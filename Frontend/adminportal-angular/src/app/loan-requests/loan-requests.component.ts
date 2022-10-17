import { Component, OnInit } from '@angular/core';
import { LoanService } from '../loan.service'
import { LoanRequest } from '../model/loanRequest';
import { NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-loan-requests',
  templateUrl: './loan-requests.component.html',
  styleUrls: ['./loan-requests.component.css']
})
export class LoanRequestsComponent implements OnInit {

  loanrequests: LoanRequest[];
  term: string;


  constructor(public loanService: LoanService) {

  }

  ngOnInit() {
    this.loanService.getRequestsData().subscribe(res => {
      this.loanrequests = res
    });
  }

  getData() {

  }

  confirmRequest(account) {
    this.loanService.confirmLoanService(account).subscribe(res => this.ngOnInit());
  }

}
