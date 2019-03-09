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
	Dim rijT As Table
	Dim rijP As Panel
	Dim lblTitle As Label
	Dim auth As DbxAuth
	Dim config As DbxRequestConfig
	Dim dbxFiles As DbxUserFilesRequests
	Dim dbxSharing As DbxUserSharingRequests
	Dim dbxUsers As DbxUserUsersRequests
	Dim token As String
	Dim client As DbxClientV2
	Dim DropboxEnabled As Boolean
	Private downloadrunning As Boolean
	Dim Dropbox As DropboxV2
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	lblTitle.Initialize("")
	lblTitle.Text = "Solutions"
	lblTitle.TextSize = 16.0
	lblTitle.Gravity = Bit.Or(Gravity.CENTER_HORIZONTAL, Gravity.CENTER_VERTICAL)
	lblTitle.TextColor = Colors.Yellow
	Activity.AddView(lblTitle, 0, 0, 100%x, 10%x)

	' panel za tablicu
	rijP.Initialize("")
	Activity.AddView(rijP, 0, 11%x, 100%x, 100%y - 11%x)

	rijT.Initialize(Me, "", 3, Gravity.CENTER_HORIZONTAL, False)
	rijT.CellAlignment = Bit.Or(Gravity.CENTER_HORIZONTAL, Gravity.CENTER_VERTICAL)
	rijT.RowHeight = 20dip
	rijT.AddToActivity(rijP, 0, 0, rijP.Width, rijP.Height)
	rijT.SetHeader(Array As String("Title", "Level Name", "Pushes", "Steps", "Download"))
	rijT.SetColumnsWidths(Array As Int(33%x, 33%x, 33%x, 33%x, 33%x))
	rijT.TextSize = 10.0

	Dim dummy As String
	dummy = Starter.kvs.GetSimple("token")
	If dummy <> "" Then
		token = dummy
		'		lblToken.Text = token
		Log("Token available (Activity Create. Try to enable Dropbox with this token")
		config.Initialize("", token, "", "en-en", 5)
		Dim dbxhost As DbxHost
		dbxhost.Initialize
		client.Initialize("Dropbox", config, token, dbxhost)
		dbxFiles = client.files
		dbxFiles.setEventname("dbxFiles")
		dbxSharing = client.sharing
		dbxSharing.setEventname("dbxSharing")
		dbxUsers = client.users
		dbxUsers.setEventname("dbxUsers")
		dbxFiles.listFolder("/Apps/andSokoban/", False, True, False, False, False)
		dbxSharing.listFolders
	End If
	'	btnListroot.Enabled = False
	DropboxEnabled = False
	Dropbox.Initialize("")
	auth.Initialize("ea41vz8owssfdhq")
	downloadrunning = False

'	UbaciRijesenjaUTablicu
End Sub

Sub UbaciRijesenjaUTablicu
	Log(video.listaRijesenja.Size)
	Log(video.listaRijesenjaText.Size)

	Dim bk, bg, rij, tmplist As List

	bk.Initialize
	bg.Initialize
	rij.Initialize
	tmplist.Initialize

	For i = 0 To video.listaRijesenjaText.Size - 1
		bk.Add(video.listaRijesenjaText.Get(1))
		bg.Add(video.listaRijesenjaText.Get(2))
		rij.Add(video.listaRijesenjaText.Get(3))
'		rijT.AddRow(Array As String(l1.Get(i), l2.Get(i), l3.Get(i)))
	Next
End Sub

'Sub UcitajRijesenje
'	Dim sol_info As List
'
'	sol_info.Initialize
'	brojKoraka = sol_info.Get(1)
'	brojGuranja = sol_info.Get(2)
'	rijesenje = sol_info.Get(3)
'End Sub

Sub Activity_Resume
	Dim ph As Phone

	ph.SetScreenOrientation(0)

	If auth.OAuth2Token <> Null Then
		If auth.OAuth2Token <> "" Then
			token = auth.OAuth2Token ' token is a global string i used here
			'			lblToken.Text = token ' this is the label define in my testproject holding the token
			DropboxEnabled = True ' to know Dropbox can be used now
			'			btnListroot.Enabled = True ' in my example the button to do something is only clickable after Authentification.
			Starter.kvs.PutSimple("token", token) ' Store token to a kvs
			Log("Token available. Dropbox enabled")
			config.Initialize("", token, "", "en-en", 5) '
			Dim dbxhost As DbxHost
			dbxhost.Initialize
			client.Initialize("Dropbox", config, token, dbxhost)
			dbxFiles = client.files
			dbxFiles.setEventname("dbxFiles")
			dbxSharing = client.sharing
			dbxSharing.setEventname("dbxSharing")
			dbxUsers = client.users
			dbxUsers.setEventname("dbxUsers")
			dbxFiles.listFolder("/Apps/andSokoban/", False, True, False, False, False)
			dbxSharing.listFolders
'			If aploud Then
'				UploadajVideoISolutionDat
'			End If
		Else
			Log($"Token = """$)
		End If
	Else
		Log("Token is NULL")
		If token <> "" Then
			Log("Try to use the known token...")
			'			dbxFiles.listFolder("/Apps/", False, True, False, True, False)
			'			dbxSharing.listFolders  ' Tested!
			dbxUsers.CurrentAccount ' Tested!
		End If
	End If
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub dbxSharing_listFolders(success As Boolean, folders As List, error As String)
	Log($"dbxSharing_listFolders(${success}, ${folders.Size}, ${error})"$)
	'	Log("folders: " & folders)
	'	If folders.Size > 0 Then
	'		For i = 0 To folders.Size-1
	'			Dim meta As SharedFolderMetadata = folders.Get(i)
	'			Log(meta.toStringMultiline)
	'		Next
	'	End If
End Sub

Sub dbxSharing_AddFileMember(success As Boolean, members As List, error As String)
	Log($"dbxSharing_listFolders(${success}, ${members.Size}, ${error})"$)
End Sub

Sub dbxSharing_listMountableFolders(success As Boolean, folders As List, error As String)
	Log($"dbxSharing_listFolders(${success}, ${folders.Size}, ${error})"$)
End Sub

Sub dbxSharing_listReceivedFiles(success As Boolean, receivedFiles As List, error As String)
	Log($"dbxSharing_listFolders(${success}, ${receivedFiles.Size}, ${error})"$)
End Sub

Sub dbxSharing_listSharedLinks(success As Boolean, sharedLinks As List, error As String)
	Log($"dbxSharing_listFolders(${success}, ${sharedLinks.Size}, ${error})"$)
End Sub

Sub dbxSharing_SharedFolderMetadata(success As Boolean, meta As SharedFolderMetadata, error As String)
	Log($"dbxSharing_listFolders(${success}, ${meta.toString}, ${error})"$)
End Sub

Sub dbxFiles_DownloadFinished(success As Boolean, meta As FileMetadata, error As String)
	Log($"dbxFiles_DownloadFinished(${success}, ${meta}, ${error})"$)
End Sub

Sub dbxFiles_listFolder(success As Boolean, content As List, error As String)
	'	Log($"dbxFiles_listFolders(${success}, ${content.Size}, ${error})"$)
	'	Log("content: " & content)
	If content.Size > 0 Then
		For i = 0 To content.Size-1
			Dim meta As Metadata = content.Get(i)
			'			Log("dbxFiles_listFolder: " & meta.toString)
			Log(meta.Name)
			If meta.Name.EndsWith(".solution") = False Then
'				listaRijesenja.Add(meta.Name)
			Else
'				listaRijesenjaText.Add(meta.Name)
			End If
			'			Log(meta.ParentSharedFolderId)
			'			Log(meta.toStringMultiline)
		Next
	End If
	'	If listaRijesenja.Size > 0 Then
	'		Msgbox("Not yet implemented", "info")
	'		StartActivity(rijesenja)
	'	Else
	'		Msgbox("No solutions online!", "Info")
	'	End If
End Sub

Sub dbxFiles_CopyBatch(success As Boolean, meta As Map, error As String)
 
End Sub

Sub dbxFiles_CopyBatchCheck(success As Boolean, meta As Map, error As String)
 
End Sub

Sub dbxFiles_CopyReference(metainfo As Map)
 
End Sub

Sub dbxFiles_CreateFolder(success As Boolean, meta As FolderMetadata, error As String)
 
End Sub

Sub dbxFiles_ListRevisions(success As Boolean, meta As Map, error As String)
 
End Sub

Sub dbxFiles_MoveBatch(success As Boolean, meta As Map, error As String)
 
End Sub

Sub dbxFiles_MoveBatchCheck(success As Boolean, meta As Map, error As String)
 
End Sub

Sub dbxFiles_Restore(success As Boolean, meta As FileMetadata, error As String)
 
End Sub

Sub dbxFiles_UploadFinished(success As Boolean, meta As FileMetadata, error As String)
	'	Log(success)
	Log(meta.Name)
	Log(meta.SharingInfo)
	Log(meta.toStringMultiline)
	'	Log(error)
End Sub

Sub dbxUsers_getAccount(account As BasicAccount)
	Log($"dbxUsers_getAccount(${account})"$)
End Sub

Sub dbxUsers_getAccountBatch(batch As List)
 
End Sub

Sub dbxUsers_getCurrentAccount(account As FullAccount)
	Log($"dbxUsers_getCurrentAccount(${account})"$)
End Sub

'Dim MyImport, MyExport As String
'Dim MyPath=File.DirRootExternal, MyFile ="germany.txt" As String
'MyImport="/Import"   'dropbox server subfolder
'MyExport="/Export"   'dropbox server subfolder
'
''To UPLOAD A File: If autorename Is set To True And uploaded File has same name,
''but its content changed, the File Is Not overwritten: e.g.: germany (1).txt
'dbxFiles.upload(MyPath, MyFile, MyImport &"/" & MyFile,False,False)
'
''To DOWNLOAD A File To DEVICE:
'dbxFiles.download(MyExport & "/" & MyFile, MyPath, MyFile)
