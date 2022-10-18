import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WithdrawService {
  readonly rootUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }
  
    insertEntry(saccount:string,amount:number) {
      var body = {
        account: saccount,
        amount:amount
      }
      console.log(body);
      return this.http.post(this.rootUrl + '/account/withdraw', body);
    }
  }
  
