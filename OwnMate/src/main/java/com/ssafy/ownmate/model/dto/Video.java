package com.ssafy.ownmate.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
	private String videoId;
	private String videoTitle;
	private String videoPart;
	private String videoChannel;
	private String videoUrl;
	private int videoViewCnt;	
}
