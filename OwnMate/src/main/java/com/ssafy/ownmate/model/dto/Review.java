package com.ssafy.ownmate.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	private String reviewVideoId;
	private int reviewNo;
	private String reviewTitle;
	private String reviewWriter;
	private String reviewContent;
	private int reviewViewCnt;
	private int reviewLikeCnt;
	private int reviewDislikeCnt;
	private int reviewPw;
}
