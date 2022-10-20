import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import {DepositService } from '../deposit.service';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {

  constructor( private formBuilder: FormBuilder,
    private router: Router,
    private depositeservice: DepositService) { }

    transferForm: FormGroup;
    loading = false;
    submitted = false;

  ngOnInit(): void {
 var username:String=localStorage.getItem("username");
   var accNo=+localStorage.getItem("savingAccNo");
   console.log(accNo)
   console.log(username)
   this.transferForm = this.formBuilder.group({
      saccountNo: accNo,
      amount:['',[Validators.required]]
  
  });

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
    console.log(this.transferForm.value.amount);
    console.log(this.transferForm.value.saccountno);
    if(this.transferForm.value.amount > 0){ 
    this.loading = true;
    const result:any = Object.assign({}, this.transferForm.value);
    
        
    
    // Do useful stuff with the gathered data
    try{
      this.depositeservice.insertEntry(result.saccountNo,result.amount).subscribe(
        (data : any) =>{
         this.loading=false;
         if(data.depositStatus==true){
          Swal.fire({
            icon: 'success',
            title: 'Transaction successful',
            text:data.responseMessage,
          })
         }
         else{
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: data.responseMessage,
          })
         }
         }
       );
    }catch{
      this.loading=false;
    }
  }Swal.fire({
    icon: 'error',
    title: 'Oops...',
    text: 'Enter positive digit',
  })

  }
}





  
  
  
  
