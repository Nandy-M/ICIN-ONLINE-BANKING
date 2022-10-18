import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserData } from './model/userData';
import { Observable } from 'rxjs';
import {map} from 'rxjs/operators'


@Injectable({
  providedIn: 'root'
})
export class UsersService {

  readonly url = 'http://localhost:8084/';

  constructor(private http:HttpClient) {
   }

   public getAllUsers(){
    return this.http.get<any[]>(this.url+"user/all");
  }


  getTranscationHistory(){
    return this.http.get<any>("http://localhost:8084/user/transcationdetails")
    .pipe(map((res:any)=>{
      return res;
    }))
  }


  getTransferDetails(){
    return this.http.get<any>("http://localhost:8084/user/transferdetails")
    .pipe(map((res:any)=>{
      return res;
    }))
  }

  getLoanDetails(){
    return this.http.get<any>("http://localhost:8084/user/loanrequests")
    .pipe(map((res:any)=>{
      return res;
    }))
  }


  updateLoan(data : any,id: number){
    return this.http.put<any>("http://localhost:8084/user/loan/approval/"+id, data)
    .pipe(map((res:any)=>{
      return res;
    }))
  }
}
