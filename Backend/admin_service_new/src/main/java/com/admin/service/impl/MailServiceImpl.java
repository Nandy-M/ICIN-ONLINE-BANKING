package com.admin.service.impl;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dao.AccountRepository;
import com.admin.dao.UserRepository;
import com.admin.model.Account;
import com.admin.model.User;

@Service
public class MailServiceImpl {

	@Autowired
	UserRepository userDAO;

	@Autowired
	AccountRepository accountDAO;

	public void sendAuthorizedEmail(String username) throws EmailException {

		User user = userDAO.findByUsername(username);
		String receiver = user.getEmail();
		String fullName = user.getFname() + " " + user.getLname();
		Account account = accountDAO.findByUsername(username);
		long accountNo = account.getAccno();
		int balance = account.getBalance();

		
	}

	public void sendAuthorizeCancelEmail(String username) throws EmailException {

		User user = userDAO.findByUsername(username);
		String receiver = user.getEmail();
		String fullName = user.getFname() + " " + user.getLname();

		
	}

	public void sendChequebookConfirmedEmail(String username) throws EmailException {

		User user = userDAO.findByUsername(username);
		String receiver = user.getEmail();
		String fullName = user.getFname() + " " + user.getLname();

		
	}

//	public void sendLoanConfirmedEmail(String username) throws EmailException {
//
//		User user = userDAO.findByUsername(username);
//		String receiver = user.getEmail();
//		String fullName = user.getFname() + " " + user.getLname();
//
//
//	}

	public void sendLoanConfirmedEmail1(String username) throws EmailException {
		// TODO Auto-generated method stub
		User user = userDAO.findByUsername(username);
		String receiver = user.getEmail();
		String fullName = user.getFname() + " " + user.getLname();

	

		
	}

}
