package com.wangziping.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class StreamUtil {

	public static List<String> readFile(InputStream is) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
		List<String> arrayList = new ArrayList<String>();
		String readLine = "";
		while ((readLine = bufferedReader.readLine()) != null) {
			arrayList.add(readLine);
		}
		bufferedReader.close();
		return arrayList;
	}

	public static void writeFile(String pathname, String content, String charset) throws Exception {
		File file = new File(pathname);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdir();
		}
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
		bufferedWriter.write(content);
		bufferedWriter.flush();
		bufferedWriter.close();
	}
}
