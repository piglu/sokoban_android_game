package com.stanks.andsokoban_full;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xinputtemplate extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.stanks.andsokoban_full.b4xinputtemplate");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.stanks.andsokoban_full.b4xinputtemplate.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = null;
public String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = "";
public com.stanks.andsokoban_full.b4xdialog _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = null;
public String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = "";
public anywheresoftware.b4a.objects.B4XViewWrapper _textfield1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
public anywheresoftware.b4a.objects.IME _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = null;
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
 //BA.debugLineNum = 4;BA.debugLine="Public Text As String";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = "";
 //BA.debugLineNum = 5;BA.debugLine="Private xDialog As B4XDialog";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = new com.stanks.andsokoban_full.b4xdialog();
 //BA.debugLineNum = 6;BA.debugLine="Public RegexPattern As String";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = "";
 //BA.debugLineNum = 7;BA.debugLine="Public TextField1 As B4XView";
_textfield1 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 8;BA.debugLine="Public lblTitle As Label";
_lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private IME As IME";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = new anywheresoftware.b4a.objects.IME();
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5(boolean _allowdecimals,boolean _allownegative) throws Exception{
anywheresoftware.b4a.objects.EditTextWrapper _et = null;
 //BA.debugLineNum = 30;BA.debugLine="Public Sub ConfigureForNumbers (AllowDecimals As B";
 //BA.debugLineNum = 32;BA.debugLine="Dim et As EditText = TextField1";
_et = new anywheresoftware.b4a.objects.EditTextWrapper();
_et.setObject((android.widget.EditText)(_textfield1.getObject()));
 //BA.debugLineNum = 33;BA.debugLine="If AllowDecimals Or AllowNegative Then";
if (_allowdecimals || _allownegative) { 
 //BA.debugLineNum = 34;BA.debugLine="et.InputType = et.INPUT_TYPE_DECIMAL_NUMBERS";
_et.setInputType(_et.INPUT_TYPE_DECIMAL_NUMBERS);
 }else {
 //BA.debugLineNum = 36;BA.debugLine="et.InputType = et.INPUT_TYPE_NUMBERS";
_et.setInputType(_et.INPUT_TYPE_NUMBERS);
 };
 //BA.debugLineNum = 49;BA.debugLine="If AllowDecimals And AllowNegative Then";
if (_allowdecimals && _allownegative) { 
 //BA.debugLineNum = 50;BA.debugLine="RegexPattern = \"^-?(0|[1-9]\\d*)?(\\.\\d+)?(?<=\\d)$";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = "^-?(0|[1-9]\\d*)?(\\.\\d+)?(?<=\\d)$";
 }else if(_allowdecimals && _allownegative==__c.False) { 
 //BA.debugLineNum = 52;BA.debugLine="RegexPattern = \"^(0|[1-9]\\d*)?(\\.\\d+)?(?<=\\d)$\"";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = "^(0|[1-9]\\d*)?(\\.\\d+)?(?<=\\d)$";
 }else if(_allowdecimals==__c.False && _allownegative==__c.True) { 
 //BA.debugLineNum = 54;BA.debugLine="RegexPattern = \"^-?(0|[1-9]\\d*)$\"";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = "^-?(0|[1-9]\\d*)$";
 }else if(_allowdecimals==__c.False && _allownegative==__c.False) { 
 //BA.debugLineNum = 56;BA.debugLine="RegexPattern = \"^(0|[1-9]\\d*)$\"";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = "^(0|[1-9]\\d*)$";
 };
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public String  _dialogclosed(int _result) throws Exception{
 //BA.debugLineNum = 111;BA.debugLine="Private Sub DialogClosed(Result As Int)";
 //BA.debugLineNum = 112;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (_result==_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.DialogResponse_Positive) { 
 //BA.debugLineNum = 113;BA.debugLine="Text = TextField1.Text";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = _textfield1.getText();
 };
 //BA.debugLineNum = 115;BA.debugLine="TextField1.Text = Text";
_textfield1.setText(BA.ObjectToCharSequence(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3));
 //BA.debugLineNum = 116;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _getpanel(com.stanks.andsokoban_full.b4xdialog _dialog) throws Exception{
 //BA.debugLineNum = 90;BA.debugLine="Public Sub GetPanel (Dialog As B4XDialog) As B4XVi";
 //BA.debugLineNum = 91;BA.debugLine="Return mBase";
if (true) return _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2;
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 14;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 15;BA.debugLine="mBase = xui.CreatePanel(\"mBase\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.CreatePanel(ba,"mBase");
 //BA.debugLineNum = 16;BA.debugLine="mBase.SetLayoutAnimated(0, 0, 0, 300dip, 80dip)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),__c.DipToCurrent((int) (300)),__c.DipToCurrent((int) (80)));
 //BA.debugLineNum = 17;BA.debugLine="mBase.LoadLayout(\"B4XInputTemplate\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.LoadLayout("B4XInputTemplate",ba);
 //BA.debugLineNum = 18;BA.debugLine="TextField1.TextColor = xui.Color_White";
_textfield1.setTextColor(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Color_White);
 //BA.debugLineNum = 20;BA.debugLine="IME.Initialize(\"\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Initialize("");
 //BA.debugLineNum = 21;BA.debugLine="Dim jo As JavaObject = TextField1";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_textfield1.getObject()));
 //BA.debugLineNum = 22;BA.debugLine="jo.RunMethod(\"setImeOptions\", Array(Bit.Or(335544";
_jo.RunMethod("setImeOptions",new Object[]{(Object)(__c.Bit.Or((int) (33554432),(int) (6)))});
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public boolean  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6(String _new) throws Exception{
 //BA.debugLineNum = 77;BA.debugLine="Private Sub IsValid(New As String) As Boolean";
 //BA.debugLineNum = 78;BA.debugLine="Return RegexPattern = \"\" Or Regex.IsMatch(RegexPa";
if (true) return (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0).equals("") || __c.Regex.IsMatch(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0,_new);
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return false;
}
public void  _show(com.stanks.andsokoban_full.b4xdialog _dialog) throws Exception{
ResumableSub_Show rsub = new ResumableSub_Show(this,_dialog);
rsub.resume(ba, null);
}
public static class ResumableSub_Show extends BA.ResumableSub {
public ResumableSub_Show(com.stanks.andsokoban_full.b4xinputtemplate parent,com.stanks.andsokoban_full.b4xdialog _dialog) {
this.parent = parent;
this._dialog = _dialog;
}
com.stanks.andsokoban_full.b4xinputtemplate parent;
com.stanks.andsokoban_full.b4xdialog _dialog;
anywheresoftware.b4a.objects.EditTextWrapper _tf = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 95;BA.debugLine="xDialog = Dialog";
parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = _dialog;
 //BA.debugLineNum = 96;BA.debugLine="xDialog.PutAtTop = xui.IsB4A Or xui.IsB4i";
parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.getIsB4A() || parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.getIsB4i();
 //BA.debugLineNum = 97;BA.debugLine="Sleep(20)";
parent.__c.Sleep(ba,this,(int) (20));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 98;BA.debugLine="TextField1.Text = Text";
parent._textfield1.setText(BA.ObjectToCharSequence(parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3));
 //BA.debugLineNum = 99;BA.debugLine="Validate(Text)";
parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3);
 //BA.debugLineNum = 100;BA.debugLine="TextField1.RequestFocus";
parent._textfield1.RequestFocus();
 //BA.debugLineNum = 102;BA.debugLine="Dim tf As EditText = TextField1";
_tf = new anywheresoftware.b4a.objects.EditTextWrapper();
_tf.setObject((android.widget.EditText)(parent._textfield1.getObject()));
 //BA.debugLineNum = 103;BA.debugLine="tf.SelectAll";
_tf.SelectAll();
 //BA.debugLineNum = 104;BA.debugLine="IME.ShowKeyboard(TextField1)";
parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.ShowKeyboard((android.view.View)(parent._textfield1.getObject()));
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _textfield1_action() throws Exception{
 //BA.debugLineNum = 81;BA.debugLine="Private Sub TextField1_Action";
 //BA.debugLineNum = 82;BA.debugLine="TextField1_EnterPressed";
_textfield1_enterpressed();
 //BA.debugLineNum = 83;BA.debugLine="End Sub";
return "";
}
public String  _textfield1_enterpressed() throws Exception{
 //BA.debugLineNum = 85;BA.debugLine="Private Sub TextField1_EnterPressed";
 //BA.debugLineNum = 86;BA.debugLine="If IsValid(TextField1.Text) Then xDialog.Close(xu";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6(_textfield1.getText())) { 
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.DialogResponse_Positive);};
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public String  _textfield1_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Private Sub TextField1_TextChanged (Old As String,";
 //BA.debugLineNum = 61;BA.debugLine="Validate (New)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(_new);
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(String _new) throws Exception{
int _bordercolor = 0;
boolean _enabled = false;
 //BA.debugLineNum = 64;BA.debugLine="Private Sub Validate (New As String)";
 //BA.debugLineNum = 65;BA.debugLine="Dim BorderColor As Int = xui.Color_White";
_bordercolor = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Color_White;
 //BA.debugLineNum = 66;BA.debugLine="Dim enabled As Boolean = True";
_enabled = __c.True;
 //BA.debugLineNum = 67;BA.debugLine="If IsValid(New) = False Then";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6(_new)==__c.False) { 
 //BA.debugLineNum = 68;BA.debugLine="If New.Length > 0 Then";
if (_new.length()>0) { 
 //BA.debugLineNum = 69;BA.debugLine="BorderColor = xui.Color_Red";
_bordercolor = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Color_Red;
 };
 //BA.debugLineNum = 71;BA.debugLine="enabled = False";
_enabled = __c.False;
 };
 //BA.debugLineNum = 73;BA.debugLine="xDialog.SetButtonState(xui.DialogResponse_Positiv";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.DialogResponse_Positive,_enabled);
 //BA.debugLineNum = 74;BA.debugLine="TextField1.SetColorAndBorder(xui.Color_Transparen";
_textfield1.SetColorAndBorder(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Color_Transparent,__c.DipToCurrent((int) (1)),_bordercolor,__c.DipToCurrent((int) (2)));
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "DIALOGCLOSED"))
	return _dialogclosed(((Number)args[0]).intValue());
if (BA.fastSubCompare(sub, "GETPANEL"))
	return _getpanel((com.stanks.andsokoban_full.b4xdialog) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
