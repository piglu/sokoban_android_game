package com.stanks.andsokoban_full;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class opcije extends Activity implements B4AActivity{
	public static opcije mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "com.stanks.andsokoban_full", "com.stanks.andsokoban_full.opcije");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (opcije).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "com.stanks.andsokoban_full", "com.stanks.andsokoban_full.opcije");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.stanks.andsokoban_full.opcije", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (opcije) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (opcije) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return opcije.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (opcije) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            opcije mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (opcije) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _checkbox1 = null;
public flm.b4a.archiver.ArchiverForB4A _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = null;
public static boolean _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = false;
public static boolean _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = false;
public static boolean _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = false;
public static boolean _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = false;
public static String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = "";
public anywheresoftware.b4a.objects.SpinnerWrapper _spnskin = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgpreview = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnskinlic = null;
public anywheresoftware.b4a.objects.collections.Map _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblskininfo = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btndelskin = null;
public static String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = "";
public static String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = "";
public static String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = "";
public static String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = "";
public static String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = "";
public static String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = "";
public static String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = "";
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview2 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview3 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview4 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview5 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview6 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview7 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview8 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview9 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview10 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview11 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview12 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview13 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview14 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview15 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview16 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview17 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview18 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview19 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview20 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview21 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview22 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview23 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview24 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview25 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview26 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview27 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview28 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview29 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview30 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview31 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper[] _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _vvvvvvvvvvvvvvvvvvvvvvvv2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radiobutton1 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radiobutton2 = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radiobutton3 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel3 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel4 = null;
public b4a.example.dateutils _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = null;
public com.stanks.andsokoban_full.main _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = null;
public com.stanks.andsokoban_full.starter _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = null;
public com.stanks.andsokoban_full.play _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = null;
public com.stanks.andsokoban_full.video _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = null;
public com.stanks.andsokoban_full.rijesenja _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
String _f = "";
anywheresoftware.b4a.objects.collections.List _l = null;
int _i = 0;
String _s = "";
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
String _name = "";
String _author = "";
String _desc = "";
String _web = "";
String _email = "";
 //BA.debugLineNum = 81;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 87;BA.debugLine="sv.Initialize(100%y)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvv2.Initialize(mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 88;BA.debugLine="Activity.AddView(sv, 0, 0, 100%x, 100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvv2.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 89;BA.debugLine="sv.Panel.LoadLayout(\"opcije3\")";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvv2.getPanel().LoadLayout("opcije3",mostCurrent.activityBA);
 //BA.debugLineNum = 90;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 91;BA.debugLine="cd.Initialize(Colors.ARGB(255, 222, 184, 135), 0)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (222),(int) (184),(int) (135)),(int) (0));
 //BA.debugLineNum = 92;BA.debugLine="sv.Background = cd";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvv2.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 110;BA.debugLine="ivs = Array As ImageView (ImageView1, ImageView2,";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.ImageViewWrapper[]{mostCurrent._imageview1,mostCurrent._imageview2,mostCurrent._imageview3,mostCurrent._imageview4,mostCurrent._imageview5,mostCurrent._imageview6,mostCurrent._imageview7,mostCurrent._imageview8,mostCurrent._imageview9,mostCurrent._imageview10,mostCurrent._imageview11,mostCurrent._imageview12,mostCurrent._imageview13,mostCurrent._imageview14,mostCurrent._imageview15,mostCurrent._imageview16,mostCurrent._imageview17,mostCurrent._imageview18,mostCurrent._imageview19,mostCurrent._imageview20,mostCurrent._imageview21,mostCurrent._imageview22,mostCurrent._imageview23,mostCurrent._imageview24,mostCurrent._imageview25,mostCurrent._imageview26,mostCurrent._imageview27,mostCurrent._imageview28,mostCurrent._imageview29,mostCurrent._imageview30,mostCurrent._imageview31};
 //BA.debugLineNum = 115;BA.debugLine="If File.Exists(Starter.SourceFolder, \"skins.zip\")";
if (anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1,"skins.zip")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 116;BA.debugLine="File.Copy(File.DirAssets, \"skins.zip\", Starter.S";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"skins.zip",mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1,"skins.zip");
 //BA.debugLineNum = 117;BA.debugLine="RaspakirajSkinoveIzArhive";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5();
 };
 //BA.debugLineNum = 125;BA.debugLine="Dim f As String";
_f = "";
 //BA.debugLineNum = 126;BA.debugLine="If File.Exists(Starter.SourceFolder, \"/skins/Neon";
if (anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1,"/skins/Neon")) { 
 //BA.debugLineNum = 127;BA.debugLine="Dim l As List = File.ListFiles(Starter.SourceFol";
_l = new anywheresoftware.b4a.objects.collections.List();
_l = anywheresoftware.b4a.keywords.Common.File.ListFiles(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+"/skins/Neon");
 //BA.debugLineNum = 128;BA.debugLine="For i = 0 To l.Size - 1";
{
final int step15 = 1;
final int limit15 = (int) (_l.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit15 ;_i = _i + step15 ) {
 //BA.debugLineNum = 129;BA.debugLine="f = l.Get(i)";
_f = BA.ObjectToString(_l.Get(_i));
 //BA.debugLineNum = 130;BA.debugLine="File.Delete(Starter.SourceFolder & \"/skins/Neon";
anywheresoftware.b4a.keywords.Common.File.Delete(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+"/skins/Neon/",_f);
 }
};
 //BA.debugLineNum = 132;BA.debugLine="File.Delete(Starter.SourceFolder & \"/skins/\", \"N";
anywheresoftware.b4a.keywords.Common.File.Delete(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+"/skins/","Neon");
 };
 //BA.debugLineNum = 136;BA.debugLine="Log(Starter.SourceFolder & \"/skins\")";
anywheresoftware.b4a.keywords.Common.LogImpl("37077943",mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+"/skins",0);
 //BA.debugLineNum = 137;BA.debugLine="Dim l As List = ProcitajSveFoldereUSkinDir(Starte";
_l = new anywheresoftware.b4a.objects.collections.List();
_l = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+"/skins");
 //BA.debugLineNum = 138;BA.debugLine="For i = 0 To l.Size - 1";
{
final int step23 = 1;
final int limit23 = (int) (_l.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit23 ;_i = _i + step23 ) {
 //BA.debugLineNum = 139;BA.debugLine="spnSkin.Add(l.Get(i))";
mostCurrent._spnskin.Add(BA.ObjectToString(_l.Get(_i)));
 }
};
 //BA.debugLineNum = 142;BA.debugLine="mOpcije = File.ReadMap(Starter.SourceFolder, \"opc";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = anywheresoftware.b4a.keywords.Common.File.ReadMap(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1,"opcije");
 //BA.debugLineNum = 143;BA.debugLine="cb = mOpcije.Get(\"cb\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = BA.ObjectToBoolean(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Get((Object)("cb")));
 //BA.debugLineNum = 144;BA.debugLine="rb2 = mOpcije.Get(\"rb2\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = BA.ObjectToBoolean(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Get((Object)("rb2")));
 //BA.debugLineNum = 145;BA.debugLine="rb3 = mOpcije.Get(\"rb3\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = BA.ObjectToBoolean(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Get((Object)("rb3")));
 //BA.debugLineNum = 146;BA.debugLine="rb4 = mOpcije.Get(\"rb4\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = BA.ObjectToBoolean(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Get((Object)("rb4")));
 //BA.debugLineNum = 147;BA.debugLine="spn = mOpcije.Get(\"skin\")";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Get((Object)("skin")));
 //BA.debugLineNum = 148;BA.debugLine="If cb Then";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 149;BA.debugLine="CheckBox1.Checked = True";
mostCurrent._checkbox1.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 151;BA.debugLine="CheckBox1.Checked = False";
mostCurrent._checkbox1.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 153;BA.debugLine="If rb2 Then";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2) { 
 //BA.debugLineNum = 154;BA.debugLine="RadioButton1.Checked = True";
mostCurrent._radiobutton1.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 156;BA.debugLine="RadioButton1.Checked = False";
mostCurrent._radiobutton1.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 158;BA.debugLine="spnSkin.SelectedIndex = spnSkin.IndexOf(spn)";
mostCurrent._spnskin.setSelectedIndex(mostCurrent._spnskin.IndexOf(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1));
 //BA.debugLineNum = 160;BA.debugLine="If rb3 Then";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3) { 
 //BA.debugLineNum = 161;BA.debugLine="RadioButton2.Checked = True";
mostCurrent._radiobutton2.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 163;BA.debugLine="RadioButton2.Checked = False";
mostCurrent._radiobutton2.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 166;BA.debugLine="If rb4 Then";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4) { 
 //BA.debugLineNum = 167;BA.debugLine="RadioButton3.Checked = True";
mostCurrent._radiobutton3.setChecked(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 169;BA.debugLine="RadioButton3.Checked = False";
mostCurrent._radiobutton3.setChecked(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 171;BA.debugLine="Dim s As String = spnSkin.SelectedItem";
_s = mostCurrent._spnskin.getSelectedItem();
 //BA.debugLineNum = 173;BA.debugLine="If s.StartsWith(\"1\") Then";
if (_s.startsWith("1")) { 
 //BA.debugLineNum = 174;BA.debugLine="Panel3.Visible = True";
mostCurrent._panel3.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 175;BA.debugLine="Panel4.Visible = False";
mostCurrent._panel4.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 176;BA.debugLine="Panel3.BringToFront";
mostCurrent._panel3.BringToFront();
 //BA.debugLineNum = 177;BA.debugLine="Dim bmp As Bitmap = LoadBitmap(Starter.SourceFol";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp = anywheresoftware.b4a.keywords.Common.LoadBitmap(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+"/skins"+"/"+_s,_s.substring((int) (1))+"-preview-simple.png");
 //BA.debugLineNum = 178;BA.debugLine="imgPreview.Bitmap = bmp";
mostCurrent._imgpreview.setBitmap((android.graphics.Bitmap)(_bmp.getObject()));
 //BA.debugLineNum = 179;BA.debugLine="imgPreview.Width = 224dip'DipToCurrent(bmp.Width";
mostCurrent._imgpreview.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (224)));
 //BA.debugLineNum = 180;BA.debugLine="imgPreview.Height = 160dip'DipToCurrent(bmp.Heig";
mostCurrent._imgpreview.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (160)));
 //BA.debugLineNum = 181;BA.debugLine="imgPreview.Left = (100%x - imgPreview.Width) / 2";
mostCurrent._imgpreview.setLeft((int) ((anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-mostCurrent._imgpreview.getWidth())/(double)2));
 }else {
 //BA.debugLineNum = 183;BA.debugLine="Dim name, author, desc, web, email As String";
_name = "";
_author = "";
_desc = "";
_web = "";
_email = "";
 //BA.debugLineNum = 184;BA.debugLine="Panel3.Visible = False";
mostCurrent._panel3.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 185;BA.debugLine="Panel4.Visible = True";
mostCurrent._panel4.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 186;BA.debugLine="Panel4.BringToFront";
mostCurrent._panel4.BringToFront();
 //BA.debugLineNum = 187;BA.debugLine="sv.Panel.Height = Panel1.Height + Panel2.Height";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvv2.getPanel().setHeight((int) (mostCurrent._panel1.getHeight()+mostCurrent._panel2.getHeight()+mostCurrent._panel4.getHeight()));
 //BA.debugLineNum = 188;BA.debugLine="name = mOpcije.Get(\"name\")";
_name = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Get((Object)("name")));
 //BA.debugLineNum = 189;BA.debugLine="author = mOpcije.Get(\"author\")";
_author = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Get((Object)("author")));
 //BA.debugLineNum = 190;BA.debugLine="desc = mOpcije.Get(\"desc\")";
_desc = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Get((Object)("desc")));
 //BA.debugLineNum = 191;BA.debugLine="web = mOpcije.Get(\"web\")";
_web = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Get((Object)("web")));
 //BA.debugLineNum = 192;BA.debugLine="email = mOpcije.Get(\"email\")";
_email = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Get((Object)("email")));
 //BA.debugLineNum = 193;BA.debugLine="lblSkinInfo.Text = \"Name: \" & name & CRLF & \"Aut";
mostCurrent._lblskininfo.setText(BA.ObjectToCharSequence("Name: "+_name+anywheresoftware.b4a.keywords.Common.CRLF+"Author: "+_author+anywheresoftware.b4a.keywords.Common.CRLF+"Description: "+_desc+anywheresoftware.b4a.keywords.Common.CRLF+"Web: "+_web+anywheresoftware.b4a.keywords.Common.CRLF+"Email: "+_email));
 //BA.debugLineNum = 194;BA.debugLine="zid1 = mOpcije.Get(\"zid\")";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Get((Object)("zid")));
 //BA.debugLineNum = 195;BA.debugLine="kutija1 = mOpcije.Get(\"kutija\")";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Get((Object)("kutija")));
 //BA.debugLineNum = 196;BA.debugLine="kutnamj1 = mOpcije.get(\"kutnamj\")";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Get((Object)("kutnamj")));
 //BA.debugLineNum = 197;BA.debugLine="mjzakut1 = mOpcije.get(\"mjzakut\")";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Get((Object)("mjzakut")));
 //BA.debugLineNum = 198;BA.debugLine="pod1 = mOpcije.get(\"pod\")";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Get((Object)("pod")));
 //BA.debugLineNum = 199;BA.debugLine="igr1 = mOpcije.get(\"igr\")";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Get((Object)("igr")));
 //BA.debugLineNum = 200;BA.debugLine="igrnamj1 = mOpcije.get(\"igrnamj\")";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Get((Object)("igrnamj")));
 //BA.debugLineNum = 206;BA.debugLine="SloziPreview(\"/skins/\" & spn & \"/\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5("/skins/"+mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1+"/");
 };
 //BA.debugLineNum = 208;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 216;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 217;BA.debugLine="If UserClosed Then";
if (_userclosed) { 
 //BA.debugLineNum = 218;BA.debugLine="If mOpcije.IsInitialized Then";
if (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.IsInitialized()) { 
 //BA.debugLineNum = 219;BA.debugLine="mOpcije.Put(\"cb\", cb)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("cb"),(Object)(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1));
 //BA.debugLineNum = 220;BA.debugLine="mOpcije.Put(\"rb2\", rb2)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("rb2"),(Object)(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2));
 //BA.debugLineNum = 221;BA.debugLine="mOpcije.Put(\"rb3\", rb3)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("rb3"),(Object)(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3));
 //BA.debugLineNum = 222;BA.debugLine="mOpcije.Put(\"rb4\", rb4)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("rb4"),(Object)(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4));
 //BA.debugLineNum = 223;BA.debugLine="mOpcije.Put(\"skin\", spn)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("skin"),(Object)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1));
 //BA.debugLineNum = 224;BA.debugLine="File.Delete(Starter.SourceFolder, \"opcije\")";
anywheresoftware.b4a.keywords.Common.File.Delete(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1,"opcije");
 //BA.debugLineNum = 225;BA.debugLine="File.WriteMap(Starter.SourceFolder, \"opcije\", m";
anywheresoftware.b4a.keywords.Common.File.WriteMap(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1,"opcije",mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0);
 };
 };
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
anywheresoftware.b4a.phone.Phone _ph = null;
 //BA.debugLineNum = 210;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 211;BA.debugLine="Dim ph As Phone";
_ph = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 213;BA.debugLine="ph.SetScreenOrientation(1)";
_ph.SetScreenOrientation(processBA,(int) (1));
 //BA.debugLineNum = 214;BA.debugLine="End Sub";
return "";
}
public static String  _btndelskin_click() throws Exception{
String _s = "";
anywheresoftware.b4a.objects.collections.List _l = null;
String _f = "";
int _res = 0;
int _i = 0;
 //BA.debugLineNum = 488;BA.debugLine="Sub btnDelSkin_Click";
 //BA.debugLineNum = 489;BA.debugLine="Dim s As String = spnSkin.SelectedItem";
_s = mostCurrent._spnskin.getSelectedItem();
 //BA.debugLineNum = 490;BA.debugLine="Dim l As List = File.ListFiles(Starter.SourceFold";
_l = new anywheresoftware.b4a.objects.collections.List();
_l = anywheresoftware.b4a.keywords.Common.File.ListFiles(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+"/skins/"+_s);
 //BA.debugLineNum = 491;BA.debugLine="Dim f As String";
_f = "";
 //BA.debugLineNum = 493;BA.debugLine="Dim res As Int = Msgbox2(\"Do you really want to d";
_res = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Do you really want to delete this skin?"),BA.ObjectToCharSequence("Question"),"OK","Cancel","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"upitnik.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 495;BA.debugLine="If res = DialogResponse.POSITIVE Then";
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 496;BA.debugLine="For i = 0 To l.Size - 1";
{
final int step6 = 1;
final int limit6 = (int) (_l.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
 //BA.debugLineNum = 497;BA.debugLine="f = l.Get(i)";
_f = BA.ObjectToString(_l.Get(_i));
 //BA.debugLineNum = 498;BA.debugLine="File.Delete(Starter.SourceFolder & \"/skins/\" &";
anywheresoftware.b4a.keywords.Common.File.Delete(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+"/skins/"+_s+"/",_f);
 }
};
 //BA.debugLineNum = 500;BA.debugLine="File.Delete(Starter.SourceFolder & \"/skins/\", s)";
anywheresoftware.b4a.keywords.Common.File.Delete(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+"/skins/",_s);
 //BA.debugLineNum = 501;BA.debugLine="lblSkinInfo.Text = \"\"";
mostCurrent._lblskininfo.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 502;BA.debugLine="Dim l As List = ProcitajSveFoldereUSkinDir(Start";
_l = new anywheresoftware.b4a.objects.collections.List();
_l = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+"/skins");
 //BA.debugLineNum = 503;BA.debugLine="spnSkin.Clear";
mostCurrent._spnskin.Clear();
 //BA.debugLineNum = 504;BA.debugLine="For i = 0 To l.Size - 1";
{
final int step14 = 1;
final int limit14 = (int) (_l.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit14 ;_i = _i + step14 ) {
 //BA.debugLineNum = 505;BA.debugLine="spnSkin.Add(l.Get(i))";
mostCurrent._spnskin.Add(BA.ObjectToString(_l.Get(_i)));
 }
};
 };
 //BA.debugLineNum = 508;BA.debugLine="End Sub";
return "";
}
public static String  _btnskinlic_click() throws Exception{
String _s = "";
 //BA.debugLineNum = 482;BA.debugLine="Sub btnSkinLic_Click";
 //BA.debugLineNum = 483;BA.debugLine="Dim s As String = File.ReadString(Starter.SourceF";
_s = anywheresoftware.b4a.keywords.Common.File.ReadString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+"/skins/","LICENCE.txt");
 //BA.debugLineNum = 485;BA.debugLine="Msgbox(s, \"Skins license\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence(_s),BA.ObjectToCharSequence("Skins license"),mostCurrent.activityBA);
 //BA.debugLineNum = 486;BA.debugLine="End Sub";
return "";
}
public static String  _cb_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 249;BA.debugLine="Sub cb_CheckedChange(Checked As Boolean)";
 //BA.debugLineNum = 250;BA.debugLine="Log(\"cb: \" & Checked)";
anywheresoftware.b4a.keywords.Common.LogImpl("37405569","cb: "+BA.ObjectToString(_checked),0);
 //BA.debugLineNum = 251;BA.debugLine="cb = Checked";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = _checked;
 //BA.debugLineNum = 252;BA.debugLine="mOpcije.Put(\"cb\", cb)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("cb"),(Object)(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1));
 //BA.debugLineNum = 253;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 14;BA.debugLine="Private CheckBox1 As CheckBox";
mostCurrent._checkbox1 = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Dim arch As Archiver";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = new flm.b4a.archiver.ArchiverForB4A();
 //BA.debugLineNum = 25;BA.debugLine="Dim cb As Boolean";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = false;
 //BA.debugLineNum = 27;BA.debugLine="Dim rb2, rb3, rb4 As Boolean";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = false;
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = false;
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = false;
 //BA.debugLineNum = 28;BA.debugLine="Dim spn As String";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = "";
 //BA.debugLineNum = 29;BA.debugLine="Private spnSkin As Spinner";
mostCurrent._spnskin = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private imgPreview As ImageView";
mostCurrent._imgpreview = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private btnSkinLic As Button";
mostCurrent._btnskinlic = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Dim mOpcije As Map";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 33;BA.debugLine="Private lblSkinInfo As Label";
mostCurrent._lblskininfo = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private Label2 As Label";
mostCurrent._label2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private btnDelSkin As Button";
mostCurrent._btndelskin = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Dim zid1, kutija1, kutnamj1, mjzakut1, pod1, igr1";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = "";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = "";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = "";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = "";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = "";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = "";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = "";
 //BA.debugLineNum = 37;BA.debugLine="Private ImageView1 As ImageView";
mostCurrent._imageview1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private ImageView2 As ImageView";
mostCurrent._imageview2 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private ImageView3 As ImageView";
mostCurrent._imageview3 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private ImageView4 As ImageView";
mostCurrent._imageview4 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private ImageView5 As ImageView";
mostCurrent._imageview5 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private ImageView6 As ImageView";
mostCurrent._imageview6 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private ImageView7 As ImageView";
mostCurrent._imageview7 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private ImageView8 As ImageView";
mostCurrent._imageview8 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private ImageView9 As ImageView";
mostCurrent._imageview9 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private ImageView10 As ImageView";
mostCurrent._imageview10 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private ImageView11 As ImageView";
mostCurrent._imageview11 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private ImageView12 As ImageView";
mostCurrent._imageview12 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private ImageView13 As ImageView";
mostCurrent._imageview13 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 50;BA.debugLine="Private ImageView14 As ImageView";
mostCurrent._imageview14 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private ImageView15 As ImageView";
mostCurrent._imageview15 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private ImageView16 As ImageView";
mostCurrent._imageview16 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private ImageView17 As ImageView";
mostCurrent._imageview17 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Private ImageView18 As ImageView";
mostCurrent._imageview18 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 55;BA.debugLine="Private ImageView19 As ImageView";
mostCurrent._imageview19 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Private ImageView20 As ImageView";
mostCurrent._imageview20 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Private ImageView21 As ImageView";
mostCurrent._imageview21 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 58;BA.debugLine="Private ImageView22 As ImageView";
mostCurrent._imageview22 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 59;BA.debugLine="Private ImageView23 As ImageView";
mostCurrent._imageview23 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private ImageView24 As ImageView";
mostCurrent._imageview24 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Private ImageView25 As ImageView";
mostCurrent._imageview25 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 62;BA.debugLine="Private ImageView26 As ImageView";
mostCurrent._imageview26 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 63;BA.debugLine="Private ImageView27 As ImageView";
mostCurrent._imageview27 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 64;BA.debugLine="Private ImageView28 As ImageView";
mostCurrent._imageview28 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 65;BA.debugLine="Private ImageView29 As ImageView";
mostCurrent._imageview29 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 66;BA.debugLine="Private ImageView30 As ImageView";
mostCurrent._imageview30 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 67;BA.debugLine="Private ImageView31 As ImageView";
mostCurrent._imageview31 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 68;BA.debugLine="Dim ivs(31) As ImageView";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.ImageViewWrapper[(int) (31)];
{
int d0 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.length;
for (int i0 = 0;i0 < d0;i0++) {
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6[i0] = new anywheresoftware.b4a.objects.ImageViewWrapper();
}
}
;
 //BA.debugLineNum = 69;BA.debugLine="Dim sv As ScrollView";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvv2 = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 70;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 71;BA.debugLine="Private RadioButton1 As RadioButton";
mostCurrent._radiobutton1 = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 72;BA.debugLine="Private RadioButton2 As RadioButton";
mostCurrent._radiobutton2 = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 73;BA.debugLine="Private RadioButton3 As RadioButton";
mostCurrent._radiobutton3 = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 75;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 76;BA.debugLine="Private Panel2 As Panel";
mostCurrent._panel2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 77;BA.debugLine="Private Panel3 As Panel";
mostCurrent._panel3 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 78;BA.debugLine="Private Panel4 As Panel";
mostCurrent._panel4 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6(String _dat,String _folder) throws Exception{
anywheresoftware.b4a.objects.streams.File.TextReaderWrapper _tr = null;
String _name = "";
String _author = "";
String _desc = "";
String _web = "";
String _email = "";
anywheresoftware.b4a.objects.collections.List _l = null;
int _i = 0;
String _s = "";
String _s1 = "";
 //BA.debugLineNum = 293;BA.debugLine="Sub ParsajINIDat(dat As String, folder As String)";
 //BA.debugLineNum = 294;BA.debugLine="Dim tr As TextReader";
_tr = new anywheresoftware.b4a.objects.streams.File.TextReaderWrapper();
 //BA.debugLineNum = 295;BA.debugLine="Dim name, author, desc, web, email As String";
_name = "";
_author = "";
_desc = "";
_web = "";
_email = "";
 //BA.debugLineNum = 297;BA.debugLine="zid1 = \"null\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = "null";
 //BA.debugLineNum = 298;BA.debugLine="kutija1 = \"null\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = "null";
 //BA.debugLineNum = 299;BA.debugLine="kutnamj1 = \"null\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = "null";
 //BA.debugLineNum = 300;BA.debugLine="mjzakut1 = \"null\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = "null";
 //BA.debugLineNum = 301;BA.debugLine="pod1 = \"null\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = "null";
 //BA.debugLineNum = 302;BA.debugLine="igr1 = \"null\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = "null";
 //BA.debugLineNum = 303;BA.debugLine="igrnamj1 = \"null\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = "null";
 //BA.debugLineNum = 306;BA.debugLine="tr.Initialize(File.OpenInput(Starter.SourceFolder";
_tr.Initialize((java.io.InputStream)(anywheresoftware.b4a.keywords.Common.File.OpenInput(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+_folder,_dat).getObject()));
 //BA.debugLineNum = 307;BA.debugLine="Dim l As List = tr.ReadList";
_l = new anywheresoftware.b4a.objects.collections.List();
_l = _tr.ReadList();
 //BA.debugLineNum = 308;BA.debugLine="tr.Close";
_tr.Close();
 //BA.debugLineNum = 309;BA.debugLine="For i = 0 To l.Size - 1";
{
final int step13 = 1;
final int limit13 = (int) (_l.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit13 ;_i = _i + step13 ) {
 //BA.debugLineNum = 310;BA.debugLine="Dim s As String = l.Get(i)";
_s = BA.ObjectToString(_l.Get(_i));
 //BA.debugLineNum = 311;BA.debugLine="If s.StartsWith(\"name=\") Then";
if (_s.startsWith("name=")) { 
 //BA.debugLineNum = 312;BA.debugLine="Dim s1 As String = s.SubString(s.IndexOf(\"=\"))";
_s1 = _s.substring(_s.indexOf("="));
 //BA.debugLineNum = 313;BA.debugLine="name = s1.SubString(1)";
_name = _s1.substring((int) (1));
 //BA.debugLineNum = 314;BA.debugLine="mOpcije.Put(\"name\", name)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("name"),(Object)(_name));
 }else if(_s.startsWith("author=")) { 
 //BA.debugLineNum = 316;BA.debugLine="Dim s1 As String = s.SubString(s.IndexOf(\"=\"))";
_s1 = _s.substring(_s.indexOf("="));
 //BA.debugLineNum = 317;BA.debugLine="author = s1.SubString(1)";
_author = _s1.substring((int) (1));
 //BA.debugLineNum = 318;BA.debugLine="mOpcije.Put(\"author\", author)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("author"),(Object)(_author));
 }else if(_s.startsWith("description=")) { 
 //BA.debugLineNum = 320;BA.debugLine="Dim s1 As String = s.SubString(s.IndexOf(\"=\"))";
_s1 = _s.substring(_s.indexOf("="));
 //BA.debugLineNum = 321;BA.debugLine="desc = s1.SubString(1)";
_desc = _s1.substring((int) (1));
 //BA.debugLineNum = 322;BA.debugLine="mOpcije.Put(\"desc\", desc)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("desc"),(Object)(_desc));
 }else if(_s.startsWith("website=")) { 
 //BA.debugLineNum = 324;BA.debugLine="Dim s1 As String = s.SubString(s.IndexOf(\"=\"))";
_s1 = _s.substring(_s.indexOf("="));
 //BA.debugLineNum = 325;BA.debugLine="web = s1.SubString(1)";
_web = _s1.substring((int) (1));
 //BA.debugLineNum = 326;BA.debugLine="mOpcije.Put(\"web\", web)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("web"),(Object)(_web));
 }else if(_s.startsWith("email=")) { 
 //BA.debugLineNum = 328;BA.debugLine="Dim s1 As String = s.SubString(s.IndexOf(\"=\"))";
_s1 = _s.substring(_s.indexOf("="));
 //BA.debugLineNum = 329;BA.debugLine="email = s1.SubString(1)";
_email = _s1.substring((int) (1));
 //BA.debugLineNum = 330;BA.debugLine="mOpcije.Put(\"email\", email)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("email"),(Object)(_email));
 }else if(_s.startsWith("object=")) { 
 //BA.debugLineNum = 332;BA.debugLine="Dim s1 As String = s.SubString(s.IndexOf(\"=\"))";
_s1 = _s.substring(_s.indexOf("="));
 //BA.debugLineNum = 333;BA.debugLine="kutija1 = s1.SubString(1).ToLowerCase";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = _s1.substring((int) (1)).toLowerCase();
 }else if(_s.startsWith("object_store=")) { 
 //BA.debugLineNum = 335;BA.debugLine="Dim s1 As String = s.SubString(s.IndexOf(\"=\"))";
_s1 = _s.substring(_s.indexOf("="));
 //BA.debugLineNum = 336;BA.debugLine="kutnamj1 = s1.SubString(1).ToLowerCase";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = _s1.substring((int) (1)).toLowerCase();
 }else if(_s.startsWith("floor=") || _s.startsWith("ground=")) { 
 //BA.debugLineNum = 338;BA.debugLine="Dim s1 As String = s.SubString(s.IndexOf(\"=\"))";
_s1 = _s.substring(_s.indexOf("="));
 //BA.debugLineNum = 339;BA.debugLine="pod1 = s1.SubString(1).ToLowerCase";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = _s1.substring((int) (1)).toLowerCase();
 }else if(_s.startsWith("store=")) { 
 //BA.debugLineNum = 341;BA.debugLine="Dim s1 As String = s.SubString(s.IndexOf(\"=\"))";
_s1 = _s.substring(_s.indexOf("="));
 //BA.debugLineNum = 342;BA.debugLine="mjzakut1 = s1.SubString(1).ToLowerCase";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = _s1.substring((int) (1)).toLowerCase();
 }else if(_s.startsWith("wall=")) { 
 //BA.debugLineNum = 344;BA.debugLine="Dim s1 As String = s.SubString(s.IndexOf(\"=\"))";
_s1 = _s.substring(_s.indexOf("="));
 //BA.debugLineNum = 345;BA.debugLine="zid1 = s1.SubString(1).ToLowerCase";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = _s1.substring((int) (1)).toLowerCase();
 }else if(_s.startsWith("mover_up=") || _s.startsWith("mover=")) { 
 //BA.debugLineNum = 347;BA.debugLine="Dim s1 As String = s.SubString(s.IndexOf(\"=\"))";
_s1 = _s.substring(_s.indexOf("="));
 //BA.debugLineNum = 348;BA.debugLine="igr1 = s1.SubString(1).ToLowerCase";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = _s1.substring((int) (1)).toLowerCase();
 }else if(_s.startsWith("mover_store_up=") || _s.startsWith("mover_store=") || _s.startsWith("mover_up_store")) { 
 //BA.debugLineNum = 350;BA.debugLine="Dim s1 As String = s.SubString(s.IndexOf(\"=\"))";
_s1 = _s.substring(_s.indexOf("="));
 //BA.debugLineNum = 351;BA.debugLine="igrnamj1 = s1.SubString(1).ToLowerCase";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = _s1.substring((int) (1)).toLowerCase();
 }else if(_s.startsWith("move=")) { 
 //BA.debugLineNum = 353;BA.debugLine="Dim s1 As String = s.SubString(s.IndexOf(\"=\")).";
_s1 = _s.substring(_s.indexOf("=")).toLowerCase();
 //BA.debugLineNum = 355;BA.debugLine="mOpcije.Put(\"mjuzaMove\", s1)'s1.SubString(1))";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("mjuzaMove"),(Object)(_s1));
 }else if(_s.startsWith("move_object=")) { 
 //BA.debugLineNum = 360;BA.debugLine="Dim s1 As String = s.SubString(s.IndexOf(\"=\")).";
_s1 = _s.substring(_s.indexOf("=")).toLowerCase();
 //BA.debugLineNum = 362;BA.debugLine="mOpcije.Put(\"mjuzaMoveObj\", s1)'s1.SubString(1";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("mjuzaMoveObj"),(Object)(_s1));
 }else if(_s.startsWith("finishlevel=")) { 
 //BA.debugLineNum = 367;BA.debugLine="Dim s1 As String = s.SubString(s.IndexOf(\"=\")).";
_s1 = _s.substring(_s.indexOf("=")).toLowerCase();
 //BA.debugLineNum = 369;BA.debugLine="mOpcije.Put(\"mjuza\", s1)'s1.SubString(1))";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("mjuza"),(Object)(_s1));
 };
 }
};
 //BA.debugLineNum = 375;BA.debugLine="mOpcije.Put(\"kutija\", kutija1)'s1.SubString(1))";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("kutija"),(Object)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4));
 //BA.debugLineNum = 376;BA.debugLine="mOpcije.Put(\"kutnamj\", kutnamj1)'s1.SubString(1))";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("kutnamj"),(Object)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5));
 //BA.debugLineNum = 377;BA.debugLine="mOpcije.Put(\"pod\", pod1)'s1.SubString(1))";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("pod"),(Object)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7));
 //BA.debugLineNum = 378;BA.debugLine="mOpcije.Put(\"mjzakut\", mjzakut1)'s1.SubString(1))";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("mjzakut"),(Object)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6));
 //BA.debugLineNum = 379;BA.debugLine="mOpcije.Put(\"zid\", zid1)'s1.SubString(1))";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("zid"),(Object)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3));
 //BA.debugLineNum = 380;BA.debugLine="mOpcije.Put(\"igr\", igr1)'s1.SubString(1))";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("igr"),(Object)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0));
 //BA.debugLineNum = 381;BA.debugLine="mOpcije.Put(\"igrnamj\", igrnamj1)'s1.SubString(1))";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("igrnamj"),(Object)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1));
 //BA.debugLineNum = 383;BA.debugLine="lblSkinInfo.Text = \"Name: \" & name & CRLF & \"Auth";
mostCurrent._lblskininfo.setText(BA.ObjectToCharSequence("Name: "+_name+anywheresoftware.b4a.keywords.Common.CRLF+"Author: "+_author+anywheresoftware.b4a.keywords.Common.CRLF+"Description: "+_desc+anywheresoftware.b4a.keywords.Common.CRLF+"Web: "+_web+anywheresoftware.b4a.keywords.Common.CRLF+"Email: "+_email));
 //BA.debugLineNum = 384;BA.debugLine="SloziPreview(folder)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5(_folder);
 //BA.debugLineNum = 385;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(String _dir) throws Exception{
anywheresoftware.b4a.objects.collections.List _list_files = null;
anywheresoftware.b4a.objects.collections.List _lista_folders = null;
int _i = 0;
 //BA.debugLineNum = 234;BA.debugLine="Sub ProcitajSveFoldereUSkinDir(dir As String) As L";
 //BA.debugLineNum = 235;BA.debugLine="Dim list_files As List";
_list_files = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 236;BA.debugLine="Dim lista_folders As List";
_lista_folders = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 238;BA.debugLine="lista_folders.Initialize";
_lista_folders.Initialize();
 //BA.debugLineNum = 239;BA.debugLine="list_files=File.ListFiles(dir)";
_list_files = anywheresoftware.b4a.keywords.Common.File.ListFiles(_dir);
 //BA.debugLineNum = 240;BA.debugLine="For i= 0 To list_files.Size -1";
{
final int step5 = 1;
final int limit5 = (int) (_list_files.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 241;BA.debugLine="If File.IsDirectory(dir, list_files.Get(i))=True";
if (anywheresoftware.b4a.keywords.Common.File.IsDirectory(_dir,BA.ObjectToString(_list_files.Get(_i)))==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 242;BA.debugLine="lista_folders.Add(list_files.Get(i))";
_lista_folders.Add(_list_files.Get(_i));
 };
 }
};
 //BA.debugLineNum = 246;BA.debugLine="Return lista_folders";
if (true) return _lista_folders;
 //BA.debugLineNum = 247;BA.debugLine="End Sub";
return null;
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5() throws Exception{
 //BA.debugLineNum = 230;BA.debugLine="Sub RaspakirajSkinoveIzArhive";
 //BA.debugLineNum = 231;BA.debugLine="arch.UnZip(Starter.SourceFolder, \"skins.zip\", Sta";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.UnZip(processBA,mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1,"skins.zip",mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1,"anzip");
 //BA.debugLineNum = 232;BA.debugLine="End Sub";
return "";
}
public static String  _rb2c_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 513;BA.debugLine="Sub rb2c_CheckedChange(Checked As Boolean)";
 //BA.debugLineNum = 514;BA.debugLine="rb2 = Checked";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = _checked;
 //BA.debugLineNum = 515;BA.debugLine="If Checked Then";
if (_checked) { 
 //BA.debugLineNum = 516;BA.debugLine="CheckBox1.Enabled = True";
mostCurrent._checkbox1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 518;BA.debugLine="CheckBox1.Enabled = False";
mostCurrent._checkbox1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 520;BA.debugLine="mOpcije.Put(\"rb2\", rb2)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("rb2"),(Object)(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2));
 //BA.debugLineNum = 521;BA.debugLine="RadioButton2.Checked = False";
mostCurrent._radiobutton2.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 522;BA.debugLine="rb3 = False";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 523;BA.debugLine="RadioButton3.Checked = False";
mostCurrent._radiobutton3.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 524;BA.debugLine="rb4 = False";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 525;BA.debugLine="End Sub";
return "";
}
public static String  _rb3c_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 530;BA.debugLine="Sub rb3c_CheckedChange(Checked As Boolean)";
 //BA.debugLineNum = 531;BA.debugLine="rb3 = Checked";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = _checked;
 //BA.debugLineNum = 532;BA.debugLine="mOpcije.Put(\"rb3\", Checked)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("rb3"),(Object)(_checked));
 //BA.debugLineNum = 533;BA.debugLine="RadioButton1.Checked = False";
mostCurrent._radiobutton1.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 534;BA.debugLine="rb2 = False";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 535;BA.debugLine="RadioButton3.Checked = False";
mostCurrent._radiobutton3.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 536;BA.debugLine="rb4 = False";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 537;BA.debugLine="End Sub";
return "";
}
public static String  _rb4c_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 542;BA.debugLine="Sub rb4c_CheckedChange(Checked As Boolean)";
 //BA.debugLineNum = 543;BA.debugLine="rb4 = Checked";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = _checked;
 //BA.debugLineNum = 544;BA.debugLine="mOpcije.Put(\"rb4\", Checked)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("rb4"),(Object)(_checked));
 //BA.debugLineNum = 545;BA.debugLine="RadioButton1.Checked = False";
mostCurrent._radiobutton1.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 546;BA.debugLine="rb2 = False";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 547;BA.debugLine="RadioButton2.Checked = False";
mostCurrent._radiobutton2.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 548;BA.debugLine="rb3 = False";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 549;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5(String _fold) throws Exception{
boolean _imamozid = false;
int _y = 0;
int _k = 0;
anywheresoftware.b4a.objects.collections.List _izgledlevela = null;
int _i = 0;
String _s = "";
int _j = 0;
String _s1 = "";
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
 //BA.debugLineNum = 387;BA.debugLine="Sub SloziPreview(fold As String)";
 //BA.debugLineNum = 389;BA.debugLine="Dim imamoZid As Boolean = False";
_imamozid = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 390;BA.debugLine="Dim y As Int = 0 : Dim k As Int = 0";
_y = (int) (0);
 //BA.debugLineNum = 390;BA.debugLine="Dim y As Int = 0 : Dim k As Int = 0";
_k = (int) (0);
 //BA.debugLineNum = 391;BA.debugLine="Dim izgledLevela As List";
_izgledlevela = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 393;BA.debugLine="izgledLevela.Initialize2(Array As String(\"#####\",";
_izgledlevela.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"#####","#   #","# #$###","# @ .*#","#######"}));
 //BA.debugLineNum = 399;BA.debugLine="For i = 0 To 4'hL-1";
{
final int step6 = 1;
final int limit6 = (int) (4);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
 //BA.debugLineNum = 400;BA.debugLine="Dim s As String = izgledLevela.Get(i)";
_s = BA.ObjectToString(_izgledlevela.Get(_i));
 //BA.debugLineNum = 401;BA.debugLine="For j = 0 To s.Length - 1";
{
final int step8 = 1;
final int limit8 = (int) (_s.length()-1);
_j = (int) (0) ;
for (;_j <= limit8 ;_j = _j + step8 ) {
 //BA.debugLineNum = 402;BA.debugLine="Dim s1 As String = s.CharAt(j)";
_s1 = BA.ObjectToString(_s.charAt(_j));
 //BA.debugLineNum = 404;BA.debugLine="If s1.EqualsIgnoreCase(\"#\") Then";
if (_s1.equalsIgnoreCase("#")) { 
 //BA.debugLineNum = 405;BA.debugLine="imamoZid = True";
_imamozid = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 406;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 407;BA.debugLine="If zid1.Contains(\"null\") = False Then ' .Lengt";
if (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.contains("null")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 408;BA.debugLine="bmp.Initialize(Starter.SourceFolder & fold &";
_bmp.Initialize(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+_fold+"/",mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3);
 }else {
 //BA.debugLineNum = 410;BA.debugLine="bmp.Initialize(File.DirAssets, \"zid_2.png\")";
_bmp.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"zid_2.png");
 };
 //BA.debugLineNum = 412;BA.debugLine="ivs(k).Bitmap = bmp";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6[_k].setBitmap((android.graphics.Bitmap)(_bmp.getObject()));
 //BA.debugLineNum = 413;BA.debugLine="k = k + 1";
_k = (int) (_k+1);
 }else if(_s1.equalsIgnoreCase(" ")) { 
 //BA.debugLineNum = 417;BA.debugLine="If imamoZid Then";
if (_imamozid) { 
 //BA.debugLineNum = 418;BA.debugLine="If y > 0 And y < 4 Then'hL - 1 Then";
if (_y>0 && _y<4) { 
 //BA.debugLineNum = 419;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 421;BA.debugLine="If pod1.Contains(\"null\") = False Then";
if (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.contains("null")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 422;BA.debugLine="bmp.Initialize(Starter.SourceFolder & fold";
_bmp.Initialize(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+_fold+"/",mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7);
 }else {
 //BA.debugLineNum = 424;BA.debugLine="bmp.Initialize(File.DirAssets, \"pod.png\")";
_bmp.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"pod.png");
 };
 //BA.debugLineNum = 426;BA.debugLine="ivs(k).Bitmap = bmp";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6[_k].setBitmap((android.graphics.Bitmap)(_bmp.getObject()));
 //BA.debugLineNum = 427;BA.debugLine="k = k + 1";
_k = (int) (_k+1);
 };
 };
 }else if(_s1.equalsIgnoreCase("$")) { 
 //BA.debugLineNum = 433;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 434;BA.debugLine="If kutija1.Contains(\"null\") = False Then' .Len";
if (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.contains("null")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 435;BA.debugLine="bmp.Initialize(Starter.SourceFolder & fold &";
_bmp.Initialize(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+_fold+"/",mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4);
 }else {
 //BA.debugLineNum = 437;BA.debugLine="bmp.Initialize(File.DirAssets, \"kutija_2.png\"";
_bmp.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"kutija_2.png");
 };
 //BA.debugLineNum = 439;BA.debugLine="ivs(k).Bitmap = bmp";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6[_k].setBitmap((android.graphics.Bitmap)(_bmp.getObject()));
 //BA.debugLineNum = 440;BA.debugLine="k = k + 1";
_k = (int) (_k+1);
 }else if(_s1.equalsIgnoreCase(".") || _s1.equalsIgnoreCase("*")) { 
 //BA.debugLineNum = 444;BA.debugLine="If s1.EqualsIgnoreCase(\"*\") Then";
if (_s1.equalsIgnoreCase("*")) { 
 //BA.debugLineNum = 445;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 446;BA.debugLine="If kutnamj1.Contains(\"null\") = False Then ' .";
if (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.contains("null")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 447;BA.debugLine="bmp.Initialize(Starter.SourceFolder & fold &";
_bmp.Initialize(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+_fold+"/",mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5);
 }else {
 //BA.debugLineNum = 449;BA.debugLine="bmp.Initialize(File.DirAssets, \"kutija_na_mj";
_bmp.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"kutija_na_mjestu_2.png");
 };
 //BA.debugLineNum = 451;BA.debugLine="ivs(k).Bitmap = bmp";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6[_k].setBitmap((android.graphics.Bitmap)(_bmp.getObject()));
 //BA.debugLineNum = 452;BA.debugLine="k = k + 1";
_k = (int) (_k+1);
 }else if(_s1.equalsIgnoreCase(".")) { 
 //BA.debugLineNum = 455;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 456;BA.debugLine="If mjzakut1.Contains(\"null\") = False Then ' .";
if (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.contains("null")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 457;BA.debugLine="bmp.Initialize(Starter.SourceFolder & fold &";
_bmp.Initialize(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+_fold+"/",mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6);
 }else {
 //BA.debugLineNum = 459;BA.debugLine="bmp.Initialize(File.DirAssets, \"iks_2.png\")";
_bmp.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"iks_2.png");
 };
 //BA.debugLineNum = 461;BA.debugLine="ivs(k).Bitmap = bmp";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6[_k].setBitmap((android.graphics.Bitmap)(_bmp.getObject()));
 //BA.debugLineNum = 462;BA.debugLine="k = k + 1";
_k = (int) (_k+1);
 };
 }else if(_s1.equalsIgnoreCase("@") || _s1.equalsIgnoreCase("+")) { 
 //BA.debugLineNum = 467;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 468;BA.debugLine="If igr1.Contains(\"null\") = False Then ' .Lengt";
if (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.contains("null")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 469;BA.debugLine="bmp.Initialize(Starter.SourceFolder & fold &";
_bmp.Initialize(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+_fold+"/",mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0);
 }else {
 //BA.debugLineNum = 471;BA.debugLine="bmp.Initialize(File.DirAssets, \"igrac2.png\")";
_bmp.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"igrac2.png");
 };
 //BA.debugLineNum = 473;BA.debugLine="ivs(k).Bitmap = bmp";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6[_k].setBitmap((android.graphics.Bitmap)(_bmp.getObject()));
 //BA.debugLineNum = 474;BA.debugLine="k = k + 1";
_k = (int) (_k+1);
 };
 }
};
 //BA.debugLineNum = 477;BA.debugLine="y = y + 1";
_y = (int) (_y+1);
 //BA.debugLineNum = 478;BA.debugLine="imamoZid = False";
_imamozid = anywheresoftware.b4a.keywords.Common.False;
 }
};
 //BA.debugLineNum = 480;BA.debugLine="End Sub";
return "";
}
public static String  _spnskin_itemclick(int _position,Object _value) throws Exception{
anywheresoftware.b4a.objects.collections.List _l = null;
int _i = 0;
String _s = "";
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
 //BA.debugLineNum = 255;BA.debugLine="Sub spnSkin_ItemClick (Position As Int, Value As O";
 //BA.debugLineNum = 256;BA.debugLine="spn = Value";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = BA.ObjectToString(_value);
 //BA.debugLineNum = 257;BA.debugLine="Dim l As List = File.ListFiles(Starter.SourceFold";
_l = new anywheresoftware.b4a.objects.collections.List();
_l = anywheresoftware.b4a.keywords.Common.File.ListFiles(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+"/skins/"+BA.ObjectToString(_value));
 //BA.debugLineNum = 259;BA.debugLine="If spn.StartsWith(\"1\") Then";
if (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.startsWith("1")) { 
 //BA.debugLineNum = 260;BA.debugLine="Panel3.Visible = True";
mostCurrent._panel3.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 261;BA.debugLine="Panel4.Visible = False";
mostCurrent._panel4.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 262;BA.debugLine="Panel3.BringToFront";
mostCurrent._panel3.BringToFront();
 //BA.debugLineNum = 263;BA.debugLine="For i = 0 To l.Size - 1";
{
final int step7 = 1;
final int limit7 = (int) (_l.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
 //BA.debugLineNum = 264;BA.debugLine="Dim s As String = l.get(i)";
_s = BA.ObjectToString(_l.Get(_i));
 //BA.debugLineNum = 265;BA.debugLine="Dim bmp As Bitmap = LoadBitmap(Starter.SourceFo";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp = anywheresoftware.b4a.keywords.Common.LoadBitmap(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7._vv1+"/skins"+"/"+mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1,mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.substring((int) (1))+"-preview-simple.png");
 //BA.debugLineNum = 266;BA.debugLine="imgPreview.Bitmap = bmp";
mostCurrent._imgpreview.setBitmap((android.graphics.Bitmap)(_bmp.getObject()));
 //BA.debugLineNum = 267;BA.debugLine="imgPreview.Width = 224dip'DipToCurrent(bmp.Widt";
mostCurrent._imgpreview.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (224)));
 //BA.debugLineNum = 268;BA.debugLine="imgPreview.Height = 160dip'DipToCurrent(bmp.Hei";
mostCurrent._imgpreview.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (160)));
 //BA.debugLineNum = 269;BA.debugLine="imgPreview.Left = (100%x - imgPreview.Width) /";
mostCurrent._imgpreview.setLeft((int) ((anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-mostCurrent._imgpreview.getWidth())/(double)2));
 }
};
 //BA.debugLineNum = 271;BA.debugLine="mOpcije.Put(\"skin\", spn)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("skin"),(Object)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1));
 }else {
 //BA.debugLineNum = 275;BA.debugLine="Panel3.Visible = False";
mostCurrent._panel3.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 276;BA.debugLine="Panel4.Visible = True";
mostCurrent._panel4.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 277;BA.debugLine="Panel4.BringToFront";
mostCurrent._panel4.BringToFront();
 //BA.debugLineNum = 278;BA.debugLine="sv.Panel.Height = Panel1.Height + Panel2.Height";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvv2.getPanel().setHeight((int) (mostCurrent._panel1.getHeight()+mostCurrent._panel2.getHeight()+mostCurrent._panel4.getHeight()));
 //BA.debugLineNum = 279;BA.debugLine="For i = 0 To l.Size - 1";
{
final int step21 = 1;
final int limit21 = (int) (_l.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit21 ;_i = _i + step21 ) {
 //BA.debugLineNum = 280;BA.debugLine="Dim s As String = l.get(i)";
_s = BA.ObjectToString(_l.Get(_i));
 //BA.debugLineNum = 281;BA.debugLine="If s.EndsWith(\"ini\") Then";
if (_s.endsWith("ini")) { 
 //BA.debugLineNum = 282;BA.debugLine="ParsajINIDat(s, \"/skins/\" & Value & \"/\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6(_s,"/skins/"+BA.ObjectToString(_value)+"/");
 };
 }
};
 //BA.debugLineNum = 289;BA.debugLine="mOpcije.Put(\"skin\", spn)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Put((Object)("skin"),(Object)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1));
 };
 //BA.debugLineNum = 291;BA.debugLine="End Sub";
return "";
}
}
