package co.yedam.app.file;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {
		//파일생성
		File file = new File("d:/temp/diary.txt");
		boolean result = file.createNewFile();
		System.out.println(result);
	}

	public static void main(String[] args) throws IOException {
		// filecreate();
		 //makefolder();
		// fileInfo();
		folderlist();
	}

	private static void folderlist() {
		File file = new File("d:/temp");
		if (file.isDirectory()) {
			File[] list = file.listFiles();
			for (File a : list) {

				if (StringUtil.getExtention(a.getName()).equals("jpg")) {
					System.out.println(a.getName());
					FileUtil.copy(a.getAbsolutePath(), "d:/temp/images/" + a.getName());
				}

			}
		}
	}

	private static void fileInfo() {
		File file = new File("d:/temp/image.png");
		System.out.println(file.length());
		file.getName();

	}

	private static void makefolder() {
		File file = new File("d:/temp/images");
		file.mkdir();
	}

}

