package md5916833d76c57cf5d7fd00669dd2ad9a5;


public class TaskDetailsScreen
	extends android.app.Activity
	implements
		mono.android.IGCUserPeer
{
	static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\n" +
			"";
		mono.android.Runtime.register ("TaskyAndroid.Screens.TaskDetailsScreen, TaskyAndroid, Version=1.0.5902.30023, Culture=neutral, PublicKeyToken=null", TaskDetailsScreen.class, __md_methods);
	}


	public TaskDetailsScreen () throws java.lang.Throwable
	{
		super ();
		if (getClass () == TaskDetailsScreen.class)
			mono.android.TypeManager.Activate ("TaskyAndroid.Screens.TaskDetailsScreen, TaskyAndroid, Version=1.0.5902.30023, Culture=neutral, PublicKeyToken=null", "", this, new java.lang.Object[] {  });
	}


	public void onCreate (android.os.Bundle p0)
	{
		n_onCreate (p0);
	}

	private native void n_onCreate (android.os.Bundle p0);

	java.util.ArrayList refList;
	public void monodroidAddReference (java.lang.Object obj)
	{
		if (refList == null)
			refList = new java.util.ArrayList ();
		refList.add (obj);
	}

	public void monodroidClearReferences ()
	{
		if (refList != null)
			refList.clear ();
	}
}
