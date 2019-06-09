package com.stanks.andsokoban_full;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xdatetemplate extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.stanks.andsokoban_full.b4xdatetemplate");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.stanks.andsokoban_full.b4xdatetemplate.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _vvvvvvvvvvvv6 = null;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = 0;
public float _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = 0f;
public float _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = 0f;
public float _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0f;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = 0;
public anywheresoftware.b4a.objects.B4XViewWrapper _dayspanebg = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _dayspanefg = null;
public anywheresoftware.b4a.objects.B4XCanvas _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = null;
public anywheresoftware.b4a.objects.B4XCanvas _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = null;
public long _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = 0L;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvvvvv5 = 0;
public anywheresoftware.b4a.objects.B4XCanvas _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _daystitlespane = null;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = 0;
public int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = 0;
public anywheresoftware.b4a.objects.B4XViewWrapper _btnmonthleft = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _btnmonthright = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _btnyearleft = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _btnyearright = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblmonth = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblyear = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = null;
public com.stanks.andsokoban_full.b4xdialog _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = null;
public b4a.example.dateutils _vvvvvvv3 = null;
public com.stanks.andsokoban_full.main _vvvvvvv4 = null;
public com.stanks.andsokoban_full.starter _vvvvvvv5 = null;
public com.stanks.andsokoban_full.play _vvvvvvv6 = null;
public com.stanks.andsokoban_full.odabir _vvvvvvv7 = null;
public com.stanks.andsokoban_full.video _vvvvvvv0 = null;
public com.stanks.andsokoban_full.rijesenja _vvvvvvvv1 = null;
public com.stanks.andsokoban_full.opcije _vvvvvvvv2 = null;
public String  _btnmonth_click() throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _btn = null;
int _m = 0;
 //BA.debugLineNum = 145;BA.debugLine="Private Sub btnMonth_Click";
 //BA.debugLineNum = 146;BA.debugLine="Dim btn As B4XView = Sender";
_btn = new anywheresoftware.b4a.objects.B4XViewWrapper();
_btn.setObject((java.lang.Object)(__c.Sender(ba)));
 //BA.debugLineNum = 147;BA.debugLine="Dim m As Int = 12 + month - 1 + btn.Tag";
_m = (int) (12+_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7-1+(double)(BA.ObjectToNumber(_btn.getTag())));
 //BA.debugLineNum = 148;BA.debugLine="month = (m Mod 12) + 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = (int) ((_m%12)+1);
 //BA.debugLineNum = 149;BA.debugLine="DrawDays";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvv0();
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
return "";
}
public String  _btnyear_click() throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _btn = null;
 //BA.debugLineNum = 139;BA.debugLine="Private Sub btnYear_Click";
 //BA.debugLineNum = 140;BA.debugLine="Dim btn As B4XView = Sender";
_btn = new anywheresoftware.b4a.objects.B4XViewWrapper();
_btn.setObject((java.lang.Object)(__c.Sender(ba)));
 //BA.debugLineNum = 141;BA.debugLine="year = year + btn.Tag";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0+(double)(BA.ObjectToNumber(_btn.getTag())));
 //BA.debugLineNum = 142;BA.debugLine="DrawDays";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvv0();
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private xui As XUI";
_vvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 3;BA.debugLine="Private month, year As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = 0;
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = 0;
 //BA.debugLineNum = 4;BA.debugLine="Private boxW, boxH As Float";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = 0f;
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = 0f;
 //BA.debugLineNum = 5;BA.debugLine="Private vCorrection As Float";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0f;
 //BA.debugLineNum = 6;BA.debugLine="Private tempSelectedDay As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0;
 //BA.debugLineNum = 7;BA.debugLine="Private dayOfWeekOffset As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = 0;
 //BA.debugLineNum = 8;BA.debugLine="Private daysInMonth As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = 0;
 //BA.debugLineNum = 9;BA.debugLine="Private DaysPaneBg As B4XView";
_dayspanebg = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private DaysPaneFg As B4XView";
_dayspanefg = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 11;BA.debugLine="Private cvs As B4XCanvas";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 12;BA.debugLine="Private cvsBackground As B4XCanvas";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 13;BA.debugLine="Private selectedDate As Long";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = 0L;
 //BA.debugLineNum = 14;BA.debugLine="Private selectedYear, selectedMonth, selectedDay";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = 0;
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0;
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0;
 //BA.debugLineNum = 15;BA.debugLine="Private HighlightedColor As Int = 0xFF001BBD";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = (int) (0xff001bbd);
 //BA.debugLineNum = 16;BA.debugLine="Public SelectedColor As Int = 0xFF0BA29B";
_vvvvvvvvvvvvvvvvvvvvvvvvv5 = (int) (0xff0ba29b);
 //BA.debugLineNum = 17;BA.debugLine="Private cvsDays As B4XCanvas";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 18;BA.debugLine="Private DaysTitlesPane As B4XView";
_daystitlespane = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Public FirstDay As Int = 0";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = (int) (0);
 //BA.debugLineNum = 20;BA.debugLine="Public MinYear = 1970, MaxYear = 2030 As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = (int) (1970);
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = (int) (2030);
 //BA.debugLineNum = 21;BA.debugLine="Private btnMonthLeft As B4XView";
_btnmonthleft = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private btnMonthRight As B4XView";
_btnmonthright = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private btnYearLeft As B4XView";
_btnyearleft = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private btnYearRight As B4XView";
_btnyearright = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private lblMonth As B4XView";
_lblmonth = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private lblYear As B4XView";
_lblyear = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private pnlDialog As B4XView";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private months As List";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 29;BA.debugLine="Private mDialog As B4XDialog";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = new com.stanks.andsokoban_full.b4xdialog();
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public String  _dayspanefg_touch(int _action,float _x,float _y) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
 //BA.debugLineNum = 152;BA.debugLine="Private Sub DaysPaneFg_Touch (Action As Int, X As";
 //BA.debugLineNum = 153;BA.debugLine="Dim p As B4XView = DaysPaneFg";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _dayspanefg;
 //BA.debugLineNum = 154;BA.debugLine="HandleMouse(X, Y, Action <> p.TOUCH_ACTION_UP)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2(_x,_y,_action!=_p.TOUCH_ACTION_UP);
 //BA.debugLineNum = 155;BA.debugLine="End Sub";
return "";
}
public String  _dialogclosed(int _result) throws Exception{
 //BA.debugLineNum = 174;BA.debugLine="Private Sub DialogClosed(Result As Int) 'ignore";
 //BA.debugLineNum = 176;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvv7(anywheresoftware.b4a.objects.B4XCanvas _c,int _clr,int _x,int _y) throws Exception{
anywheresoftware.b4a.objects.B4XCanvas.B4XRect _r = null;
 //BA.debugLineNum = 80;BA.debugLine="Private Sub DrawBox(c As B4XCanvas, clr As Int, x";
 //BA.debugLineNum = 81;BA.debugLine="Dim r As B4XRect";
_r = new anywheresoftware.b4a.objects.B4XCanvas.B4XRect();
 //BA.debugLineNum = 82;BA.debugLine="r.Initialize(x * boxW, y * boxH, x * boxW + boxW,";
_r.Initialize((float) (_x*_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1),(float) (_y*_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2),(float) (_x*_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1+_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1),(float) (_y*_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2));
 //BA.debugLineNum = 83;BA.debugLine="c.DrawRect(r, clr, True, 1dip)";
_c.DrawRect(_r,_clr,__c.True,(float) (__c.DipToCurrent((int) (1))));
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvv0() throws Exception{
long _firstdayofmonth = 0L;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _daysfont = null;
int _day = 0;
int _row = 0;
 //BA.debugLineNum = 55;BA.debugLine="Private Sub DrawDays";
 //BA.debugLineNum = 56;BA.debugLine="lblMonth.Text = months.Get(month - 1)";
_lblmonth.setText(BA.ObjectToCharSequence(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Get((int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7-1))));
 //BA.debugLineNum = 57;BA.debugLine="lblYear.Text = year";
_lblyear.setText(BA.ObjectToCharSequence(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0));
 //BA.debugLineNum = 58;BA.debugLine="btnYearLeft.Enabled = year > MinYear";
_btnyearleft.setEnabled(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0>_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0);
 //BA.debugLineNum = 59;BA.debugLine="btnYearRight.Enabled = year < MaxYear";
_btnyearright.setEnabled(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0<_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1);
 //BA.debugLineNum = 60;BA.debugLine="cvs.ClearRect(cvs.TargetRect)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.ClearRect(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.getTargetRect());
 //BA.debugLineNum = 61;BA.debugLine="cvsBackground.ClearRect(cvsBackground.TargetRect)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.ClearRect(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getTargetRect());
 //BA.debugLineNum = 62;BA.debugLine="Dim firstDayOfMonth As Long = DateUtils.setDate(y";
_firstdayofmonth = (long) (_vvvvvvv3._setdate(ba,_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0,_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7,(int) (1))-1);
 //BA.debugLineNum = 63;BA.debugLine="dayOfWeekOffset = (7 + DateTime.GetDayOfWeek(firs";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = (int) ((7+__c.DateTime.GetDayOfWeek(_firstdayofmonth)-_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7)%7);
 //BA.debugLineNum = 64;BA.debugLine="daysInMonth = DateUtils.NumberOfDaysInMonth(month";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = _vvvvvvv3._numberofdaysinmonth(ba,_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7,_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0);
 //BA.debugLineNum = 65;BA.debugLine="If year = selectedYear And month = selectedMonth";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0==_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 && _vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7==_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3) { 
 //BA.debugLineNum = 67;BA.debugLine="DrawBox(cvs, SelectedColor, (selectedDay - 1 + d";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvv7(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7,_vvvvvvvvvvvvvvvvvvvvvvvvv5,(int) ((_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4-1+_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5)%7),(int) ((_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4-1+_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5)/(double)7));
 };
 //BA.debugLineNum = 70;BA.debugLine="Dim daysFont As B4XFont = xui.CreateDefaultBoldFo";
_daysfont = _vvvvvvvvvvvv6.CreateDefaultBoldFont((float) (14));
 //BA.debugLineNum = 71;BA.debugLine="For day = 1 To daysInMonth";
{
final int step14 = 1;
final int limit14 = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6;
_day = (int) (1) ;
for (;_day <= limit14 ;_day = _day + step14 ) {
 //BA.debugLineNum = 72;BA.debugLine="Dim row As Int = (day - 1 + dayOfWeekOffset) / 7";
_row = (int) ((_day-1+_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5)/(double)7);
 //BA.debugLineNum = 73;BA.debugLine="cvs.DrawText(day, (((dayOfWeekOffset + day - 1)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.DrawText(ba,BA.NumberToString(_day),(float) ((((_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5+_day-1)%7)+0.5)*_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1),(float) ((_row+0.5)*_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3),_daysfont,_vvvvvvvvvvvv6.Color_White,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
 }
};
 //BA.debugLineNum = 76;BA.debugLine="cvsBackground.Invalidate";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Invalidate();
 //BA.debugLineNum = 77;BA.debugLine="cvs.Invalidate";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Invalidate();
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public long  _getvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="Public Sub getDate As Long";
 //BA.debugLineNum = 88;BA.debugLine="Return selectedDate";
if (true) return _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1;
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return 0L;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _getpanel(com.stanks.andsokoban_full.b4xdialog _dialog) throws Exception{
 //BA.debugLineNum = 157;BA.debugLine="Public Sub GetPanel (Dialog As B4XDialog) As B4XVi";
 //BA.debugLineNum = 158;BA.debugLine="Return pnlDialog";
if (true) return _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2;
 //BA.debugLineNum = 159;BA.debugLine="End Sub";
return null;
}
public String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvv2(double _x,double _y,boolean _move) throws Exception{
int _boxx = 0;
int _boxy = 0;
int _newselectedday = 0;
boolean _validday = false;
 //BA.debugLineNum = 112;BA.debugLine="Private Sub HandleMouse(x As Double, y As Double,";
 //BA.debugLineNum = 113;BA.debugLine="Dim boxX = x / boxW, boxY =  y / boxH As Int";
_boxx = (int) (_x/(double)_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1);
_boxy = (int) (_y/(double)_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2);
 //BA.debugLineNum = 114;BA.debugLine="Dim newSelectedDay As Int = boxY * 7 + boxX + 1 -";
_newselectedday = (int) (_boxy*7+_boxx+1-_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5);
 //BA.debugLineNum = 115;BA.debugLine="Dim validDay As Boolean = newSelectedDay > 0 And";
_validday = _newselectedday>0 && _newselectedday<=_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6;
 //BA.debugLineNum = 116;BA.debugLine="If move Then";
if (_move) { 
 //BA.debugLineNum = 117;BA.debugLine="If newSelectedDay = tempSelectedDay Then Return";
if (_newselectedday==_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4) { 
if (true) return "";};
 //BA.debugLineNum = 118;BA.debugLine="cvsBackground.ClearRect(cvsBackground.TargetRect";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.ClearRect(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getTargetRect());
 //BA.debugLineNum = 119;BA.debugLine="tempSelectedDay = newSelectedDay";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = _newselectedday;
 //BA.debugLineNum = 120;BA.debugLine="If validDay Then";
if (_validday) { 
 //BA.debugLineNum = 121;BA.debugLine="DrawBox(cvsBackground, HighlightedColor, boxX,";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvv7(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0,_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5,_boxx,_boxy);
 };
 }else {
 //BA.debugLineNum = 124;BA.debugLine="cvsBackground.ClearRect(cvsBackground.TargetRect";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.ClearRect(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getTargetRect());
 //BA.debugLineNum = 125;BA.debugLine="If validDay Then";
if (_validday) { 
 //BA.debugLineNum = 126;BA.debugLine="SelectDay(newSelectedDay)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv4(_newselectedday);
 //BA.debugLineNum = 127;BA.debugLine="Hide";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv3();
 };
 };
 //BA.debugLineNum = 131;BA.debugLine="cvsBackground.Invalidate";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Invalidate();
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvv3() throws Exception{
 //BA.debugLineNum = 134;BA.debugLine="Private Sub Hide";
 //BA.debugLineNum = 135;BA.debugLine="mDialog.Close(xui.DialogResponse_Positive)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4._vvvv3(_vvvvvvvvvvvv6.DialogResponse_Positive);
 //BA.debugLineNum = 136;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 32;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 33;BA.debugLine="pnlDialog = xui.CreatePanel(\"\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = _vvvvvvvvvvvv6.CreatePanel(ba,"");
 //BA.debugLineNum = 34;BA.debugLine="pnlDialog.SetLayoutAnimated(0, 0, 0, 320dip,300di";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.SetLayoutAnimated((int) (0),(int) (0),(int) (0),__c.DipToCurrent((int) (320)),__c.DipToCurrent((int) (300)));
 //BA.debugLineNum = 35;BA.debugLine="pnlDialog.LoadLayout(\"DateTemplate\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.LoadLayout("DateTemplate",ba);
 //BA.debugLineNum = 36;BA.debugLine="pnlDialog.Tag = Me";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.setTag(this);
 //BA.debugLineNum = 37;BA.debugLine="month = DateTime.GetMonth(DateTime.Now)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = __c.DateTime.GetMonth(__c.DateTime.getNow());
 //BA.debugLineNum = 38;BA.debugLine="year = DateTime.GetYear(DateTime.Now)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = __c.DateTime.GetYear(__c.DateTime.getNow());
 //BA.debugLineNum = 39;BA.debugLine="months = DateUtils.GetMonthsNames";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = _vvvvvvv3._getmonthsnames(ba);
 //BA.debugLineNum = 40;BA.debugLine="selectedDate = DateTime.Now";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = __c.DateTime.getNow();
 //BA.debugLineNum = 41;BA.debugLine="setDate(selectedDate)";
_setvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1);
 //BA.debugLineNum = 42;BA.debugLine="cvs.Initialize(DaysPaneFg)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.Initialize(_dayspanefg);
 //BA.debugLineNum = 43;BA.debugLine="cvsBackground.Initialize(DaysPaneBg)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Initialize(_dayspanebg);
 //BA.debugLineNum = 44;BA.debugLine="boxW = cvs.TargetRect.Width / 7";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = (float) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.getTargetRect().getWidth()/(double)7);
 //BA.debugLineNum = 45;BA.debugLine="boxH = cvs.TargetRect.Height / 6";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = (float) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.getTargetRect().getHeight()/(double)6);
 //BA.debugLineNum = 46;BA.debugLine="vCorrection = 5dip";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = (float) (__c.DipToCurrent((int) (5)));
 //BA.debugLineNum = 47;BA.debugLine="cvsDays.Initialize(DaysTitlesPane)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Initialize(_daystitlespane);
 //BA.debugLineNum = 53;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvv4(int _day) throws Exception{
 //BA.debugLineNum = 104;BA.debugLine="Private Sub SelectDay(day As Int)";
 //BA.debugLineNum = 105;BA.debugLine="selectedDate = DateUtils.setDate(year, month, day";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = _vvvvvvv3._setdate(ba,_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0,_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7,_day);
 //BA.debugLineNum = 106;BA.debugLine="selectedDay = day";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = _day;
 //BA.debugLineNum = 107;BA.debugLine="selectedMonth = month";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7;
 //BA.debugLineNum = 108;BA.debugLine="selectedYear = year";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0;
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public String  _setvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6(long _date) throws Exception{
 //BA.debugLineNum = 91;BA.debugLine="Public Sub setDate(date As Long)";
 //BA.debugLineNum = 93;BA.debugLine="If lblYear.IsInitialized = False Then";
if (_lblyear.IsInitialized()==__c.False) { 
 //BA.debugLineNum = 94;BA.debugLine="selectedDate = date";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = _date;
 //BA.debugLineNum = 95;BA.debugLine="Return 'the date will be set after the layout is";
if (true) return "";
 };
 //BA.debugLineNum = 97;BA.debugLine="year = DateTime.GetYear(date)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = __c.DateTime.GetYear(_date);
 //BA.debugLineNum = 98;BA.debugLine="month = DateTime.GetMonth(date)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = __c.DateTime.GetMonth(_date);
 //BA.debugLineNum = 99;BA.debugLine="SelectDay(DateTime.GetDayOfMonth(date))";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv4(__c.DateTime.GetDayOfMonth(_date));
 //BA.debugLineNum = 100;BA.debugLine="lblYear.Text = year";
_lblyear.setText(BA.ObjectToCharSequence(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv0));
 //BA.debugLineNum = 101;BA.debugLine="lblMonth.Text = months.Get(month - 1)";
_lblmonth.setText(BA.ObjectToCharSequence(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Get((int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvv7-1))));
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return "";
}
public String  _show(com.stanks.andsokoban_full.b4xdialog _dialog) throws Exception{
anywheresoftware.b4a.objects.collections.List _days = null;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _daysfont = null;
int _i = 0;
String _d = "";
 //BA.debugLineNum = 161;BA.debugLine="Private Sub Show (Dialog As B4XDialog)";
 //BA.debugLineNum = 162;BA.debugLine="Dim days As List = DateUtils.GetDaysNames";
_days = new anywheresoftware.b4a.objects.collections.List();
_days = _vvvvvvv3._getdaysnames(ba);
 //BA.debugLineNum = 163;BA.debugLine="Dim daysFont As B4XFont = xui.CreateDefaultBoldFo";
_daysfont = _vvvvvvvvvvvv6.CreateDefaultBoldFont((float) (14));
 //BA.debugLineNum = 164;BA.debugLine="cvsDays.ClearRect(cvsDays.TargetRect)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.ClearRect(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getTargetRect());
 //BA.debugLineNum = 165;BA.debugLine="For i = FirstDay To FirstDay + 7 - 1";
{
final int step4 = 1;
final int limit4 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7+7-1);
_i = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 166;BA.debugLine="Dim d As String = days.Get(i Mod 7)";
_d = BA.ObjectToString(_days.Get((int) (_i%7)));
 //BA.debugLineNum = 167;BA.debugLine="cvsDays.DrawText(d.SubString2(0, 2), (i - FirstD";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.DrawText(ba,_d.substring((int) (0),(int) (2)),(float) ((_i-_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7+0.5)*_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1),(float) (__c.DipToCurrent((int) (20))),_daysfont,_vvvvvvvvvvvv6.Color_Gray,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
 }
};
 //BA.debugLineNum = 169;BA.debugLine="cvsDays.Invalidate";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Invalidate();
 //BA.debugLineNum = 170;BA.debugLine="mDialog = Dialog";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = _dialog;
 //BA.debugLineNum = 171;BA.debugLine="DrawDays";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvv0();
 //BA.debugLineNum = 172;BA.debugLine="End Sub";
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
