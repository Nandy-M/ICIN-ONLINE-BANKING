package com.admin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.admin.dao.LoanRepository;
import com.admin.dao.TransferRepository;
import com.admin.dao.UserHistoryRepository;
import com.admin.model.Loan;
import com.admin.model.Transfer;
import com.admin.model.UserHistory;

@RestController
@CrossOrigin
public class TranscationController {

	@Autowired
	UserHistoryRepository userhistoryRepo;
	
	@Autowired
	LoanRepository loanRepo;
	
	@Autowired
	TransferRepository transferRepo;
	
	//to view transcation details
	@GetMapping("user/transcationdetails")
	public List<UserHistory> TranscationDetails(){
		return userhistoryRepo.findAll();
	}
	
	
	@GetMapping("user/transferdetails")
	public Iterable<Transfer> TransferDetails(){
		return transferRepo.findAll();
	}
	
	//loan approval
	@PutMapping("user/loan/approval/{id}")
	public ResponseEntity<Loan> ApproveLoan(@PathVariable(value = "id") int id,
			@RequestBody Loan loan) {
		Optional<Loan> op = loanRepo.findById(loan.getId());
		if (op.isPresent()) {
			Loan l = op.get();
			l.setAccountNumber(loan.getAccountNumber());
			l.setDate(loan.getDate());
			l.setLoanAmount(loan.getLoanAmount());
			l.setLoanType(loan.getLoanType());
			l.setStatus(loan.getStatus());			

			final Loan updatedprofile = loanRepo.save(loan);
			return ResponseEntity.ok(updatedprofile);
		}
		return null;
	}
	
	@GetMapping("user/loanrequests")
	public Iterable<Loan> LoanRequest(){
		return loanRepo.findAll();
	}
}
