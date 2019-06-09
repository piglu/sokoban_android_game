package com.stanks.andsokoban_full.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_opcije{

public static void LS_480x320_1(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("radiobutton1").vw.setLeft((int)(0d));
views.get("radiobutton1").vw.setTop((int)(0d));
views.get("radiobutton1").vw.setWidth((int)((100d / 100 * width)));
views.get("radiobutton1").vw.setHeight((int)((5d / 100 * height)));
views.get("checkbox1").vw.setLeft((int)((10d / 100 * width)));
views.get("checkbox1").vw.setTop((int)((views.get("radiobutton1").vw.getTop() + views.get("radiobutton1").vw.getHeight())));
views.get("checkbox1").vw.setWidth((int)((100d / 100 * width)-(10d / 100 * width)));
views.get("checkbox1").vw.setHeight((int)((5d / 100 * height)));
views.get("radiobutton2").vw.setLeft((int)(0d));
views.get("radiobutton2").vw.setTop((int)((views.get("checkbox1").vw.getTop() + views.get("checkbox1").vw.getHeight())));
views.get("radiobutton2").vw.setWidth((int)((100d / 100 * width)));
views.get("radiobutton2").vw.setHeight((int)((5d / 100 * height)));
views.get("radiobutton3").vw.setLeft((int)(0d));
views.get("radiobutton3").vw.setTop((int)((views.get("radiobutton2").vw.getTop() + views.get("radiobutton2").vw.getHeight())));
views.get("radiobutton3").vw.setWidth((int)((100d / 100 * width)));
views.get("radiobutton3").vw.setHeight((int)((5d / 100 * height)));
views.get("label1").vw.setLeft((int)(0d));
views.get("label1").vw.setTop((int)((views.get("radiobutton3").vw.getTop() + views.get("radiobutton3").vw.getHeight())));
views.get("label1").vw.setWidth((int)((100d / 100 * width)));
views.get("label1").vw.setHeight((int)((5d / 100 * height)));
views.get("spnskin").vw.setLeft((int)(0d));
views.get("spnskin").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())));
views.get("spnskin").vw.setWidth((int)((90d / 100 * width)));
views.get("spnskin").vw.setHeight((int)((5d / 100 * height)));
views.get("lblskininfo").vw.setLeft((int)(0d));
views.get("lblskininfo").vw.setTop((int)((views.get("spnskin").vw.getTop() + views.get("spnskin").vw.getHeight())));
views.get("lblskininfo").vw.setWidth((int)((100d / 100 * width)));
views.get("lblskininfo").vw.setHeight((int)((15d / 100 * height)));
views.get("btndelskin").vw.setLeft((int)((views.get("spnskin").vw.getLeft() + views.get("spnskin").vw.getWidth())+(1d / 100 * width)));
views.get("btndelskin").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())));
views.get("btndelskin").vw.setWidth((int)((5d / 100 * height)));
views.get("btndelskin").vw.setHeight((int)((5d / 100 * height)));
views.get("imgpreview").vw.setTop((int)((views.get("spnskin").vw.getTop() + views.get("spnskin").vw.getHeight())+(2d / 100 * height)));
views.get("imgpreview").vw.setWidth((int)((20d / 100 * height)));
views.get("imgpreview").vw.setHeight((int)((20d / 100 * height)));
views.get("imgpreview").vw.setLeft((int)(((100d / 100 * width)-(views.get("imgpreview").vw.getWidth()))/2d));
views.get("btnskinlic").vw.setTop((int)((views.get("imgpreview").vw.getTop() + views.get("imgpreview").vw.getHeight())+(1d / 100 * height)));
views.get("btnskinlic").vw.setWidth((int)((65d / 100 * width)));
views.get("btnskinlic").vw.setHeight((int)((5d / 100 * height)));
views.get("btnskinlic").vw.setLeft((int)(((100d / 100 * width)-(views.get("btnskinlic").vw.getWidth()))/2d));
views.get("imageview1").vw.setTop((int)((views.get("lblskininfo").vw.getTop() + views.get("lblskininfo").vw.getHeight())+(2d / 100 * height)));
views.get("imageview1").vw.setWidth((int)((6d / 100 * height)));
views.get("imageview1").vw.setHeight((int)((6d / 100 * height)));
views.get("imageview1").vw.setLeft((int)((10d / 100 * width)));
views.get("imageview2").vw.setLeft((int)((views.get("imageview1").vw.getLeft() + views.get("imageview1").vw.getWidth())));
views.get("imageview2").vw.setTop((int)((views.get("lblskininfo").vw.getTop() + views.get("lblskininfo").vw.getHeight())+(2d / 100 * height)));
views.get("imageview2").vw.setWidth((int)((6d / 100 * height)));
views.get("imageview2").vw.setHeight((int)((6d / 100 * height)));
views.get("imageview3").vw.setLeft((int)((views.get("imageview2").vw.getLeft() + views.get("imageview2").vw.getWidth())));
views.get("imageview3").vw.setTop((int)((views.get("lblskininfo").vw.getTop() + views.get("lblskininfo").vw.getHeight())+(2d / 100 * height)));
views.get("imageview3").vw.setWidth((int)((6d / 100 * height)));
views.get("imageview3").vw.setHeight((int)((6d / 100 * height)));
views.get("imageview4").vw.setLeft((int)((views.get("imageview3").vw.getLeft() + views.get("imageview3").vw.getWidth())));
views.get("imageview4").vw.setTop((int)((views.get("lblskininfo").vw.getTop() + views.get("lblskininfo").vw.getHeight())+(2d / 100 * height)));
views.get("imageview4").vw.setWidth((int)((6d / 100 * height)));
views.get("imageview4").vw.setHeight((int)((6d / 100 * height)));
views.get("imageview5").vw.setLeft((int)((views.get("imageview4").vw.getLeft() + views.get("imageview4").vw.getWidth())));
views.get("imageview5").vw.setTop((int)((views.get("lblskininfo").vw.getTop() + views.get("lblskininfo").vw.getHeight())+(2d / 100 * height)));
views.get("imageview5").vw.setWidth((int)((6d / 100 * height)));
views.get("imageview5").vw.setHeight((int)((6d / 100 * height)));
views.get("imageview6").vw.setTop((int)((views.get("imageview1").vw.getTop() + views.get("imageview1").vw.getHeight())));
views.get("imageview6").vw.setWidth((int)((6d / 100 * height)));
views.get("imageview6").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 65;BA.debugLine="ImageView6.Left = 10%x'(100%x - ImageView6.Width) / 2"[opcije/480x320,scale=1]
views.get("imageview6").vw.setLeft((int)((10d / 100 * width)));
//BA.debugLineNum = 66;BA.debugLine="ImageView7.Left = ImageView6.Right"[opcije/480x320,scale=1]
views.get("imageview7").vw.setLeft((int)((views.get("imageview6").vw.getLeft() + views.get("imageview6").vw.getWidth())));
//BA.debugLineNum = 67;BA.debugLine="ImageView7.Top = ImageView2.Bottom"[opcije/480x320,scale=1]
views.get("imageview7").vw.setTop((int)((views.get("imageview2").vw.getTop() + views.get("imageview2").vw.getHeight())));
//BA.debugLineNum = 68;BA.debugLine="ImageView7.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview7").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 69;BA.debugLine="ImageView7.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview7").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 70;BA.debugLine="ImageView8.Left = ImageView7.Right"[opcije/480x320,scale=1]
views.get("imageview8").vw.setLeft((int)((views.get("imageview7").vw.getLeft() + views.get("imageview7").vw.getWidth())));
//BA.debugLineNum = 71;BA.debugLine="ImageView8.Top = ImageView3.Bottom"[opcije/480x320,scale=1]
views.get("imageview8").vw.setTop((int)((views.get("imageview3").vw.getTop() + views.get("imageview3").vw.getHeight())));
//BA.debugLineNum = 72;BA.debugLine="ImageView8.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview8").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 73;BA.debugLine="ImageView8.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview8").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 74;BA.debugLine="ImageView9.Left = ImageView8.Right"[opcije/480x320,scale=1]
views.get("imageview9").vw.setLeft((int)((views.get("imageview8").vw.getLeft() + views.get("imageview8").vw.getWidth())));
//BA.debugLineNum = 75;BA.debugLine="ImageView9.Top = ImageView4.Bottom"[opcije/480x320,scale=1]
views.get("imageview9").vw.setTop((int)((views.get("imageview4").vw.getTop() + views.get("imageview4").vw.getHeight())));
//BA.debugLineNum = 76;BA.debugLine="ImageView9.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview9").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 77;BA.debugLine="ImageView9.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview9").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 78;BA.debugLine="ImageView10.Left = ImageView9.Right"[opcije/480x320,scale=1]
views.get("imageview10").vw.setLeft((int)((views.get("imageview9").vw.getLeft() + views.get("imageview9").vw.getWidth())));
//BA.debugLineNum = 79;BA.debugLine="ImageView10.Top = ImageView5.Bottom"[opcije/480x320,scale=1]
views.get("imageview10").vw.setTop((int)((views.get("imageview5").vw.getTop() + views.get("imageview5").vw.getHeight())));
//BA.debugLineNum = 80;BA.debugLine="ImageView10.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview10").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 81;BA.debugLine="ImageView10.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview10").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 82;BA.debugLine="ImageView11.Top = ImageView6.Bottom"[opcije/480x320,scale=1]
views.get("imageview11").vw.setTop((int)((views.get("imageview6").vw.getTop() + views.get("imageview6").vw.getHeight())));
//BA.debugLineNum = 83;BA.debugLine="ImageView11.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview11").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 84;BA.debugLine="ImageView11.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview11").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 85;BA.debugLine="ImageView11.Left = 10%x'(100%x - ImageView11.Width) / 2"[opcije/480x320,scale=1]
views.get("imageview11").vw.setLeft((int)((10d / 100 * width)));
//BA.debugLineNum = 86;BA.debugLine="ImageView12.Left = ImageView11.Right"[opcije/480x320,scale=1]
views.get("imageview12").vw.setLeft((int)((views.get("imageview11").vw.getLeft() + views.get("imageview11").vw.getWidth())));
//BA.debugLineNum = 87;BA.debugLine="ImageView12.Top = ImageView6.Bottom"[opcije/480x320,scale=1]
views.get("imageview12").vw.setTop((int)((views.get("imageview6").vw.getTop() + views.get("imageview6").vw.getHeight())));
//BA.debugLineNum = 88;BA.debugLine="ImageView12.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview12").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 89;BA.debugLine="ImageView12.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview12").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 90;BA.debugLine="ImageView13.Left = ImageView12.Right"[opcije/480x320,scale=1]
views.get("imageview13").vw.setLeft((int)((views.get("imageview12").vw.getLeft() + views.get("imageview12").vw.getWidth())));
//BA.debugLineNum = 91;BA.debugLine="ImageView13.Top = ImageView8.Bottom"[opcije/480x320,scale=1]
views.get("imageview13").vw.setTop((int)((views.get("imageview8").vw.getTop() + views.get("imageview8").vw.getHeight())));
//BA.debugLineNum = 92;BA.debugLine="ImageView13.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview13").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 93;BA.debugLine="ImageView13.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview13").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 94;BA.debugLine="ImageView14.Left = ImageView13.Right"[opcije/480x320,scale=1]
views.get("imageview14").vw.setLeft((int)((views.get("imageview13").vw.getLeft() + views.get("imageview13").vw.getWidth())));
//BA.debugLineNum = 95;BA.debugLine="ImageView14.Top = ImageView9.Bottom"[opcije/480x320,scale=1]
views.get("imageview14").vw.setTop((int)((views.get("imageview9").vw.getTop() + views.get("imageview9").vw.getHeight())));
//BA.debugLineNum = 96;BA.debugLine="ImageView14.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview14").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 97;BA.debugLine="ImageView14.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview14").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 98;BA.debugLine="ImageView15.Left = ImageView14.Right"[opcije/480x320,scale=1]
views.get("imageview15").vw.setLeft((int)((views.get("imageview14").vw.getLeft() + views.get("imageview14").vw.getWidth())));
//BA.debugLineNum = 99;BA.debugLine="ImageView15.Top = ImageView10.Bottom"[opcije/480x320,scale=1]
views.get("imageview15").vw.setTop((int)((views.get("imageview10").vw.getTop() + views.get("imageview10").vw.getHeight())));
//BA.debugLineNum = 100;BA.debugLine="ImageView15.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview15").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 101;BA.debugLine="ImageView15.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview15").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 102;BA.debugLine="ImageView16.Left = ImageView15.Right"[opcije/480x320,scale=1]
views.get("imageview16").vw.setLeft((int)((views.get("imageview15").vw.getLeft() + views.get("imageview15").vw.getWidth())));
//BA.debugLineNum = 103;BA.debugLine="ImageView16.Top = ImageView10.Bottom"[opcije/480x320,scale=1]
views.get("imageview16").vw.setTop((int)((views.get("imageview10").vw.getTop() + views.get("imageview10").vw.getHeight())));
//BA.debugLineNum = 104;BA.debugLine="ImageView16.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview16").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 105;BA.debugLine="ImageView16.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview16").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 106;BA.debugLine="ImageView17.Left = ImageView16.Right"[opcije/480x320,scale=1]
views.get("imageview17").vw.setLeft((int)((views.get("imageview16").vw.getLeft() + views.get("imageview16").vw.getWidth())));
//BA.debugLineNum = 107;BA.debugLine="ImageView17.Top = ImageView10.Bottom"[opcije/480x320,scale=1]
views.get("imageview17").vw.setTop((int)((views.get("imageview10").vw.getTop() + views.get("imageview10").vw.getHeight())));
//BA.debugLineNum = 108;BA.debugLine="ImageView17.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview17").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 109;BA.debugLine="ImageView17.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview17").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 110;BA.debugLine="ImageView18.Top = ImageView11.Bottom"[opcije/480x320,scale=1]
views.get("imageview18").vw.setTop((int)((views.get("imageview11").vw.getTop() + views.get("imageview11").vw.getHeight())));
//BA.debugLineNum = 111;BA.debugLine="ImageView18.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview18").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 112;BA.debugLine="ImageView18.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview18").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 113;BA.debugLine="ImageView18.Left = 10%x'(100%x - ImageView18.Width) / 2"[opcije/480x320,scale=1]
views.get("imageview18").vw.setLeft((int)((10d / 100 * width)));
//BA.debugLineNum = 114;BA.debugLine="ImageView19.Left = ImageView18.Right"[opcije/480x320,scale=1]
views.get("imageview19").vw.setLeft((int)((views.get("imageview18").vw.getLeft() + views.get("imageview18").vw.getWidth())));
//BA.debugLineNum = 115;BA.debugLine="ImageView19.Top = ImageView12.Bottom"[opcije/480x320,scale=1]
views.get("imageview19").vw.setTop((int)((views.get("imageview12").vw.getTop() + views.get("imageview12").vw.getHeight())));
//BA.debugLineNum = 116;BA.debugLine="ImageView19.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview19").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 117;BA.debugLine="ImageView19.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview19").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 118;BA.debugLine="ImageView20.Left = ImageView19.Right"[opcije/480x320,scale=1]
views.get("imageview20").vw.setLeft((int)((views.get("imageview19").vw.getLeft() + views.get("imageview19").vw.getWidth())));
//BA.debugLineNum = 119;BA.debugLine="ImageView20.Top = ImageView13.Bottom"[opcije/480x320,scale=1]
views.get("imageview20").vw.setTop((int)((views.get("imageview13").vw.getTop() + views.get("imageview13").vw.getHeight())));
//BA.debugLineNum = 120;BA.debugLine="ImageView20.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview20").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 121;BA.debugLine="ImageView20.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview20").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 122;BA.debugLine="ImageView21.Left = ImageView20.Right"[opcije/480x320,scale=1]
views.get("imageview21").vw.setLeft((int)((views.get("imageview20").vw.getLeft() + views.get("imageview20").vw.getWidth())));
//BA.debugLineNum = 123;BA.debugLine="ImageView21.Top = ImageView14.Bottom"[opcije/480x320,scale=1]
views.get("imageview21").vw.setTop((int)((views.get("imageview14").vw.getTop() + views.get("imageview14").vw.getHeight())));
//BA.debugLineNum = 124;BA.debugLine="ImageView21.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview21").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 125;BA.debugLine="ImageView21.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview21").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 126;BA.debugLine="ImageView22.Left = ImageView21.Right"[opcije/480x320,scale=1]
views.get("imageview22").vw.setLeft((int)((views.get("imageview21").vw.getLeft() + views.get("imageview21").vw.getWidth())));
//BA.debugLineNum = 127;BA.debugLine="ImageView22.Top = ImageView15.Bottom"[opcije/480x320,scale=1]
views.get("imageview22").vw.setTop((int)((views.get("imageview15").vw.getTop() + views.get("imageview15").vw.getHeight())));
//BA.debugLineNum = 128;BA.debugLine="ImageView22.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview22").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 129;BA.debugLine="ImageView22.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview22").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 130;BA.debugLine="ImageView23.Left = ImageView22.Right"[opcije/480x320,scale=1]
views.get("imageview23").vw.setLeft((int)((views.get("imageview22").vw.getLeft() + views.get("imageview22").vw.getWidth())));
//BA.debugLineNum = 131;BA.debugLine="ImageView23.Top = ImageView16.Bottom"[opcije/480x320,scale=1]
views.get("imageview23").vw.setTop((int)((views.get("imageview16").vw.getTop() + views.get("imageview16").vw.getHeight())));
//BA.debugLineNum = 132;BA.debugLine="ImageView23.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview23").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 133;BA.debugLine="ImageView23.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview23").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 134;BA.debugLine="ImageView24.Left = ImageView23.Right"[opcije/480x320,scale=1]
views.get("imageview24").vw.setLeft((int)((views.get("imageview23").vw.getLeft() + views.get("imageview23").vw.getWidth())));
//BA.debugLineNum = 135;BA.debugLine="ImageView24.Top = ImageView17.Bottom"[opcije/480x320,scale=1]
views.get("imageview24").vw.setTop((int)((views.get("imageview17").vw.getTop() + views.get("imageview17").vw.getHeight())));
//BA.debugLineNum = 136;BA.debugLine="ImageView24.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview24").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 137;BA.debugLine="ImageView24.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview24").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 138;BA.debugLine="ImageView25.Top = ImageView18.Bottom"[opcije/480x320,scale=1]
views.get("imageview25").vw.setTop((int)((views.get("imageview18").vw.getTop() + views.get("imageview18").vw.getHeight())));
//BA.debugLineNum = 139;BA.debugLine="ImageView25.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview25").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 140;BA.debugLine="ImageView25.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview25").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 141;BA.debugLine="ImageView25.Left = 10%x'(100%x - ImageView25.Width) / 2"[opcije/480x320,scale=1]
views.get("imageview25").vw.setLeft((int)((10d / 100 * width)));
//BA.debugLineNum = 142;BA.debugLine="ImageView26.Left = ImageView25.Right"[opcije/480x320,scale=1]
views.get("imageview26").vw.setLeft((int)((views.get("imageview25").vw.getLeft() + views.get("imageview25").vw.getWidth())));
//BA.debugLineNum = 143;BA.debugLine="ImageView26.Top = ImageView19.Bottom"[opcije/480x320,scale=1]
views.get("imageview26").vw.setTop((int)((views.get("imageview19").vw.getTop() + views.get("imageview19").vw.getHeight())));
//BA.debugLineNum = 144;BA.debugLine="ImageView26.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview26").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 145;BA.debugLine="ImageView26.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview26").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 146;BA.debugLine="ImageView27.Left = ImageView26.Right"[opcije/480x320,scale=1]
views.get("imageview27").vw.setLeft((int)((views.get("imageview26").vw.getLeft() + views.get("imageview26").vw.getWidth())));
//BA.debugLineNum = 147;BA.debugLine="ImageView27.Top = ImageView20.Bottom"[opcije/480x320,scale=1]
views.get("imageview27").vw.setTop((int)((views.get("imageview20").vw.getTop() + views.get("imageview20").vw.getHeight())));
//BA.debugLineNum = 148;BA.debugLine="ImageView27.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview27").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 149;BA.debugLine="ImageView27.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview27").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 150;BA.debugLine="ImageView28.Left = ImageView27.Right"[opcije/480x320,scale=1]
views.get("imageview28").vw.setLeft((int)((views.get("imageview27").vw.getLeft() + views.get("imageview27").vw.getWidth())));
//BA.debugLineNum = 151;BA.debugLine="ImageView28.Top = ImageView21.Bottom"[opcije/480x320,scale=1]
views.get("imageview28").vw.setTop((int)((views.get("imageview21").vw.getTop() + views.get("imageview21").vw.getHeight())));
//BA.debugLineNum = 152;BA.debugLine="ImageView28.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview28").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 153;BA.debugLine="ImageView28.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview28").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 154;BA.debugLine="ImageView29.Left = ImageView28.Right"[opcije/480x320,scale=1]
views.get("imageview29").vw.setLeft((int)((views.get("imageview28").vw.getLeft() + views.get("imageview28").vw.getWidth())));
//BA.debugLineNum = 155;BA.debugLine="ImageView29.Top = ImageView22.Bottom"[opcije/480x320,scale=1]
views.get("imageview29").vw.setTop((int)((views.get("imageview22").vw.getTop() + views.get("imageview22").vw.getHeight())));
//BA.debugLineNum = 156;BA.debugLine="ImageView29.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview29").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 157;BA.debugLine="ImageView29.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview29").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 158;BA.debugLine="ImageView30.Left = ImageView29.Right"[opcije/480x320,scale=1]
views.get("imageview30").vw.setLeft((int)((views.get("imageview29").vw.getLeft() + views.get("imageview29").vw.getWidth())));
//BA.debugLineNum = 159;BA.debugLine="ImageView30.Top = ImageView23.Bottom"[opcije/480x320,scale=1]
views.get("imageview30").vw.setTop((int)((views.get("imageview23").vw.getTop() + views.get("imageview23").vw.getHeight())));
//BA.debugLineNum = 160;BA.debugLine="ImageView30.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview30").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 161;BA.debugLine="ImageView30.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview30").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 162;BA.debugLine="ImageView31.Left = ImageView30.Right"[opcije/480x320,scale=1]
views.get("imageview31").vw.setLeft((int)((views.get("imageview30").vw.getLeft() + views.get("imageview30").vw.getWidth())));
//BA.debugLineNum = 163;BA.debugLine="ImageView31.Top = ImageView24.Bottom"[opcije/480x320,scale=1]
views.get("imageview31").vw.setTop((int)((views.get("imageview24").vw.getTop() + views.get("imageview24").vw.getHeight())));
//BA.debugLineNum = 164;BA.debugLine="ImageView31.Width = 6%y"[opcije/480x320,scale=1]
views.get("imageview31").vw.setWidth((int)((6d / 100 * height)));
//BA.debugLineNum = 165;BA.debugLine="ImageView31.Height = 6%y"[opcije/480x320,scale=1]
views.get("imageview31").vw.setHeight((int)((6d / 100 * height)));
//BA.debugLineNum = 166;BA.debugLine="Label2.Left = 0"[opcije/480x320,scale=1]
views.get("label2").vw.setLeft((int)(0d));
//BA.debugLineNum = 168;BA.debugLine="Label2.Top = btnSkinLic.Bottom + 1%y"[opcije/480x320,scale=1]
views.get("label2").vw.setTop((int)((views.get("btnskinlic").vw.getTop() + views.get("btnskinlic").vw.getHeight())+(1d / 100 * height)));
//BA.debugLineNum = 169;BA.debugLine="Label2.Width = 100%x"[opcije/480x320,scale=1]
views.get("label2").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 170;BA.debugLine="Label2.Height = 5%y"[opcije/480x320,scale=1]
views.get("label2").vw.setHeight((int)((5d / 100 * height)));

}
public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);

}
}