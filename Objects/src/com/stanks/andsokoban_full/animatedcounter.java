package com.stanks.andsokoban_full;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class animatedcounter extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.stanks.andsokoban_full.animatedcounter");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.stanks.andsokoban_full.animatedcounter.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = "";
public Object _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = null;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = 0;
public anywheresoftware.b4a.objects.B4XViewWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = null;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = 0;
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = null;
public Object _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = null;
public b4a.example.dateutils _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = null;
public com.stanks.andsokoban_full.main _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = null;
public com.stanks.andsokoban_full.starter _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = null;
public com.stanks.andsokoban_full.play _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = null;
public com.stanks.andsokoban_full.video _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = null;
public com.stanks.andsokoban_full.rijesenja _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = null;
public com.stanks.andsokoban_full.opcije _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = null;
public String  _base_resize(double _width,double _height) throws Exception{
int _columns = 0;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _bmp = null;
int _left = 0;
int _i = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _iv = null;
 //BA.debugLineNum = 67;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
 //BA.debugLineNum = 68;BA.debugLine="mBase.GetView(0).SetLayoutAnimated(0, 0, 0, Width";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.GetView((int) (0)).SetLayoutAnimated((int) (0),(int) (0),(int) (0),(int) (_width),(int) (_height));
 //BA.debugLineNum = 69;BA.debugLine="xfadeIv.SetLayoutAnimated(0, 0, 0, Width, Height)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.SetLayoutAnimated((int) (0),(int) (0),(int) (0),(int) (_width),(int) (_height));
 //BA.debugLineNum = 70;BA.debugLine="xfadeIv.SetBitmap(fade.Resize(Width, Height, Fals";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.SetBitmap((android.graphics.Bitmap)(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Resize((int) (_width),(int) (_height),__c.False).getObject()));
 //BA.debugLineNum = 71;BA.debugLine="DigitHeight = Height";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = (int) (_height);
 //BA.debugLineNum = 72;BA.debugLine="Dim Columns As Int = mdigits";
_columns = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5;
 //BA.debugLineNum = 73;BA.debugLine="DigitWidth = Width / Columns";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = (int) (_width/(double)_columns);
 //BA.debugLineNum = 74;BA.debugLine="Dim bmp As B4XBitmap = CreateBitmap(lblTemplate)";
_bmp = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
_bmp = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6);
 //BA.debugLineNum = 75;BA.debugLine="Dim left As Int = Width";
_left = (int) (_width);
 //BA.debugLineNum = 76;BA.debugLine="For i = 0 To ImageViews.Size - 1";
{
final int step9 = 1;
final int limit9 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
 //BA.debugLineNum = 77;BA.debugLine="Dim iv As B4XView = ImageViews.Get(i)";
_iv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_iv.setObject((java.lang.Object)(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Get(_i)));
 //BA.debugLineNum = 79;BA.debugLine="left = left - DigitWidth";
_left = (int) (_left-_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1);
 //BA.debugLineNum = 80;BA.debugLine="iv.SetLayoutAnimated(0, left, TopFromValue(i), D";
_iv.SetLayoutAnimated((int) (0),_left,_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6(_i),_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1,(int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0*10));
 //BA.debugLineNum = 81;BA.debugLine="iv.SetBitmap(bmp)";
_iv.SetBitmap((android.graphics.Bitmap)(_bmp.getObject()));
 }
};
 //BA.debugLineNum = 83;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Private mEventName As String 'ignore";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = "";
 //BA.debugLineNum = 6;BA.debugLine="Private mCallBack As Object 'ignore";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = new Object();
 //BA.debugLineNum = 7;BA.debugLine="Public mBase As B4XView 'ignore";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 8;BA.debugLine="Private xui As XUI 'ignore";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 9;BA.debugLine="Private ImageViews As List";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 10;BA.debugLine="Private mdigits As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = 0;
 //BA.debugLineNum = 11;BA.debugLine="Private lblTemplate As B4XView";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 12;BA.debugLine="Private mValue As List";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 13;BA.debugLine="Private DigitHeight, DigitWidth As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = 0;
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = 0;
 //BA.debugLineNum = 14;BA.debugLine="Private mDuration As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = 0;
 //BA.debugLineNum = 15;BA.debugLine="Private fade As B4XBitmap";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private xfadeIv As B4XView";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Public Tag As Object";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = new Object();
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4(anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
anywheresoftware.b4a.objects.B4XCanvas _cvs = null;
anywheresoftware.b4a.objects.B4XCanvas.B4XRect _r = null;
int _baseline = 0;
int _i = 0;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _res = null;
 //BA.debugLineNum = 90;BA.debugLine="Private Sub CreateBitmap (lbl As B4XView) As B4XBi";
 //BA.debugLineNum = 91;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.CreatePanel(ba,"");
 //BA.debugLineNum = 92;BA.debugLine="p.SetLayoutAnimated(0, 0, 0, DigitWidth, DigitHei";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1,(int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0*10));
 //BA.debugLineNum = 93;BA.debugLine="Dim cvs As B4XCanvas";
_cvs = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 94;BA.debugLine="cvs.Initialize(p)";
_cvs.Initialize(_p);
 //BA.debugLineNum = 95;BA.debugLine="Dim r As B4XRect = cvs.MeasureText(\"5\", lbl.Font)";
_r = _cvs.MeasureText("5",_lbl.getFont());
 //BA.debugLineNum = 96;BA.debugLine="Dim BaseLine As Int = DigitHeight / 2 - r.Height";
_baseline = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0/(double)2-_r.getHeight()/(double)2-_r.getTop());
 //BA.debugLineNum = 97;BA.debugLine="For i = 0 To 9";
{
final int step7 = 1;
final int limit7 = (int) (9);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
 //BA.debugLineNum = 98;BA.debugLine="cvs.DrawText(i, DigitWidth / 2, i * DigitHeight";
_cvs.DrawText(ba,BA.NumberToString(_i),(float) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1/(double)2),(float) (_i*_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0+_baseline),_lbl.getFont(),_lbl.getTextColor(),BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
 }
};
 //BA.debugLineNum = 100;BA.debugLine="cvs.Invalidate";
_cvs.Invalidate();
 //BA.debugLineNum = 101;BA.debugLine="Dim res As B4XBitmap = cvs.CreateBitmap";
_res = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
_res = _cvs.CreateBitmap();
 //BA.debugLineNum = 102;BA.debugLine="cvs.Release";
_cvs.Release();
 //BA.debugLineNum = 103;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 104;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5() throws Exception{
b4a.example.bitmapcreator _bc = null;
anywheresoftware.b4a.objects.B4XCanvas.B4XRect _r = null;
 //BA.debugLineNum = 54;BA.debugLine="Private Sub CreateFadeBitmap As B4XBitmap";
 //BA.debugLineNum = 55;BA.debugLine="Dim bc As BitmapCreator";
_bc = new b4a.example.bitmapcreator();
 //BA.debugLineNum = 56;BA.debugLine="bc.Initialize(200, 50)";
_bc._initialize(ba,(int) (200),(int) (50));
 //BA.debugLineNum = 57;BA.debugLine="Dim r As B4XRect";
_r = new anywheresoftware.b4a.objects.B4XCanvas.B4XRect();
 //BA.debugLineNum = 58;BA.debugLine="r.Initialize(0, 0, bc.mWidth, bc.mHeight / 3)";
_r.Initialize((float) (0),(float) (0),(float) (_bc._mwidth),(float) (_bc._mheight/(double)3));
 //BA.debugLineNum = 59;BA.debugLine="bc.FillGradient(Array As Int(xui.Color_White, 0x0";
_bc._fillgradient(new int[]{_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Color_White,(int) (0x00ffffff)},_r,"TOP_BOTTOM");
 //BA.debugLineNum = 60;BA.debugLine="r.Top = bc.mHeight * 2 / 3";
_r.setTop((float) (_bc._mheight*2/(double)3));
 //BA.debugLineNum = 61;BA.debugLine="r.Bottom = bc.mHeight";
_r.setBottom((float) (_bc._mheight));
 //BA.debugLineNum = 62;BA.debugLine="bc.FillGradient(Array As Int(xui.Color_White, 0x0";
_bc._fillgradient(new int[]{_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Color_White,(int) (0x00ffffff)},_r,"BOTTOM_TOP");
 //BA.debugLineNum = 63;BA.debugLine="Return bc.Bitmap";
if (true) return _bc._getbitmap();
 //BA.debugLineNum = 64;BA.debugLine="End Sub";
return null;
}
public String  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _pnl = null;
int _i = 0;
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
anywheresoftware.b4a.objects.ImageViewWrapper _fadeiv = null;
 //BA.debugLineNum = 28;BA.debugLine="Public Sub DesignerCreateView (Base As Object, lbl";
 //BA.debugLineNum = 29;BA.debugLine="mBase = Base";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.setObject((java.lang.Object)(_base));
 //BA.debugLineNum = 30;BA.debugLine="Tag = mBase.Tag : mBase.Tag = Me";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.getTag();
 //BA.debugLineNum = 30;BA.debugLine="Tag = mBase.Tag : mBase.Tag = Me";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.setTag(this);
 //BA.debugLineNum = 31;BA.debugLine="Dim pnl As B4XView = xui.CreatePanel(\"\") 'needed";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.CreatePanel(ba,"");
 //BA.debugLineNum = 32;BA.debugLine="mBase.AddView(pnl, 0, 0, 0, 0)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.AddView((android.view.View)(_pnl.getObject()),(int) (0),(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 33;BA.debugLine="mdigits = Props.Get(\"Digits\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = (int)(BA.ObjectToNumber(_props.Get((Object)("Digits"))));
 //BA.debugLineNum = 34;BA.debugLine="mDuration = Props.Get(\"Duration\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = (int)(BA.ObjectToNumber(_props.Get((Object)("Duration"))));
 //BA.debugLineNum = 35;BA.debugLine="lblTemplate = lbl";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.setObject((java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 36;BA.debugLine="fade = CreateFadeBitmap";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5();
 //BA.debugLineNum = 37;BA.debugLine="For i = 0 To mdigits - 1";
{
final int step10 = 1;
final int limit10 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5-1);
_i = (int) (0) ;
for (;_i <= limit10 ;_i = _i + step10 ) {
 //BA.debugLineNum = 38;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 39;BA.debugLine="iv.Initialize(\"\")";
_iv.Initialize(ba,"");
 //BA.debugLineNum = 40;BA.debugLine="ImageViews.Add(iv)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Add((Object)(_iv.getObject()));
 //BA.debugLineNum = 41;BA.debugLine="mBase.GetView(0).AddView(iv, 0, 0, 0, 0)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.GetView((int) (0)).AddView((android.view.View)(_iv.getObject()),(int) (0),(int) (0),(int) (0),(int) (0));
 }
};
 //BA.debugLineNum = 43;BA.debugLine="Dim fadeIv As ImageView";
_fadeiv = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 44;BA.debugLine="fadeIv.Initialize(\"\")";
_fadeiv.Initialize(ba,"");
 //BA.debugLineNum = 45;BA.debugLine="xfadeIv = fadeIv";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.setObject((java.lang.Object)(_fadeiv.getObject()));
 //BA.debugLineNum = 46;BA.debugLine="mBase.GetView(0).AddView(fadeIv, 0, 0, 0, 0)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.GetView((int) (0)).AddView((android.view.View)(_fadeiv.getObject()),(int) (0),(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 47;BA.debugLine="setValue(0)";
_setvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7((int) (0));
 //BA.debugLineNum = 48;BA.debugLine="If xui.IsB4A Then";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.getIsB4A()) { 
 //BA.debugLineNum = 49;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.getWidth(),_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.getHeight());
 //BA.debugLineNum = 50;BA.debugLine="setValue(getValue)";
_setvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(_getvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7());
 };
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public int  _getvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7() throws Exception{
int _res = 0;
int _i = 0;
 //BA.debugLineNum = 117;BA.debugLine="Public Sub getValue As Int";
 //BA.debugLineNum = 118;BA.debugLine="Dim res As Int";
_res = 0;
 //BA.debugLineNum = 119;BA.debugLine="For i = 0 To mValue.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 120;BA.debugLine="res = res + mValue.Get(i) * Power(10, i)";
_res = (int) (_res+(double)(BA.ObjectToNumber(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Get(_i)))*__c.Power(10,_i));
 }
};
 //BA.debugLineNum = 122;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
return 0;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 20;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 21;BA.debugLine="mEventName = EventName";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = _eventname;
 //BA.debugLineNum = 22;BA.debugLine="mCallBack = Callback";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = _callback;
 //BA.debugLineNum = 23;BA.debugLine="ImageViews.Initialize";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Initialize();
 //BA.debugLineNum = 24;BA.debugLine="mValue.Initialize";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Initialize();
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public String  _setvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(int _v) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _iv = null;
 //BA.debugLineNum = 106;BA.debugLine="Public Sub setValue(v As Int)";
 //BA.debugLineNum = 107;BA.debugLine="mValue.Clear";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Clear();
 //BA.debugLineNum = 108;BA.debugLine="For i = 0 To mdigits - 1";
{
final int step2 = 1;
final int limit2 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 109;BA.debugLine="mValue.Add(v Mod 10)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Add((Object)(_v%10));
 //BA.debugLineNum = 110;BA.debugLine="v = v / 10";
_v = (int) (_v/(double)10);
 //BA.debugLineNum = 111;BA.debugLine="Dim iv As B4XView = ImageViews.Get(i)";
_iv = new anywheresoftware.b4a.objects.B4XViewWrapper();
_iv.setObject((java.lang.Object)(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Get(_i)));
 //BA.debugLineNum = 112;BA.debugLine="iv.SetLayoutAnimated(mDuration, iv.Left, TopFrom";
_iv.SetLayoutAnimated(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2,_iv.getLeft(),_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6(_i),_iv.getWidth(),_iv.getHeight());
 }
};
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return "";
}
public int  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6(int _digit) throws Exception{
int _d = 0;
 //BA.debugLineNum = 85;BA.debugLine="Private Sub TopFromValue (Digit As Int) As Int";
 //BA.debugLineNum = 86;BA.debugLine="Dim d As Int = mValue.Get(Digit)";
_d = (int)(BA.ObjectToNumber(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Get(_digit)));
 //BA.debugLineNum = 87;BA.debugLine="Return -d * DigitHeight";
if (true) return (int) (-_d*_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0);
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return 0;
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
