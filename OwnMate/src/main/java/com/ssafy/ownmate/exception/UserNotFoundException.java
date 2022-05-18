package com.ssafy.ownmate.exception;

public class UserNotFoundException extends Exception {
	public UserNotFoundException() {
		super("ID가 틀렸습니다.");
	}
}	
