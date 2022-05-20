package com.ssafy.ownmate.model.service;

import java.util.List;

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
		user.setUserPw(new SHA256().getHash(user.getUserPw()));
		userDao.insertUser(user);
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

	// user를 어디서 갖고다니지? 세션?
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

	@Override
	public List<User> getUserList(String keyword) {
		return userDao.selectUserList(keyword);
	}

	@Override
	public int chekId(String userId) {
		return userDao.checkUserId(userId);
	}

	@Override
	public User getUserById(String userId) {
		return userDao.selectUserById(userId);
	}
}
