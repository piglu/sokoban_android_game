package com.stanks.andsokoban_full;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xsignaturetemplate extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.stanks.andsokoban_full.b4xsignaturetemplate");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.stanks.andsokoban_full.b4xsignaturetemplate.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _vvvvvvvvvvvv6 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _vvvvvvvvvvvv5 = null;
public anywheresoftware.b4a.objects.B4XCanvas _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = null;
public float _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = 0f;
public float _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = 0f;
public float _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = 0f;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0;
public int _vvvvvvvvvvvvvvv1 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvv2 = 0;
public boolean _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = false;
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = null;
public b4a.example.dateutils _vvvvvvv3 = null;
public com.stanks.andsokoban_full.main _vvvvvvv4 = null;
public com.stanks.andsokoban_full.starter _vvvvvvv5 = null;
public com.stanks.andsokoban_full.play _vvvvvvv6 = null;
public com.stanks.andsokoban_full.odabir _vvvvvvv7 = null;
public com.stanks.andsokoban_full.video _vvvvvvv0 = null;
public com.stanks.andsokoban_full.rijesenja _vvvvvvvv1 = null;
public com.stanks.andsokoban_full.opcije _vvvvvvvv2 = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private xui As XUI";
_vvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 3;BA.debugLine="Public mBase As B4XView";
_vvvvvvvvvvvv5 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 4;BA.debugLine="Private cvs As B4XCanvas";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 5;BA.debugLine="Private LastX, LastY As Float";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = 0f;
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = 0f;
 //BA.debugLineNum = 6;BA.debugLine="Public StrokeWidth As Float = 2dip";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = (float) (__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 7;BA.debugLine="Public StrokeColor As Int = xui.Color_Black";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = _vvvvvvvvvvvv6.Color_Black;
 //BA.debugLineNum = 8;BA.debugLine="Public TextColor As Int = 0xFFFF8800";
_vvvvvvvvvvvvvvv1 = (int) (0xffff8800);
 //BA.debugLineNum = 9;BA.debugLine="Public BackgroundColor As Int = xui.Color_White";
_vvvvvvvvvvvvvvvvvvvvvv2 = _vvvvvvvvvvvv6.Color_White;
 //BA.debugLineNum = 10;BA.debugLine="Public AddDateAndTime As Boolean = True";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = __c.True;
 //BA.debugLineNum = 11;BA.debugLine="Public TextFont As B4XFont";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
public String  _dialogclosed(int _result) throws Exception{
anywheresoftware.b4a.objects.B4XCanvas.B4XRect _r = null;
int _baseline = 0;
 //BA.debugLineNum = 53;BA.debugLine="Private Sub DialogClosed (Result As Int)";
 //BA.debugLineNum = 54;BA.debugLine="If Result = xui.DialogResponse_Positive And AddDa";
if (_result==_vvvvvvvvvvvv6.DialogResponse_Positive && _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4) { 
 //BA.debugLineNum = 55;BA.debugLine="Dim r As B4XRect = cvs.MeasureText(\"M\", TextFont";
_r = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.MeasureText("M",_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5);
 //BA.debugLineNum = 56;BA.debugLine="Dim Baseline As Int = cvs.TargetRect.Bottom - r.";
_baseline = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.getTargetRect().getBottom()-_r.getHeight()-_r.getTop()-__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 57;BA.debugLine="cvs.DrawText($\"$DateTime{DateTime.Now}\"$, 2dip,";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.DrawText(ba,(""+__c.SmartStringFormatter("datetime",(Object)(__c.DateTime.getNow()))+""),(float) (__c.DipToCurrent((int) (2))),(float) (_baseline),_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5,_vvvvvvvvvvvvvvv1,BA.getEnumFromString(android.graphics.Paint.Align.class,"LEFT"));
 };
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper  _getvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7() throws Exception{
 //BA.debugLineNum = 49;BA.debugLine="Public Sub getBitmap As B4XBitmap";
 //BA.debugLineNum = 50;BA.debugLine="Return cvs.CreateBitmap";
if (true) return _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.CreateBitmap();
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _getpanel(com.stanks.andsokoban_full.b4xdialog _dialog) throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Public Sub GetPanel (Dialog As B4XDialog) As B4XVi";
 //BA.debugLineNum = 28;BA.debugLine="Return mBase";
if (true) return _vvvvvvvvvvvv5;
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 14;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 15;BA.debugLine="mBase = xui.CreatePanel(\"mBase\")";
_vvvvvvvvvvvv5 = _vvvvvvvvvvvv6.CreatePanel(ba,"mBase");
 //BA.debugLineNum = 16;BA.debugLine="mBase.SetLayoutAnimated(0, 0, 0, 300dip, 200dip)";
_vvvvvvvvvvvv5.SetLayoutAnimated((int) (0),(int) (0),(int) (0),__c.DipToCurrent((int) (300)),__c.DipToCurrent((int) (200)));
 //BA.debugLineNum = 17;BA.debugLine="cvs.Initialize(mBase)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Initialize(_vvvvvvvvvvvv5);
 //BA.debugLineNum = 18;BA.debugLine="TextFont = xui.CreateDefaultFont(14)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = _vvvvvvvvvvvv6.CreateDefaultFont((float) (14));
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public String  _mbase_touch(int _action,float _x,float _y) throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Private Sub mBase_Touch (Action As Int, X As Float";
 //BA.debugLineNum = 37;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,_vvvvvvvvvvvv5.TOUCH_ACTION_DOWN,_vvvvvvvvvvvv5.TOUCH_ACTION_MOVE)) {
case 0: {
 //BA.debugLineNum = 39;BA.debugLine="LastX = X";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = _x;
 //BA.debugLineNum = 40;BA.debugLine="LastY = Y";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = _y;
 break; }
case 1: {
 //BA.debugLineNum = 42;BA.debugLine="cvs.DrawLine(LastX, LastY, X, Y, StrokeColor, S";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.DrawLine(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0,_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1,_x,_y,_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3,_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2);
 //BA.debugLineNum = 43;BA.debugLine="LastX = X";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = _x;
 //BA.debugLineNum = 44;BA.debugLine="LastY = Y";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = _y;
 //BA.debugLineNum = 45;BA.debugLine="cvs.Invalidate";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Invalidate();
 break; }
}
;
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2(int _width,int _height) throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Public Sub Resize(Width As Int, Height As Int)";
 //BA.debugLineNum = 22;BA.debugLine="mBase.SetLayoutAnimated(0, 0, 0, Width, Height)";
_vvvvvvvvvvvv5.SetLayoutAnimated((int) (0),(int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 23;BA.debugLine="cvs.Resize(Width, Height)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Resize((float) (_width),(float) (_height));
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public String  _show(com.stanks.andsokoban_full.b4xdialog _dialog) throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Private Sub Show (Dialog As B4XDialog) 'ignore";
 //BA.debugLineNum = 32;BA.debugLine="cvs.DrawRect(cvs.TargetRect, BackgroundColor, Tru";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.DrawRect(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.getTargetRect(),_vvvvvvvvvvvvvvvvvvvvvv2,__c.True,(float) (0));
 //BA.debugLineNum = 33;BA.debugLine="cvs.Invalidate";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Invalidate();
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
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
