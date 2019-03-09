Type=Activity
Version=6.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private CheckBox1 As CheckBox
'	Private CheckBox2 As CheckBox
'	Private Label1 As Label
'	Private Spinner1 As Spinner
'	Dim imeDat As List
'	Dim title, copy, email, slika As String
'	Private Label2 As Label
'	Private ImageView1 As ImageView
	Dim arch As Archiver
'	Dim listaDatoteka As List
'	Dim listaDatotekaZaUnzip() As String
	Dim cb As Boolean
'	Dim rb2, rb3, rb4 As Boolean
	Dim rb2, rb3, rb4 As Boolean
	Dim spn As String
	Private spnSkin As Spinner
	Private imgPreview As ImageView
	Private btnSkinLic As Button
	Dim mOpcije As Map
	Private lblSkinInfo As Label
	Private Label2 As Label
	Private btnDelSkin As Button
	Dim zid1, kutija1, kutnamj1, mjzakut1, pod1, igr1, igrnamj1 As String
	Private ImageView1 As ImageView
	Private ImageView2 As ImageView
	Private ImageView3 As ImageView
	Private ImageView4 As ImageView
	Private ImageView5 As ImageView
	Private ImageView6 As ImageView
	Private ImageView7 As ImageView
	Private ImageView8 As ImageView
	Private ImageView9 As ImageView
	Private ImageView10 As ImageView
	Private ImageView11 As ImageView
	Private ImageView12 As ImageView
	Private ImageView13 As ImageView
	Private ImageView14 As ImageView
	Private ImageView15 As ImageView
	Private ImageView16 As ImageView
	Private ImageView17 As ImageView
	Private ImageView18 As ImageView
	Private ImageView19 As ImageView
	Private ImageView20 As ImageView
	Private ImageView21 As ImageView
	Private ImageView22 As ImageView
	Private ImageView23 As ImageView
	Private ImageView24 As ImageView
	Private ImageView25 As ImageView
	Private ImageView26 As ImageView
	Private ImageView27 As ImageView
	Private ImageView28 As ImageView
	Private ImageView29 As ImageView
	Private ImageView30 As ImageView
	Private ImageView31 As ImageView
	Dim ivs(31) As ImageView
	Dim sv As ScrollView
	Private Label1 As Label
	Private RadioButton1 As RadioButton
	Private RadioButton2 As RadioButton
	Private RadioButton3 As RadioButton
'	Private Label3 As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	sv.Initialize(1000dip)
	Activity.AddView(sv, 0, 0, 100%x, 100%y)
	sv.Panel.LoadLayout("opt")
	sv.Panel.Height = RadioButton1.Height + CheckBox1.Height + RadioButton2.Height + RadioButton3.Height + Label1.Height + spnSkin.Height + lblSkinInfo.Height + ImageView1.Height + ImageView6.Height + _
					  ImageView11.Height + ImageView18.Height + ImageView25.Height + Label2.Height' + 10%y

	ivs = Array As ImageView (ImageView1, ImageView2, ImageView3, ImageView4, ImageView5, ImageView6, ImageView7, ImageView8, ImageView9, ImageView10, _
							  ImageView11, ImageView12, ImageView13, ImageView14, ImageView15, ImageView16, ImageView17, ImageView18, ImageView19, ImageView20, _
							  ImageView21, ImageView22, ImageView23, ImageView24, ImageView25, ImageView26, ImageView27, ImageView28, ImageView29, ImageView30, _
							  ImageView31)

	If File.Exists(File.DirInternal, "skins.zip") = False Then
		File.Copy(File.DirAssets, "skins.zip", File.DirInternal, "skins.zip")
		RaspakirajSkinoveIzArhive
	End If

	'
	'
	' obrisati Neon folder sa skinom jer stvara probleme
	'
	'
	Dim f As String
	If File.Exists(File.DirInternal, "/skins/Neon") Then
		Dim l As List = File.ListFiles(File.DirInternal & "/skins/Neon")
		For i = 0 To l.Size - 1
			f = l.Get(i)
			File.Delete(File.DirInternal & "/skins/Neon/", f)
		Next
		File.Delete(File.DirInternal & "/skins/", "Neon")
	End If


	Log(File.DirInternal & "/skins")
	Dim l As List = ProcitajSveFoldereUSkinDir(File.DirInternal & "/skins")
	For i = 0 To l.Size - 1
		spnSkin.Add(l.Get(i))
	Next

	mOpcije = File.ReadMap(File.DirInternal, "opcije")
	cb = mOpcije.Get("cb")
	rb2 = mOpcije.Get("rb2")
	rb3 = mOpcije.Get("rb3")
	rb4 = mOpcije.Get("rb4")
	spn = mOpcije.Get("skin")
	If cb Then
		CheckBox1.Checked = True
	Else
		CheckBox1.Checked = False
	End If
	If rb2 Then
		RadioButton1.Checked = True
	Else
		RadioButton1.Checked = False
	End If
	spnSkin.SelectedIndex = spnSkin.IndexOf(spn)

	If rb3 Then
		RadioButton2.Checked = True
	Else
		RadioButton2.Checked = False
	End If

	If rb4 Then
		RadioButton3.Checked = True
	Else
		RadioButton3.Checked = False
	End If
	Dim s As String = spnSkin.SelectedItem

	If s.StartsWith("1") Then
		lblSkinInfo.Visible = False
		imgPreview.Visible = True
		btnSkinLic.Visible = True
		Label2.Visible = True
		Dim bmp As Bitmap = LoadBitmap(File.DirInternal & "/skins" & "/" & s, s.SubString(1) & "-preview-simple.png")
		imgPreview.Bitmap = bmp
		imgPreview.Width = DipToCurrent(bmp.Width)
		imgPreview.Height = DipToCurrent(bmp.Height)
		imgPreview.Left = (100%x - imgPreview.Width) / 2
		For i = 0 To ivs.Length - 1
			ivs(i).Visible = False
		Next
	Else
		Dim name, author, desc, web, email As String
		lblSkinInfo.Visible = True
		imgPreview.Visible = False
		btnSkinLic.Visible = False
		Label2.Visible = False
		For i = 0 To ivs.Length - 1
			ivs(i).Visible = True
		Next
		name = mOpcije.Get("name")
		author = mOpcije.Get("author")
		desc = mOpcije.Get("desc")
		web = mOpcije.Get("web")
		email = mOpcije.Get("email")
		lblSkinInfo.Text = "Name: " & name & CRLF & "Author: " & author & CRLF & "Description: " & desc & CRLF & "Web: " & web & CRLF & "Email: " & email
'		Dim zid, kutija, kutnamj, mjzakut, pod, igr, igrnamj As String
		zid1 = mOpcije.Get("zid")
		kutija1 = mOpcije.Get("kutija")
		kutnamj1 = mOpcije.get("kutnamj")
		mjzakut1 = mOpcije.get("mjzakut")
		pod1 = mOpcije.get("pod")
		igr1 = mOpcije.get("igr")
		igrnamj1 = mOpcije.get("igrnamj")
'		Log("/skins/" & spn & "/")
		SloziPreview("/skins/" & spn & "/")
	End If
End Sub

Sub Activity_Resume
	Dim ph As Phone

	ph.SetScreenOrientation(0)
End Sub

Sub Activity_Pause (UserClosed As Boolean)
	If UserClosed Then
		If mOpcije.IsInitialized Then
			mOpcije.Put("cb", cb)
			mOpcije.Put("rb2", rb2)
			mOpcije.Put("rb3", rb3)
			mOpcije.Put("rb4", rb4)
			mOpcije.Put("skin", spn)
			File.Delete(File.DirInternal, "opcije")
			File.WriteMap(File.DirInternal, "opcije", mOpcije)
		End If
	End If
End Sub

Sub RaspakirajSkinoveIzArhive
	arch.UnZip(File.DirInternal, "skins.zip", File.DirInternal, "anzip")
End Sub

Sub ProcitajSveFoldereUSkinDir(dir As String) As List
	Dim list_files As List
	Dim lista_folders As List

	lista_folders.Initialize
	list_files=File.ListFiles(dir)
	For i= 0 To list_files.Size -1
		If File.IsDirectory(dir, list_files.Get(i))=True Then
			lista_folders.Add(list_files.Get(i))
		End If
	Next

	Return lista_folders
End Sub

Sub cb_CheckedChange(Checked As Boolean)
	Log("cb: " & Checked)
	cb = Checked
	mOpcije.Put("cb", cb)
End Sub

'Sub CheckBox2_CheckedChange(Checked As Boolean)
'	Log("cb2: " & Checked)
'	cb2 = Checked
'	If Checked Then
'		CheckBox1.Enabled = True
'	Else
'		CheckBox1.Enabled = False
'	End If
'	mOpcije.Put("cb2", cb2)
'End Sub

Sub spnSkin_ItemClick (Position As Int, Value As Object)
	spn = Value
	Dim l As List = File.ListFiles(File.DirInternal & "/skins/" & Value)
	' skinovi sa png slikama i manje njih
	If spn.StartsWith("1") Then
		lblSkinInfo.Visible = False
		imgPreview.Visible = True
		btnSkinLic.Visible = True
		Label2.Visible = True
		For i = 0 To l.Size - 1
			Dim s As String = l.get(i)
			If s.Contains("preview-simple") Then
				Dim bmp As Bitmap = LoadBitmap(File.DirInternal & "/skins" & "/" & spn, spn.SubString(1) & "-preview-simple.png")
				imgPreview.Bitmap = bmp
				imgPreview.Width = DipToCurrent(bmp.Width)
				imgPreview.Height = DipToCurrent(bmp.Height)
				imgPreview.Left = (100%x - imgPreview.Width) / 2
				For i = 0 To ivs.Length - 1
					ivs(i).Visible = False
				Next
			End If
		Next
		mOpcije.Put("skin", spn)

	' bmp skinovi sa zvukovima
	Else
		lblSkinInfo.Visible = True
		imgPreview.Visible = False
		btnSkinLic.Visible = False
		Label2.Visible = False
		For i = 0 To l.Size - 1
			Dim s As String = l.get(i)
			If s.EndsWith("ini") Then
				ParsajINIDat(s, "/skins/" & Value & "/")
			End If
		Next
		mOpcije.Put("skin", spn)
'		mOpcije.Put("skin2", spn)
		For i = 0 To ivs.Length - 1
			ivs(i).Visible = True
		Next
	End If
End Sub

Sub ParsajINIDat(dat As String, folder As String)
	Dim tr As TextReader
	Dim name, author, desc, web, email As String

	zid1 = "null"
	kutija1 = "null"
	kutnamj1 = "null"
	mjzakut1 = "null"
	pod1 = "null"
	igr1 = "null"
	igrnamj1 = "null"

'	Log(File.DirInternal & folder & dat)
	tr.Initialize(File.OpenInput(File.DirInternal & folder,  dat))
	Dim l As List = tr.ReadList
	tr.Close
	For i = 0 To l.Size - 1
		Dim s As String = l.Get(i)
		If s.StartsWith("name=") Then
			Dim s1 As String = s.SubString(s.IndexOf("="))
			name = s1.SubString(1)
			mOpcije.Put("name", name)
		else If s.StartsWith("author=") Then
			Dim s1 As String = s.SubString(s.IndexOf("="))
			author = s1.SubString(1)
			mOpcije.Put("author", author)
		else If s.StartsWith("description=") Then
			Dim s1 As String = s.SubString(s.IndexOf("="))
			desc = s1.SubString(1)
			mOpcije.Put("desc", desc)
		else If s.StartsWith("website=") Then
			Dim s1 As String = s.SubString(s.IndexOf("="))
			web = s1.SubString(1)
			mOpcije.Put("web", web)
		else If s.StartsWith("email=") Then
			Dim s1 As String = s.SubString(s.IndexOf("="))
			email = s1.SubString(1)
			mOpcije.Put("email", email)
		else If s.StartsWith("object=") Then
			Dim s1 As String = s.SubString(s.IndexOf("="))
			kutija1 = s1.SubString(1).ToLowerCase
		else if s.StartsWith("object_store=") Then
			Dim s1 As String = s.SubString(s.IndexOf("="))
			kutnamj1 = s1.SubString(1).ToLowerCase
		else if s.StartsWith("floor=") Or s.StartsWith("ground=") Then
			Dim s1 As String = s.SubString(s.IndexOf("="))
			pod1 = s1.SubString(1).ToLowerCase
		else if s.StartsWith("store=") Then
			Dim s1 As String = s.SubString(s.IndexOf("="))
			mjzakut1 = s1.SubString(1).ToLowerCase
		else if s.StartsWith("wall=") Then
			Dim s1 As String = s.SubString(s.IndexOf("="))
			zid1 = s1.SubString(1).ToLowerCase
		else If s.StartsWith("mover_up=") Or s.StartsWith("mover=") Then
			Dim s1 As String = s.SubString(s.IndexOf("="))
			igr1 = s1.SubString(1).ToLowerCase
		else if s.StartsWith("mover_store_up=") Or s.StartsWith("mover_store=") Or s.StartsWith("mover_up_store") Then
			Dim s1 As String = s.SubString(s.IndexOf("="))
			igrnamj1 = s1.SubString(1).ToLowerCase
		else if s.StartsWith("move=") Then
			Dim s1 As String = s.SubString(s.IndexOf("=")).ToLowerCase
'			If s1.Length > 0 Then
				mOpcije.Put("mjuzaMove", s1)'s1.SubString(1))
'			Else
'				mOpcije.Put("mjuzaMove", "null")
'			End If
		else if s.StartsWith("move_object=") Then
			Dim s1 As String = s.SubString(s.IndexOf("=")).ToLowerCase
'			If s1.Length > 0 Then
				mOpcije.Put("mjuzaMoveObj", s1)'s1.SubString(1))
'			Else
'				mOpcije.Put("mjuzaMoveObj", "null")
'			End If
		else if s.StartsWith("finishlevel=") Then
			Dim s1 As String = s.SubString(s.IndexOf("=")).ToLowerCase
'			If s1.Length > 0 Then
				mOpcije.Put("mjuza", s1)'s1.SubString(1))
'			Else
'				mOpcije.Put("mjuza", "null")
'			End If
		End If
	Next
	mOpcije.Put("kutija", kutija1)'s1.SubString(1))
	mOpcije.Put("kutnamj", kutnamj1)'s1.SubString(1))
	mOpcije.Put("pod", pod1)'s1.SubString(1))
	mOpcije.Put("mjzakut", mjzakut1)'s1.SubString(1))
	mOpcije.Put("zid", zid1)'s1.SubString(1))
	mOpcije.Put("igr", igr1)'s1.SubString(1))
	mOpcije.Put("igrnamj", igrnamj1)'s1.SubString(1))

	lblSkinInfo.Text = "Name: " & name & CRLF & "Author: " & author & CRLF & "Description: " & desc & CRLF & "Web: " & web & CRLF & "Email: " & email
	SloziPreview(folder)
End Sub

Sub SloziPreview(fold As String)
'	Dim hL As Int = 5
	Dim imamoZid As Boolean = False
	Dim y As Int = 0 : Dim k As Int = 0
	Dim izgledLevela As List
	
	izgledLevela.Initialize2(Array As String("#####", _
											 "#   #", _
											 "# #$###", _
											 "# @ .*#", _
											 "#######"))

	For i = 0 To 4'hL-1
		Dim s As String = izgledLevela.Get(i)
		For j = 0 To s.Length - 1
			Dim s1 As String = s.CharAt(j)
			' zid
			If s1.EqualsIgnoreCase("#") Then
				imamoZid = True
				Dim bmp As Bitmap
				If zid1.Contains("null") = False Then ' .Length > 0 Then
					bmp.Initialize(File.DirInternal & fold & "/", zid1)
				Else
					bmp.Initialize(File.DirAssets, "zid_2.png")
				End If
				ivs(k).Bitmap = bmp
				k = k + 1

				' prazno mjesto za kutije
			else if s1.EqualsIgnoreCase(" ") Then
				If imamoZid Then
					If y > 0 And y < 4 Then'hL - 1 Then
						Dim bmp As Bitmap
'						Log(pod1.Length)
						If pod1.Contains("null") = False Then
							bmp.Initialize(File.DirInternal & fold & "/", pod1)
						Else
							bmp.Initialize(File.DirAssets, "pod.png")
						End If
						ivs(k).Bitmap = bmp
						k = k + 1
					End If
				End If

				' kutija
			else if s1.EqualsIgnoreCase("$") Then
				Dim bmp As Bitmap
				If kutija1.Contains("null") = False Then' .Length > 0 Then
					bmp.Initialize(File.DirInternal & fold & "/", kutija1)
				Else
					bmp.Initialize(File.DirAssets, "kutija_2.png")
				End If
				ivs(k).Bitmap = bmp
				k = k + 1

				' mjesto za kutiju gdje treba biti (goal square) . (točka) i kutija na mjestu gdje treba biti *
			else if s1.EqualsIgnoreCase(".") Or s1.EqualsIgnoreCase("*") Then
				If s1.EqualsIgnoreCase("*") Then
					Dim bmp As Bitmap
					If kutnamj1.Contains("null") = False Then ' .Length > 0 Then
						bmp.Initialize(File.DirInternal & fold & "/", kutnamj1)
					Else
						bmp.Initialize(File.DirAssets, "kutija_na_mjestu_2.png")
					End If
					ivs(k).Bitmap = bmp
					k = k + 1

				Else if s1.EqualsIgnoreCase(".") Then
					Dim bmp As Bitmap
					If mjzakut1.Contains("null") = False Then ' .Length > 0 Then
						bmp.Initialize(File.DirInternal & fold & "/", mjzakut1)
					Else
						bmp.Initialize(File.DirAssets, "iks_2.png")
					End If
					ivs(k).Bitmap = bmp
					k = k + 1
				End If

				' igrač i igrač na mjestu za kutiju (+)
			else if s1.EqualsIgnoreCase("@") Or s1.EqualsIgnoreCase("+") Then
				Dim bmp As Bitmap
				If igr1.Contains("null") = False Then ' .Length > 0 Then
					bmp.Initialize(File.DirInternal & fold & "/", igr1)
				Else
					bmp.Initialize(File.DirAssets, "igrac2.png")
				End If
				ivs(k).Bitmap = bmp
				k = k + 1
			End If
		Next
		y = y + 1
		imamoZid = False
	Next
End Sub

Sub btnSkinLic_Click
	Dim s As String = File.ReadString(File.DirInternal & "/skins/", "LICENCE.txt")

	Msgbox(s, "Skins license")
End Sub

Sub btnDelSkin_Click
	Dim s As String = spnSkin.SelectedItem
	Dim l As List = File.ListFiles(File.DirInternal & "/skins/" & s)
	Dim f As String

	Dim res As Int = Msgbox2("Do you really want to delete this skin?", "Question", "OK", "Cancel", "", LoadBitmap(File.DirAssets, "upitnik.png"))
'	Wait For Msgbox_Result (res As Int)
	If res = DialogResponse.POSITIVE Then
		For i = 0 To l.Size - 1
			f = l.Get(i)
			File.Delete(File.DirInternal & "/skins/" & s & "/", f)
		Next
		File.Delete(File.DirInternal & "/skins/", s)
		lblSkinInfo.Text = ""
		Dim l As List = ProcitajSveFoldereUSkinDir(File.DirInternal & "/skins")
		spnSkin.Clear
		For i = 0 To l.Size - 1
			spnSkin.Add(l.Get(i))
		Next
	End If
End Sub

'
' play with pad
'
Sub rb2c_CheckedChange(Checked As Boolean)
	rb2 = Checked
	If Checked Then
		CheckBox1.Enabled = True
	Else
		CheckBox1.Enabled = False
	End If
	mOpcije.Put("rb2", rb2)
	RadioButton2.Checked = False
	rb3 = False
	RadioButton3.Checked = False
	rb4 = False
End Sub

'
' play with screen tap
'
Sub rb3c_CheckedChange(Checked As Boolean)
	rb3 = Checked
	mOpcije.Put("rb3", Checked)
	RadioButton1.Checked = False
	rb2 = False
	RadioButton3.Checked = False
	rb4 = False
End Sub

'
' play with orientation sensor
'
Sub rb4c_CheckedChange(Checked As Boolean)
	rb4 = Checked
	mOpcije.Put("rb4", Checked)
	RadioButton1.Checked = False
	rb2 = False
	RadioButton2.Checked = False
	rb3 = False
End Sub