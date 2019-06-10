﻿B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=6.8
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim DBFileName As String			: DBFileName = "db"
'	Dim DBFileDir As String				: DBFileDir = File.DirInternal
	Dim upit As SQL
	Dim kvs As KeyValueStore
	Public rp As RuntimePermissions
	Public SourceFolder As String
End Sub

Sub Service_Create
	'This is the program entry point.
	'This is a good place to load resources that are not specific to a single activity.
	SourceFolder = rp.GetSafeDirDefaultExternal("")
	If File.Exists(SourceFolder, "db") = False Then
		File.Copy(File.DirAssets, "db", SourceFolder, "db")
	End If
	upit.Initialize(SourceFolder, "db", True)
	kvs.Initialize(SourceFolder, "t")
End Sub

Sub Service_Start (StartingIntent As Intent)

End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy

End Sub
