package com.stanks.andsokoban_full;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class swiftbutton extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.stanks.andsokoban_full.swiftbutton");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.stanks.andsokoban_full.swiftbutton.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _vvvvvvvvvvvv3 = "";
public Object _vvvvvvvvvvvv4 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _vvvvvvvvvvvv5 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _vvvvvvvvvvvv6 = null;
public anywheresoftware.b4a.objects.B4XCanvas _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = null;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = 0;
public boolean _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = false;
public Object _vvvvvvvvvvvv7 = null;
public boolean _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = false;
public b4a.example.dateutils _vvvvvvv3 = null;
public com.stanks.andsokoban_full.main _vvvvvvv4 = null;
public com.stanks.andsokoban_full.starter _vvvvvvv5 = null;
public com.stanks.andsokoban_full.play _vvvvvvv6 = null;
public com.stanks.andsokoban_full.odabir _vvvvvvv7 = null;
public com.stanks.andsokoban_full.video _vvvvvvv0 = null;
public com.stanks.andsokoban_full.rijesenja _vvvvvvvv1 = null;
public com.stanks.andsokoban_full.opcije _vvvvvvvv2 = null;
public String  _base_resize(double _width,double _height) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _v = null;
 //BA.debugLineNum = 39;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
 //BA.debugLineNum = 40;BA.debugLine="cvs.Resize(Width, Height)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Resize((float) (_width),(float) (_height));
 //BA.debugLineNum = 41;BA.debugLine="For Each v As B4XView In mBase.GetAllViewsRecursi";
_v = new anywheresoftware.b4a.objects.B4XViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group2 = _vvvvvvvvvvvv5.GetAllViewsRecursive();
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_v.setObject((java.lang.Object)(group2.Get(index2)));
 //BA.debugLineNum = 42;BA.debugLine="v.SetLayoutAnimated(0, 0, 0, Width, Height)";
_v.SetLayoutAnimated((int) (0),(int) (0),(int) (0),(int) (_width),(int) (_height));
 }
};
 //BA.debugLineNum = 44;BA.debugLine="Draw";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6();
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Private mEventName As String 'ignore";
_vvvvvvvvvvvv3 = "";
 //BA.debugLineNum = 7;BA.debugLine="Private mCallBack As Object 'ignore";
_vvvvvvvvvvvv4 = new Object();
 //BA.debugLineNum = 8;BA.debugLine="Public mBase As B4XView 'ignore";
_vvvvvvvvvvvv5 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 9;BA.debugLine="Private xui As XUI 'ignore";
_vvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 10;BA.debugLine="Private cvs As B4XCanvas";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 11;BA.debugLine="Public xLBL As B4XView";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 12;BA.debugLine="Private clr1, clr2, disabledColor As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0;
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = 0;
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = 0;
 //BA.debugLineNum = 13;BA.debugLine="Private pressed As Boolean";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = false;
 //BA.debugLineNum = 14;BA.debugLine="Public Tag As Object";
_vvvvvvvvvvvv7 = new Object();
 //BA.debugLineNum = 15;BA.debugLine="Private mDisabled As Boolean";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = false;
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
 //BA.debugLineNum = 23;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
 //BA.debugLineNum = 24;BA.debugLine="mBase = Base";
_vvvvvvvvvvvv5.setObject((java.lang.Object)(_base));
 //BA.debugLineNum = 25;BA.debugLine="Tag = mBase.Tag : mBase.Tag = Me";
_vvvvvvvvvvvv7 = _vvvvvvvvvvvv5.getTag();
 //BA.debugLineNum = 25;BA.debugLine="Tag = mBase.Tag : mBase.Tag = Me";
_vvvvvvvvvvvv5.setTag(this);
 //BA.debugLineNum = 26;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"p\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _vvvvvvvvvvvv6.CreatePanel(ba,"p");
 //BA.debugLineNum = 27;BA.debugLine="p.Color = xui.Color_Transparent";
_p.setColor(_vvvvvvvvvvvv6.Color_Transparent);
 //BA.debugLineNum = 28;BA.debugLine="clr1 = xui.PaintOrColorToColor(Props.Get(\"Primary";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = _vvvvvvvvvvvv6.PaintOrColorToColor(_props.Get((Object)("PrimaryColor")));
 //BA.debugLineNum = 29;BA.debugLine="clr2 = xui.PaintOrColorToColor(Props.Get(\"Seconda";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = _vvvvvvvvvvvv6.PaintOrColorToColor(_props.Get((Object)("SecondaryColor")));
 //BA.debugLineNum = 30;BA.debugLine="disabledColor = xui.PaintOrColorToColor(Props.Get";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = _vvvvvvvvvvvv6.PaintOrColorToColor(_props.GetDefault((Object)("DisabledColor"),(Object)(0xff999999)));
 //BA.debugLineNum = 31;BA.debugLine="xLBL = Lbl";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.setObject((java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 32;BA.debugLine="mBase.AddView(xLBL, 0, 0, 0, 0)";
_vvvvvvvvvvvv5.AddView((android.view.View)(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getObject()),(int) (0),(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 33;BA.debugLine="mBase.AddView(p, 0, 0, 0, 0)";
_vvvvvvvvvvvv5.AddView((android.view.View)(_p.getObject()),(int) (0),(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 34;BA.debugLine="xLBL.SetTextAlignment(\"CENTER\", \"CENTER\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.SetTextAlignment("CENTER","CENTER");
 //BA.debugLineNum = 35;BA.debugLine="cvs.Initialize(mBase)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Initialize(_vvvvvvvvvvvv5);
 //BA.debugLineNum = 36;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_vvvvvvvvvvvv5.getWidth(),_vvvvvvvvvvvv5.getHeight());
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6() throws Exception{
int _gap = 0;
int _corners = 0;
anywheresoftware.b4a.objects.B4XCanvas.B4XRect _r = null;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _p = null;
int _c = 0;
 //BA.debugLineNum = 90;BA.debugLine="Private Sub Draw";
 //BA.debugLineNum = 91;BA.debugLine="cvs.ClearRect(cvs.TargetRect)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.ClearRect(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.getTargetRect());
 //BA.debugLineNum = 92;BA.debugLine="Dim gap As Int = 5dip";
_gap = __c.DipToCurrent((int) (5));
 //BA.debugLineNum = 93;BA.debugLine="Dim corners As Int = 15dip";
_corners = __c.DipToCurrent((int) (15));
 //BA.debugLineNum = 94;BA.debugLine="Dim r As B4XRect";
_r = new anywheresoftware.b4a.objects.B4XCanvas.B4XRect();
 //BA.debugLineNum = 95;BA.debugLine="Dim p As B4XPath";
_p = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 96;BA.debugLine="r.Initialize(0, gap, mBase.Width, mBase.Height)";
_r.Initialize((float) (0),(float) (_gap),(float) (_vvvvvvvvvvvv5.getWidth()),(float) (_vvvvvvvvvvvv5.getHeight()));
 //BA.debugLineNum = 97;BA.debugLine="If pressed = False Then";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7==__c.False) { 
 //BA.debugLineNum = 98;BA.debugLine="xLBL.Top = 0";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.setTop((int) (0));
 //BA.debugLineNum = 99;BA.debugLine="p.InitializeRoundedRect(r, corners)";
_p.InitializeRoundedRect(_r,(float) (_corners));
 //BA.debugLineNum = 100;BA.debugLine="cvs.DrawPath(p, clr2, True, 0)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.DrawPath(_p,_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5,__c.True,(float) (0));
 //BA.debugLineNum = 101;BA.debugLine="r.Initialize(0, 0, mBase.Width, mBase.Height - g";
_r.Initialize((float) (0),(float) (0),(float) (_vvvvvvvvvvvv5.getWidth()),(float) (_vvvvvvvvvvvv5.getHeight()-_gap));
 //BA.debugLineNum = 102;BA.debugLine="p.InitializeRoundedRect(r, corners)";
_p.InitializeRoundedRect(_r,(float) (_corners));
 //BA.debugLineNum = 103;BA.debugLine="cvs.DrawPath(p, clr1, True, 0)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.DrawPath(_p,_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4,__c.True,(float) (0));
 }else {
 //BA.debugLineNum = 105;BA.debugLine="xLBL.Top = gap";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.setTop(_gap);
 //BA.debugLineNum = 106;BA.debugLine="p.InitializeRoundedRect(r, corners)";
_p.InitializeRoundedRect(_r,(float) (_corners));
 //BA.debugLineNum = 107;BA.debugLine="Dim c As Int";
_c = 0;
 //BA.debugLineNum = 108;BA.debugLine="If mDisabled Then c = disabledColor Else c = clr";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0) { 
_c = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6;}
else {
_c = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4;};
 //BA.debugLineNum = 109;BA.debugLine="cvs.DrawPath(p, c, True, 0)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.DrawPath(_p,_c,__c.True,(float) (0));
 };
 //BA.debugLineNum = 112;BA.debugLine="cvs.Invalidate";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Invalidate();
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
return "";
}
public boolean  _getvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3() throws Exception{
 //BA.debugLineNum = 47;BA.debugLine="Public Sub getEnabled As Boolean";
 //BA.debugLineNum = 48;BA.debugLine="Return Not(mDisabled)";
if (true) return __c.Not(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0);
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return false;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 18;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 19;BA.debugLine="mEventName = EventName";
_vvvvvvvvvvvv3 = _eventname;
 //BA.debugLineNum = 20;BA.debugLine="mCallBack = Callback";
_vvvvvvvvvvvv4 = _callback;
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public String  _p_touch(int _action,float _x,float _y) throws Exception{
boolean _inside = false;
 //BA.debugLineNum = 57;BA.debugLine="Private Sub p_Touch (Action As Int, X As Float, Y";
 //BA.debugLineNum = 58;BA.debugLine="If mDisabled Then Return";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0) { 
if (true) return "";};
 //BA.debugLineNum = 59;BA.debugLine="Dim Inside As Boolean = x > 0 And x < mBase.Width";
_inside = _x>0 && _x<_vvvvvvvvvvvv5.getWidth() && _y>0 && _y<_vvvvvvvvvvvv5.getHeight();
 //BA.debugLineNum = 60;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,_vvvvvvvvvvvv5.TOUCH_ACTION_DOWN,_vvvvvvvvvvvv5.TOUCH_ACTION_MOVE,_vvvvvvvvvvvv5.TOUCH_ACTION_UP)) {
case 0: {
 //BA.debugLineNum = 62;BA.debugLine="pressed = True";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = __c.True;
 //BA.debugLineNum = 63;BA.debugLine="Draw";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6();
 break; }
case 1: {
 //BA.debugLineNum = 65;BA.debugLine="If pressed <> Inside Then";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7!=_inside) { 
 //BA.debugLineNum = 66;BA.debugLine="pressed = Inside";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = _inside;
 //BA.debugLineNum = 67;BA.debugLine="Draw";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6();
 };
 break; }
case 2: {
 //BA.debugLineNum = 70;BA.debugLine="pressed = False";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = __c.False;
 //BA.debugLineNum = 71;BA.debugLine="Draw";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6();
 //BA.debugLineNum = 72;BA.debugLine="If Inside Then";
if (_inside) { 
 //BA.debugLineNum = 73;BA.debugLine="CallSubDelayed(mCallBack, mEventName & \"_Click";
__c.CallSubDelayed(ba,_vvvvvvvvvvvv4,_vvvvvvvvvvvv3+"_Click");
 };
 break; }
}
;
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1(int _primary,int _secondary) throws Exception{
 //BA.debugLineNum = 84;BA.debugLine="Public Sub SetColors(Primary As Int, Secondary As";
 //BA.debugLineNum = 85;BA.debugLine="clr1 = Primary";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = _primary;
 //BA.debugLineNum = 86;BA.debugLine="clr2 = Secondary";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = _secondary;
 //BA.debugLineNum = 87;BA.debugLine="Draw";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6();
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return "";
}
public String  _setvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3(boolean _b) throws Exception{
 //BA.debugLineNum = 51;BA.debugLine="Public Sub setEnabled(b As Boolean)";
 //BA.debugLineNum = 52;BA.debugLine="mDisabled = Not(b)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = __c.Not(_b);
 //BA.debugLineNum = 53;BA.debugLine="pressed = mDisabled";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0;
 //BA.debugLineNum = 54;BA.debugLine="Draw";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6();
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
