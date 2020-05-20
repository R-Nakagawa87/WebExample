package model;

public class Member {

	//Field
	private int mid;
	private String name;
	private String adr;


	//getter&setter
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAdr() {
		return adr;
	}
	public void setAdr(String adr) {
		this.adr = adr;
	}


	//Constructor
	public Member() {
		super();
	}

	public Member(int mid, String name, String adr) {
		super();
		this.mid = mid;
		this.name = name;
		this.adr = adr;
	}


}
