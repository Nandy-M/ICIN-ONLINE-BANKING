import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoanRequest } from './model/loanRequest';
import {map} from 'rxjs/operators'


@Injectable({
    providedIn: 'root'
})
export class LoanService {

    
    constructor(private http: HttpClient) { }


    updateAdhar(data : any, id: number){
        return this.http.put<any>("http://localhost:8084/user/loan/approval/"+id, data)
        .pipe(map((res:any)=>{
          return res;
        }))
      }

      getLoanRequest(){
        return this.http.get<any>("http://localhost:8084/user/loanrequests")
        .pipe(map((res:any)=>{
          return res;
        }))
      }
}

