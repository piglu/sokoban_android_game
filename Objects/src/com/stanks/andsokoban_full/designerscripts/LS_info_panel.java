package com.stanks.andsokoban_full.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_info_panel{

public static void LS_480x320_1(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("pnlinfo").vw.setTop((int)(0d));
views.get("pnlinfo").vw.setWidth((int)((50d / 100 * width)));
views.get("pnlinfo").vw.setHeight((int)((54d / 100 * height)));
views.get("pnlinfo").vw.setLeft((int)(((100d / 100 * width)-(views.get("pnlinfo").vw.getWidth()))/2d));
views.get("lblrazina").vw.setLeft((int)(0d));
views.get("lblrazina").vw.setTop((int)(0d));
views.get("lblrazina").vw.setWidth((int)((views.get("pnlinfo").vw.getWidth())));
views.get("lblrazina").vw.setHeight((int)((10d / 100 * width)));
views.get("btnsound").vw.setLeft((int)((9d / 100 * width)));
views.get("btnsound").vw.setTop((int)((views.get("lblrazina").vw.getTop() + views.get("lblrazina").vw.getHeight())+(1d / 100 * height)));
views.get("btnsound").vw.setWidth((int)((10d / 100 * width)));
views.get("btnsound").vw.setHeight((int)((10d / 100 * width)));
views.get("btnrec").vw.setLeft((int)((views.get("btnsound").vw.getLeft() + views.get("btnsound").vw.getWidth())+(2d / 100 * width)));
views.get("btnrec").vw.setTop((int)((views.get("lblrazina").vw.getTop() + views.get("lblrazina").vw.getHeight())+(4d / 100 * height)));
views.get("btnrec").vw.setWidth((int)((10d / 100 * width)));
views.get("btnrec").vw.setHeight((int)((6d / 100 * width)));
views.get("btnreset").vw.setLeft((int)((views.get("btnrec").vw.getLeft() + views.get("btnrec").vw.getWidth())+(2d / 100 * width)));
views.get("btnreset").vw.setTop((int)((views.get("lblrazina").vw.getTop() + views.get("lblrazina").vw.getHeight())+(2d / 100 * height)));
views.get("btnreset").vw.setWidth((int)((9d / 100 * width)));
views.get("btnreset").vw.setHeight((int)((9d / 100 * width)));
views.get("btnprev").vw.setWidth((int)((6d / 100 * width)));
views.get("btnprev").vw.setHeight((int)((6d / 100 * width)));
views.get("btnprev").vw.setLeft((int)((views.get("btnreset").vw.getLeft() + views.get("btnreset").vw.getWidth())+(1d / 100 * width)));
views.get("btnprev").vw.setTop((int)((views.get("lblrazina").vw.getTop() + views.get("lblrazina").vw.getHeight())));
views.get("btnnext").vw.setWidth((int)((6d / 100 * width)));
views.get("btnnext").vw.setHeight((int)((6d / 100 * width)));
//BA.debugLineNum = 32;BA.debugLine="btnNext.Left = btnReset.Right + 1%x"[info_panel/480x320,scale=1]
views.get("btnnext").vw.setLeft((int)((views.get("btnreset").vw.getLeft() + views.get("btnreset").vw.getWidth())+(1d / 100 * width)));
//BA.debugLineNum = 33;BA.debugLine="btnNext.Top = btnPrev.Bottom"[info_panel/480x320,scale=1]
views.get("btnnext").vw.setTop((int)((views.get("btnprev").vw.getTop() + views.get("btnprev").vw.getHeight())));
//BA.debugLineNum = 38;BA.debugLine="btnInfo.Left = (lblRazina.Width - btnInfo.Width) / 2"[info_panel/480x320,scale=1]
views.get("btninfo").vw.setLeft((int)(((views.get("lblrazina").vw.getWidth())-(views.get("btninfo").vw.getWidth()))/2d));
//BA.debugLineNum = 39;BA.debugLine="btnInfo.Top = btnSound.Bottom + 1%y"[info_panel/480x320,scale=1]
views.get("btninfo").vw.setTop((int)((views.get("btnsound").vw.getTop() + views.get("btnsound").vw.getHeight())+(1d / 100 * height)));
//BA.debugLineNum = 40;BA.debugLine="btnInfo.Width = 7%x"[info_panel/480x320,scale=1]
views.get("btninfo").vw.setWidth((int)((7d / 100 * width)));
//BA.debugLineNum = 41;BA.debugLine="btnInfo.Height = 7%x"[info_panel/480x320,scale=1]
views.get("btninfo").vw.setHeight((int)((7d / 100 * width)));

}
public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("pnlinfo").vw.setTop((int)(0d));
views.get("pnlinfo").vw.setWidth((int)((50d / 100 * width)));
views.get("pnlinfo").vw.setHeight((int)((54d / 100 * height)));
views.get("pnlinfo").vw.setLeft((int)(((100d / 100 * width)-(views.get("pnlinfo").vw.getWidth()))/2d));
views.get("lblrazina").vw.setLeft((int)(0d));
views.get("lblrazina").vw.setTop((int)(0d));
views.get("lblrazina").vw.setWidth((int)((views.get("pnlinfo").vw.getWidth())));
views.get("lblrazina").vw.setHeight((int)((10d / 100 * width)));
views.get("btnsound").vw.setLeft((int)((9d / 100 * width)));
views.get("btnsound").vw.setTop((int)((views.get("lblrazina").vw.getTop() + views.get("lblrazina").vw.getHeight())+(1d / 100 * height)));
views.get("btnsound").vw.setWidth((int)((10d / 100 * width)));
views.get("btnsound").vw.setHeight((int)((10d / 100 * width)));
views.get("btnrec").vw.setLeft((int)((views.get("btnsound").vw.getLeft() + views.get("btnsound").vw.getWidth())+(2d / 100 * width)));
views.get("btnrec").vw.setTop((int)((views.get("lblrazina").vw.getTop() + views.get("lblrazina").vw.getHeight())+(4d / 100 * height)));
views.get("btnrec").vw.setWidth((int)((10d / 100 * width)));
views.get("btnrec").vw.setHeight((int)((6d / 100 * width)));
views.get("btnreset").vw.setLeft((int)((views.get("btnrec").vw.getLeft() + views.get("btnrec").vw.getWidth())+(2d / 100 * width)));
views.get("btnreset").vw.setTop((int)((views.get("lblrazina").vw.getTop() + views.get("lblrazina").vw.getHeight())+(2d / 100 * height)));
views.get("btnreset").vw.setWidth((int)((9d / 100 * width)));
views.get("btnreset").vw.setHeight((int)((9d / 100 * width)));
views.get("btnprev").vw.setWidth((int)((6d / 100 * width)));
views.get("btnprev").vw.setHeight((int)((6d / 100 * width)));
views.get("btnprev").vw.setLeft((int)((views.get("btnreset").vw.getLeft() + views.get("btnreset").vw.getWidth())+(1d / 100 * width)));
views.get("btnprev").vw.setTop((int)((views.get("lblrazina").vw.getTop() + views.get("lblrazina").vw.getHeight())));
views.get("btnnext").vw.setWidth((int)((6d / 100 * width)));
views.get("btnnext").vw.setHeight((int)((6d / 100 * width)));
views.get("btnnext").vw.setLeft((int)((views.get("btnreset").vw.getLeft() + views.get("btnreset").vw.getWidth())+(1d / 100 * width)));
views.get("btnnext").vw.setTop((int)((views.get("btnprev").vw.getTop() + views.get("btnprev").vw.getHeight())));
views.get("btninfo").vw.setLeft((int)(((views.get("lblrazina").vw.getWidth())-(views.get("btninfo").vw.getWidth()))/2d));
views.get("btninfo").vw.setTop((int)((views.get("btnsound").vw.getTop() + views.get("btnsound").vw.getHeight())+(1d / 100 * height)));
views.get("btninfo").vw.setWidth((int)((7d / 100 * width)));
//BA.debugLineNum = 37;BA.debugLine="btnInfo.Height = 7%x"[info_panel/General script]
views.get("btninfo").vw.setHeight((int)((7d / 100 * width)));
//BA.debugLineNum = 38;BA.debugLine="pnlInfo.Top = 0"[info_panel/General script]
views.get("pnlinfo").vw.setTop((int)(0d));
//BA.debugLineNum = 39;BA.debugLine="pnlInfo.Width = 50%x"[info_panel/General script]
views.get("pnlinfo").vw.setWidth((int)((50d / 100 * width)));
//BA.debugLineNum = 40;BA.debugLine="pnlInfo.Height = 54%y"[info_panel/General script]
views.get("pnlinfo").vw.setHeight((int)((54d / 100 * height)));
//BA.debugLineNum = 41;BA.debugLine="pnlInfo.Left = (100%x - pnlInfo.Width) / 2"[info_panel/General script]
views.get("pnlinfo").vw.setLeft((int)(((100d / 100 * width)-(views.get("pnlinfo").vw.getWidth()))/2d));
//BA.debugLineNum = 42;BA.debugLine="lblRazina.Left = 0"[info_panel/General script]
views.get("lblrazina").vw.setLeft((int)(0d));
//BA.debugLineNum = 43;BA.debugLine="lblRazina.Top = 0"[info_panel/General script]
views.get("lblrazina").vw.setTop((int)(0d));
//BA.debugLineNum = 44;BA.debugLine="lblRazina.Width = pnlInfo.Width"[info_panel/General script]
views.get("lblrazina").vw.setWidth((int)((views.get("pnlinfo").vw.getWidth())));
//BA.debugLineNum = 45;BA.debugLine="lblRazina.Height = 10%x"[info_panel/General script]
views.get("lblrazina").vw.setHeight((int)((10d / 100 * width)));
//BA.debugLineNum = 46;BA.debugLine="btnSound.Left = 2%x"[info_panel/General script]
views.get("btnsound").vw.setLeft((int)((2d / 100 * width)));
//BA.debugLineNum = 47;BA.debugLine="btnSound.Top = lblRazina.Bottom + 1%y"[info_panel/General script]
views.get("btnsound").vw.setTop((int)((views.get("lblrazina").vw.getTop() + views.get("lblrazina").vw.getHeight())+(1d / 100 * height)));
//BA.debugLineNum = 48;BA.debugLine="btnSound.Width = 10%x"[info_panel/General script]
views.get("btnsound").vw.setWidth((int)((10d / 100 * width)));
//BA.debugLineNum = 49;BA.debugLine="btnSound.Height = 10%x"[info_panel/General script]
views.get("btnsound").vw.setHeight((int)((10d / 100 * width)));
//BA.debugLineNum = 50;BA.debugLine="btnRec.Left = btnSound.Right + 2%x"[info_panel/General script]
views.get("btnrec").vw.setLeft((int)((views.get("btnsound").vw.getLeft() + views.get("btnsound").vw.getWidth())+(2d / 100 * width)));
//BA.debugLineNum = 51;BA.debugLine="btnRec.Top = lblRazina.Bottom + 4%y"[info_panel/General script]
views.get("btnrec").vw.setTop((int)((views.get("lblrazina").vw.getTop() + views.get("lblrazina").vw.getHeight())+(4d / 100 * height)));
//BA.debugLineNum = 52;BA.debugLine="btnRec.Width = 10%x"[info_panel/General script]
views.get("btnrec").vw.setWidth((int)((10d / 100 * width)));
//BA.debugLineNum = 53;BA.debugLine="btnRec.Height = 6%x"[info_panel/General script]
views.get("btnrec").vw.setHeight((int)((6d / 100 * width)));
//BA.debugLineNum = 54;BA.debugLine="btnReset.Left = btnRec.Right + 2%x"[info_panel/General script]
views.get("btnreset").vw.setLeft((int)((views.get("btnrec").vw.getLeft() + views.get("btnrec").vw.getWidth())+(2d / 100 * width)));
//BA.debugLineNum = 55;BA.debugLine="btnReset.Top = lblRazina.Bottom + 2%y"[info_panel/General script]
views.get("btnreset").vw.setTop((int)((views.get("lblrazina").vw.getTop() + views.get("lblrazina").vw.getHeight())+(2d / 100 * height)));
//BA.debugLineNum = 56;BA.debugLine="btnReset.Width = 9%x"[info_panel/General script]
views.get("btnreset").vw.setWidth((int)((9d / 100 * width)));
//BA.debugLineNum = 57;BA.debugLine="btnReset.Height = 9%x"[info_panel/General script]
views.get("btnreset").vw.setHeight((int)((9d / 100 * width)));
//BA.debugLineNum = 62;BA.debugLine="btnPrev.Width = 6%x"[info_panel/General script]
views.get("btnprev").vw.setWidth((int)((6d / 100 * width)));
//BA.debugLineNum = 63;BA.debugLine="btnPrev.Height = 6%x"[info_panel/General script]
views.get("btnprev").vw.setHeight((int)((6d / 100 * width)));
//BA.debugLineNum = 64;BA.debugLine="btnPrev.Left = btnReset.Right + 1%x"[info_panel/General script]
views.get("btnprev").vw.setLeft((int)((views.get("btnreset").vw.getLeft() + views.get("btnreset").vw.getWidth())+(1d / 100 * width)));
//BA.debugLineNum = 65;BA.debugLine="btnPrev.Top = lblRazina.Bottom' + 2%y"[info_panel/General script]
views.get("btnprev").vw.setTop((int)((views.get("lblrazina").vw.getTop() + views.get("lblrazina").vw.getHeight())));
//BA.debugLineNum = 66;BA.debugLine="btnNext.Width = 6%x"[info_panel/General script]
views.get("btnnext").vw.setWidth((int)((6d / 100 * width)));
//BA.debugLineNum = 67;BA.debugLine="btnNext.Height = 6%x"[info_panel/General script]
views.get("btnnext").vw.setHeight((int)((6d / 100 * width)));
//BA.debugLineNum = 68;BA.debugLine="btnNext.Left = btnReset.Right + 1%x"[info_panel/General script]
views.get("btnnext").vw.setLeft((int)((views.get("btnreset").vw.getLeft() + views.get("btnreset").vw.getWidth())+(1d / 100 * width)));
//BA.debugLineNum = 69;BA.debugLine="btnNext.Top = btnPrev.Bottom"[info_panel/General script]
views.get("btnnext").vw.setTop((int)((views.get("btnprev").vw.getTop() + views.get("btnprev").vw.getHeight())));
//BA.debugLineNum = 74;BA.debugLine="btnInfo.Left = (lblRazina.Width - btnInfo.Width) / 2"[info_panel/General script]
views.get("btninfo").vw.setLeft((int)(((views.get("lblrazina").vw.getWidth())-(views.get("btninfo").vw.getWidth()))/2d));
//BA.debugLineNum = 75;BA.debugLine="btnInfo.Top = btnSound.Bottom + 1%y"[info_panel/General script]
views.get("btninfo").vw.setTop((int)((views.get("btnsound").vw.getTop() + views.get("btnsound").vw.getHeight())+(1d / 100 * height)));
//BA.debugLineNum = 76;BA.debugLine="btnInfo.Width = 7%x"[info_panel/General script]
views.get("btninfo").vw.setWidth((int)((7d / 100 * width)));
//BA.debugLineNum = 77;BA.debugLine="btnInfo.Height = 7%x"[info_panel/General script]
views.get("btninfo").vw.setHeight((int)((7d / 100 * width)));

}
}