package com.stanks.andsokoban_full;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xcombobox extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.stanks.andsokoban_full.b4xcombobox");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.stanks.andsokoban_full.b4xcombobox.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _vvvvvvvvvvvv3 = "";
public Object _vvvvvvvvvvvv4 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _vvvvvvvvvvvv5 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _vvvvvvvvvvvv6 = null;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0;
public anywheresoftware.b4a.objects.SpinnerWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = null;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = 0;
public Object _vvvvvvvvvvvv7 = null;
public b4a.example.dateutils _vvvvvvv3 = null;
public com.stanks.andsokoban_full.main _vvvvvvv4 = null;
public com.stanks.andsokoban_full.starter _vvvvvvv5 = null;
public com.stanks.andsokoban_full.play _vvvvvvv6 = null;
public com.stanks.andsokoban_full.odabir _vvvvvvv7 = null;
public com.stanks.andsokoban_full.video _vvvvvvv0 = null;
public com.stanks.andsokoban_full.rijesenja _vvvvvvvv1 = null;
public com.stanks.andsokoban_full.opcije _vvvvvvvv2 = null;
public String  _base_resize(double _width,double _height) throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
 //BA.debugLineNum = 55;BA.debugLine="mBase.GetView(0).SetLayoutAnimated(0, 0, 0, Width";
_vvvvvvvvvvvv5.GetView((int) (0)).SetLayoutAnimated((int) (0),(int) (0),(int) (0),(int) (_width),(int) (_height));
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private mEventName As String 'ignore";
_vvvvvvvvvvvv3 = "";
 //BA.debugLineNum = 4;BA.debugLine="Private mCallBack As Object 'ignore";
_vvvvvvvvvvvv4 = new Object();
 //BA.debugLineNum = 5;BA.debugLine="Public mBase As B4XView";
_vvvvvvvvvvvv5 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 6;BA.debugLine="Private xui As XUI 'ignore";
_vvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 7;BA.debugLine="Private LastSelectedIndex As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0;
 //BA.debugLineNum = 11;BA.debugLine="Public cmbBox As Spinner";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Public DelayBeforeChangeEvent As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = 0;
 //BA.debugLineNum = 19;BA.debugLine="Private DelayIndex As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = 0;
 //BA.debugLineNum = 20;BA.debugLine="Public Tag As Object";
_vvvvvvvvvvvv7 = new Object();
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public String  _cmbbox_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 124;BA.debugLine="Private Sub CmbBox_ItemClick (Position As Int, Val";
 //BA.debugLineNum = 125;BA.debugLine="RaiseEvent";
_vvvvvvvvvvvvvvvvvvvvvvvvvvv7();
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _xlbl = null;
 //BA.debugLineNum = 31;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
 //BA.debugLineNum = 32;BA.debugLine="mBase = Base";
_vvvvvvvvvvvv5.setObject((java.lang.Object)(_base));
 //BA.debugLineNum = 33;BA.debugLine="Tag = mBase.Tag : mBase.Tag = Me";
_vvvvvvvvvvvv7 = _vvvvvvvvvvvv5.getTag();
 //BA.debugLineNum = 33;BA.debugLine="Tag = mBase.Tag : mBase.Tag = Me";
_vvvvvvvvvvvv5.setTag(this);
 //BA.debugLineNum = 34;BA.debugLine="Dim xlbl As B4XView = Lbl";
_xlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xlbl.setObject((java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 41;BA.debugLine="cmbBox.Initialize(\"cmbBox\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Initialize(ba,"cmbBox");
 //BA.debugLineNum = 42;BA.debugLine="cmbBox.TextSize = xlbl.TextSize";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvv4.setTextSize(_xlbl.getTextSize());
 //BA.debugLineNum = 43;BA.debugLine="mBase.AddView(cmbBox, 0, 0, mBase.Width, mBase.He";
_vvvvvvvvvvvv5.AddView((android.view.View)(_vvvvvvvvvvvvvvvvvvvvvvvvvvvv4.getObject()),(int) (0),(int) (0),_vvvvvvvvvvvv5.getWidth(),_vvvvvvvvvvvv5.getHeight());
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvvvvvvvvvvvvvvvvvv5(int _index) throws Exception{
 //BA.debugLineNum = 96;BA.debugLine="Public Sub GetItem(Index As Int) As String";
 //BA.debugLineNum = 100;BA.debugLine="Return cmbBox.GetItem(Index)";
if (true) return _vvvvvvvvvvvvvvvvvvvvvvvvvvvv4.GetItem(_index);
 //BA.debugLineNum = 104;BA.debugLine="End Sub";
return "";
}
public int  _getvvvvvvvvvvvvvvvvvvvvvvvvvvvv2() throws Exception{
 //BA.debugLineNum = 74;BA.debugLine="Public Sub getSelectedIndex As Int";
 //BA.debugLineNum = 76;BA.debugLine="Return cmbBox.SelectedIndex";
if (true) return _vvvvvvvvvvvvvvvvvvvvvvvvvvvv4.getSelectedIndex();
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return 0;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 23;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 24;BA.debugLine="mEventName = EventName";
_vvvvvvvvvvvv3 = _eventname;
 //BA.debugLineNum = 25;BA.debugLine="mCallBack = Callback";
_vvvvvvvvvvvv4 = _callback;
 //BA.debugLineNum = 26;BA.debugLine="LastSelectedIndex = -1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = (int) (-1);
 //BA.debugLineNum = 27;BA.debugLine="If xui.IsB4J Then DelayBeforeChangeEvent = 500";
if (_vvvvvvvvvvvv6.getIsB4J()) { 
_vvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = (int) (500);};
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public void  _vvvvvvvvvvvvvvvvvvvvvvvvvvv7() throws Exception{
ResumableSub_RaiseEvent rsub = new ResumableSub_RaiseEvent(this);
rsub.resume(ba, null);
}
public static class ResumableSub_RaiseEvent extends BA.ResumableSub {
public ResumableSub_RaiseEvent(com.stanks.andsokoban_full.b4xcombobox parent) {
this.parent = parent;
}
com.stanks.andsokoban_full.b4xcombobox parent;
int _index = 0;
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
 //BA.debugLineNum = 107;BA.debugLine="Dim index As Int = getSelectedIndex";
_index = parent._getvvvvvvvvvvvvvvvvvvvvvvvvvvvv2();
 //BA.debugLineNum = 108;BA.debugLine="If LastSelectedIndex = index Then Return";
if (true) break;

case 1:
//if
this.state = 6;
if (parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvv3==_index) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) return ;
if (true) break;

case 6:
//C
this.state = 7;
;
 //BA.debugLineNum = 109;BA.debugLine="If DelayBeforeChangeEvent > 0 Then";
if (true) break;

case 7:
//if
this.state = 16;
if (parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvv5>0) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 110;BA.debugLine="DelayIndex = DelayIndex + 1";
parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = (int) (parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvv6+1);
 //BA.debugLineNum = 111;BA.debugLine="Dim MyIndex As Int = DelayIndex";
_myindex = parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvv6;
 //BA.debugLineNum = 112;BA.debugLine="Sleep(DelayBeforeChangeEvent)";
parent.__c.Sleep(ba,this,parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvv5);
this.state = 17;
return;
case 17:
//C
this.state = 10;
;
 //BA.debugLineNum = 113;BA.debugLine="If MyIndex <> DelayIndex Then Return";
if (true) break;

case 10:
//if
this.state = 15;
if (_myindex!=parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvv6) { 
this.state = 12;
;}if (true) break;

case 12:
//C
this.state = 15;
if (true) return ;
if (true) break;

case 15:
//C
this.state = 16;
;
 if (true) break;

case 16:
//C
this.state = -1;
;
 //BA.debugLineNum = 115;BA.debugLine="LastSelectedIndex = index";
parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = _index;
 //BA.debugLineNum = 116;BA.debugLine="CallSub2(mCallBack, mEventName & \"_SelectedIndexC";
parent.__c.CallSubNew2(ba,parent._vvvvvvvvvvvv4,parent._vvvvvvvvvvvv3+"_SelectedIndexChanged",(Object)(_index));
 //BA.debugLineNum = 117;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _vvvvvvvvvvvvvvvvvvvvvvvvvvv0(anywheresoftware.b4a.objects.collections.List _items) throws Exception{
 //BA.debugLineNum = 58;BA.debugLine="Public Sub SetItems(Items As List)";
 //BA.debugLineNum = 63;BA.debugLine="cmbBox.Clear";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Clear();
 //BA.debugLineNum = 64;BA.debugLine="cmbBox.AddAll(Items)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvv4.AddAll(_items);
 //BA.debugLineNum = 71;BA.debugLine="If Items.Size > 0 Then setSelectedIndex(0)";
if (_items.getSize()>0) { 
_setvvvvvvvvvvvvvvvvvvvvvvvvvvvv2((int) (0));};
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return "";
}
public String  _setvvvvvvvvvvvvvvvvvvvvvvvvvvvv2(int _i) throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Public Sub setSelectedIndex(i As Int)";
 //BA.debugLineNum = 83;BA.debugLine="LastSelectedIndex = i";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = _i;
 //BA.debugLineNum = 85;BA.debugLine="cmbBox.SelectedIndex = i";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvv4.setSelectedIndex(_i);
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
