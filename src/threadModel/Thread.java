package threadModel;

import java.sql.Timestamp;

public class Thread {
	private int tid;
	private String name;
	private String mainText;
	private Timestamp insertTime;


	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getMainText() {
		return mainText;
	}
	public void setMainText(String mainText) {
		this.mainText = mainText;
	}

	public Timestamp getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}


	public Thread(int tid, String name, String mainText, Timestamp insertTime) {
		super();
		this.tid = tid;
		this.name = name;
		this.mainText = mainText;
		this.insertTime = insertTime;
	}


}
