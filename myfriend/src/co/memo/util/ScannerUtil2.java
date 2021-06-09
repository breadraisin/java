package co.memo.util;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import co.memo.model.Memo;

public class ScannerUtil2 {
	static Scanner scanner = new Scanner(System.in);

	public static int readInt(String prompt) {
		System.out.println(prompt + ">");
		return readInt();
	}

	// 숫자입력
	public static int readInt() {
		int result = 0;
		while (true) {
			try {
				String temp = scanner.next();
				result = Integer.parseInt(temp);
				break;
			} catch (Exception e) {
				System.out.println("숫자형식이 아닙니다.");
			}
		}
		return result;
	}

	public static String readStr(String prompt) {
		System.out.println(prompt + ">");
		return readStr();
	}

	// 한줄입력
	public static String readStr() {
		String result = "";
		try {
			result = scanner.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 날짜입력
	public static String readDate() {
		String result = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		do {
			try {
				result = scanner.next();
				df.parse(result.trim()); // trim공백제거
				break;
			} catch (Exception e) {
				System.out.println("(yyyyMMdd)날짜 형식이 아닙니다.");
			}
		} while (true);
		return result;
	}
	
	//Memo 입력
	public static Memo readMemo() {
		System.out.println("날짜,내용>");
		String result = scanner.next();
		String[] arr = result.split(",");
		Memo memo = new Memo(arr[0],arr[1]);
//		friend.setGubun(arr[0]);
//		friend.setName(arr[1]);
//		friend.setTel(arr[2]);
		return memo;
	}
}
