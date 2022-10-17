package com.admin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.admin.model.LoanRequest;

@Repository
public interface LoanRequestsRepository extends CrudRepository<LoanRequest, Integer>{
	
	@Modifying
	@Transactional
	@Query("update LoanRequest c set c.requestStatus=1 where c.account = ?1")
	void setLoanInfoByAccount(long accNo);
	
	@Query("FROM LoanRequest c where c.requestStatus=FALSE")
	public List<LoanRequest> findAllLoanRequests();

}
