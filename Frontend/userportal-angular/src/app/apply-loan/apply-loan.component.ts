import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, } from '@angular/forms';
import { Router } from '@angular/router';
import { TransferService } from '../transfer.service';
import Swal from 'sweetalert2';
import {LoanService } from '../loan.service';


@Component({
  selector: 'app-apply-loan',
  templateUrl: './apply-loan.component.html',
  styleUrls: ['./apply-loan.component.css']
})
export class ApplyLoanComponent implements OnInit {


  AppliedStatus = '';


  constructor( private formBuilder: FormBuilder,
    private router: Router,
    private transferService: LoanService) { }


  transferForm: FormGroup;
  loading = false;
  submitted = false;
  
  ngOnInit() {
  var status:string="pending";
   var username:String=localStorage.getItem("username");
   var accNo=+localStorage.getItem("savingAccNo");
   console.log(accNo)
   console.log(username)
   this.transferForm = this.formBuilder.group({
     
      saccountNo: accNo,
      loanType: ['', [Validators.required]],
      loanAmount: ['', [Validators.required]],
      date:['',[Validators.required]],
      status : status,
  
  });
  

}


onCreateServer() {
  this.AppliedStatus = 'Successfully Applied ';
}

get saccountno(): any {
  return localStorage.getItem('savingAccNo');
}
get fval() { return this.transferForm.controls; }

  transfer(){
    this.submitted = true;
    if (this.transferForm.invalid) {
      return;
    }
    this.loading = true;
    this.onCreateServer();
    const result:any = Object.assign({}, this.transferForm.value);
    this.transferForm.reset();

   
      this.transferService.insertEntry(result.saccountNo,result.loanType,result.loanAmount,result.status,result.date).subscribe(
        (data : any) =>{
          this.loading=false;
        
         {
          Swal.fire({
            icon: 'success',
            title: 'Applied successful',
            text: 'Application is waiting'
          })
         }
         
         }
       );
    }  

  }

