import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoanService {

  readonly rootUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  insertEntry(accountNumber:string, loanType:string,loanAmount:string,status:string,date:number) {
    var body = {
      accountNumber:accountNumber,
      loanType: loanType,
      loanAmount: loanAmount, 
      status:status,
      date:date
    }
    console.log(body);
    return this.http.post(this.rootUrl + '/user/apply/loan', body);

}
}
