package com.ameen.crashhandler;

import android.content.Context;
import android.widget.Toast;

public class CrashHunt {
	
	private static CrashHunt crashHunt;
	private Context context;
	private CrashException exception;
	private CrashListener listener;
	
	private CrashHunt(){}
		
	public static CrashHunt getInstance(){
		if(crashHunt == null){
			crashHunt = new CrashHunt();
			return crashHunt;
		}
		return crashHunt;
	}
	
	public void initialize(Context context){
		exception = new CrashException(context);
		exception.setListener((message)->{
			listener.onAppCrash(message);
		});
		Thread.setDefaultUncaughtExceptionHandler(exception);
	}
	
	public void setListener(CrashListener listener){
		this.listener = listener;
	}
	
	public interface CrashListener{
		public void onAppCrash(String errorMessage);
	}
	
	public static class ErrorToast{
		private ErrorToast(){}
		
		public static void makeText(String string, Context context){
			
		}	
	}
}