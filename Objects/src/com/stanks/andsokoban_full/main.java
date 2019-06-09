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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "com.stanks.andsokoban_full", "com.stanks.andsokoban_full.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "com.stanks.andsokoban_full", "com.stanks.andsokoban_full.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.stanks.andsokoban_full.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
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
public static anywheresoftware.b4a.objects.SaxParser _slc_parse = null;
public static anywheresoftware.b4a.objects.collections.List _vvv7 = null;
public static anywheresoftware.b4a.objects.collections.Map _vvv4 = null;
public static String _vvv0 = "";
public static String _ime_dat_za_video = "";
public static String _vvv5 = "";
public static int _vvv6 = 0;
public static String _ime_datoteke_za_info = "";
public flm.b4a.archiver.ArchiverForB4A _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _spnlevelstitleletter = null;
public b4a.example3.customlistview _clvlevelswithtitleletter = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = null;
public anywheresoftware.b4a.objects.collections.List _ime_dat = null;
public static String _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = "";
public anywheresoftware.b4a.objects.LabelWrapper _lbltitleautor = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblinfo = null;
public b4a.example.dateutils _vvvvvvv3 = null;
public com.stanks.andsokoban_full.starter _vvvvvvv5 = null;
public com.stanks.andsokoban_full.play _vvvvvvv6 = null;
public com.stanks.andsokoban_full.odabir _vvvvvvv7 = null;
public com.stanks.andsokoban_full.video _vvvvvvv0 = null;
public com.stanks.andsokoban_full.rijesenja _vvvvvvvv1 = null;
public com.stanks.andsokoban_full.opcije _vvvvvvvv2 = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (play.mostCurrent != null);
vis = vis | (odabir.mostCurrent != null);
vis = vis | (video.mostCurrent != null);
vis = vis | (rijesenja.mostCurrent != null);
vis = vis | (opcije.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _mopcije = null;
 //BA.debugLineNum = 49;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 52;BA.debugLine="Activity.LoadLayout(\"mejn\")";
mostCurrent._activity.LoadLayout("mejn",mostCurrent.activityBA);
 //BA.debugLineNum = 54;BA.debugLine="For i = 0 To letters.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 55;BA.debugLine="spnLevelsTitleLetter.Add(\"Titles with \" & letter";
mostCurrent._spnlevelstitleletter.Add("Titles with "+BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.Get(_i)));
 }
};
 //BA.debugLineNum = 58;BA.debugLine="slc_parse.Initialize";
_slc_parse.Initialize(processBA);
 //BA.debugLineNum = 59;BA.debugLine="listaDatZaVideo.Initialize";
_vvv7.Initialize();
 //BA.debugLineNum = 60;BA.debugLine="imeLevela.Initialize	' ime razine";
_vvv4.Initialize();
 //BA.debugLineNum = 61;BA.debugLine="Title.Initialize";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Initialize();
 //BA.debugLineNum = 62;BA.debugLine="Description.Initialize";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Initialize();
 //BA.debugLineNum = 63;BA.debugLine="Email.Initialize";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Initialize();
 //BA.debugLineNum = 64;BA.debugLine="Url.Initialize";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Initialize();
 //BA.debugLineNum = 65;BA.debugLine="Autor.Initialize";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Initialize();
 //BA.debugLineNum = 66;BA.debugLine="brojRazina.Initialize";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Initialize();
 //BA.debugLineNum = 67;BA.debugLine="ime_dat.Initialize";
mostCurrent._ime_dat.Initialize();
 //BA.debugLineNum = 69;BA.debugLine="slovoOdabira = \"#\"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = "#";
 //BA.debugLineNum = 70;BA.debugLine="OtvoriIzBaze";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0();
 //BA.debugLineNum = 72;BA.debugLine="For i = 0 To clvLevelsWithTitleLetter.Size - 1";
{
final int step17 = 1;
final int limit17 = (int) (mostCurrent._clvlevelswithtitleletter._getsize()-1);
_i = (int) (0) ;
for (;_i <= limit17 ;_i = _i + step17 ) {
 }
};
 //BA.debugLineNum = 80;BA.debugLine="If File.Exists(Starter.SourceFolder, \"skins.zip\")";
if (anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._vvvvvvv5._vv1,"skins.zip")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 81;BA.debugLine="File.Copy(File.DirAssets, \"skins.zip\", Starter.S";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"skins.zip",mostCurrent._vvvvvvv5._vv1,"skins.zip");
 //BA.debugLineNum = 82;BA.debugLine="RaspakirajSkinoveIzArhive";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1();
 };
 //BA.debugLineNum = 85;BA.debugLine="If File.Exists(Starter.SourceFolder, \"opcije\") =";
if (anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._vvvvvvv5._vv1,"opcije")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 86;BA.debugLine="Dim mOpcije As Map";
_mopcije = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 88;BA.debugLine="mOpcije.Initialize";
_mopcije.Initialize();
 //BA.debugLineNum = 89;BA.debugLine="mOpcije.Put(\"cb\", False)";
_mopcije.Put((Object)("cb"),(Object)(anywheresoftware.b4a.keywords.Common.False));
 //BA.debugLineNum = 90;BA.debugLine="mOpcije.Put(\"rb2\", True)";
_mopcije.Put((Object)("rb2"),(Object)(anywheresoftware.b4a.keywords.Common.True));
 //BA.debugLineNum = 91;BA.debugLine="mOpcije.Put(\"rb3\", False)";
_mopcije.Put((Object)("rb3"),(Object)(anywheresoftware.b4a.keywords.Common.False));
 //BA.debugLineNum = 92;BA.debugLine="mOpcije.Put(\"rb4\", False)";
_mopcije.Put((Object)("rb4"),(Object)(anywheresoftware.b4a.keywords.Common.False));
 //BA.debugLineNum = 93;BA.debugLine="mOpcije.Put(\"skin\", \"1yoshi-32\")";
_mopcije.Put((Object)("skin"),(Object)("1yoshi-32"));
 //BA.debugLineNum = 94;BA.debugLine="mOpcije.Put(\"mjuzaZid\", False)";
_mopcije.Put((Object)("mjuzaZid"),(Object)(anywheresoftware.b4a.keywords.Common.False));
 //BA.debugLineNum = 95;BA.debugLine="File.WriteMap(Starter.SourceFolder, \"opcije\", mO";
anywheresoftware.b4a.keywords.Common.File.WriteMap(mostCurrent._vvvvvvv5._vv1,"opcije",_mopcije);
 };
 //BA.debugLineNum = 103;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
 //BA.debugLineNum = 104;BA.debugLine="Msgbox(\"Remeber to use long tap on (almost) all";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Remeber to use long tap on (almost) all buttons in any activity to get more info about action with button!"),BA.ObjectToCharSequence("Info"),mostCurrent.activityBA);
 };
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 421;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 422;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
anywheresoftware.b4a.phone.Phone _ph = null;
 //BA.debugLineNum = 415;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 416;BA.debugLine="Dim ph As Phone";
_ph = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 418;BA.debugLine="ph.SetScreenOrientation(1)";
_ph.SetScreenOrientation(processBA,(int) (1));
 //BA.debugLineNum = 419;BA.debugLine="End Sub";
return "";
}
public static String  _btn_click() throws Exception{
anywheresoftware.b4a.objects.ButtonWrapper _gumb1 = null;
 //BA.debugLineNum = 392;BA.debugLine="Sub btn_Click";
 //BA.debugLineNum = 393;BA.debugLine="Dim gumb1 As Button";
_gumb1 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 395;BA.debugLine="gumb1 = Sender";
_gumb1.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 397;BA.debugLine="Select gumb1.Tag";
switch (BA.switchObjectToInt(_gumb1.getTag(),(Object)("opt"),(Object)("o"))) {
case 0: {
 //BA.debugLineNum = 404;BA.debugLine="StartActivity(opcije)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._vvvvvvvv2.getObject()));
 break; }
case 1: {
 //BA.debugLineNum = 407;BA.debugLine="Msgbox(\"A lot of sokoban(c) level packs (17k+?)";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("A lot of sokoban(c) level packs (17k+?)"),BA.ObjectToCharSequence("About andSokoban v1.0b2"),mostCurrent.activityBA);
 break; }
}
;
 //BA.debugLineNum = 413;BA.debugLine="End Sub";
return "";
}
public static String  _clvlevelswithtitleletter_itemclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 432;BA.debugLine="Sub clvLevelsWithTitleLetter_ItemClick (Index As I";
 //BA.debugLineNum = 434;BA.debugLine="End Sub";
return "";
}
public static String  _clvlevelswithtitleletter_visiblerangechanged(int _firstindex,int _lastindex) throws Exception{
 //BA.debugLineNum = 436;BA.debugLine="Sub clvLevelsWithTitleLetter_VisibleRangeChanged (";
 //BA.debugLineNum = 438;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.PanelWrapper  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2(String _t1,String _ime_d,String _br,int _width,int _height) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
anywheresoftware.b4a.objects.collections.List _list_info = null;
int _x = 0;
 //BA.debugLineNum = 158;BA.debugLine="Sub CreateListItem(t1 As String, ime_d As String,";
 //BA.debugLineNum = 159;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 161;BA.debugLine="p.Initialize(\"\")";
_p.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 163;BA.debugLine="p.SetLayout(0, 0, Width, Height)";
_p.SetLayout((int) (0),(int) (0),_width,_height);
 //BA.debugLineNum = 164;BA.debugLine="p.LoadLayout(\"stavka\")";
_p.LoadLayout("stavka",mostCurrent.activityBA);
 //BA.debugLineNum = 165;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 166;BA.debugLine="cd.Initialize(Colors.ARGB(255, 245, 245, 220), 0)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (255),(int) (245),(int) (245),(int) (220)),(int) (0));
 //BA.debugLineNum = 167;BA.debugLine="p.Background = cd";
_p.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
 //BA.debugLineNum = 169;BA.debugLine="lblTitleAutor.Text = t1";
mostCurrent._lbltitleautor.setText(BA.ObjectToCharSequence(_t1));
 //BA.debugLineNum = 170;BA.debugLine="SetLabelTextSize(lblTitleAutor, lblTitleAutor.Tex";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3(mostCurrent._lbltitleautor,mostCurrent._lbltitleautor.getText(),(float) (14),(float) (8));
 //BA.debugLineNum = 174;BA.debugLine="If File.Exists(Starter.SourceFolder, ime_d & \".in";
if (anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._vvvvvvv5._vv1,_ime_d+".info")) { 
 //BA.debugLineNum = 175;BA.debugLine="Log(\"info postoji!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("635192849","info postoji!",0);
 //BA.debugLineNum = 176;BA.debugLine="Dim list_info As List";
_list_info = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 177;BA.debugLine="list_info.Initialize";
_list_info.Initialize();
 //BA.debugLineNum = 178;BA.debugLine="list_info = File.ReadList(Starter.SourceFolder,";
_list_info = anywheresoftware.b4a.keywords.Common.File.ReadList(mostCurrent._vvvvvvv5._vv1,_ime_d+".info");
 //BA.debugLineNum = 179;BA.debugLine="Dim x As Int = list_info.Get(0)";
_x = (int)(BA.ObjectToNumber(_list_info.Get((int) (0))));
 //BA.debugLineNum = 180;BA.debugLine="x = x + 1";
_x = (int) (_x+1);
 //BA.debugLineNum = 181;BA.debugLine="lblInfo.Text = \"Finished: \" & x & \"/\" & list_inf";
mostCurrent._lblinfo.setText(BA.ObjectToCharSequence("Finished: "+BA.NumberToString(_x)+"/"+BA.ObjectToString(_list_info.Get((int) (1)))));
 }else {
 //BA.debugLineNum = 183;BA.debugLine="lblInfo.Text = \"Finished: 0/\" & br";
mostCurrent._lblinfo.setText(BA.ObjectToCharSequence("Finished: 0/"+_br));
 };
 //BA.debugLineNum = 185;BA.debugLine="SetLabelTextSize(lblInfo, lblInfo.Text, 18, 8)";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3(mostCurrent._lblinfo,mostCurrent._lblinfo.getText(),(float) (18),(float) (8));
 //BA.debugLineNum = 187;BA.debugLine="Return p";
if (true) return _p;
 //BA.debugLineNum = 188;BA.debugLine="End Sub";
return null;
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 38;BA.debugLine="Dim arch As Archiver";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = new flm.b4a.archiver.ArchiverForB4A();
 //BA.debugLineNum = 39;BA.debugLine="Private spnLevelsTitleLetter As Spinner";
mostCurrent._spnlevelstitleletter = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private clvLevelsWithTitleLetter As CustomListVie";
mostCurrent._clvlevelswithtitleletter = new b4a.example3.customlistview();
 //BA.debugLineNum = 41;BA.debugLine="Dim letters As List = Array As String(\"#\", \"A\", \"";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = new anywheresoftware.b4a.objects.collections.List();
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1 = anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"#","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"});
 //BA.debugLineNum = 42;BA.debugLine="Dim Title, Description, Email, Url, Autor, brojRa";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = new anywheresoftware.b4a.objects.collections.List();
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2 = new anywheresoftware.b4a.objects.collections.List();
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3 = new anywheresoftware.b4a.objects.collections.List();
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4 = new anywheresoftware.b4a.objects.collections.List();
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5 = new anywheresoftware.b4a.objects.collections.List();
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 43;BA.debugLine="Dim ime_dat As List";
mostCurrent._ime_dat = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 44;BA.debugLine="Dim slovoOdabira As String";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = "";
 //BA.debugLineNum = 45;BA.debugLine="Private lblTitleAutor As Label";
mostCurrent._lbltitleautor = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private lblInfo As Label";
mostCurrent._lblinfo = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
public static String  _imgdelete_click() throws Exception{
int _index = 0;
anywheresoftware.b4a.sql.SQL.CursorWrapper _curs = null;
String _q = "";
int _i = 0;
String _ime_datoteke = "";
String _bl = "";
int _res = 0;
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 190;BA.debugLine="Sub imgDelete_Click";
 //BA.debugLineNum = 191;BA.debugLine="Dim index As Int";
_index = 0;
 //BA.debugLineNum = 192;BA.debugLine="Dim curs As Cursor";
_curs = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 194;BA.debugLine="index = clvLevelsWithTitleLetter.GetItemFromView(";
_index = mostCurrent._clvlevelswithtitleletter._getitemfromview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA))));
 //BA.debugLineNum = 195;BA.debugLine="Dim q As String = \"SELECT imeDat, brojRazina FROM";
_q = "SELECT imeDat, brojRazina FROM "+mostCurrent._vvvvvvv5._v5+" WHERE title = '"+BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Get(_index))+"'";
 //BA.debugLineNum = 196;BA.debugLine="curs = Starter.upit.ExecQuery(q)";
_curs.setObject((android.database.Cursor)(mostCurrent._vvvvvvv5._v6.ExecQuery(_q)));
 //BA.debugLineNum = 197;BA.debugLine="If curs.RowCount > 0 Then";
if (_curs.getRowCount()>0) { 
 //BA.debugLineNum = 198;BA.debugLine="For i = 0 To curs.RowCount-1";
{
final int step7 = 1;
final int limit7 = (int) (_curs.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
 //BA.debugLineNum = 199;BA.debugLine="curs.Position = i";
_curs.setPosition(_i);
 //BA.debugLineNum = 200;BA.debugLine="Dim ime_datoteke As String = curs.GetString(\"im";
_ime_datoteke = _curs.GetString("imeDat");
 //BA.debugLineNum = 201;BA.debugLine="Dim bl As String = curs.GetString(\"brojRazina\")";
_bl = _curs.GetString("brojRazina");
 }
};
 };
 //BA.debugLineNum = 205;BA.debugLine="Dim res As Int = Msgbox2(\"Really delete stats?\",";
_res = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Really delete stats?"),BA.ObjectToCharSequence("Warning"),"Yes","","No",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"upitnik.png",anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32))).getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 207;BA.debugLine="If res = DialogResponse.POSITIVE Then";
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 209;BA.debugLine="If File.Exists(Starter.SourceFolder, ime_datotek";
if (anywheresoftware.b4a.keywords.Common.File.Exists(mostCurrent._vvvvvvv5._vv1,_ime_datoteke+".info")) { 
 //BA.debugLineNum = 210;BA.debugLine="File.Delete(Starter.SourceFolder, ime_datoteke";
anywheresoftware.b4a.keywords.Common.File.Delete(mostCurrent._vvvvvvv5._vv1,_ime_datoteke+".info");
 //BA.debugLineNum = 211;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 212;BA.debugLine="pnl = clvLevelsWithTitleLetter.GetPanel(index)";
_pnl.setObject((android.view.ViewGroup)(mostCurrent._clvlevelswithtitleletter._getpanel(_index).getObject()));
 //BA.debugLineNum = 213;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 214;BA.debugLine="lbl = pnl.GetView(7)";
_lbl.setObject((android.widget.TextView)(_pnl.GetView((int) (7)).getObject()));
 //BA.debugLineNum = 215;BA.debugLine="lbl.Text = \"Finished: 0/\" & bl";
_lbl.setText(BA.ObjectToCharSequence("Finished: 0/"+_bl));
 }else {
 //BA.debugLineNum = 217;BA.debugLine="Msgbox(\"No stats for delete!\", \"Warning\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("No stats for delete!"),BA.ObjectToCharSequence("Warning"),mostCurrent.activityBA);
 };
 };
 //BA.debugLineNum = 220;BA.debugLine="End Sub";
return "";
}
public static String  _imgdelete_longclick() throws Exception{
 //BA.debugLineNum = 364;BA.debugLine="Sub imgDelete_LongClick";
 //BA.debugLineNum = 365;BA.debugLine="Msgbox(\"Delete stats for all levels\", \"Info\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Delete stats for all levels"),BA.ObjectToCharSequence("Info"),mostCurrent.activityBA);
 //BA.debugLineNum = 366;BA.debugLine="End Sub";
return "";
}
public static String  _imgemail_click() throws Exception{
int _index = 0;
String _s = "";
int _res = 0;
anywheresoftware.b4a.objects.IntentWrapper _intent1 = null;
 //BA.debugLineNum = 275;BA.debugLine="Sub imgEmail_Click";
 //BA.debugLineNum = 276;BA.debugLine="Dim index As Int";
_index = 0;
 //BA.debugLineNum = 278;BA.debugLine="index = clvLevelsWithTitleLetter.GetItemFromView(";
_index = mostCurrent._clvlevelswithtitleletter._getitemfromview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA))));
 //BA.debugLineNum = 280;BA.debugLine="Dim s As String = Email.Get(index)";
_s = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Get(_index));
 //BA.debugLineNum = 281;BA.debugLine="If s.Length > 0 Then";
if (_s.length()>0) { 
 //BA.debugLineNum = 282;BA.debugLine="Log(Email.Get(index))";
anywheresoftware.b4a.keywords.Common.LogImpl("636044807",BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Get(_index)),0);
 //BA.debugLineNum = 283;BA.debugLine="Dim res As Int = Msgbox2(\"Send e-mail to author?";
_res = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Send e-mail to author?"),BA.ObjectToCharSequence("Question"),"Yes","","No",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"upitnik.png",anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32))).getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 285;BA.debugLine="If res = DialogResponse.POSITIVE Then";
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 286;BA.debugLine="Dim intent1 As Intent";
_intent1 = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 287;BA.debugLine="intent1.Initialize(intent1.ACTION_VIEW, \"mailto";
_intent1.Initialize(_intent1.ACTION_VIEW,"mailto:"+BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Get(_index)));
 //BA.debugLineNum = 288;BA.debugLine="StartActivity(intent1)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_intent1.getObject()));
 };
 }else {
 //BA.debugLineNum = 291;BA.debugLine="Msgbox(\"No email!\", \"Info\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("No email!"),BA.ObjectToCharSequence("Info"),mostCurrent.activityBA);
 };
 //BA.debugLineNum = 293;BA.debugLine="End Sub";
return "";
}
public static String  _imgemail_longclick() throws Exception{
 //BA.debugLineNum = 356;BA.debugLine="Sub imgEmail_LongClick";
 //BA.debugLineNum = 357;BA.debugLine="Msgbox(\"Send email to author\", \"Info\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Send email to author"),BA.ObjectToCharSequence("Info"),mostCurrent.activityBA);
 //BA.debugLineNum = 358;BA.debugLine="End Sub";
return "";
}
public static String  _imginfo_click() throws Exception{
int _index = 0;
String _s = "";
 //BA.debugLineNum = 343;BA.debugLine="Sub imgInfo_Click";
 //BA.debugLineNum = 344;BA.debugLine="Dim index As Int";
_index = 0;
 //BA.debugLineNum = 346;BA.debugLine="index = clvLevelsWithTitleLetter.GetItemFromView(";
_index = mostCurrent._clvlevelswithtitleletter._getitemfromview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA))));
 //BA.debugLineNum = 347;BA.debugLine="Dim s As String = Description.Get(index)";
_s = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Get(_index));
 //BA.debugLineNum = 348;BA.debugLine="s = s.Replace(CRLF, \" \")";
_s = _s.replace(anywheresoftware.b4a.keywords.Common.CRLF," ");
 //BA.debugLineNum = 349;BA.debugLine="Msgbox(s, \"Levels info\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence(_s),BA.ObjectToCharSequence("Levels info"),mostCurrent.activityBA);
 //BA.debugLineNum = 350;BA.debugLine="End Sub";
return "";
}
public static String  _imginfo_longclick() throws Exception{
 //BA.debugLineNum = 372;BA.debugLine="Sub imgInfo_LongClick";
 //BA.debugLineNum = 373;BA.debugLine="Msgbox(\"Shows more info about level pack\", \"Info\"";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Shows more info about level pack"),BA.ObjectToCharSequence("Info"),mostCurrent.activityBA);
 //BA.debugLineNum = 374;BA.debugLine="End Sub";
return "";
}
public static String  _imgplay_click() throws Exception{
int _index = 0;
anywheresoftware.b4a.sql.SQL.CursorWrapper _curs = null;
String _s = "";
String _q = "";
int _i = 0;
 //BA.debugLineNum = 314;BA.debugLine="Sub imgPlay_Click";
 //BA.debugLineNum = 315;BA.debugLine="Dim index As Int";
_index = 0;
 //BA.debugLineNum = 316;BA.debugLine="Dim curs As Cursor";
_curs = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 318;BA.debugLine="index = clvLevelsWithTitleLetter.GetItemFromView(";
_index = mostCurrent._clvlevelswithtitleletter._getitemfromview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA))));
 //BA.debugLineNum = 319;BA.debugLine="Dim s As String = Title.Get(index)";
_s = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Get(_index));
 //BA.debugLineNum = 320;BA.debugLine="If s.Contains(\"'\") Then s = s.Replace(\"'\", \"''\")";
if (_s.contains("'")) { 
_s = _s.replace("'","''");};
 //BA.debugLineNum = 321;BA.debugLine="Log(\"odabir -> imgPlay_Click -> Title -> \" & s &";
anywheresoftware.b4a.keywords.Common.LogImpl("636175879","odabir -> imgPlay_Click -> Title -> "+_s+" by "+BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Get(_index)),0);
 //BA.debugLineNum = 322;BA.debugLine="zaSolutionIme = s & \" by \" & Autor.Get(index)";
_vvv0 = _s+" by "+BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Get(_index));
 //BA.debugLineNum = 323;BA.debugLine="Dim q As String = \"SELECT imeDat, brojRazina, dat";
_q = "SELECT imeDat, brojRazina, datoteka FROM "+mostCurrent._vvvvvvv5._v5+" WHERE title = '"+_s+"'";
 //BA.debugLineNum = 324;BA.debugLine="curs = Starter.upit.ExecQuery(q)";
_curs.setObject((android.database.Cursor)(mostCurrent._vvvvvvv5._v6.ExecQuery(_q)));
 //BA.debugLineNum = 325;BA.debugLine="If curs.RowCount > 0 Then";
if (_curs.getRowCount()>0) { 
 //BA.debugLineNum = 326;BA.debugLine="For i = 0 To curs.RowCount-1";
{
final int step11 = 1;
final int limit11 = (int) (_curs.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit11 ;_i = _i + step11 ) {
 //BA.debugLineNum = 327;BA.debugLine="curs.Position = i";
_curs.setPosition(_i);
 //BA.debugLineNum = 329;BA.debugLine="brojLevela = curs.GetString(\"brojRazina\")";
_vvv6 = (int)(Double.parseDouble(_curs.GetString("brojRazina")));
 //BA.debugLineNum = 331;BA.debugLine="datZaParsanjeRazina = curs.GetString(\"datoteka\"";
_vvv5 = _curs.GetString("datoteka");
 //BA.debugLineNum = 332;BA.debugLine="ime_datoteke_za_info = curs.GetString(\"imeDat\")";
_ime_datoteke_za_info = _curs.GetString("imeDat");
 }
};
 }else {
 //BA.debugLineNum = 336;BA.debugLine="Msgbox(\"No levels for choosen letter!\", \"Info\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("No levels for choosen letter!"),BA.ObjectToCharSequence("Info"),mostCurrent.activityBA);
 //BA.debugLineNum = 337;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 340;BA.debugLine="StartActivity(play)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._vvvvvvv6.getObject()));
 //BA.debugLineNum = 341;BA.debugLine="End Sub";
return "";
}
public static String  _imgplay_longclick() throws Exception{
 //BA.debugLineNum = 360;BA.debugLine="Sub imgPlay_LongClick";
 //BA.debugLineNum = 361;BA.debugLine="Msgbox(\"Start playing levels\", \"Info\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Start playing levels"),BA.ObjectToCharSequence("Info"),mostCurrent.activityBA);
 //BA.debugLineNum = 362;BA.debugLine="End Sub";
return "";
}
public static String  _imgsolution_click() throws Exception{
int _index = 0;
String _s = "";
 //BA.debugLineNum = 247;BA.debugLine="Sub imgSolution_Click";
 //BA.debugLineNum = 248;BA.debugLine="Dim index As Int";
_index = 0;
 //BA.debugLineNum = 250;BA.debugLine="index = clvLevelsWithTitleLetter.GetItemFromView(";
_index = mostCurrent._clvlevelswithtitleletter._getitemfromview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA))));
 //BA.debugLineNum = 251;BA.debugLine="Dim s As String = Title.Get(index)";
_s = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Get(_index));
 //BA.debugLineNum = 252;BA.debugLine="If s.Contains(\"'\") Then s = s.Replace(\"'\", \"''\")";
if (_s.contains("'")) { 
_s = _s.replace("'","''");};
 //BA.debugLineNum = 253;BA.debugLine="Log(\"odabir -> imgSolution_Click -> Title -> \" &";
anywheresoftware.b4a.keywords.Common.LogImpl("635454982","odabir -> imgSolution_Click -> Title -> "+_s+" by "+BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Get(_index)),0);
 //BA.debugLineNum = 254;BA.debugLine="zaSolutionIme = s & \" by \" & Autor.Get(index)";
_vvv0 = _s+" by "+BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Get(_index));
 //BA.debugLineNum = 256;BA.debugLine="StartActivity(rijesenja)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._vvvvvvvv1.getObject()));
 //BA.debugLineNum = 257;BA.debugLine="End Sub";
return "";
}
public static String  _imgsolution_longclick() throws Exception{
 //BA.debugLineNum = 376;BA.debugLine="Sub imgSolution_LongClick";
 //BA.debugLineNum = 377;BA.debugLine="Msgbox(\"Check for solution online\", \"Info\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Check for solution online"),BA.ObjectToCharSequence("Info"),mostCurrent.activityBA);
 //BA.debugLineNum = 378;BA.debugLine="End Sub";
return "";
}
public static String  _imgvideo_click() throws Exception{
int _index = 0;
anywheresoftware.b4a.sql.SQL.CursorWrapper _curs = null;
String _s = "";
String _q = "";
int _i = 0;
 //BA.debugLineNum = 222;BA.debugLine="Sub imgVideo_Click";
 //BA.debugLineNum = 223;BA.debugLine="Dim index As Int";
_index = 0;
 //BA.debugLineNum = 224;BA.debugLine="Dim curs As Cursor";
_curs = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 226;BA.debugLine="index = clvLevelsWithTitleLetter.GetItemFromView(";
_index = mostCurrent._clvlevelswithtitleletter._getitemfromview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA))));
 //BA.debugLineNum = 227;BA.debugLine="Dim s As String = Title.Get(index)";
_s = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Get(_index));
 //BA.debugLineNum = 228;BA.debugLine="If s.Contains(\"'\") Then s = s.Replace(\"'\", \"''\")";
if (_s.contains("'")) { 
_s = _s.replace("'","''");};
 //BA.debugLineNum = 229;BA.debugLine="Dim q As String = \"SELECT imeDat FROM \" & Starter";
_q = "SELECT imeDat FROM "+mostCurrent._vvvvvvv5._v5+" WHERE title = '"+_s+"'";
 //BA.debugLineNum = 230;BA.debugLine="curs = Starter.upit.ExecQuery(q)";
_curs.setObject((android.database.Cursor)(mostCurrent._vvvvvvv5._v6.ExecQuery(_q)));
 //BA.debugLineNum = 231;BA.debugLine="If curs.RowCount > 0 Then";
if (_curs.getRowCount()>0) { 
 //BA.debugLineNum = 232;BA.debugLine="For i = 0 To curs.RowCount-1";
{
final int step9 = 1;
final int limit9 = (int) (_curs.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
 //BA.debugLineNum = 233;BA.debugLine="curs.Position = i";
_curs.setPosition(_i);
 //BA.debugLineNum = 234;BA.debugLine="ime_dat_za_video = curs.GetString(\"imeDat\")";
_ime_dat_za_video = _curs.GetString("imeDat");
 }
};
 //BA.debugLineNum = 236;BA.debugLine="ime_dat_za_video = ime_dat_za_video.SubString2(0";
_ime_dat_za_video = _ime_dat_za_video.substring((int) (0),_ime_dat_za_video.indexOf("."));
 };
 //BA.debugLineNum = 239;BA.debugLine="OtvoriVideoDat";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5();
 //BA.debugLineNum = 240;BA.debugLine="If listaDatZaVideo.Size > 0 Then";
if (_vvv7.getSize()>0) { 
 //BA.debugLineNum = 241;BA.debugLine="StartActivity(video)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._vvvvvvv0.getObject()));
 }else {
 //BA.debugLineNum = 243;BA.debugLine="Msgbox(\"No video files!\", \"Info\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("No video files!"),BA.ObjectToCharSequence("Info"),mostCurrent.activityBA);
 };
 //BA.debugLineNum = 245;BA.debugLine="End Sub";
return "";
}
public static String  _imgvideo_longclick() throws Exception{
 //BA.debugLineNum = 368;BA.debugLine="Sub imgVideo_LongClick";
 //BA.debugLineNum = 369;BA.debugLine="Msgbox(\"Watch saved video\", \"Info\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Watch saved video"),BA.ObjectToCharSequence("Info"),mostCurrent.activityBA);
 //BA.debugLineNum = 370;BA.debugLine="End Sub";
return "";
}
public static String  _imgwww_click() throws Exception{
int _index = 0;
anywheresoftware.b4a.phone.Phone.PhoneIntents _p = null;
String _s = "";
int _res = 0;
 //BA.debugLineNum = 295;BA.debugLine="Sub imgWWW_Click";
 //BA.debugLineNum = 296;BA.debugLine="Dim index As Int";
_index = 0;
 //BA.debugLineNum = 297;BA.debugLine="Dim p As PhoneIntents";
_p = new anywheresoftware.b4a.phone.Phone.PhoneIntents();
 //BA.debugLineNum = 299;BA.debugLine="index = clvLevelsWithTitleLetter.GetItemFromView(";
_index = mostCurrent._clvlevelswithtitleletter._getitemfromview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA))));
 //BA.debugLineNum = 301;BA.debugLine="Dim s As String = Url.Get(index)";
_s = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Get(_index));
 //BA.debugLineNum = 302;BA.debugLine="If s.Length > 0 Then";
if (_s.length()>0) { 
 //BA.debugLineNum = 303;BA.debugLine="Dim res As Int = Msgbox2(\"Open in browser?\", \"Qu";
_res = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Open in browser?"),BA.ObjectToCharSequence("Question"),"Yes","","No",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"upitnik.png",anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32))).getObject()),mostCurrent.activityBA);
 //BA.debugLineNum = 305;BA.debugLine="If res = DialogResponse.POSITIVE Then";
if (_res==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 306;BA.debugLine="Log(Url.Get(index))";
anywheresoftware.b4a.keywords.Common.LogImpl("636110347",BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Get(_index)),0);
 //BA.debugLineNum = 307;BA.debugLine="StartActivity(p.OpenBrowser(Url.Get(index)))";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_p.OpenBrowser(BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Get(_index)))));
 };
 }else {
 //BA.debugLineNum = 310;BA.debugLine="Msgbox(\"No URL!\", \"Info\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("No URL!"),BA.ObjectToCharSequence("Info"),mostCurrent.activityBA);
 };
 //BA.debugLineNum = 312;BA.debugLine="End Sub";
return "";
}
public static String  _imgwww_longclick() throws Exception{
 //BA.debugLineNum = 352;BA.debugLine="Sub imgWWW_LongClick";
 //BA.debugLineNum = 353;BA.debugLine="Msgbox(\"Author website\", \"Info\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Author website"),BA.ObjectToCharSequence("Info"),mostCurrent.activityBA);
 //BA.debugLineNum = 354;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0() throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _curs = null;
String _q = "";
int _i = 0;
 //BA.debugLineNum = 113;BA.debugLine="Sub OtvoriIzBaze";
 //BA.debugLineNum = 114;BA.debugLine="Dim curs As Cursor";
_curs = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 116;BA.debugLine="Title.Clear";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Clear();
 //BA.debugLineNum = 117;BA.debugLine="Description.Clear";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Clear();
 //BA.debugLineNum = 118;BA.debugLine="Email.Clear";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Clear();
 //BA.debugLineNum = 119;BA.debugLine="Url.Clear";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Clear();
 //BA.debugLineNum = 120;BA.debugLine="Autor.Clear";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Clear();
 //BA.debugLineNum = 121;BA.debugLine="brojRazina.Clear";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Clear();
 //BA.debugLineNum = 122;BA.debugLine="ime_dat.Clear";
mostCurrent._ime_dat.Clear();
 //BA.debugLineNum = 125;BA.debugLine="If slovoOdabira.StartsWith(\"#\") Then";
if (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7.startsWith("#")) { 
 //BA.debugLineNum = 126;BA.debugLine="Dim q As String = \"SELECT title, autor, desc, em";
_q = "SELECT title, autor, desc, email, url, brojRazina, imeDat FROM "+mostCurrent._vvvvvvv5._v5+" WHERE imeDat GLOB '[1-9]*'";
 }else {
 //BA.debugLineNum = 129;BA.debugLine="Dim q As String = \"SELECT title, autor, desc, em";
_q = "SELECT title, autor, desc, email, url, brojRazina, imeDat FROM "+mostCurrent._vvvvvvv5._v5+" WHERE imeDat LIKE '"+mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7+"%'";
 };
 //BA.debugLineNum = 131;BA.debugLine="curs = Starter.upit.ExecQuery(q)";
_curs.setObject((android.database.Cursor)(mostCurrent._vvvvvvv5._v6.ExecQuery(_q)));
 //BA.debugLineNum = 132;BA.debugLine="If curs.RowCount > 0 Then";
if (_curs.getRowCount()>0) { 
 //BA.debugLineNum = 133;BA.debugLine="For i = 0 To curs.RowCount-1";
{
final int step16 = 1;
final int limit16 = (int) (_curs.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit16 ;_i = _i + step16 ) {
 //BA.debugLineNum = 134;BA.debugLine="curs.Position = i";
_curs.setPosition(_i);
 //BA.debugLineNum = 135;BA.debugLine="Title.Add(curs.GetString(\"title\"))";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Add((Object)(_curs.GetString("title")));
 //BA.debugLineNum = 136;BA.debugLine="Autor.Add(curs.GetString(\"autor\"))";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Add((Object)(_curs.GetString("autor")));
 //BA.debugLineNum = 137;BA.debugLine="Description.Add(curs.GetString(\"desc\"))";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2.Add((Object)(_curs.GetString("desc")));
 //BA.debugLineNum = 138;BA.debugLine="Email.Add(curs.GetString(\"email\"))";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3.Add((Object)(_curs.GetString("email")));
 //BA.debugLineNum = 139;BA.debugLine="Url.Add(curs.GetString(\"url\"))";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Add((Object)(_curs.GetString("url")));
 //BA.debugLineNum = 140;BA.debugLine="brojRazina.Add(curs.GetString(\"brojRazina\"))";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Add((Object)(_curs.GetString("brojRazina")));
 //BA.debugLineNum = 141;BA.debugLine="ime_dat.Add(curs.GetString(\"imeDat\"))";
mostCurrent._ime_dat.Add((Object)(_curs.GetString("imeDat")));
 }
};
 }else {
 //BA.debugLineNum = 144;BA.debugLine="Msgbox(\"No level packs!\", \"Info\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("No level packs!"),BA.ObjectToCharSequence("Info"),mostCurrent.activityBA);
 //BA.debugLineNum = 145;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 };
 //BA.debugLineNum = 148;BA.debugLine="UbaciUListu";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6();
 //BA.debugLineNum = 149;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5() throws Exception{
anywheresoftware.b4a.objects.collections.List _tmplist = null;
int _i = 0;
String _s = "";
 //BA.debugLineNum = 259;BA.debugLine="Sub OtvoriVideoDat";
 //BA.debugLineNum = 260;BA.debugLine="Dim tmpList As List";
_tmplist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 262;BA.debugLine="listaDatZaVideo.Clear";
_vvv7.Clear();
 //BA.debugLineNum = 264;BA.debugLine="tmpList.Initialize";
_tmplist.Initialize();
 //BA.debugLineNum = 265;BA.debugLine="tmpList = File.ListFiles(Starter.SourceFolder)";
_tmplist = anywheresoftware.b4a.keywords.Common.File.ListFiles(mostCurrent._vvvvvvv5._vv1);
 //BA.debugLineNum = 266;BA.debugLine="For i = 0 To tmpList.Size - 1";
{
final int step5 = 1;
final int limit5 = (int) (_tmplist.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 267;BA.debugLine="Dim s As String = tmpList.Get(i)";
_s = BA.ObjectToString(_tmplist.Get(_i));
 //BA.debugLineNum = 268;BA.debugLine="If s.StartsWith(ime_dat_za_video) And s.EndsWith";
if (_s.startsWith(_ime_dat_za_video) && _s.endsWith(".mp4")) { 
 //BA.debugLineNum = 269;BA.debugLine="listaDatZaVideo.Add(s)";
_vvv7.Add((Object)(_s));
 };
 }
};
 //BA.debugLineNum = 273;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        b4a.example.dateutils._process_globals();
main._process_globals();
starter._process_globals();
play._process_globals();
odabir._process_globals();
video._process_globals();
rijesenja._process_globals();
opcije._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 21;BA.debugLine="Dim slc_parse As SaxParser";
_slc_parse = new anywheresoftware.b4a.objects.SaxParser();
 //BA.debugLineNum = 22;BA.debugLine="Dim listaDatZaVideo As List";
_vvv7 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 23;BA.debugLine="Dim imeLevela As Map";
_vvv4 = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 24;BA.debugLine="Dim zaSolutionIme As String";
_vvv0 = "";
 //BA.debugLineNum = 25;BA.debugLine="Dim ime_dat_za_video As String";
_ime_dat_za_video = "";
 //BA.debugLineNum = 26;BA.debugLine="Dim datZaParsanjeRazina As String";
_vvv5 = "";
 //BA.debugLineNum = 27;BA.debugLine="Dim brojLevela As Int = 0";
_vvv6 = (int) (0);
 //BA.debugLineNum = 28;BA.debugLine="Dim ime_datoteke_za_info As String";
_ime_datoteke_za_info = "";
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1() throws Exception{
 //BA.debugLineNum = 388;BA.debugLine="Sub RaspakirajSkinoveIzArhive";
 //BA.debugLineNum = 389;BA.debugLine="arch.UnZip(Starter.SourceFolder, \"skins.zip\", Sta";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.UnZip(processBA,mostCurrent._vvvvvvv5._vv1,"skins.zip",mostCurrent._vvvvvvv5._vv1,"anzip");
 //BA.debugLineNum = 390;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv3(anywheresoftware.b4a.objects.LabelWrapper _lbl,String _txt,float _maxfontsize,float _minfontsize) throws Exception{
float _fontsize = 0f;
int _height = 0;
anywheresoftware.b4a.objects.StringUtils _stu = null;
 //BA.debugLineNum = 440;BA.debugLine="Sub SetLabelTextSize(lbl As Label, txt As String,";
 //BA.debugLineNum = 441;BA.debugLine="Dim FontSize = MaxFontSize As Float";
_fontsize = _maxfontsize;
 //BA.debugLineNum = 442;BA.debugLine="Dim Height As Int";
_height = 0;
 //BA.debugLineNum = 443;BA.debugLine="Dim stu As StringUtils";
_stu = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 445;BA.debugLine="lbl.TextSize = FontSize";
_lbl.setTextSize(_fontsize);
 //BA.debugLineNum = 446;BA.debugLine="Height = stu.MeasureMultilineTextHeight(lbl, txt)";
_height = _stu.MeasureMultilineTextHeight((android.widget.TextView)(_lbl.getObject()),BA.ObjectToCharSequence(_txt));
 //BA.debugLineNum = 447;BA.debugLine="Do While Height > lbl.Height And FontSize > MinFo";
while (_height>_lbl.getHeight() && _fontsize>_minfontsize) {
 //BA.debugLineNum = 448;BA.debugLine="FontSize = FontSize - 1";
_fontsize = (float) (_fontsize-1);
 //BA.debugLineNum = 449;BA.debugLine="lbl.TextSize = FontSize";
_lbl.setTextSize(_fontsize);
 //BA.debugLineNum = 450;BA.debugLine="Height = stu.MeasureMultilineTextHeight(lbl, txt";
_height = _stu.MeasureMultilineTextHeight((android.widget.TextView)(_lbl.getObject()),BA.ObjectToCharSequence(_txt));
 }
;
 //BA.debugLineNum = 452;BA.debugLine="End Sub";
return "";
}
public static String  _spnlevelstitleletter_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 425;BA.debugLine="Sub spnLevelsTitleLetter_ItemClick (Position As In";
 //BA.debugLineNum = 426;BA.debugLine="clvLevelsWithTitleLetter.Clear";
mostCurrent._clvlevelswithtitleletter._clear();
 //BA.debugLineNum = 427;BA.debugLine="slovoOdabira = letters.Get(Position)'spnLevelsTit";
mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv7 = BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv1.Get(_position));
 //BA.debugLineNum = 428;BA.debugLine="OtvoriIzBaze";
_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv0();
 //BA.debugLineNum = 430;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6() throws Exception{
int _i = 0;
 //BA.debugLineNum = 151;BA.debugLine="Sub UbaciUListu";
 //BA.debugLineNum = 152;BA.debugLine="For i = 0 To Title.Size - 1";
{
final int step1 = 1;
final int limit1 = (int) (mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit1 ;_i = _i + step1 ) {
 //BA.debugLineNum = 153;BA.debugLine="clvLevelsWithTitleLetter.Add(CreateListItem(Titl";
mostCurrent._clvlevelswithtitleletter._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv2(BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv4.Get(_i))+" by "+BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv5.Get(_i)),BA.ObjectToString(mostCurrent._ime_dat.Get(_i)),BA.ObjectToString(mostCurrent._vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv6.Get(_i)),mostCurrent._clvlevelswithtitleletter._asview().getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (102))).getObject())),(Object)(""));
 }
};
 //BA.debugLineNum = 155;BA.debugLine="End Sub";
return "";
}
}
