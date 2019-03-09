Type=Class
Version=6.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class module
'Version: 1.24
Sub Class_Globals
	Public DockingAreaColor As Int
	Public StickyAreaColor As Int
	Public PinnedWindowMsg As String
	Public MinimumWidthAfterResize As Int
	Public MinimumHeightAfterResize As Int
	Public MaximumWidthAfterResize As Int
	Public MaximumHeightAfterResize As Int
	Public MinimumCoveredSurfaceForDocking As Int
	Public StillVisible As Int
	Public TouchSlop As Int

	Private Window As Panel
	Private wParent As Panel
	Private wActionBar As ClsActionBar
	Private wTitleBar As Panel
	Private wContent As Panel
	Private wFrame As Panel
	Private wModule As Object

	Private btnPin As View
	Private btnMaximize As View
	Private btnClose As View
	Private btnResize As ImageView
	Private wResizeBtnSize As Int
	Private OnPinWinSub, OnMaximizeWinSub, OnCloseWinSub As String
	Private wPinDrawable, wMaximizeDrawable, wCloseDrawable, wResizeDrawable As Object
	Private wPinned, wMaximized As Boolean
	Private wSavedLayout As Rect
	Private wHideOnlyWhenClose As Boolean

	Private wStartX, wStartY As Int
	Private wMoveInProgress, wResizeMode As Boolean
	Private edtInputType, edtSelectionStart As Int
	Private OnMoveWinSub, OnResizeWinSub As String

	Private DockingAreas As List
	Private DockingPanel As Panel
	Private wDocked As Boolean
	Private OnEnterDockAreaWinSub, OnDockWinSub, OnUndockWinSub As String
	Private StickyAreas As Map
	Private StickyPanel(4) As Panel
	Private wStickyEdgeEnabled As Boolean
	Private OnStickWinSub As String
	Private Anim As Animation
	Private AfterAnim As typAfterAnim
	Type typAfterAnim(WinLeft As Int, WinTop As Int, IsDocking As Boolean, _
	                  SubName As String, DARect As Rect, SEdge As Int)
End Sub

'Initializes the floating window
'Parent = activity or panel holding the window
'Module = Me
Public Sub Initialize(Parent As Panel, Left As Int, Top As Int, Width As Int, Height As Int, Module As Object)
	wParent = Parent
	If Not(wParent.IsInitialized) Then
		Log("'Parent' must be the current activity or an initialized panel")
		Return
	End If
	Window.Initialize("")
	wParent.AddView(Window, Left, Top, Width, Height)

	wActionBar.Initialize(Window, True, True, 40dip, Me)
	wActionBar.Title.Left = 10dip
	wActionBar.Title.TextSize = 16
	wTitleBar = wActionBar.AsPanel
	wPinDrawable = wActionBar.LoadDrawable("ic_menu_goto")
	wMaximizeDrawable = wActionBar.LoadDrawable("btn_zoom_page_normal")
	wCloseDrawable = wActionBar.LoadDrawable("btn_close_normal")
	wResizeDrawable = wActionBar.LoadDrawable("ic_btn_square_browser_zoom_page_overview_normal")
	SetOnTouchListener(wTitleBar)

	wContent.Initialize("")
	wContent.Color = Colors.White
	Window.AddView(wContent, 0, wTitleBar.Height, -1, Height - wTitleBar.Height)
	SetOnTouchListener(wContent)

	wFrame.Initialize("")
	wFrame.Color = Colors.Transparent
	Window.AddView(wFrame, 0, 0, Width, Height)
	SetBorder(Colors.Black, 1dip)

	DockingAreas.Initialize
	StickyAreas.Initialize
	DockingAreaColor = Colors.ARGB(128, 128, 128, 128)
	StickyAreaColor = Colors.ARGB(128, 128, 128, 128)
	wDocked = False
	MinimumCoveredSurfaceForDocking = 0 'Not used by default
	wStickyEdgeEnabled = False

	Dim r As Reflector
	r.Target = r.RunStaticMethod("android.view.ViewConfiguration", "get", Array As Object(r.GetContext), Array As String("android.content.Context"))
	TouchSlop = r.RunMethod("getScaledTouchSlop")

	PinnedWindowMsg = "This window is pinned. It cannot be moved or resized."
	wMoveInProgress = False
	wResizeMode = False
	wResizeBtnSize = 30dip
	MinimumWidthAfterResize = 40dip
	MinimumHeightAfterResize = 40dip + wResizeBtnSize
	MaximumWidthAfterResize = wParent.Width
	MaximumHeightAfterResize = wParent.Height
	StillVisible = 100dip
	wModule = Module
End Sub

#Region Title bar
'Shows/Hides the title bar
Public Sub EnableTitleBar(Enabled As Boolean)
	If wTitleBar.Visible <> Enabled Then
		wTitleBar.Visible = Enabled
		If wTitleBar.Visible Then
			wContent.Top = wTitleBar.Height
		Else
			wContent.Top = 0
		End If
		wContent.Height = getHeight - wContent.Top
		If btnResize.IsInitialized Then btnResize.Top = wContent.Height - wResizeBtnSize
	End If
End Sub

'Changes the title background
'Background = a valid drawable
Public Sub SetTitleBackground(Background As Object)
	wActionBar.SetBackground(Background)
End Sub

'Changes the window title text
Public Sub SetTitleText(Text As String)
	wActionBar.Title.Text = Text
End Sub

'Changes the title text color
Public Sub SetTitleTextColor(Color As Int)
	wActionBar.Title.TextColor = Color
End Sub

'Changes the title text size
Public Sub SetTitleTextSize(Size As Int)
	wActionBar.Title.TextSize = Size
End Sub
#End Region

#Region Buttons
'Adds a custom button in the title bar
'Icon = a valid bitmap or drawable
'Position = position in the title bar, starting from the right (1 = rightmost position)
'OnClickSub = name of the sub to call in your module when the button is pressed
'OnLongClickSub = name of the sub to call in your module after a long click
'Returns a pointer on the new button
Public Sub AddCustomButton(Icon As Object, Position As Int, OnClickSub As String, OnLongClickSub As String) As View
	Dim MyBtn As View, Action As typAction
	MyBtn = wActionBar.AddButton(Icon, "", 5, -Position, "CustomButton_Click", "CustomButton_LongClick")
	Action = MyBtn.Tag
	Action.Tag = OnClickSub & "|" & OnLongClickSub
	SetOnTouchListener(MyBtn)
	Return MyBtn
End Sub

Private Sub CustomButton_Click(ActionBar As ClsActionBar, Btn As View)
	' Redirects the Click event
	Dim Action As typAction, ClickSub As String
	Action = Btn.Tag
	ClickSub = Action.Tag
	ClickSub = ClickSub.SubString2(0, ClickSub.IndexOf("|"))
	If SubExists(wModule, ClickSub) Then CallSub3(wModule, ClickSub, Me, Btn)
End Sub

Private Sub CustomButton_LongClick(ActionBar As ClsActionBar, Btn As View)
	' Redirects the LongClick event
	Dim Action As typAction, LongClickSub As String
	Action = Btn.Tag
	LongClickSub = Action.Tag
	LongClickSub = LongClickSub.SubString(LongClickSub.IndexOf("|") + 1)
	If SubExists(wModule, LongClickSub) Then CallSub3(wModule, LongClickSub, Me, Btn)
End Sub

Private Sub UpdateStateDrawables(Selected As Boolean, Btn As View)
	Dim sd As StateListDrawable
	sd.Initialize
	If Selected Then
		sd.AddState(sd.State_Pressed, wActionBar.LoadDrawable("list_selector_background_pressed"))
		sd.AddCatchAllState(wActionBar.LoadDrawable("list_selector_background_focus"))
	Else
		Btn.Color = Colors.Transparent
		sd.AddState(sd.State_Pressed, wActionBar.LoadDrawable("list_selector_background_pressed"))
		sd.AddState(sd.State_Selected, wActionBar.LoadDrawable("list_selector_background_focus"))
		sd.AddCatchAllState(Btn.Background)
	End If
	Btn.Background = sd
End Sub

'Shows/Hides the pin button in the title bar
'OnPinSub = name of the sub to call in your module after the window is pinned
Public Sub EnablePinButton(Enabled As Boolean, OnPinSub As String)
	If Enabled <> btnPin.IsInitialized Then
		If Enabled Then
			btnPin = wActionBar.AddButton(wPinDrawable, "", 5, -wActionBar.GetRightCount-1, "btnPin_Click", "")
			SetOnTouchListener(btnPin)
		Else
			wActionBar.RemoveButton(btnPin)
			btnPin = Null
		End If
	End If
	OnPinWinSub = OnPinSub
End Sub

'Changes the pin button icon
'Icon = a valid bitmap or drawable
Public Sub ChangePinIcon(NewIcon As Object)
	If NewIcon = Null Then Return
	If NewIcon Is Bitmap Then
		Dim bd As BitmapDrawable
		bd.Initialize(NewIcon)
		wPinDrawable = bd
	Else
		wPinDrawable = NewIcon
	End If
	If btnPin.IsInitialized Then wActionBar.ReplaceIcon(btnPin, wPinDrawable)
End Sub

Private Sub btnPin_Click(ActionBar As ClsActionBar, Btn As View)
	'Pins the window on its parent (cannot move)
	wPinned = Not(wPinned)

	'Update the state drawables
	UpdateStateDrawables(wPinned, Btn)
	If SubExists(wModule, OnPinWinSub) Then CallSub2(wModule, OnPinWinSub, Me)
End Sub

'Is the window pinned ?
Public Sub IsPinned As Boolean
	Return wPinned
End Sub

'Shows/Hides the maximize/restore button in the title bar
'OnMaximizeSub = name of the sub to call in your module after the window is maximized/restored
Public Sub EnableMaximizeButton(Enabled As Boolean, OnMaximizeSub As String)
	If Enabled <> btnMaximize.IsInitialized Then
		If Enabled Then
			btnMaximize = wActionBar.AddButton(wMaximizeDrawable, "", 5, -wActionBar.GetRightCount-1, "btnMaximize_Click", "")
			SetOnTouchListener(btnMaximize)
		Else
			wActionBar.RemoveButton(btnMaximize)
			btnMaximize = Null
		End If
	End If
	OnMaximizeWinSub = OnMaximizeSub
End Sub

'Changes the maximize button icon
'Icon = a valid bitmap or drawable
Public Sub ChangeMaximizeIcon(NewIcon As Object)
	If NewIcon = Null Then Return
	If NewIcon Is Bitmap Then
		Dim bd As BitmapDrawable
		bd.Initialize(NewIcon)
		wMaximizeDrawable = bd
	Else
		wMaximizeDrawable = NewIcon
	End If
	If btnMaximize.IsInitialized Then wActionBar.ReplaceIcon(btnMaximize, wMaximizeDrawable)
End Sub

'Enlarges the window to fill its parent (MaxSize=True) or returns to its previous position and size (MaxSize=False)
Public Sub Maximize(MaxSize As Boolean)
	If wPinned Then
		ToastMessageShow(PinnedWindowMsg, False)
		Return
	End If
	If MaxSize AND Not(wMaximized) Then
		wSavedLayout.Initialize(Window.Left, Window.Top, getWidth, getHeight)
		MoveWin(0, 0, False)
		ResizeWin(wParent.Width, wParent.Height, 0, 0, wParent.Width, wParent.Height)
		BringOnTop
		wMaximized = True
		If btnMaximize.IsInitialized Then UpdateStateDrawables(wMaximized, btnMaximize)
		If SubExists(wModule, OnMaximizeWinSub) Then CallSub2(wModule, OnMaximizeWinSub, Me)
	Else If Not(MaxSize) AND wMaximized Then
		Resize(wSavedLayout.Right, wSavedLayout.Bottom)
		MoveWin(wSavedLayout.Left, wSavedLayout.Top, True)
		wSavedLayout = Null
		wMaximized = False
		If btnMaximize.IsInitialized Then UpdateStateDrawables(wMaximized, btnMaximize)
		If SubExists(wModule, OnMaximizeWinSub) Then CallSub2(wModule, OnMaximizeWinSub, Me)
	End If
End Sub

Private Sub btnMaximize_Click(ActionBar As ClsActionBar, Btn As View)
	Maximize(Not(wMaximized))
End Sub

'Is the window maximized ?
Public Sub IsMaximized As Boolean
	Return wMaximized
End Sub

'Shows/Hides the close button in the title bar
'HideOnly = if True, closing the window just hides it
'OnCloseSub = name of the sub to call in your module before the window is closed
Public Sub EnableCloseButton(Enabled As Boolean, HideOnly As Boolean, OnCloseSub As String)
	If Enabled <> btnClose.IsInitialized Then
		If Enabled Then
			btnClose = wActionBar.AddButton(wCloseDrawable, "", 5, -1, "btnClose_Click", "")
			SetOnTouchListener(btnClose)
		Else
			wActionBar.RemoveButton(btnClose)
			btnClose = Null
		End If
	End If
	wHideOnlyWhenClose = HideOnly
	OnCloseWinSub = OnCloseSub
End Sub

'Changes the close button icon
'Icon = a valid bitmap or drawable
Public Sub ChangeCloseIcon(NewIcon As Object)
	If NewIcon = Null Then Return
	If NewIcon Is Bitmap Then
		Dim bd As BitmapDrawable
		bd.Initialize(NewIcon)
		wCloseDrawable = bd
	Else
		wCloseDrawable = NewIcon
	End If
	If btnClose.IsInitialized Then wActionBar.ReplaceIcon(btnClose, wCloseDrawable)
End Sub

Private Sub btnClose_Click(ActionBar As ClsActionBar, Btn As View)
	If SubExists(wModule, OnCloseWinSub) Then CallSub2(wModule, OnCloseWinSub, Me)
	If wHideOnlyWhenClose Then
		Hide
	Else
		Close
	End If
End Sub

'Shows/Hides the resize button in the bottom right corner
Public Sub EnableResizeButton(Enabled As Boolean)
	If Enabled <> btnResize.IsInitialized Then
		If Enabled Then
			btnResize.Initialize("")
			btnResize.Background = wResizeDrawable
			btnResize.Gravity = Gravity.FILL
			wContent.AddView(btnResize, getWidth - wResizeBtnSize, getContentHeight - wResizeBtnSize, wResizeBtnSize, wResizeBtnSize)
			SetOnTouchListener(btnResize)
		Else
			btnResize.RemoveView
			btnResize = Null
		End If
	End If
End Sub

'Changes the resize button icon
'Icon = a valid bitmap or drawable
Public Sub ChangeResizeIcon(NewIcon As Object)
	If NewIcon = Null Then Return
	If NewIcon Is Bitmap Then
		Dim bd As BitmapDrawable
		bd.Initialize(NewIcon)
		wResizeDrawable = bd
	Else
		wResizeDrawable = NewIcon
	End If
	btnResize.Background = wResizeDrawable
End Sub
#End Region

'Draws a colored frame around the window
Public Sub SetBorder(Color As Int, Width As Int)
	Dim C As Canvas, wRect As Rect
	C.Initialize(wFrame)
	C.DrawColor(Colors.Transparent)
	wRect.Initialize(0 + (Width/2), 0 + (Width/2), getWidth - (Width/2), getHeight - (Width/2))
	C.DrawRect(wRect, Color, False, Width)
End Sub

'Changes the main content background
'Background = a valid drawable
Public Sub SetBackground(Background As Object)
	wContent.Background = Background
End Sub

'Adds a view to the window
'DelegateTouchEvent: if True, the Touch event is handled by the class and allows to move the window.
'Some views like ListView or ScrollView need DelegateTouchEvent=False if their content is not fully displayed (that allows to scroll their content but prevents from moving the window by moving the view).
Public Sub AddView(MyView As View, Left As Int, Top As Int, Width As Int, Height As Int, DelegateTouchEvent As Boolean)
	wContent.AddView(MyView, Left, Top, Width, Height)
	If DelegateTouchEvent Then SetOnTouchListener(MyView)
	If btnResize.IsInitialized Then btnResize.BringToFront
End Sub

#Region Left, Top, Width, Height
'Gets the window left value
Public Sub getLeft As Int
	Return Window.Left
End Sub

'Gets the window top value
Public Sub getTop As Int
	Return Window.Top
End Sub

'Gets the window width
Public Sub getWidth As Int
	If Window.Width < 0 Then
		Dim r As Reflector, Largeur As Int
		r.Target = Window
		Largeur = r.RunMethod("getWidth")
		If Largeur = 0 Then
			DoEvents
			Largeur = r.RunMethod("getWidth")
		End If
		Return Largeur		
	Else
		Return Window.Width
	End If
End Sub

'Gets the window height
'If you want only the height of the content panel, call getContentHeight
Public Sub getHeight As Int
	If Window.Height < 0 Then
		Dim r As Reflector, Hauteur As Int
		r.Target = Window
		Hauteur = r.RunMethod("getHeight")
		If Hauteur = 0 Then
			DoEvents
			Hauteur = r.RunMethod("getHeight")
		End If
		Return Hauteur		
	Else
		Return Window.Height
	End If
End Sub

'Gets the content panel height
'ContentHeight = WindowHeight - ActionBarHeight
Public Sub getContentHeight As Int
	Return getHeight - wTitleBar.Height
End Sub
#End Region

'Brings the window to the front
Public Sub BringOnTop()
	' Successive calls to BringToFront create an issue with focus,
	' so we only call BringToFront when needed
	Dim OnTop As Boolean
	If wParent Is Activity Then
		Dim act As Activity
		act = wParent
		OnTop = (act.GetView(act.NumberOfViews - 1) = Window)
	Else
		Dim pnl As Panel
		pnl = wParent
		OnTop = (pnl.GetView(pnl.NumberOfViews - 1) = Window)
	End If
	If Not(OnTop) Then Window.BringToFront
End Sub

Private Sub SetOnTouchListener(MyView As View)
	Dim r As Reflector
	r.Target = MyView
	r.SetOnTouchListener("Content_Touch")
End Sub

Private Sub AllowInputInEditText(MyET As Object, Enabled As Object)
	Dim edt As EditText: edt = MyET
	If Enabled = True Then
		edt.InputType = edtInputType
		edt.SelectionStart = edtSelectionStart
	Else
		edtInputType = edt.InputType
		edtSelectionStart = edt.SelectionStart
		edt.InputType = 0
		edt.SelectionStart = edtSelectionStart
	End If
End Sub

Private Sub Content_Touch(ViewTag As Object, Action As Int, X As Float, Y As Float, MotionEvent As Object) As Boolean
	Dim SenderIsWindow As Boolean
	SenderIsWindow = (Sender = Window OR Sender = wTitleBar OR _
	                  Sender = wContent OR Sender = wFrame)
	Select Action
		Case 0 ' DOWN
			' We bring the window to the front
			BringOnTop

			' We undock the window
			If wDocked Then
				wDocked = False
				If SubExists(wModule, OnUndockWinSub) Then
					Dim OldX, OldY As Int
					OldX = getLeft
					OldY = getTop
					CallSub2(wModule, OnUndockWinSub, Me)
					' We adjust the touch coordinates if the window has been moved in OnUndockWinSub
					X = X + OldX - getLeft
					Y = Y + OldY - getTop
				End If
			End If
			CheckSpecialAreas(False)

			' We memorize the starting position
			wStartX = X
			wStartY = Y
			wMoveInProgress = False

			' We turn the resize mode on if the user pressed the resize button
			If btnResize.IsInitialized Then
				If Sender = btnResize Then
					If wPinned Then
						ToastMessageShow(PinnedWindowMsg, False)
					Else
						wResizeMode = True
					End If
				End If
			End If

		Case 1 ' UP
			' We perform all actions related to the docking and sticky areas
			CheckSpecialAreas(True)
			If wMoveInProgress Then
				wMoveInProgress = False
				If Sender Is ListView Then Return True
				If Sender Is EditText Then AllowInputInEditText(Sender, True)
			End If
			wResizeMode = False

		Case 2 ' MOVE
			If Not(wMaximized OR wPinned) Then ' We don't move/resize a maximized or pinned window
				' We block the interception of touch events
				Dim r As Reflector
				r.Target = Sender
				If Sender Is ListView OR Sender Is ScrollView Then
					r.RunMethod2("requestDisallowInterceptTouchEvent", True, "java.lang.boolean")
				End If

				' Is the move big enough to be considered as a move ?
				Dim MoveQty As Int
				MoveQty = Sqrt(Power(Abs(X - wStartX), 2) + Power(Abs(Y - wStartY), 2))
				If wMoveInProgress OR MoveQty > TouchSlop Then
					' We move/resize the window
					If wResizeMode Then
						Resize(Window.Width + X - wStartX, Window.Height + Y - wStartY)
						wStartX = X
						wStartY = Y
					Else
						MoveWin(Window.Left + X - wStartX, Window.Top + Y - wStartY, True)
					End If
					CheckSpecialAreas(False)
					If Not(SenderIsWindow) Then
						' We cancel the pressed and selected states
		   			r.RunMethod2("setPressed", "False", "java.lang.boolean")
		   			r.RunMethod2("setSelected", "False", "java.lang.boolean")
					End If
					If Not(wMoveInProgress) Then
						wMoveInProgress = True
						If r.Target Is EditText Then
					 		' No input is allowed in an EditText while moving
							' This also prevents the soft keyboard from appearing
							AllowInputInEditText(r.Target, False)
						End If
					End If
				End If

			End If
	End Select
	Return SenderIsWindow
End Sub

#Region Move & Resize
Private Sub ResizeWin(NewWidth As Int, NewHeight As Int, MinWidth As Int, MinHeight As Int, _
                                                         MaxWidth As Int, MaxHeight As Int)
	If NewWidth <> -1 Then
		NewWidth = Min(Max(NewWidth, MinWidth), MaxWidth)
		Window.Width = NewWidth
		wTitleBar.Width = NewWidth
		wActionBar.Invalidate
		wContent.Width = NewWidth
		wFrame.Width = NewWidth
		If btnResize.IsInitialized Then btnResize.Left = NewWidth - wResizeBtnSize
	End If
	If NewHeight <> -1 Then
		NewHeight = Min(Max(NewHeight, MinHeight), MaxHeight)
		Window.Height = NewHeight
		If wTitleBar.Visible Then
			wContent.Height = NewHeight - wTitleBar.Height
		Else
			wContent.Height = NewHeight
		End If
		wFrame.Height = NewHeight
		If btnResize.IsInitialized Then btnResize.Top = wContent.Height - wResizeBtnSize
	End If
	If SubExists(wModule, OnResizeWinSub) Then CallSub2(wModule, OnResizeWinSub, Me)
End Sub

'Resizes the window
'If a dimension is set to -1, it is left unchanged.
Public Sub Resize(NewWidth As Int, NewHeight As Int)
	If wPinned Then
		Log(PinnedWindowMsg)
		Return
	End If
	ResizeWin(NewWidth, NewHeight, MinimumWidthAfterResize, MinimumHeightAfterResize, _
	                               MaximumWidthAfterResize, MaximumHeightAfterResize)
End Sub

'Adds a listener for events onResize (fired after a resize)
'Your listener must be declared like this: myListener(Window As ClsFloatingWindow)
Public Sub SetOnResizeListener(SubName As String)
	OnResizeWinSub = SubName
End Sub

Private Sub CalcNewLeft(NewLeft As Int) As Int
	Return Max(StillVisible - getWidth, Min(NewLeft, wParent.Width - StillVisible))
End Sub
Private Sub CalcNewTop(NewTop As Int) As Int
	Return Max(StillVisible - getHeight, Min(NewTop, wParent.Height - StillVisible))
End Sub
Private Sub MoveWin(NewLeft As Int, NewTop As Int, CheckStillVisible As Boolean)
	If CheckStillVisible Then
		If NewLeft <> -1 Then
			Window.Left = CalcNewLeft(NewLeft)
		End If
		If NewTop <> -1 Then
			Window.Top = CalcNewTop(NewTop)
		End If
	Else
		If NewLeft <> -1 Then Window.Left = NewLeft
		If NewTop <> -1 Then Window.Top = NewTop
	End If
	If SubExists(wModule, OnMoveWinSub) Then CallSub2(wModule, OnMoveWinSub, Me)
End Sub

'Moves the window
'If a position is set to -1, it is left unchanged.
'IgnoreSpecialAreas = if True, docking areas and sticky edges are ignored.
Public Sub Move(NewLeft As Int, NewTop As Int, IgnoreSpecialAreas As Boolean)
	If wPinned Then
		Log(PinnedWindowMsg)
		Return
	End If
	If NewLeft <> getLeft AND NewLeft <> -1 AND NewTop <> getTop AND NewTop <> -1 Then
		' The window leaves the docking area
		wDocked = False
	End If
	MoveWin(NewLeft, NewTop, True)
	If Not(IgnoreSpecialAreas) Then CheckSpecialAreas(True)
End Sub

'Adds a listener for events onMove (fired after a move)
'Your listener must be declared like this: myListener(Window As ClsFloatingWindow)
Public Sub SetOnMoveListener(SubName As String)
	OnMoveWinSub = SubName
End Sub
#End Region

'Shows a hidden window
Public Sub Show
	Window.Visible = True
End Sub

'Hides a window
Public Sub Hide
	Window.Visible = False
End Sub

'Gets the window panel
Public Sub AsPanel As Panel
	Return Window
End Sub

'Clears the content and closes the window
Public Sub Close
	Dim v As View
	For i = wContent.NumberOfViews - 1 To 0 Step -1
		v = wContent.GetView(i)
		v.RemoveView
	Next
	For i = Window.NumberOfViews - 1 To 0 Step -1
		v = Window.GetView(i)
		v.RemoveView
	Next
	Window.RemoveView
End Sub

#Region Dock & Stick
Private Sub UpdateAfterAnimPosition(Left As Int, Top As Int)
	If Anim.IsInitialized Then
		If AfterAnim.WinLeft = -1 AND Left <> -1 Then AfterAnim.WinLeft = Left
		If AfterAnim.WinTop = -1 AND Top <> -1 Then AfterAnim.WinTop = Top
	Else
		AfterAnim.WinLeft = Left
		AfterAnim.WinTop = Top
	End If
End Sub

Private Sub CalcSurface(rectDock As Rect) As Long
	'Computes the covered area
	Dim SurfaceW As Int
	Dim WinRight As Int = Window.Left + Window.Width
	If Window.Left >= rectDock.Left Then
		If WinRight <= rectDock.Right Then
			SurfaceW = Window.Width
		Else
			SurfaceW = rectDock.Right - Window.Left
		End If
	Else
		If WinRight >= rectDock.Right Then
			SurfaceW = rectDock.Right - rectDock.Left
		Else
			SurfaceW = WinRight - rectDock.Left
		End If
	End If

	Dim SurfaceH As Int
	Dim WinBottom As Int = Window.Top + Window.Height
	If Window.Top >= rectDock.Top Then
		If WinBottom <= rectDock.Bottom Then
			SurfaceH = Window.Height
		Else
			SurfaceH = rectDock.Bottom - Window.Top
		End If
	Else
		If WinBottom >= rectDock.Bottom Then
			SurfaceH = rectDock.Bottom - rectDock.Top
		Else
			SurfaceH = WinBottom - rectDock.Top
		End If
	End If

	Return SurfaceW * SurfaceH
End Sub

Private Sub CheckSpecialAreas(PerformAction As Boolean)
	' Initialisations
	AfterAnim.Initialize
	AfterAnim.WinLeft = -1
	AfterAnim.WinTop = -1

	' Docking areas
	Dim wRect As Rect
	If DockingPanel.IsInitialized Then
		DockingPanel.Visible = False
		If Not(wMaximized) Then
			Dim Surface, BiggestSurface As Long, SelectedArea As Int
			SelectedArea = -1
			For i = 0 To DockingAreas.Size - 1
				wRect = DockingAreas.Get(i)
				If (Window.Left <= wRect.Right AND Window.Left + getWidth >= wRect.Left) AND _
		   		(Window.Top <= wRect.Bottom AND Window.Top + getHeight >= wRect.Top) Then
					' The window is in a docking area
					' We calculate the covered area
					Surface = CalcSurface(wRect)
					If Surface > BiggestSurface Then
						' We select the docking area with the most covered surface
						SelectedArea = i
						BiggestSurface = Surface
					End If
				End If
			Next
			If SelectedArea <> -1 Then
				wRect = DockingAreas.Get(SelectedArea)
				Dim ActionIsConfirmed As Boolean
				If PerformAction AND MinimumCoveredSurfaceForDocking > 0 Then
					Dim CoveredSurface As Float
					CoveredSurface = (BiggestSurface / ((wRect.Right - wRect.Left) * (wRect.Bottom - wRect.Top))) * 100
					ActionIsConfirmed = (CoveredSurface >= MinimumCoveredSurfaceForDocking)
				Else
					ActionIsConfirmed = True
				End If
				If PerformAction AND ActionIsConfirmed Then
					UpdateAfterAnimPosition(wRect.Left, wRect.Top)
					Anim.InitializeTranslate("Anim", 0, 0, wRect.Left - Window.Left, wRect.Top - Window.Top)
					Anim.Duration = 100
					AfterAnim.SubName = OnDockWinSub
					AfterAnim.IsDocking = True
					AfterAnim.DARect = wRect
					If wStickyEdgeEnabled Then HideStickyPanels
					Anim.Start(Window)
					Return ' We bypass the sticky edge check
				Else
					DockingPanel.SetLayout(wRect.Left, wRect.Top, wRect.Right - wRect.Left, wRect.Bottom - wRect.Top)
					DockingPanel.Color = DockingAreaColor
					DockingPanel.Visible = (DockingAreaColor <> Colors.Transparent)
					If SubExists(wModule, OnEnterDockAreaWinSub) Then CallSub3(wModule, OnEnterDockAreaWinSub, Me, wRect)
				End If
			End If
		End If
	End If

	' Sticky areas
	If wStickyEdgeEnabled Then
		HideStickyPanels
		If Not(wMaximized) Then
			Dim Edge As Int
			For i = 0 To StickyAreas.Size - 1
				Edge = StickyAreas.GetKeyAt(i)
				Select Edge
					Case 0 'LEFT
						wRect.Initialize(0, 0, StickyAreas.GetValueAt(i), wParent.Height)
					Case 1 'TOP
						wRect.Initialize(0, 0, wParent.Width, StickyAreas.GetValueAt(i))
					Case 2 'RIGHT
						wRect.Initialize(wParent.Width - StickyAreas.GetValueAt(i), 0, wParent.Width, wParent.Height)
					Case 3 'BOTTOM
						wRect.Initialize(0, wParent.Height - StickyAreas.GetValueAt(i), wParent.Width, wParent.Height)
				End Select
				If (Window.Left <= wRect.Right AND Window.Left + getWidth >= wRect.Left) AND _
				   (Window.Top <= wRect.Bottom AND Window.Top + getHeight >= wRect.Top) Then
					' The window is in the sticky area
					If PerformAction Then
						Select Edge
							Case 0 'LEFT
								UpdateAfterAnimPosition(CalcNewLeft(0), -1)
							Case 1 'TOP
								UpdateAfterAnimPosition(-1, CalcNewTop(0))
							Case 2 'RIGHT
								UpdateAfterAnimPosition(CalcNewLeft(wParent.Width - getWidth), -1)
							Case 3 'BOTTOM
								UpdateAfterAnimPosition(-1, CalcNewTop(wParent.Height - getHeight))
						End Select
						Dim DestX, DestY As Int
						If AfterAnim.WinLeft <> -1 Then DestX = AfterAnim.WinLeft - Window.Left
						If AfterAnim.WinTop <> -1 Then DestY = AfterAnim.WinTop - Window.Top
						If DestX <> 0 OR DestY <> 0 Then
							Anim.InitializeTranslate("Anim", 0, 0, DestX, DestY)
							Anim.Duration = 200
							AfterAnim.SubName = OnStickWinSub
							AfterAnim.IsDocking = False
							AfterAnim.SEdge = Edge
							Anim.Start(Window)
						End If
					Else If Not(IsDocked OR (Anim.IsInitialized AND AfterAnim.IsDocking)) Then
						StickyPanel(Edge).SetLayout(wRect.Left, wRect.Top, wRect.Right - wRect.Left, wRect.Bottom - wRect.Top)
						StickyPanel(Edge).Color = StickyAreaColor
						StickyPanel(Edge).Visible = (StickyAreaColor <> Colors.Transparent)
					End If
				End If
			Next
		End If
	End If
End Sub

Private Sub Anim_AnimationEnd
	'Sets the final position and destroys the animation
	If AfterAnim.IsDocking Then
		wDocked = True
		MoveWin(AfterAnim.WinLeft, AfterAnim.WinTop, False)
		ResizeWin(AfterAnim.DARect.Right - AfterAnim.DARect.Left, AfterAnim.DARect.Bottom - AfterAnim.DARect.Top, 0, 0, _
		          AfterAnim.DARect.Right - AfterAnim.DARect.Left, AfterAnim.DARect.Bottom - AfterAnim.DARect.Top)
		If SubExists(wModule, AfterAnim.SubName) Then CallSub3(wModule, AfterAnim.SubName, Me, AfterAnim.DARect)
	Else
		MoveWin(AfterAnim.WinLeft, AfterAnim.WinTop, True)
		If SubExists(wModule, AfterAnim.SubName) Then CallSub3(wModule, AfterAnim.SubName, Me, AfterAnim.SEdge)
	End If
	Anim = Null
End Sub

'Adds a docking area
'If a window enters a docking area, the area becomes visible.
'If the window is still in the area when the move ends, it is moved and resized to fit the area.
Public Sub AddDockingArea(DockRect As Rect)
	If Not(DockingPanel.IsInitialized) Then
		DockingPanel.Initialize("")
		wParent.AddView(DockingPanel, 0, 0, 0, 0)
		DockingPanel.Visible = False
	End If
	DockingAreas.Add(DockRect)
End Sub

'Removes all docking areas
Public Sub RemoveDockingAreas
	If DockingPanel.IsInitialized Then
		DockingPanel.RemoveView
		DockingPanel = Null
	End If
	DockingAreas.Clear
End Sub

'Adds a listener for the events OnEnterDockArea (fired when entering a docking area)
'Your listener must be declared like this: myListener(Window As ClsFloatingWindow, DockRect As Rect)
Public Sub SetOnEnterDockAreaListener(SubName As String)
	OnEnterDockAreaWinSub = SubName
End Sub

'Adds a listener for the events OnDock (fired after docking)
'Your listener must be declared like this: myListener(Window As ClsFloatingWindow, DockRect As Rect)
Public Sub SetOnDockListener(SubName As String)
	OnDockWinSub = SubName
End Sub

'Adds a listener for the events OnUndock (fired after leaving a docking area)
'Your listener must be declared like this: myListener(Window As ClsFloatingWindow)
Public Sub SetOnUndockListener(SubName As String)
	OnUndockWinSub = SubName
End Sub

'Is the window docked ?
Public Sub IsDocked As Boolean
	Return wDocked
End Sub

'Creates a sticky area near an edge.
'If the window enters the sticky area, the area becomes visible.
'If the window is still in the area when the move ends, it is sticked against the edge.
'Edge:
'0 = Left
'1 = Top
'2 = Right
'3 = Bottom
Public Sub AddStickyEdge(Edge As Int, Size As Int)
	If Edge < 0 OR Edge > 3 Then
		Log("Invalid Edge value. Must be 0, 1, 2 or 3.")
		Return
	End If
	StickyAreas.Put(Edge, Size)
	If Not(StickyPanel(Edge).IsInitialized) Then
		StickyPanel(Edge).Initialize("")
		wParent.AddView(StickyPanel(Edge), 0, 0, 0, 0)
		StickyPanel(Edge).Visible = False
		wStickyEdgeEnabled = True
	End If
End Sub

' Hides all sticky panels
Private Sub HideStickyPanels
	For i = 0 To 3
		If StickyPanel(i).IsInitialized Then StickyPanel(i).Visible = False
	Next
End Sub

'Removes all sticky areas
Public Sub RemoveStickyEdges
	For i = 0 To 3
		If StickyPanel(i).IsInitialized Then
			StickyPanel(i).RemoveView
			StickyPanel(i) = Null
		End If
	Next
	StickyAreas.Clear
	wStickyEdgeEnabled = False
End Sub

'Adds a listener for events OnStick (fired after sticking to an edge)
'Your listener must be declared like this: myListener(Window As ClsFloatingWindow, Edge As Int)
'Edge:
'0 = Left
'1 = Top
'2 = Right
'3 = Bottom
Public Sub SetOnStickListener(SubName As String)
	OnStickWinSub = SubName
End Sub
#End Region

#Region Tag
'Gets the tag value
Public Sub getTag As Object
	Return Window.Tag
End Sub

'Sets the tag value
Public Sub SetTag(NewValue As Object)
	Window.Tag = NewValue
End Sub
#End Region
