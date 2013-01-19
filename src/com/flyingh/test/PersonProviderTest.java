package com.flyingh.test;

import android.content.ContentValues;
import android.net.Uri;
import android.test.AndroidTestCase;

public class PersonProviderTest extends AndroidTestCase {
	public void testInsert() {
		Uri url = Uri
				.parse("content://com.flyingh.providers.PersonProvider/person");
		ContentValues values = new ContentValues();
		values.put("name", "xiix");
		values.put("age", 17);
		values.put("amount", 5000);
		getContext().getContentResolver().insert(url, values);
	}
}
