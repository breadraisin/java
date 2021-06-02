package pkg.collect;

public class StringUtil {
	//파일명 추출
	public static String getFilenames(String path) {
		String s = null;
		if(path == null) return null;
		s = path.substring(path.lastIndexOf("/")+1);
		return s;
	}
	
	//확장자 jpg
	public static String getExtention(String path) {
		String s = null;
		if(path == null) return null;
		s = path.substring(path.lastIndexOf(".")+1);
		return s;
	}
	
	public static String getPath(String path) {
		String s = null;
		if(path == null) return null;
		s = path.substring(0,path.lastIndexOf("/")-1);
		return s;
	}
	
}
