package com.admin.dao;

import org.springframework.data.repository.CrudRepository;

import com.admin.model.Loan;

public interface LoanRepository extends CrudRepository<Loan, Integer> {

}
