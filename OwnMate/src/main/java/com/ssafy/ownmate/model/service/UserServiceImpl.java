package com.ssafy.ownmate.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ownmate.exception.IdAlreadyExistException;
import com.ssafy.ownmate.exception.PWIncorrectException;
import com.ssafy.ownmate.exception.UserNotFoundException;
import com.ssafy.ownmate.model.dao.userDao;
import com.ssafy.ownmate.model.dto.Review;
import com.ssafy.ownmate.model.dto.User;
import com.ssafy.ownmate.util.SHA256;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private userDao userDao;

	@Override
	public void join(User user) throws Exception {
		// id로 select해온다. 아이디가 존재하면 isExistUser==1
		int isExistUser = userDao.checkUserId(user.getUserId());
		// id중복이 없으면 가입 가능
		if (isExistUser == 0) {
			user.setUserPw(new SHA256().getHash(user.getUserPw()));
			userDao.insertUser(user);
		}
		// 중복되면 에러발생
		else {
			throw new IdAlreadyExistException();
		}
	}

	@Override
	public User login(String userId, String userPw) throws Exception {
		// id로 select해와서
		int isExistUser = userDao.checkUserId(userId);
		// id에 해당하는 user가 없으면 오류발생
		if (isExistUser == 0)
			throw new UserNotFoundException();
		// 유저가 있는데 pw가 다르면 오류 아니면 ㄱㄱ
		User user = userDao.selectUserById(userId);
		if (!user.getUserPw().equals(new SHA256().getHash(userPw)))
			throw new PWIncorrectException();
		else
			return user;
	}
	
	//user를 어디서 갖고다니지? 세션?
	@Override
	public boolean modifyUser(User user) {
		User originuser = userDao.selectUserById(user.getUserId());
		originuser.setUserAge(user.getUserAge());
		originuser.setUserExerciseCareer(user.getUserExerciseCareer());
		originuser.setUserGender(user.getUserGender());
		// 이거의 결과는 true false
		return userDao.updateUser(originuser) == 1;
	}

	@Override
	public boolean dropUser(String userId) {
		return userDao.deleteUser(userId) == 1;
	}
}
