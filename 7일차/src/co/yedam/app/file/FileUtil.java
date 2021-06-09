package co.yedam.app.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileUtil {
	public static void copy(String src, String des) {
		//파일복사
		try {
			FileInputStream fis = new FileInputStream(src);
			FileOutputStream fos = new FileOutputStream(des);
			
			int b;
			while(true){  //while 안에 (b = fis.read()) != -1 
				b=fis.read();
				if(b == -1) break;
				fos.write(b);
		} 
			fis.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
