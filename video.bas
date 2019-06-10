B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=6.8
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim listaRijesenja As List
	Dim listaRijesenjaText As List
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Dim vv As VideoView
	Dim spn As Spinner
	Dim btn1 As Button
'	Dim auth As DbxAuth
'	Dim config As DbxRequestConfig
'	Dim dbxFiles As DbxUserFilesRequests
'	Dim dbxSharing As DbxUserSharingRequests
'	Dim dbxUsers As DbxUserUsersRequests
'	Dim token As String
'	Dim client As DbxClientV2
'	Dim DropboxEnabled As Boolean
'	Private downloadrunning As Boolean
'	Dim Dropbox As DropboxV2
'	Dim aploud As Boolean
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	vv.Initialize("vv") 'we'll use a videoview to show the recording
	Activity.AddView(vv, 30%x, 0, 100%x - 20%x, 100%y)
	vv.MediaControllerEnabled = True

	spn.Initialize("spn1")
	Activity.AddView(spn, 0, 0, 30%x, 10%x)
	spn.AddAll(Main.listaDatZaVideo)

	btn1.Initialize("delete")
	btn1.Text = "Delete selected video"
	btn1.TextSize = 12
	btn1.TextColor = Colors.Yellow
	Activity.AddView(btn1, 0, 10%x, 20%x, 10%x)

'	btn2.Initialize("upload")
'	btn2.Text = "Upload selected video"
'	btn2.TextSize = 12
'	btn2.TextColor = Colors.Yellow
'	Activity.AddView(btn2, 0, 21%x, 20%x, 10%x)

'	btn3.Initialize("dl_aktivnost")
'	btn3.Text = "Show uploaded solutions"
'	btn3.TextSize = 12
'	btn3.TextColor = Colors.Yellow
'	Activity.AddView(btn3, 0, 32%x, 20%x, 10%x)

	'	auth.Initialize("y9yckqobjsd48w4")	' app key
'	Dim dummy As String
'	dummy = Starter.kvs.GetSimple("token")
'	If dummy <> "" Then
'		token = dummy
''		lblToken.Text = token
'		Log("Token available (Activity Create. Try to enable Dropbox with this token")
'		config.Initialize("", token, "", "en-en", 5)
'		Dim dbxhost As DbxHost
'		dbxhost.Initialize
'		client.Initialize("Dropbox", config, token, dbxhost)
'		dbxFiles = client.files
'		dbxFiles.setEventname("dbxFiles")
'		dbxSharing = client.sharing
'		dbxSharing.setEventname("dbxSharing")
'		dbxUsers = client.users
'		dbxUsers.setEventname("dbxUsers")
'	End If
''	btnListroot.Enabled = False
'	DropboxEnabled = False
'	Dropbox.Initialize("")
'	auth.Initialize("ea41vz8owssfdhq")
'	downloadrunning = False

	listaRijesenja.Initialize
	listaRijesenjaText.Initialize

	' app secret -> 5peypxaeukyu9nr
	' access token -> qRhxz8JTeoQAAAAAAAAQHW1GCaxmt5nVv1mczWJKYiCStALg_3noP4WLeUh_9Gqz
End Sub

Sub Activity_Resume
	Dim ph As Phone

	ph.SetScreenOrientation(0)

'	If auth.OAuth2Token <> Null Then
'		If auth.OAuth2Token <> "" Then
'			token = auth.OAuth2Token ' token is a global string i used here
''			lblToken.Text = token ' this is the label define in my testproject holding the token
'			DropboxEnabled = True ' to know Dropbox can be used now
''			btnListroot.Enabled = True ' in my example the button to do something is only clickable after Authentification.
'			Starter.kvs.PutSimple("token", token) ' Store token to a kvs
'			Log("Token available. Dropbox enabled")
'			config.Initialize("", token, "", "en-en", 5) '
'			Dim dbxhost As DbxHost
'			dbxhost.Initialize
'			client.Initialize("Dropbox", config, token, dbxhost)
'			dbxFiles = client.files
'			dbxFiles.setEventname("dbxFiles")
'			dbxSharing = client.sharing
'			dbxSharing.setEventname("dbxSharing")
'			dbxUsers = client.users
'			dbxUsers.setEventname("dbxUsers")
'			If aploud Then
'				UploadajVideoISolutionDat
'			End If
'		Else
'			Log($"Token = """$)
'		End If
'	Else
'		Log("Token is NULL")
'		If token <> "" Then
'			Log("Try to use the known token...")
''			dbxFiles.listFolder("/Apps/", False, True, False, True, False)
''			dbxSharing.listFolders  ' Tested!
'			dbxUsers.CurrentAccount ' Tested!
'		End If
'	End If
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub spn1_ItemClick (Position As Int, Value As Object)
	vv.LoadVideo(File.DirInternal, Value)
	vv.Play
End Sub

Sub delete_Click
	Dim res As Int = Msgbox2("Really delete selected video?", "Warning", "OK", "Cancel", "", LoadBitmap(File.DirAssets, "upitnik.png"))
'	Wait For Msgbox_Result (res As Int)
	If res = DialogResponse.POSITIVE Then
		File.Delete(File.DirInternal, spn.SelectedItem)
		spn.RemoveAt(spn.SelectedIndex)
	End If
End Sub

'Sub upload_Click
'	auth.startOAuth2Authentication
'	aploud = True
'End Sub
'
'Sub UploadajVideoISolutionDat
'	Log(File.DirInternal & "/" & spn.SelectedItem)
'	Log(File.DirInternal & "/" &  spn.SelectedItem & ".solution")
'	dbxFiles.upload(File.DirInternal, spn.SelectedItem, "/Apps/andSokoban/" & spn.SelectedItem, False, False)
''	dbxSharing.createSharedLinkWithSettings("/" & spn.SelectedItem, Null)
''	dbxSharing.createSharedLink("/Apps/andSokoban/" & spn.SelectedItem, Dropbox.PendingUploadMode_FILE, False)
'	dbxFiles.upload(File.DirInternal, spn.SelectedItem & ".solution", "/Apps/andSokoban/" & spn.SelectedItem & ".solution", False, False)
''	dbxSharing.createSharedLinkWithSettings("/" & spn.SelectedItem & ".solution", Null)
''	dbxSharing.createSharedLink("/Apps/andSokoban/" & spn.SelectedItem & ".solution", Dropbox.PendingUploadMode_FILE, False)
'	Msgbox("Files uploaded", "Info")
'	aploud = False
'End Sub

'Sub dl_aktivnost_Click
'	'	auth.startOAuth2Authentication
'	dbxFiles.listFolder("/Apps/andSokoban/", False, True, False, False, False)
'	dbxSharing.listFolders
'End Sub

Sub vv_Complete
	Msgbox("Playing complete!", "Info")
End Sub

'Sub dbxSharing_listFolders(success As Boolean, folders As List, error As String)
'	Log($"dbxSharing_listFolders(${success}, ${folders.Size}, ${error})"$)
''	Log("folders: " & folders)
''	If folders.Size > 0 Then
''		For i = 0 To folders.Size-1
''			Dim meta As SharedFolderMetadata = folders.Get(i)
''			Log(meta.toStringMultiline)
''		Next
''	End If
'End Sub
'
'Sub dbxSharing_AddFileMember(success As Boolean, members As List, error As String)
'	Log($"dbxSharing_listFolders(${success}, ${members.Size}, ${error})"$)
'End Sub
'
'Sub dbxSharing_listMountableFolders(success As Boolean, folders As List, error As String)
'	Log($"dbxSharing_listFolders(${success}, ${folders.Size}, ${error})"$)
'End Sub
'
'Sub dbxSharing_listReceivedFiles(success As Boolean, receivedFiles As List, error As String)
'	Log($"dbxSharing_listFolders(${success}, ${receivedFiles.Size}, ${error})"$)
'End Sub
'
'Sub dbxSharing_listSharedLinks(success As Boolean, sharedLinks As List, error As String)
'	Log($"dbxSharing_listFolders(${success}, ${sharedLinks.Size}, ${error})"$)
'End Sub
'
'Sub dbxSharing_SharedFolderMetadata(success As Boolean, meta As SharedFolderMetadata, error As String)
'	Log($"dbxSharing_listFolders(${success}, ${meta.toString}, ${error})"$)
'End Sub
'
'Sub dbxFiles_DownloadFinished(success As Boolean, meta As FileMetadata, error As String)
'	Log($"dbxFiles_DownloadFinished(${success}, ${meta}, ${error})"$)
'End Sub
'
'Sub dbxFiles_listFolder(success As Boolean, content As List, error As String)
''	Log($"dbxFiles_listFolders(${success}, ${content.Size}, ${error})"$)
''	Log("content: " & content)
'	If content.Size > 0 Then
'		For i = 0 To content.Size-1
'			Dim meta As Metadata = content.Get(i)
''			Log("dbxFiles_listFolder: " & meta.toString)
'			Log(meta.Name)
'			If meta.Name.EndsWith(".solution") = False Then
'				listaRijesenja.Add(meta.Name)
'			Else
'				listaRijesenjaText.Add(meta.Name)
'			End If
''			Log(meta.ParentSharedFolderId)
''			Log(meta.toStringMultiline)
'		Next
'	End If
''	If listaRijesenja.Size > 0 Then
''		Msgbox("Not yet implemented", "info")
''		StartActivity(rijesenja)
''	Else
''		Msgbox("No solutions online!", "Info")
''	End If
'End Sub

'Sub dbxFiles_CopyBatch(success As Boolean, meta As Map, error As String)
' 
'End Sub
'
'Sub dbxFiles_CopyBatchCheck(success As Boolean, meta As Map, error As String)
' 
'End Sub
'
'Sub dbxFiles_CopyReference(metainfo As Map)
' 
'End Sub
'
'Sub dbxFiles_CreateFolder(success As Boolean, meta As FolderMetadata, error As String)
' 
'End Sub
'
'Sub dbxFiles_ListRevisions(success As Boolean, meta As Map, error As String)
' 
'End Sub
'
'Sub dbxFiles_MoveBatch(success As Boolean, meta As Map, error As String)
' 
'End Sub
'
'Sub dbxFiles_MoveBatchCheck(success As Boolean, meta As Map, error As String)
' 
'End Sub
'
'Sub dbxFiles_Restore(success As Boolean, meta As FileMetadata, error As String)
' 
'End Sub
'
'Sub dbxFiles_UploadFinished(success As Boolean, meta As FileMetadata, error As String)
''	Log(success)
'	Log(meta.Name)
'	Log(meta.SharingInfo)
'	Log(meta.toStringMultiline)
''	Log(error)
'End Sub
'
'Sub dbxUsers_getAccount(account As BasicAccount)
'	Log($"dbxUsers_getAccount(${account})"$)
'End Sub
'
'Sub dbxUsers_getAccountBatch(batch As List)
' 
'End Sub
'
'Sub dbxUsers_getCurrentAccount(account As FullAccount)
'	Log($"dbxUsers_getCurrentAccount(${account})"$)
'End Sub
 
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
