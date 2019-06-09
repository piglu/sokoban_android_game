package com.stanks.andsokoban_full;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class roundslider extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.stanks.andsokoban_full.roundslider");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.stanks.andsokoban_full.roundslider.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _vvvvvvvvvvvv3 = "";
public Object _vvvvvvvvvvvv4 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _vvvvvvvvvvvv5 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _vvvvvvvvvvvv6 = null;
public anywheresoftware.b4a.objects.B4XCanvas _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = null;
public int _vvvvvvvvvvvvvvvvvvvv5 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = 0;
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = null;
public anywheresoftware.b4a.objects.B4XCanvas.B4XRect _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = null;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0;
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
 //BA.debugLineNum = 67;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
 //BA.debugLineNum = 68;BA.debugLine="cvs.Resize(Width, Height)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Resize((float) (_width),(float) (_height));
 //BA.debugLineNum = 69;BA.debugLine="pnl.SetLayoutAnimated(0, 0, 0, Width, Height)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.SetLayoutAnimated((int) (0),(int) (0),(int) (0),(int) (_width),(int) (_height));
 //BA.debugLineNum = 70;BA.debugLine="If thumb.IsInitialized = False Then CreateThumb";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.IsInitialized()==__c.False) { 
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3();};
 //BA.debugLineNum = 71;BA.debugLine="CircleRect.Initialize(ThumbSize + stroke, ThumbSi";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.Initialize((float) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4+_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3),(float) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4+_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3),(float) (_width-_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4-_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3),(float) (_height-_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4-_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3));
 //BA.debugLineNum = 72;BA.debugLine="xlbl.SetLayoutAnimated(0, CircleRect.Left, Circle";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.SetLayoutAnimated((int) (0),(int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getLeft()),(int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getTop()),(int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getWidth()),(int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getHeight()));
 //BA.debugLineNum = 73;BA.debugLine="Draw";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6();
 //BA.debugLineNum = 74;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Private mValue As Int = 75";
_vvvvvvvvvvvvvvvvvvvv5 = (int) (75);
 //BA.debugLineNum = 12;BA.debugLine="Private mMin, mMax As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0;
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = 0;
 //BA.debugLineNum = 13;BA.debugLine="Private thumb As B4XBitmap";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private pnl As B4XView";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private xlbl As B4XView";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private CircleRect As B4XRect";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = new anywheresoftware.b4a.objects.B4XCanvas.B4XRect();
 //BA.debugLineNum = 17;BA.debugLine="Private ValueColor As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = 0;
 //BA.debugLineNum = 18;BA.debugLine="Private stroke As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0;
 //BA.debugLineNum = 19;BA.debugLine="Private ThumbSize As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0;
 //BA.debugLineNum = 20;BA.debugLine="Public Tag As Object";
_vvvvvvvvvvvv7 = new Object();
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3() throws Exception{
b4a.example.bcpath _p = null;
int _r = 0;
int _g = 0;
int _l = 0;
b4a.example.bitmapcreator _bc = null;
 //BA.debugLineNum = 48;BA.debugLine="Private Sub CreateThumb";
 //BA.debugLineNum = 49;BA.debugLine="Dim p As BCPath";
_p = new b4a.example.bcpath();
 //BA.debugLineNum = 50;BA.debugLine="Dim r As Int = 80dip";
_r = __c.DipToCurrent((int) (80));
 //BA.debugLineNum = 51;BA.debugLine="Dim g As Int = 8dip";
_g = __c.DipToCurrent((int) (8));
 //BA.debugLineNum = 52;BA.debugLine="Dim l As Int = 28dip";
_l = __c.DipToCurrent((int) (28));
 //BA.debugLineNum = 53;BA.debugLine="Dim bc As BitmapCreator";
_bc = new b4a.example.bitmapcreator();
 //BA.debugLineNum = 54;BA.debugLine="bc.Initialize(2 * r + g + 3dip, 2 * r + l + g)";
_bc._initialize(ba,(int) (2*_r+_g+__c.DipToCurrent((int) (3))),(int) (2*_r+_l+_g));
 //BA.debugLineNum = 55;BA.debugLine="p.Initialize(r - l + g, 2 * r - 2dip + g)";
_p._initialize(ba,(float) (_r-_l+_g),(float) (2*_r-__c.DipToCurrent((int) (2))+_g));
 //BA.debugLineNum = 56;BA.debugLine="p.LineTo(r + l + g, 2 * r - 2dip + g)";
_p._lineto((float) (_r+_l+_g),(float) (2*_r-__c.DipToCurrent((int) (2))+_g));
 //BA.debugLineNum = 57;BA.debugLine="p.LineTo(r + g, 2 * r + l + g)";
_p._lineto((float) (_r+_g),(float) (2*_r+_l+_g));
 //BA.debugLineNum = 58;BA.debugLine="p.LineTo(r - l + g, 2 * r - 2dip + g)";
_p._lineto((float) (_r-_l+_g),(float) (2*_r-__c.DipToCurrent((int) (2))+_g));
 //BA.debugLineNum = 59;BA.debugLine="bc.DrawPath(p, 0xFF5B5B5B, True, 0)";
_bc._drawpath(_p,(int) (0xff5b5b5b),__c.True,(int) (0));
 //BA.debugLineNum = 60;BA.debugLine="bc.DrawCircle(r + g, r + g, r, xui.Color_White, T";
_bc._drawcircle((float) (_r+_g),(float) (_r+_g),(float) (_r),_vvvvvvvvvvvv6.Color_White,__c.True,(int) (0));
 //BA.debugLineNum = 61;BA.debugLine="bc.DrawCircle(r + g, r + g, r, 0xFF5B5B5B, False,";
_bc._drawcircle((float) (_r+_g),(float) (_r+_g),(float) (_r),(int) (0xff5b5b5b),__c.False,__c.DipToCurrent((int) (10)));
 //BA.debugLineNum = 62;BA.debugLine="thumb = bc.Bitmap";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = _bc._getbitmap();
 //BA.debugLineNum = 63;BA.debugLine="ThumbSize = thumb.Height / 4";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getHeight()/(double)4);
 //BA.debugLineNum = 64;BA.debugLine="xlbl.SetTextAlignment(\"CENTER\", \"CENTER\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.SetTextAlignment("CENTER","CENTER");
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 29;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
 //BA.debugLineNum = 30;BA.debugLine="mBase = Base";
_vvvvvvvvvvvv5.setObject((java.lang.Object)(_base));
 //BA.debugLineNum = 31;BA.debugLine="Tag = mBase.Tag : mBase.Tag = Me";
_vvvvvvvvvvvv7 = _vvvvvvvvvvvv5.getTag();
 //BA.debugLineNum = 31;BA.debugLine="Tag = mBase.Tag : mBase.Tag = Me";
_vvvvvvvvvvvv5.setTag(this);
 //BA.debugLineNum = 32;BA.debugLine="cvs.Initialize(mBase)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Initialize(_vvvvvvvvvvvv5);
 //BA.debugLineNum = 33;BA.debugLine="mMin = Props.Get(\"Min\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = (int)(BA.ObjectToNumber(_props.Get((Object)("Min"))));
 //BA.debugLineNum = 34;BA.debugLine="mMax = Props.Get(\"Max\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = (int)(BA.ObjectToNumber(_props.Get((Object)("Max"))));
 //BA.debugLineNum = 35;BA.debugLine="pnl = xui.CreatePanel(\"pnl\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = _vvvvvvvvvvvv6.CreatePanel(ba,"pnl");
 //BA.debugLineNum = 36;BA.debugLine="xlbl = Lbl";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.setObject((java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 37;BA.debugLine="mBase.AddView(xlbl, 0, 0, 0, 0)";
_vvvvvvvvvvvv5.AddView((android.view.View)(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getObject()),(int) (0),(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 38;BA.debugLine="mBase.AddView(pnl, 0, 0, 0, 0)";
_vvvvvvvvvvvv5.AddView((android.view.View)(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.getObject()),(int) (0),(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 39;BA.debugLine="ValueColor = xui.PaintOrColorToColor(Props.Get(\"V";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = _vvvvvvvvvvvv6.PaintOrColorToColor(_props.Get((Object)("ValueColor")));
 //BA.debugLineNum = 40;BA.debugLine="If xui.IsB4A Or xui.IsB4i Then";
if (_vvvvvvvvvvvv6.getIsB4A() || _vvvvvvvvvvvv6.getIsB4i()) { 
 //BA.debugLineNum = 41;BA.debugLine="stroke = 8dip";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = __c.DipToCurrent((int) (8));
 }else if(_vvvvvvvvvvvv6.getIsB4J()) { 
 //BA.debugLineNum = 43;BA.debugLine="stroke = 6dip";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = __c.DipToCurrent((int) (6));
 };
 //BA.debugLineNum = 45;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_vvvvvvvvvvvv5.getWidth(),_vvvvvvvvvvvv5.getHeight());
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6() throws Exception{
int _radius = 0;
anywheresoftware.b4a.objects.B4XCanvas.B4XPath _p = null;
int _angle = 0;
int _b4jstrokeoffset = 0;
anywheresoftware.b4a.objects.B4XCanvas.B4XRect _dest = null;
int _r = 0;
int _cx = 0;
int _cy = 0;
 //BA.debugLineNum = 76;BA.debugLine="Private Sub Draw";
 //BA.debugLineNum = 77;BA.debugLine="cvs.ClearRect(cvs.TargetRect)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.ClearRect(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.getTargetRect());
 //BA.debugLineNum = 78;BA.debugLine="Dim radius As Int = CircleRect.Width / 2";
_radius = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getWidth()/(double)2);
 //BA.debugLineNum = 79;BA.debugLine="cvs.DrawCircle(CircleRect.CenterX, CircleRect.Cen";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.DrawCircle(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getCenterX(),_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getCenterY(),(float) (_radius),(int) (0xffb6b6b6),__c.False,(float) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3));
 //BA.debugLineNum = 80;BA.debugLine="Dim p As B4XPath";
_p = new anywheresoftware.b4a.objects.B4XCanvas.B4XPath();
 //BA.debugLineNum = 81;BA.debugLine="Dim angle As Int = (mValue - mMin) / (mMax - mMin";
_angle = (int) ((_vvvvvvvvvvvvvvvvvvvv5-_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4)/(double)(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5-_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4)*360);
 //BA.debugLineNum = 82;BA.debugLine="Dim B4JStrokeOffset As Int";
_b4jstrokeoffset = 0;
 //BA.debugLineNum = 83;BA.debugLine="If xui.IsB4J Then B4JStrokeOffset = stroke / 2";
if (_vvvvvvvvvvvv6.getIsB4J()) { 
_b4jstrokeoffset = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3/(double)2);};
 //BA.debugLineNum = 84;BA.debugLine="p.InitializeArc(CircleRect.CenterX, CircleRect.Ce";
_p.InitializeArc(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getCenterX(),_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getCenterY(),(float) (_radius+_b4jstrokeoffset),(float) (-90),(float) (_angle));
 //BA.debugLineNum = 85;BA.debugLine="cvs.DrawPath(p, ValueColor, False, stroke)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.DrawPath(_p,_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2,__c.False,(float) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3));
 //BA.debugLineNum = 86;BA.debugLine="cvs.DrawCircle(CircleRect.CenterX, CircleRect.Cen";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.DrawCircle(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getCenterX(),_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getCenterY(),(float) (_radius-_b4jstrokeoffset),_vvvvvvvvvvvv6.Color_White,__c.True,(float) (0));
 //BA.debugLineNum = 87;BA.debugLine="Dim dest As B4XRect";
_dest = new anywheresoftware.b4a.objects.B4XCanvas.B4XRect();
 //BA.debugLineNum = 88;BA.debugLine="Dim r As Int = radius + ThumbSize / 2 + stroke /";
_r = (int) (_radius+_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4/(double)2+_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3/(double)2);
 //BA.debugLineNum = 89;BA.debugLine="Dim cx As Int = CircleRect.CenterX + r * CosD(ang";
_cx = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getCenterX()+_r*__c.CosD(_angle-90));
 //BA.debugLineNum = 90;BA.debugLine="Dim cy As Int = CircleRect.CenterY + r * SinD(ang";
_cy = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getCenterY()+_r*__c.SinD(_angle-90));
 //BA.debugLineNum = 91;BA.debugLine="dest.Initialize(cx - thumb.Width / 8, cy - ThumbS";
_dest.Initialize((float) (_cx-_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getWidth()/(double)8),(float) (_cy-_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4/(double)2),(float) (_cx+_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getWidth()/(double)8),(float) (_cy+_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4/(double)2));
 //BA.debugLineNum = 92;BA.debugLine="cvs.DrawBitmapRotated(thumb, dest, angle)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.DrawBitmapRotated((android.graphics.Bitmap)(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getObject()),_dest,(float) (_angle));
 //BA.debugLineNum = 93;BA.debugLine="cvs.Invalidate";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Invalidate();
 //BA.debugLineNum = 94;BA.debugLine="xlbl.Text = mValue";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.setText(BA.ObjectToCharSequence(_vvvvvvvvvvvvvvvvvvvv5));
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public int  _getvvvvvvvvvvvvvvvvvvvv1() throws Exception{
 //BA.debugLineNum = 121;BA.debugLine="Public Sub getValue As Int";
 //BA.debugLineNum = 122;BA.debugLine="Return mValue";
if (true) return _vvvvvvvvvvvvvvvvvvvv5;
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
return 0;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 23;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 24;BA.debugLine="mEventName = EventName";
_vvvvvvvvvvvv3 = _eventname;
 //BA.debugLineNum = 25;BA.debugLine="mCallBack = Callback";
_vvvvvvvvvvvv4 = _callback;
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return "";
}
public String  _pnl_touch(int _action,float _x,float _y) throws Exception{
int _dx = 0;
int _dy = 0;
float _dist = 0f;
int _angle = 0;
int _newvalue = 0;
 //BA.debugLineNum = 97;BA.debugLine="Private Sub pnl_Touch (Action As Int, X As Float,";
 //BA.debugLineNum = 98;BA.debugLine="If Action = pnl.TOUCH_ACTION_MOVE_NOTOUCH Then Re";
if (_action==_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.TOUCH_ACTION_MOVE_NOTOUCH) { 
if (true) return "";};
 //BA.debugLineNum = 99;BA.debugLine="Dim dx As Int = x - CircleRect.CenterX";
_dx = (int) (_x-_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getCenterX());
 //BA.debugLineNum = 100;BA.debugLine="Dim dy As Int = y - CircleRect.CenterY";
_dy = (int) (_y-_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getCenterY());
 //BA.debugLineNum = 101;BA.debugLine="Dim dist As Float = Sqrt(Power(dx, 2) + Power(dy,";
_dist = (float) (__c.Sqrt(__c.Power(_dx,2)+__c.Power(_dy,2)));
 //BA.debugLineNum = 102;BA.debugLine="If dist > CircleRect.Width / 2 Then";
if (_dist>_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getWidth()/(double)2) { 
 //BA.debugLineNum = 103;BA.debugLine="Dim angle As Int = Round(ATan2D(dy, dx))";
_angle = (int) (__c.Round(__c.ATan2D(_dy,_dx)));
 //BA.debugLineNum = 104;BA.debugLine="angle = angle + 90";
_angle = (int) (_angle+90);
 //BA.debugLineNum = 105;BA.debugLine="angle = (angle + 360) Mod 360";
_angle = (int) ((_angle+360)%360);
 //BA.debugLineNum = 106;BA.debugLine="Dim NewValue As Int = mMin + angle / 360 * (mMax";
_newvalue = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4+_angle/(double)360*(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5-_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4));
 //BA.debugLineNum = 107;BA.debugLine="NewValue = Max(mMin, Min(mMax, NewValue))";
_newvalue = (int) (__c.Max(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4,__c.Min(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5,_newvalue)));
 //BA.debugLineNum = 108;BA.debugLine="If NewValue <> mValue Then";
if (_newvalue!=_vvvvvvvvvvvvvvvvvvvv5) { 
 //BA.debugLineNum = 109;BA.debugLine="mValue = NewValue";
_vvvvvvvvvvvvvvvvvvvv5 = _newvalue;
 //BA.debugLineNum = 110;BA.debugLine="CallSub2(mCallBack, mEventName & \"_ValueChanged";
__c.CallSubNew2(ba,_vvvvvvvvvvvv4,_vvvvvvvvvvvv3+"_ValueChanged",(Object)(_vvvvvvvvvvvvvvvvvvvv5));
 };
 //BA.debugLineNum = 112;BA.debugLine="Draw";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6();
 };
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
public String  _setvvvvvvvvvvvvvvvvvvvv1(int _v) throws Exception{
 //BA.debugLineNum = 116;BA.debugLine="Public Sub setValue (v As Int)";
 //BA.debugLineNum = 117;BA.debugLine="mValue = Max(mMin, Min(mMax, v))";
_vvvvvvvvvvvvvvvvvvvv5 = (int) (__c.Max(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4,__c.Min(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5,_v)));
 //BA.debugLineNum = 118;BA.debugLine="Draw";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6();
 //BA.debugLineNum = 119;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
