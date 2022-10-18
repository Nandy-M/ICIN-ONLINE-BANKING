package com.icinbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.icinbank.dao.LoanRepository;
import com.icinbank.model.Loan;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoanController {

	@Autowired
	LoanRepository loanRepo;
	
	
	@PostMapping("user/apply/loan")
	public Loan ApplyLoan(@RequestBody Loan loan) {
		return loanRepo.save(loan);
	}
}
