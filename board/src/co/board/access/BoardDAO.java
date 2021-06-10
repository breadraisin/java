package co.board.access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.board.model.Board;
import co.board.util.DAO;

public class BoardDAO extends DAO implements BoardAccess{

	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	@Override
	public ArrayList<Board> selectAll() {
		
		ArrayList<Board> bList = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("select * from board");
			rs = psmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setB_id(rs.getString("b_id"));
				board.setB_title(rs.getString("b_title"));
				board.setB_content(rs.getString("b_content"));
				board.setB_writer(rs.getString("b_writer"));
				bList.add(board);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bList;
	}

	@Override
	public void insert(Board board) {
		try {
			psmt = conn.prepareStatement("insert into board(b_title,b_content,b_writer) values(?,?,?)");
			psmt.setString(1, board.getB_title());
			psmt.setString(2, board.getB_content());
			psmt.setString(3, board.getB_writer());
			int r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Board board) {
		try {
			psmt = conn.prepareStatement("update board set b_content=? where b_id=? ");
			psmt.setString(1, board.getB_content());
			psmt.setString(2, board.getB_id());
			int r = psmt.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(String b_id) {
		try {
			psmt = conn.prepareStatement("delete from board where b_id=?");
			psmt.setString(1, b_id);
			int r = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Board selectOne(String b_id) {
		Board b = null;
		try {
			psmt = conn.prepareStatement("select * from board where b_id = ?");
			psmt.setString(1, b_id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				b = new Board();
				b.setB_id(rs.getString("b_id"));
				b.setB_title(rs.getString("b_title"));
				b.setB_writer(rs.getString("b_writer"));
				b.setB_content(rs.getString("b_content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
}
