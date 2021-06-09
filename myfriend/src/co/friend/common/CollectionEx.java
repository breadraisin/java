package co.friend.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//568~570p 논리적으로 동일한 
//객체정의: hashCode, equals 메소드 정의
public class CollectionEx {
	public static void main(String[] args) {
	List<String> list = null;
	list = new ArrayList<String>();
	list.add("Hong");
	list.add("Hong");
	list.add("Park");
	list.add("Choi");
	
	list.remove(0);
	
	for(int i = 0; i<list.size(); i++) {
		System.out.println(list.get(i));
	}
	
	Set <String> set = new HashSet<>();
	set.add("Hong");
	set.add("Hong");
	set.add("Park");
	set.add("Choi");
	
	System.out.println("<set>");
	Iterator<String> iter = set.iterator();
	while(iter.hasNext()) {
		String value = iter.next();
		System.out.println(value);
	}
	
}
}
