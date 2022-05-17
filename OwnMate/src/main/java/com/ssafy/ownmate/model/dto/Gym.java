package com.ssafy.ownmate.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gym {
	private int gymNo;
	private String gymName;
	private String gymLoc;
}
