package co.memo.access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import co.memo.model.Memo;

public class MemoList implements MemoAccess {
	ArrayList <Memo> memos;

	public MemoList() {
		memos = new ArrayList<Memo>();
		open();
	}

	//메모등록
	@Override
	public void insert(Memo memo) {
		memos.add(memo);
		save();

	}
	
	//메모수정
	@Override
	public void update(Memo memo) {
		for (Memo a : memos) {
			if (a.getDate().equals(memo.getDate())) {
				a.setContent(memo.getContent());
				save();
			}
		}
	}
	
	//메모삭제
	@Override
	public void delete(String content) {
		for (Memo a : memos) {
			if (a.getContent().equals(content)) {
				memos.remove(a);
				save();
				break;
			}
		}
	}
	
	//메모전체조회
	@Override
	public ArrayList<Memo> selectAll() {
		return memos;
	}
	
	//날짜검색
	@Override
	public Memo findDate(String date) {
		for(Memo a : memos) {
			if(a.getDate().contains(date)) {	//contains
				return a;
			}
		}
		return null;
	}
	
	//내용검색
	@Override
	public Memo findContent(String content) {
		for(Memo a : memos) {
			if(a.getContent().contains(content)) {	//contains
				return a;
			}
		}
		return null;
	}
	
	String path = "d:/temp/memo.txt";
	public void open() {
		try {
			Scanner scanner = new Scanner(new File(path));
			while(true) {
				if(! scanner.hasNext())break;
				String str = scanner.next();
				String[] arr = str.split(",");
				memos.add(new Memo(arr[0],arr[1]));
			}
			scanner.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void save() {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(path));
			for(Memo a : memos) {
				fw.write(String.format("%s,%s\n,", a.getDate(), a.getContent()));
			}
			fw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	


}

