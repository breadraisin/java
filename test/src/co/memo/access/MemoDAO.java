package co.memo.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.memo.model.Memo;

// MemoAccess를 구현하는 클래스입니다.
// 기능을 작성하세요.
public class MemoDAO implements MemoAccess {

	PreparedStatement psmt;
	ResultSet rs;
	static Connection conn;

	// 메모 추가
	@Override
	public void insert(String date, String title, String content) {
		connect();
		try {
			psmt = conn.prepareStatement("insert into Memo(date,title,content) values (?,?,?)");
			psmt.setString(1, date);
			psmt.setString(2, title);
			psmt.setString(3, content);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 메모 수정
	@Override
	public void update(String content, String title) {
		connect();
		try {
			psmt = conn.prepareStatement("update Memo set content=? where title=?");
			psmt.setString(1, content);
			psmt.setString(2, title);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 메모 삭제
	@Override
	public void delete(String title) {
		connect();
		try {
			psmt = conn.prepareStatement("delete from Memo where title=?");
			psmt.setString(1, title);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 전체 조회
	@Override
	public ArrayList<Memo> FindAll() {
		connect();
		ArrayList<Memo> mList = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("select * from Memo");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Memo memo = new Memo();
				memo.setDate(rs.getString("date"));
				memo.setTitle(rs.getString("title"));
				memo.setContent(rs.getString("content"));
				mList.add(memo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mList;

	}

	// 날짜로 조회
	@Override
	public Memo FindByDate(String date) {
		connect();
		Memo m = null;
		try {
			psmt = conn.prepareStatement("select * from memo where date = ?");
			psmt.setString(1, date);
			rs = psmt.executeQuery();
			while (rs.next()) {
				m = new Memo();
				m.setDate(rs.getString("date"));
				m.setTitle(rs.getString("title"));
				m.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

	// 내용으로 조회
	@Override
	public Memo FindByContent(String content) {
		connect();
		Memo m = null;
		try {
			psmt = conn.prepareStatement("select * from memo where content = ?");
			psmt.setString(1, content);
			rs = psmt.executeQuery();
			while (rs.next()) {
				m = new Memo();
				m.setDate(rs.getString("date"));
				m.setTitle(rs.getString("title"));
				m.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

	// 커넥트 (sample파일이름 dd로 이름 저장함.)
	public static void connect() {
		String url = "jdbc:sqlite:C:/sqlite/db/dd.db";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("연결 성공!!!");
		} catch (SQLException e) {
			System.out.println("연결 실패");
		}
	}
}
