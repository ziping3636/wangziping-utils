package com.wangziping.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * @Title: getEarly
	 * @Description: TODO返回指定月份的月初
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static Date getEarly(Date date) {
		// 获取的当前系统的时间的日历类
		Calendar instance = Calendar.getInstance();
		// 用传入的日期初始化日历类
		instance.setTime(date);
		// 设置月份的天为 1
		instance.set(Calendar.DAY_OF_MONTH, 1);
		instance.set(Calendar.HOUR_OF_DAY, 0);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.SECOND, 0);
		return instance.getTime();
	}

	/**
	 * @Title: getMonthEnd
	 * @Description: TODO返回指定月份的月末
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static Date getMonthEnd(Date date) {
		Calendar instance = Calendar.getInstance();
		// 用传入的日期初始化日历类
		instance.setTime(date);
		// 当前月份 +1
		instance.add(Calendar.MONTH, 1);
		// 日期变为下个月月初
		Date early = getEarly(instance.getTime());
		// 用月初再次初始化日历类
		instance.setTime(early);
		// 日期的秒数 -1
		instance.add(Calendar.SECOND, -1);
		return instance.getTime();
	}

	/**
	 * @Title: random
	 * @Description: TODO返回某一个时间段的随机日期
	 * @param startDate
	 * @param endDate
	 * @return
	 * @return: Date
	 */
	public static Date random(Date startDate, Date endDate) {
		long endTime = endDate.getTime();
		long startTime = startDate.getTime();
		long ultimateTime = (long) (Math.random() * (endTime - startTime + 1) + startTime);

		return new Date(ultimateTime);
	}

	/**
	 * @Title: getAge
	 * @Description: TODO根据获得的生日精确计算年龄
	 * @param birthday
	 * @return
	 * @return: int
	 */
	public static int getAge(Date birthday) {
		Calendar instance = Calendar.getInstance();
		int yearNow = instance.get(Calendar.YEAR);
		int monthNow = instance.get(Calendar.MONTH);
		int dateOfMonthNow = instance.get(Calendar.DAY_OF_MONTH);
		instance.setTime(birthday);
		int yearBirth = instance.get(Calendar.YEAR);
		int monthBirth = instance.get(Calendar.MONTH);
		int dateOfMonthBirth = instance.get(Calendar.DAY_OF_MONTH);
		int age = yearNow - yearBirth;
		if (monthNow < monthBirth) {
			age--;
		}
		if (dateOfMonthNow < dateOfMonthBirth && monthNow == monthBirth) {
			age--;
		}
		return age;
	}
}
