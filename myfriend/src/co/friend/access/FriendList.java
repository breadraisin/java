package co.friend.access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.friend.model.Friend;

public class FriendList implements FriendAccess {
	ArrayList<Friend> friends;

	public FriendList() {
		friends = new ArrayList<Friend>();
		open();
	}

	@Override
	public void insert(Friend friend) {
		friends.add(friend);
		save();

	}

	@Override
	public void update(Friend friend) {
		for (Friend f : friends) {
			if (f.getName().equals(friend.getName())) {
				f.setTel(friend.getTel());
				save();
			}
		}
	}

	@Override
	public void delete(String name) {
		for (Friend f : friends) {
			if (f.getName().equals(name)) {
				friends.remove(f);
				save();
				break;
			}
		}
	}

	@Override
	public ArrayList<Friend> selectAll() {
		return friends;
	}

	@Override
	public Friend selectOne(String name) {
		for(Friend f : friends) {
			if(f.getName().equals(name)) {	//contains
				return f;
			}
		}
		return null;
	}
	
	
	String path = "d:/temp/friend.txt";
	public void open() {
		try {
			Scanner scanner = new Scanner(new File(path));
			while(true) {
				if(! scanner.hasNext())break;
				String str = scanner.next();
				String[] arr = str.split(",");
				friends.add(new Friend(arr[0],arr[1],arr[2]));
			}
			scanner.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void save() {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(path));
			for(Friend f : friends) {
				fw.write(String.format("%s,%s,%s\n,", f.getGubun(),f.getName(),f.getTel()));
			}
			fw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//전화번호 입력
	public Friend findTel(String tel){
		for(Friend f : friends) {
			if(f.getTel().contains(tel)) {	//contains
				return f;
			}
		}
		return null;
	}
}
