package pkg.friend.util;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		System.out.println(DateUtil.dateToStr(new Date()));
		System.out.println(DateUtil.dateToStr(new Date(),"yyyy"));
		System.out.println(DateUtil.durationDay(new Date(2021,5,20), new Date()));
		System.out.println(DateUtil.durationDay("2021-07-01", "2021-06-03"));
		System.out.println(DateUtil.lastDay(2021,6));

		System.out.println();
	}

}
