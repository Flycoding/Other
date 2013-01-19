package com.flyingh.test;

import android.content.ContentValues;
import android.net.Uri;
import android.test.AndroidTestCase;

public class PersonProviderTest extends AndroidTestCase {
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
}
