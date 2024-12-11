/*
 * Copyright (C) 2024 Kiseok Jang. All rights reserved.
 *
 * This software is licensed under the Personal and Limited Commercial Use License.
 * You may use this software for personal, educational, or non-commercial purposes.
 * For commercial use, ensure that your use does not infringe on the rights of others.
 *
 * For full license details, see the LICENSE file in the root directory of this project.
 *
 * Contact information: lecture4cs@gmail.com
 * 
 * 
 * 
 * 저작권 (C) 2024 장기. 모든 권리 보유.
 *
 * 이 소프트웨어는 개인 및 제한적인 상업적 사용 라이선스 하에 제공됩니다.
 * 이 소프트웨어는 개인적, 교육적 또는 비상업적 목적으로 자유롭게 사용할 수 있습니다.
 * 상업적 사용을 위해서는 타인의 권리를 침해하지 않도록 주의해야 합니다.
 *
 * 전체 라이선스 내용은 이 프로젝트의 루트 디렉토리에 있는 LICENSE 파일을 참조하십시오.
 *
 * 연락처: lecture4cs@gmail.com
 * 
 */
package kr.ac.kku.cs.wp.wsd.user.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kr.ac.kku.cs.wp.wsd.tools.message.MessageException;
import kr.ac.kku.cs.wp.wsd.user.dao.UserDAO;
import kr.ac.kku.cs.wp.wsd.user.entity.User;

/**
 * UserServiceImple
 * 
 * @author kiseokjang
 * @since 2024. 10. 6.
 * @version 1.0
 */
//@Service
public class UserServiceHImpl implements UserService {
	
	private static final Logger logger = LogManager.getLogger(UserServiceHImpl.class);
	
	@Autowired
	private UserDAO dao;
	

	@Override
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		User user= dao.getUserById(userId);
		
		if (user == null) {
			throw new MessageException("Not Found User : " + userId);
		}
		
		return user;
	}

	@Override
	public User getUser(User user) {
		User foundUser = dao.getUser(user);
	    if (foundUser == null) {
	        logger.warn("User not found for criteria: " + user);
	        throw new MessageException("User not found with provided details.");
	    }
	    return foundUser;
	}

	@Override
	public User updateUser(User user) {
		User existingUser = dao.getUserById(user.getId());
	    if (existingUser == null) {
	        logger.warn("Attempt to update non-existent user: " + user.getId());
	        throw new MessageException("User not found: " + user.getId());
	    }
	    User updatedUser = dao.updateUser(user);
	    logger.info("User updated successfully: " + updatedUser);
	    return updatedUser;
	}

	@Override
	public void deleteUser(User user) {
		User existingUser = dao.getUserById(user.getId());
	    if (existingUser == null) {
	        logger.warn("Attempt to delete non-existent user: " + user.getId());
	        throw new MessageException("User not found: " + user.getId());
	    }
	    dao.deleteUser(user);
	    logger.info("User deleted successfully: " + user.getId());
		
	}

	@Override
	public User createUser(User user) {
		 if (user == null || user.getId() == null || user.getName() == null) {
		     logger.error("Invalid user data: " + user);
		     throw new MessageException("Invalid user data. User ID and Name are required.");
		 }

		 // Check if the user already exists to avoid duplicates.
		    User existingUser = dao.getUserById(user.getId());
		 if (existingUser != null) {
		     logger.warn("User already exists with ID: " + user.getId());
		     throw new MessageException("User already exists with ID: " + user.getId());
		 }

		 // Create the new user and log the success.
		User createdUser = dao.createUser(user);
		logger.info("User created successfully: " + createdUser);
		return dao.createUser(user);
		
	}

	@Override
	public List<User> getUsers(User user) {
		if (user == null) {
	        logger.info("Fetching all users without filters.");
	        return dao.getUsers(null); // Assuming null retrieves all users.
	    }

	    // Fetch users matching the provided criteria.
	    List<User> users = dao.getUsers(user);
	    if (users.isEmpty()) {
	        logger.warn("No users found matching criteria: " + user);
	        throw new MessageException("No users found for the given criteria.");
	    }

	    logger.info(users.size() + " users found matching criteria: " + user);
		return dao.getUsers(user);
	}
	
	@Override
	@Transactional
	public List<User> getUsersByQueryString(String queryString) {
		List<User> users = dao.getUsersByQuery(queryString);
	    if (users.isEmpty()) {
	        logger.warn("No users found for query: " + queryString);
	        throw new MessageException("No users match the given query.");
	    }
	    logger.info("Users retrieved successfully for query: " + queryString);
	    return users;
	}
	
	
}

