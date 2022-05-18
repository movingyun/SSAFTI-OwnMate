package com.ssafy.ownmate.exception;

public class IdAlreadyExistException extends Exception {
	public IdAlreadyExistException() {
		super("입력하신 ID가 이미 존재합니다.");
	}
}	
