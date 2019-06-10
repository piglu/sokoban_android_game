package com.stanks.andsokoban_full;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xlongtexttemplate extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.stanks.andsokoban_full.b4xlongtexttemplate");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.stanks.andsokoban_full.b4xlongtexttemplate.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = null;
public b4a.example3.customlistview _customlistview1 = null;
public Object _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = null;
public b4a.example.dateutils _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = null;
public com.stanks.andsokoban_full.main _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = null;
public com.stanks.andsokoban_full.starter _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = null;
public com.stanks.andsokoban_full.play _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = null;
public com.stanks.andsokoban_full.video _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = null;
public com.stanks.andsokoban_full.rijesenja _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = null;
public com.stanks.andsokoban_full.opcije _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private xui As XUI";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 3;BA.debugLine="Public mBase As B4XView";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 4;BA.debugLine="Public CustomListView1 As CustomListView";
_customlistview1 = new b4a.example3.customlistview();
 //BA.debugLineNum = 5;BA.debugLine="Public Text As Object";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = new Object();
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return "";
}
public String  _dialogclosed(int _result) throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Private Sub DialogClosed(Result As Int) 'ignore";
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _getpanel(com.stanks.andsokoban_full.b4xdialog _dialog) throws Exception{
 //BA.debugLineNum = 29;BA.debugLine="Public Sub GetPanel (Dialog As B4XDialog) As B4XVi";
 //BA.debugLineNum = 30;BA.debugLine="Return mBase";
if (true) return _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2;
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 8;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 9;BA.debugLine="mBase = xui.CreatePanel(\"mBase\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.CreatePanel(ba,"mBase");
 //BA.debugLineNum = 10;BA.debugLine="mBase.SetLayoutAnimated(0, 0, 0, 300dip, 300dip)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),__c.DipToCurrent((int) (300)),__c.DipToCurrent((int) (300)));
 //BA.debugLineNum = 11;BA.debugLine="mBase.LoadLayout(\"LongTextTemplate\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.LoadLayout("LongTextTemplate",ba);
 //BA.debugLineNum = 12;BA.debugLine="mBase.SetColorAndBorder(xui.Color_Transparent, 0,";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.SetColorAndBorder(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Color_Transparent,(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 13;BA.debugLine="CustomListView1.sv.SetColorAndBorder(xui.Color_Tr";
_customlistview1._sv.SetColorAndBorder(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Color_Transparent,(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 14;BA.debugLine="CustomListView1.DefaultTextBackgroundColor = 0xFF";
_customlistview1._defaulttextbackgroundcolor = (int) (0xff555555);
 //BA.debugLineNum = 15;BA.debugLine="CustomListView1.DefaultTextColor = xui.Color_Whit";
_customlistview1._defaulttextcolor = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Color_White;
 //BA.debugLineNum = 16;BA.debugLine="CustomListView1.sv.Color = 0xFF464646";
_customlistview1._sv.setColor((int) (0xff464646));
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1(int _width,int _height) throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Public Sub Resize(Width As Int, Height As Int)";
 //BA.debugLineNum = 24;BA.debugLine="mBase.SetLayoutAnimated(0, 0, 0, Width, Height)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 25;BA.debugLine="CustomListView1.Base_Resize(Width, Height)";
_customlistview1._base_resize(_width,_height);
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return "";
}
public String  _show(com.stanks.andsokoban_full.b4xdialog _dialog) throws Exception{
 //BA.debugLineNum = 33;BA.debugLine="Private Sub Show (Dialog As B4XDialog)";
 //BA.debugLineNum = 34;BA.debugLine="CustomListView1.Clear";
_customlistview1._clear();
 //BA.debugLineNum = 35;BA.debugLine="CustomListView1.AddTextItem(Text, \"\")";
_customlistview1._addtextitem(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3,(Object)(""));
 //BA.debugLineNum = 36;BA.debugLine="CustomListView1.GetPanel(0).GetView(0).SetTextAli";
_customlistview1._getpanel((int) (0)).GetView((int) (0)).SetTextAlignment("TOP","LEFT");
 //BA.debugLineNum = 37;BA.debugLine="Dialog.InternalAddStubToCLVIfNeeded(CustomListVie";
_dialog._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(_customlistview1,_customlistview1._defaulttextbackgroundcolor);
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "DIALOGCLOSED"))
	return _dialogclosed(((Number)args[0]).intValue());
if (BA.fastSubCompare(sub, "GETPANEL"))
	return _getpanel((com.stanks.andsokoban_full.b4xdialog) args[0]);
if (BA.fastSubCompare(sub, "SHOW"))
	return _show((com.stanks.andsokoban_full.b4xdialog) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
