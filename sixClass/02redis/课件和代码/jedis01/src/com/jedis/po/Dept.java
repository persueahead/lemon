package com.jedis.po;

public class Dept {

	private int deId;
	
	private String deName;

	public int getDeId() {
		return deId;
	}

	public void setDeId(int deId) {
		this.deId = deId;
	}

	public String getDeName() {
		return deName;
	}

	public void setDeName(String deName) {
		this.deName = deName;
	}

	@Override
	public String toString() {
		return "Dept [deId=" + deId + ", deName=" + deName + "]";
	}
	
	
}
