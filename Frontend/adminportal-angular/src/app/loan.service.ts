import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoanRequest } from './model/loanRequest';


@Injectable({
    providedIn: 'root'
})
export class LoanService {

    //readonly rootUrl = 'localhost:<port>/user/{username}/loanbook/request/confirm';
    readonly rootUrl = 'http://localhost:8084/user/';
    //readonly dataUrl= 'localhost:<port>/loan/request/all';
    readonly dataUrl = 'http://localhost:8084/loan/request/all';
    private data: any = []
    constructor(private http: HttpClient) { }




    confirmLoanService(account) {
        return this.http.get(this.rootUrl + account + '/loan/request/confirm');
    }


    getRequestsData(): Observable<LoanRequest[]> {
        return this.http.get<LoanRequest[]>(this.dataUrl);
    }

}

