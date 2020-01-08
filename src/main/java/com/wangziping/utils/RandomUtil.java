package com.wangziping.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomUtil {

	/**
	 * @Title: random
	 * @Description: 返回 min - max 之间的随机数(包含 min 和 max ).
	 * @param min
	 * @param max
	 * @return
	 * @return: int
	 */
	public static int random(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}

	/**
	 * @Title: subRandom
	 * @Description: 在 min - max 之间截取 len 个不重复的随机数.
	 * @param min
	 * @param max
	 * @param len
	 * @return
	 * @return: int[]
	 */
	public static int[] subRandom(int min, int max, int len) {
		int[] array = new int[len];
		Set<Integer> hashSet = new HashSet<Integer>();
		while (hashSet.size() != len) {
			hashSet.add(random(min, max));
		}
		int i = 0;
		for (Integer num : hashSet) {
			array[i] = num;
			i++;
		}
		return array;
	}

	/**
	 * @Title: randomCharacter
	 * @Description: 返回一个0-9, a-z, A-Z之间的随机字符.
	 * @return
	 * @return: char
	 */
	public static char randomCharacter() {
		String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return str.charAt(random(0, str.length() - 1));
	}

	/**
	 * @Title: randomString
	 * @Description: 返回 len 个字符串, 方法内部要调用randomCharacter()方法.
	 * @param length
	 * @return
	 * @return: String
	 */
	public static String randomString(int len) {
		String str = "";
		for (int i = 0; i < len; i++) {
			str += randomCharacter();
		}
		return str;
	}
}
