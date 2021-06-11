package co.board.model;

public class Board {
	
	 protected int b_id;
	 protected String b_title;
	 protected String b_content;
	 protected String b_writer;
	 protected int b_parentid;
	 
	 protected String u_id;
	 protected String u_pass;

	public Board() {}

	public Board(String b_title, String b_content, String b_writer) {
		super();
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_writer = b_writer;
	}

	public Board( int b_parentid,String b_content) {
		super();
		this.b_content = b_content;
		this.b_parentid = b_parentid;
	}

	public Board(int b_id, String b_title, String b_content, String b_writer, int b_parentid) {
		super();
		this.b_id = b_id;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_writer = b_writer;
		this.b_parentid = b_parentid;
		}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int string) {
		this.b_id = string;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_writer() {
		return b_writer;
	}

	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pass() {
		return u_pass;
	}

	public void setU_pass(String u_pass) {
		this.u_pass = u_pass;
	}
	
	public int getB_parentid() {
		return b_parentid;
	}

	public void setB_parentid(int b_parentid) {
		this.b_parentid = b_parentid;
	}

	@Override
	public String toString() {
		return "Board [b_id=" + b_id + ", b_title=" + b_title + ", b_content=" + b_content + ", b_writer=" + b_writer
				+ ", u_id=" + u_id + ", u_pass=" + u_pass + "]";
		
	
	}
	
	
	
	
}
