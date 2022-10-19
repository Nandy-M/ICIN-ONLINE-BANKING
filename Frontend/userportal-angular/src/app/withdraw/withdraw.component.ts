import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { WithdrawService } from '../withdraw.service';
@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})
export class WithdrawComponent implements OnInit {

  constructor( private formBuilder: FormBuilder,
    private router: Router,
    private withdrawservice: WithdrawService) { }

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
    if(this.transferForm.value.amount > 0){
    this.loading = true;
    const result:any = Object.assign({}, this.transferForm.value);
        
    
    // Do useful stuff with the gathered data
    try{
      this.withdrawservice.insertEntry(result.saccountNo,result.amount).subscribe(
        (data : any) =>{
         this.loading=false;
         if(data.withdrawStatus==true){
          Swal.fire({
            icon: 'success',
            title: 'Transaction successful',
            text:data.responseMessage
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
  }else{
    Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: 'enter positive digit',
    })
  }

  }
}

