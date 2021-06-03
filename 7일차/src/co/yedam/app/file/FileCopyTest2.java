package co.yedam.app.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileCopyTest2 {
	public static void main(String[] args) {
		//파일복사
		try {
			FileInputStream fis = new FileInputStream("d:/temp/img.jpg");
			FileOutputStream fos = new FileOutputStream("d:/temp/img2.jpg");
			
			byte[] b = new byte[100];
			while(true){  
				int cnt = fis.read(b);
				if(cnt == -1) break;
				fos.write(b);
		} 
			fis.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
