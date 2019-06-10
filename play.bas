B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=6.8
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
'	Dim Timer1, Timer2, Timer3, Timer4 As Timer
	'	Dim Timer1, Timer2, Timer4, Timer5 As Timer
	Dim Timer1 As Timer
	Dim Timer3 As Timer
	Dim Timer5 As Timer
'	Dim Timer6 As Timer
	Dim slc_parse As SaxParser
	Dim sounds As SoundPool
	Dim bounceId1, bounceId2, bounceId3, bounceId4 As Int
	Dim awake As PhoneWakeState
	'	Dim juzer_klouzed As Boolean = False
'	Private accelerometer, magnetic As PhoneSensors
'	Private accValues(), magValues() As Float
'	Private sm As JavaObject
'	Dim ori As PhoneOrientation
'	Dim ori As PhoneSensors
'	Dim acc As PhoneAccelerometer
	Dim sensor As PhoneSensors
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Dim tWidth As Int
	Dim lWidth As Int
	Dim pozKutijaMjesta As List
	Dim pozKutija As List
'	Dim pozIgracaZaNatrag As Map
'	Dim pozIgracaZaNatrag As List
'	Dim pozIgraca As Map
	Dim brojKoraka, brojGuranja As Int = 0
	Private lblSteps As Label
	Private lblPushes As Label
'	Private lblBT As Label	' najbolje vrijeme
	Private lblCT As Label	' trenutno
	Dim razina As Int = 0
	Private lblRazina As Label
	Dim izgRazineOdIndeksaPoc As Int
	Dim izgRazineDoIndeksaKraj As Int
'	Private imgKvacica As ImageView
	Dim brJednakihPoz As Int
	Dim izgledLevela As List
	Dim wLevel, hLevel As List
	Dim imeLevela As List
'	Dim snapshot As List
'	Dim gore As Int = 1
'	Dim lijevo As Int = 2
'	Dim dole As Int = 3
'	Dim desno As Int = 4
	'
	Dim datZaParsanje As String
	Private PanelI As Panel
'	Private PanelK As Panel
	Dim sv2d As ScrollView2D
	Dim brojLevela As Int = 0
	Dim karta As Map
	Dim tempKartaZaNatrag As Map
	Dim ukupno_razina As Int = 0
	Dim snd As Boolean = True
	Private btnSound As Button
'	Private PanelMeni As Panel
	Dim rec As ScreenRecorder
	Dim recB As Boolean = False
	Dim DatZaSnimku As String
	Private btnRec As Button
	' tajmer 2
'	Dim lbl1 As Label
'	Dim count As Int = 3
	Dim slijedeci, prethodni As Boolean = False
'	Dim snapshot As Boolean	' snapshot
'	Dim snimanje As Boolean = False
'	Private pnlOpcije As Panel
'	Private btnOpc As Button
'	Dim pnl_opc_vidljiv, pnl_info_vidljiv As Boolean = False
	Dim pnl_info_vidljiv As Boolean = False
	Private pnlInfo As Panel
	Private btnInfo As Button
'	Dim sensors As PhoneSensors
'	Dim cijelkiEkran As Boolean
	Dim Azimuth As Float
	Dim Pitch As Float
	Dim Roll As Float
'	Dim ipsilon1 As Float
	'
	Dim zid1, kutija1, kutnamj1, mjzakut1, pod1, igr1, igrnamj1 As Bitmap
'	Dim sekunde As Int
'	Dim minute As Int
'	Dim x0 As Int
	Dim ref As Reflector
'	Dim stariX As Int
'	Dim stariY As Int
	Private ACTION_DOWN As Int 'ACTION_MOVE, ACTION_UP
'	Dim koordinate As Map
	Dim velicinaRetka As List
	Private ImageView1 As ImageView
	Private Label1 As Label
	Dim gif As GifDecoder
	Dim Frame As Int
	' ako je igra počela, tajmer se ne može uključiti
'	Dim igraPocela As Boolean
'	Dim norec As Boolean
'	Private btnOK As Button
'	Dim sek As Int = 0
	Dim panelGotovo As Panel
	Dim rijesenje As String
	'	dim razina_lbl as String
	Dim x3 As Int	' pomak zbog centriranja
'	Private btnNatrag As Button
	Dim velikoSlovo As Boolean
'	Dim pocPozIgrZaNatrag As String
'	Dim pocPozIgrZaNatragPlus1 As String
'	Dim pocPozIgrZaNatragPlus2 As String
	Dim btnNatrag As Button
'	Private iad As InterstitialAd
End Sub

Sub Activity_Create(FirstTime As Boolean)
'#if debug
'	iad.Initialize("iad","ca-app-pub-3940256099942544/1033173712") 'test ID
'#else
'	iad.Initialize("iad", "ca-app-pub-3462427055174223/1046533533")
'	iad.LoadAd
'#End If

	Dim ph As Phone

	ph.SetScreenOrientation(0)

	Dim mOpcije As Map
	Dim rb4 As Boolean
	mOpcije = File.ReadMap(Starter.SourceFolder, "opcije")
	rb4 = mOpcije.Get("rb4")
	Dim nivo, mjuza, mjuzaMoveObj, mjuzaZid As String
	nivo = mOpcije.Get("skin")
	mjuza = mOpcije.get("mjuza")
	mjuzaMoveObj = mOpcije.Get("mjuzaMoveObj")
	mjuzaZid = mOpcije.Get("mjuzaZid")

	Timer3.Initialize("Timer3", 1000)

	If FirstTime Then
		sounds.Initialize(4)
'		If nivo.StartsWith("1") Then
		If mjuzaZid.EqualsIgnoreCase("true") Then
			bounceId1 = sounds.Load(File.DirAssets, "zid.mp3")
'			btnSound.SetBackgroundImage(LoadBitmap(File.DirAssets, "s_on.png"))
'		Else
'			btnSound.SetBackgroundImage(LoadBitmap(File.DirAssets, "s_off.png"))
		End If
'		End If

		If nivo.StartsWith("1") Then
			bounceId2 = sounds.Load(File.DirAssets, "na_mjestu.mp3")
		Else
			bounceId2 = sounds.Load(Starter.SourceFolder & "/skins/" & nivo & "/", mjuzaMoveObj)
		End If

		If nivo.StartsWith("1") Or mOpcije.ContainsKey("mjuza") = False Then	' završni zvuk
			bounceId3 = sounds.Load(File.DirAssets, "lvl.mp3")
			bounceId4 = sounds.Load(File.DirAssets, "all_lvls.mp3")
		Else if mOpcije.ContainsKey("mjuza") Then
			bounceId3 = sounds.Load(Starter.SourceFolder & "/skins/" & nivo & "/", mjuza)
		End If
	End If

	If rb4 Then
		sensor.Initialize(sensor.TYPE_ACCELEROMETER)
		Timer3.Enabled = True
	End If

	If GetSDK >= 21 Then
		rec.Initialize("rec")
	Else
		Msgbox("Recording supported only with SDK " & GetSDK & " and Android version " & GetSDKversion & CRLF & "Recording will be disabled!", "Warning!")
'		norec = True
	End If

	Timer1.Initialize("Timer1", 100)

	Timer5.Initialize("Timer5", 0)

	slc_parse.Initialize
	izgledLevela.Initialize
	wLevel.Initialize
	hLevel.Initialize
	imeLevela.Initialize
'	snapshot.Initialize
'	pozIgracaZaNatrag.Initialize

	brojLevela = 0

'	pnl.Initialize("")
'	pnl.LoadLayout("all_finished")
'	Activity.AddView(pnl, 0, 14%y, 100%x, 100%y)
'	pnl.Visible = False

	NovaIgra
End Sub

Sub Timer1_Tick
	ProvjeriKutijeNaMjestu
End Sub

'Sub Timer2_Tick
'	If count >= 0 Then
'		lbl1.Text = count
'		count = count - 1
'	Else
'		lbl1.Text = ""
'		Timer2.Enabled = False
'	End If
'End Sub

Sub Timer3_Tick
	Log("pitch: " & NumberFormat(Pitch, 1, 0))
	Log("roll: " & NumberFormat(Roll, 1, 0))
	Log("azimuth: " & NumberFormat(Azimuth, 1, 0))
	Dim p As Int = NumberFormat(Pitch, 1, 0)
	Dim r As Int = NumberFormat(Roll, 1, 0)
	Dim a As Int = NumberFormat(Azimuth, 1, 0)
	If p > 2 And a >= 0 Then	' desno
		PomakniUSmjeru("desno")
	else if p < -2 And a > 0 Then	' lijevo
		PomakniUSmjeru("lijevo")
	else if r > 0 And a > 3 Then	' gore
		PomakniUSmjeru("dole")
	else if r > 0 And a < -3 Then	' dole
		PomakniUSmjeru("gore")
	End If
End Sub

Sub Timer5_Tick
	Timer5.Enabled = False
	Frame = Frame + 1
	If Frame >= gif.FrameCount Then
		Frame = 0
	End If
	Timer5.Interval = gif.Delay(Frame)
	ImageView1.Bitmap = gif.Frame(Frame)
	Timer5.Enabled = True
End Sub

Sub Activity_Resume
	Dim ph As Phone

	ph.SetScreenOrientation(0)

	awake.KeepAlive(True)
	Dim mOpcije As Map
	Dim rb4 As Boolean
	mOpcije = File.ReadMap(Starter.SourceFolder, "opcije")
	rb4 = mOpcije.Get("rb4")
	If rb4 Then
		sensor.StartListening("sensor")
	End If
End Sub

Sub Activity_Pause (UserClosed As Boolean)
	awake.ReleaseKeepAlive
	Timer1.Enabled = False
	Timer3.Enabled = False
	Timer5.Enabled = False
	sensor.StopListening
End Sub

Sub NovaIgra
'	If File.Exists(Starter.SourceFolder, odabir.ime_datoteke_za_info  & "_" & razina & ".snapshot") Then
'		Dim res As Int = Msgbox2("We have snapshot for this level." & CRLF & "Do you want to continue from last time?", "Info", "OK", "Cancel", "", LoadBitmap(File.DirAssets, "upitnik.png"))
'		If res = DialogResponse.POSITIVE Then
'			UcitajSnapshotInfo
'			UcitajSnapshot
'		End If
'	Else
	If File.Exists(Starter.SourceFolder, Main.ime_datoteke_za_info & ".info") Then
		Log("play -> NovaIgra -> UcitajInfo -> učitava se info o tome koliko je nivoa odigrano za paket nivoa!")
		UcitajInfo
		If razina = ukupno_razina Then
			Dim res As Int = Msgbox2("You already played all levels from this package." & CRLF & "If you want to play again delete stats in the levels package list!", "Info", "OK", "", "", Null)
'			Wait For Msgbox_Result (res As Int)
			If res = DialogResponse.POSITIVE Then Activity.Finish
		Else
			Dim curs As Cursor
			Dim datZaParsanjeR As String
			Dim q As String = "SELECT datoteka FROM " & Starter.DBFileName & " WHERE imeDat = '" & datZaParsanje & "'"
			curs = Starter.upit.ExecQuery(q)
			If curs.RowCount > 0 Then
				For i = 0 To curs.RowCount-1
					curs.Position = i
					datZaParsanjeR = curs.GetString("datoteka")
				Next
			End If

			ParsajRazine(datZaParsanjeR)

			Dim od As Int = 0
			For i = 0 To razina - 1
				od = od + hLevel.Get(i)
			Next
			Dim doo As Int = 0
			For i = 0 To razina
				doo = doo + hLevel.Get(i)
			Next
			izgRazineOdIndeksaPoc = od
			izgRazineDoIndeksaKraj = doo - 1
			KreirajNivo
		End If

''''''''''	Else If File.Exists(File.DirDefaultExternal, odabir.ime_datoteke_za_info  & "_" & razina & ".snapshot") Then
''''''''''		Log("play -> NovaIgra -> Snapshot")
''''''''''		Dim res As Int = Msgbox2("We have snapshot for this level." & CRLF & "Do you want to continue from last time?", "Info", "OK", "Cancel", "", LoadBitmap(File.DirAssets, "upitnik.png"))
''''''''''		If res = DialogResponse.POSITIVE Then
''''''''''			UcitajSnapshotInfo
''''''''''			' učitaj snapshot izgled levela
''''''''''			UcitajSnapshot
''''''''''		
''''''''''		Else
''''''''''			ParsajRazine(odabir.datZaParsanjeRazina)
''''''''''			izgRazineOdIndeksaPoc = 0
''''''''''			If razina = 0 Then izgRazineDoIndeksaKraj = 0
''''''''''			izgRazineDoIndeksaKraj = izgRazineDoIndeksaKraj + hLevel.Get(razina) - 1
''''''''''		End If

'	Else If File.Exists(File.DirDefaultExternal, odabir.ime_datoteke_za_info  & "_" & razina & ".snapshot") Then
'			Log("imamo snapshot!")
'			' učitaj info za snapshot
'			UcitajSnapshotInfo
'			' za snapshot
'			Dim tr As TextReader
'			tr.Initialize(File.OpenInput(File.DirDefaultExternal, odabir.ime_datoteke_za_info & "_" & razina & ".snapshot"))
'			Dim nivo As String = tr.ReadAll
'			ParsajRazine(nivo)
'			izgRazineOdIndeksaPoc = 0
'			If razina = 0 Then izgRazineDoIndeksaKraj = 0
'			izgRazineDoIndeksaKraj = izgRazineDoIndeksaKraj + hLevel.Get(razina) - 1

	Else
		ParsajRazine(Main.datZaParsanjeRazina)
		izgRazineOdIndeksaPoc = 0
		If razina = 0 Then izgRazineDoIndeksaKraj = 0
		izgRazineDoIndeksaKraj = izgRazineDoIndeksaKraj + hLevel.Get(razina) - 1
		KreirajNivo
	End If
End Sub

Sub ParsajRazine(dat As String)
	imeLevela.Clear
	wLevel.Clear
	hLevel.Clear
	izgledLevela.Clear
	brojLevela = 0
	Dim bytes() As Byte = dat.GetBytes("utf8")
	Dim ins As InputStream
	ins.InitializeFromBytesArray(bytes, 0, bytes.Length)
	slc_parse.Parse(ins, "slc")
End Sub

Sub slc_StartElement (Uri As String, Name As String, Attributes As Attributes)
	If Name = "Level" Then
'		Log(Attributes.GetValue2("","Id"))
		If Attributes.GetValue2("","Id").Length > 0 Then
			brojLevela = brojLevela + 1
'			Log(brojLevela)
			imeLevela.Add(Attributes.GetValue2("","Id"))
'			imeLevela.Put(brojDat, Attributes.GetValue2("","Id"))
		Else
			imeLevela.Add("No Name")
'			imeLevela.Put(brojDat, "No Level Name")
		End If
		If Attributes.GetValue2("","Width").Length > 0 Then
			wLevel.Add(Attributes.GetValue2("","Width"))
'			wLevel.put(brojDat, Attributes.GetValue2("","Width"))
		Else
			wLevel.Add("?")
'			wLevel.put(brojDat, "?")
		End If
		If Attributes.GetValue2("","Height").Length > 0 Then
			hLevel.Add(Attributes.GetValue2("","Height"))
'			hLevel.put(brojDat, Attributes.GetValue2("","Height"))
		Else
			hLevel.Add("?")
'			hLevel.put(brojDat, "?")
		End If
	End If
End Sub

Sub slc_EndElement(Uri As String, Name As String, text As StringBuilder)
    If slc_parse.Parents.IndexOf("LevelCollection") > -1 Then
		If Name = "L" Then
			izgledLevela.Add(text.ToString)
		End If
	End If
End Sub

Sub KreirajNivo
'	igraPocela =  False

	If Activity.NumberOfViews > 0 Then
		Activity.RemoveAllViews
	End If

	Dim br As Int = Rnd(1,6)
	Activity.SetBackgroundImage(LoadBitmap(File.DirAssets, "t" & br & ".png"))

	Dim mOpcije As Map
	Dim cb, rb2 As Boolean
	Dim skn As String

	mOpcije = File.ReadMap(Starter.SourceFolder, "opcije")
	cb = mOpcije.Get("cb")
	rb2 = mOpcije.Get("rb2")
	skn = mOpcije.Get("skin")
	Dim zid, kutija, kutnamj, mjzakut, pod, igr, igrnamj As String
	zid = mOpcije.Get("zid")
	kutija = mOpcije.Get("kutija")
	kutnamj = mOpcije.get("kutnamj")
	mjzakut = mOpcije.get("mjzakut")
	pod = mOpcije.get("pod")
	igr = mOpcije.get("igr")
	igrnamj = mOpcije.get("igrnamj")
'	mjuzaZid = mOpcije.Get("mjuzaZid")

'	Dim skn As String = spn'StateManager.GetSetting("skin")

	If skn.StartsWith("1") Then
		zid1 = LoadBitmap(Starter.SourceFolder & "/skins/" & skn & "/", skn.SubString(1) & "-wall.png")
		kutija1 = LoadBitmap(Starter.SourceFolder & "/skins/" & skn & "/", skn.SubString(1) & "-box.png")
		kutnamj1 = LoadBitmap(Starter.SourceFolder & "/skins/" & skn & "/", skn.SubString(1) & "-box-docked.png")
		mjzakut1 = LoadBitmap(Starter.SourceFolder & "/skins/" & skn & "/", skn.SubString(1) & "-dock.png")
		pod1 = LoadBitmap(Starter.SourceFolder & "/skins/" & skn & "/", skn.SubString(1) & "-floor.png")
		igr1 = LoadBitmap(Starter.SourceFolder & "/skins/" & skn & "/", skn.SubString(1) & "-worker.png")
		igrnamj1 = LoadBitmap(Starter.SourceFolder & "/skins/" & skn & "/", skn.SubString(1) & "-worker-docked.png")
'		bounceId3 = sounds.Load(File.DirAssets, "win.mp3")
	Else
		If zid <> "null" Then
			zid1 = LoadBitmap(Starter.SourceFolder & "/skins/" & skn & "/", zid)
		Else
			zid1 = LoadBitmap(File.DirAssets, "zid_2.png")
		End If
		If kutija <> "null" Then
			kutija1 = LoadBitmap(Starter.SourceFolder & "/skins/" & skn & "/", kutija)
		Else
			kutija1 = LoadBitmap(File.DirAssets, "kutija_2.png")
		End If
		If kutnamj <> "null" Then
			kutnamj1 = LoadBitmap(Starter.SourceFolder & "/skins/" & skn & "/", kutnamj)
		Else
			kutnamj1 = LoadBitmap(File.DirAssets, "kutija_na_mjestu_2.png")
		End If
		If mjzakut <> "null" Then
			mjzakut1 = LoadBitmap(Starter.SourceFolder & "/skins/" & skn & "/", mjzakut)
		Else
			mjzakut1 = LoadBitmap(File.DirAssets, "iks_2.png")
		End If
		If pod <> "null" Then
			pod1 = LoadBitmap(Starter.SourceFolder & "/skins/" & skn & "/", pod)
		Else
			pod1 = LoadBitmap(File.DirAssets, "pod.png")
		End If
		If igr <> "null" Then
			igr1 = LoadBitmap(Starter.SourceFolder & "/skins/" & skn & "/", igr)
		Else
			igr1 = LoadBitmap(File.DirAssets, "igrac2.png")
		End If
		If igrnamj <> "null" Then
			igrnamj1 = LoadBitmap(Starter.SourceFolder & "/skins/" & skn & "/", igrnamj)
		Else
			igrnamj1 = LoadBitmap(File.DirAssets, "igrac2.png")
		End If
		
'		bounceId3 = sounds.Load(Starter.SourceFolder & "/skins/" & skn & "/", mjuza)
	End If
	
'''''''	Activity.LoadLayout("igra_scv")
'	Log(GetDeviceLayoutValues)
'	Log(PanelI.Width)
'	PanelI.Width = 170dip
'	Log(PanelI.Width)
'	PanelI.Height = 100%y
	sv2d.Initialize(100%x, 100%y, "sv2d")

	ref.Target = sv2d
	ref.SetOnTouchListener("sv2d_Touch")
	ACTION_DOWN = Activity.ACTION_DOWN

'	imgKvacica.Initialize("")
'	sv2d.Panel.AddView(imgKvacica, 10%x, 10%y, 10%x, 10%y)
'	If nema_Sensor_TYPE_ORIENTATION Then
'	If StateManager.GetSetting("cb2") Then
'		sv2d.Panel.LoadLayout("igra_scv")
'	End If
'	Else
'		koristi senzor
'	End If
'	imgKvacica.Visible = False
'	brojKoraka = 0
'	lblSteps.Text = "Steps: " & brojKoraka
'	SetLabelTextSize(lblSteps, lblSteps.Text, 28, 10)
'	Dim cd As ColorDrawable
'	cd.Initialize(Colors.RGB(115, 175, 199), 0)
'	Log(StateManager.settings)
'	Log(StateManager.GetSetting("cb"))
'	Log(StateManager.GetSetting("cb2"))

'	If StateManager.GetSetting("cb2").EqualsIgnoreCase("true") Then
	If rb2 Then
		Activity.AddView(sv2d, 0, 0, 100%x, 100%y)
		Activity.LoadLayout("igra_scv")
		If cb Then
'			Activity.AddView(sv2d, PanelI.Width, 0, 100%x - PanelI.Width, 100%y)
			PanelI.Left = 0
			PanelI.Top = 48%y
'			Activity.Background = cd
		Else
'			Activity.AddView(sv2d, 0, 0, 100%x - PanelI.Width, 100%y)
			PanelI.Left = 100%x - PanelI.Width
			PanelI.Top = 48%y
'			Activity.Background = cd
		End If
	Else
		Activity.AddView(sv2d, 0, 0, 100%x, 100%y)
'		sv2d.Panel.AddView(btnNatrag, 100%x - 1%x, 1%x, 10%x, 10%x)
	End If
	btnNatrag.Initialize("btn")
	btnNatrag.Tag = "natrag"
	btnNatrag.Gravity = Gravity.FILL
	btnNatrag.SetBackgroundImage(LoadBitmap(File.DirAssets, "z_undo.png"))
	btnNatrag.BringToFront
	btnNatrag.Visible = True
	Activity.AddView(btnNatrag, 100%x - 11%x, 1%x, 10%x, 10%x)

'	pozIgraca.Initialize
	pozKutijaMjesta.Initialize
	'''''''''''''''''''''''''''''
	'''''''' slijedeći kod stavljen pod komentar!!!!!!!1'''''''''''''''''''
	'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
'	If pozKutija.IsInitialized = False Then
		pozKutija.Initialize
'	End If
	karta.Initialize
	tempKartaZaNatrag.Initialize

'	Dim snapshotPostoji As Boolean = False
'	Dim l1 As List
'	Dim iks As Int = 0
'	If File.Exists(File.DirDefaultExternal, odabir.ime_datoteke_za_info & "_" & razina & ".snapshot") Then
'		l1 = File.ReadList(File.DirDefaultExternal, odabir.ime_datoteke_za_info & "_" & razina & ".snapshot")
''		pozKutija.Add(l1.Get(0))
''		pozKutija.Add(l1.Get(1))
''		pozKutija.Add(l1.Get(2))
''		karta.Put("@", l1.Get(3))
'		snapshotPostoji = True
'	End If

	lWidth = wLevel.Get(razina)
	Dim lHeight As Int = hLevel.Get(razina)
'	If cijelkiEkran Then
		tWidth = 100%x / lWidth
'	Else
'		tWidth = (100%x - PanelI.Width) / lWidth'80'100'x'40'dip
'	End If
	Dim tHeight As Int = 100%y / lHeight
	If tWidth > tHeight Then
		tHeight = tWidth
	Else
		tWidth = tHeight
	End If
	If tWidth < 60 Or tHeight < 60 Then
		Log("<80")
		tWidth = 70
		tHeight = 70
	Else if tWidth > 200 Or tHeight > 200 Then
		tWidth = 200
		tHeight = 200
	End If

	ukupno_razina = brojLevela

'	koordinate.Initialize
	velicinaRetka.Initialize

	Dim wL As Int = wLevel.Get(razina) : Dim hL As Int = hLevel.Get(razina) : Dim imamoZid As Boolean = False : Dim y As Int = 0
	Dim x1 As Int = 100%x
	Dim x2 As Int = wL * tWidth
	' za centriranje nivoa
	If x1 > x2 Then
		x3 = (100%x - x2) / 2
	Else
		x3 = 0
	End If
	For i = izgRazineOdIndeksaPoc To izgRazineDoIndeksaKraj
'		Log("i: " & i)
		' i bi trebao ići od 0 do hLevel - 1
		Dim s As String = izgledLevela.Get(izgRazineOdIndeksaPoc+y)
'		Log(s)
		Dim s1 As String = s
		s1 = s1.Trim
		velicinaRetka.Add(s1.Length)
		For j = 0 To s.Length - 1
'			Log("j: " & j)
			Dim s1 As String = s.CharAt(j)
			' zid
			If s1.EqualsIgnoreCase("#") Then
				imamoZid = True
				Dim iv As ImageView
				iv.Initialize("")
				iv.Tag = "#"
				iv.Gravity = Gravity.FILL
				iv.Bitmap = zid1'LoadBitmap(File.DirAssets, "zid_2.png")
				sv2d.Panel.AddView(iv, j*tWidth+x3, y*tWidth, tWidth, tHeight)'tWidth)
				karta.Put(y & ";" & j, iv)
				tempKartaZaNatrag.Put(y & ";" & j, "#")
'				koordinate.Put(y & ";" & j, (j*tWidth) & ":" & ((j+1)*tWidth) & ";" & (y*tWidth) & ":" & ((y+1)*tWidth))

			' prazno mjesto za kutije
			else if s1.EqualsIgnoreCase(" ") Then
				If imamoZid Then
					If y > 0 And y < hL - 1 Then
						Dim iv As ImageView
						iv.Initialize("")
						iv.Tag = "_"
						iv.Gravity = Gravity.FILL
						iv.Bitmap = pod1
						sv2d.Panel.AddView(iv, j*tWidth+x3, y*tWidth, tWidth, tHeight)'tWidth)
						karta.Put(y & ";" & j, iv)
						tempKartaZaNatrag.Put(y & ";" & j, "_")
'						koordinate.Put(y & ";" & j, (j*tWidth) & ":" & ((j+1)*tWidth) & ";" & (y*tWidth) & ":" & ((y+1)*tWidth))
					End If
'				Else
'					'
'					' neki nivoi imaju prazno mjesto ispred prvog tilea zida u bilo kojem redu (ako je recimo širina 10 onda prvi red nema 10 tilea nego recimo 4 (ovisi o drugom redu, itd.))
'					' tu u iv.tag stavljamo _ da bi lakše usnimili nivo kao snapshot ako korisnik želi koristiti snapshot
'					'
'					Dim iv As ImageView
'					iv.Initialize("")
'					iv.Tag = "_"
'					karta.Put(y & ";" & j, iv)
				End If

			' kutija
			else if s1.EqualsIgnoreCase("$") Then
				Dim iv As ImageView
				iv.Initialize("")
				iv.Tag = "$"
				iv.Gravity = Gravity.FILL
				iv.Bitmap = kutija1'LoadBitmap(File.DirAssets, "kutija.png")
'				sv2d.Panel.AddView(iv, j*tWidth, y*tWidth, tWidth, tWidth)
'				If snapshotPostoji = False Then
'				If snapshot = False Then
					pozKutija.Add(y & ";" & j)
					karta.Put(y & ";" & j, iv)
					tempKartaZaNatrag.Put(y & ";" & j, "$")
'					koordinate.Put(y & ";" & j, (j*tWidth) & ":" & ((j+1)*tWidth) & ";" & (y*tWidth) & ":" & ((y+1)*tWidth))
					sv2d.Panel.AddView(iv, j*tWidth+x3, y*tWidth, tWidth, tHeight)'tWidth)
'				Else
'					karta.Put(pozKutija.Get(iks), iv)
'					Dim ssss As String = pozKutija.Get(iks)
'					Dim ipsilon As Int = ssss.SubString2(0, ssss.IndexOf(";"))
'					Dim ij As Int = ssss.SubString2(ssss.IndexOf(";") + 1, ssss.Length)
'					sv2d.Panel.AddView(iv, ij*tWidth, ipsilon*tWidth, tWidth, tWidth)
'					iks = iks + 1
'				End If

			' mjesto za kutiju gdje treba biti (goal square) . (točka) i kutija na mjestu gdje treba biti *
			else if s1.EqualsIgnoreCase(".") Or s1.EqualsIgnoreCase("*") Then
				Dim iv As ImageView
				iv.Initialize("")
				If s1.EqualsIgnoreCase("*") Then
					iv.Tag = "*"
					iv.Gravity = Gravity.FILL
					iv.Bitmap = kutnamj1'LoadBitmap(File.DirAssets, "kutija_na_mjestu.png")
'					If snapshotPostoji = False Then
'					If snapshot = False Then
						pozKutija.Add(y & ";" & j)
						pozKutijaMjesta.Add(y & ";" & j)
						karta.Put(y & ";" & j, iv)
						tempKartaZaNatrag.put(y & ";" & j, "*")
'						tempKartaZaNatrag.Put(y & ";" & j, (j*tWidth) & ":" & ((j+1)*tWidth) & ";" & (y*tWidth) & ":" & ((y+1)*tWidth))
'						sv2d.Panel.AddView(iv, j*tWidth, y*tWidth, tWidth, tWidth)
'					Else
'						pozKutijaMjesta.Add(y & ";" & j)
'						karta.Put(pozKutija.Get(iks), iv)
'						iks = iks + 1
'						Dim ssss As String = pozKutija.Get(iks)
'						Dim ipsilon As Int = ssss.SubString2(0, ssss.IndexOf(";"))
'						Dim ij As Int = ssss.SubString2(ssss.IndexOf(";") + 1, ssss.Length)
'						sv2d.Panel.AddView(iv, ij*tWidth, ipsilon*tWidth, tWidth, tWidth)
'					End If

				Else if s1.EqualsIgnoreCase(".") Then
					iv.Tag = "."
					iv.Gravity = Gravity.FILL
					iv.Bitmap = mjzakut1'LoadBitmap(File.DirAssets, "iks.png")
					pozKutijaMjesta.Add(y & ";" & j)
					karta.Put(y & ";" & j, iv)
					tempKartaZaNatrag.Put(y & ";" & j, ".")
'					koordinate.Put(y & ";" & j, (j*tWidth) & ":" & ((j+1)*tWidth) & ";" & (y*tWidth) & ":" & ((y+1)*tWidth))
'					sv2d.Panel.AddView(iv, j*tWidth, y*tWidth, tWidth, tWidth)
				End If
				sv2d.Panel.AddView(iv, j*tWidth+x3, y*tWidth, tWidth, tHeight)'tWidth)

			' igrač i igrač na mjestu za kutiju (+)
			else if s1.EqualsIgnoreCase("@") Or s1.EqualsIgnoreCase("+") Then
				Dim iv As ImageView
				iv.Initialize("")
				iv.Gravity = Gravity.FILL
				iv.Bitmap = igr1'LoadBitmap(File.DirAssets, "igrac2.png")
				If s1.EqualsIgnoreCase("@") Then
					iv.Tag = "_"
'					karta.Put("@", y & ";" & j)
'					karta.Put(y & ";" & j, iv)
'					If snapshotPostoji = False Then
'					If snapshot = False Then
'						pozIgraca.Put("@", y & ";" & j)
						karta.Put("@", y & ";" & j)
						karta.Put(y & ";" & j, iv)
						tempKartaZaNatrag.Put(y & ";" & j, "_")
'						koordinate.Put(y & ";" & j, (j*tWidth) & ":" & ((j+1)*tWidth) & ";" & (y*tWidth) & ":" & ((y+1)*tWidth))
'						sv2d.Panel.AddView(iv, j*tWidth, y*tWidth, tWidth, tWidth)
'					Else
'						karta.Put("@", pozKutija.Get(3))
'						karta.Put(pozKutija.Get(3), iv)
'						pozKutija.RemoveAt(3)
'						Dim ssss As String = pozKutija.Get(iks)
'						Dim ipsilon As Int = ssss.SubString2(0, ssss.IndexOf(";"))
'						Dim ij As Int = ssss.SubString2(ssss.IndexOf(";") + 1, ssss.Length)
'						sv2d.Panel.AddView(iv, ij*tWidth, ipsilon*tWidth, tWidth, tWidth)
'					End If
'					Else
'						karta.Put("@", l1.Get(3))
'						karta.Put(l1.Get(3), iv)
'					End If

				Else if s1.EqualsIgnoreCase("+") Then
					iv.Tag = "."
'					karta.Put("@", y & ";" & j)
'					karta.Put(y & ";" & j, iv)
'					If snapshotPostoji = False Then
'					If snapshot = False Then
						pozKutijaMjesta.Add(y & ";" & j)
'						pozIgraca.Put("@", y & ";" & j)
						karta.Put("@", y & ";" & j)
						karta.Put(y & ";" & j, iv)
						tempKartaZaNatrag.put(y & ";" & j, ".")
'						koordinate.Put(y & ";" & j, (j*tWidth) & ":" & ((j+1)*tWidth) & ";" & (y*tWidth) & ":" & ((y+1)*tWidth))
'						sv2d.Panel.AddView(iv, j*tWidth, y*tWidth, tWidth, tWidth)
'					Else
'						pozKutijaMjesta.Add(y & ";" & j)
'						karta.Put("@", pozKutija.Get(3))
'						karta.Put(pozKutija.Get(3), iv)
'						pozKutija.RemoveAt(3)
'						Dim ssss As String = pozKutija.Get(iks)
'						Dim ipsilon As Int = ssss.SubString2(0, ssss.IndexOf(";"))
'						Dim ij As Int = ssss.SubString2(ssss.IndexOf(";") + 1, ssss.Length)
'						sv2d.Panel.AddView(iv, ij*tWidth, ipsilon*tWidth, tWidth, tWidth)
'					End If
'					Else
'						pozKutijaMjesta.Add(l1.Get(3))
'						karta.Put("@", l1.Get(3))
'						karta.Put(l1.Get(3), iv)
'					End If
				End If
'				iv.Gravity = Gravity.FILL
'				iv.Bitmap = LoadBitmap(File.DirAssets, "igrac.png")
				sv2d.Panel.AddView(iv, j*tWidth+x3, y*tWidth, tWidth, tHeight)'tWidth)
			End If
		Next
		y = y + 1
		imamoZid = False
	Next

'	Log("i: " & i)
'	Log("j: " & j)
'	Log("i * j = " & (i*j))
'	Log(karta.Size)
	sv2d.Panel.Height = tWidth * hL
	If x1 > x2 Then
		sv2d.Panel.Width = 100%x
	Else
		sv2d.Panel.Width = tWidth * wL
	End If
'	ScaleView(sv2d, 0.5)
	
'	Dim r2 As Int = razina
	Dim s As String = imeLevela.Get(razina)
'	lblRazina.Text = s & CRLF & "Level: " & (r2+1) & "/" & ukupno_razina
'	lblRazina.Text = s & CRLF & "Played: " & (razina+1) & "/" & ukupno_razina
'	SetLabelTextSize(lblRazina, lblRazina.Text, 28, 8)

'	DoEvents
	Sleep(0)
	sv2d.SmoothScrollTo(IzracunajPozicijuX, IzracunajPozicijuY)

	Activity.LoadLayout("info_panel")
	If rec.IsInitialized Then
		btnRec.Enabled = True
	Else
		btnRec.Enabled = False
	End If
	pnlInfo.Top = -(pnlInfo.Height) + 8%x
	Dim cd As ColorDrawable
	cd.Initialize(Colors.ARGB(0, 0, 0, 0), 0)
	pnlInfo.Background = cd

	If snd Then' Or mjuzaZid.EqualsIgnoreCase("true") Then
		btnSound.SetBackgroundImage(LoadBitmap(File.DirAssets, "s_on.png"))
	Else
		btnSound.SetBackgroundImage(LoadBitmap(File.DirAssets, "s_off.png"))
	End If

	brojKoraka = 0
	lblSteps.Initialize("")
	lblSteps.Text = "Steps: " & brojKoraka
'	lblSteps.Text = brojKoraka
	lblSteps.TextColor = Colors.Red
	Activity.AddView(lblSteps, 0, 0, 15%x, 10%y)
	SetLabelTextSize(lblSteps, lblSteps.Text, 28, 10)

'	lblRazina.Text = s & CRLF & "Finished: " & (razina+1) & "/" & ukupno_razina
	lblRazina.Text = s & CRLF & "Finished: " & razina & "/" & ukupno_razina
	SetLabelTextSize(lblRazina, lblRazina.Text, 28, 8)

	brojGuranja = 0
	lblPushes.Initialize("")
	lblPushes.Text = "Pushes: " & brojGuranja
	lblPushes.TextColor = Colors.Cyan
	Activity.AddView(lblPushes, 0, 10%y, 15%x, 10%y)
	SetLabelTextSize(lblPushes, lblPushes.Text, 28, 10)

'	lblBT.Initialize("")
'	lblBT.TextColor = Colors.Green
	
	lblCT.Initialize("")
	lblCT.TextColor = Colors.Red
	Activity.AddView(lblCT, 2%x, 100%y - 20%y, 20%x, 10%x)
	lblCT.Typeface = Typeface.DEFAULT_BOLD
	SetLabelTextSize(lblCT, lblCT.Text, 50, 10)
End Sub

Sub btn_Click
	Dim send As View : Dim redak, stupac As Int' : Dim cd As ColorDrawable
	If Timer1.Enabled = False Then Timer1.Enabled = True

'	cd.Initialize(Colors.RGB(115, 175, 199), 0)

	send = Sender
	Select send.Tag
		' gore
		Case "g"
			redak = -1
			' pozicija igrača
			Dim staraPoz As String = karta.Get("@")

			' slijedeća pozicija
			Dim npt1 As String = staraPoz.SubString2(0, staraPoz.IndexOf(";"))
			Dim npt2 As Int = npt1 + redak
			Dim novaPoz As String = npt2 & staraPoz.SubString(staraPoz.IndexOf(";"))

			' pozicija dva mjesta od igrača
			Dim npt1 As String = novaPoz.SubString2(0, novaPoz.IndexOf(";"))
			Dim npt2 As Int = npt1 + redak
			Dim drugaKutijaPoz As String = npt2 & novaPoz.SubString(novaPoz.IndexOf(";"))

'			Log("početna pozicija igrača (naprijed): " & staraPoz)
'			Log("nova pozicija igrača (naprijed): " & novaPoz)
'			Log("nova pozicija igrača+2 (naprijed): " & drugaKutijaPoz)
'			pozIgracaZaNatrag.add(staraPoz)
'			pozIgracaZaNatrag.InsertAt(0, staraPoz)
'			pozIgracaZaNatrag.InsertAt(pozIgracaZaNatrag.Size, novaPoz)
'			pozIgracaZaNatrag.Put("sp1", staraPoz)
'			pozIgracaZaNatrag.Put("np1", novaPoz)
'			pozIgracaZaNatrag.Put("sp2", drugaKutijaPoz)
'			Log("početna pozicija igrača (natrag): " & novaPoz)
'			Log("nova pozicija igrača (natrag): " & staraPoz)
'			Log("nova pozicija igrača+2 (natrag): " & drugaKutijaPoz)
'			ProvjeriIPomakni(staraPoz, novaPoz, drugaKutijaPoz)', cd)
			ProvjeriIPomakni(staraPoz, novaPoz, drugaKutijaPoz, 1)

		' lijevo
		Case "l"
			' umanjujemo stupac
			stupac = -1
			' pozicija igrača
			Dim staraPoz As String = karta.Get("@")

			' slijedeća pozicija
			Dim npt1 As String = staraPoz.SubString(staraPoz.IndexOf(";")+1)
			Dim npt2 As Int = npt1 + stupac
			Dim novaPoz As String = staraPoz.SubString2(0, staraPoz.IndexOf(";")+1) & npt2

			' pozicija dva mjesta od igrača
			Dim npt1 As String = novaPoz.SubString(novaPoz.IndexOf(";")+1)
			Dim npt2 As Int = npt1 + stupac
			Dim drugaKutijaPoz As String = novaPoz.SubString2(0, novaPoz.IndexOf(";")+1) & npt2

'			Log("početna pozicija igrača (naprijed): " & staraPoz)
'			Log("nova pozicija igrača (naprijed): " & novaPoz)
'			Log("nova pozicija igrača+2 (naprijed): " & drugaKutijaPoz)
'			pozIgracaZaNatrag.add(staraPoz)
'			pozIgracaZaNatrag.InsertAt(0, staraPoz)
'			pozIgracaZaNatrag.InsertAt(pozIgracaZaNatrag.Size, novaPoz)
'			pozIgracaZaNatrag.Put("sp1", staraPoz)
'			pozIgracaZaNatrag.Put("np1", novaPoz)
'			pozIgracaZaNatrag.Put("sp2", drugaKutijaPoz)
'			Log("početna pozicija igrača (natrag): " & novaPoz)
'			Log("nova pozicija igrača (natrag): " & staraPoz)
'			Log("nova pozicija igrača+2 (natrag): " & drugaKutijaPoz)
'			ProvjeriIPomakni(staraPoz, novaPoz, drugaKutijaPoz)', cd)
			ProvjeriIPomakni(staraPoz, novaPoz, drugaKutijaPoz, 2)

		' desno
		Case "d"
			' uvećavamo stupac
			stupac = 1
			' pozicija igrača
			Dim staraPoz As String = karta.Get("@")

			' slijedeća pozicija
			Dim npt1 As String = staraPoz.SubString(staraPoz.IndexOf(";")+1)
			Dim npt2 As Int = npt1 + stupac
			Dim novaPoz As String = staraPoz.SubString2(0, staraPoz.IndexOf(";")+1) & npt2

			' pozicija dva mjesta od igrača
			Dim npt1 As String = novaPoz.SubString(novaPoz.IndexOf(";")+1)
			Dim npt2 As Int = npt1 + stupac
			Dim drugaKutijaPoz As String = novaPoz.SubString2(0, novaPoz.IndexOf(";")+1) & npt2
			
'			Log("početna pozicija igrača (naprijed): " & staraPoz)
'			Log("nova pozicija igrača (naprijed): " & novaPoz)
'			Log("nova pozicija igrača+2 (naprijed): " & drugaKutijaPoz)
'			pozIgracaZaNatrag.add(staraPoz)
'			pozIgracaZaNatrag.InsertAt(0, staraPoz)
'			pozIgracaZaNatrag.InsertAt(pozIgracaZaNatrag.Size, novaPoz)
'			pozIgracaZaNatrag.Put("sp1", staraPoz)
'			pozIgracaZaNatrag.Put("np1", novaPoz)
'			pozIgracaZaNatrag.Put("sp2", drugaKutijaPoz)
'			Log("početna pozicija igrača (natrag): " & novaPoz)
'			Log("nova pozicija igrača (natrag): " & staraPoz)
'			Log("nova pozicija igrača+2 (natrag): " & drugaKutijaPoz)
'			ProvjeriIPomakni(staraPoz, novaPoz, drugaKutijaPoz)', cd)
			ProvjeriIPomakni(staraPoz, novaPoz, drugaKutijaPoz, 4)

		' dole
		Case "do"
			redak = 1

			' pozicija igrača
			Dim staraPoz As String = karta.Get("@")

			' slijedeća pozicija
			Dim npt1 As String = staraPoz.SubString2(0, staraPoz.IndexOf(";"))
			Dim npt2 As Int = npt1 + redak
			Dim novaPoz As String = npt2 & staraPoz.SubString(staraPoz.IndexOf(";"))

			' pozicija dva mjesta od igrača
			Dim npt1 As String = novaPoz.SubString2(0, novaPoz.IndexOf(";"))
			Dim npt2 As Int = npt1 + redak
			Dim drugaKutijaPoz As String = npt2 & novaPoz.SubString(novaPoz.IndexOf(";"))

'			Log("početna pozicija igrača (naprijed): " & staraPoz)
'			Log("nova pozicija igrača (naprijed): " & novaPoz)
'			Log("nova pozicija igrača+2 (naprijed): " & drugaKutijaPoz)
'			pozIgracaZaNatrag.add(staraPoz)
'			pozIgracaZaNatrag.InsertAt(0, staraPoz)
'			pozIgracaZaNatrag.InsertAt(pozIgracaZaNatrag.Size, novaPoz)
'			pozIgracaZaNatrag.Put("sp1", staraPoz)
'			pozIgracaZaNatrag.Put("np1", novaPoz)
'			pozIgracaZaNatrag.Put("sp2", drugaKutijaPoz)
'			Log("početna pozicija igrača (natrag): " & novaPoz)
'			Log("nova pozicija igrača (natrag): " & staraPoz)
'			Log("nova pozicija igrača+2 (natrag): " & drugaKutijaPoz)
'			ProvjeriIPomakni(staraPoz, novaPoz, drugaKutijaPoz)', cd)
			ProvjeriIPomakni(staraPoz, novaPoz, drugaKutijaPoz, 3)

		Case "reset"
			NovaIgra

'		Case "meni"
'			If PanelMeni.Visible Then
'				PanelMeni.Visible = False
'			Else
'				PanelMeni.Visible = True
'			End If

		Case "sound"
'			Dim mOpcije As Map
'			mOpcije = File.ReadMap(Starter.SourceFolder, "opcije")
'			Dim mjuzaZid As String
'			mjuzaZid = mOpcije.Get("mjuzaZid")

			If snd Then'Or mjuzaZid.EqualsIgnoreCase("true") Then
				snd = False
				btnSound.SetBackgroundImage(LoadBitmap(File.DirAssets, "s_off.png"))
'				Dim mOpcije As Map
'				mOpcije.Initialize
'				mOpcije.Put("mjuzaZid", False)
'				File.WriteMap(Starter.SourceFolder, "opcije", mOpcije)
			Else
				snd = True
				btnSound.SetBackgroundImage(LoadBitmap(File.DirAssets, "s_on.png"))
'				Dim mOpcije As Map
'				mOpcije.Initialize
'				mOpcije.Put("mjuzaZid", True)
'				File.WriteMap(Starter.SourceFolder, "opcije", mOpcije)
			End If
			btnInfo_Click

		Case "record"
			If rec.IsInitialized Then
				If recB Then
'					If Timer2.Enabled Then Timer2.Enabled = False
					recB = False
					rec.StopRecording
					btnRec.SetBackgroundImage(LoadBitmap(File.DirAssets, "off.png"))
'					lbl1.Visible = False
				Else
'					Timer2.Initialize("Timer2", 1000)
'					recB = True
					rec.GetPermission
					btnRec.SetBackgroundImage(LoadBitmap(File.DirAssets, "on.png"))
					' labela za odbrojavanje kod snimanja
'					lbl1.Initialize("")
'					lbl1.Text = "3"
'					lbl1.TextSize = 72
'					lbl1.Typeface = Typeface.DEFAULT_BOLD
'					lbl1.Gravity = Bit.Or(Gravity.CENTER_HORIZONTAL, Gravity.CENTER_VERTICAL)
'					lbl1.TextColor = Colors.Red
'					Dim cd As ColorDrawable
'					cd.Initialize(Colors.ARGB(0, 255, 0, 0), 0)
'					lbl1.Background = cd
'					Activity.AddView(lbl1, (Activity.Width - 100dip) / 2, Activity.Height / 2 - 100dip, 100dip, 100dip)
'					lbl1.Visible = True
'					Timer2.Enabled = True
				End If
'				norec = False
'				btnRec.Enabled = True
'			Else
'				norec = True
'				btnRec.Enabled = False
			End If
			btnInfo_Click
			
		' jedan korak natrag
		Case "natrag"
'			Msgbox("??", "xx")
'			Exit
			'			Log(rijesenje)
			Dim s As String = rijesenje
			If s.Length >= 1 Then
				Dim s As String = rijesenje.SubString(rijesenje.Length-1)
				If s.Contains("l") Or s.Contains("L") Then
					If s.StartsWith("L") Then	' idemo desno
						velikoSlovo = True
					Else
						velikoSlovo = False
					End If
					VratiPotez("desno")
				else if s.Contains("u") Or s.Contains("U") Then
					If s.StartsWith("U") Then	' idemo dole
						velikoSlovo = True
					Else
						velikoSlovo = False
					End If
					VratiPotez("dole")
				else if s.Contains("r") Or s.Contains("R") Then
					If s.StartsWith("R") Then	' idemo lijevo
						velikoSlovo = True
					Else
						velikoSlovo = False
					End If
					VratiPotez("lijevo")
				else if s.Contains("d") Or s.Contains("D") Then
					If s.StartsWith("D") Then	' idemo gore
						velikoSlovo = True
					Else
						velikoSlovo = False
					End If
					VratiPotez("gore")
				End If
			Else
				Msgbox("No more moves for undo!", "Info")
			End If
'			btnInfo_Click

		' slijedeća razina
		Case "next"
			slijedeci = True
'			If Activity.NumberOfViews > 0 Then Activity.RemoveAllViews
			If razina < ukupno_razina-1 Then
				Log("razina|ukupno razina: " & razina & "|" & ukupno_razina)
'				pokusaj = 0
				razina = razina + 1
				ParsajRazine(Main.datZaParsanjeRazina)
				Dim od As Int = 0
				For i = 0 To razina - 1
					od = od + hLevel.Get(i)
				Next
				Dim doo As Int = 0
				For i = 0 To razina
					doo = doo + hLevel.Get(i)
				Next
				izgRazineOdIndeksaPoc = od
				izgRazineDoIndeksaKraj = doo - 1

				KreirajNivo
'			Else
'				Msgbox("All levels solved", "Congratulations")
'				Msgbox("Zadnja razina!", "Info")
			End If
			slijedeci = False

		Case "prev"
			prethodni = True
'			If Activity.NumberOfViews > 0 Then Activity.RemoveAllViews
			If razina < ukupno_razina And razina > 0 Then
				Log("razina|ukupno razina: " & razina & "|" & ukupno_razina)
'				pokusaj = 0
				razina = razina - 1
				ParsajRazine(Main.datZaParsanjeRazina)
				Dim od As Int = 0
				For i = 0 To razina - 1
					od = od + hLevel.Get(i)
				Next
				Dim doo As Int = 0
				For i = 0 To razina
					doo = doo + hLevel.Get(i)
				Next
				izgRazineOdIndeksaPoc = od
				izgRazineDoIndeksaKraj = doo - 1
				KreirajNivo

'			Else if razina = ukupno_razina Then
'				Msgbox("All levels solved", "Congratulations")
'				Msgbox("Zadnja razina!", "Info")
			End If
			prethodni = False

'		Case "tajmer"
'			If igraPocela And Timer4.Enabled Then
''				Msgbox("You can't start timer because you already played a move!", "Info")
''				Return
'			Else
'				If Timer4.Enabled Then
'					Timer4.Enabled = False
'	'				lblBT.Visible = False
'					lblCT.Visible = False
'					igraPocela = False
'				Else
'					Timer4.Enabled = True
'	'				lblBT.Visible = True
'					lblCT.Visible = True
'					lblCT.Text = "00:00"
'					sekunde = 0
'					minute = 0
'					igraPocela = True
'				End If
'				btnInfo_Click
'			End If
'		Log("btn_Click -> poz. igrača prije pomicanja: " & staraPoz)
'		Log("btn_Click -> poz. igrača nakon pomicanja: " & novaPoz)
	End Select
End Sub

Sub VratiPotez(smjer As String)
'	For i = pozIgracaZaNatrag.Size-1 To 0 Step -1
	'		Log(pozIgracaZaNatrag.Get(i))
	'	Next
	'	DoEvents
	Dim redak, stupac As Int : Dim cd As ColorDrawable
	
	cd.Initialize(Colors.RGB(115, 175, 199), 0)

'	Log(rijesenje)

	Select smjer
		Case "gore"
			redak = -1
			' stara pozicija igrača
			Dim staraPoz As String = karta.Get("@")
			
			' prethodna pozicija
			Dim npt1 As String = staraPoz.SubString2(0, staraPoz.IndexOf(";"))
			Dim npt2 As Int = npt1 + redak
			Dim novaPoz As String = npt2 & staraPoz.SubString(staraPoz.IndexOf(";"))

			' pozicija dva mjesta od igrača
			Dim npt1 As String = staraPoz.SubString2(0, novaPoz.IndexOf(";"))
			Dim npt2 As Int = npt1 - redak
			Dim dvaMjOdIgraca As String = npt2 & staraPoz.SubString(staraPoz.IndexOf(";"))
			ProvjeriIPomakniUnatrag(staraPoz, novaPoz, dvaMjOdIgraca, 1)

		Case "lijevo"
			stupac = -1
			' stara pozicija igrača
			Dim staraPoz As String = karta.Get("@")

			' prethodna pozicija
			Dim npt1 As String = staraPoz.SubString(staraPoz.IndexOf(";")+1)
			Dim npt2 As Int = npt1 + stupac
			Dim novaPoz As String = staraPoz.SubString2(0, staraPoz.IndexOf(";")+1) & npt2

			' pozicija dva mjesta od igrača
			Dim npt1 As String = staraPoz.SubString(novaPoz.IndexOf(";")+1)
			Dim npt2 As Int = npt1 - stupac
			Dim dvaMjOdIgraca As String = staraPoz.SubString2(0, staraPoz.IndexOf(";")+1) & npt2
			ProvjeriIPomakniUnatrag(staraPoz, novaPoz, dvaMjOdIgraca, 2)

		Case "desno"
			stupac = 1
			' pozicija igrača
			Dim staraPoz As String = karta.Get("@")

			' prethodna pozicija
			Dim npt1 As String = staraPoz.SubString(staraPoz.IndexOf(";")+1)
			Dim npt2 As Int = npt1 + stupac
			Dim novaPoz As String = staraPoz.SubString2(0, staraPoz.IndexOf(";")+1) & npt2

			' pozicija dva mjesta od igrača
			Dim npt1 As String = staraPoz.SubString(novaPoz.IndexOf(";")+1)
			Dim npt2 As Int = npt1 - stupac
			Dim dvaMjOdIgraca As String = staraPoz.SubString2(0, staraPoz.IndexOf(";")+1) & npt2
			ProvjeriIPomakniUnatrag(staraPoz, novaPoz, dvaMjOdIgraca, 4)

		Case "dole"
			redak = 1

			' pozicija igrača
			Dim staraPoz As String = karta.Get("@")

			' prethodna pozicija
			Dim npt1 As String = staraPoz.SubString2(0, staraPoz.IndexOf(";"))
			Dim npt2 As Int = npt1 + redak
			Dim novaPoz As String = npt2 & staraPoz.SubString(staraPoz.IndexOf(";"))

			' pozicija dva mjesta od igrača
			Dim npt1 As String = staraPoz.SubString2(0, novaPoz.IndexOf(";"))
			Dim npt2 As Int = npt1 - redak
			Dim dvaMjOdIgraca As String = npt2 & staraPoz.SubString(staraPoz.IndexOf(";"))
			ProvjeriIPomakniUnatrag(staraPoz, novaPoz, dvaMjOdIgraca, 3)
	End Select

	sv2d.SmoothScrollTo(IzracunajPozicijuX, IzracunajPozicijuY)
End Sub

Sub ProvjeriIPomakniUnatrag(sp As String, np As String, dkp As String, smjer As Int)
	If karta.ContainsKey(np) Then
		Dim img0 As ImageView : img0 = karta.Get(sp)
		Dim img1 As ImageView : img1 = karta.Get(np)
		Dim img2 As ImageView : img2 = karta.Get(dkp)
		Dim sp1 As String = img0.Tag'tempKartaZaNatrag.Get(sp)'img0.Tag
		Dim np1 As String = img1.Tag'tempKartaZaNatrag.Get(np)'img1.Tag
		Dim dkp1 As String = tempKartaZaNatrag.Get(dkp)'img2.Tag

'		Dim img0a As ImageView : img0 = karta.Get(sp)
'		Dim img1a As ImageView : img1 = karta.Get(np)
'		Dim img2a As ImageView : img2 = karta.Get(dkp)
'		Dim sp2 As String = img0.Tag
'		Dim np2 As String = img1.Tag
'		Dim dkp2 As String = img2.Tag
		
'		Log(sp1)
'		Log(sp2)
'		Log(np1)
'		Log(np2)
'		Log(dkp1)
'		Log(dkp2)
		'
		' igrač
		'
		If np1.EqualsIgnoreCase("_") Then
			img1.Bitmap = igr1
			img1.Gravity = Gravity.FILL
			karta.Put("@", np)
		else if np1.EqualsIgnoreCase(".") Or np1.EqualsIgnoreCase("+") Then
			img1.Bitmap = igrnamj1
			img1.Gravity = Gravity.FILL
			karta.Put("@", np)
		End If

		'
		' kutija
		'
		If velikoSlovo = False Then
			If sp1.EqualsIgnoreCase("_") Then
				img0.Bitmap = pod1
				img0.Tag = "_"
				img0.Gravity = Gravity.FILL
			else if sp1.EqualsIgnoreCase(".") Then
				img0.Bitmap = mjzakut1
				img0.Gravity = Gravity.FILL
				img0.Tag = "."
			else if sp1.EqualsIgnoreCase("*") Then
				img0.Bitmap = kutnamj1
				img0.Gravity = Gravity.FILL
				img0.Tag = "*"
			End If
		Else
			If sp1.EqualsIgnoreCase(".") Then
				img0.Bitmap = kutnamj1
				img0.Gravity = Gravity.FILL
				img0.Tag = "*"
				Dim xx As Int = pozKutija.IndexOf(dkp)
				pozKutija.RemoveAt(xx)
				pozKutija.Add(sp)
				velikoSlovo = False
			Else
				img0.Bitmap = kutija1
				img0.Gravity = Gravity.FILL
				img0.Tag = "$"
				Dim xx As Int = pozKutija.IndexOf(dkp)
				pozKutija.RemoveAt(xx)
				pozKutija.Add(sp)
				velikoSlovo = False
			End If
		End If
		'
		' preostalo mjesto
		'
		If dkp1.EqualsIgnoreCase("_") Then
			img2.Bitmap = pod1
			img2.Tag = "_"
			img2.Gravity = Gravity.FILL
		else if dkp1.EqualsIgnoreCase("$") Then
			img2.Bitmap = kutija1
			img2.Tag = "$"
			img2.Gravity = Gravity.FILL
		else if dkp1.EqualsIgnoreCase("*") Then
			img2.Bitmap = kutnamj1
			img2.Gravity = Gravity.FILL
			img2.Tag = "*"
		else if dkp1.EqualsIgnoreCase(".") Then
			img2.Bitmap = mjzakut1
			img2.Gravity = Gravity.FILL
			img2.Tag = "."
		End If
	End If
	' makni zadnji znak iz niza za riješenje
	rijesenje = rijesenje.SubString2(0, rijesenje.Length - 1)
	Log("rijesenje: " & rijesenje)
	lblSteps.Text = "Steps: " & brojKoraka
	SetLabelTextSize(lblSteps, lblSteps.Text, 28, 10)
	lblPushes.Text = "Pushes: " & brojGuranja
	SetLabelTextSize(lblPushes, lblPushes.Text, 28, 10)
	sv2d.SmoothScrollTo(IzracunajPozicijuX, IzracunajPozicijuY)
End Sub

'Sub ProvjeriIPomakni(sp As String, np As String, dkp As String, bkg As ColorDrawable, smjer As Int)
Sub ProvjeriIPomakni(sp As String, np As String, dkp As String, smjer As Int)', bkg As ColorDrawable)
'	Dim mOpcije As Map
'	mOpcije = File.ReadMap(Starter.SourceFolder, "opcije")
'	Dim mjuzaZid As String
'	mjuzaZid = mOpcije.Get("mjuzaZid")

	If karta.ContainsKey(np) Then
		Dim img0 As ImageView : img0 = karta.Get(sp)
		Dim img1 As ImageView : img1 = karta.Get(np)
		Dim img2 As ImageView : img2 = karta.Get(dkp)
		Dim novaP1 As String = img1.Tag
		If img2.IsInitialized Then
			Dim novaP2 As String = img2.Tag
		Else
			novaP2 = "#"	' zid -> druga pozicija od igrača
		End If
		Dim staraP As String = img0.Tag
		If novaP1.EqualsIgnoreCase("_") Then' Or novaP1.EqualsIgnoreCase(".") Then
			img1.Bitmap = igr1' LoadBitmap(File.DirAssets, "igrac2.png")
			img1.Gravity = Gravity.FILL
			karta.Put("@", np)
			If staraP.EqualsIgnoreCase(".") Then
				img0.Bitmap = mjzakut1'LoadBitmap(File.DirAssets, "iks.png")
				img0.Tag = "."
			Else
'				img0.Background = bkg
				img0.Bitmap = pod1
				img0.Tag = "_"
			End If
			brojKoraka = brojKoraka + 1
			If smjer = 1 Then ' gore
				rijesenje = rijesenje & "u"
			else if smjer = 2 Then ' lijevo
				rijesenje = rijesenje & "l"
			else if smjer = 3 Then ' dole
				rijesenje = rijesenje & "d"
			else if smjer = 4 Then ' desno
				rijesenje = rijesenje & "r"
			End If

		else if novaP1.EqualsIgnoreCase(".") Then
			img1.Bitmap = igrnamj1'LoadBitmap(File.DirAssets, "igrac_iks.png")
			img1.Gravity = Gravity.FILL
			karta.Put("@", np)
			If staraP.EqualsIgnoreCase(".") Then
				img0.Bitmap = mjzakut1'LoadBitmap(File.DirAssets, "iks.png")
				img0.Tag = "."
			Else
'				img0.Background = bkg
				img0.Bitmap = pod1
				img0.Tag = "_"
			End If
			brojKoraka = brojKoraka + 1
			If smjer = 1 Then ' gore
				rijesenje = rijesenje & "u"
			else if smjer = 2 Then ' lijevo
				rijesenje = rijesenje & "l"
			else if smjer = 3 Then ' dole
				rijesenje = rijesenje & "d"
			else if smjer = 4 Then ' desno
				rijesenje = rijesenje & "r"
			End If
			
		else if novaP1.EqualsIgnoreCase("$") And novaP2.EqualsIgnoreCase("_") Then
			img1.Bitmap = igr1' LoadBitmap(File.DirAssets, "igrac2.png")
			img1.Gravity = Gravity.FILL
			img1.Tag = "_"
			karta.Put("@", np)
			img2.Bitmap = kutija1' LoadBitmap(File.DirAssets, "kutija.png")
			img2.Gravity = Gravity.FILL
			img2.Tag = "$"
			Dim xx As Int = pozKutija.IndexOf(np)
			pozKutija.RemoveAt(xx)
			pozKutija.Add(dkp)
			If staraP.EqualsIgnoreCase(".") Then
				img0.Bitmap = mjzakut1' LoadBitmap(File.DirAssets, "iks.png")
				img0.Tag = "."
			Else
'				img0.Background = bkg
				img0.Bitmap = pod1
				img0.Tag = "_"
			End If
			brojKoraka = brojKoraka + 1
			brojGuranja = brojGuranja + 1
			If smjer = 1 Then ' gore
				rijesenje = rijesenje & "U"
			else if smjer = 2 Then ' lijevo
				rijesenje = rijesenje & "L"
			else if smjer = 3 Then ' dole
				rijesenje = rijesenje & "D"
			else if smjer = 4 Then ' desno
				rijesenje = rijesenje & "R"
			End If

		else if novaP1.EqualsIgnoreCase("$") And novaP2.EqualsIgnoreCase(".") Then
			img1.Bitmap = igr1'igrnamj1' LoadBitmap(File.DirAssets, "igrac_iks.png")'"igrac.png")
			img1.Gravity = Gravity.FILL
			img1.Tag = "_"
			karta.Put("@", np)
			img2.Bitmap = kutnamj1'LoadBitmap(File.DirAssets, "kutija_na_mjestu.png")
			img2.Gravity = Gravity.FILL
			img2.Tag = "*"
			Dim xx As Int = pozKutija.IndexOf(np)
			pozKutija.RemoveAt(xx)
			pozKutija.Add(dkp)
			If staraP.EqualsIgnoreCase(".") Then
				img0.Bitmap = mjzakut1' LoadBitmap(File.DirAssets, "iks.png")
				img0.Tag = "."
			Else
'				img0.Background = bkg
				img0.Bitmap = pod1
				img0.Tag = "_"
			End If
			If snd Then'Or mjuzaZid.EqualsIgnoreCase("true") Then
				sounds.Play(bounceId2, 1, 1, 1, 0, 1)
			End If
			brojKoraka = brojKoraka + 1
			brojGuranja = brojGuranja + 1
			If smjer = 1 Then ' gore
				rijesenje = rijesenje & "U"
			else if smjer = 2 Then ' lijevo
				rijesenje = rijesenje & "L"
			else if smjer = 3 Then ' dole
				rijesenje = rijesenje & "D"
			else if smjer = 4 Then ' desno
				rijesenje = rijesenje & "R"
			End If

		else if novaP1.EqualsIgnoreCase(".") And novaP2.EqualsIgnoreCase(".") Or novaP1.EqualsIgnoreCase(".") And novaP2.EqualsIgnoreCase("_") Then
			img1.Bitmap = igrnamj1'LoadBitmap(File.DirAssets, "igrac_iks.png")'"igrac.png")
			img1.Gravity = Gravity.FILL
			img1.Tag = "."
			karta.Put("@", np)
			img2.Bitmap = kutnamj1'LoadBitmap(File.DirAssets, "kutija_na_mjestu.png")
			img2.Gravity = Gravity.FILL
			img2.Tag = "*"
			If staraP.EqualsIgnoreCase(".") Then
				img0.Bitmap = mjzakut1'LoadBitmap(File.DirAssets, "iks.png")
				img0.Tag = "."
			Else
'				img0.Background = bkg
				img0.Bitmap = pod1
				img0.Tag = "_"
			End If
			If snd Then'Or mjuzaZid.EqualsIgnoreCase("true") Then
				sounds.Play(bounceId2, 1, 1, 1, 0, 1)
			End If
			brojKoraka = brojKoraka + 1
			If smjer = 1 Then ' gore
				rijesenje = rijesenje & "u"
			else if smjer = 2 Then ' lijevo
				rijesenje = rijesenje & "l"
			else if smjer = 3 Then ' dole
				rijesenje = rijesenje & "d"
			else if smjer = 4 Then ' desno
				rijesenje = rijesenje & "r"
			End If

		else if novaP1.EqualsIgnoreCase("*") And novaP2.EqualsIgnoreCase(".") Then' Or novaP1.EqualsIgnoreCase("*") And novaP2.EqualsIgnoreCase("*") Then
			img1.Bitmap = igrnamj1'LoadBitmap(File.DirAssets, "igrac_iks.png")'"igrac.png")
			img1.Gravity = Gravity.FILL
			img1.Tag = "."
			karta.Put("@", np)
			img2.Bitmap = kutnamj1'LoadBitmap(File.DirAssets, "kutija_na_mjestu.png")
			img2.Gravity = Gravity.FILL
			img2.Tag = "*"
			Dim xx As Int = pozKutija.IndexOf(np)
			pozKutija.RemoveAt(xx)
			pozKutija.Add(dkp)
			If staraP.EqualsIgnoreCase(".") Then
				img0.Bitmap = mjzakut1'LoadBitmap(File.DirAssets, "iks.png")
				img0.Tag = "."
			Else
'				img0.Background = bkg
				img0.Bitmap = pod1
				img0.Tag = "_"
			End If
			If snd Then'Or mjuzaZid.EqualsIgnoreCase("true") Then
				sounds.Play(bounceId2, 1, 1, 1, 0, 1)
			End If
			brojKoraka = brojKoraka + 1
			brojGuranja = brojGuranja + 1
			If smjer = 1 Then ' gore
				rijesenje = rijesenje & "U"
			else if smjer = 2 Then ' lijevo
				rijesenje = rijesenje & "L"
			else if smjer = 3 Then ' dole
				rijesenje = rijesenje & "D"
			else if smjer = 4 Then ' desno
				rijesenje = rijesenje & "R"
			End If

		else if novaP1.EqualsIgnoreCase("*") And novaP2.EqualsIgnoreCase("_") Then
			img1.Bitmap = igrnamj1'igr1'LoadBitmap(File.DirAssets, "igrac.png")
			img1.Gravity = Gravity.FILL
			img1.Tag = "."
			karta.Put("@", np)
			img2.Bitmap = kutija1'LoadBitmap(File.DirAssets, "kutija.png")
			img2.Gravity = Gravity.FILL
			img2.Tag = "$"
			Dim xx As Int = pozKutija.IndexOf(np)
			pozKutija.RemoveAt(xx)
			pozKutija.Add(dkp)
			If staraP.EqualsIgnoreCase(".") Then
				img0.Bitmap = mjzakut1'LoadBitmap(File.DirAssets, "iks.png")
				img0.Tag = "."
			Else
'				img0.Background = bkg
				img0.Bitmap = pod1
				img0.Tag = "_"
			End If
			brojKoraka = brojKoraka + 1
			brojGuranja = brojGuranja + 1
			If smjer = 1 Then ' gore
				rijesenje = rijesenje & "U"
			else if smjer = 2 Then ' lijevo
				rijesenje = rijesenje & "L"
			else if smjer = 3 Then ' dole
				rijesenje = rijesenje & "D"
			else if smjer = 4 Then ' desno
				rijesenje = rijesenje & "R"
			End If

		Else
			If snd Then'Or mjuzaZid.EqualsIgnoreCase("true") Then
				sounds.Play(bounceId1, 1, 1, 1, 0, 1)
			End If
		End If
	End If

'	UsnimiSnapshotInfo
'	UsnimiSnapshot

'	igraPocela = True
	lblSteps.Text = "Steps: " & brojKoraka
	SetLabelTextSize(lblSteps, lblSteps.Text, 28, 10)
	lblPushes.Text = "Pushes: " & brojGuranja
	SetLabelTextSize(lblPushes, lblPushes.Text, 28, 10)
'	DoEvents
	sv2d.SmoothScrollTo(IzracunajPozicijuX, IzracunajPozicijuY)
'	sv2d.GiveFocusToFirstVisible
End Sub

' provjerava jesu li sve kutije na mjestu gdje bi trebale i biti
Sub ProvjeriKutijeNaMjestu
	If slijedeci = False And prethodni = False Then
		For i = 0 To pozKutijaMjesta.Size - 1
			Dim m1 As String = pozKutijaMjesta.Get(i)
			For j = 0 To pozKutija.Size - 1
				Dim m2 As String = pozKutija.Get(j)
				If m1.Contains(m2) Then
					brJednakihPoz = brJednakihPoz + 1
				End If
			Next
		Next
		Dim x As Int = pozKutijaMjesta.Size
'		Dim sRazina As Int = razina
		If brJednakihPoz = x Then
'			y = y + 1
			Timer1.Enabled = False
			' usnimi riješenje
			UsnimiRijesenje
			' usnimi u bazu info o levelima
			UsnimiInfo
			brJednakihPoz = 0
'			Log(razina)
'			razina = razina + 1
'			Dim xx As Int = Abs(sRazina - razina)
'			'
'			' iz nekog razloga (timer?) dogodi se da se 2x prikaže panel za pobjedu a onda se i slijedeća razina 2x poveća
'			'
'			If xx > 1 Then
'				razina = razina - 1
'				Log("xx -> razina: " & razina)
'			End If
'			If panelGotovo.IsInitialized = False Then
'			If Timer1.Enabled = False Then
				panelGotovo.Initialize("")
				panelGotovo.LoadLayout("all_finished")
				Activity.AddView(panelGotovo, 0, 14%y, 100%x, 100%y - 14%y)
				SetLabelTextSize(Label1, Label1.Text, 40, 8)
				gif.DisposeFrames
				gif.Load(File.DirAssets, "level_finished.gif")
				Frame = 0
				Timer5.Interval = gif.Delay(Frame)
				ImageView1.Bitmap = gif.Frame(Frame)
				Timer5.Enabled = True
'				iad.Show
'			Else
'				panelGotovo.top = 14%y
'				panelGotovo.SetLayout(0, 14%y, 100%x, 100%y - 14%y)
'			End If

			If snd Then'Or mjuzaZid.EqualsIgnoreCase("true") Then
				sounds.Play(bounceId3, 1, 1, 1, 0, 1)
			End If
			' prekini snimanje
			If recB Then
'				Log("recB stop")
'				Timer2.Enabled = False
				rec.StopRecording
'				If Timer4.Enabled Then
'					Timer4.Enabled = False
'					Log(lblCT.Text)
'				End If
'				If norec Then btnRec.Enabled = True
			End If
'			Log("ProvjeriKutijeNaMjestu -> y -> koliko puta je pokrenut panel! -> " & y)
		Else
			brJednakihPoz = 0
		End If
	End If
End Sub

Sub UsnimiRijesenje
	Dim s As String = Main.ime_datoteke_za_info
	s = s.SubString2(0, s.IndexOf("."))

	Log(razina)

	Dim dat As String  = s & ".level_" & (razina+1) & ".mp4.solution"
	Dim sol_info As List

	sol_info.Initialize
	sol_info.Add(Main.zaSolutionIme)
	sol_info.Add(brojKoraka)
	sol_info.Add(brojGuranja)
	sol_info.Add(rijesenje)
'	Log(Starter.SourceFolder & "/" & dat)
	File.WriteList(Starter.SourceFolder, dat, sol_info)	
End Sub

'Sub UcitajRijesenje
'	Dim sol_info As List
'
'	sol_info.Initialize
'	brojKoraka = sol_info.Get(1)
'	brojGuranja = sol_info.Get(2)
'	rijesenje = sol_info.Get(3)
'End Sub

Sub UsnimiInfo
	Dim list_info As List

	list_info.Initialize
'	list_info.Add(pokusaj)
	list_info.Add(razina)
	list_info.Add(ukupno_razina)
	list_info.Add(Main.ime_datoteke_za_info)
	File.WriteList(Starter.SourceFolder, Main.ime_datoteke_za_info & ".info", list_info)
'	Dim stu As StringUtils
'	stu.SaveCSV(File.DirDefaultExternal, odabir.ime_datoteke_za_info & ".info", ",", list_info)
End Sub

Sub UcitajInfo
	Dim list_info As List

	list_info.Initialize
	list_info = File.ReadList(Starter.SourceFolder, Main.ime_datoteke_za_info & ".info")
'	Dim stu As StringUtils
'	list_info = stu.LoadCSV(File.DirDefaultExternal, odabir.ime_datoteke_za_info & ".info", ",")
'	pokusaj = list_info.Get(0)
	razina = list_info.Get(0)
	razina = razina + 1
	ukupno_razina = list_info.Get(1)
	datZaParsanje = list_info.Get(2)
End Sub

'Sub UcitajSnapshotInfo
'	Dim list_info As List
'
'	list_info.Initialize
'	list_info = File.ReadList(Starter.SourceFolder, odabir.ime_datoteke_za_info & ".snapshotinfo")
'	'	pokusaj = list_info.Get(0)
'	razina = list_info.Get(0)
'	ukupno_razina = list_info.Get(1)
'	datZaParsanje = list_info.Get(2)
'	brojGuranja = list_info.Get(3)
'	brojKoraka = list_info.Get(4)
'End Sub
'
'Sub UsnimiSnapshotInfo
'	Dim list_info As List
'
'	list_info.Initialize
'	'	list_info.Add(pokusaj)
'	list_info.Add(razina)
'	list_info.Add(ukupno_razina)
'	list_info.Add(odabir.ime_datoteke_za_info)
'	list_info.Add(brojGuranja)
'	list_info.Add(brojKoraka)
'	File.WriteList(Starter.SourceFolder, odabir.ime_datoteke_za_info & ".snapshotinfo", list_info)
'End Sub
'
'Sub UcitajSnapshot
'	Dim tr As TextReader
'
'	tr.Initialize(File.OpenInput(Starter.SourceFolder, odabir.ime_datoteke_za_info & "_" & razina & ".snapshot"))
'	Dim l As String
'	Do While l <> Null
'		Log(l)
'		l = tr.ReadLine
'	Loop
'	tr.Close
'End Sub
'
'Sub UsnimiSnapshot
'	Dim tw As TextWriter
'	Dim izgledNivoa, sve As String
'	Dim l1 As String = $"<Level Id="${imeLevela.Get(razina)}" Width="${wLevel.Get(razina)}" Height="${hLevel.Get(razina)}">"$ & CRLF
'	Dim l2 As String = "</Level>"
'	sve = l1
'
'	If File.Exists(Starter.SourceFolder, odabir.ime_datoteke_za_info & "_" & razina & ".snapshot") Then
'		File.Delete(Starter.SourceFolder, odabir.ime_datoteke_za_info & "_" & razina & ".snapshot")
'	End If
'
'	tw.Initialize(File.OpenOutput(Starter.SourceFolder, odabir.ime_datoteke_za_info & "_" & razina & ".snapshot", False))
'
'	Dim k As Int = 0
'	For i = 0 To velicinaRetka.Size - 1'izgRazineOdIndeksaPoc To izgRazineDoIndeksaKraj
'		Dim x As Int = velicinaRetka.Get(i)
'		For j = 0 To x - 1
''			Log(karta.GetValueAt(k))
'			Dim s As String = karta.GetKeyAt(k)
'			If s.Contains("@") = False Then
'				Dim iv As ImageView = karta.GetValueAt(k)
'				Dim s As String = iv.tag
'				izgledNivoa = izgledNivoa & s
'				k = k + 1
'			Else
''				Log("pozicija igrača!")
'				k = k + 1
'				j = j - 1
'				Dim iv As ImageView = karta.GetValueAt(k)
'				Dim s As String = iv.tag
'				If s.EqualsIgnoreCase(".") Then
'					izgledNivoa = izgledNivoa & "+"
'				Else
'					izgledNivoa = izgledNivoa & "@"
'				End If
'			End If
'		Next
'		izgledNivoa = izgledNivoa.Replace(izgledNivoa, "<L>" & izgledNivoa & "</L>")
'		izgledNivoa = izgledNivoa & CRLF
'		sve = sve & izgledNivoa
'		izgledNivoa = ""
'	Next
'	sve = sve & sve & l2
'	tw.Write(sve)
'	tw.Close
'End Sub

Sub SetLabelTextSize(lbl As Label, txt As String, MaxFontSize As Float, MinFontSize As Float)
    Dim FontSize = MaxFontSize As Float
    Dim Height As Int
    Dim stu As StringUtils
    
    lbl.TextSize = FontSize
    Height = stu.MeasureMultilineTextHeight(lbl, txt)
    Do While Height > lbl.Height And FontSize > MinFontSize 
        FontSize = FontSize - 1
        lbl.TextSize = FontSize
        Height = stu.MeasureMultilineTextHeight(lbl, txt)
    Loop
End Sub

Sub IzracunajPozicijuX As Int
	Dim iks As Int : Dim yx As String = karta.Get("@") : Dim x1 As Int = yx.SubString(yx.IndexOf(";")+1)

	iks = (x1 - 2) * tWidth
'	stariX = (x1+1) * tWidth
'	Log(stariX)

	Return iks
End Sub

Sub IzracunajPozicijuY As Int
	Dim ipsilon As Int : Dim yx As String = karta.Get("@") : Dim y1 As Int = yx.SubString2(0, yx.IndexOf(";"))

	ipsilon = (y1 - 2) * tWidth
'	stariY = (y1-1) * tWidth
'	Log(stariY)

	Return ipsilon
End Sub

Sub rec_Result(Grant As Boolean)
	'here we check if user granted permission to record the screen
	If Grant = True Then
		Dim s As String = Main.ime_datoteke_za_info
		s = s.SubString2(0, s.IndexOf("."))
'		Log(s & ".level_" & (razina+1))
		DatZaSnimku = s & ".level_" & (razina+1)
		'in this sample-app, I am using the same file-name for all recordings and therefore
		'I delete the previous video-file. Here you will need to implement your own solution
		'in order to make sure the video file-name does not already exist....
		If File.Exists(Starter.SourceFolder, DatZaSnimku & ".mp4") Then
			Dim res As Int = Msgbox2("File exists! Overwrite?", "Warning", "OK", "Cancel", "", LoadBitmap(File.DirAssets, "upitnik.png"))
'			Wait For Msgbox_Result (res As Int)
			If res = DialogResponse.POSITIVE Then
'				Timer2.Enabled = True
				File.Delete(Starter.SourceFolder, DatZaSnimku)
				'Below code starts the recording immediately. A better solution would be to use a timer and perhaps
				'delay the beginning of the screen recording to give user time to reach the app he/she wants to record.
				recB = True
				rec.StartRecording(GetDeviceLayoutValues.Width, GetDeviceLayoutValues.Height, Starter.SourceFolder, DatZaSnimku)
				Timer1.Enabled = True
			End If
		Else
			recB = True
			rec.StartRecording(GetDeviceLayoutValues.Width, GetDeviceLayoutValues.Height, Starter.SourceFolder, DatZaSnimku)
			Timer1.Enabled = True
		End If
	Else
		Msgbox("You did not grant permission to record!", "Warning")
'		If Timer2.Enabled Then Timer2.Enabled = False
		recB = False
		rec.StopRecording
		btnRec.SetBackgroundImage(LoadBitmap(File.DirAssets, "off.png"))
		Timer1.Enabled = False
'		lbl1.Visible = False
	End If
	Log(Starter.SourceFolder & "/" & DatZaSnimku)
End Sub

Sub GetSDK() As Int
    Dim p As Phone

    Return p.SdkVersion
End Sub

Sub GetSDKversion() As String
    Dim versions As Map

    versions.Initialize
    versions.Put(3,"1.5")
    versions.Put(4,"1.6")
    versions.Put(7,"2.1")
    versions.Put(8,"2.2")
    versions.Put(10,"2.3.3")
    versions.Put(11,"3.0")
    versions.Put(12,"3.1")
    versions.Put(13,"3.2")
    versions.Put(14,"4.0")
    versions.Put(15,"4.0.3")
    versions.Put(16,"4.1.2")
    versions.Put(17,"4.2.2")
    versions.Put(18,"4.3")
    versions.Put(19,"4.4.2")
    Dim p As Phone

    Return versions.Get(p.SdkVersion)
End Sub

'
' You can use this sub to scale a view:
'
' You can use it to scale all the child views. It will not be automatic.
'Sub ScaleView(v As View, Scale As Float)
'	Dim jo As JavaObject = v
'	jo.RunMethod("setScaleX", Array(Scale))
'	jo.RunMethod("setScaleY", Array(Scale))
'End Sub

Sub btnInfo_Click
	Dim cd As ColorDrawable

	pnlInfo.RequestFocus

	If pnl_info_vidljiv Then
		'		pnlInfo.Top = -(pnlInfo.Height) + 8%x
		pnlInfo.SetLayoutAnimated(500, (100%x - pnlInfo.Width) / 2, -(pnlInfo.Height) + 8%x, pnlInfo.Width, pnlInfo.Height)
		pnl_info_vidljiv = False
		cd.Initialize(Colors.ARGB(0, 0, 0, 0), 0)
		pnlInfo.Background = cd
	Else
		'		pnlInfo.Top = 0
		pnlInfo.SetLayoutAnimated(500, (100%x - pnlInfo.Width) / 2, 0, pnlInfo.Width, pnlInfo.Height)
		pnl_info_vidljiv = True
		cd.Initialize(Colors.ARGB(128, 0, 0, 255), 0)
		pnlInfo.Background = cd
	End If
End Sub

Sub sensor_SensorChanged(Values() As Float)
	Azimuth = Values(0)
	Pitch = Values(1)
	Roll = Values(2)
End Sub

Sub PomakniUSmjeru(smjer As String)
	Dim redak, stupac As Int : Dim cd As ColorDrawable
	
	cd.Initialize(Colors.RGB(115, 175, 199), 0)

	Select smjer
		Case "gore"
		' gore
			redak = -1
			' pozicija igrača
			Dim staraPoz As String = karta.Get("@")

			' slijedeća pozicija
			Dim npt1 As String = staraPoz.SubString2(0, staraPoz.IndexOf(";"))
			Dim npt2 As Int = npt1 + redak
			Dim novaPoz As String = npt2 & staraPoz.SubString(staraPoz.IndexOf(";"))

			' pozicija dva mjesta od igrača
			Dim npt1 As String = novaPoz.SubString2(0, novaPoz.IndexOf(";"))
			Dim npt2 As Int = npt1 + redak
			Dim drugaKutijaPoz As String = npt2 & novaPoz.SubString(novaPoz.IndexOf(";"))

			ProvjeriIPomakni(staraPoz, novaPoz, drugaKutijaPoz, 1)', cd)

		' lijevo
		Case "lijevo"
			' umanjujemo stupac
			stupac = -1
			' pozicija igrača
			Dim staraPoz As String = karta.Get("@")

			' slijedeća pozicija
			Dim npt1 As String = staraPoz.SubString(staraPoz.IndexOf(";")+1)
			Dim npt2 As Int = npt1 + stupac
			Dim novaPoz As String = staraPoz.SubString2(0, staraPoz.IndexOf(";")+1) & npt2

			' pozicija dva mjesta od igrača
			Dim npt1 As String = novaPoz.SubString(novaPoz.IndexOf(";")+1)
			Dim npt2 As Int = npt1 + stupac
			Dim drugaKutijaPoz As String = novaPoz.SubString2(0, novaPoz.IndexOf(";")+1) & npt2

			ProvjeriIPomakni(staraPoz, novaPoz, drugaKutijaPoz, 2)', cd)

		Case "desno"
		' desno
			' uvećavamo stupac
			stupac = 1
			' pozicija igrača
			Dim staraPoz As String = karta.Get("@")

			' slijedeća pozicija
			Dim npt1 As String = staraPoz.SubString(staraPoz.IndexOf(";")+1)
			Dim npt2 As Int = npt1 + stupac
			Dim novaPoz As String = staraPoz.SubString2(0, staraPoz.IndexOf(";")+1) & npt2

			' pozicija dva mjesta od igrača
			Dim npt1 As String = novaPoz.SubString(novaPoz.IndexOf(";")+1)
			Dim npt2 As Int = npt1 + stupac
			Dim drugaKutijaPoz As String = novaPoz.SubString2(0, novaPoz.IndexOf(";")+1) & npt2
				
			ProvjeriIPomakni(staraPoz, novaPoz, drugaKutijaPoz, 4)', cd)

		Case "dole"
			' dole
			redak = 1

			' pozicija igrača
			Dim staraPoz As String = karta.Get("@")

			' slijedeća pozicija
			Dim npt1 As String = staraPoz.SubString2(0, staraPoz.IndexOf(";"))
			Dim npt2 As Int = npt1 + redak
			Dim novaPoz As String = npt2 & staraPoz.SubString(staraPoz.IndexOf(";"))

			' pozicija dva mjesta od igrača
			Dim npt1 As String = novaPoz.SubString2(0, novaPoz.IndexOf(";"))
			Dim npt2 As Int = npt1 + redak
			Dim drugaKutijaPoz As String = npt2 & novaPoz.SubString(novaPoz.IndexOf(";"))

			ProvjeriIPomakni(staraPoz, novaPoz, drugaKutijaPoz, 3)', cd)
	End Select

	sv2d.SmoothScrollTo(IzracunajPozicijuX, IzracunajPozicijuY)
End Sub

Sub btn_LongClick
	Dim send As View

	send = Sender
	Select send.Tag
		Case "sound"
'			Log("longclick sound!")
			Msgbox("Sound on/off", "Info")
		Case "record"
'			Log("longclick record!")
			Msgbox("Record on/off", "Info")
		Case "reset"
'			Log("longclick reset!")
			Msgbox("Reset level", "Info")
		Case "natrag"
			Msgbox("Undo move", "Info")
'		Case "tajmer"
'			Log("longclick tajmer!")
'			Msgbox("Timer on/off", "Info")
	End Select
End Sub

Sub sv2d_Touch(o As Object, ACTION As Int, x As Float, y As Float, motion As Object) As Boolean'(viewtag As Object, action As Int, x As Float, Y As Float, motionevent As Object) As Boolean
	Dim mOpcije As Map
	Dim rb3 As Boolean
	mOpcije = File.ReadMap(Starter.SourceFolder, "opcije")
	rb3 = mOpcije.Get("rb3")

	If Timer1.Enabled = False Then Timer1.Enabled = True
'	Log(motion)
	'
	'
	'https://www.b4x.com/android/forum/threads/classes-are-soon-coming.18395/#content -> draggable view
	'
	'
	If ACTION = ACTION_DOWN And rb3 Then
		Dim stvarniX As Int = Round(x) + sv2d.HorizontalScrollPosition' + x3
		Dim stvarniY As Int = Round(y) + sv2d.VerticalScrollPosition' + x3
		Dim iksNovi As Int = (stvarniX -x3) / tWidth' + x3'(tWidth + x3)
'		Log(iksNovi)
		Dim ipsilonNovi As Int = stvarniY / tWidth'(tWidth + x3)
'		Log(ipsilonNovi)
		Dim s As String = karta.Get("@")
		Dim iks As Int = s.SubString(s.IndexOf(";")+1)
'		Log(iks)
		Dim ipsilon As Int = s.SubString2(0, s.IndexOf(";"))
'		Log(ipsilon)
		Dim razlikaX As Int = Abs(iks - iksNovi)
		Dim razlikaY As Int = Abs(ipsilon - ipsilonNovi)
		If iksNovi < iks And razlikaX = 1 And razlikaY = 0 Then ' lijevo
			PomakniUSmjeru("lijevo")
		else if iksNovi > iks And razlikaX = 1 And razlikaY = 0 Then ' desno
			PomakniUSmjeru("desno")
		else if ipsilonNovi < ipsilon And razlikaY = 1 And razlikaX = 0 Then ' gore
			PomakniUSmjeru("gore")
		else if ipsilonNovi > ipsilon And razlikaY = 1 And razlikaX = 0 Then ' dole
			PomakniUSmjeru("dole")
		End If
	End If
	Return False
End Sub

Sub btnOK_Click
	Log(rijesenje)
	rijesenje = ""
	Log(razina)
	razina = razina + 1
	If razina = ukupno_razina Then
		If snd Then'Or mjuzaZid.EqualsIgnoreCase("true") Then
			sounds.Play(bounceId4, 1, 1, 1, 0, 1)
		End If
		Msgbox("All levels solved", "Congratulations")
'		Timer1.Enabled = False
		Timer5.Enabled = False
'		panelGotovo.Top = 100%y
		panelGotovo.RemoveView
		Activity.Finish
	Else
'		Timer1.Enabled = False
		Timer5.Enabled = False
'		panelGotovo.Top = 100%y
		panelGotovo.RemoveView
		Log("btnOK_Click: " & razina)
		' slijedeći nivo
		izgRazineOdIndeksaPoc = izgRazineDoIndeksaKraj + 1
		izgRazineDoIndeksaKraj = izgRazineDoIndeksaKraj + hLevel.Get(razina)
		KreirajNivo
	End If
End Sub

'Sub sensor_SensorChanged (Values() As Float)
'	Shake.HandleSensorEvent(Values)
''	Log(Values(0))
''	Log(Values(1))
''	Log(Values(2))
'End Sub
'
'Sub Shake
'	Log("šejk")
'End Sub