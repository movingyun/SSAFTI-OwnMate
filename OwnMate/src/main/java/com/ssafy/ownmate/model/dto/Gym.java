package com.ssafy.ownmate.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Gym {
	private int gymNo;
	private String gymName;
	private String gymLoc;
	public int getGymNo() {
		return gymNo;
	}
	public void setGymNo(int gymNo) {
		this.gymNo = gymNo;
	}
	public String getGymName() {
		return gymName;
	}
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}
	public String getGymLoc() {
		return gymLoc;
	}
	public void setGymLoc(String gymLoc) {
		this.gymLoc = gymLoc;
	}
	
	
}
