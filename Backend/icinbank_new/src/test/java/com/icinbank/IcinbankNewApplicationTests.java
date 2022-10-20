package com.icinbank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import com.icinbank.dao.AccountRepository;
import com.icinbank.dao.ChequeBookRepository;
import com.icinbank.dao.LoanRepository;
import com.icinbank.dao.SaccountRepository;
import com.icinbank.dao.TransferHistoryRepository;
import com.icinbank.dao.UserDisplayRepository;
import com.icinbank.dao.UserRepository;
import com.icinbank.model.ChequebookRequest;
import com.icinbank.model.Loan;
import com.icinbank.model.Transfer;
import com.icinbank.model.User;

@SpringBootTest
class IcinbankNewApplicationTests {

	@Autowired
	private AccountRepository accountrepo;
	@Autowired
	private ChequeBookRepository checkrepo;
	@Autowired
	private LoanRepository loanrepo;
	@Autowired
	private SaccountRepository saccountrepo;
	@Autowired
	private TransferHistoryRepository transferhistoryrepo;
	@Autowired
	private UserDisplayRepository userdisplayrepo;
	@Autowired
	private UserRepository userrepo;

	@Test
	public void createUser() {
		User user = new User();
		user.setFname("Nivetha");
		user.setLname("K");
		user.setUsername("Nivetha");
		user.setPhone(1234512345);
		user.setAddress("6,Lawerance street");
		
		user.setEmail("nivi@gmail.com");
		user.setIdentity("12345");
		user.setIdentityType("Aadhar");
		user.setAuthorizationStatus(false);
		user.setFeatureStatus(0);
		
		userrepo.save(user);
		assertNotNull(userrepo.findById(1).get());
	}

	@Test
	public void updateUser() {
		User user = userrepo.findById(1).get();
		user.setUsername("Nivi");
		user.setPhone(1231231230);
		user.setAddress("6,Orange Street");
		user.setEmail("Nivetha@gmail.com");
		userrepo.save(user);
		assertNotEquals("Nivetha",  userrepo.findById(1).get().getUsername());
		assertNotEquals(1234512345,  userrepo.findById(1).get().getPhone());
		assertNotEquals("6,Lawerance Street",  userrepo.findById(1).get().getAddress());
		assertNotEquals("nivi@gmail.com", userrepo.findById(1).get().getEmail());
	}
	@Test
	public void applyChequeBook() {
		ChequebookRequest req = new ChequebookRequest();
		req.setAccount(39149182);
		req.setAccType("Secondary");
		// req.setDate();
		req.setNo_of_pages(20);
		req.setRequestStatus(false);
		checkrepo.save(req);
		assertNotNull(checkrepo.findById(1).get());

	}

	@Test
	public void Moneytransfer() {
		Transfer transfer = new Transfer();
		transfer.setAmount(50000);
		transfer.setDate(null);
		transfer.setRaccount(39149182);;
		transfer.setSaccount(39149183);
		transferhistoryrepo.save(transfer);
		assertNotNull(transferhistoryrepo.findById(1).get());
	}
	@Test
	public void applyLoan()
	{
		Loan loan=new Loan();
	    loan.setLoanType("Home");
		loan.setLoanAmount("200000");
		loan.setStatus("false");
		loan.setAccountNumber("39149182012");
		loanrepo.save(loan);
		assertNotNull(loanrepo.findById(1).get());	
	}
	@Test
	public void users() {
		List<User> list = userrepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void showTransfer() {
		List<Transfer> list = transferhistoryrepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	public void showChequeBook() {
		List<ChequebookRequest> list = checkrepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	public void showLoan() {
		List<Loan> list = loanrepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	
	

}
