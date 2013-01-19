package com.flyingh.test;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.test.AndroidTestCase;
import android.util.Log;

public class PersonProviderTest extends AndroidTestCase {
	private static final String TAG = "PersonProviderTest";
	private String uri;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		uri = "content://com.flyingh.providers.PersonProvider/person";
	}

	public void testInsert() {
		Uri url = Uri.parse(uri);
		ContentValues values = new ContentValues();
		values.put("name", "xiix");
		values.put("age", 17);
		values.put("amount", 5000);
		getContext().getContentResolver().insert(url, values);
	}

	public void testDelete() {
		getContext().getContentResolver().delete(Uri.parse(uri), "id=?",
				new String[] { String.valueOf(3) });
	}

	public void testDeleteAll() {
		getContext().getContentResolver().delete(Uri.parse(uri), null, null);
	}

	public void testQueryAll() {
		Cursor cursor = getContext().getContentResolver().query(Uri.parse(uri),
				null, null, null, null);
		if (cursor == null) {
			Log.i(TAG, "cursor is null");
			return;
		}
		while (cursor.moveToNext()) {
			Log.i(TAG, cursor.getString(cursor.getColumnIndex("name")));
			Log.i(TAG, cursor.getInt(cursor.getColumnIndex("age")) + "");
		}
	}

	public void testQuery() {
		Cursor cursor = getContext().getContentResolver().query(Uri.parse(uri),
				null, "id=?", new String[] { String.valueOf(8) }, null);
		if (cursor == null) {
			Log.i(TAG, "cursor is null");
			return;
		}
		while (cursor.moveToNext()) {
			Log.i(TAG, cursor.getString(cursor.getColumnIndex("name")));
			Log.i(TAG, cursor.getInt(cursor.getColumnIndex("age")) + "");
		}

	}

	public void testUpdate() {
		ContentValues values = new ContentValues();
		values.put("name", "abc");
		values.put("age", 20);
		values.put("amount", 10000);
		getContext().getContentResolver().update(Uri.parse(uri), values,
				"id=?", new String[] { String.valueOf(5) });
	}

	public void testUpdateAll() {
		ContentValues values = new ContentValues();
		values.put("name", "www");
		int count = getContext().getContentResolver().update(Uri.parse(uri),
				values, null, null);
		Log.i(TAG, String.valueOf(count));
	}
}
