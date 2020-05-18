package model;

public class Sankaku {

	private int teihen;
	private int takasa;


	public Sankaku(int teihen, int takasa) {
		super();
		this.teihen = teihen;
		this.takasa = takasa;
	}


	public int getTeihen() {
		return teihen;
	}
	public void setTeihen(int teihen) {
		this.teihen = teihen;
	}
	public int getTakasa() {
		return takasa;
	}
	public void setTakasa(int takasa) {
		this.takasa = takasa;
	}



	public int getMenseki() {
		return this.takasa*this.teihen/2;
	}
}
