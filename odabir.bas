Type=Activity
Version=6.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: false
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim slc_parse As SaxParser
	Dim imeLevela As Map
	Dim datZaParsanjeRazina As String
	Dim brojLevela As Int = 0
	Dim ime_datoteke_za_info As String
	Dim ime_dat_za_video As String
	Dim listaDatZaVideo As List
	Dim zaSolutionIme As String
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Dim Title, Description, Email, Url, Autor, brojRazina As List
	Private cvOdabir As CustomListView
	Dim slovoOdabira As String
	Private lblTitleAutor As Label
'	Private lblDesc As Label
	Private imgWWW As ImageView
	Private imgPlay As ImageView
	Private imgEmail As ImageView
	Private lblInfo As Label
	Dim ime_dat As List
	Private imgDelete As ImageView
	Private imgInfo As ImageView
	Private imgSolution As ImageView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("lista")

	slovoOdabira = Main.gumb.ToLowerCase

	slc_parse.Initialize
	listaDatZaVideo.Initialize
	imeLevela.Initialize	' ime razine
	Title.Initialize
	Description.Initialize
	Email.Initialize
	Url.Initialize
	Autor.Initialize
	brojRazina.Initialize
	ime_dat.Initialize

	OtvoriIzBaze
End Sub

Sub Activity_Resume
	Dim ph As Phone

	ph.SetScreenOrientation(0)

	If cvOdabir.IsInitialized Then
		Log("cvOdabir.IsInitialized")
		cvOdabir.Clear
		UbaciUListu
	End If
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

'
'
' nešto te štima sa RLDecode...
'
'
'Sub RLDecode(s As String) As String
''	Dim curs As Cursor
'	Dim m, rCount, outP As String
'	Dim sf As StringFunctions
'
'	sf.Initialize
'
'	For i = 1 To s.Length' - 1
'		m = sf.mid(s, i, 1)'s.SubString2(i, i+1)
'		Select m
'			Case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
'				rCount = rCount & m
'			Case Else
'				If rCount.Length <> 0 Then
'					outP = outP & rCount & m'm.SubString(rCount)
'					rCount = ""
'				Else
'					outP = outP & m
'				End If
'		End Select
'	Next
'
'	Return outP
'End Sub
'
'Sub RLEncode(s As String) As String
'	Dim tmp1, tmp2, outP As String
'	Dim rCount As Int
'	Dim sf As StringFunctions
'
'	sf.Initialize
'
'	tmp1 = sf.mid(s, 1, 1)
'	tmp2 = tmp1
'	rCount = 1
'
'	For i = 2 To s.Length' - 1
'		tmp1 = sf.Mid(s, i, 1)
'		If tmp1 <> tmp2 Then
'			outP = outP & rCount & tmp2
'			tmp2 = tmp1
'			rCount = 1
'		Else
'			rCount = rCount + 1
'		End If
'	Next
'	outP = outP & rCount
'	outP = outP & tmp2
'
'	Return outP
''	RLEncode(outP)
'End Sub

'Sub osvjezi
'	If play.juzer_klouzed Then
'		Log("juzer klouzd!")
'		OtvoriIzBaze
'	End If
'End Sub

Sub OtvoriIzBaze
	Dim curs As Cursor
'	Dim l1 As List
	Title.Clear
	Description.Clear
	Email.Clear
	Url.Clear
	Autor.Clear
	brojRazina.Clear
	ime_dat.Clear

'	ProgressDialogShow("Učitavam razine...")
	If slovoOdabira.StartsWith("#") Then
		Dim q As String = "SELECT title, autor, desc, email, url, brojRazina, imeDat FROM " & Starter.DBFileName & " WHERE imeDat GLOB '[1-9]*'"
'		Log(q)
	Else
		Dim q As String = "SELECT title, autor, desc, email, url, brojRazina, imeDat FROM " & Starter.DBFileName & " WHERE imeDat LIKE '" & slovoOdabira & "%'"
	End If
	curs = Starter.upit.ExecQuery(q)
	If curs.RowCount > 0 Then
		For i = 0 To curs.RowCount-1
			curs.Position = i
			Title.Add(curs.GetString("title"))
			Autor.Add(curs.GetString("autor"))
			Description.Add(curs.GetString("desc"))
			Email.Add(curs.GetString("email"))
			Url.Add(curs.GetString("url"))
			brojRazina.Add(curs.GetString("brojRazina"))
			ime_dat.Add(curs.GetString("imeDat"))
		Next
	Else
		Msgbox("No level packs!", "Info")
		Activity.Finish
	End If
		
'	l1.Initialize
'	Dim s As String = "SELECT imeDat, datoteka FROM " & Starter.DBFileName & " WHERE imeDat LIKE '" & slovoOdabira & "%'"
''	Log(s)
'	curs = Starter.upit.ExecQuery(s)
'	If curs.RowCount > 0 Then
'		For i = 0 To curs.RowCount - 1
'			curs.Position = i
''			Log(curs.GetString("imeDat"))
''			Log(curs.GetString("datoteka"))
'			datLista.Add(curs.GetString("imeDat"))
'			l1.Add(curs.GetString("datoteka"))
'		Next
'	Else
'		Msgbox("Nema ništa!", "Info")
'		Activity.Finish
'	End If
'
'	For i = 0 To l1.Size - 1
'		ParsajSLC(l1.Get(i))
'		brojDat = i
'	Next
'	For i = 0 To l1.Size - 1
''		Log("UPDATE db SET title = '" & Title.Get(i) & "', desc = '" & Description.Get(i) & "', email = '" & Email.Get(i) & "', url = '" & Url.Get(i) & "', autor = '" & Autor.Get(i) & "' WHERE imeDat = '" & l1.Get(i) & "'")
''		Starter.upit.ExecNonQuery("UPDATE db SET title = '" & Title.Get(i) & "', desc = '" & Description.Get(i) & "', email = '" & Email.Get(i) & "', url = '" & Url.Get(i) & "', autor = '" & Autor.Get(i) & "' WHERE imeDat = '" & datLista.Get(i) & "'")
'	Next
	UbaciUListu
'	ProgressDialogHide

'	DBUtils.ExecuteMap(Starter.upit, 
End Sub

'Sub OtvoriDatRazina
'	Dim tmpList As List
'
'	tmpList.Initialize
'	tmpList = File.ListFiles(File.DirAssets)
'	ProgressDialogShow("Otvaram razine...")
'	For i = 0 To tmpList.Size - 1
'		Dim s As String = tmpList.Get(i)
'		If s.StartsWith(Main.gumb.ToLowerCase) And s.EndsWith(".slc") Then
'			lvlTitleList.Add(s)
'			ParsajSLC(s)
'			UbaciUBazu
'		End If
'	Next
'	UbaciUListu
'	ProgressDialogHide
'End Sub
'
'Sub UbaciUBazu
'	
'End Sub

'Sub slc_StartElement (Uri As String, Name As String, Attributes As Attributes)
''	Log(brojDat)
'	If Name = "Level" Then
''		Log(Attributes.GetValue2("","Id"))
'		If Attributes.GetValue2("","Id").Length > 0 Then
'			brojLevela = brojLevela + 1
''			Log(brojLevela)
''			imeLevela.Add(Attributes.GetValue2("","Id"))
'			imeLevela.Put(brojDat, Attributes.GetValue2("","Id"))
'		Else
''			imeLevela.Add("No Name")
'			imeLevela.Put(brojDat, "No Level Name")
'		End If
'		If Attributes.GetValue2("","Width").Length > 0 Then
'			wLevel.Add(Attributes.GetValue2("","Width"))
''			wLevel.put(brojDat, Attributes.GetValue2("","Width"))
'		Else
'			wLevel.Add("?")
''			wLevel.put(brojDat, "?")
'		End If
'		If Attributes.GetValue2("","Height").Length > 0 Then
'			hLevel.Add(Attributes.GetValue2("","Height"))
''			hLevel.put(brojDat, Attributes.GetValue2("","Height"))
'		Else
'			hLevel.Add("?")
''			hLevel.put(brojDat, "?")
'		End If
'
'	else if Name = "LevelCollection" Then
''	If Name = "LevelCollection" Then
'		If Attributes.GetValue2("","Copyright").Length > 0 Then
''			Autor = Attributes.GetValue2("","Copyright")
''			Autor.Add(Attributes.GetValue2("","Copyright"))
'			Autor.Put(brojDat, Attributes.GetValue2("","Copyright"))
'		Else
''			Autor = "No Name"
''			Autor.Add("No Name")
'			Autor.Put(brojDat, "No Author")
'		End If
'	End If
'End Sub
'
'Sub slc_EndElement(Uri As String, Name As String, text As StringBuilder)
'    If slc_parse.Parents.IndexOf("SokobanLevels") > -1 Then
'        If Name = "Title" Then
''			Log(text.ToString)
'			If text.ToString.Length > 0 Then
''				Title = text.ToString
''				Title.Add(text.ToString)
'				Title.Put(brojDat, text.ToString)
'			Else
''				Title = "n/a"
''				Title.Add("n/a")
'				Title.Put(brojDat, "No Title")
'			End If
'
'		else if Name = "Description" Then
''			Log(text.ToString)
'			If text.ToString.Length > 0 Then
''				Description = text.ToString
''				Description.Add(text.ToString)
'				Description.Put(brojDat, text.ToString)
'			Else
''				Description = "No Description"
''				Description.Add("No Description")
'				Description.Put(brojDat, "No Description")
'			End If
'		else if Name = "Email" Then
''			Log(text.ToString)
'			If text.ToString.Length > 0 Then
''				Email = text.ToString
''				Email.Add(text.ToString)
'				Email.Put(brojDat, text.ToString)
'			Else
''				Email = "No Email"
''				Email.Add("n/a")
'				Email.Put(brojDat, "No Email")
'			End If
'		else if Name = "Url" Then
''			Log(text.ToString)
'			If text.ToString.Length > 0 Then
''				Url = text.ToString
''				Url.Add(text.ToString)
'				Url.Put(brojDat, text.ToString)
'			Else
''				Url = "No URL"
''				Url.Add("n/a")
'				Url.Put(brojDat, "No URL")
'			End If
'		End If
'	End If
'
'    If slc_parse.Parents.IndexOf("LevelCollection") > -1 Then
'		If Name = "L" Then
''			Log(text.ToString)
'			izgledLevela.Add(text.ToString)
''			izgledLevela.put(brojDat, text.ToString)
'		End If
'	End If
'End Sub
'
'Sub ParsajSLC(datSLC As String)
''	izgledLevela.Clear
''	imeLevela.Clear
''	wLevel.Clear
''	hLevel.Clear
'
''	Dim fo As InputStream = File.OpenInput(File.DirAssets, datSLC)
''	slc_parse.Parse(fo, "slc")
'
'	Dim bytes() As Byte = datSLC.GetBytes("utf8")
'	Dim ins As InputStream
'	ins.InitializeFromBytesArray(bytes, 0, bytes.Length)
'	slc_parse.Parse(ins, "slc")
'
''	Log(brojLevela)
'	brLevela.Add(brojLevela)
'	brojLevela = 0
''	brojDat = 0
'End Sub

Sub UbaciUListu
	For i = 0 To Title.Size - 1
		cvOdabir.Add(CreateListItem(Title.Get(i) & " by " & Autor.Get(i), Description.Get(i), ime_dat.Get(i), brojRazina.Get(i), cvOdabir.AsView.Width, 10%x), 10%x, "")
	Next
End Sub

Sub CreateListItem(t1 As String, t2 As String, ime_d As String, br As String, Width As Int, Height As Int) As Panel
	Dim p As Panel

	p.Initialize("")
	p.Color = Colors.Black
	'we need to add the panel to a parent to set its dimensions. It will be removed after the layout is loaded.
	Activity.AddView(p, 0, 0, Width, Height)
	p.LoadLayout("stavka")
	p.RemoveView

	lblTitleAutor.Text = t1
	SetLabelTextSize(lblTitleAutor, lblTitleAutor.Text, 14, 8)
'	t2 = t2.Replace(CRLF, " ")
'	lblDesc.Text = t2
'	SetLabelTextSize(lblDesc, lblDesc.Text, 14, 8)
	If File.Exists(File.DirInternal, ime_d & ".info") Then
		Log("info postoji!")
		Dim list_info As List
		list_info.Initialize
		list_info = File.ReadList(File.DirInternal, ime_d & ".info")
		Dim x As Int = list_info.Get(0)
		x = x + 1
		lblInfo.Text = "Finished: " & x & "/" & list_info.Get(1)'list_info.Get(0) & "/" & list_info.Get(1)
	Else
		lblInfo.Text = "Finished: 0/" & br
	End If
	SetLabelTextSize(lblInfo, lblInfo.Text, 18, 8)

	Return p
End Sub

Sub imgEmail_Click
	Dim index As Int

	index = cvOdabir.GetItemFromView(Sender)
	
	Dim s As String = Email.Get(index)
	If s.Length > 0 Then
		Log(Email.Get(index))
		Dim res As Int = Msgbox2("Send e-mail to author?", "Question", "Yes", "", "No", LoadBitmapSample(File.DirAssets, "upitnik.png", 32dip, 32dip))
'		Wait For Msgbox_Result (res As Int)
		If res = DialogResponse.POSITIVE Then
			Dim intent1 As Intent
			intent1.Initialize(intent1.ACTION_VIEW, "mailto:" & Email.Get(index))
			StartActivity(intent1)
		End If
	Else
		Msgbox("No email!", "Info")
	End If
End Sub

Sub imgWWW_Click
	Dim index As Int
	Dim p As PhoneIntents

	index = cvOdabir.GetItemFromView(Sender)

	Dim s As String = Url.Get(index)
	If s.Length > 0 Then
		Dim res As Int = Msgbox2("Open in browser?", "Question", "Yes", "", "No", LoadBitmapSample(File.DirAssets, "upitnik.png", 32dip, 32dip))
'		Wait For Msgbox_Result (res As Int)
		If res = DialogResponse.POSITIVE Then
			Log(Url.Get(index))
			StartActivity(p.OpenBrowser(Url.Get(index)))
		End If
	Else
		Msgbox("No URL!", "Info")
	End If
End Sub

Sub imgPlay_Click
	Dim index As Int
	Dim curs As Cursor

	index = cvOdabir.GetItemFromView(Sender)
	Dim s As String = Title.Get(index)
	If s.Contains("'") Then s = s.Replace("'", "''")
	Log("odabir -> imgPlay_Click -> Title -> " & s & " by " & Autor.Get(index))
	zaSolutionIme = s & " by " & Autor.Get(index)
	Dim q As String = "SELECT imeDat, brojRazina, datoteka FROM " & Starter.DBFileName & " WHERE title = '" & s & "'"
	curs = Starter.upit.ExecQuery(q)
	If curs.RowCount > 0 Then
		For i = 0 To curs.RowCount-1
			curs.Position = i
'			Log(curs.GetString("brojRazina"))
			brojLevela = curs.GetString("brojRazina")
'			Log(curs.GetString("datoteka"))
			datZaParsanjeRazina = curs.GetString("datoteka")
			ime_datoteke_za_info = curs.GetString("imeDat")
'			Log(curs.GetString("imeDat"))
		Next
	Else
		Msgbox("No levels for choosen letter!", "Info")
		Activity.Finish
	End If

	StartActivity(play)
End Sub

Sub imgInfo_Click
	Dim index As Int

	index = cvOdabir.GetItemFromView(Sender)
	Dim s As String = Description.Get(index)
	s = s.Replace(CRLF, " ")
	Msgbox(s, "Levels info")
End Sub

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

Sub imgDelete_Click
	Dim index As Int
	Dim curs As Cursor

	index = cvOdabir.GetItemFromView(Sender)
	Dim q As String = "SELECT imeDat, brojRazina FROM " & Starter.DBFileName & " WHERE title = '" & Title.Get(index) & "'"
	curs = Starter.upit.ExecQuery(q)
	If curs.RowCount > 0 Then
		For i = 0 To curs.RowCount-1
			curs.Position = i
			Dim ime_datoteke As String = curs.GetString("imeDat")
			Dim bl As String = curs.GetString("brojRazina")
		Next
	End If

	Dim res As Int = Msgbox2("Really delete stats?", "Warning", "Yes", "", "No", LoadBitmapSample(File.DirAssets, "upitnik.png", 32dip, 32dip))
'	Wait For Msgbox_Result (res As Int)
	If res = DialogResponse.POSITIVE Then
		' ime_datoteke
		If File.Exists(File.DirInternal, ime_datoteke & ".info") Then
			File.Delete(File.DirInternal, ime_datoteke & ".info")
			Dim pnl As Panel
			pnl = cvOdabir.GetPanel(index)
			Dim lbl As Label
			lbl = pnl.GetView(7)
			lbl.Text = "Finished: 0/" & bl
		Else
			Msgbox("No stats for delete!", "Warning")
		End If
	End If
End Sub

Sub imgVideo_Click
	Dim index As Int
	Dim curs As Cursor

	index = cvOdabir.GetItemFromView(Sender)
	Dim s As String = Title.Get(index)
	If s.Contains("'") Then s = s.Replace("'", "''")
	Dim q As String = "SELECT imeDat FROM " & Starter.DBFileName & " WHERE title = '" & s & "'"
	curs = Starter.upit.ExecQuery(q)
	If curs.RowCount > 0 Then
		For i = 0 To curs.RowCount-1
			curs.Position = i
			ime_dat_za_video = curs.GetString("imeDat")
		Next
		ime_dat_za_video = ime_dat_za_video.SubString2(0, ime_dat_za_video.IndexOf("."))
	End If

	OtvoriVideoDat
	If listaDatZaVideo.Size > 0 Then
		StartActivity(video)
	Else
		Msgbox("No video files!", "Info")
	End If
End Sub

Sub imgSolution_Click
	Dim index As Int

	index = cvOdabir.GetItemFromView(Sender)
	Dim s As String = Title.Get(index)
	If s.Contains("'") Then s = s.Replace("'", "''")
	Log("odabir -> imgSolution_Click -> Title -> " & s & " by " & Autor.Get(index))
	zaSolutionIme = s & " by " & Autor.Get(index)

	StartActivity(rijesenja)
End Sub

Sub OtvoriVideoDat
	Dim tmpList As List

	listaDatZaVideo.Clear

	tmpList.Initialize
	tmpList = File.ListFiles(File.DirInternal)
	For i = 0 To tmpList.Size - 1
		Dim s As String = tmpList.Get(i)
		If s.StartsWith(ime_dat_za_video) And s.EndsWith(".mp4") Then
			listaDatZaVideo.Add(s)
'			spn.Add(s)
		End If
	Next
End Sub

Sub imgWWW_LongClick
	Msgbox("Author website", "Info")
End Sub

Sub imgEmail_LongClick
	Msgbox("Send email to author", "Info")
End Sub

Sub imgPlay_LongClick
	Msgbox("Start playing levels", "Info")
End Sub

Sub imgDelete_LongClick
	Msgbox("Delete stats for all levels", "Info")
End Sub

Sub imgVideo_LongClick
	Msgbox("Watch saved video", "Info")
End Sub

Sub imgInfo_LongClick
	Msgbox("Shows more info about level pack", "Info")
End Sub

Sub imgSolution_LongClick
	Msgbox("Check for solution online", "Info")
End Sub

'Sub lblTitleAutor_Click
'	Dim index As Int
'	Dim curs As Cursor
'
'	index = cvOdabir.GetItemFromView(Sender)
'	Dim s As String = Title.Get(index)
'	If s.Contains("'") Then s = s.Replace("'", "''")
'	Dim q As String = "SELECT imeDat FROM " & Starter.DBFileName & " WHERE title = '" & s & "'"
'	curs = Starter.upit.ExecQuery(q)
'	If curs.RowCount > 0 Then
'		For i = 0 To curs.RowCount-1
'			curs.Position = i
'			ime_dat_za_video = curs.GetString("imeDat")
'		Next
'		ime_dat_za_video = ime_dat_za_video.SubString2(0, ime_dat_za_video.IndexOf("."))
'	End If
'
'	OtvoriVideoDat
'	If listaDatZaVideo.Size > 0 Then
'		StartActivity(video)
'	Else
'		Msgbox("No video files!", "Info")
'	End If
'End Sub
'
'Sub lblTitleAutor_LongClick
'	Msgbox("View/Send/Download solution(s)", "Info")
'End Sub