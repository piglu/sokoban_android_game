package com.stanks.andsokoban_full;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xtable extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.stanks.andsokoban_full.b4xtable");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.stanks.andsokoban_full.b4xtable.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _vvvvvvvvvvvv3 = "";
public Object _vvvvvvvvvvvv4 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _vvvvvvvvvvvv5 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _vvvvvvvvvvvv6 = null;
public Object _vvvvvvvvvvvv7 = null;
public anywheresoftware.b4a.sql.SQL _vvvvvv0 = null;
public int _column_type_text = 0;
public int _column_type_numbers = 0;
public int _column_type_date = 0;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvv0 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvv1 = null;
public int _vvvvvvvvvvvvv2 = 0;
public int _vvvvvvvvvvvvv3 = 0;
public com.stanks.andsokoban_full.b4xformatter _vvvvvvvvvvvvv4 = null;
public com.stanks.andsokoban_full.b4xformatter _vvvvvvvvvvvvv5 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _pnlheader = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _vvvvvvvvvvvvv6 = null;
public b4a.example3.customlistview _clvdata = null;
public int _vvvvvvvvvvvvv7 = 0;
public int _vvvvvvvvvvvvv0 = 0;
public boolean _vvvvvvvvvvvvvv1 = false;
public int _vvvvvvvvvvvvvv2 = 0;
public boolean _vvvvvvvvvvvvvv3 = false;
public int _vvvvvvvvvvvvvv4 = 0;
public int _vvvvvvvvvvvvvv5 = 0;
public int _vvvvvvvvvvvvvv6 = 0;
public int _vvvvvvvvvvvvvv7 = 0;
public int _vvvvvvvvvvvvvv0 = 0;
public int _vvvvvvvvvvvvvvv1 = 0;
public int _vvvvvvvvvvvvvvv2 = 0;
public int _vvvvvvvvvvvvvvv3 = 0;
public int _vvvvvvvvvvvvvvv4 = 0;
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _vvvvvvvvvvvvvvv5 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _vvvvvvvvvvvvvvv6 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblfirst = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblnumber = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblnext = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lbllast = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblfromto = null;
public int _vvvvvvvvvvvvvvv7 = 0;
public int _vvvvvvvvvvvvvvv0 = 0;
public int _vvvvvvvvvvvvvvvv1 = 0;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblsort = null;
public com.stanks.andsokoban_full.b4xfloattextfield _searchfield = null;
public String _vvvvvvvvvvvvvvvv2 = "";
public int _vvvvvvvvvvvvvvvv3 = 0;
public int _vvvvvvvvvvvvvvvv4 = 0;
public int _vvvvvvvvvvvvvvvv5 = 0;
public int _vvvvvvvvvvvvvvvv6 = 0;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvv7 = null;
public int _vvvvvvvvvvvvvvvv0 = 0;
public String _vvvvvvvvvvvvvvvvv1 = "";
public String _vvvvvvvvvvvvvvvvv2 = "";
public String _vvvvvvvvvvvvvvvvv3 = "";
public String _vvvvvvvvvvvvvvvvv4 = "";
public String _vvvvvvvvvvvvvvvvv5 = "";
public int _vvvvvvvvvvvvvvvvv6 = 0;
public boolean _vvvvvvvvvvvvvvvvv7 = false;
public int _vvvvvvvvvvvvvvvvv0 = 0;
public int _vvvvvvvvvvvvvvvvvv1 = 0;
public long _vvvvvvvvvvvvvvvvvv2 = 0L;
public b4a.example.dateutils _vvvvvvv3 = null;
public com.stanks.andsokoban_full.main _vvvvvvv4 = null;
public com.stanks.andsokoban_full.starter _vvvvvvv5 = null;
public com.stanks.andsokoban_full.play _vvvvvvv6 = null;
public com.stanks.andsokoban_full.odabir _vvvvvvv7 = null;
public com.stanks.andsokoban_full.video _vvvvvvv0 = null;
public com.stanks.andsokoban_full.rijesenja _vvvvvvvv1 = null;
public com.stanks.andsokoban_full.opcije _vvvvvvvv2 = null;
public static class _b4xtablecolumn{
public boolean IsInitialized;
public String Title;
public String Id;
public int ColumnType;
public boolean Sortable;
public boolean Searchable;
public com.stanks.andsokoban_full.b4xformatter Formatter;
public String SQLID;
public int Width;
public int ComputedWidth;
public anywheresoftware.b4a.objects.collections.List CellsLayouts;
public anywheresoftware.b4a.objects.B4XViewWrapper Panel;
public int LabelIndex;
public boolean DisableAutoResizeLayout;
public String InternalSortMode;
public void Initialize() {
IsInitialized = true;
Title = "";
Id = "";
ColumnType = 0;
Sortable = false;
Searchable = false;
Formatter = new com.stanks.andsokoban_full.b4xformatter();
SQLID = "";
Width = 0;
ComputedWidth = 0;
CellsLayouts = new anywheresoftware.b4a.objects.collections.List();
Panel = new anywheresoftware.b4a.objects.B4XViewWrapper();
LabelIndex = 0;
DisableAutoResizeLayout = false;
InternalSortMode = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public com.stanks.andsokoban_full.b4xtable._b4xtablecolumn  _vvvvvvvv3(String _title,int _columntype) throws Exception{
com.stanks.andsokoban_full.b4xtable._b4xtablecolumn _c = null;
anywheresoftware.b4a.objects.B4XViewWrapper _header = null;
 //BA.debugLineNum = 502;BA.debugLine="Public Sub AddColumn (Title As String, ColumnType";
 //BA.debugLineNum = 503;BA.debugLine="Dim c As B4XTableColumn";
_c = new com.stanks.andsokoban_full.b4xtable._b4xtablecolumn();
 //BA.debugLineNum = 504;BA.debugLine="c.Initialize";
_c.Initialize();
 //BA.debugLineNum = 505;BA.debugLine="c.Title = Title";
_c.Title = _title;
 //BA.debugLineNum = 506;BA.debugLine="c.ColumnType = ColumnType";
_c.ColumnType = _columntype;
 //BA.debugLineNum = 507;BA.debugLine="c.Sortable = True";
_c.Sortable = __c.True;
 //BA.debugLineNum = 508;BA.debugLine="c.Searchable = ColumnType = COLUMN_TYPE_TEXT";
_c.Searchable = _columntype==_column_type_text;
 //BA.debugLineNum = 509;BA.debugLine="c.CellsLayouts.Initialize";
_c.CellsLayouts.Initialize();
 //BA.debugLineNum = 510;BA.debugLine="c.Formatter = DefaultDataFormatter";
_c.Formatter = _vvvvvvvvvvvvv5;
 //BA.debugLineNum = 511;BA.debugLine="c.Panel = xui.CreatePanel(\"ColumnPanel\")";
_c.Panel = _vvvvvvvvvvvv6.CreatePanel(ba,"ColumnPanel");
 //BA.debugLineNum = 512;BA.debugLine="c.Panel.Tag = c";
_c.Panel.setTag((Object)(_c));
 //BA.debugLineNum = 513;BA.debugLine="c.Id = Title";
_c.Id = _title;
 //BA.debugLineNum = 514;BA.debugLine="Columns.Add(c)";
_vvvvvvvvvvvv0.Add((Object)(_c));
 //BA.debugLineNum = 515;BA.debugLine="VisibleColumns.Add(c)";
_vvvvvvvvvvvvv1.Add((Object)(_c));
 //BA.debugLineNum = 516;BA.debugLine="CreateColumnLayouts(c, mRowsPerPage + 1)";
_vvvvvvvvv4(_c,(int) (_vvvvvvvvvvvvvv2+1));
 //BA.debugLineNum = 517;BA.debugLine="Dim header As B4XView = GetLabelFromColumn(c, 0)";
_header = new anywheresoftware.b4a.objects.B4XViewWrapper();
_header = _vvvvvvvvvv1(_c,(int) (0));
 //BA.debugLineNum = 518;BA.debugLine="SetTextOrCSBuilderToLabel (header, Title)";
_vvvvvvvvvvv5(_header,(Object)(_title));
 //BA.debugLineNum = 519;BA.debugLine="If LayoutLoaded Then";
if (_vvvvvvvvvvvvvv3) { 
 //BA.debugLineNum = 520;BA.debugLine="AddColumnToCLV(c)";
_vvvvvvvv4(_c);
 };
 //BA.debugLineNum = 522;BA.debugLine="Return c";
if (true) return _c;
 //BA.debugLineNum = 523;BA.debugLine="End Sub";
return null;
}
public String  _vvvvvvvv4(com.stanks.andsokoban_full.b4xtable._b4xtablecolumn _c) throws Exception{
 //BA.debugLineNum = 495;BA.debugLine="Private Sub AddColumnToCLV (c As B4XTableColumn)";
 //BA.debugLineNum = 496;BA.debugLine="clvData.Add(c.Panel, c)";
_clvdata._add(_c.Panel,(Object)(_c));
 //BA.debugLineNum = 497;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(double _width,double _height) throws Exception{
 //BA.debugLineNum = 135;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
 //BA.debugLineNum = 136;BA.debugLine="Refresh2 (False)";
_vvvvvvvvvv6(__c.False);
 //BA.debugLineNum = 137;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvv5(int _size) throws Exception{
com.stanks.andsokoban_full.b4xtable._b4xtablecolumn _c = null;
 //BA.debugLineNum = 526;BA.debugLine="Public Sub BuildLayoutsCache (Size As Int)";
 //BA.debugLineNum = 527;BA.debugLine="For Each c As B4XTableColumn In Columns";
{
final anywheresoftware.b4a.BA.IterableList group1 = _vvvvvvvvvvvv0;
final int groupLen1 = group1.getSize()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_c = (com.stanks.andsokoban_full.b4xtable._b4xtablecolumn)(group1.Get(index1));
 //BA.debugLineNum = 528;BA.debugLine="CreateColumnLayouts(c, Size + 1)";
_vvvvvvvvv4(_c,(int) (_size+1));
 }
};
 //BA.debugLineNum = 530;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvv6() throws Exception{
int _wildcardcount = 0;
int _totalexplicitwidth = 0;
com.stanks.andsokoban_full.b4xtable._b4xtablecolumn _c = null;
int _wildcardwidth = 0;
int _width = 0;
int _remainder = 0;
 //BA.debugLineNum = 473;BA.debugLine="Private Sub CalculateWidths";
 //BA.debugLineNum = 474;BA.debugLine="Dim wildcardcount As Int";
_wildcardcount = 0;
 //BA.debugLineNum = 475;BA.debugLine="Dim TotalExplicitWidth As Int";
_totalexplicitwidth = 0;
 //BA.debugLineNum = 476;BA.debugLine="For Each c As B4XTableColumn In VisibleColumns";
{
final anywheresoftware.b4a.BA.IterableList group3 = _vvvvvvvvvvvvv1;
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_c = (com.stanks.andsokoban_full.b4xtable._b4xtablecolumn)(group3.Get(index3));
 //BA.debugLineNum = 477;BA.debugLine="If c.Width = 0 Then wildcardcount = wildcardcoun";
if (_c.Width==0) { 
_wildcardcount = (int) (_wildcardcount+1);}
else {
_c.ComputedWidth = _c.Width;};
 //BA.debugLineNum = 478;BA.debugLine="TotalExplicitWidth = TotalExplicitWidth + c.Widt";
_totalexplicitwidth = (int) (_totalexplicitwidth+_c.Width);
 }
};
 //BA.debugLineNum = 480;BA.debugLine="If wildcardcount = 0 Then Return";
if (_wildcardcount==0) { 
if (true) return "";};
 //BA.debugLineNum = 481;BA.debugLine="Dim WildcardWidth As Int = Max(wildcardcount * Mi";
_wildcardwidth = (int) (__c.Max(_wildcardcount*_vvvvvvvvvvvvvv4,_vvvvvvvvvvvv5.getWidth()-__c.DipToCurrent((int) (2))-_totalexplicitwidth));
 //BA.debugLineNum = 482;BA.debugLine="Dim Width As Int = WildcardWidth / wildcardcount";
_width = (int) (_wildcardwidth/(double)_wildcardcount);
 //BA.debugLineNum = 483;BA.debugLine="Dim Remainder As Int = WildcardWidth Mod wildcard";
_remainder = (int) (_wildcardwidth%_wildcardcount);
 //BA.debugLineNum = 484;BA.debugLine="For Each c As B4XTableColumn In VisibleColumns";
{
final anywheresoftware.b4a.BA.IterableList group11 = _vvvvvvvvvvvvv1;
final int groupLen11 = group11.getSize()
;int index11 = 0;
;
for (; index11 < groupLen11;index11++){
_c = (com.stanks.andsokoban_full.b4xtable._b4xtablecolumn)(group11.Get(index11));
 //BA.debugLineNum = 485;BA.debugLine="If c.Width = 0 Then";
if (_c.Width==0) { 
 //BA.debugLineNum = 486;BA.debugLine="c.ComputedWidth = Width";
_c.ComputedWidth = _width;
 //BA.debugLineNum = 487;BA.debugLine="If Remainder > 0 Then";
if (_remainder>0) { 
 //BA.debugLineNum = 488;BA.debugLine="Remainder = Remainder - 1";
_remainder = (int) (_remainder-1);
 //BA.debugLineNum = 489;BA.debugLine="c.ComputedWidth = c.ComputedWidth + 1";
_c.ComputedWidth = (int) (_c.ComputedWidth+1);
 };
 };
 }
};
 //BA.debugLineNum = 493;BA.debugLine="End Sub";
return "";
}
public String  _cell_click() throws Exception{
 //BA.debugLineNum = 631;BA.debugLine="Private Sub Cell_Click";
 //BA.debugLineNum = 632;BA.debugLine="CellClicked(Sender, False)";
_vvvvvvvv7((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(__c.Sender(ba))),__c.False);
 //BA.debugLineNum = 633;BA.debugLine="End Sub";
return "";
}
public String  _cell_longclick() throws Exception{
 //BA.debugLineNum = 635;BA.debugLine="Private Sub Cell_LongClick";
 //BA.debugLineNum = 636;BA.debugLine="CellClicked(Sender, True)";
_vvvvvvvv7((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(__c.Sender(ba))),__c.True);
 //BA.debugLineNum = 637;BA.debugLine="End Sub";
return "";
}
public void  _vvvvvvvv7(anywheresoftware.b4a.objects.B4XViewWrapper _pnl,boolean _longclicked) throws Exception{
ResumableSub_CellClicked rsub = new ResumableSub_CellClicked(this,_pnl,_longclicked);
rsub.resume(ba, null);
}
public static class ResumableSub_CellClicked extends BA.ResumableSub {
public ResumableSub_CellClicked(com.stanks.andsokoban_full.b4xtable parent,anywheresoftware.b4a.objects.B4XViewWrapper _pnl,boolean _longclicked) {
this.parent = parent;
this._pnl = _pnl;
this._longclicked = _longclicked;
}
com.stanks.andsokoban_full.b4xtable parent;
anywheresoftware.b4a.objects.B4XViewWrapper _pnl;
boolean _longclicked;
com.stanks.andsokoban_full.b4xtable._b4xtablecolumn _column = null;
int _row = 0;
String _e = "";
long _rowid = 0L;
int _clr = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 677;BA.debugLine="If DateTime.Now < LastCellClickEvent + 20 Then Re";
if (true) break;

case 1:
//if
this.state = 6;
if (parent.__c.DateTime.getNow()<parent._vvvvvvvvvvvvvvvvvv2+20) { 
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
 //BA.debugLineNum = 678;BA.debugLine="LastCellClickEvent = DateTime.Now";
parent._vvvvvvvvvvvvvvvvvv2 = parent.__c.DateTime.getNow();
 //BA.debugLineNum = 679;BA.debugLine="Dim column As B4XTableColumn = pnl.Parent.Tag";
_column = (com.stanks.andsokoban_full.b4xtable._b4xtablecolumn)(_pnl.getParent().getTag());
 //BA.debugLineNum = 680;BA.debugLine="Dim Row As Int = pnl.Tag - 1";
_row = (int) ((double)(BA.ObjectToNumber(_pnl.getTag()))-1);
 //BA.debugLineNum = 681;BA.debugLine="Dim e As String";
_e = "";
 //BA.debugLineNum = 682;BA.debugLine="If Row = -1 Then";
if (true) break;

case 7:
//if
this.state = 61;
if (_row==-1) { 
this.state = 9;
}else {
this.state = 20;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 683;BA.debugLine="If LongClicked Then";
if (true) break;

case 10:
//if
this.state = 15;
if (_longclicked) { 
this.state = 12;
}else {
this.state = 14;
}if (true) break;

case 12:
//C
this.state = 15;
 //BA.debugLineNum = 684;BA.debugLine="e = \"_headerlongclicked\"";
_e = "_headerlongclicked";
 if (true) break;

case 14:
//C
this.state = 15;
 //BA.debugLineNum = 686;BA.debugLine="e = \"_headerclicked\"";
_e = "_headerclicked";
 //BA.debugLineNum = 687;BA.debugLine="HeaderClicked(column)";
parent._vvvvvvvvvv3(_column);
 if (true) break;
;
 //BA.debugLineNum = 689;BA.debugLine="If xui.SubExists(mCallBack, mEventName & e, 1) T";

case 15:
//if
this.state = 18;
if (parent._vvvvvvvvvvvv6.SubExists(ba,parent._vvvvvvvvvvvv4,parent._vvvvvvvvvvvv3+_e,(int) (1))) { 
this.state = 17;
}if (true) break;

case 17:
//C
this.state = 18;
 //BA.debugLineNum = 693;BA.debugLine="CallSub2(mCallBack, mEventName & e, column.Id)";
parent.__c.CallSubNew2(ba,parent._vvvvvvvvvvvv4,parent._vvvvvvvvvvvv3+_e,(Object)(_column.Id));
 if (true) break;

case 18:
//C
this.state = 61;
;
 if (true) break;

case 20:
//C
this.state = 21;
 //BA.debugLineNum = 696;BA.debugLine="Dim RowId As Long = VisibleRowIds.Get(Row)";
_rowid = BA.ObjectToLongNumber(parent._vvvvvvvvvvvvvvvv7.Get(_row));
 //BA.debugLineNum = 697;BA.debugLine="If RowId > 0 Then";
if (true) break;

case 21:
//if
this.state = 60;
if (_rowid>0) { 
this.state = 23;
}if (true) break;

case 23:
//C
this.state = 24;
 //BA.debugLineNum = 698;BA.debugLine="Dim clr As Int";
_clr = 0;
 //BA.debugLineNum = 699;BA.debugLine="If Row Mod 2 = 0 Then clr = EvenRowColor Else c";
if (true) break;

case 24:
//if
this.state = 31;
if (_row%2==0) { 
this.state = 26;
;}
else {
this.state = 28;
;}if (true) break;

case 26:
//C
this.state = 31;
_clr = parent._vvvvvvvvvvvvvv6;
if (true) break;

case 28:
//C
this.state = 31;
_clr = parent._vvvvvvvvvvvvvv7;
if (true) break;

case 31:
//C
this.state = 32;
;
 //BA.debugLineNum = 701;BA.debugLine="If LongClicked Then";
if (true) break;

case 32:
//if
this.state = 43;
if (_longclicked) { 
this.state = 34;
}else {
this.state = 36;
}if (true) break;

case 34:
//C
this.state = 43;
 //BA.debugLineNum = 702;BA.debugLine="e = \"_CellLongClicked\"";
_e = "_CellLongClicked";
 if (true) break;

case 36:
//C
this.state = 37;
 //BA.debugLineNum = 704;BA.debugLine="e = \"_cellclicked\"";
_e = "_cellclicked";
 //BA.debugLineNum = 705;BA.debugLine="If SelectionColor <> 0 Then pnl.SetColorAnimat";
if (true) break;

case 37:
//if
this.state = 42;
if (parent._vvvvvvvvvvvvvvvv0!=0) { 
this.state = 39;
;}if (true) break;

case 39:
//C
this.state = 42;
_pnl.SetColorAnimated((int) (50),_clr,parent._vvvvvvvvvvvvvvvv0);
if (true) break;

case 42:
//C
this.state = 43;
;
 if (true) break;
;
 //BA.debugLineNum = 708;BA.debugLine="If xui.SubExists(mCallBack, mEventName & e, 2)";

case 43:
//if
this.state = 46;
if (parent._vvvvvvvvvvvv6.SubExists(ba,parent._vvvvvvvvvvvv4,parent._vvvvvvvvvvvv3+_e,(int) (2))) { 
this.state = 45;
}if (true) break;

case 45:
//C
this.state = 46;
 //BA.debugLineNum = 712;BA.debugLine="CallSub3(mCallBack, mEventName & e, column.Id,";
parent.__c.CallSubNew3(ba,parent._vvvvvvvvvvvv4,parent._vvvvvvvvvvvv3+_e,(Object)(_column.Id),parent._vvvvvvvvvvvvvvvv7.Get(_row));
 if (true) break;
;
 //BA.debugLineNum = 714;BA.debugLine="If LongClicked = False Then";

case 46:
//if
this.state = 59;
if (_longclicked==parent.__c.False) { 
this.state = 48;
}if (true) break;

case 48:
//C
this.state = 49;
 //BA.debugLineNum = 715;BA.debugLine="Sleep(200)";
parent.__c.Sleep(ba,this,(int) (200));
this.state = 62;
return;
case 62:
//C
this.state = 49;
;
 //BA.debugLineNum = 716;BA.debugLine="If pnl.IsInitialized Then";
if (true) break;

case 49:
//if
this.state = 58;
if (_pnl.IsInitialized()) { 
this.state = 51;
}if (true) break;

case 51:
//C
this.state = 52;
 //BA.debugLineNum = 717;BA.debugLine="If SelectionColor <> 0 Then pnl.SetColorAnima";
if (true) break;

case 52:
//if
this.state = 57;
if (parent._vvvvvvvvvvvvvvvv0!=0) { 
this.state = 54;
;}if (true) break;

case 54:
//C
this.state = 57;
_pnl.SetColorAnimated((int) (200),parent._vvvvvvvvvvvvvvvv0,_clr);
if (true) break;

case 57:
//C
this.state = 58;
;
 if (true) break;

case 58:
//C
this.state = 59;
;
 if (true) break;

case 59:
//C
this.state = 60;
;
 if (true) break;

case 60:
//C
this.state = 61;
;
 if (true) break;

case 61:
//C
this.state = -1;
;
 //BA.debugLineNum = 722;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private mEventName As String 'ignore";
_vvvvvvvvvvvv3 = "";
 //BA.debugLineNum = 17;BA.debugLine="Private mCallBack As Object 'ignore";
_vvvvvvvvvvvv4 = new Object();
 //BA.debugLineNum = 18;BA.debugLine="Public mBase As B4XView 'ignore";
_vvvvvvvvvvvv5 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private xui As XUI 'ignore";
_vvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 20;BA.debugLine="Public Tag As Object";
_vvvvvvvvvvvv7 = new Object();
 //BA.debugLineNum = 21;BA.debugLine="Public sql1 As SQL";
_vvvvvv0 = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 22;BA.debugLine="Type B4XTableColumn (Title As String, Id As Strin";
;
 //BA.debugLineNum = 25;BA.debugLine="Public COLUMN_TYPE_TEXT = 1, COLUMN_TYPE_NUMBERS";
_column_type_text = (int) (1);
_column_type_numbers = (int) (2);
_column_type_date = (int) (3);
 //BA.debugLineNum = 26;BA.debugLine="Public Columns As List";
_vvvvvvvvvvvv0 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 27;BA.debugLine="Public VisibleColumns As List";
_vvvvvvvvvvvvv1 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 28;BA.debugLine="Private mFirstRowIndex, mLastRowIndex As Int";
_vvvvvvvvvvvvv2 = 0;
_vvvvvvvvvvvvv3 = 0;
 //BA.debugLineNum = 29;BA.debugLine="Public DefaultFormatter, DefaultDataFormatter As";
_vvvvvvvvvvvvv4 = new com.stanks.andsokoban_full.b4xformatter();
_vvvvvvvvvvvvv5 = new com.stanks.andsokoban_full.b4xformatter();
 //BA.debugLineNum = 30;BA.debugLine="Public pnlHeader As B4XView";
_pnlheader = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Public pnlTitles As B4XView";
_vvvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Public clvData As CustomListView";
_clvdata = new b4a.example3.customlistview();
 //BA.debugLineNum = 33;BA.debugLine="Public pnlHeader As B4XView";
_pnlheader = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Public RowHeight, HeadersHeight As Int";
_vvvvvvvvvvvvv7 = 0;
_vvvvvvvvvvvvv0 = 0;
 //BA.debugLineNum = 35;BA.debugLine="Public AllowSmallRowHeightModifications As Boolea";
_vvvvvvvvvvvvvv1 = __c.True;
 //BA.debugLineNum = 36;BA.debugLine="Private mRowsPerPage As Int = 0";
_vvvvvvvvvvvvvv2 = (int) (0);
 //BA.debugLineNum = 37;BA.debugLine="Private LayoutLoaded As Boolean";
_vvvvvvvvvvvvvv3 = false;
 //BA.debugLineNum = 38;BA.debugLine="Public MinimumWidth As Int";
_vvvvvvvvvvvvvv4 = 0;
 //BA.debugLineNum = 39;BA.debugLine="Private SQLIndex As Int";
_vvvvvvvvvvvvvv5 = 0;
 //BA.debugLineNum = 40;BA.debugLine="Public EvenRowColor, OddRowColor, HeaderTextColor";
_vvvvvvvvvvvvvv6 = 0;
_vvvvvvvvvvvvvv7 = 0;
_vvvvvvvvvvvvvv0 = 0;
_vvvvvvvvvvvvvvv1 = 0;
_vvvvvvvvvvvvvvv2 = 0;
_vvvvvvvvvvvvvvv3 = 0;
_vvvvvvvvvvvvvvv4 = 0;
 //BA.debugLineNum = 41;BA.debugLine="Public HeaderFont, LabelsFont As B4XFont";
_vvvvvvvvvvvvvvv5 = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
_vvvvvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
 //BA.debugLineNum = 42;BA.debugLine="Public lblFirst As B4XView";
_lblfirst = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Public lblBack As B4XView";
_lblback = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Public lblNumber As B4XView";
_lblnumber = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Public lblNext As B4XView";
_lblnext = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Public lblLast As B4XView";
_lbllast = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Public lblFromTo As B4XView";
_lblfromto = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private CountAll As Int";
_vvvvvvvvvvvvvvv7 = 0;
 //BA.debugLineNum = 49;BA.debugLine="Private mCurrentPage As Int";
_vvvvvvvvvvvvvvv0 = 0;
 //BA.debugLineNum = 50;BA.debugLine="Public mCurrentCount As Int";
_vvvvvvvvvvvvvvvv1 = 0;
 //BA.debugLineNum = 51;BA.debugLine="Private lblSort As B4XView";
_lblsort = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Public SearchField As B4XFloatTextField";
_searchfield = new com.stanks.andsokoban_full.b4xfloattextfield();
 //BA.debugLineNum = 53;BA.debugLine="Private FilterText As String";
_vvvvvvvvvvvvvvvv2 = "";
 //BA.debugLineNum = 54;BA.debugLine="Public SleepBeforeSearch As Int = 300";
_vvvvvvvvvvvvvvvv3 = (int) (300);
 //BA.debugLineNum = 55;BA.debugLine="Private SearchIndex As Int";
_vvvvvvvvvvvvvvvv4 = 0;
 //BA.debugLineNum = 56;BA.debugLine="Public ArrowsEnabledColor, ArrowsDisabledColor As";
_vvvvvvvvvvvvvvvv5 = 0;
_vvvvvvvvvvvvvvvv6 = 0;
 //BA.debugLineNum = 57;BA.debugLine="Public VisibleRowIds As List";
_vvvvvvvvvvvvvvvv7 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 58;BA.debugLine="Public SelectionColor As Int";
_vvvvvvvvvvvvvvvv0 = 0;
 //BA.debugLineNum = 59;BA.debugLine="Private SQLTableName As String = \"data\"";
_vvvvvvvvvvvvvvvvv1 = "data";
 //BA.debugLineNum = 60;BA.debugLine="Public StringMoreAvailable As String = \"(more ava";
_vvvvvvvvvvvvvvvvv2 = "(more available)";
 //BA.debugLineNum = 61;BA.debugLine="Public StringNoMatches As String = \"No matches\"";
_vvvvvvvvvvvvvvvvv3 = "No matches";
 //BA.debugLineNum = 62;BA.debugLine="Public StringOutOf As String = \"out of\"";
_vvvvvvvvvvvvvvvvv4 = "out of";
 //BA.debugLineNum = 63;BA.debugLine="Public StringTo As String = \"to\"";
_vvvvvvvvvvvvvvvvv5 = "to";
 //BA.debugLineNum = 64;BA.debugLine="Public MaximumRowsPerPage As Int";
_vvvvvvvvvvvvvvvvv6 = 0;
 //BA.debugLineNum = 65;BA.debugLine="Public PrefixSearch As Boolean";
_vvvvvvvvvvvvvvvvv7 = false;
 //BA.debugLineNum = 70;BA.debugLine="Private LastBaseHeight As Int";
_vvvvvvvvvvvvvvvvv0 = 0;
 //BA.debugLineNum = 71;BA.debugLine="Public NumberOfFrozenColumns As Int";
_vvvvvvvvvvvvvvvvvv1 = 0;
 //BA.debugLineNum = 72;BA.debugLine="Private LastCellClickEvent As Long";
_vvvvvvvvvvvvvvvvvv2 = 0L;
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public void  _vvvvvvvv0() throws Exception{
ResumableSub_Clear rsub = new ResumableSub_Clear(this);
rsub.resume(ba, null);
}
public static class ResumableSub_Clear extends BA.ResumableSub {
public ResumableSub_Clear(com.stanks.andsokoban_full.b4xtable parent) {
this.parent = parent;
}
com.stanks.andsokoban_full.b4xtable parent;
anywheresoftware.b4a.sql.SQL _oldsql = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 141;BA.debugLine="SQLIndex = SQLIndex + 1";
parent._vvvvvvvvvvvvvv5 = (int) (parent._vvvvvvvvvvvvvv5+1);
 //BA.debugLineNum = 142;BA.debugLine="Dim OldSQL As SQL = sql1";
_oldsql = parent._vvvvvv0;
 //BA.debugLineNum = 143;BA.debugLine="Dim sql1 As SQL";
parent._vvvvvv0 = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 144;BA.debugLine="Columns.Clear";
parent._vvvvvvvvvvvv0.Clear();
 //BA.debugLineNum = 145;BA.debugLine="SQLTableName = \"data\"";
parent._vvvvvvvvvvvvvvvvv1 = "data";
 //BA.debugLineNum = 146;BA.debugLine="VisibleColumns.Clear";
parent._vvvvvvvvvvvvv1.Clear();
 //BA.debugLineNum = 147;BA.debugLine="If clvData.IsInitialized Then";
if (true) break;

case 1:
//if
this.state = 4;
if (parent._clvdata.IsInitialized()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 148;BA.debugLine="clvData.Clear";
parent._clvdata._clear();
 if (true) break;
;
 //BA.debugLineNum = 150;BA.debugLine="If OldSQL.IsInitialized Then";

case 4:
//if
this.state = 11;
if (_oldsql.IsInitialized()) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 151;BA.debugLine="Sleep(1000)";
parent.__c.Sleep(ba,this,(int) (1000));
this.state = 12;
return;
case 12:
//C
this.state = 7;
;
 //BA.debugLineNum = 152;BA.debugLine="If OldSQL.IsInitialized Then";
if (true) break;

case 7:
//if
this.state = 10;
if (_oldsql.IsInitialized()) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 153;BA.debugLine="Log(\"closing old db.\")";
parent.__c.LogImpl("99764877","closing old db.",0);
 //BA.debugLineNum = 154;BA.debugLine="OldSQL.Close";
_oldsql.Close();
 if (true) break;

case 10:
//C
this.state = 11;
;
 if (true) break;

case 11:
//C
this.state = -1;
;
 //BA.debugLineNum = 157;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _vvvvvvvvv1() throws Exception{
 //BA.debugLineNum = 311;BA.debugLine="Public Sub ClearDataView";
 //BA.debugLineNum = 312;BA.debugLine="SQLTableName = \"data\"";
_vvvvvvvvvvvvvvvvv1 = "data";
 //BA.debugLineNum = 313;BA.debugLine="mFirstRowIndex = 0";
_vvvvvvvvvvvvv2 = (int) (0);
 //BA.debugLineNum = 314;BA.debugLine="CountAll = sql1.ExecQuerySingleResult(\"SELECT cou";
_vvvvvvvvvvvvvvv7 = (int)(Double.parseDouble(_vvvvvv0.ExecQuerySingleResult("SELECT count(*) FROM data")));
 //BA.debugLineNum = 315;BA.debugLine="UpdateData";
_vvvvvvvvvvv7();
 //BA.debugLineNum = 316;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvv2(com.stanks.andsokoban_full.b4xtable._b4xtablecolumn _c) throws Exception{
 //BA.debugLineNum = 604;BA.debugLine="Private Sub ColumnToSQLType (c As B4XTableColumn)";
 //BA.debugLineNum = 605;BA.debugLine="If c.ColumnType = COLUMN_TYPE_TEXT Then Return \"T";
if (_c.ColumnType==_column_type_text) { 
if (true) return "TEXT";}
else {
if (true) return "INTEGER";};
 //BA.debugLineNum = 606;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _vvvvvvvvv3() throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _xlbl = null;
 //BA.debugLineNum = 609;BA.debugLine="Private Sub CreateCellViews As B4XView";
 //BA.debugLineNum = 610;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"cell\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _vvvvvvvvvvvv6.CreatePanel(ba,"cell");
 //BA.debugLineNum = 611;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 612;BA.debugLine="lbl.Initialize(\"lbl\")";
_lbl.Initialize(ba,"lbl");
 //BA.debugLineNum = 613;BA.debugLine="SetMouseTransparent(lbl)";
_vvvvvvvvvvv3((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject())));
 //BA.debugLineNum = 614;BA.debugLine="Dim xlbl As B4XView = lbl";
_xlbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_xlbl.setObject((java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 615;BA.debugLine="xlbl.SetTextAlignment(\"CENTER\", \"CENTER\")";
_xlbl.SetTextAlignment("CENTER","CENTER");
 //BA.debugLineNum = 616;BA.debugLine="p.AddView(xlbl, 0, 0, 0, 0)";
_p.AddView((android.view.View)(_xlbl.getObject()),(int) (0),(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 617;BA.debugLine="Return p";
if (true) return _p;
 //BA.debugLineNum = 618;BA.debugLine="End Sub";
return null;
}
public String  _vvvvvvvvv4(com.stanks.andsokoban_full.b4xtable._b4xtablecolumn _c,int _size) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
int _clr = 0;
int _tclr = 0;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _fnt = null;
 //BA.debugLineNum = 532;BA.debugLine="Private Sub CreateColumnLayouts (c As B4XTableColu";
 //BA.debugLineNum = 533;BA.debugLine="For i = c.CellsLayouts.Size To Size - 1";
{
final int step1 = 1;
final int limit1 = (int) (_size-1);
_i = _c.CellsLayouts.getSize() ;
for (;_i <= limit1 ;_i = _i + step1 ) {
 //BA.debugLineNum = 534;BA.debugLine="Dim p As B4XView = CreateCellViews";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _vvvvvvvvv3();
 //BA.debugLineNum = 535;BA.debugLine="Dim lbl As B4XView = p.GetView(c.LabelIndex)";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = _p.GetView(_c.LabelIndex);
 //BA.debugLineNum = 536;BA.debugLine="c.CellsLayouts.Add(p)";
_c.CellsLayouts.Add((Object)(_p.getObject()));
 //BA.debugLineNum = 537;BA.debugLine="Dim clr, tclr As Int";
_clr = 0;
_tclr = 0;
 //BA.debugLineNum = 538;BA.debugLine="Dim fnt As B4XFont";
_fnt = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont();
 //BA.debugLineNum = 539;BA.debugLine="If i = 0 Then";
if (_i==0) { 
 //BA.debugLineNum = 540;BA.debugLine="clr = HeaderColor";
_clr = _vvvvvvvvvvvvvvv3;
 //BA.debugLineNum = 541;BA.debugLine="tclr = HeaderTextColor";
_tclr = _vvvvvvvvvvvvvv0;
 //BA.debugLineNum = 542;BA.debugLine="fnt = HeaderFont";
_fnt = _vvvvvvvvvvvvvvv5;
 }else {
 //BA.debugLineNum = 544;BA.debugLine="fnt = LabelsFont";
_fnt = _vvvvvvvvvvvvvvv6;
 //BA.debugLineNum = 545;BA.debugLine="tclr = TextColor";
_tclr = _vvvvvvvvvvvvvvv1;
 //BA.debugLineNum = 546;BA.debugLine="If i Mod 2 = 1 Then";
if (_i%2==1) { 
 //BA.debugLineNum = 547;BA.debugLine="clr = EvenRowColor";
_clr = _vvvvvvvvvvvvvv6;
 }else {
 //BA.debugLineNum = 549;BA.debugLine="clr = OddRowColor";
_clr = _vvvvvvvvvvvvvv7;
 };
 };
 //BA.debugLineNum = 552;BA.debugLine="lbl.Font = fnt";
_lbl.setFont(_fnt);
 //BA.debugLineNum = 553;BA.debugLine="p.SetColorAndBorder(clr, 1dip, GridColor, 0)";
_p.SetColorAndBorder(_clr,__c.DipToCurrent((int) (1)),_vvvvvvvvvvvvvvv4,(int) (0));
 //BA.debugLineNum = 554;BA.debugLine="lbl.TextColor = tclr";
_lbl.setTextColor(_tclr);
 //BA.debugLineNum = 555;BA.debugLine="lbl.SetTextAlignment(\"CENTER\", \"CENTER\")";
_lbl.SetTextAlignment("CENTER","CENTER");
 //BA.debugLineNum = 556;BA.debugLine="p.Tag = i";
_p.setTag((Object)(_i));
 //BA.debugLineNum = 557;BA.debugLine="c.Panel.AddView(p, 0, 0, 0, 0)";
_c.Panel.AddView((android.view.View)(_p.getObject()),(int) (0),(int) (0),(int) (0),(int) (0));
 }
};
 //BA.debugLineNum = 559;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvv5(String _whereclause) throws Exception{
 //BA.debugLineNum = 302;BA.debugLine="Public Sub CreateDataView (WhereClause As String)";
 //BA.debugLineNum = 303;BA.debugLine="sql1.ExecNonQuery(\"DROP VIEW IF EXISTS TempView\")";
_vvvvvv0.ExecNonQuery("DROP VIEW IF EXISTS TempView");
 //BA.debugLineNum = 304;BA.debugLine="sql1.ExecNonQuery(\"CREATE VIEW TempView AS SELECT";
_vvvvvv0.ExecNonQuery("CREATE VIEW TempView AS SELECT *, rowid FROM data WHERE "+_whereclause);
 //BA.debugLineNum = 305;BA.debugLine="CountAll = sql1.ExecQuerySingleResult(\"SELECT cou";
_vvvvvvvvvvvvvvv7 = (int)(Double.parseDouble(_vvvvvv0.ExecQuerySingleResult("SELECT count(*) FROM TempView")));
 //BA.debugLineNum = 306;BA.debugLine="mFirstRowIndex = 0";
_vvvvvvvvvvvvv2 = (int) (0);
 //BA.debugLineNum = 307;BA.debugLine="SQLTableName = \"TempView\"";
_vvvvvvvvvvvvvvvvv1 = "TempView";
 //BA.debugLineNum = 308;BA.debugLine="UpdateData";
_vvvvvvvvvvv7();
 //BA.debugLineNum = 309;BA.debugLine="End Sub";
return "";
}
public String  _vvvv5() throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
com.stanks.andsokoban_full.b4xtable._b4xtablecolumn _column = null;
 //BA.debugLineNum = 589;BA.debugLine="Private Sub CreateTable";
 //BA.debugLineNum = 590;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 591;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 592;BA.debugLine="sb.Append(\"CREATE TABLE data (\")";
_sb.Append("CREATE TABLE data (");
 //BA.debugLineNum = 593;BA.debugLine="Dim i As Int";
_i = 0;
 //BA.debugLineNum = 594;BA.debugLine="For Each Column As B4XTableColumn In Columns";
{
final anywheresoftware.b4a.BA.IterableList group5 = _vvvvvvvvvvvv0;
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_column = (com.stanks.andsokoban_full.b4xtable._b4xtablecolumn)(group5.Get(index5));
 //BA.debugLineNum = 595;BA.debugLine="Column.SQLID = \"c\" & i";
_column.SQLID = "c"+BA.NumberToString(_i);
 //BA.debugLineNum = 596;BA.debugLine="sb.Append(Column.SQLID & \" \" & ColumnToSQLType(C";
_sb.Append(_column.SQLID+" "+_vvvvvvvvv2(_column)+",");
 //BA.debugLineNum = 597;BA.debugLine="i = i + 1";
_i = (int) (_i+1);
 }
};
 //BA.debugLineNum = 599;BA.debugLine="sb.Remove(sb.Length - 1, sb.Length)";
_sb.Remove((int) (_sb.getLength()-1),_sb.getLength());
 //BA.debugLineNum = 600;BA.debugLine="sb.Append(\")\")";
_sb.Append(")");
 //BA.debugLineNum = 601;BA.debugLine="sql1.ExecNonQuery(sb.ToString)";
_vvvvvv0.ExecNonQuery(_sb.ToString());
 //BA.debugLineNum = 602;BA.debugLine="End Sub";
return "";
}
public void  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
ResumableSub_DesignerCreateView rsub = new ResumableSub_DesignerCreateView(this,_base,_lbl,_props);
rsub.resume(ba, null);
}
public static class ResumableSub_DesignerCreateView extends BA.ResumableSub {
public ResumableSub_DesignerCreateView(com.stanks.andsokoban_full.b4xtable parent,Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) {
this.parent = parent;
this._base = _base;
this._lbl = _lbl;
this._props = _props;
}
com.stanks.andsokoban_full.b4xtable parent;
Object _base;
anywheresoftware.b4a.objects.LabelWrapper _lbl;
anywheresoftware.b4a.objects.collections.Map _props;
anywheresoftware.b4j.object.JavaObject _jo = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 102;BA.debugLine="mBase = Base";
parent._vvvvvvvvvvvv5.setObject((java.lang.Object)(_base));
 //BA.debugLineNum = 103;BA.debugLine="LastBaseHeight = mBase.Height";
parent._vvvvvvvvvvvvvvvvv0 = parent._vvvvvvvvvvvv5.getHeight();
 //BA.debugLineNum = 104;BA.debugLine="Tag = mBase.Tag : mBase.Tag = Me";
parent._vvvvvvvvvvvv7 = parent._vvvvvvvvvvvv5.getTag();
 //BA.debugLineNum = 104;BA.debugLine="Tag = mBase.Tag : mBase.Tag = Me";
parent._vvvvvvvvvvvv5.setTag(parent);
 //BA.debugLineNum = 105;BA.debugLine="LayoutLoaded = False";
parent._vvvvvvvvvvvvvv3 = parent.__c.False;
 //BA.debugLineNum = 106;BA.debugLine="EvenRowColor = xui.PaintOrColorToColor(Props.Get(";
parent._vvvvvvvvvvvvvv6 = parent._vvvvvvvvvvvv6.PaintOrColorToColor(_props.Get((Object)("EvenRowColor")));
 //BA.debugLineNum = 107;BA.debugLine="OddRowColor = xui.PaintOrColorToColor(Props.Get(\"";
parent._vvvvvvvvvvvvvv7 = parent._vvvvvvvvvvvv6.PaintOrColorToColor(_props.Get((Object)("OddRowColor")));
 //BA.debugLineNum = 108;BA.debugLine="HeaderTextColor = xui.PaintOrColorToColor(Props.G";
parent._vvvvvvvvvvvvvv0 = parent._vvvvvvvvvvvv6.PaintOrColorToColor(_props.Get((Object)("HeaderTextColor")));
 //BA.debugLineNum = 109;BA.debugLine="TextColor = xui.PaintOrColorToColor(Props.Get(\"Te";
parent._vvvvvvvvvvvvvvv1 = parent._vvvvvvvvvvvv6.PaintOrColorToColor(_props.Get((Object)("TextColor")));
 //BA.debugLineNum = 110;BA.debugLine="HeaderColor = xui.PaintOrColorToColor(Props.Get(\"";
parent._vvvvvvvvvvvvvvv3 = parent._vvvvvvvvvvvv6.PaintOrColorToColor(_props.Get((Object)("HeaderColor")));
 //BA.debugLineNum = 111;BA.debugLine="GridColor = xui.PaintOrColorToColor(Props.Get(\"Gr";
parent._vvvvvvvvvvvvvvv4 = parent._vvvvvvvvvvvv6.PaintOrColorToColor(_props.Get((Object)("GridColor")));
 //BA.debugLineNum = 112;BA.debugLine="SelectionColor = xui.PaintOrColorToColor(Props.Ge";
parent._vvvvvvvvvvvvvvvv0 = parent._vvvvvvvvvvvv6.PaintOrColorToColor(_props.Get((Object)("SelectionColor")));
 //BA.debugLineNum = 113;BA.debugLine="HighlightTextColor = xui.PaintOrColorToColor(Prop";
parent._vvvvvvvvvvvvvvv2 = parent._vvvvvvvvvvvv6.PaintOrColorToColor(_props.GetDefault((Object)("HighlightTextColor"),(Object)(0xffff0000)));
 //BA.debugLineNum = 114;BA.debugLine="If Bit.And(SelectionColor, 0xff000000) = 0 Then S";
if (true) break;

case 1:
//if
this.state = 6;
if (parent.__c.Bit.And(parent._vvvvvvvvvvvvvvvv0,(int) (0xff000000))==0) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
parent._vvvvvvvvvvvvvvvv0 = (int) (0);
if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 115;BA.debugLine="Sleep(0)";
parent.__c.Sleep(ba,this,(int) (0));
this.state = 7;
return;
case 7:
//C
this.state = -1;
;
 //BA.debugLineNum = 116;BA.debugLine="mBase.LoadLayout(\"B4XTable\")";
parent._vvvvvvvvvvvv5.LoadLayout("B4XTable",ba);
 //BA.debugLineNum = 117;BA.debugLine="SearchField.LargeLabelTextSize = 14";
parent._searchfield._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = (float) (14);
 //BA.debugLineNum = 118;BA.debugLine="SearchField.SmallLabelTextSize = 8";
parent._searchfield._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = (float) (8);
 //BA.debugLineNum = 119;BA.debugLine="SearchField.Update";
parent._searchfield._vvvvvvvvvvvvvvvvvvvvvvvvv3();
 //BA.debugLineNum = 121;BA.debugLine="Dim jo As JavaObject = SearchField.TextField";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(parent._searchfield._getvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5().getObject()));
 //BA.debugLineNum = 122;BA.debugLine="jo.RunMethod(\"setImeOptions\", Array(Bit.Or(6, 0x1";
_jo.RunMethod("setImeOptions",new Object[]{(Object)(parent.__c.Bit.Or((int) (6),(int) (0x10000000)))});
 //BA.debugLineNum = 127;BA.debugLine="SetMouseTransparent(lblSort)";
parent._vvvvvvvvvvv3(parent._lblsort);
 //BA.debugLineNum = 128;BA.debugLine="clvData.AsView.SetColorAndBorder(0, 0, 0, 0)";
parent._clvdata._asview().SetColorAndBorder((int) (0),(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 129;BA.debugLine="clvData.sv.SetColorAndBorder(0, 0, 0, 0)";
parent._clvdata._sv.SetColorAndBorder((int) (0),(int) (0),(int) (0),(int) (0));
 //BA.debugLineNum = 130;BA.debugLine="lblNumber.TextColor = ArrowsEnabledColor";
parent._lblnumber.setTextColor(parent._vvvvvvvvvvvvvvvv5);
 //BA.debugLineNum = 131;BA.debugLine="LayoutLoaded = True";
parent._vvvvvvvvvvvvvv3 = parent.__c.True;
 //BA.debugLineNum = 132;BA.debugLine="Refresh2 (True)";
parent._vvvvvvvvvv6(parent.__c.True);
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public com.stanks.andsokoban_full.b4xtable._b4xtablecolumn  _vvvvvvvvv6(String _columnid) throws Exception{
com.stanks.andsokoban_full.b4xtable._b4xtablecolumn _c = null;
 //BA.debugLineNum = 451;BA.debugLine="Public Sub GetColumn (ColumnId As String) As B4XTa";
 //BA.debugLineNum = 452;BA.debugLine="For Each c As B4XTableColumn In Columns";
{
final anywheresoftware.b4a.BA.IterableList group1 = _vvvvvvvvvvvv0;
final int groupLen1 = group1.getSize()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_c = (com.stanks.andsokoban_full.b4xtable._b4xtablecolumn)(group1.Get(index1));
 //BA.debugLineNum = 453;BA.debugLine="If c.Id = ColumnId Then Return c";
if ((_c.Id).equals(_columnid)) { 
if (true) return _c;};
 }
};
 //BA.debugLineNum = 455;BA.debugLine="Return c";
if (true) return _c;
 //BA.debugLineNum = 456;BA.debugLine="End Sub";
return null;
}
public int  _getvvvvvvvvvvvv1() throws Exception{
 //BA.debugLineNum = 790;BA.debugLine="Public Sub getCurrentPage As Int";
 //BA.debugLineNum = 791;BA.debugLine="Return mCurrentPage";
if (true) return _vvvvvvvvvvvvvvv0;
 //BA.debugLineNum = 792;BA.debugLine="End Sub";
return 0;
}
public int  _getvvvvvvvvvvvv2() throws Exception{
 //BA.debugLineNum = 785;BA.debugLine="Public Sub getFirstRowIndex As Int";
 //BA.debugLineNum = 786;BA.debugLine="Return mFirstRowIndex";
if (true) return _vvvvvvvvvvvvv2;
 //BA.debugLineNum = 787;BA.debugLine="End Sub";
return 0;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _vvvvvvvvvv1(com.stanks.andsokoban_full.b4xtable._b4xtablecolumn _c,int _index) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
 //BA.debugLineNum = 468;BA.debugLine="Private Sub GetLabelFromColumn (c As B4XTableColum";
 //BA.debugLineNum = 469;BA.debugLine="Dim p As B4XView = c.CellsLayouts.Get(Index)";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p.setObject((java.lang.Object)(_c.CellsLayouts.Get(_index)));
 //BA.debugLineNum = 470;BA.debugLine="Return p.GetView(c.LabelIndex)";
if (true) return _p.GetView(_c.LabelIndex);
 //BA.debugLineNum = 471;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.Map  _vvvvvvvvvv2(long _rowid) throws Exception{
anywheresoftware.b4a.objects.collections.Map _m = null;
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
com.stanks.andsokoban_full.b4xtable._b4xtablecolumn _c = null;
 //BA.debugLineNum = 758;BA.debugLine="Public Sub GetRow(RowId As Long) As Map";
 //BA.debugLineNum = 759;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 760;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 761;BA.debugLine="Dim rs As ResultSet = sql1.ExecQuery2(\"SELECT * F";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs.setObject((android.database.Cursor)(_vvvvvv0.ExecQuery2("SELECT * FROM data WHERE rowid = ?",new String[]{BA.NumberToString(_rowid)})));
 //BA.debugLineNum = 762;BA.debugLine="If rs.NextRow Then";
if (_rs.NextRow()) { 
 //BA.debugLineNum = 763;BA.debugLine="For Each c As B4XTableColumn In Columns";
{
final anywheresoftware.b4a.BA.IterableList group5 = _vvvvvvvvvvvv0;
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_c = (com.stanks.andsokoban_full.b4xtable._b4xtablecolumn)(group5.Get(index5));
 //BA.debugLineNum = 764;BA.debugLine="Select c.ColumnType";
switch (BA.switchObjectToInt(_c.ColumnType,_column_type_text,_column_type_numbers,_column_type_date)) {
case 0: {
 //BA.debugLineNum = 766;BA.debugLine="m.Put(c.Id, rs.GetString(c.SQLID))";
_m.Put((Object)(_c.Id),(Object)(_rs.GetString(_c.SQLID)));
 break; }
case 1: {
 //BA.debugLineNum = 768;BA.debugLine="m.Put(c.Id, rs.GetDouble(c.SQLID))";
_m.Put((Object)(_c.Id),(Object)(_rs.GetDouble(_c.SQLID)));
 break; }
case 2: {
 //BA.debugLineNum = 770;BA.debugLine="m.Put(c.Id, rs.GetLong(c.SQLID))";
_m.Put((Object)(_c.Id),(Object)(_rs.GetLong(_c.SQLID)));
 break; }
}
;
 }
};
 };
 //BA.debugLineNum = 774;BA.debugLine="rs.Close";
_rs.Close();
 //BA.debugLineNum = 775;BA.debugLine="Return m";
if (true) return _m;
 //BA.debugLineNum = 776;BA.debugLine="End Sub";
return null;
}
public String  _vvvvvvvvvv3(com.stanks.andsokoban_full.b4xtable._b4xtablecolumn _col) throws Exception{
com.stanks.andsokoban_full.b4xtable._b4xtablecolumn _c = null;
 //BA.debugLineNum = 724;BA.debugLine="Private Sub HeaderClicked (col As B4XTableColumn)";
 //BA.debugLineNum = 725;BA.debugLine="If col.Sortable Then";
if (_col.Sortable) { 
 //BA.debugLineNum = 726;BA.debugLine="For Each c As B4XTableColumn In Columns";
{
final anywheresoftware.b4a.BA.IterableList group2 = _vvvvvvvvvvvv0;
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_c = (com.stanks.andsokoban_full.b4xtable._b4xtablecolumn)(group2.Get(index2));
 //BA.debugLineNum = 727;BA.debugLine="If c = col Then";
if ((_c).equals(_col)) { 
 //BA.debugLineNum = 728;BA.debugLine="If c.InternalSortMode = \"ASC\" Then c.InternalS";
if ((_c.InternalSortMode).equals("ASC")) { 
_c.InternalSortMode = "DESC";}
else {
_c.InternalSortMode = "ASC";};
 }else {
 //BA.debugLineNum = 730;BA.debugLine="c.InternalSortMode = \"\"";
_c.InternalSortMode = "";
 };
 }
};
 //BA.debugLineNum = 733;BA.debugLine="mFirstRowIndex = 0";
_vvvvvvvvvvvvv2 = (int) (0);
 //BA.debugLineNum = 734;BA.debugLine="UpdateSortIcon";
_vvvvvvvvvvv0();
 //BA.debugLineNum = 735;BA.debugLine="UpdateData";
_vvvvvvvvvvv7();
 };
 //BA.debugLineNum = 737;BA.debugLine="End Sub";
return "";
}
public void  _vvvvvvvvvv4(String _query,anywheresoftware.b4a.objects.collections.List _args,int _totalcount) throws Exception{
ResumableSub_ImplUpdateDataFromQuery rsub = new ResumableSub_ImplUpdateDataFromQuery(this,_query,_args,_totalcount);
rsub.resume(ba, null);
}
public static class ResumableSub_ImplUpdateDataFromQuery extends BA.ResumableSub {
public ResumableSub_ImplUpdateDataFromQuery(com.stanks.andsokoban_full.b4xtable parent,String _query,anywheresoftware.b4a.objects.collections.List _args,int _totalcount) {
this.parent = parent;
this._query = _query;
this._args = _args;
this._totalcount = _totalcount;
}
com.stanks.andsokoban_full.b4xtable parent;
String _query;
anywheresoftware.b4a.objects.collections.List _args;
int _totalcount;
int _limit = 0;
int _myindex = 0;
String[] _aargs = null;
int _i = 0;
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _rs = null;
boolean _success = false;
int _rownumber = 0;
com.stanks.andsokoban_full.b4xtable._b4xtablecolumn _c = null;
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
boolean _aretheremoreresults = false;
int step13;
int limit13;
anywheresoftware.b4a.BA.IterableList group22;
int index22;
int groupLen22;
int step37;
int limit37;
anywheresoftware.b4a.BA.IterableList group38;
int index38;
int groupLen38;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 319;BA.debugLine="SQLIndex = SQLIndex + 1";
parent._vvvvvvvvvvvvvv5 = (int) (parent._vvvvvvvvvvvvvv5+1);
 //BA.debugLineNum = 320;BA.debugLine="If mRowsPerPage = 0 Then Return";
if (true) break;

case 1:
//if
this.state = 6;
if (parent._vvvvvvvvvvvvvv2==0) { 
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
 //BA.debugLineNum = 321;BA.debugLine="Dim limit As Int = mRowsPerPage";
_limit = parent._vvvvvvvvvvvvvv2;
 //BA.debugLineNum = 322;BA.debugLine="If TotalCount < 0 Then limit = limit + 1";
if (true) break;

case 7:
//if
this.state = 12;
if (_totalcount<0) { 
this.state = 9;
;}if (true) break;

case 9:
//C
this.state = 12;
_limit = (int) (_limit+1);
if (true) break;

case 12:
//C
this.state = 13;
;
 //BA.debugLineNum = 323;BA.debugLine="Query = Query & $\" LIMIT ${mFirstRowIndex}, ${lim";
_query = _query+(" LIMIT "+parent.__c.SmartStringFormatter("",(Object)(parent._vvvvvvvvvvvvv2))+", "+parent.__c.SmartStringFormatter("",(Object)(_limit))+"");
 //BA.debugLineNum = 324;BA.debugLine="Dim MyIndex As Int = SQLIndex";
_myindex = parent._vvvvvvvvvvvvvv5;
 //BA.debugLineNum = 325;BA.debugLine="Sleep(40)";
parent.__c.Sleep(ba,this,(int) (40));
this.state = 72;
return;
case 72:
//C
this.state = 13;
;
 //BA.debugLineNum = 326;BA.debugLine="If MyIndex <> SQLIndex Then";
if (true) break;

case 13:
//if
this.state = 16;
if (_myindex!=parent._vvvvvvvvvvvvvv5) { 
this.state = 15;
}if (true) break;

case 15:
//C
this.state = 16;
 //BA.debugLineNum = 327;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 16:
//C
this.state = 17;
;
 //BA.debugLineNum = 329;BA.debugLine="VisibleRowIds.Clear";
parent._vvvvvvvvvvvvvvvv7.Clear();
 //BA.debugLineNum = 331;BA.debugLine="Dim aargs(Args.Size) As String";
_aargs = new String[_args.getSize()];
java.util.Arrays.fill(_aargs,"");
 //BA.debugLineNum = 332;BA.debugLine="For i = 0 To Args.Size - 1";
if (true) break;

case 17:
//for
this.state = 20;
step13 = 1;
limit13 = (int) (_args.getSize()-1);
_i = (int) (0) ;
this.state = 73;
if (true) break;

case 73:
//C
this.state = 20;
if ((step13 > 0 && _i <= limit13) || (step13 < 0 && _i >= limit13)) this.state = 19;
if (true) break;

case 74:
//C
this.state = 73;
_i = ((int)(0 + _i + step13)) ;
if (true) break;

case 19:
//C
this.state = 74;
 //BA.debugLineNum = 333;BA.debugLine="aargs(i) = Args.Get(i)";
_aargs[_i] = BA.ObjectToString(_args.Get(_i));
 if (true) break;
if (true) break;

case 20:
//C
this.state = 21;
;
 //BA.debugLineNum = 338;BA.debugLine="Dim rs As ResultSet = sql1.ExecQuery2(Query, aarg";
_rs = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
_rs.setObject((android.database.Cursor)(parent._vvvvvv0.ExecQuery2(_query,_aargs)));
 //BA.debugLineNum = 339;BA.debugLine="Dim success As Boolean = True";
_success = parent.__c.True;
 //BA.debugLineNum = 343;BA.debugLine="If success Then";
if (true) break;

case 21:
//if
this.state = 68;
if (_success) { 
this.state = 23;
}else {
this.state = 67;
}if (true) break;

case 23:
//C
this.state = 24;
 //BA.debugLineNum = 344;BA.debugLine="Dim RowNumber As Int = 1";
_rownumber = (int) (1);
 //BA.debugLineNum = 345;BA.debugLine="Do While RowNumber <= mRowsPerPage And rs.NextRo";
if (true) break;

case 24:
//do while
this.state = 39;
while (_rownumber<=parent._vvvvvvvvvvvvvv2 && _rs.NextRow()) {
this.state = 26;
if (true) break;
}
if (true) break;

case 26:
//C
this.state = 27;
 //BA.debugLineNum = 346;BA.debugLine="VisibleRowIds.Add(rs.GetLong(\"rowid\"))";
parent._vvvvvvvvvvvvvvvv7.Add((Object)(_rs.GetLong("rowid")));
 //BA.debugLineNum = 347;BA.debugLine="For Each c As B4XTableColumn In VisibleColumns";
if (true) break;

case 27:
//for
this.state = 38;
group22 = parent._vvvvvvvvvvvvv1;
index22 = 0;
groupLen22 = group22.getSize();
this.state = 75;
if (true) break;

case 75:
//C
this.state = 38;
if (index22 < groupLen22) {
this.state = 29;
_c = (com.stanks.andsokoban_full.b4xtable._b4xtablecolumn)(group22.Get(index22));}
if (true) break;

case 76:
//C
this.state = 75;
index22++;
if (true) break;

case 29:
//C
this.state = 30;
 //BA.debugLineNum = 348;BA.debugLine="Dim lbl As B4XView = GetLabelFromColumn(c, Row";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = parent._vvvvvvvvvv1(_c,_rownumber);
 //BA.debugLineNum = 349;BA.debugLine="Select c.ColumnType";
if (true) break;

case 30:
//select
this.state = 37;
switch (BA.switchObjectToInt(_c.ColumnType,parent._column_type_text,parent._column_type_numbers,parent._column_type_date)) {
case 0: {
this.state = 32;
if (true) break;
}
case 1: {
this.state = 34;
if (true) break;
}
case 2: {
this.state = 36;
if (true) break;
}
}
if (true) break;

case 32:
//C
this.state = 37;
 //BA.debugLineNum = 351;BA.debugLine="SetTextToCell(rs.GetString(c.SQLID), lbl, c.";
parent._vvvvvvvvvvv6(_rs.GetString(_c.SQLID),_lbl,_c.Searchable);
 if (true) break;

case 34:
//C
this.state = 37;
 //BA.debugLineNum = 353;BA.debugLine="c.Formatter.FormatLabel(rs.GetDouble(c.SQLID";
_c.Formatter._vvvvvvvvvvvvvvvvvv7(BA.NumberToString(_rs.GetDouble(_c.SQLID)),_lbl);
 if (true) break;

case 36:
//C
this.state = 37;
 //BA.debugLineNum = 355;BA.debugLine="lbl.Text = DateTime.Date(rs.GetLong(c.SQLID)";
_lbl.setText(BA.ObjectToCharSequence(parent.__c.DateTime.Date(_rs.GetLong(_c.SQLID))));
 if (true) break;

case 37:
//C
this.state = 76;
;
 if (true) break;
if (true) break;

case 38:
//C
this.state = 24;
;
 //BA.debugLineNum = 358;BA.debugLine="RowNumber = RowNumber + 1";
_rownumber = (int) (_rownumber+1);
 if (true) break;

case 39:
//C
this.state = 40;
;
 //BA.debugLineNum = 360;BA.debugLine="Dim AreThereMoreResults As Boolean = RowNumber =";
_aretheremoreresults = _rownumber==parent._vvvvvvvvvvvvvv2+1 && _rs.NextRow();
 //BA.debugLineNum = 361;BA.debugLine="rs.Close";
_rs.Close();
 //BA.debugLineNum = 362;BA.debugLine="For i = RowNumber To mRowsPerPage";
if (true) break;

case 40:
//for
this.state = 47;
step37 = 1;
limit37 = parent._vvvvvvvvvvvvvv2;
_i = _rownumber ;
this.state = 77;
if (true) break;

case 77:
//C
this.state = 47;
if ((step37 > 0 && _i <= limit37) || (step37 < 0 && _i >= limit37)) this.state = 42;
if (true) break;

case 78:
//C
this.state = 77;
_i = ((int)(0 + _i + step37)) ;
if (true) break;

case 42:
//C
this.state = 43;
 //BA.debugLineNum = 363;BA.debugLine="For Each c As B4XTableColumn In VisibleColumns";
if (true) break;

case 43:
//for
this.state = 46;
group38 = parent._vvvvvvvvvvvvv1;
index38 = 0;
groupLen38 = group38.getSize();
this.state = 79;
if (true) break;

case 79:
//C
this.state = 46;
if (index38 < groupLen38) {
this.state = 45;
_c = (com.stanks.andsokoban_full.b4xtable._b4xtablecolumn)(group38.Get(index38));}
if (true) break;

case 80:
//C
this.state = 79;
index38++;
if (true) break;

case 45:
//C
this.state = 80;
 //BA.debugLineNum = 367;BA.debugLine="GetLabelFromColumn(c, i).Text = \"\"";
parent._vvvvvvvvvv1(_c,_i).setText(BA.ObjectToCharSequence(""));
 if (true) break;
if (true) break;

case 46:
//C
this.state = 78;
;
 //BA.debugLineNum = 370;BA.debugLine="VisibleRowIds.Add(0)";
parent._vvvvvvvvvvvvvvvv7.Add((Object)(0));
 if (true) break;
if (true) break;

case 47:
//C
this.state = 48;
;
 //BA.debugLineNum = 372;BA.debugLine="mLastRowIndex = mFirstRowIndex - 2 + RowNumber";
parent._vvvvvvvvvvvvv3 = (int) (parent._vvvvvvvvvvvvv2-2+_rownumber);
 //BA.debugLineNum = 373;BA.debugLine="SetPageLabelState(lblLast, TotalCount >= 0)";
parent._vvvvvvvvvvv4(parent._lbllast,_totalcount>=0);
 //BA.debugLineNum = 374;BA.debugLine="If TotalCount >= 0 Then";
if (true) break;

case 48:
//if
this.state = 65;
if (_totalcount>=0) { 
this.state = 50;
}else {
this.state = 52;
}if (true) break;

case 50:
//C
this.state = 65;
 //BA.debugLineNum = 375;BA.debugLine="lblFromTo.Text = $\"${DefaultFormatter.Format(mF";
parent._lblfromto.setText(BA.ObjectToCharSequence((""+parent.__c.SmartStringFormatter("",(Object)(parent._vvvvvvvvvvvvv4._vvvvvvvvvvvvvvvvvv6(parent._vvvvvvvvvvvvv2+1)))+" "+parent.__c.SmartStringFormatter("",(Object)(parent._vvvvvvvvvvvvvvvvv5))+" "+parent.__c.SmartStringFormatter("",(Object)(parent._vvvvvvvvvvvvv4._vvvvvvvvvvvvvvvvvv6(parent._vvvvvvvvvvvvv3+1)))+" "+parent.__c.SmartStringFormatter("",(Object)(parent._vvvvvvvvvvvvvvvvv4))+" "+parent.__c.SmartStringFormatter("",(Object)(parent._vvvvvvvvvvvvv4._vvvvvvvvvvvvvvvvvv6(_totalcount)))+"")));
 //BA.debugLineNum = 376;BA.debugLine="SetPageLabelState(lblNext, mLastRowIndex < Tota";
parent._vvvvvvvvvvv4(parent._lblnext,parent._vvvvvvvvvvvvv3<_totalcount-1);
 //BA.debugLineNum = 377;BA.debugLine="SetPageLabelState(lblLast, lblNext.Tag)";
parent._vvvvvvvvvvv4(parent._lbllast,BA.ObjectToBoolean(parent._lblnext.getTag()));
 if (true) break;

case 52:
//C
this.state = 53;
 //BA.debugLineNum = 379;BA.debugLine="If mLastRowIndex = -1 Then";
if (true) break;

case 53:
//if
this.state = 64;
if (parent._vvvvvvvvvvvvv3==-1) { 
this.state = 55;
}else {
this.state = 57;
}if (true) break;

case 55:
//C
this.state = 64;
 //BA.debugLineNum = 380;BA.debugLine="lblFromTo.Text = StringNoMatches";
parent._lblfromto.setText(BA.ObjectToCharSequence(parent._vvvvvvvvvvvvvvvvv3));
 if (true) break;

case 57:
//C
this.state = 58;
 //BA.debugLineNum = 382;BA.debugLine="lblFromTo.Text = $\"${DefaultFormatter.Format(m";
parent._lblfromto.setText(BA.ObjectToCharSequence((""+parent.__c.SmartStringFormatter("",(Object)(parent._vvvvvvvvvvvvv4._vvvvvvvvvvvvvvvvvv6(parent._vvvvvvvvvvvvv2+1)))+" "+parent.__c.SmartStringFormatter("",(Object)(parent._vvvvvvvvvvvvvvvvv5))+" "+parent.__c.SmartStringFormatter("",(Object)(parent._vvvvvvvvvvvvv4._vvvvvvvvvvvvvvvvvv6(parent._vvvvvvvvvvvvv3+1)))+"")));
 //BA.debugLineNum = 383;BA.debugLine="If AreThereMoreResults Then lblFromTo.Text = l";
if (true) break;

case 58:
//if
this.state = 63;
if (_aretheremoreresults) { 
this.state = 60;
;}if (true) break;

case 60:
//C
this.state = 63;
parent._lblfromto.setText(BA.ObjectToCharSequence(parent._lblfromto.getText()+" "+parent._vvvvvvvvvvvvvvvvv2));
if (true) break;

case 63:
//C
this.state = 64;
;
 if (true) break;

case 64:
//C
this.state = 65;
;
 //BA.debugLineNum = 385;BA.debugLine="SetPageLabelState(lblNext, AreThereMoreResults)";
parent._vvvvvvvvvvv4(parent._lblnext,_aretheremoreresults);
 //BA.debugLineNum = 386;BA.debugLine="SetPageLabelState(lblLast, False)";
parent._vvvvvvvvvvv4(parent._lbllast,parent.__c.False);
 if (true) break;

case 65:
//C
this.state = 68;
;
 //BA.debugLineNum = 388;BA.debugLine="SetPageLabelState(lblBack, mFirstRowIndex > 0)";
parent._vvvvvvvvvvv4(parent._lblback,parent._vvvvvvvvvvvvv2>0);
 //BA.debugLineNum = 389;BA.debugLine="SetPageLabelState(lblFirst, lblBack.Tag)";
parent._vvvvvvvvvvv4(parent._lblfirst,BA.ObjectToBoolean(parent._lblback.getTag()));
 //BA.debugLineNum = 390;BA.debugLine="mCurrentPage = Ceil(mFirstRowIndex / mRowsPerPag";
parent._vvvvvvvvvvvvvvv0 = (int) (parent.__c.Ceil(parent._vvvvvvvvvvvvv2/(double)parent._vvvvvvvvvvvvvv2)+1);
 //BA.debugLineNum = 391;BA.debugLine="lblNumber.Text = NumberFormat(mCurrentPage, 0, 0";
parent._lblnumber.setText(BA.ObjectToCharSequence(parent.__c.NumberFormat(parent._vvvvvvvvvvvvvvv0,(int) (0),(int) (0))));
 //BA.debugLineNum = 392;BA.debugLine="rs.Close";
_rs.Close();
 //BA.debugLineNum = 393;BA.debugLine="mCurrentCount = TotalCount";
parent._vvvvvvvvvvvvvvvv1 = _totalcount;
 if (true) break;

case 67:
//C
this.state = 68;
 //BA.debugLineNum = 395;BA.debugLine="Log(LastException)";
parent.__c.LogImpl("910223693",BA.ObjectToString(parent.__c.LastException(ba)),0);
 if (true) break;
;
 //BA.debugLineNum = 397;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_DataUp";

case 68:
//if
this.state = 71;
if (parent._vvvvvvvvvvvv6.SubExists(ba,parent._vvvvvvvvvvvv4,parent._vvvvvvvvvvvv3+"_DataUpdated",(int) (0))) { 
this.state = 70;
}if (true) break;

case 70:
//C
this.state = 71;
 //BA.debugLineNum = 398;BA.debugLine="CallSub(mCallBack, mEventName & \"_DataUpdated\")";
parent.__c.CallSubNew(ba,parent._vvvvvvvvvvvv4,parent._vvvvvvvvvvvv3+"_DataUpdated");
 if (true) break;

case 71:
//C
this.state = -1;
;
 //BA.debugLineNum = 400;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 78;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
 //BA.debugLineNum = 79;BA.debugLine="mEventName = EventName";
_vvvvvvvvvvvv3 = _eventname;
 //BA.debugLineNum = 80;BA.debugLine="mCallBack = Callback";
_vvvvvvvvvvvv4 = _callback;
 //BA.debugLineNum = 81;BA.debugLine="Columns.Initialize";
_vvvvvvvvvvvv0.Initialize();
 //BA.debugLineNum = 82;BA.debugLine="DefaultFormatter.Initialize";
_vvvvvvvvvvvvv4._initialize(ba);
 //BA.debugLineNum = 83;BA.debugLine="DefaultDataFormatter.Initialize";
_vvvvvvvvvvvvv5._initialize(ba);
 //BA.debugLineNum = 84;BA.debugLine="VisibleColumns.Initialize";
_vvvvvvvvvvvvv1.Initialize();
 //BA.debugLineNum = 85;BA.debugLine="HeaderFont = xui.CreateDefaultBoldFont(15)";
_vvvvvvvvvvvvvvv5 = _vvvvvvvvvvvv6.CreateDefaultBoldFont((float) (15));
 //BA.debugLineNum = 86;BA.debugLine="LabelsFont = xui.CreateDefaultFont(15)";
_vvvvvvvvvvvvvvv6 = _vvvvvvvvvvvv6.CreateDefaultFont((float) (15));
 //BA.debugLineNum = 87;BA.debugLine="ArrowsDisabledColor = 0xFFBBBBBB";
_vvvvvvvvvvvvvvvv6 = (int) (0xffbbbbbb);
 //BA.debugLineNum = 88;BA.debugLine="ArrowsEnabledColor = xui.Color_Black";
_vvvvvvvvvvvvvvvv5 = _vvvvvvvvvvvv6.Color_Black;
 //BA.debugLineNum = 89;BA.debugLine="VisibleRowIds.Initialize";
_vvvvvvvvvvvvvvvv7.Initialize();
 //BA.debugLineNum = 90;BA.debugLine="MinimumWidth = 140dip";
_vvvvvvvvvvvvvv4 = __c.DipToCurrent((int) (140));
 //BA.debugLineNum = 91;BA.debugLine="RowHeight = 40dip";
_vvvvvvvvvvvvv7 = __c.DipToCurrent((int) (40));
 //BA.debugLineNum = 92;BA.debugLine="HeadersHeight = 40dip";
_vvvvvvvvvvvvv0 = __c.DipToCurrent((int) (40));
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
return "";
}
public String  _lbl_click() throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
 //BA.debugLineNum = 621;BA.debugLine="Private Sub lbl_Click";
 //BA.debugLineNum = 622;BA.debugLine="Dim lbl As B4XView = Sender";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl.setObject((java.lang.Object)(__c.Sender(ba)));
 //BA.debugLineNum = 623;BA.debugLine="CellClicked(lbl.Parent, False)";
_vvvvvvvv7(_lbl.getParent(),__c.False);
 //BA.debugLineNum = 624;BA.debugLine="End Sub";
return "";
}
public String  _lbl_longclick() throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
 //BA.debugLineNum = 626;BA.debugLine="Private Sub lbl_LongClick";
 //BA.debugLineNum = 627;BA.debugLine="Dim lbl As B4XView = Sender";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl.setObject((java.lang.Object)(__c.Sender(ba)));
 //BA.debugLineNum = 628;BA.debugLine="CellClicked(lbl.Parent, True)";
_vvvvvvvv7(_lbl.getParent(),__c.True);
 //BA.debugLineNum = 629;BA.debugLine="End Sub";
return "";
}
public String  _lblback_click() throws Exception{
 //BA.debugLineNum = 803;BA.debugLine="Private Sub lblBack_Click";
 //BA.debugLineNum = 804;BA.debugLine="If lblBack.Tag = False Then Return";
if ((_lblback.getTag()).equals((Object)(__c.False))) { 
if (true) return "";};
 //BA.debugLineNum = 805;BA.debugLine="setFirstRowIndex (mFirstRowIndex - mRowsPerPage)";
_setvvvvvvvvvvvv2((int) (_vvvvvvvvvvvvv2-_vvvvvvvvvvvvvv2));
 //BA.debugLineNum = 806;BA.debugLine="End Sub";
return "";
}
public String  _lblfirst_click() throws Exception{
 //BA.debugLineNum = 798;BA.debugLine="Private Sub lblFirst_Click";
 //BA.debugLineNum = 799;BA.debugLine="If lblFirst.Tag = False Then Return";
if ((_lblfirst.getTag()).equals((Object)(__c.False))) { 
if (true) return "";};
 //BA.debugLineNum = 800;BA.debugLine="setFirstRowIndex (0)";
_setvvvvvvvvvvvv2((int) (0));
 //BA.debugLineNum = 801;BA.debugLine="End Sub";
return "";
}
public String  _lbllast_click() throws Exception{
 //BA.debugLineNum = 808;BA.debugLine="Private Sub lblLast_Click";
 //BA.debugLineNum = 809;BA.debugLine="If lblLast.Tag = False Then Return";
if ((_lbllast.getTag()).equals((Object)(__c.False))) { 
if (true) return "";};
 //BA.debugLineNum = 810;BA.debugLine="setFirstRowIndex (Floor(mCurrentCount /  mRowsPer";
_setvvvvvvvvvvvv2((int) (__c.Floor(_vvvvvvvvvvvvvvvv1/(double)_vvvvvvvvvvvvvv2)*_vvvvvvvvvvvvvv2));
 //BA.debugLineNum = 811;BA.debugLine="End Sub";
return "";
}
public String  _lblnext_click() throws Exception{
 //BA.debugLineNum = 813;BA.debugLine="Private Sub lblNext_Click";
 //BA.debugLineNum = 814;BA.debugLine="If lblNext.Tag = False Then Return";
if ((_lblnext.getTag()).equals((Object)(__c.False))) { 
if (true) return "";};
 //BA.debugLineNum = 815;BA.debugLine="setFirstRowIndex (mFirstRowIndex + mRowsPerPage)";
_setvvvvvvvvvvvv2((int) (_vvvvvvvvvvvvv2+_vvvvvvvvvvvvvv2));
 //BA.debugLineNum = 816;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvv5() throws Exception{
 //BA.debugLineNum = 160;BA.debugLine="Public Sub Refresh";
 //BA.debugLineNum = 161;BA.debugLine="Refresh2(True)";
_vvvvvvvvvv6(__c.True);
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvv6(boolean _refreshdata) throws Exception{
int _prevrowsperpage = 0;
int _totalheight = 0;
int _columnindex = 0;
com.stanks.andsokoban_full.b4xtable._b4xtablecolumn _c = null;
int _freezedwidth = 0;
int _i = 0;
float _offset = 0f;
 //BA.debugLineNum = 164;BA.debugLine="Private Sub Refresh2 (RefreshData As Boolean)";
 //BA.debugLineNum = 165;BA.debugLine="If LayoutLoaded = False Or VisibleColumns.Size =";
if (_vvvvvvvvvvvvvv3==__c.False || _vvvvvvvvvvvvv1.getSize()==0) { 
if (true) return "";};
 //BA.debugLineNum = 166;BA.debugLine="Dim PrevRowsPerPage As Int = mRowsPerPage";
_prevrowsperpage = _vvvvvvvvvvvvvv2;
 //BA.debugLineNum = 167;BA.debugLine="If xui.IsB4A And LastBaseHeight <> mBase.Height T";
if (_vvvvvvvvvvvv6.getIsB4A() && _vvvvvvvvvvvvvvvvv0!=_vvvvvvvvvvvv5.getHeight()) { 
 //BA.debugLineNum = 168;BA.debugLine="clvData.AsView.Height = clvData.AsView.Height -";
_clvdata._asview().setHeight((int) (_clvdata._asview().getHeight()-(_vvvvvvvvvvvvvvvvv0-_vvvvvvvvvvvv5.getHeight())));
 //BA.debugLineNum = 169;BA.debugLine="clvData.Base_Resize(clvData.AsView.Width, clvDat";
_clvdata._base_resize(_clvdata._asview().getWidth(),_clvdata._asview().getHeight());
 //BA.debugLineNum = 170;BA.debugLine="LastBaseHeight = mBase.Height";
_vvvvvvvvvvvvvvvvv0 = _vvvvvvvvvvvv5.getHeight();
 };
 //BA.debugLineNum = 172;BA.debugLine="Dim TotalHeight As Int = clvData.AsView.Height -";
_totalheight = (int) (_clvdata._asview().getHeight()-_vvvvvvvvvvvvv0);
 //BA.debugLineNum = 173;BA.debugLine="If xui.IsB4J Then";
if (_vvvvvvvvvvvv6.getIsB4J()) { 
 //BA.debugLineNum = 174;BA.debugLine="TotalHeight = TotalHeight - 20";
_totalheight = (int) (_totalheight-20);
 };
 //BA.debugLineNum = 176;BA.debugLine="If AllowSmallRowHeightModifications Then";
if (_vvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 177;BA.debugLine="mRowsPerPage = Max(0, Round(TotalHeight/ RowHeig";
_vvvvvvvvvvvvvv2 = (int) (__c.Max(0,__c.Round(_totalheight/(double)_vvvvvvvvvvvvv7)));
 }else {
 //BA.debugLineNum = 179;BA.debugLine="mRowsPerPage = Max(0, Floor(TotalHeight / RowHei";
_vvvvvvvvvvvvvv2 = (int) (__c.Max(0,__c.Floor(_totalheight/(double)_vvvvvvvvvvvvv7)));
 };
 //BA.debugLineNum = 181;BA.debugLine="If MaximumRowsPerPage > 0 Then";
if (_vvvvvvvvvvvvvvvvv6>0) { 
 //BA.debugLineNum = 182;BA.debugLine="mRowsPerPage = Min(MaximumRowsPerPage, mRowsPerP";
_vvvvvvvvvvvvvv2 = (int) (__c.Min(_vvvvvvvvvvvvvvvvv6,_vvvvvvvvvvvvvv2));
 //BA.debugLineNum = 183;BA.debugLine="TotalHeight = Min(TotalHeight, MaximumRowsPerPag";
_totalheight = (int) (__c.Min(_totalheight,_vvvvvvvvvvvvvvvvv6*_vvvvvvvvvvvvv7));
 };
 //BA.debugLineNum = 185;BA.debugLine="If PrevRowsPerPage <> mRowsPerPage Then RefreshDa";
if (_prevrowsperpage!=_vvvvvvvvvvvvvv2) { 
_refreshdata = __c.True;};
 //BA.debugLineNum = 186;BA.debugLine="If RefreshData Then UpdateData";
if (_refreshdata) { 
_vvvvvvvvvvv7();};
 //BA.debugLineNum = 187;BA.debugLine="If VisibleColumns.Size = 0 Then Return";
if (_vvvvvvvvvvvvv1.getSize()==0) { 
if (true) return "";};
 //BA.debugLineNum = 188;BA.debugLine="CalculateWidths";
_vvvvvvvv6();
 //BA.debugLineNum = 189;BA.debugLine="Dim ColumnIndex As Int";
_columnindex = 0;
 //BA.debugLineNum = 191;BA.debugLine="For Each c As B4XTableColumn In VisibleColumns";
{
final anywheresoftware.b4a.BA.IterableList group26 = _vvvvvvvvvvvvv1;
final int groupLen26 = group26.getSize()
;int index26 = 0;
;
for (; index26 < groupLen26;index26++){
_c = (com.stanks.andsokoban_full.b4xtable._b4xtablecolumn)(group26.Get(index26));
 //BA.debugLineNum = 192;BA.debugLine="If c.Panel.Parent.IsInitialized = False Then";
if (_c.Panel.getParent().IsInitialized()==__c.False) { 
 //BA.debugLineNum = 193;BA.debugLine="c.Panel.Width = c.ComputedWidth";
_c.Panel.setWidth(_c.ComputedWidth);
 //BA.debugLineNum = 194;BA.debugLine="If ColumnIndex < NumberOfFrozenColumns Then";
if (_columnindex<_vvvvvvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 195;BA.debugLine="mBase.AddView(c.Panel, 0, 0, 0, 0)";
_vvvvvvvvvvvv5.AddView((android.view.View)(_c.Panel.getObject()),(int) (0),(int) (0),(int) (0),(int) (0));
 }else {
 //BA.debugLineNum = 197;BA.debugLine="AddColumnToCLV (c)";
_vvvvvvvv4(_c);
 };
 };
 //BA.debugLineNum = 201;BA.debugLine="CreateColumnLayouts(c, mRowsPerPage + 1)";
_vvvvvvvvv4(_c,(int) (_vvvvvvvvvvvvvv2+1));
 //BA.debugLineNum = 202;BA.debugLine="ResizeColumnImpl(c, TotalHeight)";
_vvvvvvvvvv7(_c,_totalheight);
 //BA.debugLineNum = 203;BA.debugLine="ColumnIndex = ColumnIndex + 1";
_columnindex = (int) (_columnindex+1);
 }
};
 //BA.debugLineNum = 205;BA.debugLine="Dim FreezedWidth As Int";
_freezedwidth = 0;
 //BA.debugLineNum = 206;BA.debugLine="For i = 0 To NumberOfFrozenColumns - 1";
{
final int step40 = 1;
final int limit40 = (int) (_vvvvvvvvvvvvvvvvvv1-1);
_i = (int) (0) ;
for (;_i <= limit40 ;_i = _i + step40 ) {
 //BA.debugLineNum = 207;BA.debugLine="Dim c As B4XTableColumn = VisibleColumns.Get(i)";
_c = (com.stanks.andsokoban_full.b4xtable._b4xtablecolumn)(_vvvvvvvvvvvvv1.Get(_i));
 //BA.debugLineNum = 211;BA.debugLine="Dim offset As Float = 0";
_offset = (float) (0);
 //BA.debugLineNum = 213;BA.debugLine="c.Panel.SetLayoutAnimated(0, offset + FreezedWid";
_c.Panel.SetLayoutAnimated((int) (0),(int) (_offset+_freezedwidth),(int) (_clvdata._asview().getTop()+_offset),_c.ComputedWidth,_clvdata._asview().getHeight());
 //BA.debugLineNum = 215;BA.debugLine="FreezedWidth = FreezedWidth + c.ComputedWidth";
_freezedwidth = (int) (_freezedwidth+_c.ComputedWidth);
 }
};
 //BA.debugLineNum = 217;BA.debugLine="clvData.AsView.Left = FreezedWidth";
_clvdata._asview().setLeft(_freezedwidth);
 //BA.debugLineNum = 218;BA.debugLine="If Round(clvData.AsView.Width) <> Round(mBase.Wid";
if (__c.Round(_clvdata._asview().getWidth())!=__c.Round(_vvvvvvvvvvvv5.getWidth()-_freezedwidth)) { 
 //BA.debugLineNum = 219;BA.debugLine="clvData.AsView.Width = mBase.Width - FreezedWidt";
_clvdata._asview().setWidth((int) (_vvvvvvvvvvvv5.getWidth()-_freezedwidth));
 //BA.debugLineNum = 220;BA.debugLine="If xui.IsB4A Then clvData.Base_Resize(clvData.As";
if (_vvvvvvvvvvvv6.getIsB4A()) { 
_clvdata._base_resize(_clvdata._asview().getWidth(),_clvdata._asview().getHeight());};
 };
 //BA.debugLineNum = 222;BA.debugLine="For i = NumberOfFrozenColumns To VisibleColumns.S";
{
final int step51 = 1;
final int limit51 = (int) (_vvvvvvvvvvvvv1.getSize()-1);
_i = _vvvvvvvvvvvvvvvvvv1 ;
for (;_i <= limit51 ;_i = _i + step51 ) {
 //BA.debugLineNum = 223;BA.debugLine="Dim c As B4XTableColumn = VisibleColumns.Get(i)";
_c = (com.stanks.andsokoban_full.b4xtable._b4xtablecolumn)(_vvvvvvvvvvvvv1.Get(_i));
 //BA.debugLineNum = 224;BA.debugLine="clvData.ResizeItem(i - NumberOfFrozenColumns, c.";
_clvdata._resizeitem((int) (_i-_vvvvvvvvvvvvvvvvvv1),_c.ComputedWidth);
 }
};
 //BA.debugLineNum = 227;BA.debugLine="UpdateSortIcon";
_vvvvvvvvvvv0();
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvv7(com.stanks.andsokoban_full.b4xtable._b4xtablecolumn _c,int _totalheight) throws Exception{
float _height = 0f;
int _topint = 0;
int _heightint = 0;
int _i = 0;
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
 //BA.debugLineNum = 230;BA.debugLine="Private Sub ResizeColumnImpl (c As B4XTableColumn,";
 //BA.debugLineNum = 231;BA.debugLine="c.Panel.Width = c.ComputedWidth";
_c.Panel.setWidth(_c.ComputedWidth);
 //BA.debugLineNum = 233;BA.debugLine="Dim Height As Float = TotalHeight / mRowsPerPage";
_height = (float) (_totalheight/(double)_vvvvvvvvvvvvvv2);
 //BA.debugLineNum = 234;BA.debugLine="If AllowSmallRowHeightModifications = False Then";
if (_vvvvvvvvvvvvvv1==__c.False) { 
_height = (float) (_vvvvvvvvvvvvv7);};
 //BA.debugLineNum = 235;BA.debugLine="Dim TopInt, HeightInt As Int";
_topint = 0;
_heightint = 0;
 //BA.debugLineNum = 236;BA.debugLine="For i = 0 To c.CellsLayouts.Size - 1";
{
final int step5 = 1;
final int limit5 = (int) (_c.CellsLayouts.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 237;BA.debugLine="Dim p As B4XView = c.CellsLayouts.Get(i)";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p.setObject((java.lang.Object)(_c.CellsLayouts.Get(_i)));
 //BA.debugLineNum = 238;BA.debugLine="If i < mRowsPerPage + 1 Then";
if (_i<_vvvvvvvvvvvvvv2+1) { 
 //BA.debugLineNum = 239;BA.debugLine="Dim HeightInt As Int = Round(Height * i + Heade";
_heightint = (int) (__c.Round(_height*_i+_vvvvvvvvvvvvv0-_topint));
 //BA.debugLineNum = 240;BA.debugLine="If i = 0 Then HeightInt = HeadersHeight";
if (_i==0) { 
_heightint = _vvvvvvvvvvvvv0;};
 //BA.debugLineNum = 241;BA.debugLine="p.SetLayoutAnimated(0, 0, TopInt, c.ComputedWid";
_p.SetLayoutAnimated((int) (0),(int) (0),_topint,_c.ComputedWidth,_heightint);
 //BA.debugLineNum = 242;BA.debugLine="p.Visible = True";
_p.setVisible(__c.True);
 //BA.debugLineNum = 243;BA.debugLine="If c.DisableAutoResizeLayout = False Then";
if (_c.DisableAutoResizeLayout==__c.False) { 
 //BA.debugLineNum = 244;BA.debugLine="Dim lbl As B4XView = p.GetView(0)";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = _p.GetView((int) (0));
 //BA.debugLineNum = 245;BA.debugLine="lbl.SetLayoutAnimated(0, 0, 0, p.Width, p.Heig";
_lbl.SetLayoutAnimated((int) (0),(int) (0),(int) (0),_p.getWidth(),_p.getHeight());
 };
 //BA.debugLineNum = 252;BA.debugLine="TopInt = TopInt + HeightInt";
_topint = (int) (_topint+_heightint);
 }else {
 //BA.debugLineNum = 254;BA.debugLine="p.Visible = False";
_p.setVisible(__c.False);
 };
 }
};
 //BA.debugLineNum = 257;BA.debugLine="End Sub";
return "";
}
public void  _searchfield_textchanged(String _old,String _new) throws Exception{
ResumableSub_SearchField_TextChanged rsub = new ResumableSub_SearchField_TextChanged(this,_old,_new);
rsub.resume(ba, null);
}
public static class ResumableSub_SearchField_TextChanged extends BA.ResumableSub {
public ResumableSub_SearchField_TextChanged(com.stanks.andsokoban_full.b4xtable parent,String _old,String _new) {
this.parent = parent;
this._old = _old;
this._new = _new;
}
com.stanks.andsokoban_full.b4xtable parent;
String _old;
String _new;
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
 //BA.debugLineNum = 838;BA.debugLine="SearchIndex = SearchIndex + 1";
parent._vvvvvvvvvvvvvvvv4 = (int) (parent._vvvvvvvvvvvvvvvv4+1);
 //BA.debugLineNum = 839;BA.debugLine="Dim MyIndex As Int = SearchIndex";
_myindex = parent._vvvvvvvvvvvvvvvv4;
 //BA.debugLineNum = 840;BA.debugLine="Sleep(SleepBeforeSearch)";
parent.__c.Sleep(ba,this,parent._vvvvvvvvvvvvvvvv3);
this.state = 5;
return;
case 5:
//C
this.state = 1;
;
 //BA.debugLineNum = 841;BA.debugLine="If MyIndex <> SearchIndex Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_myindex!=parent._vvvvvvvvvvvvvvvv4) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 842;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 844;BA.debugLine="FilterText = New.ToLowerCase";
parent._vvvvvvvvvvvvvvvv2 = _new.toLowerCase();
 //BA.debugLineNum = 845;BA.debugLine="mFirstRowIndex = 0";
parent._vvvvvvvvvvvvv2 = (int) (0);
 //BA.debugLineNum = 846;BA.debugLine="UpdateData";
parent._vvvvvvvvvvv7();
 //BA.debugLineNum = 847;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _setvvvvvvvvvvvv1(int _p) throws Exception{
 //BA.debugLineNum = 794;BA.debugLine="Public Sub setCurrentPage(p As Int)";
 //BA.debugLineNum = 795;BA.debugLine="setFirstRowIndex((p - 1) * mRowsPerPage)";
_setvvvvvvvvvvvv2((int) ((_p-1)*_vvvvvvvvvvvvvv2));
 //BA.debugLineNum = 796;BA.debugLine="End Sub";
return "";
}
public void  _vvvvvvvvvvv1(anywheresoftware.b4a.objects.collections.List _data) throws Exception{
ResumableSub_SetData rsub = new ResumableSub_SetData(this,_data);
rsub.resume(ba, null);
}
public static class ResumableSub_SetData extends BA.ResumableSub {
public ResumableSub_SetData(com.stanks.andsokoban_full.b4xtable parent,anywheresoftware.b4a.objects.collections.List _data) {
this.parent = parent;
this._data = _data;
}
com.stanks.andsokoban_full.b4xtable parent;
anywheresoftware.b4a.objects.collections.List _data;
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
Object[] _row = null;
Object _senderfilter = null;
boolean _success = false;
int step7;
int limit7;
anywheresoftware.b4a.BA.IterableList group12;
int index12;
int groupLen12;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 563;BA.debugLine="If sql1.IsInitialized Then sql1.Close";
if (true) break;

case 1:
//if
this.state = 6;
if (parent._vvvvvv0.IsInitialized()) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
parent._vvvvvv0.Close();
if (true) break;

case 6:
//C
this.state = 7;
;
 //BA.debugLineNum = 567;BA.debugLine="sql1.Initialize(\"\", \":memory:\", True)";
parent._vvvvvv0.Initialize("",":memory:",parent.__c.True);
 //BA.debugLineNum = 569;BA.debugLine="CreateTable";
parent._vvvv5();
 //BA.debugLineNum = 570;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 571;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 572;BA.debugLine="sb.Append(\"INSERT INTO data VALUES (\")";
_sb.Append("INSERT INTO data VALUES (");
 //BA.debugLineNum = 573;BA.debugLine="For i = 0 To Columns.Size - 1";
if (true) break;

case 7:
//for
this.state = 10;
step7 = 1;
limit7 = (int) (parent._vvvvvvvvvvvv0.getSize()-1);
_i = (int) (0) ;
this.state = 15;
if (true) break;

case 15:
//C
this.state = 10;
if ((step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7)) this.state = 9;
if (true) break;

case 16:
//C
this.state = 15;
_i = ((int)(0 + _i + step7)) ;
if (true) break;

case 9:
//C
this.state = 16;
 //BA.debugLineNum = 574;BA.debugLine="sb.Append(\"?,\")";
_sb.Append("?,");
 if (true) break;
if (true) break;

case 10:
//C
this.state = 11;
;
 //BA.debugLineNum = 576;BA.debugLine="sb.Remove(sb.Length - 1, sb.Length)";
_sb.Remove((int) (_sb.getLength()-1),_sb.getLength());
 //BA.debugLineNum = 577;BA.debugLine="sb.Append(\")\")";
_sb.Append(")");
 //BA.debugLineNum = 578;BA.debugLine="For Each row() As Object In Data";
if (true) break;

case 11:
//for
this.state = 14;
group12 = _data;
index12 = 0;
groupLen12 = group12.getSize();
this.state = 17;
if (true) break;

case 17:
//C
this.state = 14;
if (index12 < groupLen12) {
this.state = 13;
_row = (Object[])(group12.Get(index12));}
if (true) break;

case 18:
//C
this.state = 17;
index12++;
if (true) break;

case 13:
//C
this.state = 18;
 //BA.debugLineNum = 579;BA.debugLine="sql1.AddNonQueryToBatch(sb.ToString, row)";
parent._vvvvvv0.AddNonQueryToBatch(_sb.ToString(),anywheresoftware.b4a.keywords.Common.ArrayToList(_row));
 if (true) break;
if (true) break;

case 14:
//C
this.state = -1;
;
 //BA.debugLineNum = 581;BA.debugLine="Dim SenderFilter As Object = sql1.ExecNonQueryBat";
_senderfilter = parent._vvvvvv0.ExecNonQueryBatch(ba,"SQL1");
 //BA.debugLineNum = 583;BA.debugLine="Wait For (SenderFilter) SQL1_NonQueryComplete (Su";
parent.__c.WaitFor("sql1_nonquerycomplete", ba, this, _senderfilter);
this.state = 19;
return;
case 19:
//C
this.state = -1;
_success = (Boolean) result[0];
;
 //BA.debugLineNum = 585;BA.debugLine="CountAll = Data.Size";
parent._vvvvvvvvvvvvvvv7 = _data.getSize();
 //BA.debugLineNum = 586;BA.debugLine="Refresh2 (True)";
parent._vvvvvvvvvv6(parent.__c.True);
 //BA.debugLineNum = 587;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _sql1_nonquerycomplete(boolean _success) throws Exception{
}
public String  _setvvvvvvvvvvvv2(int _row) throws Exception{
 //BA.debugLineNum = 779;BA.debugLine="Public Sub setFirstRowIndex (row As Int)";
 //BA.debugLineNum = 780;BA.debugLine="row = Max(0, Min(CountAll - 1, row))";
_row = (int) (__c.Max(0,__c.Min(_vvvvvvvvvvvvvvv7-1,_row)));
 //BA.debugLineNum = 781;BA.debugLine="mFirstRowIndex = row";
_vvvvvvvvvvvvv2 = _row;
 //BA.debugLineNum = 782;BA.debugLine="UpdateData";
_vvvvvvvvvvv7();
 //BA.debugLineNum = 783;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvv3(anywheresoftware.b4a.objects.B4XViewWrapper _lbl) throws Exception{
 //BA.debugLineNum = 653;BA.debugLine="Private Sub SetMouseTransparent (lbl As B4XView)";
 //BA.debugLineNum = 658;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvv4(anywheresoftware.b4a.objects.B4XViewWrapper _lbl,boolean _enabled) throws Exception{
 //BA.debugLineNum = 458;BA.debugLine="Private Sub SetPageLabelState (lbl As B4XView, ena";
 //BA.debugLineNum = 459;BA.debugLine="If lbl.Tag = enabled Then Return";
if ((_lbl.getTag()).equals((Object)(_enabled))) { 
if (true) return "";};
 //BA.debugLineNum = 460;BA.debugLine="lbl.Tag = enabled";
_lbl.setTag((Object)(_enabled));
 //BA.debugLineNum = 461;BA.debugLine="If enabled Then";
if (_enabled) { 
 //BA.debugLineNum = 462;BA.debugLine="lbl.TextColor = ArrowsEnabledColor";
_lbl.setTextColor(_vvvvvvvvvvvvvvvv5);
 }else {
 //BA.debugLineNum = 464;BA.debugLine="lbl.TextColor = ArrowsDisabledColor";
_lbl.setTextColor(_vvvvvvvvvvvvvvvv6);
 };
 //BA.debugLineNum = 466;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvv5(anywheresoftware.b4a.objects.B4XViewWrapper _xlbl,Object _text) throws Exception{
 //BA.debugLineNum = 660;BA.debugLine="Private Sub SetTextOrCSBuilderToLabel(xlbl As B4XV";
 //BA.debugLineNum = 662;BA.debugLine="xlbl.Text = Text";
_xlbl.setText(BA.ObjectToCharSequence(_text));
 //BA.debugLineNum = 672;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvv6(String _text,anywheresoftware.b4a.objects.B4XViewWrapper _lbl,boolean _searchable) throws Exception{
int _x = 0;
anywheresoftware.b4a.objects.CSBuilder _cs = null;
 //BA.debugLineNum = 402;BA.debugLine="Private Sub SetTextToCell (Text As String, lbl As";
 //BA.debugLineNum = 403;BA.debugLine="If Searchable = False Then";
if (_searchable==__c.False) { 
 //BA.debugLineNum = 404;BA.debugLine="lbl.Text = Text";
_lbl.setText(BA.ObjectToCharSequence(_text));
 }else {
 //BA.debugLineNum = 412;BA.debugLine="If FilterText = \"\" Then";
if ((_vvvvvvvvvvvvvvvv2).equals("")) { 
 //BA.debugLineNum = 413;BA.debugLine="lbl.Text = Text";
_lbl.setText(BA.ObjectToCharSequence(_text));
 }else {
 //BA.debugLineNum = 415;BA.debugLine="Dim x As Int = Text.ToLowerCase.IndexOf(FilterT";
_x = _text.toLowerCase().indexOf(_vvvvvvvvvvvvvvvv2);
 //BA.debugLineNum = 416;BA.debugLine="If x = -1 Or (PrefixSearch And x > 0) Then";
if (_x==-1 || (_vvvvvvvvvvvvvvvvv7 && _x>0)) { 
 //BA.debugLineNum = 417;BA.debugLine="lbl.Text = Text";
_lbl.setText(BA.ObjectToCharSequence(_text));
 //BA.debugLineNum = 418;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 422;BA.debugLine="Dim cs As CSBuilder";
_cs = new anywheresoftware.b4a.objects.CSBuilder();
 //BA.debugLineNum = 423;BA.debugLine="cs.Initialize.Append(Text.SubString2(0, x)).Col";
_cs.Initialize().Append(BA.ObjectToCharSequence(_text.substring((int) (0),_x))).Color(_vvvvvvvvvvvvvvv2).Append(BA.ObjectToCharSequence(_text.substring(_x,(int) (_x+_vvvvvvvvvvvvvvvv2.length())))).Pop();
 //BA.debugLineNum = 424;BA.debugLine="cs.Append(Text.SubString(x + FilterText.Length)";
_cs.Append(BA.ObjectToCharSequence(_text.substring((int) (_x+_vvvvvvvvvvvvvvvv2.length()))));
 //BA.debugLineNum = 426;BA.debugLine="lbl.Text = cs";
_lbl.setText(BA.ObjectToCharSequence(_cs.getObject()));
 };
 };
 //BA.debugLineNum = 448;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvv7() throws Exception{
String _sortcolumn = "";
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
com.stanks.andsokoban_full.b4xtable._b4xtablecolumn _c = null;
anywheresoftware.b4a.objects.collections.List _args = null;
int _totalcount = 0;
 //BA.debugLineNum = 259;BA.debugLine="Private Sub UpdateData";
 //BA.debugLineNum = 260;BA.debugLine="If sql1.IsInitialized = False Then Return";
if (_vvvvvv0.IsInitialized()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 262;BA.debugLine="Dim SortColumn As String";
_sortcolumn = "";
 //BA.debugLineNum = 263;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 264;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 265;BA.debugLine="sb.Append(\"SELECT rowid\")";
_sb.Append("SELECT rowid");
 //BA.debugLineNum = 266;BA.debugLine="For Each c As B4XTableColumn In VisibleColumns";
{
final anywheresoftware.b4a.BA.IterableList group6 = _vvvvvvvvvvvvv1;
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_c = (com.stanks.andsokoban_full.b4xtable._b4xtablecolumn)(group6.Get(index6));
 //BA.debugLineNum = 267;BA.debugLine="sb.Append(\",\").Append(c.SQLID)";
_sb.Append(",").Append(_c.SQLID);
 //BA.debugLineNum = 268;BA.debugLine="If c.InternalSortMode <> \"\" Then";
if ((_c.InternalSortMode).equals("") == false) { 
 //BA.debugLineNum = 269;BA.debugLine="SortColumn = \" ORDER BY \" & c.SQLID & \" \" & c.I";
_sortcolumn = " ORDER BY "+_c.SQLID+" "+_c.InternalSortMode;
 };
 }
};
 //BA.debugLineNum = 272;BA.debugLine="sb.Append(\" FROM \").Append(SQLTableName).Append(\"";
_sb.Append(" FROM ").Append(_vvvvvvvvvvvvvvvvv1).Append(" ");
 //BA.debugLineNum = 273;BA.debugLine="Dim args As List";
_args = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 274;BA.debugLine="args.Initialize";
_args.Initialize();
 //BA.debugLineNum = 275;BA.debugLine="Dim TotalCount As Int";
_totalcount = 0;
 //BA.debugLineNum = 276;BA.debugLine="If FilterText = \"\" Then";
if ((_vvvvvvvvvvvvvvvv2).equals("")) { 
 //BA.debugLineNum = 277;BA.debugLine="TotalCount = CountAll";
_totalcount = _vvvvvvvvvvvvvvv7;
 }else {
 //BA.debugLineNum = 279;BA.debugLine="For Each c As B4XTableColumn In VisibleColumns";
{
final anywheresoftware.b4a.BA.IterableList group19 = _vvvvvvvvvvvvv1;
final int groupLen19 = group19.getSize()
;int index19 = 0;
;
for (; index19 < groupLen19;index19++){
_c = (com.stanks.andsokoban_full.b4xtable._b4xtablecolumn)(group19.Get(index19));
 //BA.debugLineNum = 280;BA.debugLine="If c.Searchable Then";
if (_c.Searchable) { 
 //BA.debugLineNum = 281;BA.debugLine="If args.Size = 0 Then";
if (_args.getSize()==0) { 
 //BA.debugLineNum = 282;BA.debugLine="sb.Append(\" WHERE \")";
_sb.Append(" WHERE ");
 }else {
 //BA.debugLineNum = 284;BA.debugLine="sb.Append(\" OR \")";
_sb.Append(" OR ");
 };
 //BA.debugLineNum = 286;BA.debugLine="sb.Append(c.SQLID).Append(\" LIKE ? \")";
_sb.Append(_c.SQLID).Append(" LIKE ? ");
 //BA.debugLineNum = 287;BA.debugLine="If PrefixSearch Then";
if (_vvvvvvvvvvvvvvvvv7) { 
 //BA.debugLineNum = 288;BA.debugLine="args.Add(FilterText & \"%\")";
_args.Add((Object)(_vvvvvvvvvvvvvvvv2+"%"));
 }else {
 //BA.debugLineNum = 290;BA.debugLine="args.Add(\"%\" & FilterText & \"%\")";
_args.Add((Object)("%"+_vvvvvvvvvvvvvvvv2+"%"));
 };
 };
 }
};
 //BA.debugLineNum = 294;BA.debugLine="TotalCount = -1";
_totalcount = (int) (-1);
 };
 //BA.debugLineNum = 296;BA.debugLine="If SortColumn <> \"\" Then sb.Append(SortColumn)";
if ((_sortcolumn).equals("") == false) { 
_sb.Append(_sortcolumn);};
 //BA.debugLineNum = 298;BA.debugLine="ImplUpdateDataFromQuery (sb.ToString, args, Total";
_vvvvvvvvvv4(_sb.ToString(),_args,_totalcount);
 //BA.debugLineNum = 299;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvv0() throws Exception{
com.stanks.andsokoban_full.b4xtable._b4xtablecolumn _col = null;
 //BA.debugLineNum = 739;BA.debugLine="Private Sub UpdateSortIcon";
 //BA.debugLineNum = 740;BA.debugLine="For Each col As B4XTableColumn In Columns";
{
final anywheresoftware.b4a.BA.IterableList group1 = _vvvvvvvvvvvv0;
final int groupLen1 = group1.getSize()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_col = (com.stanks.andsokoban_full.b4xtable._b4xtablecolumn)(group1.Get(index1));
 //BA.debugLineNum = 741;BA.debugLine="If col.InternalSortMode <> \"\" Then";
if ((_col.InternalSortMode).equals("") == false) { 
 //BA.debugLineNum = 742;BA.debugLine="If lblSort.Parent <> col.Panel Then";
if ((_lblsort.getParent()).equals(_col.Panel) == false) { 
 //BA.debugLineNum = 743;BA.debugLine="lblSort.RemoveViewFromParent";
_lblsort.RemoveViewFromParent();
 //BA.debugLineNum = 744;BA.debugLine="col.Panel.AddView(lblSort, 0, 0, lblSort.Width";
_col.Panel.AddView((android.view.View)(_lblsort.getObject()),(int) (0),(int) (0),_lblsort.getWidth(),(int) (0));
 };
 //BA.debugLineNum = 746;BA.debugLine="lblSort.Top = 0";
_lblsort.setTop((int) (0));
 //BA.debugLineNum = 747;BA.debugLine="lblSort.Height = HeadersHeight";
_lblsort.setHeight(_vvvvvvvvvvvvv0);
 //BA.debugLineNum = 748;BA.debugLine="lblSort.Left = col.Panel.Width - lblSort.Width";
_lblsort.setLeft((int) (_col.Panel.getWidth()-_lblsort.getWidth()));
 //BA.debugLineNum = 749;BA.debugLine="lblSort.Visible = True";
_lblsort.setVisible(__c.True);
 //BA.debugLineNum = 750;BA.debugLine="If col.InternalSortMode = \"ASC\" Then lblSort.Te";
if ((_col.InternalSortMode).equals("ASC")) { 
_lblsort.setText(BA.ObjectToCharSequence(__c.Chr((int) (0xf0de))));}
else {
_lblsort.setText(BA.ObjectToCharSequence(__c.Chr((int) (0xf0dd))));};
 //BA.debugLineNum = 751;BA.debugLine="Return";
if (true) return "";
 };
 }
};
 //BA.debugLineNum = 754;BA.debugLine="lblSort.Visible = False";
_lblsort.setVisible(__c.False);
 //BA.debugLineNum = 755;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
