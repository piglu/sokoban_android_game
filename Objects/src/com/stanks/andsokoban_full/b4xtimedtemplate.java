package com.stanks.andsokoban_full;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xtimedtemplate extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.stanks.andsokoban_full.b4xtimedtemplate");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.stanks.andsokoban_full.b4xtimedtemplate.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _vvvvvvvvvvvv6 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _vvvvvvvvvvvv5 = null;
public com.stanks.andsokoban_full.anotherprogressbar _anotherprogressbar1 = null;
public Object _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = null;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0;
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
 //BA.debugLineNum = 4;BA.debugLine="Private AnotherProgressBar1 As AnotherProgressBar";
_anotherprogressbar1 = new com.stanks.andsokoban_full.anotherprogressbar();
 //BA.debugLineNum = 5;BA.debugLine="Private mTemplate As Object";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = new Object();
 //BA.debugLineNum = 6;BA.debugLine="Public TimeoutMilliseconds As Int = 10000";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = (int) (10000);
 //BA.debugLineNum = 7;BA.debugLine="Private Index As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0;
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return "";
}
public String  _dialogclosed(int _result) throws Exception{
 //BA.debugLineNum = 41;BA.debugLine="Private Sub DialogClosed(Result As Int)";
 //BA.debugLineNum = 42;BA.debugLine="Index = Index + 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3+1);
 //BA.debugLineNum = 43;BA.debugLine="CallSub2(mTemplate, \"DialogClosed\", Result)";
__c.CallSubNew2(ba,_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1,"DialogClosed",(Object)(_result));
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _getpanel(com.stanks.andsokoban_full.b4xdialog _dialog) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _innerpanel = null;
 //BA.debugLineNum = 16;BA.debugLine="Public Sub GetPanel (Dialog As B4XDialog) As B4XVi";
 //BA.debugLineNum = 17;BA.debugLine="If mBase.NumberOfViews = 0 Then";
if (_vvvvvvvvvvvv5.getNumberOfViews()==0) { 
 //BA.debugLineNum = 18;BA.debugLine="Dim InnerPanel As B4XView = CallSub2(mTemplate,";
_innerpanel = new anywheresoftware.b4a.objects.B4XViewWrapper();
_innerpanel.setObject((java.lang.Object)(__c.CallSubNew2(ba,_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1,"GetPanel",(Object)(_dialog))));
 //BA.debugLineNum = 19;BA.debugLine="If InnerPanel.Parent.IsInitialized Then InnerPan";
if (_innerpanel.getParent().IsInitialized()) { 
_innerpanel.RemoveViewFromParent();};
 //BA.debugLineNum = 20;BA.debugLine="mBase.SetLayoutAnimated(0, 0, 0, InnerPanel.Widt";
_vvvvvvvvvvvv5.SetLayoutAnimated((int) (0),(int) (0),(int) (0),_innerpanel.getWidth(),(int) (_innerpanel.getHeight()+__c.DipToCurrent((int) (19))));
 //BA.debugLineNum = 21;BA.debugLine="mBase.LoadLayout(\"TimedDialogTemplate\")";
_vvvvvvvvvvvv5.LoadLayout("TimedDialogTemplate",ba);
 //BA.debugLineNum = 22;BA.debugLine="mBase.SetColorAndBorder(xui.Color_Transparent, 0";
_vvvvvvvvvvvv5.SetColorAndBorder(_vvvvvvvvvvvv6.Color_Transparent,(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 23;BA.debugLine="mBase.AddView(InnerPanel, 0, 19dip, InnerPanel.W";
_vvvvvvvvvvvv5.AddView((android.view.View)(_innerpanel.getObject()),(int) (0),__c.DipToCurrent((int) (19)),_innerpanel.getWidth(),_innerpanel.getHeight());
 };
 //BA.debugLineNum = 25;BA.debugLine="Return mBase";
if (true) return _vvvvvvvvvvvv5;
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _innertemplate) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 10;BA.debugLine="Public Sub Initialize (InnerTemplate As Object)";
 //BA.debugLineNum = 11;BA.debugLine="mBase = xui.CreatePanel(\"mBase\")";
_vvvvvvvvvvvv5 = _vvvvvvvvvvvv6.CreatePanel(ba,"mBase");
 //BA.debugLineNum = 12;BA.debugLine="mTemplate = InnerTemplate";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = _innertemplate;
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
public void  _show(com.stanks.andsokoban_full.b4xdialog _dialog) throws Exception{
ResumableSub_Show rsub = new ResumableSub_Show(this,_dialog);
rsub.resume(ba, null);
}
public static class ResumableSub_Show extends BA.ResumableSub {
public ResumableSub_Show(com.stanks.andsokoban_full.b4xtimedtemplate parent,com.stanks.andsokoban_full.b4xdialog _dialog) {
this.parent = parent;
this._dialog = _dialog;
}
com.stanks.andsokoban_full.b4xtimedtemplate parent;
com.stanks.andsokoban_full.b4xdialog _dialog;
int _myindex = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 29;BA.debugLine="CallSub2(mTemplate, \"Show\", Dialog)";
parent.__c.CallSubNew2(ba,parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1,"Show",(Object)(_dialog));
 //BA.debugLineNum = 30;BA.debugLine="AnotherProgressBar1.SetValueNoAnimation(0)";
parent._anotherprogressbar1._vvvvvvvvvvvvvvvvvvvvv5((int) (0));
 //BA.debugLineNum = 31;BA.debugLine="AnotherProgressBar1.ValueChangePerSecond = 100 /";
parent._anotherprogressbar1._vvvvvvvvvvvvvvvvvvvvvvv3 = (float) (100/(double)(parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2/(double)1000));
 //BA.debugLineNum = 32;BA.debugLine="AnotherProgressBar1.Value = 100";
parent._anotherprogressbar1._setvvvvvvvvvvvvvvvvvvvv1((int) (100));
 //BA.debugLineNum = 33;BA.debugLine="Index = Index + 1";
parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = (int) (parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3+1);
 //BA.debugLineNum = 34;BA.debugLine="Dim MyIndex As Int = Index";
_myindex = parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3;
 //BA.debugLineNum = 35;BA.debugLine="Sleep(TimeoutMilliseconds)";
parent.__c.Sleep(ba,this,parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2);
this.state = 5;
return;
case 5:
//C
this.state = 1;
;
 //BA.debugLineNum = 36;BA.debugLine="If MyIndex = Index Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_myindex==parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 37;BA.debugLine="Dialog.Close(xui.DialogResponse_Cancel)";
_dialog._vvvv3(parent._vvvvvvvvvvvv6.DialogResponse_Cancel);
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
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
