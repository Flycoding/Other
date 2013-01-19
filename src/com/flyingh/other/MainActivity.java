package com.flyingh.other;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String TAG = "com.flyingh.other.MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setText(getContent());
		setContentView(textView);
		writeContent();
	}

	private void writeContent() {
		try {
			FileOutputStream os = new FileOutputStream(new File(
					"/data/data/com.flyingh.file/files/haha"));
			os.write("hello world,app!!!".getBytes());
			os.close();
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());
		}
	}

	private CharSequence getContent() {
		try {
			FileInputStream is = new FileInputStream(new File(
					"/data/data/com.flyingh.file/files/haha"));
			int len = -1;
			byte[] buf = new byte[1024];
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			while ((len = is.read(buf)) != -1) {
				os.write(buf, 0, len);
			}
			is.close();
			return new String(os.toByteArray());
		} catch (FileNotFoundException e) {
			Toast.makeText(this, "the file may not exists!", Toast.LENGTH_SHORT)
					.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
