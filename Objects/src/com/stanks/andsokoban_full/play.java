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

public class play extends Activity implements B4AActivity{
	public static play mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "com.stanks.andsokoban_full", "com.stanks.andsokoban_full.play");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (play).");
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
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
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
		activityBA = new BA(this, layout, processBA, "com.stanks.andsokoban_full", "com.stanks.andsokoban_full.play");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.stanks.andsokoban_full.play", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (play) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (play) Resume **");
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
		return play.class;
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
        BA.LogInfo("** Activity (play) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            play mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (play) Resume **");
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
public static anywheresoftware.b4a.objects.Timer _vv2 = null;
public static anywheresoftware.b4a.objects.Timer _vv3 = null;
public static anywheresoftware.b4a.objects.Timer _vv4 = null;
public static anywheresoftware.b4a.objects.SaxParser _slc_parse = null;
public static anywheresoftware.b4a.audio.SoundPoolWrapper _vv5 = null;
public static int _vv6 = 0;
public static int _vv7 = 0;
public static int _vv0 = 0;
public static int _vvv1 = 0;
public static anywheresoftware.b4a.phone.Phone.PhoneWakeState _vvv2 = null;
public static anywheresoftware.b4a.phone.Phone.PhoneSensors _vvv3 = null;
public static int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = 0;
public static int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = null;
public static int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = 0;
public static int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = 0;
public anywheresoftware.b4a.objects.LabelWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = null;
public anywheresoftware.b4a.objects.LabelWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = null;
public static int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = 0;
public anywheresoftware.b4a.objects.LabelWrapper _lblrazina = null;
public static int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = 0;
public static int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = 0;
public static int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = null;
public anywheresoftware.b4a.objects.collections.List _vvv4 = null;
public static String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = "";
public anywheresoftware.b4a.objects.PanelWrapper _paneli = null;
public flm.b4a.scrollview2d.ScrollView2DWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = null;
public static int _vvv6 = 0;
public anywheresoftware.b4a.objects.collections.Map _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = null;
public anywheresoftware.b4a.objects.collections.Map _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = null;
public static int _ukupno_razina = 0;
public static boolean _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = false;
public anywheresoftware.b4a.objects.ButtonWrapper _btnsound = null;
public com.tillekesoft.screenrecorder.B4AScreenRecorder _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = null;
public static boolean _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = false;
public static String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = "";
public anywheresoftware.b4a.objects.ButtonWrapper _btnrec = null;
public static boolean _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = false;
public static boolean _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = false;
public static boolean _pnl_info_vidljiv = false;
public anywheresoftware.b4a.objects.PanelWrapper _pnlinfo = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btninfo = null;
public static float _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = 0f;
public static float _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0f;
public static float _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0f;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = null;
public anywheresoftware.b4a.agraham.reflection.Reflection _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = null;
public static int _action_down = 0;
public static int _action_move = 0;
public static int _action_up = 0;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.agraham.gifdecoder.GifDecoder _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = null;
public static int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = 0;
public anywheresoftware.b4a.objects.PanelWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = null;
public static String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = "";
public static int _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = 0;
public static boolean _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = false;
public anywheresoftware.b4a.objects.ButtonWrapper _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = null;
public b4a.example.dateutils _vvvvvvv3 = null;
public com.stanks.andsokoban_full.main _vvvvvvv4 = null;
public com.stanks.andsokoban_full.starter _vvvvvvv5 = null;
public com.stanks.andsokoban_full.odabir _vvvvvvv7 = null;
public com.stanks.andsokoban_full.video _vvvvvvv0 = null;
public com.stanks.andsokoban_full.rijesenja _vvvvvvvv1 = null;
public com.stanks.andsokoban_full.opcije _vvvvvvvv2 = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.phone.Phone _ph = null;
anywheresoftware.b4a.objects.collections.Map _mopcije = null;
boolean _rb4 = false;
String _nivo = "";
String _mjuza = "";
String _mjuzamoveobj = "";
String _mjuzazid = "";
 //BA.debugLineNum = 125;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 133;BA.debugLine="Dim ph As Phone";
_ph = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 135;BA.debugLine="ph.SetScreenOrientation(0)";
_ph.SetScreenOrientation(processBA,(int) (0));
 //BA.debugLineNum = 137;BA.debugLine="Dim mOpcije As Map";
_mopcije = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 138;BA.debugLine="Dim rb4 As Boolean";
_rb4 = false;
 //BA.debugLineNum = 139;BA.debugLine="mOpcije = File.ReadMap(Starter.SourceFolder, \"opc";
_mopcije = anywheresoftware.b4a.keywords.Common.File.ReadMap(mostCurrent._vvvvvvv5._vv1,"opcije");
 //BA.debugLineNum = 140;BA.debugLine="rb4 = mOpcije.Get(\"rb4\")";
_rb4 = BA.ObjectToBoolean(_mopcije.Get((Object)("rb4")));
 //BA.debugLineNum = 141;BA.debugLine="Dim nivo, mjuza, mjuzaMoveObj, mjuzaZid As String";
_nivo = "";
_mjuza = "";
_mjuzamoveobj = "";
_mjuzazid = "";
 //BA.debugLineNum = 142;BA.debugLine="nivo = mOpcije.Get(\"skin\")";
_nivo = BA.ObjectToString(_mopcije.Get((Object)("skin")));
 //BA.debugLineNum = 143;BA.debugLine="mjuza = mOpcije.get(\"mjuza\")";
_mjuza = BA.ObjectToString(_mopcije.Get((Object)("mjuza")));
 //BA.debugLineNum = 144;BA.debugLine="mjuzaMoveObj = mOpcije.Get(\"mjuzaMoveObj\")";
_mjuzamoveobj = BA.ObjectToString(_mopcije.Get((Object)("mjuzaMoveObj")));
 //BA.debugLineNum = 145;BA.debugLine="mjuzaZid = mOpcije.Get(\"mjuzaZid\")";
_mjuzazid = BA.ObjectToString(_mopcije.Get((Object)("mjuzaZid")));
 //BA.debugLineNum = 147;BA.debugLine="Timer3.Initialize(\"Timer3\", 1000)";
_vv3.Initialize(processBA,"Timer3",(long) (1000));
 //BA.debugLineNum = 149;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
 //BA.debugLineNum = 150;BA.debugLine="sounds.Initialize(4)";
_vv5.Initialize((int) (4));
 //BA.debugLineNum = 152;BA.debugLine="If mjuzaZid.EqualsIgnoreCase(\"true\") Then";
if (_mjuzazid.equalsIgnoreCase("true")) { 
 //BA.debugLineNum = 153;BA.debugLine="bounceId1 = sounds.Load(File.DirAssets, \"zid.mp";
_vv6 = _vv5.Load(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"zid.mp3");
 };
 //BA.debugLineNum = 160;BA.debugLine="If nivo.StartsWith(\"1\") Then";
if (_nivo.startsWith("1")) { 
 //BA.debugLineNum = 161;BA.debugLine="bounceId2 = sounds.Load(File.DirAssets, \"na_mje";
_vv7 = _vv5.Load(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"na_mjestu.mp3");
 }else {
 //BA.debugLineNum = 163;BA.debugLine="bounceId2 = sounds.Load(Starter.SourceFolder &";
_vv7 = _vv5.Load(mostCurrent._vvvvvvv5._vv1+"/skins/"+_nivo+"/",_mjuzamoveobj);
 };
 //BA.debugLineNum = 166;BA.debugLine="If nivo.StartsWith(\"1\") Or mOpcije.ContainsKey(\"";
if (_nivo.startsWith("1") || _mopcije.ContainsKey((Object)("mjuza"))==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 167;BA.debugLine="bounceId3 = sounds.Load(File.DirAssets, \"lvl.mp";
_vv0 = _vv5.Load(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"lvl.mp3");
 //BA.debugLineNum = 168;BA.debugLine="bounceId4 = sounds.Load(File.DirAssets, \"all_lv";
_vvv1 = _vv5.Load(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"all_lvls.mp3");
 }else if(_mopcije.ContainsKey((Object)("mjuza"))) { 
 //BA.debugLineNum = 170;BA.debugLine="bounceId3 = sounds.Load(Starter.SourceFolder &";
_vv0 = _vv5.Load(mostCurrent._vvvvvvv5._vv1+"/skins/"+_nivo+"/",_mjuza);
 };
 };
 //BA.debugLineNum = 174;BA.debugLine="If rb4 Then";
if (_rb4) { 
 //BA.debugLineNum = 175;BA.debugLine="sensor.Initialize(sensor.TYPE_ACCELEROMETER)";
_vvv3.Initialize(_vvv3.TYPE_ACCELEROMETER);
 //BA.debugLineNum = 176;BA.debugLine="Timer3.Enabled = True";
_vv3.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 179;BA.debugLine="If GetSDK >= 21 Then";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7()>=21) { 
 //BA.debugLineNum = 180;BA.debugLine="rec.Initialize(\"rec\")";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Initialize(processBA,"rec");
 }else {
 //BA.debugLineNum = 182;BA.debugLine="Msgbox(\"Recording supported only with SDK \" & Ge";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Recording supported only with SDK "+BA.NumberToString(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7())+" and Android version "+_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1()+anywheresoftware.b4a.keywords.Common.CRLF+"Recording will be disabled!"),BA.ObjectToCharSequence("Warning!"),mostCurrent.activityBA);
 };
 //BA.debugLineNum = 186;BA.debugLine="Timer1.Initialize(\"Timer1\", 100)";
_vv2.Initialize(processBA,"Timer1",(long) (100));
 //BA.debugLineNum = 188;BA.debugLine="Timer5.Initialize(\"Timer5\", 0)";
_vv4.Initialize(processBA,"Timer5",(long) (0));
 //BA.debugLineNum = 190;BA.debugLine="slc_parse.Initialize";
_slc_parse.Initialize(processBA);
 //BA.debugLineNum = 191;BA.debugLine="izgledLevela.Initialize";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Initialize();
 //BA.debugLineNum = 192;BA.debugLine="wLevel.Initialize";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Initialize();
 //BA.debugLineNum = 193;BA.debugLine="hLevel.Initialize";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Initialize();
 //BA.debugLineNum = 194;BA.debugLine="imeLevela.Initialize";
mostCurrent._vvv4.Initialize();
 //BA.debugLineNum = 198;BA.debugLine="brojLevela = 0";
_vvv6 = (int) (0);
 //BA.debugLineNum = 205;BA.debugLine="NovaIgra";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5();
 //BA.debugLineNum = 206;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 266;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 267;BA.debugLine="awake.ReleaseKeepAlive";
_vvv2.ReleaseKeepAlive();
 //BA.debugLineNum = 268;BA.debugLine="Timer1.Enabled = False";
_vv2.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 269;BA.debugLine="Timer3.Enabled = False";
_vv3.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 270;BA.debugLine="Timer5.Enabled = False";
_vv4.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 271;BA.debugLine="sensor.StopListening";
_vvv3.StopListening(processBA);
 //BA.debugLineNum = 272;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
anywheresoftware.b4a.phone.Phone _ph = null;
anywheresoftware.b4a.objects.collections.Map _mopcije = null;
boolean _rb4 = false;
 //BA.debugLineNum = 251;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 252;BA.debugLine="Dim ph As Phone";
_ph = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 254;BA.debugLine="ph.SetScreenOrientation(0)";
_ph.SetScreenOrientation(processBA,(int) (0));
 //BA.debugLineNum = 256;BA.debugLine="awake.KeepAlive(True)";
_vvv2.KeepAlive(processBA,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 257;BA.debugLine="Dim mOpcije As Map";
_mopcije = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 258;BA.debugLine="Dim rb4 As Boolean";
_rb4 = false;
 //BA.debugLineNum = 259;BA.debugLine="mOpcije = File.ReadMap(Starter.SourceFolder, \"opc";
_mopcije = anywheresoftware.b4a.keywords.Common.File.ReadMap(mostCurrent._vvvvvvv5._vv1,"opcije");
 //BA.debugLineNum = 260;BA.debugLine="rb4 = mOpcije.Get(\"rb4\")";
_rb4 = BA.ObjectToBoolean(_mopcije.Get((Object)("rb4")));
 //BA.debugLineNum = 261;BA.debugLine="If rb4 Then";
if (_rb4) { 
 //BA.debugLineNum = 262;BA.debugLine="sensor.StartListening(\"sensor\")";
_vvv3.StartListening(processBA,"sensor");
 };
 //BA.debugLineNum = 264;BA.debugLine="End Sub";
return "";
}
public static String  _btn_click() throws Exception{
anywheresoftware.b4a.objects.ConcreteViewWrapper _send = null;
int _redak = 0;
int _stupac = 0;
String _starapoz = "";
String _npt1 = "";
int _npt2 = 0;
String _novapoz = "";
String _drugakutijapoz = "";
String _s = "";
 //BA.debugLineNum = 847;BA.debugLine="Sub btn_Click";
 //BA.debugLineNum = 848;BA.debugLine="Dim send As View : Dim redak, stupac As Int' : Di";
_send = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
 //BA.debugLineNum = 848;BA.debugLine="Dim send As View : Dim redak, stupac As Int' : Di";
_redak = 0;
_stupac = 0;
 //BA.debugLineNum = 849;BA.debugLine="If Timer1.Enabled = False Then Timer1.Enabled = T";
if (_vv2.getEnabled()==anywheresoftware.b4a.keywords.Common.False) { 
_vv2.setEnabled(anywheresoftware.b4a.keywords.Common.True);};
 //BA.debugLineNum = 853;BA.debugLine="send = Sender";
_send.setObject((android.view.View)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 854;BA.debugLine="Select send.Tag";
switch (BA.switchObjectToInt(_send.getTag(),(Object)("g"),(Object)("l"),(Object)("d"),(Object)("do"),(Object)("reset"),(Object)("sound"),(Object)("record"),(Object)("natrag"))) {
case 0: {
 //BA.debugLineNum = 857;BA.debugLine="redak = -1";
_redak = (int) (-1);
 //BA.debugLineNum = 859;BA.debugLine="Dim staraPoz As String = karta.Get(\"@\")";
_starapoz = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)("@")));
 //BA.debugLineNum = 862;BA.debugLine="Dim npt1 As String = staraPoz.SubString2(0, sta";
_npt1 = _starapoz.substring((int) (0),_starapoz.indexOf(";"));
 //BA.debugLineNum = 863;BA.debugLine="Dim npt2 As Int = npt1 + redak";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_redak);
 //BA.debugLineNum = 864;BA.debugLine="Dim novaPoz As String = npt2 & staraPoz.SubStri";
_novapoz = BA.NumberToString(_npt2)+_starapoz.substring(_starapoz.indexOf(";"));
 //BA.debugLineNum = 867;BA.debugLine="Dim npt1 As String = novaPoz.SubString2(0, nova";
_npt1 = _novapoz.substring((int) (0),_novapoz.indexOf(";"));
 //BA.debugLineNum = 868;BA.debugLine="Dim npt2 As Int = npt1 + redak";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_redak);
 //BA.debugLineNum = 869;BA.debugLine="Dim drugaKutijaPoz As String = npt2 & novaPoz.S";
_drugakutijapoz = BA.NumberToString(_npt2)+_novapoz.substring(_novapoz.indexOf(";"));
 //BA.debugLineNum = 884;BA.debugLine="ProvjeriIPomakni(staraPoz, novaPoz, drugaKutija";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(_starapoz,_novapoz,_drugakutijapoz,(int) (1));
 break; }
case 1: {
 //BA.debugLineNum = 889;BA.debugLine="stupac = -1";
_stupac = (int) (-1);
 //BA.debugLineNum = 891;BA.debugLine="Dim staraPoz As String = karta.Get(\"@\")";
_starapoz = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)("@")));
 //BA.debugLineNum = 894;BA.debugLine="Dim npt1 As String = staraPoz.SubString(staraPo";
_npt1 = _starapoz.substring((int) (_starapoz.indexOf(";")+1));
 //BA.debugLineNum = 895;BA.debugLine="Dim npt2 As Int = npt1 + stupac";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_stupac);
 //BA.debugLineNum = 896;BA.debugLine="Dim novaPoz As String = staraPoz.SubString2(0,";
_novapoz = _starapoz.substring((int) (0),(int) (_starapoz.indexOf(";")+1))+BA.NumberToString(_npt2);
 //BA.debugLineNum = 899;BA.debugLine="Dim npt1 As String = novaPoz.SubString(novaPoz.";
_npt1 = _novapoz.substring((int) (_novapoz.indexOf(";")+1));
 //BA.debugLineNum = 900;BA.debugLine="Dim npt2 As Int = npt1 + stupac";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_stupac);
 //BA.debugLineNum = 901;BA.debugLine="Dim drugaKutijaPoz As String = novaPoz.SubStrin";
_drugakutijapoz = _novapoz.substring((int) (0),(int) (_novapoz.indexOf(";")+1))+BA.NumberToString(_npt2);
 //BA.debugLineNum = 916;BA.debugLine="ProvjeriIPomakni(staraPoz, novaPoz, drugaKutija";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(_starapoz,_novapoz,_drugakutijapoz,(int) (2));
 break; }
case 2: {
 //BA.debugLineNum = 921;BA.debugLine="stupac = 1";
_stupac = (int) (1);
 //BA.debugLineNum = 923;BA.debugLine="Dim staraPoz As String = karta.Get(\"@\")";
_starapoz = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)("@")));
 //BA.debugLineNum = 926;BA.debugLine="Dim npt1 As String = staraPoz.SubString(staraPo";
_npt1 = _starapoz.substring((int) (_starapoz.indexOf(";")+1));
 //BA.debugLineNum = 927;BA.debugLine="Dim npt2 As Int = npt1 + stupac";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_stupac);
 //BA.debugLineNum = 928;BA.debugLine="Dim novaPoz As String = staraPoz.SubString2(0,";
_novapoz = _starapoz.substring((int) (0),(int) (_starapoz.indexOf(";")+1))+BA.NumberToString(_npt2);
 //BA.debugLineNum = 931;BA.debugLine="Dim npt1 As String = novaPoz.SubString(novaPoz.";
_npt1 = _novapoz.substring((int) (_novapoz.indexOf(";")+1));
 //BA.debugLineNum = 932;BA.debugLine="Dim npt2 As Int = npt1 + stupac";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_stupac);
 //BA.debugLineNum = 933;BA.debugLine="Dim drugaKutijaPoz As String = novaPoz.SubStrin";
_drugakutijapoz = _novapoz.substring((int) (0),(int) (_novapoz.indexOf(";")+1))+BA.NumberToString(_npt2);
 //BA.debugLineNum = 948;BA.debugLine="ProvjeriIPomakni(staraPoz, novaPoz, drugaKutija";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(_starapoz,_novapoz,_drugakutijapoz,(int) (4));
 break; }
case 3: {
 //BA.debugLineNum = 952;BA.debugLine="redak = 1";
_redak = (int) (1);
 //BA.debugLineNum = 955;BA.debugLine="Dim staraPoz As String = karta.Get(\"@\")";
_starapoz = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)("@")));
 //BA.debugLineNum = 958;BA.debugLine="Dim npt1 As String = staraPoz.SubString2(0, sta";
_npt1 = _starapoz.substring((int) (0),_starapoz.indexOf(";"));
 //BA.debugLineNum = 959;BA.debugLine="Dim npt2 As Int = npt1 + redak";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_redak);
 //BA.debugLineNum = 960;BA.debugLine="Dim novaPoz As String = npt2 & staraPoz.SubStri";
_novapoz = BA.NumberToString(_npt2)+_starapoz.substring(_starapoz.indexOf(";"));
 //BA.debugLineNum = 963;BA.debugLine="Dim npt1 As String = novaPoz.SubString2(0, nova";
_npt1 = _novapoz.substring((int) (0),_novapoz.indexOf(";"));
 //BA.debugLineNum = 964;BA.debugLine="Dim npt2 As Int = npt1 + redak";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_redak);
 //BA.debugLineNum = 965;BA.debugLine="Dim drugaKutijaPoz As String = npt2 & novaPoz.S";
_drugakutijapoz = BA.NumberToString(_npt2)+_novapoz.substring(_novapoz.indexOf(";"));
 //BA.debugLineNum = 980;BA.debugLine="ProvjeriIPomakni(staraPoz, novaPoz, drugaKutija";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(_starapoz,_novapoz,_drugakutijapoz,(int) (3));
 break; }
case 4: {
 //BA.debugLineNum = 983;BA.debugLine="NovaIgra";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5();
 break; }
case 5: {
 //BA.debugLineNum = 998;BA.debugLine="If snd Then'Or mjuzaZid.EqualsIgnoreCase(\"true\"";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0) { 
 //BA.debugLineNum = 999;BA.debugLine="snd = False";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1000;BA.debugLine="btnSound.SetBackgroundImage(LoadBitmap(File.Di";
mostCurrent._btnsound.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"s_off.png").getObject()));
 }else {
 //BA.debugLineNum = 1006;BA.debugLine="snd = True";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 1007;BA.debugLine="btnSound.SetBackgroundImage(LoadBitmap(File.Di";
mostCurrent._btnsound.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"s_on.png").getObject()));
 };
 //BA.debugLineNum = 1013;BA.debugLine="btnInfo_Click";
_btninfo_click();
 break; }
case 6: {
 //BA.debugLineNum = 1016;BA.debugLine="If rec.IsInitialized Then";
if (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.IsInitialized()) { 
 //BA.debugLineNum = 1017;BA.debugLine="If recB Then";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 1019;BA.debugLine="recB = False";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1020;BA.debugLine="rec.StopRecording";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.StopRecording();
 //BA.debugLineNum = 1021;BA.debugLine="btnRec.SetBackgroundImage(LoadBitmap(File.Dir";
mostCurrent._btnrec.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"off.png").getObject()));
 }else {
 //BA.debugLineNum = 1026;BA.debugLine="rec.GetPermission";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.GetPermission(processBA);
 //BA.debugLineNum = 1027;BA.debugLine="btnRec.SetBackgroundImage(LoadBitmap(File.Dir";
mostCurrent._btnrec.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"on.png").getObject()));
 };
 };
 //BA.debugLineNum = 1048;BA.debugLine="btnInfo_Click";
_btninfo_click();
 break; }
case 7: {
 //BA.debugLineNum = 1055;BA.debugLine="Dim s As String = rijesenje";
_s = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2;
 //BA.debugLineNum = 1056;BA.debugLine="If s.Length >= 1 Then";
if (_s.length()>=1) { 
 //BA.debugLineNum = 1057;BA.debugLine="Dim s As String = rijesenje.SubString(rijesenj";
_s = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.substring((int) (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.length()-1));
 //BA.debugLineNum = 1058;BA.debugLine="If s.Contains(\"l\") Or s.Contains(\"L\") Then";
if (_s.contains("l") || _s.contains("L")) { 
 //BA.debugLineNum = 1059;BA.debugLine="If s.StartsWith(\"L\") Then	' idemo desno";
if (_s.startsWith("L")) { 
 //BA.debugLineNum = 1060;BA.debugLine="velikoSlovo = True";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 1062;BA.debugLine="velikoSlovo = False";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 1064;BA.debugLine="VratiPotez(\"desno\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4("desno");
 }else if(_s.contains("u") || _s.contains("U")) { 
 //BA.debugLineNum = 1066;BA.debugLine="If s.StartsWith(\"U\") Then	' idemo dole";
if (_s.startsWith("U")) { 
 //BA.debugLineNum = 1067;BA.debugLine="velikoSlovo = True";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 1069;BA.debugLine="velikoSlovo = False";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 1071;BA.debugLine="VratiPotez(\"dole\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4("dole");
 }else if(_s.contains("r") || _s.contains("R")) { 
 //BA.debugLineNum = 1073;BA.debugLine="If s.StartsWith(\"R\") Then	' idemo lijevo";
if (_s.startsWith("R")) { 
 //BA.debugLineNum = 1074;BA.debugLine="velikoSlovo = True";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 1076;BA.debugLine="velikoSlovo = False";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 1078;BA.debugLine="VratiPotez(\"lijevo\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4("lijevo");
 }else if(_s.contains("d") || _s.contains("D")) { 
 //BA.debugLineNum = 1080;BA.debugLine="If s.StartsWith(\"D\") Then	' idemo gore";
if (_s.startsWith("D")) { 
 //BA.debugLineNum = 1081;BA.debugLine="velikoSlovo = True";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 1083;BA.debugLine="velikoSlovo = False";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 1085;BA.debugLine="VratiPotez(\"gore\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4("gore");
 };
 }else {
 //BA.debugLineNum = 1088;BA.debugLine="Msgbox(\"No more moves for undo!\", \"Info\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("No more moves for undo!"),BA.ObjectToCharSequence("Info"),mostCurrent.activityBA);
 };
 break; }
}
;
 //BA.debugLineNum = 1169;BA.debugLine="End Sub";
return "";
}
public static String  _btn_longclick() throws Exception{
anywheresoftware.b4a.objects.ConcreteViewWrapper _send = null;
 //BA.debugLineNum = 2031;BA.debugLine="Sub btn_LongClick";
 //BA.debugLineNum = 2032;BA.debugLine="Dim send As View";
_send = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
 //BA.debugLineNum = 2034;BA.debugLine="send = Sender";
_send.setObject((android.view.View)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 2035;BA.debugLine="Select send.Tag";
switch (BA.switchObjectToInt(_send.getTag(),(Object)("sound"),(Object)("record"),(Object)("reset"),(Object)("natrag"))) {
case 0: {
 //BA.debugLineNum = 2038;BA.debugLine="Msgbox(\"Sound on/off\", \"Info\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Sound on/off"),BA.ObjectToCharSequence("Info"),mostCurrent.activityBA);
 break; }
case 1: {
 //BA.debugLineNum = 2041;BA.debugLine="Msgbox(\"Record on/off\", \"Info\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Record on/off"),BA.ObjectToCharSequence("Info"),mostCurrent.activityBA);
 break; }
case 2: {
 //BA.debugLineNum = 2044;BA.debugLine="Msgbox(\"Reset level\", \"Info\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Reset level"),BA.ObjectToCharSequence("Info"),mostCurrent.activityBA);
 break; }
case 3: {
 //BA.debugLineNum = 2046;BA.debugLine="Msgbox(\"Undo move\", \"Info\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Undo move"),BA.ObjectToCharSequence("Info"),mostCurrent.activityBA);
 break; }
}
;
 //BA.debugLineNum = 2051;BA.debugLine="End Sub";
return "";
}
public static String  _btninfo_click() throws Exception{
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
 //BA.debugLineNum = 1920;BA.debugLine="Sub btnInfo_Click";
 //BA.debugLineNum = 1921;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 1923;BA.debugLine="pnlInfo.RequestFocus";
mostCurrent._pnlinfo.RequestFocus();
 //BA.debugLineNum = 1925;BA.debugLine="If pnl_info_vidljiv Then";
if (_pnl_info_vidljiv) { 
 //BA.debugLineNum = 1927;BA.debugLine="pnlInfo.SetLayoutAnimated(500, (100%x - pnlInfo.";
mostCurrent._pnlinfo.SetLayoutAnimated((int) (500),(int) ((anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-mostCurrent._pnlinfo.getWidth())/(double)2),(int) (-(mostCurrent._pnlinfo.getHeight())+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (8),mostCurrent.activityBA)),mostCurrent._pnlinfo.getWidth(),mostCurrent._pnlinfo.getHeight());
 //BA.debugLineNum = 1928;BA.debugLine="pnl_info_vidljiv = False";
_pnl_info_vidljiv = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1929;BA.debugLine="cd.Initialize(Colors.ARGB(0, 0, 0, 0), 0)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)),(int) (0));
 //BA.debugLineNum = 1930;BA.debugLine="pnlInfo.Background = cd";
mostCurrent._pnlinfo.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 }else {
 //BA.debugLineNum = 1933;BA.debugLine="pnlInfo.SetLayoutAnimated(500, (100%x - pnlInfo.";
mostCurrent._pnlinfo.SetLayoutAnimated((int) (500),(int) ((anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-mostCurrent._pnlinfo.getWidth())/(double)2),(int) (0),mostCurrent._pnlinfo.getWidth(),mostCurrent._pnlinfo.getHeight());
 //BA.debugLineNum = 1934;BA.debugLine="pnl_info_vidljiv = True";
_pnl_info_vidljiv = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 1935;BA.debugLine="cd.Initialize(Colors.ARGB(128, 0, 0, 255), 0)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (128),(int) (0),(int) (0),(int) (255)),(int) (0));
 //BA.debugLineNum = 1936;BA.debugLine="pnlInfo.Background = cd";
mostCurrent._pnlinfo.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 };
 //BA.debugLineNum = 1938;BA.debugLine="End Sub";
return "";
}
public static String  _btnok_click() throws Exception{
 //BA.debugLineNum = 2093;BA.debugLine="Sub btnOK_Click";
 //BA.debugLineNum = 2094;BA.debugLine="Log(rijesenje)";
anywheresoftware.b4a.keywords.Common.LogImpl("66488065",mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2,0);
 //BA.debugLineNum = 2095;BA.debugLine="rijesenje = \"\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = "";
 //BA.debugLineNum = 2096;BA.debugLine="Log(razina)";
anywheresoftware.b4a.keywords.Common.LogImpl("66488067",BA.NumberToString(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5),0);
 //BA.debugLineNum = 2097;BA.debugLine="razina = razina + 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5+1);
 //BA.debugLineNum = 2098;BA.debugLine="If razina = ukupno_razina Then";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5==_ukupno_razina) { 
 //BA.debugLineNum = 2099;BA.debugLine="If snd Then'Or mjuzaZid.EqualsIgnoreCase(\"true\")";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0) { 
 //BA.debugLineNum = 2100;BA.debugLine="sounds.Play(bounceId4, 1, 1, 1, 0, 1)";
_vv5.Play(_vvv1,(float) (1),(float) (1),(int) (1),(int) (0),(float) (1));
 };
 //BA.debugLineNum = 2102;BA.debugLine="Msgbox(\"All levels solved\", \"Congratulations\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("All levels solved"),BA.ObjectToCharSequence("Congratulations"),mostCurrent.activityBA);
 //BA.debugLineNum = 2104;BA.debugLine="Timer5.Enabled = False";
_vv4.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2106;BA.debugLine="panelGotovo.RemoveView";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.RemoveView();
 //BA.debugLineNum = 2107;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 }else {
 //BA.debugLineNum = 2110;BA.debugLine="Timer5.Enabled = False";
_vv4.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 2112;BA.debugLine="panelGotovo.RemoveView";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.RemoveView();
 //BA.debugLineNum = 2113;BA.debugLine="Log(\"btnOK_Click: \" & razina)";
anywheresoftware.b4a.keywords.Common.LogImpl("66488084","btnOK_Click: "+BA.NumberToString(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5),0);
 //BA.debugLineNum = 2115;BA.debugLine="izgRazineOdIndeksaPoc = izgRazineDoIndeksaKraj +";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0+1);
 //BA.debugLineNum = 2116;BA.debugLine="izgRazineDoIndeksaKraj = izgRazineDoIndeksaKraj";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0+(double)(BA.ObjectToNumber(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Get(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5))));
 //BA.debugLineNum = 2117;BA.debugLine="KreirajNivo";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1();
 };
 //BA.debugLineNum = 2119;BA.debugLine="End Sub";
return "";
}
public static int  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7() throws Exception{
anywheresoftware.b4a.phone.Phone _p = null;
 //BA.debugLineNum = 1881;BA.debugLine="Sub GetSDK() As Int";
 //BA.debugLineNum = 1882;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 1884;BA.debugLine="Return p.SdkVersion";
if (true) return _p.getSdkVersion();
 //BA.debugLineNum = 1885;BA.debugLine="End Sub";
return 0;
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1() throws Exception{
anywheresoftware.b4a.objects.collections.Map _versions = null;
anywheresoftware.b4a.phone.Phone _p = null;
 //BA.debugLineNum = 1887;BA.debugLine="Sub GetSDKversion() As String";
 //BA.debugLineNum = 1888;BA.debugLine="Dim versions As Map";
_versions = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 1890;BA.debugLine="versions.Initialize";
_versions.Initialize();
 //BA.debugLineNum = 1891;BA.debugLine="versions.Put(3,\"1.5\")";
_versions.Put((Object)(3),(Object)("1.5"));
 //BA.debugLineNum = 1892;BA.debugLine="versions.Put(4,\"1.6\")";
_versions.Put((Object)(4),(Object)("1.6"));
 //BA.debugLineNum = 1893;BA.debugLine="versions.Put(7,\"2.1\")";
_versions.Put((Object)(7),(Object)("2.1"));
 //BA.debugLineNum = 1894;BA.debugLine="versions.Put(8,\"2.2\")";
_versions.Put((Object)(8),(Object)("2.2"));
 //BA.debugLineNum = 1895;BA.debugLine="versions.Put(10,\"2.3.3\")";
_versions.Put((Object)(10),(Object)("2.3.3"));
 //BA.debugLineNum = 1896;BA.debugLine="versions.Put(11,\"3.0\")";
_versions.Put((Object)(11),(Object)("3.0"));
 //BA.debugLineNum = 1897;BA.debugLine="versions.Put(12,\"3.1\")";
_versions.Put((Object)(12),(Object)("3.1"));
 //BA.debugLineNum = 1898;BA.debugLine="versions.Put(13,\"3.2\")";
_versions.Put((Object)(13),(Object)("3.2"));
 //BA.debugLineNum = 1899;BA.debugLine="versions.Put(14,\"4.0\")";
_versions.Put((Object)(14),(Object)("4.0"));
 //BA.debugLineNum = 1900;BA.debugLine="versions.Put(15,\"4.0.3\")";
_versions.Put((Object)(15),(Object)("4.0.3"));
 //BA.debugLineNum = 1901;BA.debugLine="versions.Put(16,\"4.1.2\")";
_versions.Put((Object)(16),(Object)("4.1.2"));
 //BA.debugLineNum = 1902;BA.debugLine="versions.Put(17,\"4.2.2\")";
_versions.Put((Object)(17),(Object)("4.2.2"));
 //BA.debugLineNum = 1903;BA.debugLine="versions.Put(18,\"4.3\")";
_versions.Put((Object)(18),(Object)("4.3"));
 //BA.debugLineNum = 1904;BA.debugLine="versions.Put(19,\"4.4.2\")";
_versions.Put((Object)(19),(Object)("4.4.2"));
 //BA.debugLineNum = 1905;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 1907;BA.debugLine="Return versions.Get(p.SdkVersion)";
if (true) return BA.ObjectToString(_versions.Get((Object)(_p.getSdkVersion())));
 //BA.debugLineNum = 1908;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 29;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 32;BA.debugLine="Dim tWidth As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = 0;
 //BA.debugLineNum = 33;BA.debugLine="Dim lWidth As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0;
 //BA.debugLineNum = 34;BA.debugLine="Dim pozKutijaMjesta As List";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 35;BA.debugLine="Dim pozKutija As List";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 39;BA.debugLine="Dim brojKoraka, brojGuranja As Int = 0";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = 0;
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = (int) (0);
 //BA.debugLineNum = 40;BA.debugLine="Private lblSteps As Label";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private lblPushes As Label";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private lblCT As Label	' trenutno";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Dim razina As Int = 0";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = (int) (0);
 //BA.debugLineNum = 45;BA.debugLine="Private lblRazina As Label";
mostCurrent._lblrazina = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Dim izgRazineOdIndeksaPoc As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = 0;
 //BA.debugLineNum = 47;BA.debugLine="Dim izgRazineDoIndeksaKraj As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = 0;
 //BA.debugLineNum = 49;BA.debugLine="Dim brJednakihPoz As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0;
 //BA.debugLineNum = 50;BA.debugLine="Dim izgledLevela As List";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 51;BA.debugLine="Dim wLevel, hLevel As List";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = new anywheresoftware.b4a.objects.collections.List();
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 52;BA.debugLine="Dim imeLevela As List";
mostCurrent._vvv4 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 59;BA.debugLine="Dim datZaParsanje As String";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = "";
 //BA.debugLineNum = 60;BA.debugLine="Private PanelI As Panel";
mostCurrent._paneli = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 62;BA.debugLine="Dim sv2d As ScrollView2D";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = new flm.b4a.scrollview2d.ScrollView2DWrapper();
 //BA.debugLineNum = 63;BA.debugLine="Dim brojLevela As Int = 0";
_vvv6 = (int) (0);
 //BA.debugLineNum = 64;BA.debugLine="Dim karta As Map";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 65;BA.debugLine="Dim tempKartaZaNatrag As Map";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 66;BA.debugLine="Dim ukupno_razina As Int = 0";
_ukupno_razina = (int) (0);
 //BA.debugLineNum = 67;BA.debugLine="Dim snd As Boolean = True";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 68;BA.debugLine="Private btnSound As Button";
mostCurrent._btnsound = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 70;BA.debugLine="Dim rec As ScreenRecorder";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = new com.tillekesoft.screenrecorder.B4AScreenRecorder();
 //BA.debugLineNum = 71;BA.debugLine="Dim recB As Boolean = False";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 72;BA.debugLine="Dim DatZaSnimku As String";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = "";
 //BA.debugLineNum = 73;BA.debugLine="Private btnRec As Button";
mostCurrent._btnrec = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 77;BA.debugLine="Dim slijedeci, prethodni As Boolean = False";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = false;
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 83;BA.debugLine="Dim pnl_info_vidljiv As Boolean = False";
_pnl_info_vidljiv = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 84;BA.debugLine="Private pnlInfo As Panel";
mostCurrent._pnlinfo = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 85;BA.debugLine="Private btnInfo As Button";
mostCurrent._btninfo = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 88;BA.debugLine="Dim Azimuth As Float";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = 0f;
 //BA.debugLineNum = 89;BA.debugLine="Dim Pitch As Float";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = 0f;
 //BA.debugLineNum = 90;BA.debugLine="Dim Roll As Float";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = 0f;
 //BA.debugLineNum = 93;BA.debugLine="Dim zid1, kutija1, kutnamj1, mjzakut1, pod1, igr1";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 97;BA.debugLine="Dim ref As Reflector";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 100;BA.debugLine="Private ACTION_DOWN, ACTION_MOVE, ACTION_UP As In";
_action_down = 0;
_action_move = 0;
_action_up = 0;
 //BA.debugLineNum = 102;BA.debugLine="Dim velicinaRetka As List";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 103;BA.debugLine="Private ImageView1 As ImageView";
mostCurrent._imageview1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 104;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 105;BA.debugLine="Dim gif As GifDecoder";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = new anywheresoftware.b4a.agraham.gifdecoder.GifDecoder();
 //BA.debugLineNum = 106;BA.debugLine="Dim Frame As Int";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = 0;
 //BA.debugLineNum = 112;BA.debugLine="Dim panelGotovo As Panel";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 113;BA.debugLine="Dim rijesenje As String";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = "";
 //BA.debugLineNum = 115;BA.debugLine="Dim x3 As Int	' pomak zbog centriranja";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = 0;
 //BA.debugLineNum = 117;BA.debugLine="Dim velikoSlovo As Boolean";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = false;
 //BA.debugLineNum = 121;BA.debugLine="Dim btnNatrag As Button";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
return "";
}
public static int  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2() throws Exception{
int _iks = 0;
String _yx = "";
int _x1 = 0;
 //BA.debugLineNum = 1822;BA.debugLine="Sub IzracunajPozicijuX As Int";
 //BA.debugLineNum = 1823;BA.debugLine="Dim iks As Int : Dim yx As String = karta.Get(\"@\"";
_iks = 0;
 //BA.debugLineNum = 1823;BA.debugLine="Dim iks As Int : Dim yx As String = karta.Get(\"@\"";
_yx = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)("@")));
 //BA.debugLineNum = 1823;BA.debugLine="Dim iks As Int : Dim yx As String = karta.Get(\"@\"";
_x1 = (int)(Double.parseDouble(_yx.substring((int) (_yx.indexOf(";")+1))));
 //BA.debugLineNum = 1825;BA.debugLine="iks = (x1 - 2) * tWidth";
_iks = (int) ((_x1-2)*_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2);
 //BA.debugLineNum = 1829;BA.debugLine="Return iks";
if (true) return _iks;
 //BA.debugLineNum = 1830;BA.debugLine="End Sub";
return 0;
}
public static int  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3() throws Exception{
int _ipsilon = 0;
String _yx = "";
int _y1 = 0;
 //BA.debugLineNum = 1832;BA.debugLine="Sub IzracunajPozicijuY As Int";
 //BA.debugLineNum = 1833;BA.debugLine="Dim ipsilon As Int : Dim yx As String = karta.Get";
_ipsilon = 0;
 //BA.debugLineNum = 1833;BA.debugLine="Dim ipsilon As Int : Dim yx As String = karta.Get";
_yx = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)("@")));
 //BA.debugLineNum = 1833;BA.debugLine="Dim ipsilon As Int : Dim yx As String = karta.Get";
_y1 = (int)(Double.parseDouble(_yx.substring((int) (0),_yx.indexOf(";"))));
 //BA.debugLineNum = 1835;BA.debugLine="ipsilon = (y1 - 2) * tWidth";
_ipsilon = (int) ((_y1-2)*_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2);
 //BA.debugLineNum = 1839;BA.debugLine="Return ipsilon";
if (true) return _ipsilon;
 //BA.debugLineNum = 1840;BA.debugLine="End Sub";
return 0;
}
public static void  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1() throws Exception{
ResumableSub_KreirajNivo rsub = new ResumableSub_KreirajNivo(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_KreirajNivo extends BA.ResumableSub {
public ResumableSub_KreirajNivo(com.stanks.andsokoban_full.play parent) {
this.parent = parent;
}
com.stanks.andsokoban_full.play parent;
int _br = 0;
anywheresoftware.b4a.objects.collections.Map _mopcije = null;
boolean _cb = false;
boolean _rb2 = false;
String _skn = "";
String _zid = "";
String _kutija = "";
String _kutnamj = "";
String _mjzakut = "";
String _pod = "";
String _igr = "";
String _igrnamj = "";
int _lheight = 0;
int _theight = 0;
int _wl = 0;
int _hl = 0;
boolean _imamozid = false;
int _y = 0;
int _x1 = 0;
int _x2 = 0;
int _i = 0;
String _s = "";
String _s1 = "";
int _j = 0;
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
int step124;
int limit124;
int step129;
int limit129;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 405;BA.debugLine="If Activity.NumberOfViews > 0 Then";
if (true) break;

case 1:
//if
this.state = 4;
if (parent.mostCurrent._activity.getNumberOfViews()>0) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 406;BA.debugLine="Activity.RemoveAllViews";
parent.mostCurrent._activity.RemoveAllViews();
 if (true) break;

case 4:
//C
this.state = 5;
;
 //BA.debugLineNum = 409;BA.debugLine="Dim br As Int = Rnd(1,6)";
_br = anywheresoftware.b4a.keywords.Common.Rnd((int) (1),(int) (6));
 //BA.debugLineNum = 410;BA.debugLine="Activity.SetBackgroundImage(LoadBitmap(File.DirAs";
parent.mostCurrent._activity.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"t"+BA.NumberToString(_br)+".png").getObject()));
 //BA.debugLineNum = 412;BA.debugLine="Dim mOpcije As Map";
_mopcije = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 413;BA.debugLine="Dim cb, rb2 As Boolean";
_cb = false;
_rb2 = false;
 //BA.debugLineNum = 414;BA.debugLine="Dim skn As String";
_skn = "";
 //BA.debugLineNum = 416;BA.debugLine="mOpcije = File.ReadMap(Starter.SourceFolder, \"opc";
_mopcije = anywheresoftware.b4a.keywords.Common.File.ReadMap(parent.mostCurrent._vvvvvvv5._vv1,"opcije");
 //BA.debugLineNum = 417;BA.debugLine="cb = mOpcije.Get(\"cb\")";
_cb = BA.ObjectToBoolean(_mopcije.Get((Object)("cb")));
 //BA.debugLineNum = 418;BA.debugLine="rb2 = mOpcije.Get(\"rb2\")";
_rb2 = BA.ObjectToBoolean(_mopcije.Get((Object)("rb2")));
 //BA.debugLineNum = 419;BA.debugLine="skn = mOpcije.Get(\"skin\")";
_skn = BA.ObjectToString(_mopcije.Get((Object)("skin")));
 //BA.debugLineNum = 420;BA.debugLine="Dim zid, kutija, kutnamj, mjzakut, pod, igr, igrn";
_zid = "";
_kutija = "";
_kutnamj = "";
_mjzakut = "";
_pod = "";
_igr = "";
_igrnamj = "";
 //BA.debugLineNum = 421;BA.debugLine="zid = mOpcije.Get(\"zid\")";
_zid = BA.ObjectToString(_mopcije.Get((Object)("zid")));
 //BA.debugLineNum = 422;BA.debugLine="kutija = mOpcije.Get(\"kutija\")";
_kutija = BA.ObjectToString(_mopcije.Get((Object)("kutija")));
 //BA.debugLineNum = 423;BA.debugLine="kutnamj = mOpcije.get(\"kutnamj\")";
_kutnamj = BA.ObjectToString(_mopcije.Get((Object)("kutnamj")));
 //BA.debugLineNum = 424;BA.debugLine="mjzakut = mOpcije.get(\"mjzakut\")";
_mjzakut = BA.ObjectToString(_mopcije.Get((Object)("mjzakut")));
 //BA.debugLineNum = 425;BA.debugLine="pod = mOpcije.get(\"pod\")";
_pod = BA.ObjectToString(_mopcije.Get((Object)("pod")));
 //BA.debugLineNum = 426;BA.debugLine="igr = mOpcije.get(\"igr\")";
_igr = BA.ObjectToString(_mopcije.Get((Object)("igr")));
 //BA.debugLineNum = 427;BA.debugLine="igrnamj = mOpcije.get(\"igrnamj\")";
_igrnamj = BA.ObjectToString(_mopcije.Get((Object)("igrnamj")));
 //BA.debugLineNum = 432;BA.debugLine="If skn.StartsWith(\"1\") Then";
if (true) break;

case 5:
//if
this.state = 46;
if (_skn.startsWith("1")) { 
this.state = 7;
}else {
this.state = 9;
}if (true) break;

case 7:
//C
this.state = 46;
 //BA.debugLineNum = 433;BA.debugLine="zid1 = LoadBitmap(Starter.SourceFolder & \"/skins";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = anywheresoftware.b4a.keywords.Common.LoadBitmap(parent.mostCurrent._vvvvvvv5._vv1+"/skins/"+_skn+"/",_skn.substring((int) (1))+"-wall.png");
 //BA.debugLineNum = 434;BA.debugLine="kutija1 = LoadBitmap(Starter.SourceFolder & \"/sk";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = anywheresoftware.b4a.keywords.Common.LoadBitmap(parent.mostCurrent._vvvvvvv5._vv1+"/skins/"+_skn+"/",_skn.substring((int) (1))+"-box.png");
 //BA.debugLineNum = 435;BA.debugLine="kutnamj1 = LoadBitmap(Starter.SourceFolder & \"/s";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = anywheresoftware.b4a.keywords.Common.LoadBitmap(parent.mostCurrent._vvvvvvv5._vv1+"/skins/"+_skn+"/",_skn.substring((int) (1))+"-box-docked.png");
 //BA.debugLineNum = 436;BA.debugLine="mjzakut1 = LoadBitmap(Starter.SourceFolder & \"/s";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = anywheresoftware.b4a.keywords.Common.LoadBitmap(parent.mostCurrent._vvvvvvv5._vv1+"/skins/"+_skn+"/",_skn.substring((int) (1))+"-dock.png");
 //BA.debugLineNum = 437;BA.debugLine="pod1 = LoadBitmap(Starter.SourceFolder & \"/skins";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = anywheresoftware.b4a.keywords.Common.LoadBitmap(parent.mostCurrent._vvvvvvv5._vv1+"/skins/"+_skn+"/",_skn.substring((int) (1))+"-floor.png");
 //BA.debugLineNum = 438;BA.debugLine="igr1 = LoadBitmap(Starter.SourceFolder & \"/skins";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = anywheresoftware.b4a.keywords.Common.LoadBitmap(parent.mostCurrent._vvvvvvv5._vv1+"/skins/"+_skn+"/",_skn.substring((int) (1))+"-worker.png");
 //BA.debugLineNum = 439;BA.debugLine="igrnamj1 = LoadBitmap(Starter.SourceFolder & \"/s";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = anywheresoftware.b4a.keywords.Common.LoadBitmap(parent.mostCurrent._vvvvvvv5._vv1+"/skins/"+_skn+"/",_skn.substring((int) (1))+"-worker-docked.png");
 if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 442;BA.debugLine="If zid <> \"null\" Then";
if (true) break;

case 10:
//if
this.state = 15;
if ((_zid).equals("null") == false) { 
this.state = 12;
}else {
this.state = 14;
}if (true) break;

case 12:
//C
this.state = 15;
 //BA.debugLineNum = 443;BA.debugLine="zid1 = LoadBitmap(Starter.SourceFolder & \"/skin";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = anywheresoftware.b4a.keywords.Common.LoadBitmap(parent.mostCurrent._vvvvvvv5._vv1+"/skins/"+_skn+"/",_zid);
 if (true) break;

case 14:
//C
this.state = 15;
 //BA.debugLineNum = 445;BA.debugLine="zid1 = LoadBitmap(File.DirAssets, \"zid_2.png\")";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"zid_2.png");
 if (true) break;
;
 //BA.debugLineNum = 447;BA.debugLine="If kutija <> \"null\" Then";

case 15:
//if
this.state = 20;
if ((_kutija).equals("null") == false) { 
this.state = 17;
}else {
this.state = 19;
}if (true) break;

case 17:
//C
this.state = 20;
 //BA.debugLineNum = 448;BA.debugLine="kutija1 = LoadBitmap(Starter.SourceFolder & \"/s";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = anywheresoftware.b4a.keywords.Common.LoadBitmap(parent.mostCurrent._vvvvvvv5._vv1+"/skins/"+_skn+"/",_kutija);
 if (true) break;

case 19:
//C
this.state = 20;
 //BA.debugLineNum = 450;BA.debugLine="kutija1 = LoadBitmap(File.DirAssets, \"kutija_2.";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"kutija_2.png");
 if (true) break;
;
 //BA.debugLineNum = 452;BA.debugLine="If kutnamj <> \"null\" Then";

case 20:
//if
this.state = 25;
if ((_kutnamj).equals("null") == false) { 
this.state = 22;
}else {
this.state = 24;
}if (true) break;

case 22:
//C
this.state = 25;
 //BA.debugLineNum = 453;BA.debugLine="kutnamj1 = LoadBitmap(Starter.SourceFolder & \"/";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = anywheresoftware.b4a.keywords.Common.LoadBitmap(parent.mostCurrent._vvvvvvv5._vv1+"/skins/"+_skn+"/",_kutnamj);
 if (true) break;

case 24:
//C
this.state = 25;
 //BA.debugLineNum = 455;BA.debugLine="kutnamj1 = LoadBitmap(File.DirAssets, \"kutija_n";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"kutija_na_mjestu_2.png");
 if (true) break;
;
 //BA.debugLineNum = 457;BA.debugLine="If mjzakut <> \"null\" Then";

case 25:
//if
this.state = 30;
if ((_mjzakut).equals("null") == false) { 
this.state = 27;
}else {
this.state = 29;
}if (true) break;

case 27:
//C
this.state = 30;
 //BA.debugLineNum = 458;BA.debugLine="mjzakut1 = LoadBitmap(Starter.SourceFolder & \"/";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = anywheresoftware.b4a.keywords.Common.LoadBitmap(parent.mostCurrent._vvvvvvv5._vv1+"/skins/"+_skn+"/",_mjzakut);
 if (true) break;

case 29:
//C
this.state = 30;
 //BA.debugLineNum = 460;BA.debugLine="mjzakut1 = LoadBitmap(File.DirAssets, \"iks_2.pn";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"iks_2.png");
 if (true) break;
;
 //BA.debugLineNum = 462;BA.debugLine="If pod <> \"null\" Then";

case 30:
//if
this.state = 35;
if ((_pod).equals("null") == false) { 
this.state = 32;
}else {
this.state = 34;
}if (true) break;

case 32:
//C
this.state = 35;
 //BA.debugLineNum = 463;BA.debugLine="pod1 = LoadBitmap(Starter.SourceFolder & \"/skin";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = anywheresoftware.b4a.keywords.Common.LoadBitmap(parent.mostCurrent._vvvvvvv5._vv1+"/skins/"+_skn+"/",_pod);
 if (true) break;

case 34:
//C
this.state = 35;
 //BA.debugLineNum = 465;BA.debugLine="pod1 = LoadBitmap(File.DirAssets, \"pod.png\")";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"pod.png");
 if (true) break;
;
 //BA.debugLineNum = 467;BA.debugLine="If igr <> \"null\" Then";

case 35:
//if
this.state = 40;
if ((_igr).equals("null") == false) { 
this.state = 37;
}else {
this.state = 39;
}if (true) break;

case 37:
//C
this.state = 40;
 //BA.debugLineNum = 468;BA.debugLine="igr1 = LoadBitmap(Starter.SourceFolder & \"/skin";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = anywheresoftware.b4a.keywords.Common.LoadBitmap(parent.mostCurrent._vvvvvvv5._vv1+"/skins/"+_skn+"/",_igr);
 if (true) break;

case 39:
//C
this.state = 40;
 //BA.debugLineNum = 470;BA.debugLine="igr1 = LoadBitmap(File.DirAssets, \"igrac2.png\")";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"igrac2.png");
 if (true) break;
;
 //BA.debugLineNum = 472;BA.debugLine="If igrnamj <> \"null\" Then";

case 40:
//if
this.state = 45;
if ((_igrnamj).equals("null") == false) { 
this.state = 42;
}else {
this.state = 44;
}if (true) break;

case 42:
//C
this.state = 45;
 //BA.debugLineNum = 473;BA.debugLine="igrnamj1 = LoadBitmap(Starter.SourceFolder & \"/";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = anywheresoftware.b4a.keywords.Common.LoadBitmap(parent.mostCurrent._vvvvvvv5._vv1+"/skins/"+_skn+"/",_igrnamj);
 if (true) break;

case 44:
//C
this.state = 45;
 //BA.debugLineNum = 475;BA.debugLine="igrnamj1 = LoadBitmap(File.DirAssets, \"igrac2.p";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"igrac2.png");
 if (true) break;

case 45:
//C
this.state = 46;
;
 if (true) break;

case 46:
//C
this.state = 47;
;
 //BA.debugLineNum = 487;BA.debugLine="sv2d.Initialize(100%x, 100%y, \"sv2d\")";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Initialize(mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA),"sv2d");
 //BA.debugLineNum = 489;BA.debugLine="ref.Target = sv2d";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Target = (Object)(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.getObject());
 //BA.debugLineNum = 490;BA.debugLine="ref.SetOnTouchListener(\"sv2d_Touch\")";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.SetOnTouchListener(processBA,"sv2d_Touch");
 //BA.debugLineNum = 491;BA.debugLine="ACTION_DOWN = Activity.ACTION_DOWN";
parent._action_down = parent.mostCurrent._activity.ACTION_DOWN;
 //BA.debugLineNum = 513;BA.debugLine="If rb2 Then";
if (true) break;

case 47:
//if
this.state = 58;
if (_rb2) { 
this.state = 49;
}else {
this.state = 57;
}if (true) break;

case 49:
//C
this.state = 50;
 //BA.debugLineNum = 514;BA.debugLine="Activity.AddView(sv2d, 0, 0, 100%x, 100%y)";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 515;BA.debugLine="Activity.LoadLayout(\"igra_scv\")";
parent.mostCurrent._activity.LoadLayout("igra_scv",mostCurrent.activityBA);
 //BA.debugLineNum = 516;BA.debugLine="If cb Then";
if (true) break;

case 50:
//if
this.state = 55;
if (_cb) { 
this.state = 52;
}else {
this.state = 54;
}if (true) break;

case 52:
//C
this.state = 55;
 //BA.debugLineNum = 518;BA.debugLine="PanelI.Left = 0";
parent.mostCurrent._paneli.setLeft((int) (0));
 //BA.debugLineNum = 519;BA.debugLine="PanelI.Top = 48%y";
parent.mostCurrent._paneli.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (48),mostCurrent.activityBA));
 if (true) break;

case 54:
//C
this.state = 55;
 //BA.debugLineNum = 523;BA.debugLine="PanelI.Left = 100%x - PanelI.Width";
parent.mostCurrent._paneli.setLeft((int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-parent.mostCurrent._paneli.getWidth()));
 //BA.debugLineNum = 524;BA.debugLine="PanelI.Top = 48%y";
parent.mostCurrent._paneli.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (48),mostCurrent.activityBA));
 if (true) break;

case 55:
//C
this.state = 58;
;
 if (true) break;

case 57:
//C
this.state = 58;
 //BA.debugLineNum = 528;BA.debugLine="Activity.AddView(sv2d, 0, 0, 100%x, 100%y)";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 if (true) break;

case 58:
//C
this.state = 59;
;
 //BA.debugLineNum = 531;BA.debugLine="btnNatrag.Initialize(\"btn\")";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.Initialize(mostCurrent.activityBA,"btn");
 //BA.debugLineNum = 532;BA.debugLine="btnNatrag.Tag = \"natrag\"";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.setTag((Object)("natrag"));
 //BA.debugLineNum = 533;BA.debugLine="btnNatrag.Gravity = Gravity.FILL";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 534;BA.debugLine="btnNatrag.SetBackgroundImage(LoadBitmap(File.DirA";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"z_undo.png").getObject()));
 //BA.debugLineNum = 535;BA.debugLine="btnNatrag.BringToFront";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.BringToFront();
 //BA.debugLineNum = 536;BA.debugLine="btnNatrag.Visible = True";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 537;BA.debugLine="Activity.AddView(btnNatrag, 100%x - 11%x, 1%x, 10";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getObject()),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (11),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 540;BA.debugLine="pozKutijaMjesta.Initialize";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Initialize();
 //BA.debugLineNum = 545;BA.debugLine="pozKutija.Initialize";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Initialize();
 //BA.debugLineNum = 547;BA.debugLine="karta.Initialize";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Initialize();
 //BA.debugLineNum = 548;BA.debugLine="tempKartaZaNatrag.Initialize";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Initialize();
 //BA.debugLineNum = 562;BA.debugLine="lWidth = wLevel.Get(razina)";
parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = (int)(BA.ObjectToNumber(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Get(parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5)));
 //BA.debugLineNum = 563;BA.debugLine="Dim lHeight As Int = hLevel.Get(razina)";
_lheight = (int)(BA.ObjectToNumber(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Get(parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5)));
 //BA.debugLineNum = 565;BA.debugLine="tWidth = 100%x / lWidth";
parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = (int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)/(double)parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3);
 //BA.debugLineNum = 569;BA.debugLine="Dim tHeight As Int = 100%y / lHeight";
_theight = (int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)/(double)_lheight);
 //BA.debugLineNum = 570;BA.debugLine="If tWidth > tHeight Then";
if (true) break;

case 59:
//if
this.state = 64;
if (parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2>_theight) { 
this.state = 61;
}else {
this.state = 63;
}if (true) break;

case 61:
//C
this.state = 64;
 //BA.debugLineNum = 571;BA.debugLine="tHeight = tWidth";
_theight = parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2;
 if (true) break;

case 63:
//C
this.state = 64;
 //BA.debugLineNum = 573;BA.debugLine="tWidth = tHeight";
parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = _theight;
 if (true) break;
;
 //BA.debugLineNum = 575;BA.debugLine="If tWidth < 60 Or tHeight < 60 Then";

case 64:
//if
this.state = 69;
if (parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2<60 || _theight<60) { 
this.state = 66;
}else if(parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2>200 || _theight>200) { 
this.state = 68;
}if (true) break;

case 66:
//C
this.state = 69;
 //BA.debugLineNum = 576;BA.debugLine="Log(\"<80\")";
anywheresoftware.b4a.keywords.Common.LogImpl("65177518","<80",0);
 //BA.debugLineNum = 577;BA.debugLine="tWidth = 70";
parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = (int) (70);
 //BA.debugLineNum = 578;BA.debugLine="tHeight = 70";
_theight = (int) (70);
 if (true) break;

case 68:
//C
this.state = 69;
 //BA.debugLineNum = 580;BA.debugLine="tWidth = 200";
parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = (int) (200);
 //BA.debugLineNum = 581;BA.debugLine="tHeight = 200";
_theight = (int) (200);
 if (true) break;

case 69:
//C
this.state = 70;
;
 //BA.debugLineNum = 584;BA.debugLine="ukupno_razina = brojLevela";
parent._ukupno_razina = parent._vvv6;
 //BA.debugLineNum = 587;BA.debugLine="velicinaRetka.Initialize";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Initialize();
 //BA.debugLineNum = 589;BA.debugLine="Dim wL As Int = wLevel.Get(razina) : Dim hL As In";
_wl = (int)(BA.ObjectToNumber(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Get(parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5)));
 //BA.debugLineNum = 589;BA.debugLine="Dim wL As Int = wLevel.Get(razina) : Dim hL As In";
_hl = (int)(BA.ObjectToNumber(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Get(parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5)));
 //BA.debugLineNum = 589;BA.debugLine="Dim wL As Int = wLevel.Get(razina) : Dim hL As In";
_imamozid = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 589;BA.debugLine="Dim wL As Int = wLevel.Get(razina) : Dim hL As In";
_y = (int) (0);
 //BA.debugLineNum = 590;BA.debugLine="Dim x1 As Int = 100%x";
_x1 = anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA);
 //BA.debugLineNum = 591;BA.debugLine="Dim x2 As Int = wL * tWidth";
_x2 = (int) (_wl*parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2);
 //BA.debugLineNum = 593;BA.debugLine="If x1 > x2 Then";
if (true) break;

case 70:
//if
this.state = 75;
if (_x1>_x2) { 
this.state = 72;
}else {
this.state = 74;
}if (true) break;

case 72:
//C
this.state = 75;
 //BA.debugLineNum = 594;BA.debugLine="x3 = (100%x - x2) / 2";
parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = (int) ((anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-_x2)/(double)2);
 if (true) break;

case 74:
//C
this.state = 75;
 //BA.debugLineNum = 596;BA.debugLine="x3 = 0";
parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = (int) (0);
 if (true) break;
;
 //BA.debugLineNum = 598;BA.debugLine="For i = izgRazineOdIndeksaPoc To izgRazineDoIndek";

case 75:
//for
this.state = 114;
step124 = 1;
limit124 = parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0;
_i = parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 ;
this.state = 133;
if (true) break;

case 133:
//C
this.state = 114;
if ((step124 > 0 && _i <= limit124) || (step124 < 0 && _i >= limit124)) this.state = 77;
if (true) break;

case 134:
//C
this.state = 133;
_i = ((int)(0 + _i + step124)) ;
if (true) break;

case 77:
//C
this.state = 78;
 //BA.debugLineNum = 601;BA.debugLine="Dim s As String = izgledLevela.Get(izgRazineOdIn";
_s = BA.ObjectToString(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Get((int) (parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7+_y)));
 //BA.debugLineNum = 603;BA.debugLine="Dim s1 As String = s";
_s1 = _s;
 //BA.debugLineNum = 604;BA.debugLine="s1 = s1.Trim";
_s1 = _s1.trim();
 //BA.debugLineNum = 605;BA.debugLine="velicinaRetka.Add(s1.Length)";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Add((Object)(_s1.length()));
 //BA.debugLineNum = 606;BA.debugLine="For j = 0 To s.Length - 1";
if (true) break;

case 78:
//for
this.state = 113;
step129 = 1;
limit129 = (int) (_s.length()-1);
_j = (int) (0) ;
this.state = 135;
if (true) break;

case 135:
//C
this.state = 113;
if ((step129 > 0 && _j <= limit129) || (step129 < 0 && _j >= limit129)) this.state = 80;
if (true) break;

case 136:
//C
this.state = 135;
_j = ((int)(0 + _j + step129)) ;
if (true) break;

case 80:
//C
this.state = 81;
 //BA.debugLineNum = 608;BA.debugLine="Dim s1 As String = s.CharAt(j)";
_s1 = BA.ObjectToString(_s.charAt(_j));
 //BA.debugLineNum = 610;BA.debugLine="If s1.EqualsIgnoreCase(\"#\") Then";
if (true) break;

case 81:
//if
this.state = 112;
if (_s1.equalsIgnoreCase("#")) { 
this.state = 83;
}else if(_s1.equalsIgnoreCase(" ")) { 
this.state = 85;
}else if(_s1.equalsIgnoreCase("$")) { 
this.state = 95;
}else if(_s1.equalsIgnoreCase(".") || _s1.equalsIgnoreCase("*")) { 
this.state = 97;
}else if(_s1.equalsIgnoreCase("@") || _s1.equalsIgnoreCase("+")) { 
this.state = 105;
}if (true) break;

case 83:
//C
this.state = 112;
 //BA.debugLineNum = 611;BA.debugLine="imamoZid = True";
_imamozid = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 612;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 613;BA.debugLine="iv.Initialize(\"\")";
_iv.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 614;BA.debugLine="iv.Tag = \"#\"";
_iv.setTag((Object)("#"));
 //BA.debugLineNum = 615;BA.debugLine="iv.Gravity = Gravity.FILL";
_iv.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 616;BA.debugLine="iv.Bitmap = zid1'LoadBitmap(File.DirAssets, \"z";
_iv.setBitmap((android.graphics.Bitmap)(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.getObject()));
 //BA.debugLineNum = 617;BA.debugLine="sv2d.Panel.AddView(iv, j*tWidth+x3, y*tWidth,";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.getPanel().AddView((android.view.View)(_iv.getObject()),(int) (_j*parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0),(int) (_y*parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2),parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2,_theight);
 //BA.debugLineNum = 618;BA.debugLine="karta.Put(y & \";\" & j, iv)";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)),(Object)(_iv.getObject()));
 //BA.debugLineNum = 619;BA.debugLine="tempKartaZaNatrag.Put(y & \";\" & j, \"#\")";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)),(Object)("#"));
 if (true) break;

case 85:
//C
this.state = 86;
 //BA.debugLineNum = 624;BA.debugLine="If imamoZid Then";
if (true) break;

case 86:
//if
this.state = 93;
if (_imamozid) { 
this.state = 88;
}if (true) break;

case 88:
//C
this.state = 89;
 //BA.debugLineNum = 625;BA.debugLine="If y > 0 And y < hL - 1 Then";
if (true) break;

case 89:
//if
this.state = 92;
if (_y>0 && _y<_hl-1) { 
this.state = 91;
}if (true) break;

case 91:
//C
this.state = 92;
 //BA.debugLineNum = 626;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 627;BA.debugLine="iv.Initialize(\"\")";
_iv.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 628;BA.debugLine="iv.Tag = \"_\"";
_iv.setTag((Object)("_"));
 //BA.debugLineNum = 629;BA.debugLine="iv.Gravity = Gravity.FILL";
_iv.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 630;BA.debugLine="iv.Bitmap = pod1";
_iv.setBitmap((android.graphics.Bitmap)(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getObject()));
 //BA.debugLineNum = 631;BA.debugLine="sv2d.Panel.AddView(iv, j*tWidth+x3, y*tWidth";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.getPanel().AddView((android.view.View)(_iv.getObject()),(int) (_j*parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0),(int) (_y*parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2),parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2,_theight);
 //BA.debugLineNum = 632;BA.debugLine="karta.Put(y & \";\" & j, iv)";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)),(Object)(_iv.getObject()));
 //BA.debugLineNum = 633;BA.debugLine="tempKartaZaNatrag.Put(y & \";\" & j, \"_\")";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)),(Object)("_"));
 if (true) break;

case 92:
//C
this.state = 93;
;
 if (true) break;

case 93:
//C
this.state = 112;
;
 if (true) break;

case 95:
//C
this.state = 112;
 //BA.debugLineNum = 649;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 650;BA.debugLine="iv.Initialize(\"\")";
_iv.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 651;BA.debugLine="iv.Tag = \"$\"";
_iv.setTag((Object)("$"));
 //BA.debugLineNum = 652;BA.debugLine="iv.Gravity = Gravity.FILL";
_iv.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 653;BA.debugLine="iv.Bitmap = kutija1'LoadBitmap(File.DirAssets,";
_iv.setBitmap((android.graphics.Bitmap)(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getObject()));
 //BA.debugLineNum = 657;BA.debugLine="pozKutija.Add(y & \";\" & j)";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Add((Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)));
 //BA.debugLineNum = 658;BA.debugLine="karta.Put(y & \";\" & j, iv)";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)),(Object)(_iv.getObject()));
 //BA.debugLineNum = 659;BA.debugLine="tempKartaZaNatrag.Put(y & \";\" & j, \"$\")";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)),(Object)("$"));
 //BA.debugLineNum = 661;BA.debugLine="sv2d.Panel.AddView(iv, j*tWidth+x3, y*tWidth,";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.getPanel().AddView((android.view.View)(_iv.getObject()),(int) (_j*parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0),(int) (_y*parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2),parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2,_theight);
 if (true) break;

case 97:
//C
this.state = 98;
 //BA.debugLineNum = 673;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 674;BA.debugLine="iv.Initialize(\"\")";
_iv.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 675;BA.debugLine="If s1.EqualsIgnoreCase(\"*\") Then";
if (true) break;

case 98:
//if
this.state = 103;
if (_s1.equalsIgnoreCase("*")) { 
this.state = 100;
}else if(_s1.equalsIgnoreCase(".")) { 
this.state = 102;
}if (true) break;

case 100:
//C
this.state = 103;
 //BA.debugLineNum = 676;BA.debugLine="iv.Tag = \"*\"";
_iv.setTag((Object)("*"));
 //BA.debugLineNum = 677;BA.debugLine="iv.Gravity = Gravity.FILL";
_iv.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 678;BA.debugLine="iv.Bitmap = kutnamj1'LoadBitmap(File.DirAsset";
_iv.setBitmap((android.graphics.Bitmap)(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.getObject()));
 //BA.debugLineNum = 681;BA.debugLine="pozKutija.Add(y & \";\" & j)";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Add((Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)));
 //BA.debugLineNum = 682;BA.debugLine="pozKutijaMjesta.Add(y & \";\" & j)";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Add((Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)));
 //BA.debugLineNum = 683;BA.debugLine="karta.Put(y & \";\" & j, iv)";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)),(Object)(_iv.getObject()));
 //BA.debugLineNum = 684;BA.debugLine="tempKartaZaNatrag.put(y & \";\" & j, \"*\")";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)),(Object)("*"));
 if (true) break;

case 102:
//C
this.state = 103;
 //BA.debugLineNum = 698;BA.debugLine="iv.Tag = \".\"";
_iv.setTag((Object)("."));
 //BA.debugLineNum = 699;BA.debugLine="iv.Gravity = Gravity.FILL";
_iv.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 700;BA.debugLine="iv.Bitmap = mjzakut1'LoadBitmap(File.DirAsset";
_iv.setBitmap((android.graphics.Bitmap)(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getObject()));
 //BA.debugLineNum = 701;BA.debugLine="pozKutijaMjesta.Add(y & \";\" & j)";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Add((Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)));
 //BA.debugLineNum = 702;BA.debugLine="karta.Put(y & \";\" & j, iv)";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)),(Object)(_iv.getObject()));
 //BA.debugLineNum = 703;BA.debugLine="tempKartaZaNatrag.Put(y & \";\" & j, \".\")";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)),(Object)("."));
 if (true) break;

case 103:
//C
this.state = 112;
;
 //BA.debugLineNum = 707;BA.debugLine="sv2d.Panel.AddView(iv, j*tWidth+x3, y*tWidth,";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.getPanel().AddView((android.view.View)(_iv.getObject()),(int) (_j*parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0),(int) (_y*parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2),parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2,_theight);
 if (true) break;

case 105:
//C
this.state = 106;
 //BA.debugLineNum = 711;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 712;BA.debugLine="iv.Initialize(\"\")";
_iv.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 713;BA.debugLine="iv.Gravity = Gravity.FILL";
_iv.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 714;BA.debugLine="iv.Bitmap = igr1'LoadBitmap(File.DirAssets, \"i";
_iv.setBitmap((android.graphics.Bitmap)(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.getObject()));
 //BA.debugLineNum = 715;BA.debugLine="If s1.EqualsIgnoreCase(\"@\") Then";
if (true) break;

case 106:
//if
this.state = 111;
if (_s1.equalsIgnoreCase("@")) { 
this.state = 108;
}else if(_s1.equalsIgnoreCase("+")) { 
this.state = 110;
}if (true) break;

case 108:
//C
this.state = 111;
 //BA.debugLineNum = 716;BA.debugLine="iv.Tag = \"_\"";
_iv.setTag((Object)("_"));
 //BA.debugLineNum = 722;BA.debugLine="karta.Put(\"@\", y & \";\" & j)";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)("@"),(Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)));
 //BA.debugLineNum = 723;BA.debugLine="karta.Put(y & \";\" & j, iv)";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)),(Object)(_iv.getObject()));
 //BA.debugLineNum = 724;BA.debugLine="tempKartaZaNatrag.Put(y & \";\" & j, \"_\")";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)),(Object)("_"));
 if (true) break;

case 110:
//C
this.state = 111;
 //BA.debugLineNum = 742;BA.debugLine="iv.Tag = \".\"";
_iv.setTag((Object)("."));
 //BA.debugLineNum = 747;BA.debugLine="pozKutijaMjesta.Add(y & \";\" & j)";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Add((Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)));
 //BA.debugLineNum = 749;BA.debugLine="karta.Put(\"@\", y & \";\" & j)";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)("@"),(Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)));
 //BA.debugLineNum = 750;BA.debugLine="karta.Put(y & \";\" & j, iv)";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)),(Object)(_iv.getObject()));
 //BA.debugLineNum = 751;BA.debugLine="tempKartaZaNatrag.put(y & \";\" & j, \".\")";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)(BA.NumberToString(_y)+";"+BA.NumberToString(_j)),(Object)("."));
 if (true) break;

case 111:
//C
this.state = 112;
;
 //BA.debugLineNum = 772;BA.debugLine="sv2d.Panel.AddView(iv, j*tWidth+x3, y*tWidth,";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.getPanel().AddView((android.view.View)(_iv.getObject()),(int) (_j*parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0),(int) (_y*parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2),parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2,_theight);
 if (true) break;

case 112:
//C
this.state = 136;
;
 if (true) break;
if (true) break;

case 113:
//C
this.state = 134;
;
 //BA.debugLineNum = 775;BA.debugLine="y = y + 1";
_y = (int) (_y+1);
 //BA.debugLineNum = 776;BA.debugLine="imamoZid = False";
_imamozid = anywheresoftware.b4a.keywords.Common.False;
 if (true) break;
if (true) break;

case 114:
//C
this.state = 115;
;
 //BA.debugLineNum = 783;BA.debugLine="sv2d.Panel.Height = tWidth * hL";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.getPanel().setHeight((int) (parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2*_hl));
 //BA.debugLineNum = 784;BA.debugLine="If x1 > x2 Then";
if (true) break;

case 115:
//if
this.state = 120;
if (_x1>_x2) { 
this.state = 117;
}else {
this.state = 119;
}if (true) break;

case 117:
//C
this.state = 120;
 //BA.debugLineNum = 785;BA.debugLine="sv2d.Panel.Width = 100%x";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.getPanel().setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 if (true) break;

case 119:
//C
this.state = 120;
 //BA.debugLineNum = 787;BA.debugLine="sv2d.Panel.Width = tWidth * wL";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.getPanel().setWidth((int) (parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2*_wl));
 if (true) break;

case 120:
//C
this.state = 121;
;
 //BA.debugLineNum = 792;BA.debugLine="Dim s As String = imeLevela.Get(razina)";
_s = BA.ObjectToString(parent.mostCurrent._vvv4.Get(parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5));
 //BA.debugLineNum = 798;BA.debugLine="Sleep(0)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (0));
this.state = 137;
return;
case 137:
//C
this.state = 121;
;
 //BA.debugLineNum = 799;BA.debugLine="sv2d.SmoothScrollTo(IzracunajPozicijuX, Izracunaj";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.SmoothScrollTo(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2(),_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3());
 //BA.debugLineNum = 801;BA.debugLine="Activity.LoadLayout(\"info_panel\")";
parent.mostCurrent._activity.LoadLayout("info_panel",mostCurrent.activityBA);
 //BA.debugLineNum = 802;BA.debugLine="If rec.IsInitialized Then";
if (true) break;

case 121:
//if
this.state = 126;
if (parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.IsInitialized()) { 
this.state = 123;
}else {
this.state = 125;
}if (true) break;

case 123:
//C
this.state = 126;
 //BA.debugLineNum = 803;BA.debugLine="btnRec.Enabled = True";
parent.mostCurrent._btnrec.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 125:
//C
this.state = 126;
 //BA.debugLineNum = 805;BA.debugLine="btnRec.Enabled = False";
parent.mostCurrent._btnrec.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 126:
//C
this.state = 127;
;
 //BA.debugLineNum = 807;BA.debugLine="pnlInfo.Top = -(pnlInfo.Height) + 8%x";
parent.mostCurrent._pnlinfo.setTop((int) (-(parent.mostCurrent._pnlinfo.getHeight())+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (8),mostCurrent.activityBA)));
 //BA.debugLineNum = 808;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 809;BA.debugLine="cd.Initialize(Colors.ARGB(0, 0, 0, 0), 0)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (0),(int) (0),(int) (0)),(int) (0));
 //BA.debugLineNum = 810;BA.debugLine="pnlInfo.Background = cd";
parent.mostCurrent._pnlinfo.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 812;BA.debugLine="If snd Then' Or mjuzaZid.EqualsIgnoreCase(\"true\")";
if (true) break;

case 127:
//if
this.state = 132;
if (parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0) { 
this.state = 129;
}else {
this.state = 131;
}if (true) break;

case 129:
//C
this.state = 132;
 //BA.debugLineNum = 813;BA.debugLine="btnSound.SetBackgroundImage(LoadBitmap(File.DirA";
parent.mostCurrent._btnsound.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"s_on.png").getObject()));
 if (true) break;

case 131:
//C
this.state = 132;
 //BA.debugLineNum = 815;BA.debugLine="btnSound.SetBackgroundImage(LoadBitmap(File.DirA";
parent.mostCurrent._btnsound.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"s_off.png").getObject()));
 if (true) break;

case 132:
//C
this.state = -1;
;
 //BA.debugLineNum = 818;BA.debugLine="brojKoraka = 0";
parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = (int) (0);
 //BA.debugLineNum = 819;BA.debugLine="lblSteps.Initialize(\"\")";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 820;BA.debugLine="lblSteps.Text = \"Steps: \" & brojKoraka";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.setText(BA.ObjectToCharSequence("Steps: "+BA.NumberToString(parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6)));
 //BA.debugLineNum = 822;BA.debugLine="lblSteps.TextColor = Colors.Red";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 823;BA.debugLine="Activity.AddView(lblSteps, 0, 0, 15%x, 10%y)";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 824;BA.debugLine="SetLabelTextSize(lblSteps, lblSteps.Text, 28, 10)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0,parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getText(),(float) (28),(float) (10));
 //BA.debugLineNum = 827;BA.debugLine="lblRazina.Text = s & CRLF & \"Finished: \" & razina";
parent.mostCurrent._lblrazina.setText(BA.ObjectToCharSequence(_s+anywheresoftware.b4a.keywords.Common.CRLF+"Finished: "+BA.NumberToString(parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5)+"/"+BA.NumberToString(parent._ukupno_razina)));
 //BA.debugLineNum = 828;BA.debugLine="SetLabelTextSize(lblRazina, lblRazina.Text, 28, 8";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3(parent.mostCurrent._lblrazina,parent.mostCurrent._lblrazina.getText(),(float) (28),(float) (8));
 //BA.debugLineNum = 830;BA.debugLine="brojGuranja = 0";
parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = (int) (0);
 //BA.debugLineNum = 831;BA.debugLine="lblPushes.Initialize(\"\")";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 832;BA.debugLine="lblPushes.Text = \"Pushes: \" & brojGuranja";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.setText(BA.ObjectToCharSequence("Pushes: "+BA.NumberToString(parent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7)));
 //BA.debugLineNum = 833;BA.debugLine="lblPushes.TextColor = Colors.Cyan";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Cyan);
 //BA.debugLineNum = 834;BA.debugLine="Activity.AddView(lblPushes, 0, 10%y, 15%x, 10%y)";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 835;BA.debugLine="SetLabelTextSize(lblPushes, lblPushes.Text, 28, 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1,parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getText(),(float) (28),(float) (10));
 //BA.debugLineNum = 840;BA.debugLine="lblCT.Initialize(\"\")";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 841;BA.debugLine="lblCT.TextColor = Colors.Red";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 842;BA.debugLine="Activity.AddView(lblCT, 2%x, 100%y - 20%y, 20%x,";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (20),mostCurrent.activityBA)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (20),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 843;BA.debugLine="lblCT.Typeface = Typeface.DEFAULT_BOLD";
parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
 //BA.debugLineNum = 844;BA.debugLine="SetLabelTextSize(lblCT, lblCT.Text, 50, 10)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3(parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2,parent.mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.getText(),(float) (50),(float) (10));
 //BA.debugLineNum = 845;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5() throws Exception{
int _res = 0;
anywheresoftware.b4a.sql.SQL.CursorWrapper _curs = null;
String _datzaparsanjer = "";
String _q = "";
int _i = 0;
int _od = 0;
int _doo = 0;
 //BA.debugLineNum = 274;BA.debugLine="Sub NovaIgra";
 //BA.debugLineNum = 282;BA.debugLine="If File.Exists(Starter.SourceFolder, Main.ime_dat";
if (anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._vvvvvvv5._vv1,mostCurrent._vvvvvvv4._ime_datoteke_za_info+".info")) { 
 //BA.debugLineNum = 283;BA.debugLine="Log(\"play -> NovaIgra -> UcitajInfo -> učitava s";
anywheresoftware.b4a.keywords.Common.LogImpl("64915209","play -> NovaIgra -> UcitajInfo -> učitava se info o tome koliko je nivoa odigrano za paket nivoa!",0);
 //BA.debugLineNum = 284;BA.debugLine="UcitajInfo";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4();
 //BA.debugLineNum = 285;BA.debugLine="If razina = ukupno_razina Then";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5==_ukupno_razina) { 
 //BA.debugLineNum = 286;BA.debugLine="Dim res As Int = Msgbox2(\"You already played al";
_res = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("You already played all levels from this package."+anywheresoftware.b4a.keywords.Common.CRLF+"If you want to play again delete stats in the levels package list!"),BA.ObjectToCharSequence("Info"),"OK","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 288;BA.debugLine="If res = DialogResponse.POSITIVE Then Activity.";
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
mostCurrent._activity.Finish();};
 }else {
 //BA.debugLineNum = 290;BA.debugLine="Dim curs As Cursor";
_curs = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 291;BA.debugLine="Dim datZaParsanjeR As String";
_datzaparsanjer = "";
 //BA.debugLineNum = 292;BA.debugLine="Dim q As String = \"SELECT datoteka FROM \" & Sta";
_q = "SELECT datoteka FROM "+mostCurrent._vvvvvvv5._v5+" WHERE imeDat = '"+mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4+"'";
 //BA.debugLineNum = 293;BA.debugLine="curs = Starter.upit.ExecQuery(q)";
_curs.setObject((android.database.Cursor)(mostCurrent._vvvvvvv5._v6.ExecQuery(_q)));
 //BA.debugLineNum = 294;BA.debugLine="If curs.RowCount > 0 Then";
if (_curs.getRowCount()>0) { 
 //BA.debugLineNum = 295;BA.debugLine="For i = 0 To curs.RowCount-1";
{
final int step13 = 1;
final int limit13 = (int) (_curs.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit13 ;_i = _i + step13 ) {
 //BA.debugLineNum = 296;BA.debugLine="curs.Position = i";
_curs.setPosition(_i);
 //BA.debugLineNum = 297;BA.debugLine="datZaParsanjeR = curs.GetString(\"datoteka\")";
_datzaparsanjer = _curs.GetString("datoteka");
 }
};
 };
 //BA.debugLineNum = 301;BA.debugLine="ParsajRazine(datZaParsanjeR)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5(_datzaparsanjer);
 //BA.debugLineNum = 303;BA.debugLine="Dim od As Int = 0";
_od = (int) (0);
 //BA.debugLineNum = 304;BA.debugLine="For i = 0 To razina - 1";
{
final int step20 = 1;
final int limit20 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5-1);
_i = (int) (0) ;
for (;_i <= limit20 ;_i = _i + step20 ) {
 //BA.debugLineNum = 305;BA.debugLine="od = od + hLevel.Get(i)";
_od = (int) (_od+(double)(BA.ObjectToNumber(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Get(_i))));
 }
};
 //BA.debugLineNum = 307;BA.debugLine="Dim doo As Int = 0";
_doo = (int) (0);
 //BA.debugLineNum = 308;BA.debugLine="For i = 0 To razina";
{
final int step24 = 1;
final int limit24 = _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5;
_i = (int) (0) ;
for (;_i <= limit24 ;_i = _i + step24 ) {
 //BA.debugLineNum = 309;BA.debugLine="doo = doo + hLevel.Get(i)";
_doo = (int) (_doo+(double)(BA.ObjectToNumber(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Get(_i))));
 }
};
 //BA.debugLineNum = 311;BA.debugLine="izgRazineOdIndeksaPoc = od";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = _od;
 //BA.debugLineNum = 312;BA.debugLine="izgRazineDoIndeksaKraj = doo - 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = (int) (_doo-1);
 //BA.debugLineNum = 313;BA.debugLine="KreirajNivo";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1();
 };
 }else {
 //BA.debugLineNum = 345;BA.debugLine="ParsajRazine(Main.datZaParsanjeRazina)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5(mostCurrent._vvvvvvv4._vvv5);
 //BA.debugLineNum = 346;BA.debugLine="izgRazineOdIndeksaPoc = 0";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = (int) (0);
 //BA.debugLineNum = 347;BA.debugLine="If razina = 0 Then izgRazineDoIndeksaKraj = 0";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5==0) { 
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = (int) (0);};
 //BA.debugLineNum = 348;BA.debugLine="izgRazineDoIndeksaKraj = izgRazineDoIndeksaKraj";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0+(double)(BA.ObjectToNumber(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Get(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5)))-1);
 //BA.debugLineNum = 349;BA.debugLine="KreirajNivo";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1();
 };
 //BA.debugLineNum = 351;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5(String _dat) throws Exception{
byte[] _bytes = null;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _ins = null;
 //BA.debugLineNum = 353;BA.debugLine="Sub ParsajRazine(dat As String)";
 //BA.debugLineNum = 354;BA.debugLine="imeLevela.Clear";
mostCurrent._vvv4.Clear();
 //BA.debugLineNum = 355;BA.debugLine="wLevel.Clear";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Clear();
 //BA.debugLineNum = 356;BA.debugLine="hLevel.Clear";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Clear();
 //BA.debugLineNum = 357;BA.debugLine="izgledLevela.Clear";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Clear();
 //BA.debugLineNum = 358;BA.debugLine="brojLevela = 0";
_vvv6 = (int) (0);
 //BA.debugLineNum = 359;BA.debugLine="Dim bytes() As Byte = dat.GetBytes(\"utf8\")";
_bytes = _dat.getBytes("utf8");
 //BA.debugLineNum = 360;BA.debugLine="Dim ins As InputStream";
_ins = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
 //BA.debugLineNum = 361;BA.debugLine="ins.InitializeFromBytesArray(bytes, 0, bytes.Leng";
_ins.InitializeFromBytesArray(_bytes,(int) (0),_bytes.length);
 //BA.debugLineNum = 362;BA.debugLine="slc_parse.Parse(ins, \"slc\")";
_slc_parse.Parse((java.io.InputStream)(_ins.getObject()),"slc");
 //BA.debugLineNum = 363;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6(String _smjer) throws Exception{
int _redak = 0;
int _stupac = 0;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
String _starapoz = "";
String _npt1 = "";
int _npt2 = 0;
String _novapoz = "";
String _drugakutijapoz = "";
 //BA.debugLineNum = 1946;BA.debugLine="Sub PomakniUSmjeru(smjer As String)";
 //BA.debugLineNum = 1947;BA.debugLine="Dim redak, stupac As Int : Dim cd As ColorDrawabl";
_redak = 0;
_stupac = 0;
 //BA.debugLineNum = 1947;BA.debugLine="Dim redak, stupac As Int : Dim cd As ColorDrawabl";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 1949;BA.debugLine="cd.Initialize(Colors.RGB(115, 175, 199), 0)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (115),(int) (175),(int) (199)),(int) (0));
 //BA.debugLineNum = 1951;BA.debugLine="Select smjer";
switch (BA.switchObjectToInt(_smjer,"gore","lijevo","desno","dole")) {
case 0: {
 //BA.debugLineNum = 1954;BA.debugLine="redak = -1";
_redak = (int) (-1);
 //BA.debugLineNum = 1956;BA.debugLine="Dim staraPoz As String = karta.Get(\"@\")";
_starapoz = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)("@")));
 //BA.debugLineNum = 1959;BA.debugLine="Dim npt1 As String = staraPoz.SubString2(0, sta";
_npt1 = _starapoz.substring((int) (0),_starapoz.indexOf(";"));
 //BA.debugLineNum = 1960;BA.debugLine="Dim npt2 As Int = npt1 + redak";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_redak);
 //BA.debugLineNum = 1961;BA.debugLine="Dim novaPoz As String = npt2 & staraPoz.SubStri";
_novapoz = BA.NumberToString(_npt2)+_starapoz.substring(_starapoz.indexOf(";"));
 //BA.debugLineNum = 1964;BA.debugLine="Dim npt1 As String = novaPoz.SubString2(0, nova";
_npt1 = _novapoz.substring((int) (0),_novapoz.indexOf(";"));
 //BA.debugLineNum = 1965;BA.debugLine="Dim npt2 As Int = npt1 + redak";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_redak);
 //BA.debugLineNum = 1966;BA.debugLine="Dim drugaKutijaPoz As String = npt2 & novaPoz.S";
_drugakutijapoz = BA.NumberToString(_npt2)+_novapoz.substring(_novapoz.indexOf(";"));
 //BA.debugLineNum = 1968;BA.debugLine="ProvjeriIPomakni(staraPoz, novaPoz, drugaKutija";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(_starapoz,_novapoz,_drugakutijapoz,(int) (1));
 break; }
case 1: {
 //BA.debugLineNum = 1973;BA.debugLine="stupac = -1";
_stupac = (int) (-1);
 //BA.debugLineNum = 1975;BA.debugLine="Dim staraPoz As String = karta.Get(\"@\")";
_starapoz = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)("@")));
 //BA.debugLineNum = 1978;BA.debugLine="Dim npt1 As String = staraPoz.SubString(staraPo";
_npt1 = _starapoz.substring((int) (_starapoz.indexOf(";")+1));
 //BA.debugLineNum = 1979;BA.debugLine="Dim npt2 As Int = npt1 + stupac";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_stupac);
 //BA.debugLineNum = 1980;BA.debugLine="Dim novaPoz As String = staraPoz.SubString2(0,";
_novapoz = _starapoz.substring((int) (0),(int) (_starapoz.indexOf(";")+1))+BA.NumberToString(_npt2);
 //BA.debugLineNum = 1983;BA.debugLine="Dim npt1 As String = novaPoz.SubString(novaPoz.";
_npt1 = _novapoz.substring((int) (_novapoz.indexOf(";")+1));
 //BA.debugLineNum = 1984;BA.debugLine="Dim npt2 As Int = npt1 + stupac";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_stupac);
 //BA.debugLineNum = 1985;BA.debugLine="Dim drugaKutijaPoz As String = novaPoz.SubStrin";
_drugakutijapoz = _novapoz.substring((int) (0),(int) (_novapoz.indexOf(";")+1))+BA.NumberToString(_npt2);
 //BA.debugLineNum = 1987;BA.debugLine="ProvjeriIPomakni(staraPoz, novaPoz, drugaKutija";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(_starapoz,_novapoz,_drugakutijapoz,(int) (2));
 break; }
case 2: {
 //BA.debugLineNum = 1992;BA.debugLine="stupac = 1";
_stupac = (int) (1);
 //BA.debugLineNum = 1994;BA.debugLine="Dim staraPoz As String = karta.Get(\"@\")";
_starapoz = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)("@")));
 //BA.debugLineNum = 1997;BA.debugLine="Dim npt1 As String = staraPoz.SubString(staraPo";
_npt1 = _starapoz.substring((int) (_starapoz.indexOf(";")+1));
 //BA.debugLineNum = 1998;BA.debugLine="Dim npt2 As Int = npt1 + stupac";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_stupac);
 //BA.debugLineNum = 1999;BA.debugLine="Dim novaPoz As String = staraPoz.SubString2(0,";
_novapoz = _starapoz.substring((int) (0),(int) (_starapoz.indexOf(";")+1))+BA.NumberToString(_npt2);
 //BA.debugLineNum = 2002;BA.debugLine="Dim npt1 As String = novaPoz.SubString(novaPoz.";
_npt1 = _novapoz.substring((int) (_novapoz.indexOf(";")+1));
 //BA.debugLineNum = 2003;BA.debugLine="Dim npt2 As Int = npt1 + stupac";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_stupac);
 //BA.debugLineNum = 2004;BA.debugLine="Dim drugaKutijaPoz As String = novaPoz.SubStrin";
_drugakutijapoz = _novapoz.substring((int) (0),(int) (_novapoz.indexOf(";")+1))+BA.NumberToString(_npt2);
 //BA.debugLineNum = 2006;BA.debugLine="ProvjeriIPomakni(staraPoz, novaPoz, drugaKutija";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(_starapoz,_novapoz,_drugakutijapoz,(int) (4));
 break; }
case 3: {
 //BA.debugLineNum = 2010;BA.debugLine="redak = 1";
_redak = (int) (1);
 //BA.debugLineNum = 2013;BA.debugLine="Dim staraPoz As String = karta.Get(\"@\")";
_starapoz = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)("@")));
 //BA.debugLineNum = 2016;BA.debugLine="Dim npt1 As String = staraPoz.SubString2(0, sta";
_npt1 = _starapoz.substring((int) (0),_starapoz.indexOf(";"));
 //BA.debugLineNum = 2017;BA.debugLine="Dim npt2 As Int = npt1 + redak";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_redak);
 //BA.debugLineNum = 2018;BA.debugLine="Dim novaPoz As String = npt2 & staraPoz.SubStri";
_novapoz = BA.NumberToString(_npt2)+_starapoz.substring(_starapoz.indexOf(";"));
 //BA.debugLineNum = 2021;BA.debugLine="Dim npt1 As String = novaPoz.SubString2(0, nova";
_npt1 = _novapoz.substring((int) (0),_novapoz.indexOf(";"));
 //BA.debugLineNum = 2022;BA.debugLine="Dim npt2 As Int = npt1 + redak";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_redak);
 //BA.debugLineNum = 2023;BA.debugLine="Dim drugaKutijaPoz As String = npt2 & novaPoz.S";
_drugakutijapoz = BA.NumberToString(_npt2)+_novapoz.substring(_novapoz.indexOf(";"));
 //BA.debugLineNum = 2025;BA.debugLine="ProvjeriIPomakni(staraPoz, novaPoz, drugaKutija";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(_starapoz,_novapoz,_drugakutijapoz,(int) (3));
 break; }
}
;
 //BA.debugLineNum = 2028;BA.debugLine="sv2d.SmoothScrollTo(IzracunajPozicijuX, Izracunaj";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.SmoothScrollTo(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2(),_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3());
 //BA.debugLineNum = 2029;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 11;BA.debugLine="Dim Timer1 As Timer";
_vv2 = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 12;BA.debugLine="Dim Timer3 As Timer";
_vv3 = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 13;BA.debugLine="Dim Timer5 As Timer";
_vv4 = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 15;BA.debugLine="Dim slc_parse As SaxParser";
_slc_parse = new anywheresoftware.b4a.objects.SaxParser();
 //BA.debugLineNum = 16;BA.debugLine="Dim sounds As SoundPool";
_vv5 = new anywheresoftware.b4a.audio.SoundPoolWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Dim bounceId1, bounceId2, bounceId3, bounceId4 As";
_vv6 = 0;
_vv7 = 0;
_vv0 = 0;
_vvv1 = 0;
 //BA.debugLineNum = 18;BA.debugLine="Dim awake As PhoneWakeState";
_vvv2 = new anywheresoftware.b4a.phone.Phone.PhoneWakeState();
 //BA.debugLineNum = 26;BA.debugLine="Dim sensor As PhoneSensors";
_vvv3 = new anywheresoftware.b4a.phone.Phone.PhoneSensors();
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(String _sp,String _np,String _dkp,int _smjer) throws Exception{
anywheresoftware.b4a.objects.ImageViewWrapper _img0 = null;
anywheresoftware.b4a.objects.ImageViewWrapper _img1 = null;
anywheresoftware.b4a.objects.ImageViewWrapper _img2 = null;
String _novap1 = "";
String _novap2 = "";
String _starap = "";
int _xx = 0;
 //BA.debugLineNum = 1355;BA.debugLine="Sub ProvjeriIPomakni(sp As String, np As String, d";
 //BA.debugLineNum = 1361;BA.debugLine="If karta.ContainsKey(np) Then";
if (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.ContainsKey((Object)(_np))) { 
 //BA.debugLineNum = 1362;BA.debugLine="Dim img0 As ImageView : img0 = karta.Get(sp)";
_img0 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 1362;BA.debugLine="Dim img0 As ImageView : img0 = karta.Get(sp)";
_img0.setObject((android.widget.ImageView)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)(_sp))));
 //BA.debugLineNum = 1363;BA.debugLine="Dim img1 As ImageView : img1 = karta.Get(np)";
_img1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 1363;BA.debugLine="Dim img1 As ImageView : img1 = karta.Get(np)";
_img1.setObject((android.widget.ImageView)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)(_np))));
 //BA.debugLineNum = 1364;BA.debugLine="Dim img2 As ImageView : img2 = karta.Get(dkp)";
_img2 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 1364;BA.debugLine="Dim img2 As ImageView : img2 = karta.Get(dkp)";
_img2.setObject((android.widget.ImageView)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)(_dkp))));
 //BA.debugLineNum = 1365;BA.debugLine="Dim novaP1 As String = img1.Tag";
_novap1 = BA.ObjectToString(_img1.getTag());
 //BA.debugLineNum = 1366;BA.debugLine="If img2.IsInitialized Then";
if (_img2.IsInitialized()) { 
 //BA.debugLineNum = 1367;BA.debugLine="Dim novaP2 As String = img2.Tag";
_novap2 = BA.ObjectToString(_img2.getTag());
 }else {
 //BA.debugLineNum = 1369;BA.debugLine="novaP2 = \"#\"	' zid -> druga pozicija od igrača";
_novap2 = "#";
 };
 //BA.debugLineNum = 1371;BA.debugLine="Dim staraP As String = img0.Tag";
_starap = BA.ObjectToString(_img0.getTag());
 //BA.debugLineNum = 1372;BA.debugLine="If novaP1.EqualsIgnoreCase(\"_\") Then' Or novaP1.";
if (_novap1.equalsIgnoreCase("_")) { 
 //BA.debugLineNum = 1373;BA.debugLine="img1.Bitmap = igr1' LoadBitmap(File.DirAssets,";
_img1.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.getObject()));
 //BA.debugLineNum = 1374;BA.debugLine="img1.Gravity = Gravity.FILL";
_img1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1375;BA.debugLine="karta.Put(\"@\", np)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)("@"),(Object)(_np));
 //BA.debugLineNum = 1376;BA.debugLine="If staraP.EqualsIgnoreCase(\".\") Then";
if (_starap.equalsIgnoreCase(".")) { 
 //BA.debugLineNum = 1377;BA.debugLine="img0.Bitmap = mjzakut1'LoadBitmap(File.DirAsse";
_img0.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getObject()));
 //BA.debugLineNum = 1378;BA.debugLine="img0.Tag = \".\"";
_img0.setTag((Object)("."));
 }else {
 //BA.debugLineNum = 1381;BA.debugLine="img0.Bitmap = pod1";
_img0.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getObject()));
 //BA.debugLineNum = 1382;BA.debugLine="img0.Tag = \"_\"";
_img0.setTag((Object)("_"));
 };
 //BA.debugLineNum = 1384;BA.debugLine="brojKoraka = brojKoraka + 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6+1);
 //BA.debugLineNum = 1385;BA.debugLine="If smjer = 1 Then ' gore";
if (_smjer==1) { 
 //BA.debugLineNum = 1386;BA.debugLine="rijesenje = rijesenje & \"u\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"u";
 }else if(_smjer==2) { 
 //BA.debugLineNum = 1388;BA.debugLine="rijesenje = rijesenje & \"l\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"l";
 }else if(_smjer==3) { 
 //BA.debugLineNum = 1390;BA.debugLine="rijesenje = rijesenje & \"d\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"d";
 }else if(_smjer==4) { 
 //BA.debugLineNum = 1392;BA.debugLine="rijesenje = rijesenje & \"r\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"r";
 };
 }else if(_novap1.equalsIgnoreCase(".")) { 
 //BA.debugLineNum = 1396;BA.debugLine="img1.Bitmap = igrnamj1'LoadBitmap(File.DirAsset";
_img1.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.getObject()));
 //BA.debugLineNum = 1397;BA.debugLine="img1.Gravity = Gravity.FILL";
_img1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1398;BA.debugLine="karta.Put(\"@\", np)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)("@"),(Object)(_np));
 //BA.debugLineNum = 1399;BA.debugLine="If staraP.EqualsIgnoreCase(\".\") Then";
if (_starap.equalsIgnoreCase(".")) { 
 //BA.debugLineNum = 1400;BA.debugLine="img0.Bitmap = mjzakut1'LoadBitmap(File.DirAsse";
_img0.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getObject()));
 //BA.debugLineNum = 1401;BA.debugLine="img0.Tag = \".\"";
_img0.setTag((Object)("."));
 }else {
 //BA.debugLineNum = 1404;BA.debugLine="img0.Bitmap = pod1";
_img0.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getObject()));
 //BA.debugLineNum = 1405;BA.debugLine="img0.Tag = \"_\"";
_img0.setTag((Object)("_"));
 };
 //BA.debugLineNum = 1407;BA.debugLine="brojKoraka = brojKoraka + 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6+1);
 //BA.debugLineNum = 1408;BA.debugLine="If smjer = 1 Then ' gore";
if (_smjer==1) { 
 //BA.debugLineNum = 1409;BA.debugLine="rijesenje = rijesenje & \"u\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"u";
 }else if(_smjer==2) { 
 //BA.debugLineNum = 1411;BA.debugLine="rijesenje = rijesenje & \"l\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"l";
 }else if(_smjer==3) { 
 //BA.debugLineNum = 1413;BA.debugLine="rijesenje = rijesenje & \"d\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"d";
 }else if(_smjer==4) { 
 //BA.debugLineNum = 1415;BA.debugLine="rijesenje = rijesenje & \"r\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"r";
 };
 }else if(_novap1.equalsIgnoreCase("$") && _novap2.equalsIgnoreCase("_")) { 
 //BA.debugLineNum = 1419;BA.debugLine="img1.Bitmap = igr1' LoadBitmap(File.DirAssets,";
_img1.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.getObject()));
 //BA.debugLineNum = 1420;BA.debugLine="img1.Gravity = Gravity.FILL";
_img1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1421;BA.debugLine="img1.Tag = \"_\"";
_img1.setTag((Object)("_"));
 //BA.debugLineNum = 1422;BA.debugLine="karta.Put(\"@\", np)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)("@"),(Object)(_np));
 //BA.debugLineNum = 1423;BA.debugLine="img2.Bitmap = kutija1' LoadBitmap(File.DirAsset";
_img2.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getObject()));
 //BA.debugLineNum = 1424;BA.debugLine="img2.Gravity = Gravity.FILL";
_img2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1425;BA.debugLine="img2.Tag = \"$\"";
_img2.setTag((Object)("$"));
 //BA.debugLineNum = 1426;BA.debugLine="Dim xx As Int = pozKutija.IndexOf(np)";
_xx = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.IndexOf((Object)(_np));
 //BA.debugLineNum = 1427;BA.debugLine="pozKutija.RemoveAt(xx)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.RemoveAt(_xx);
 //BA.debugLineNum = 1428;BA.debugLine="pozKutija.Add(dkp)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Add((Object)(_dkp));
 //BA.debugLineNum = 1429;BA.debugLine="If staraP.EqualsIgnoreCase(\".\") Then";
if (_starap.equalsIgnoreCase(".")) { 
 //BA.debugLineNum = 1430;BA.debugLine="img0.Bitmap = mjzakut1' LoadBitmap(File.DirAss";
_img0.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getObject()));
 //BA.debugLineNum = 1431;BA.debugLine="img0.Tag = \".\"";
_img0.setTag((Object)("."));
 }else {
 //BA.debugLineNum = 1434;BA.debugLine="img0.Bitmap = pod1";
_img0.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getObject()));
 //BA.debugLineNum = 1435;BA.debugLine="img0.Tag = \"_\"";
_img0.setTag((Object)("_"));
 };
 //BA.debugLineNum = 1437;BA.debugLine="brojKoraka = brojKoraka + 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6+1);
 //BA.debugLineNum = 1438;BA.debugLine="brojGuranja = brojGuranja + 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7+1);
 //BA.debugLineNum = 1439;BA.debugLine="If smjer = 1 Then ' gore";
if (_smjer==1) { 
 //BA.debugLineNum = 1440;BA.debugLine="rijesenje = rijesenje & \"U\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"U";
 }else if(_smjer==2) { 
 //BA.debugLineNum = 1442;BA.debugLine="rijesenje = rijesenje & \"L\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"L";
 }else if(_smjer==3) { 
 //BA.debugLineNum = 1444;BA.debugLine="rijesenje = rijesenje & \"D\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"D";
 }else if(_smjer==4) { 
 //BA.debugLineNum = 1446;BA.debugLine="rijesenje = rijesenje & \"R\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"R";
 };
 }else if(_novap1.equalsIgnoreCase("$") && _novap2.equalsIgnoreCase(".")) { 
 //BA.debugLineNum = 1450;BA.debugLine="img1.Bitmap = igr1'igrnamj1' LoadBitmap(File.Di";
_img1.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.getObject()));
 //BA.debugLineNum = 1451;BA.debugLine="img1.Gravity = Gravity.FILL";
_img1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1452;BA.debugLine="img1.Tag = \"_\"";
_img1.setTag((Object)("_"));
 //BA.debugLineNum = 1453;BA.debugLine="karta.Put(\"@\", np)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)("@"),(Object)(_np));
 //BA.debugLineNum = 1454;BA.debugLine="img2.Bitmap = kutnamj1'LoadBitmap(File.DirAsset";
_img2.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.getObject()));
 //BA.debugLineNum = 1455;BA.debugLine="img2.Gravity = Gravity.FILL";
_img2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1456;BA.debugLine="img2.Tag = \"*\"";
_img2.setTag((Object)("*"));
 //BA.debugLineNum = 1457;BA.debugLine="Dim xx As Int = pozKutija.IndexOf(np)";
_xx = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.IndexOf((Object)(_np));
 //BA.debugLineNum = 1458;BA.debugLine="pozKutija.RemoveAt(xx)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.RemoveAt(_xx);
 //BA.debugLineNum = 1459;BA.debugLine="pozKutija.Add(dkp)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Add((Object)(_dkp));
 //BA.debugLineNum = 1460;BA.debugLine="If staraP.EqualsIgnoreCase(\".\") Then";
if (_starap.equalsIgnoreCase(".")) { 
 //BA.debugLineNum = 1461;BA.debugLine="img0.Bitmap = mjzakut1' LoadBitmap(File.DirAss";
_img0.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getObject()));
 //BA.debugLineNum = 1462;BA.debugLine="img0.Tag = \".\"";
_img0.setTag((Object)("."));
 }else {
 //BA.debugLineNum = 1465;BA.debugLine="img0.Bitmap = pod1";
_img0.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getObject()));
 //BA.debugLineNum = 1466;BA.debugLine="img0.Tag = \"_\"";
_img0.setTag((Object)("_"));
 };
 //BA.debugLineNum = 1468;BA.debugLine="If snd Then'Or mjuzaZid.EqualsIgnoreCase(\"true\"";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0) { 
 //BA.debugLineNum = 1469;BA.debugLine="sounds.Play(bounceId2, 1, 1, 1, 0, 1)";
_vv5.Play(_vv7,(float) (1),(float) (1),(int) (1),(int) (0),(float) (1));
 };
 //BA.debugLineNum = 1471;BA.debugLine="brojKoraka = brojKoraka + 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6+1);
 //BA.debugLineNum = 1472;BA.debugLine="brojGuranja = brojGuranja + 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7+1);
 //BA.debugLineNum = 1473;BA.debugLine="If smjer = 1 Then ' gore";
if (_smjer==1) { 
 //BA.debugLineNum = 1474;BA.debugLine="rijesenje = rijesenje & \"U\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"U";
 }else if(_smjer==2) { 
 //BA.debugLineNum = 1476;BA.debugLine="rijesenje = rijesenje & \"L\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"L";
 }else if(_smjer==3) { 
 //BA.debugLineNum = 1478;BA.debugLine="rijesenje = rijesenje & \"D\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"D";
 }else if(_smjer==4) { 
 //BA.debugLineNum = 1480;BA.debugLine="rijesenje = rijesenje & \"R\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"R";
 };
 }else if(_novap1.equalsIgnoreCase(".") && _novap2.equalsIgnoreCase(".") || _novap1.equalsIgnoreCase(".") && _novap2.equalsIgnoreCase("_")) { 
 //BA.debugLineNum = 1484;BA.debugLine="img1.Bitmap = igrnamj1'LoadBitmap(File.DirAsset";
_img1.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.getObject()));
 //BA.debugLineNum = 1485;BA.debugLine="img1.Gravity = Gravity.FILL";
_img1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1486;BA.debugLine="img1.Tag = \".\"";
_img1.setTag((Object)("."));
 //BA.debugLineNum = 1487;BA.debugLine="karta.Put(\"@\", np)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)("@"),(Object)(_np));
 //BA.debugLineNum = 1488;BA.debugLine="img2.Bitmap = kutnamj1'LoadBitmap(File.DirAsset";
_img2.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.getObject()));
 //BA.debugLineNum = 1489;BA.debugLine="img2.Gravity = Gravity.FILL";
_img2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1490;BA.debugLine="img2.Tag = \"*\"";
_img2.setTag((Object)("*"));
 //BA.debugLineNum = 1491;BA.debugLine="If staraP.EqualsIgnoreCase(\".\") Then";
if (_starap.equalsIgnoreCase(".")) { 
 //BA.debugLineNum = 1492;BA.debugLine="img0.Bitmap = mjzakut1'LoadBitmap(File.DirAsse";
_img0.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getObject()));
 //BA.debugLineNum = 1493;BA.debugLine="img0.Tag = \".\"";
_img0.setTag((Object)("."));
 }else {
 //BA.debugLineNum = 1496;BA.debugLine="img0.Bitmap = pod1";
_img0.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getObject()));
 //BA.debugLineNum = 1497;BA.debugLine="img0.Tag = \"_\"";
_img0.setTag((Object)("_"));
 };
 //BA.debugLineNum = 1499;BA.debugLine="If snd Then'Or mjuzaZid.EqualsIgnoreCase(\"true\"";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0) { 
 //BA.debugLineNum = 1500;BA.debugLine="sounds.Play(bounceId2, 1, 1, 1, 0, 1)";
_vv5.Play(_vv7,(float) (1),(float) (1),(int) (1),(int) (0),(float) (1));
 };
 //BA.debugLineNum = 1502;BA.debugLine="brojKoraka = brojKoraka + 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6+1);
 //BA.debugLineNum = 1503;BA.debugLine="If smjer = 1 Then ' gore";
if (_smjer==1) { 
 //BA.debugLineNum = 1504;BA.debugLine="rijesenje = rijesenje & \"u\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"u";
 }else if(_smjer==2) { 
 //BA.debugLineNum = 1506;BA.debugLine="rijesenje = rijesenje & \"l\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"l";
 }else if(_smjer==3) { 
 //BA.debugLineNum = 1508;BA.debugLine="rijesenje = rijesenje & \"d\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"d";
 }else if(_smjer==4) { 
 //BA.debugLineNum = 1510;BA.debugLine="rijesenje = rijesenje & \"r\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"r";
 };
 }else if(_novap1.equalsIgnoreCase("*") && _novap2.equalsIgnoreCase(".")) { 
 //BA.debugLineNum = 1514;BA.debugLine="img1.Bitmap = igrnamj1'LoadBitmap(File.DirAsset";
_img1.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.getObject()));
 //BA.debugLineNum = 1515;BA.debugLine="img1.Gravity = Gravity.FILL";
_img1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1516;BA.debugLine="img1.Tag = \".\"";
_img1.setTag((Object)("."));
 //BA.debugLineNum = 1517;BA.debugLine="karta.Put(\"@\", np)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)("@"),(Object)(_np));
 //BA.debugLineNum = 1518;BA.debugLine="img2.Bitmap = kutnamj1'LoadBitmap(File.DirAsset";
_img2.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.getObject()));
 //BA.debugLineNum = 1519;BA.debugLine="img2.Gravity = Gravity.FILL";
_img2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1520;BA.debugLine="img2.Tag = \"*\"";
_img2.setTag((Object)("*"));
 //BA.debugLineNum = 1521;BA.debugLine="Dim xx As Int = pozKutija.IndexOf(np)";
_xx = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.IndexOf((Object)(_np));
 //BA.debugLineNum = 1522;BA.debugLine="pozKutija.RemoveAt(xx)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.RemoveAt(_xx);
 //BA.debugLineNum = 1523;BA.debugLine="pozKutija.Add(dkp)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Add((Object)(_dkp));
 //BA.debugLineNum = 1524;BA.debugLine="If staraP.EqualsIgnoreCase(\".\") Then";
if (_starap.equalsIgnoreCase(".")) { 
 //BA.debugLineNum = 1525;BA.debugLine="img0.Bitmap = mjzakut1'LoadBitmap(File.DirAsse";
_img0.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getObject()));
 //BA.debugLineNum = 1526;BA.debugLine="img0.Tag = \".\"";
_img0.setTag((Object)("."));
 }else {
 //BA.debugLineNum = 1529;BA.debugLine="img0.Bitmap = pod1";
_img0.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getObject()));
 //BA.debugLineNum = 1530;BA.debugLine="img0.Tag = \"_\"";
_img0.setTag((Object)("_"));
 };
 //BA.debugLineNum = 1532;BA.debugLine="If snd Then'Or mjuzaZid.EqualsIgnoreCase(\"true\"";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0) { 
 //BA.debugLineNum = 1533;BA.debugLine="sounds.Play(bounceId2, 1, 1, 1, 0, 1)";
_vv5.Play(_vv7,(float) (1),(float) (1),(int) (1),(int) (0),(float) (1));
 };
 //BA.debugLineNum = 1535;BA.debugLine="brojKoraka = brojKoraka + 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6+1);
 //BA.debugLineNum = 1536;BA.debugLine="brojGuranja = brojGuranja + 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7+1);
 //BA.debugLineNum = 1537;BA.debugLine="If smjer = 1 Then ' gore";
if (_smjer==1) { 
 //BA.debugLineNum = 1538;BA.debugLine="rijesenje = rijesenje & \"U\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"U";
 }else if(_smjer==2) { 
 //BA.debugLineNum = 1540;BA.debugLine="rijesenje = rijesenje & \"L\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"L";
 }else if(_smjer==3) { 
 //BA.debugLineNum = 1542;BA.debugLine="rijesenje = rijesenje & \"D\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"D";
 }else if(_smjer==4) { 
 //BA.debugLineNum = 1544;BA.debugLine="rijesenje = rijesenje & \"R\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"R";
 };
 }else if(_novap1.equalsIgnoreCase("*") && _novap2.equalsIgnoreCase("_")) { 
 //BA.debugLineNum = 1548;BA.debugLine="img1.Bitmap = igrnamj1'igr1'LoadBitmap(File.Dir";
_img1.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.getObject()));
 //BA.debugLineNum = 1549;BA.debugLine="img1.Gravity = Gravity.FILL";
_img1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1550;BA.debugLine="img1.Tag = \".\"";
_img1.setTag((Object)("."));
 //BA.debugLineNum = 1551;BA.debugLine="karta.Put(\"@\", np)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)("@"),(Object)(_np));
 //BA.debugLineNum = 1552;BA.debugLine="img2.Bitmap = kutija1'LoadBitmap(File.DirAssets";
_img2.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getObject()));
 //BA.debugLineNum = 1553;BA.debugLine="img2.Gravity = Gravity.FILL";
_img2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1554;BA.debugLine="img2.Tag = \"$\"";
_img2.setTag((Object)("$"));
 //BA.debugLineNum = 1555;BA.debugLine="Dim xx As Int = pozKutija.IndexOf(np)";
_xx = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.IndexOf((Object)(_np));
 //BA.debugLineNum = 1556;BA.debugLine="pozKutija.RemoveAt(xx)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.RemoveAt(_xx);
 //BA.debugLineNum = 1557;BA.debugLine="pozKutija.Add(dkp)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Add((Object)(_dkp));
 //BA.debugLineNum = 1558;BA.debugLine="If staraP.EqualsIgnoreCase(\".\") Then";
if (_starap.equalsIgnoreCase(".")) { 
 //BA.debugLineNum = 1559;BA.debugLine="img0.Bitmap = mjzakut1'LoadBitmap(File.DirAsse";
_img0.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getObject()));
 //BA.debugLineNum = 1560;BA.debugLine="img0.Tag = \".\"";
_img0.setTag((Object)("."));
 }else {
 //BA.debugLineNum = 1563;BA.debugLine="img0.Bitmap = pod1";
_img0.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getObject()));
 //BA.debugLineNum = 1564;BA.debugLine="img0.Tag = \"_\"";
_img0.setTag((Object)("_"));
 };
 //BA.debugLineNum = 1566;BA.debugLine="brojKoraka = brojKoraka + 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6+1);
 //BA.debugLineNum = 1567;BA.debugLine="brojGuranja = brojGuranja + 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7+1);
 //BA.debugLineNum = 1568;BA.debugLine="If smjer = 1 Then ' gore";
if (_smjer==1) { 
 //BA.debugLineNum = 1569;BA.debugLine="rijesenje = rijesenje & \"U\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"U";
 }else if(_smjer==2) { 
 //BA.debugLineNum = 1571;BA.debugLine="rijesenje = rijesenje & \"L\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"L";
 }else if(_smjer==3) { 
 //BA.debugLineNum = 1573;BA.debugLine="rijesenje = rijesenje & \"D\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"D";
 }else if(_smjer==4) { 
 //BA.debugLineNum = 1575;BA.debugLine="rijesenje = rijesenje & \"R\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2+"R";
 };
 }else {
 //BA.debugLineNum = 1579;BA.debugLine="If snd Then'Or mjuzaZid.EqualsIgnoreCase(\"true\"";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0) { 
 //BA.debugLineNum = 1580;BA.debugLine="sounds.Play(bounceId1, 1, 1, 1, 0, 1)";
_vv5.Play(_vv6,(float) (1),(float) (1),(int) (1),(int) (0),(float) (1));
 };
 };
 };
 //BA.debugLineNum = 1589;BA.debugLine="lblSteps.Text = \"Steps: \" & brojKoraka";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.setText(BA.ObjectToCharSequence("Steps: "+BA.NumberToString(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6)));
 //BA.debugLineNum = 1590;BA.debugLine="SetLabelTextSize(lblSteps, lblSteps.Text, 28, 10)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0,mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getText(),(float) (28),(float) (10));
 //BA.debugLineNum = 1591;BA.debugLine="lblPushes.Text = \"Pushes: \" & brojGuranja";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.setText(BA.ObjectToCharSequence("Pushes: "+BA.NumberToString(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7)));
 //BA.debugLineNum = 1592;BA.debugLine="SetLabelTextSize(lblPushes, lblPushes.Text, 28, 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1,mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getText(),(float) (28),(float) (10));
 //BA.debugLineNum = 1594;BA.debugLine="sv2d.SmoothScrollTo(IzracunajPozicijuX, Izracunaj";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.SmoothScrollTo(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2(),_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3());
 //BA.debugLineNum = 1596;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(String _sp,String _np,String _dkp,int _smjer) throws Exception{
anywheresoftware.b4a.objects.ImageViewWrapper _img0 = null;
anywheresoftware.b4a.objects.ImageViewWrapper _img1 = null;
anywheresoftware.b4a.objects.ImageViewWrapper _img2 = null;
String _sp1 = "";
String _np1 = "";
String _dkp1 = "";
int _xx = 0;
 //BA.debugLineNum = 1252;BA.debugLine="Sub ProvjeriIPomakniUnatrag(sp As String, np As St";
 //BA.debugLineNum = 1253;BA.debugLine="If karta.ContainsKey(np) Then";
if (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.ContainsKey((Object)(_np))) { 
 //BA.debugLineNum = 1254;BA.debugLine="Dim img0 As ImageView : img0 = karta.Get(sp)";
_img0 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 1254;BA.debugLine="Dim img0 As ImageView : img0 = karta.Get(sp)";
_img0.setObject((android.widget.ImageView)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)(_sp))));
 //BA.debugLineNum = 1255;BA.debugLine="Dim img1 As ImageView : img1 = karta.Get(np)";
_img1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 1255;BA.debugLine="Dim img1 As ImageView : img1 = karta.Get(np)";
_img1.setObject((android.widget.ImageView)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)(_np))));
 //BA.debugLineNum = 1256;BA.debugLine="Dim img2 As ImageView : img2 = karta.Get(dkp)";
_img2 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 1256;BA.debugLine="Dim img2 As ImageView : img2 = karta.Get(dkp)";
_img2.setObject((android.widget.ImageView)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)(_dkp))));
 //BA.debugLineNum = 1257;BA.debugLine="Dim sp1 As String = img0.Tag'tempKartaZaNatrag.G";
_sp1 = BA.ObjectToString(_img0.getTag());
 //BA.debugLineNum = 1258;BA.debugLine="Dim np1 As String = img1.Tag'tempKartaZaNatrag.G";
_np1 = BA.ObjectToString(_img1.getTag());
 //BA.debugLineNum = 1259;BA.debugLine="Dim dkp1 As String = tempKartaZaNatrag.Get(dkp)'";
_dkp1 = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)(_dkp)));
 //BA.debugLineNum = 1277;BA.debugLine="If np1.EqualsIgnoreCase(\"_\") Then";
if (_np1.equalsIgnoreCase("_")) { 
 //BA.debugLineNum = 1278;BA.debugLine="img1.Bitmap = igr1";
_img1.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.getObject()));
 //BA.debugLineNum = 1279;BA.debugLine="img1.Gravity = Gravity.FILL";
_img1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1280;BA.debugLine="karta.Put(\"@\", np)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)("@"),(Object)(_np));
 }else if(_np1.equalsIgnoreCase(".") || _np1.equalsIgnoreCase("+")) { 
 //BA.debugLineNum = 1282;BA.debugLine="img1.Bitmap = igrnamj1";
_img1.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.getObject()));
 //BA.debugLineNum = 1283;BA.debugLine="img1.Gravity = Gravity.FILL";
_img1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1284;BA.debugLine="karta.Put(\"@\", np)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Put((Object)("@"),(Object)(_np));
 };
 //BA.debugLineNum = 1290;BA.debugLine="If velikoSlovo = False Then";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 1291;BA.debugLine="If sp1.EqualsIgnoreCase(\"_\") Then";
if (_sp1.equalsIgnoreCase("_")) { 
 //BA.debugLineNum = 1292;BA.debugLine="img0.Bitmap = pod1";
_img0.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getObject()));
 //BA.debugLineNum = 1293;BA.debugLine="img0.Tag = \"_\"";
_img0.setTag((Object)("_"));
 //BA.debugLineNum = 1294;BA.debugLine="img0.Gravity = Gravity.FILL";
_img0.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 }else if(_sp1.equalsIgnoreCase(".")) { 
 //BA.debugLineNum = 1296;BA.debugLine="img0.Bitmap = mjzakut1";
_img0.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getObject()));
 //BA.debugLineNum = 1297;BA.debugLine="img0.Gravity = Gravity.FILL";
_img0.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1298;BA.debugLine="img0.Tag = \".\"";
_img0.setTag((Object)("."));
 }else if(_sp1.equalsIgnoreCase("*")) { 
 //BA.debugLineNum = 1300;BA.debugLine="img0.Bitmap = kutnamj1";
_img0.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.getObject()));
 //BA.debugLineNum = 1301;BA.debugLine="img0.Gravity = Gravity.FILL";
_img0.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1302;BA.debugLine="img0.Tag = \"*\"";
_img0.setTag((Object)("*"));
 };
 }else {
 //BA.debugLineNum = 1305;BA.debugLine="If sp1.EqualsIgnoreCase(\".\") Then";
if (_sp1.equalsIgnoreCase(".")) { 
 //BA.debugLineNum = 1306;BA.debugLine="img0.Bitmap = kutnamj1";
_img0.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.getObject()));
 //BA.debugLineNum = 1307;BA.debugLine="img0.Gravity = Gravity.FILL";
_img0.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1308;BA.debugLine="img0.Tag = \"*\"";
_img0.setTag((Object)("*"));
 //BA.debugLineNum = 1309;BA.debugLine="Dim xx As Int = pozKutija.IndexOf(dkp)";
_xx = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.IndexOf((Object)(_dkp));
 //BA.debugLineNum = 1310;BA.debugLine="pozKutija.RemoveAt(xx)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.RemoveAt(_xx);
 //BA.debugLineNum = 1311;BA.debugLine="pozKutija.Add(sp)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Add((Object)(_sp));
 //BA.debugLineNum = 1312;BA.debugLine="velikoSlovo = False";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = anywheresoftware.b4a.keywords.Common.False;
 }else {
 //BA.debugLineNum = 1314;BA.debugLine="img0.Bitmap = kutija1";
_img0.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getObject()));
 //BA.debugLineNum = 1315;BA.debugLine="img0.Gravity = Gravity.FILL";
_img0.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1316;BA.debugLine="img0.Tag = \"$\"";
_img0.setTag((Object)("$"));
 //BA.debugLineNum = 1317;BA.debugLine="Dim xx As Int = pozKutija.IndexOf(dkp)";
_xx = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.IndexOf((Object)(_dkp));
 //BA.debugLineNum = 1318;BA.debugLine="pozKutija.RemoveAt(xx)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.RemoveAt(_xx);
 //BA.debugLineNum = 1319;BA.debugLine="pozKutija.Add(sp)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Add((Object)(_sp));
 //BA.debugLineNum = 1320;BA.debugLine="velikoSlovo = False";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = anywheresoftware.b4a.keywords.Common.False;
 };
 };
 //BA.debugLineNum = 1326;BA.debugLine="If dkp1.EqualsIgnoreCase(\"_\") Then";
if (_dkp1.equalsIgnoreCase("_")) { 
 //BA.debugLineNum = 1327;BA.debugLine="img2.Bitmap = pod1";
_img2.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getObject()));
 //BA.debugLineNum = 1328;BA.debugLine="img2.Tag = \"_\"";
_img2.setTag((Object)("_"));
 //BA.debugLineNum = 1329;BA.debugLine="img2.Gravity = Gravity.FILL";
_img2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 }else if(_dkp1.equalsIgnoreCase("$")) { 
 //BA.debugLineNum = 1331;BA.debugLine="img2.Bitmap = kutija1";
_img2.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getObject()));
 //BA.debugLineNum = 1332;BA.debugLine="img2.Tag = \"$\"";
_img2.setTag((Object)("$"));
 //BA.debugLineNum = 1333;BA.debugLine="img2.Gravity = Gravity.FILL";
_img2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 }else if(_dkp1.equalsIgnoreCase("*")) { 
 //BA.debugLineNum = 1335;BA.debugLine="img2.Bitmap = kutnamj1";
_img2.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.getObject()));
 //BA.debugLineNum = 1336;BA.debugLine="img2.Gravity = Gravity.FILL";
_img2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1337;BA.debugLine="img2.Tag = \"*\"";
_img2.setTag((Object)("*"));
 }else if(_dkp1.equalsIgnoreCase(".")) { 
 //BA.debugLineNum = 1339;BA.debugLine="img2.Bitmap = mjzakut1";
_img2.setBitmap((android.graphics.Bitmap)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getObject()));
 //BA.debugLineNum = 1340;BA.debugLine="img2.Gravity = Gravity.FILL";
_img2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 1341;BA.debugLine="img2.Tag = \".\"";
_img2.setTag((Object)("."));
 };
 };
 //BA.debugLineNum = 1345;BA.debugLine="rijesenje = rijesenje.SubString2(0, rijesenje.Len";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.substring((int) (0),(int) (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.length()-1));
 //BA.debugLineNum = 1346;BA.debugLine="Log(\"rijesenje: \" & rijesenje)";
anywheresoftware.b4a.keywords.Common.LogImpl("65374046","rijesenje: "+mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2,0);
 //BA.debugLineNum = 1347;BA.debugLine="lblSteps.Text = \"Steps: \" & brojKoraka";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.setText(BA.ObjectToCharSequence("Steps: "+BA.NumberToString(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6)));
 //BA.debugLineNum = 1348;BA.debugLine="SetLabelTextSize(lblSteps, lblSteps.Text, 28, 10)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0,mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.getText(),(float) (28),(float) (10));
 //BA.debugLineNum = 1349;BA.debugLine="lblPushes.Text = \"Pushes: \" & brojGuranja";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.setText(BA.ObjectToCharSequence("Pushes: "+BA.NumberToString(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7)));
 //BA.debugLineNum = 1350;BA.debugLine="SetLabelTextSize(lblPushes, lblPushes.Text, 28, 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1,mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getText(),(float) (28),(float) (10));
 //BA.debugLineNum = 1351;BA.debugLine="sv2d.SmoothScrollTo(IzracunajPozicijuX, Izracunaj";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.SmoothScrollTo(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2(),_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3());
 //BA.debugLineNum = 1352;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0() throws Exception{
int _i = 0;
String _m1 = "";
int _j = 0;
String _m2 = "";
int _x = 0;
 //BA.debugLineNum = 1599;BA.debugLine="Sub ProvjeriKutijeNaMjestu";
 //BA.debugLineNum = 1600;BA.debugLine="If slijedeci = False And prethodni = False Then";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0==anywheresoftware.b4a.keywords.Common.False && _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 1601;BA.debugLine="For i = 0 To pozKutijaMjesta.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 1602;BA.debugLine="Dim m1 As String = pozKutijaMjesta.Get(i)";
_m1 = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Get(_i));
 //BA.debugLineNum = 1603;BA.debugLine="For j = 0 To pozKutija.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.getSize()-1);
_j = (int) (0) ;
for (;_j <= limit4 ;_j = _j + step4 ) {
 //BA.debugLineNum = 1604;BA.debugLine="Dim m2 As String = pozKutija.Get(j)";
_m2 = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Get(_j));
 //BA.debugLineNum = 1605;BA.debugLine="If m1.Contains(m2) Then";
if (_m1.contains(_m2)) { 
 //BA.debugLineNum = 1606;BA.debugLine="brJednakihPoz = brJednakihPoz + 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3+1);
 };
 }
};
 }
};
 //BA.debugLineNum = 1610;BA.debugLine="Dim x As Int = pozKutijaMjesta.Size";
_x = mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.getSize();
 //BA.debugLineNum = 1612;BA.debugLine="If brJednakihPoz = x Then";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3==_x) { 
 //BA.debugLineNum = 1614;BA.debugLine="Timer1.Enabled = False";
_vv2.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 1616;BA.debugLine="UsnimiRijesenje";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1();
 //BA.debugLineNum = 1618;BA.debugLine="UsnimiInfo";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2();
 //BA.debugLineNum = 1619;BA.debugLine="brJednakihPoz = 0";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = (int) (0);
 //BA.debugLineNum = 1632;BA.debugLine="panelGotovo.Initialize(\"\")";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 1633;BA.debugLine="panelGotovo.LoadLayout(\"all_finished\")";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.LoadLayout("all_finished",mostCurrent.activityBA);
 //BA.debugLineNum = 1634;BA.debugLine="Activity.AddView(panelGotovo, 0, 14%y, 100%x,";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (14),mostCurrent.activityBA)));
 //BA.debugLineNum = 1635;BA.debugLine="SetLabelTextSize(Label1, Label1.Text, 40, 8)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3(mostCurrent._label1,mostCurrent._label1.getText(),(float) (40),(float) (8));
 //BA.debugLineNum = 1636;BA.debugLine="gif.DisposeFrames";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.DisposeFrames();
 //BA.debugLineNum = 1637;BA.debugLine="gif.Load(File.DirAssets, \"level_finished.gif\")";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Load(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"level_finished.gif");
 //BA.debugLineNum = 1638;BA.debugLine="Frame = 0";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = (int) (0);
 //BA.debugLineNum = 1639;BA.debugLine="Timer5.Interval = gif.Delay(Frame)";
_vv4.setInterval((long) (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Delay(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7)));
 //BA.debugLineNum = 1640;BA.debugLine="ImageView1.Bitmap = gif.Frame(Frame)";
mostCurrent._imageview1.setBitmap(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Frame(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7));
 //BA.debugLineNum = 1641;BA.debugLine="Timer5.Enabled = True";
_vv4.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 1648;BA.debugLine="If snd Then'Or mjuzaZid.EqualsIgnoreCase(\"true\"";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0) { 
 //BA.debugLineNum = 1649;BA.debugLine="sounds.Play(bounceId3, 1, 1, 1, 0, 1)";
_vv5.Play(_vv0,(float) (1),(float) (1),(int) (1),(int) (0),(float) (1));
 };
 //BA.debugLineNum = 1652;BA.debugLine="If recB Then";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 1655;BA.debugLine="rec.StopRecording";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.StopRecording();
 };
 }else {
 //BA.debugLineNum = 1664;BA.debugLine="brJednakihPoz = 0";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = (int) (0);
 };
 };
 //BA.debugLineNum = 1667;BA.debugLine="End Sub";
return "";
}
public static String  _rec_result(boolean _grant) throws Exception{
String _s = "";
int _res = 0;
 //BA.debugLineNum = 1842;BA.debugLine="Sub rec_Result(Grant As Boolean)";
 //BA.debugLineNum = 1844;BA.debugLine="If Grant = True Then";
if (_grant==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 1845;BA.debugLine="Dim s As String = Main.ime_datoteke_za_info";
_s = mostCurrent._vvvvvvv4._ime_datoteke_za_info;
 //BA.debugLineNum = 1846;BA.debugLine="s = s.SubString2(0, s.IndexOf(\".\"))";
_s = _s.substring((int) (0),_s.indexOf("."));
 //BA.debugLineNum = 1848;BA.debugLine="DatZaSnimku = s & \".level_\" & (razina+1)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = _s+".level_"+BA.NumberToString((_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5+1));
 //BA.debugLineNum = 1852;BA.debugLine="If File.Exists(Starter.SourceFolder, DatZaSnimku";
if (anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._vvvvvvv5._vv1,mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7+".mp4")) { 
 //BA.debugLineNum = 1853;BA.debugLine="Dim res As Int = Msgbox2(\"File exists! Overwrit";
_res = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("File exists! Overwrite?"),BA.ObjectToCharSequence("Warning"),"OK","Cancel","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"upitnik.png").getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 1855;BA.debugLine="If res = DialogResponse.POSITIVE Then";
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 1857;BA.debugLine="File.Delete(Starter.SourceFolder, DatZaSnimku)";
anywheresoftware.b4a.keywords.Common.File.Delete(mostCurrent._vvvvvvv5._vv1,mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7);
 //BA.debugLineNum = 1860;BA.debugLine="recB = True";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 1861;BA.debugLine="rec.StartRecording(GetDeviceLayoutValues.Width";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.StartRecording(anywheresoftware.b4a.keywords.Common.GetDeviceLayoutValues(mostCurrent.activityBA).Width,anywheresoftware.b4a.keywords.Common.GetDeviceLayoutValues(mostCurrent.activityBA).Height,mostCurrent._vvvvvvv5._vv1,mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7);
 //BA.debugLineNum = 1862;BA.debugLine="Timer1.Enabled = True";
_vv2.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
 //BA.debugLineNum = 1865;BA.debugLine="recB = True";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 1866;BA.debugLine="rec.StartRecording(GetDeviceLayoutValues.Width,";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.StartRecording(anywheresoftware.b4a.keywords.Common.GetDeviceLayoutValues(mostCurrent.activityBA).Width,anywheresoftware.b4a.keywords.Common.GetDeviceLayoutValues(mostCurrent.activityBA).Height,mostCurrent._vvvvvvv5._vv1,mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7);
 //BA.debugLineNum = 1867;BA.debugLine="Timer1.Enabled = True";
_vv2.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
 //BA.debugLineNum = 1870;BA.debugLine="Msgbox(\"You did not grant permission to record!\"";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("You did not grant permission to record!"),BA.ObjectToCharSequence("Warning"),mostCurrent.activityBA);
 //BA.debugLineNum = 1872;BA.debugLine="recB = False";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 1873;BA.debugLine="rec.StopRecording";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0.StopRecording();
 //BA.debugLineNum = 1874;BA.debugLine="btnRec.SetBackgroundImage(LoadBitmap(File.DirAss";
mostCurrent._btnrec.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"off.png").getObject()));
 //BA.debugLineNum = 1875;BA.debugLine="Timer1.Enabled = False";
_vv2.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 1878;BA.debugLine="Log(Starter.SourceFolder & \"/\" & DatZaSnimku)";
anywheresoftware.b4a.keywords.Common.LogImpl("65963812",mostCurrent._vvvvvvv5._vv1+"/"+mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7,0);
 //BA.debugLineNum = 1879;BA.debugLine="End Sub";
return "";
}
public static String  _sensor_sensorchanged(float[] _values) throws Exception{
 //BA.debugLineNum = 1940;BA.debugLine="Sub sensor_SensorChanged(Values() As Float)";
 //BA.debugLineNum = 1941;BA.debugLine="Azimuth = Values(0)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = _values[(int) (0)];
 //BA.debugLineNum = 1942;BA.debugLine="Pitch = Values(1)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = _values[(int) (1)];
 //BA.debugLineNum = 1943;BA.debugLine="Roll = Values(2)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = _values[(int) (2)];
 //BA.debugLineNum = 1944;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3(anywheresoftware.b4a.objects.LabelWrapper _lbl,String _txt,float _maxfontsize,float _minfontsize) throws Exception{
float _fontsize = 0f;
int _height = 0;
anywheresoftware.b4a.objects.StringUtils _stu = null;
 //BA.debugLineNum = 1808;BA.debugLine="Sub SetLabelTextSize(lbl As Label, txt As String,";
 //BA.debugLineNum = 1809;BA.debugLine="Dim FontSize = MaxFontSize As Float";
_fontsize = _maxfontsize;
 //BA.debugLineNum = 1810;BA.debugLine="Dim Height As Int";
_height = 0;
 //BA.debugLineNum = 1811;BA.debugLine="Dim stu As StringUtils";
_stu = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 1813;BA.debugLine="lbl.TextSize = FontSize";
_lbl.setTextSize(_fontsize);
 //BA.debugLineNum = 1814;BA.debugLine="Height = stu.MeasureMultilineTextHeight(lbl, t";
_height = _stu.MeasureMultilineTextHeight((android.widget.TextView)(_lbl.getObject()),BA.ObjectToCharSequence(_txt));
 //BA.debugLineNum = 1815;BA.debugLine="Do While Height > lbl.Height And FontSize > Mi";
while (_height>_lbl.getHeight() && _fontsize>_minfontsize) {
 //BA.debugLineNum = 1816;BA.debugLine="FontSize = FontSize - 1";
_fontsize = (float) (_fontsize-1);
 //BA.debugLineNum = 1817;BA.debugLine="lbl.TextSize = FontSize";
_lbl.setTextSize(_fontsize);
 //BA.debugLineNum = 1818;BA.debugLine="Height = stu.MeasureMultilineTextHeight(lb";
_height = _stu.MeasureMultilineTextHeight((android.widget.TextView)(_lbl.getObject()),BA.ObjectToCharSequence(_txt));
 }
;
 //BA.debugLineNum = 1820;BA.debugLine="End Sub";
return "";
}
public static String  _slc_endelement(String _uri,String _name,anywheresoftware.b4a.keywords.StringBuilderWrapper _text) throws Exception{
 //BA.debugLineNum = 394;BA.debugLine="Sub slc_EndElement(Uri As String, Name As String,";
 //BA.debugLineNum = 395;BA.debugLine="If slc_parse.Parents.IndexOf(\"LevelCollection\"";
if (_slc_parse.Parents.IndexOf((Object)("LevelCollection"))>-1) { 
 //BA.debugLineNum = 396;BA.debugLine="If Name = \"L\" Then";
if ((_name).equals("L")) { 
 //BA.debugLineNum = 397;BA.debugLine="izgledLevela.Add(text.ToString)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Add((Object)(_text.ToString()));
 };
 };
 //BA.debugLineNum = 400;BA.debugLine="End Sub";
return "";
}
public static String  _slc_startelement(String _uri,String _name,anywheresoftware.b4a.objects.SaxParser.AttributesWrapper _attributes) throws Exception{
 //BA.debugLineNum = 365;BA.debugLine="Sub slc_StartElement (Uri As String, Name As Strin";
 //BA.debugLineNum = 366;BA.debugLine="If Name = \"Level\" Then";
if ((_name).equals("Level")) { 
 //BA.debugLineNum = 368;BA.debugLine="If Attributes.GetValue2(\"\",\"Id\").Length > 0 Then";
if (_attributes.GetValue2("","Id").length()>0) { 
 //BA.debugLineNum = 369;BA.debugLine="brojLevela = brojLevela + 1";
_vvv6 = (int) (_vvv6+1);
 //BA.debugLineNum = 371;BA.debugLine="imeLevela.Add(Attributes.GetValue2(\"\",\"Id\"))";
mostCurrent._vvv4.Add((Object)(_attributes.GetValue2("","Id")));
 }else {
 //BA.debugLineNum = 374;BA.debugLine="imeLevela.Add(\"No Name\")";
mostCurrent._vvv4.Add((Object)("No Name"));
 };
 //BA.debugLineNum = 377;BA.debugLine="If Attributes.GetValue2(\"\",\"Width\").Length > 0 T";
if (_attributes.GetValue2("","Width").length()>0) { 
 //BA.debugLineNum = 378;BA.debugLine="wLevel.Add(Attributes.GetValue2(\"\",\"Width\"))";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Add((Object)(_attributes.GetValue2("","Width")));
 }else {
 //BA.debugLineNum = 381;BA.debugLine="wLevel.Add(\"?\")";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Add((Object)("?"));
 };
 //BA.debugLineNum = 384;BA.debugLine="If Attributes.GetValue2(\"\",\"Height\").Length > 0";
if (_attributes.GetValue2("","Height").length()>0) { 
 //BA.debugLineNum = 385;BA.debugLine="hLevel.Add(Attributes.GetValue2(\"\",\"Height\"))";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Add((Object)(_attributes.GetValue2("","Height")));
 }else {
 //BA.debugLineNum = 388;BA.debugLine="hLevel.Add(\"?\")";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Add((Object)("?"));
 };
 };
 //BA.debugLineNum = 392;BA.debugLine="End Sub";
return "";
}
public static boolean  _sv2d_touch(Object _o,int _action,float _x,float _y,Object _motion) throws Exception{
anywheresoftware.b4a.objects.collections.Map _mopcije = null;
boolean _rb3 = false;
int _stvarnix = 0;
int _stvarniy = 0;
int _iksnovi = 0;
int _ipsilonnovi = 0;
String _s = "";
int _iks = 0;
int _ipsilon = 0;
int _razlikax = 0;
int _razlikay = 0;
 //BA.debugLineNum = 2053;BA.debugLine="Sub sv2d_Touch(o As Object, ACTION As Int, x As Fl";
 //BA.debugLineNum = 2054;BA.debugLine="Dim mOpcije As Map";
_mopcije = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 2055;BA.debugLine="Dim rb3 As Boolean";
_rb3 = false;
 //BA.debugLineNum = 2056;BA.debugLine="mOpcije = File.ReadMap(Starter.SourceFolder, \"opc";
_mopcije = anywheresoftware.b4a.keywords.Common.File.ReadMap(mostCurrent._vvvvvvv5._vv1,"opcije");
 //BA.debugLineNum = 2057;BA.debugLine="rb3 = mOpcije.Get(\"rb3\")";
_rb3 = BA.ObjectToBoolean(_mopcije.Get((Object)("rb3")));
 //BA.debugLineNum = 2059;BA.debugLine="If Timer1.Enabled = False Then Timer1.Enabled = T";
if (_vv2.getEnabled()==anywheresoftware.b4a.keywords.Common.False) { 
_vv2.setEnabled(anywheresoftware.b4a.keywords.Common.True);};
 //BA.debugLineNum = 2066;BA.debugLine="If ACTION = ACTION_DOWN And rb3 Then";
if (_action==_action_down && _rb3) { 
 //BA.debugLineNum = 2067;BA.debugLine="Dim stvarniX As Int = Round(x) + sv2d.Horizontal";
_stvarnix = (int) (anywheresoftware.b4a.keywords.Common.Round(_x)+mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.getHorizontalScrollPosition());
 //BA.debugLineNum = 2068;BA.debugLine="Dim stvarniY As Int = Round(y) + sv2d.VerticalSc";
_stvarniy = (int) (anywheresoftware.b4a.keywords.Common.Round(_y)+mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.getVerticalScrollPosition());
 //BA.debugLineNum = 2069;BA.debugLine="Dim iksNovi As Int = (stvarniX -x3) / tWidth' +";
_iksnovi = (int) ((_stvarnix-_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0)/(double)_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2);
 //BA.debugLineNum = 2071;BA.debugLine="Dim ipsilonNovi As Int = stvarniY / tWidth'(tWid";
_ipsilonnovi = (int) (_stvarniy/(double)_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2);
 //BA.debugLineNum = 2073;BA.debugLine="Dim s As String = karta.Get(\"@\")";
_s = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)("@")));
 //BA.debugLineNum = 2074;BA.debugLine="Dim iks As Int = s.SubString(s.IndexOf(\";\")+1)";
_iks = (int)(Double.parseDouble(_s.substring((int) (_s.indexOf(";")+1))));
 //BA.debugLineNum = 2076;BA.debugLine="Dim ipsilon As Int = s.SubString2(0, s.IndexOf(\"";
_ipsilon = (int)(Double.parseDouble(_s.substring((int) (0),_s.indexOf(";"))));
 //BA.debugLineNum = 2078;BA.debugLine="Dim razlikaX As Int = Abs(iks - iksNovi)";
_razlikax = (int) (anywheresoftware.b4a.keywords.Common.Abs(_iks-_iksnovi));
 //BA.debugLineNum = 2079;BA.debugLine="Dim razlikaY As Int = Abs(ipsilon - ipsilonNovi)";
_razlikay = (int) (anywheresoftware.b4a.keywords.Common.Abs(_ipsilon-_ipsilonnovi));
 //BA.debugLineNum = 2080;BA.debugLine="If iksNovi < iks And razlikaX = 1 And razlikaY =";
if (_iksnovi<_iks && _razlikax==1 && _razlikay==0) { 
 //BA.debugLineNum = 2081;BA.debugLine="PomakniUSmjeru(\"lijevo\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6("lijevo");
 }else if(_iksnovi>_iks && _razlikax==1 && _razlikay==0) { 
 //BA.debugLineNum = 2083;BA.debugLine="PomakniUSmjeru(\"desno\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6("desno");
 }else if(_ipsilonnovi<_ipsilon && _razlikay==1 && _razlikax==0) { 
 //BA.debugLineNum = 2085;BA.debugLine="PomakniUSmjeru(\"gore\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6("gore");
 }else if(_ipsilonnovi>_ipsilon && _razlikay==1 && _razlikax==0) { 
 //BA.debugLineNum = 2087;BA.debugLine="PomakniUSmjeru(\"dole\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6("dole");
 };
 };
 //BA.debugLineNum = 2090;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 2091;BA.debugLine="End Sub";
return false;
}
public static String  _timer1_tick() throws Exception{
 //BA.debugLineNum = 208;BA.debugLine="Sub Timer1_Tick";
 //BA.debugLineNum = 209;BA.debugLine="ProvjeriKutijeNaMjestu";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0();
 //BA.debugLineNum = 210;BA.debugLine="End Sub";
return "";
}
public static String  _timer3_tick() throws Exception{
int _p = 0;
int _r = 0;
int _a = 0;
 //BA.debugLineNum = 222;BA.debugLine="Sub Timer3_Tick";
 //BA.debugLineNum = 223;BA.debugLine="Log(\"pitch: \" & NumberFormat(Pitch, 1, 0))";
anywheresoftware.b4a.keywords.Common.LogImpl("64653057","pitch: "+anywheresoftware.b4a.keywords.Common.NumberFormat(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3,(int) (1),(int) (0)),0);
 //BA.debugLineNum = 224;BA.debugLine="Log(\"roll: \" & NumberFormat(Roll, 1, 0))";
anywheresoftware.b4a.keywords.Common.LogImpl("64653058","roll: "+anywheresoftware.b4a.keywords.Common.NumberFormat(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4,(int) (1),(int) (0)),0);
 //BA.debugLineNum = 225;BA.debugLine="Log(\"azimuth: \" & NumberFormat(Azimuth, 1, 0))";
anywheresoftware.b4a.keywords.Common.LogImpl("64653059","azimuth: "+anywheresoftware.b4a.keywords.Common.NumberFormat(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2,(int) (1),(int) (0)),0);
 //BA.debugLineNum = 226;BA.debugLine="Dim p As Int = NumberFormat(Pitch, 1, 0)";
_p = (int)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.NumberFormat(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3,(int) (1),(int) (0))));
 //BA.debugLineNum = 227;BA.debugLine="Dim r As Int = NumberFormat(Roll, 1, 0)";
_r = (int)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.NumberFormat(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4,(int) (1),(int) (0))));
 //BA.debugLineNum = 228;BA.debugLine="Dim a As Int = NumberFormat(Azimuth, 1, 0)";
_a = (int)(Double.parseDouble(anywheresoftware.b4a.keywords.Common.NumberFormat(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2,(int) (1),(int) (0))));
 //BA.debugLineNum = 229;BA.debugLine="If p > 2 And a >= 0 Then	' desno";
if (_p>2 && _a>=0) { 
 //BA.debugLineNum = 230;BA.debugLine="PomakniUSmjeru(\"desno\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6("desno");
 }else if(_p<-2 && _a>0) { 
 //BA.debugLineNum = 232;BA.debugLine="PomakniUSmjeru(\"lijevo\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6("lijevo");
 }else if(_r>0 && _a>3) { 
 //BA.debugLineNum = 234;BA.debugLine="PomakniUSmjeru(\"dole\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6("dole");
 }else if(_r>0 && _a<-3) { 
 //BA.debugLineNum = 236;BA.debugLine="PomakniUSmjeru(\"gore\")";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6("gore");
 };
 //BA.debugLineNum = 238;BA.debugLine="End Sub";
return "";
}
public static String  _timer5_tick() throws Exception{
 //BA.debugLineNum = 240;BA.debugLine="Sub Timer5_Tick";
 //BA.debugLineNum = 241;BA.debugLine="Timer5.Enabled = False";
_vv4.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 242;BA.debugLine="Frame = Frame + 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7+1);
 //BA.debugLineNum = 243;BA.debugLine="If Frame >= gif.FrameCount Then";
if (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7>=mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.getFrameCount()) { 
 //BA.debugLineNum = 244;BA.debugLine="Frame = 0";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = (int) (0);
 };
 //BA.debugLineNum = 246;BA.debugLine="Timer5.Interval = gif.Delay(Frame)";
_vv4.setInterval((long) (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Delay(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7)));
 //BA.debugLineNum = 247;BA.debugLine="ImageView1.Bitmap = gif.Frame(Frame)";
mostCurrent._imageview1.setBitmap(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Frame(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7));
 //BA.debugLineNum = 248;BA.debugLine="Timer5.Enabled = True";
_vv4.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 249;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4() throws Exception{
anywheresoftware.b4a.objects.collections.List _list_info = null;
 //BA.debugLineNum = 1709;BA.debugLine="Sub UcitajInfo";
 //BA.debugLineNum = 1710;BA.debugLine="Dim list_info As List";
_list_info = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1712;BA.debugLine="list_info.Initialize";
_list_info.Initialize();
 //BA.debugLineNum = 1713;BA.debugLine="list_info = File.ReadList(Starter.SourceFolder, M";
_list_info = anywheresoftware.b4a.keywords.Common.File.ReadList(mostCurrent._vvvvvvv5._vv1,mostCurrent._vvvvvvv4._ime_datoteke_za_info+".info");
 //BA.debugLineNum = 1717;BA.debugLine="razina = list_info.Get(0)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = (int)(BA.ObjectToNumber(_list_info.Get((int) (0))));
 //BA.debugLineNum = 1718;BA.debugLine="razina = razina + 1";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = (int) (_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5+1);
 //BA.debugLineNum = 1719;BA.debugLine="ukupno_razina = list_info.Get(1)";
_ukupno_razina = (int)(BA.ObjectToNumber(_list_info.Get((int) (1))));
 //BA.debugLineNum = 1720;BA.debugLine="datZaParsanje = list_info.Get(2)";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = BA.ObjectToString(_list_info.Get((int) (2)));
 //BA.debugLineNum = 1721;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2() throws Exception{
anywheresoftware.b4a.objects.collections.List _list_info = null;
 //BA.debugLineNum = 1696;BA.debugLine="Sub UsnimiInfo";
 //BA.debugLineNum = 1697;BA.debugLine="Dim list_info As List";
_list_info = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1699;BA.debugLine="list_info.Initialize";
_list_info.Initialize();
 //BA.debugLineNum = 1701;BA.debugLine="list_info.Add(razina)";
_list_info.Add((Object)(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5));
 //BA.debugLineNum = 1702;BA.debugLine="list_info.Add(ukupno_razina)";
_list_info.Add((Object)(_ukupno_razina));
 //BA.debugLineNum = 1703;BA.debugLine="list_info.Add(Main.ime_datoteke_za_info)";
_list_info.Add((Object)(mostCurrent._vvvvvvv4._ime_datoteke_za_info));
 //BA.debugLineNum = 1704;BA.debugLine="File.WriteList(Starter.SourceFolder, Main.ime_dat";
anywheresoftware.b4a.keywords.Common.File.WriteList(mostCurrent._vvvvvvv5._vv1,mostCurrent._vvvvvvv4._ime_datoteke_za_info+".info",_list_info);
 //BA.debugLineNum = 1707;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1() throws Exception{
String _s = "";
String _dat = "";
anywheresoftware.b4a.objects.collections.List _sol_info = null;
 //BA.debugLineNum = 1669;BA.debugLine="Sub UsnimiRijesenje";
 //BA.debugLineNum = 1670;BA.debugLine="Dim s As String = Main.ime_datoteke_za_info";
_s = mostCurrent._vvvvvvv4._ime_datoteke_za_info;
 //BA.debugLineNum = 1671;BA.debugLine="s = s.SubString2(0, s.IndexOf(\".\"))";
_s = _s.substring((int) (0),_s.indexOf("."));
 //BA.debugLineNum = 1673;BA.debugLine="Log(razina)";
anywheresoftware.b4a.keywords.Common.LogImpl("65570564",BA.NumberToString(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5),0);
 //BA.debugLineNum = 1675;BA.debugLine="Dim dat As String  = s & \".level_\" & (razina+1) &";
_dat = _s+".level_"+BA.NumberToString((_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5+1))+".mp4.solution";
 //BA.debugLineNum = 1676;BA.debugLine="Dim sol_info As List";
_sol_info = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1678;BA.debugLine="sol_info.Initialize";
_sol_info.Initialize();
 //BA.debugLineNum = 1679;BA.debugLine="sol_info.Add(Main.zaSolutionIme)";
_sol_info.Add((Object)(mostCurrent._vvvvvvv4._vvv0));
 //BA.debugLineNum = 1680;BA.debugLine="sol_info.Add(brojKoraka)";
_sol_info.Add((Object)(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6));
 //BA.debugLineNum = 1681;BA.debugLine="sol_info.Add(brojGuranja)";
_sol_info.Add((Object)(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7));
 //BA.debugLineNum = 1682;BA.debugLine="sol_info.Add(rijesenje)";
_sol_info.Add((Object)(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2));
 //BA.debugLineNum = 1684;BA.debugLine="File.WriteList(Starter.SourceFolder, dat, sol_inf";
anywheresoftware.b4a.keywords.Common.File.WriteList(mostCurrent._vvvvvvv5._vv1,_dat,_sol_info);
 //BA.debugLineNum = 1685;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4(String _smjer) throws Exception{
int _redak = 0;
int _stupac = 0;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
String _starapoz = "";
String _npt1 = "";
int _npt2 = 0;
String _novapoz = "";
String _dvamjodigraca = "";
 //BA.debugLineNum = 1171;BA.debugLine="Sub VratiPotez(smjer As String)";
 //BA.debugLineNum = 1176;BA.debugLine="Dim redak, stupac As Int : Dim cd As ColorDrawabl";
_redak = 0;
_stupac = 0;
 //BA.debugLineNum = 1176;BA.debugLine="Dim redak, stupac As Int : Dim cd As ColorDrawabl";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 1178;BA.debugLine="cd.Initialize(Colors.RGB(115, 175, 199), 0)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (115),(int) (175),(int) (199)),(int) (0));
 //BA.debugLineNum = 1182;BA.debugLine="Select smjer";
switch (BA.switchObjectToInt(_smjer,"gore","lijevo","desno","dole")) {
case 0: {
 //BA.debugLineNum = 1184;BA.debugLine="redak = -1";
_redak = (int) (-1);
 //BA.debugLineNum = 1186;BA.debugLine="Dim staraPoz As String = karta.Get(\"@\")";
_starapoz = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)("@")));
 //BA.debugLineNum = 1189;BA.debugLine="Dim npt1 As String = staraPoz.SubString2(0, sta";
_npt1 = _starapoz.substring((int) (0),_starapoz.indexOf(";"));
 //BA.debugLineNum = 1190;BA.debugLine="Dim npt2 As Int = npt1 + redak";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_redak);
 //BA.debugLineNum = 1191;BA.debugLine="Dim novaPoz As String = npt2 & staraPoz.SubStri";
_novapoz = BA.NumberToString(_npt2)+_starapoz.substring(_starapoz.indexOf(";"));
 //BA.debugLineNum = 1194;BA.debugLine="Dim npt1 As String = staraPoz.SubString2(0, nov";
_npt1 = _starapoz.substring((int) (0),_novapoz.indexOf(";"));
 //BA.debugLineNum = 1195;BA.debugLine="Dim npt2 As Int = npt1 - redak";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))-_redak);
 //BA.debugLineNum = 1196;BA.debugLine="Dim dvaMjOdIgraca As String = npt2 & staraPoz.S";
_dvamjodigraca = BA.NumberToString(_npt2)+_starapoz.substring(_starapoz.indexOf(";"));
 //BA.debugLineNum = 1197;BA.debugLine="ProvjeriIPomakniUnatrag(staraPoz, novaPoz, dvaM";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(_starapoz,_novapoz,_dvamjodigraca,(int) (1));
 break; }
case 1: {
 //BA.debugLineNum = 1200;BA.debugLine="stupac = -1";
_stupac = (int) (-1);
 //BA.debugLineNum = 1202;BA.debugLine="Dim staraPoz As String = karta.Get(\"@\")";
_starapoz = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)("@")));
 //BA.debugLineNum = 1205;BA.debugLine="Dim npt1 As String = staraPoz.SubString(staraPo";
_npt1 = _starapoz.substring((int) (_starapoz.indexOf(";")+1));
 //BA.debugLineNum = 1206;BA.debugLine="Dim npt2 As Int = npt1 + stupac";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_stupac);
 //BA.debugLineNum = 1207;BA.debugLine="Dim novaPoz As String = staraPoz.SubString2(0,";
_novapoz = _starapoz.substring((int) (0),(int) (_starapoz.indexOf(";")+1))+BA.NumberToString(_npt2);
 //BA.debugLineNum = 1210;BA.debugLine="Dim npt1 As String = staraPoz.SubString(novaPoz";
_npt1 = _starapoz.substring((int) (_novapoz.indexOf(";")+1));
 //BA.debugLineNum = 1211;BA.debugLine="Dim npt2 As Int = npt1 - stupac";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))-_stupac);
 //BA.debugLineNum = 1212;BA.debugLine="Dim dvaMjOdIgraca As String = staraPoz.SubStrin";
_dvamjodigraca = _starapoz.substring((int) (0),(int) (_starapoz.indexOf(";")+1))+BA.NumberToString(_npt2);
 //BA.debugLineNum = 1213;BA.debugLine="ProvjeriIPomakniUnatrag(staraPoz, novaPoz, dvaM";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(_starapoz,_novapoz,_dvamjodigraca,(int) (2));
 break; }
case 2: {
 //BA.debugLineNum = 1216;BA.debugLine="stupac = 1";
_stupac = (int) (1);
 //BA.debugLineNum = 1218;BA.debugLine="Dim staraPoz As String = karta.Get(\"@\")";
_starapoz = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)("@")));
 //BA.debugLineNum = 1221;BA.debugLine="Dim npt1 As String = staraPoz.SubString(staraPo";
_npt1 = _starapoz.substring((int) (_starapoz.indexOf(";")+1));
 //BA.debugLineNum = 1222;BA.debugLine="Dim npt2 As Int = npt1 + stupac";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_stupac);
 //BA.debugLineNum = 1223;BA.debugLine="Dim novaPoz As String = staraPoz.SubString2(0,";
_novapoz = _starapoz.substring((int) (0),(int) (_starapoz.indexOf(";")+1))+BA.NumberToString(_npt2);
 //BA.debugLineNum = 1226;BA.debugLine="Dim npt1 As String = staraPoz.SubString(novaPoz";
_npt1 = _starapoz.substring((int) (_novapoz.indexOf(";")+1));
 //BA.debugLineNum = 1227;BA.debugLine="Dim npt2 As Int = npt1 - stupac";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))-_stupac);
 //BA.debugLineNum = 1228;BA.debugLine="Dim dvaMjOdIgraca As String = staraPoz.SubStrin";
_dvamjodigraca = _starapoz.substring((int) (0),(int) (_starapoz.indexOf(";")+1))+BA.NumberToString(_npt2);
 //BA.debugLineNum = 1229;BA.debugLine="ProvjeriIPomakniUnatrag(staraPoz, novaPoz, dvaM";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(_starapoz,_novapoz,_dvamjodigraca,(int) (4));
 break; }
case 3: {
 //BA.debugLineNum = 1232;BA.debugLine="redak = 1";
_redak = (int) (1);
 //BA.debugLineNum = 1235;BA.debugLine="Dim staraPoz As String = karta.Get(\"@\")";
_starapoz = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get((Object)("@")));
 //BA.debugLineNum = 1238;BA.debugLine="Dim npt1 As String = staraPoz.SubString2(0, sta";
_npt1 = _starapoz.substring((int) (0),_starapoz.indexOf(";"));
 //BA.debugLineNum = 1239;BA.debugLine="Dim npt2 As Int = npt1 + redak";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))+_redak);
 //BA.debugLineNum = 1240;BA.debugLine="Dim novaPoz As String = npt2 & staraPoz.SubStri";
_novapoz = BA.NumberToString(_npt2)+_starapoz.substring(_starapoz.indexOf(";"));
 //BA.debugLineNum = 1243;BA.debugLine="Dim npt1 As String = staraPoz.SubString2(0, nov";
_npt1 = _starapoz.substring((int) (0),_novapoz.indexOf(";"));
 //BA.debugLineNum = 1244;BA.debugLine="Dim npt2 As Int = npt1 - redak";
_npt2 = (int) ((double)(Double.parseDouble(_npt1))-_redak);
 //BA.debugLineNum = 1245;BA.debugLine="Dim dvaMjOdIgraca As String = npt2 & staraPoz.S";
_dvamjodigraca = BA.NumberToString(_npt2)+_starapoz.substring(_starapoz.indexOf(";"));
 //BA.debugLineNum = 1246;BA.debugLine="ProvjeriIPomakniUnatrag(staraPoz, novaPoz, dvaM";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7(_starapoz,_novapoz,_dvamjodigraca,(int) (3));
 break; }
}
;
 //BA.debugLineNum = 1249;BA.debugLine="sv2d.SmoothScrollTo(IzracunajPozicijuX, Izracunaj";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.SmoothScrollTo(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2(),_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3());
 //BA.debugLineNum = 1250;BA.debugLine="End Sub";
return "";
}
}
