package com.wangziping.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StreamUtil {

	public static List<String> read(InputStream is) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		List<String> arrayList = new ArrayList<String>();
		String readLine = "";
		while ((readLine = br.readLine()) != null) {
			arrayList.add(readLine);

		}
		return arrayList;
	}
}
