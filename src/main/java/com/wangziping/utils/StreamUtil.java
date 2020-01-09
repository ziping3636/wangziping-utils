package com.wangziping.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class StreamUtil {

	/**
	 * @Title: readFile
	 * @Description: TODO读取文件
	 * @param is
	 * @return
	 * @throws IOException
	 * @return: List<String>
	 */
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

	/**
	 * @Title: readFile 
	 * @Description: TODO读取文件
	 * @param file
	 * @param charset
	 * @return
	 * @throws IOException
	 * @return: String
	 */
	public static String readFile(File file, String charset) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf8"));
		StringBuffer stringBuffer = new StringBuffer();
		String content = null;
		while((content = bufferedReader.readLine()) != null) {
			stringBuffer.append(content);
		}
		bufferedReader.close();
		return stringBuffer.toString();
	}

	/**
	 * @Title: writeFile
	 * @Description: TODO将文件写入磁盘
	 * @param pathname
	 * @param content
	 * @param charset
	 * @throws Exception
	 * @return: void
	 */
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
