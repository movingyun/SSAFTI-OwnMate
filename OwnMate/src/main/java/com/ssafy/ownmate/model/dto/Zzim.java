package com.ssafy.ownmate.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Zzim {
	private int zzimNo;
	private String zzimUserId;
	private String zzimVideoId;
	public int getZzimNo() {
		return zzimNo;
	}
	public void setZzimNo(int zzimNo) {
		this.zzimNo = zzimNo;
	}
	public String getZzimUserId() {
		return zzimUserId;
	}
	public void setZzimUserId(String zzimUserId) {
		this.zzimUserId = zzimUserId;
	}
	public String getZzimVideoId() {
		return zzimVideoId;
	}
	public void setZzimVideoId(String zzimVideoId) {
		this.zzimVideoId = zzimVideoId;
	}
	
	
}