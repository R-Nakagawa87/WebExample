package model;

public class Shouhin {

	//Field
	private int sid;
	private String sname;
	private int tanka;


	//Constructor
	public Shouhin() {
		super();
	}

	public Shouhin(int sid, String sname, int tanka) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.tanka = tanka;
	}


	//getter&setter
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getTanka() {
		return tanka;
	}
	public void setTanka(int tanka) {
		this.tanka = tanka;
	}


}
