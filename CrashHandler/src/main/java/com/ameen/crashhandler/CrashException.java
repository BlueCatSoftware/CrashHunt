package com.ameen.crashhandler;

import android.widget.Toast;
import android.content.Context;
import android.widget.Toast;
import com.ameen.crashhandler.listener.CrashListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread;

public class CrashException implements Thread.UncaughtExceptionHandler {

	Context context;
	int toast_length = Toast.LENGTH_LONG;
	String stacktrace = "NO ERROR";
	CrashListener listener;

	public CrashException(Context context) {
		this.context = context;
	}

	private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

	@Override
	public void uncaughtException(Thread thread, Throwable throwable) {
		final Writer writer = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(writer);
		throwable.printStackTrace(printWriter);
		stacktrace = writer.toString();
		listener.onCrash(stacktrace);
		uncaughtExceptionHandler.uncaughtException(thread, throwable);
	}

	public String getStackTrace() {
		return stacktrace;
	}

	public void setListener(CrashListener listener) {
		this.listener = listener;
	}

	public interface CrashListener {
		public void onCrash(String errorMessage);
	}
}