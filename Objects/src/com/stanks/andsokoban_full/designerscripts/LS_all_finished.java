package com.stanks.andsokoban_full.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_all_finished{

public static void LS_480x320_1(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="Label1.Top = 0"[all_finished/480x320,scale=1]
views.get("label1").vw.setTop((int)(0d));
//BA.debugLineNum = 3;BA.debugLine="Label1.Width = 100%x"[all_finished/480x320,scale=1]
views.get("label1").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 4;BA.debugLine="Label1.Height = 10%x"[all_finished/480x320,scale=1]
views.get("label1").vw.setHeight((int)((10d / 100 * width)));
//BA.debugLineNum = 5;BA.debugLine="Label1.Left = 0"[all_finished/480x320,scale=1]
views.get("label1").vw.setLeft((int)(0d));
//BA.debugLineNum = 6;BA.debugLine="ImageView1.Width = 20%x"[all_finished/480x320,scale=1]
views.get("imageview1").vw.setWidth((int)((20d / 100 * width)));
//BA.debugLineNum = 7;BA.debugLine="ImageView1.Left = (100%x - ImageView1.Width) / 2"[all_finished/480x320,scale=1]
views.get("imageview1").vw.setLeft((int)(((100d / 100 * width)-(views.get("imageview1").vw.getWidth()))/2d));
//BA.debugLineNum = 8;BA.debugLine="ImageView1.Top = Label1.Bottom"[all_finished/480x320,scale=1]
views.get("imageview1").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())));
//BA.debugLineNum = 9;BA.debugLine="ImageView1.Height = 20%x"[all_finished/480x320,scale=1]
views.get("imageview1").vw.setHeight((int)((20d / 100 * width)));
//BA.debugLineNum = 10;BA.debugLine="btnOK.Width = 10%x"[all_finished/480x320,scale=1]
views.get("btnok").vw.setWidth((int)((10d / 100 * width)));
//BA.debugLineNum = 11;BA.debugLine="btnOK.Height = 10%x"[all_finished/480x320,scale=1]
views.get("btnok").vw.setHeight((int)((10d / 100 * width)));
//BA.debugLineNum = 12;BA.debugLine="btnOK.Left = (100%x - btnOK.Width) / 2"[all_finished/480x320,scale=1]
views.get("btnok").vw.setLeft((int)(((100d / 100 * width)-(views.get("btnok").vw.getWidth()))/2d));
//BA.debugLineNum = 13;BA.debugLine="btnOK.Top = ImageView1.Bottom + 1%y"[all_finished/480x320,scale=1]
views.get("btnok").vw.setTop((int)((views.get("imageview1").vw.getTop() + views.get("imageview1").vw.getHeight())+(1d / 100 * height)));

}
public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("label1").vw.setTop((int)(0d));
views.get("label1").vw.setWidth((int)((100d / 100 * width)));
views.get("label1").vw.setHeight((int)((10d / 100 * width)));
views.get("label1").vw.setLeft((int)(0d));
views.get("imageview1").vw.setWidth((int)((20d / 100 * width)));
views.get("imageview1").vw.setLeft((int)(((100d / 100 * width)-(views.get("imageview1").vw.getWidth()))/2d));
views.get("imageview1").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())));
views.get("imageview1").vw.setHeight((int)((20d / 100 * width)));
views.get("btnok").vw.setWidth((int)((10d / 100 * width)));
views.get("btnok").vw.setHeight((int)((10d / 100 * width)));
views.get("btnok").vw.setLeft((int)(((100d / 100 * width)-(views.get("btnok").vw.getWidth()))/2d));
//BA.debugLineNum = 14;BA.debugLine="btnOK.Top = ImageView1.Bottom + 1%y"[all_finished/General script]
views.get("btnok").vw.setTop((int)((views.get("imageview1").vw.getTop() + views.get("imageview1").vw.getHeight())+(1d / 100 * height)));

}
}