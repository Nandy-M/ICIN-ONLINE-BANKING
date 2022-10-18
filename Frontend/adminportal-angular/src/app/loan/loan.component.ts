import { Component, OnInit } from '@angular/core';
import { UsersService } from '../users.service';
import { LoanRequest } from '../model/loanRequest';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup} from '@angular/forms'

@Component({
  selector: 'app-loan',
  templateUrl: './loan.component.html',
  styleUrls: ['./loan.component.css']
})
export class LoanComponent implements OnInit {


  formValue !: FormGroup;
  LooanModelobj : LoanRequest = new LoanRequest();
  LoanData !: any;
  showAdd !: boolean;
  showUpdate !: boolean;


  constructor(private formbuilber: FormBuilder,private router: Router, private api : UsersService) {

  }

  ngOnInit(): void {
    this.formValue = this.formbuilber.group({
      accountNumber :[''],
      loanType :[''],
      loanAmount :[''],
      status :[''],
      date :['']  
    })
    this.getLoanRequest();
  }


  getLoanRequest(){
    this.api.getLoanDetails()
    .subscribe(res=>{
      console.log(res);
      this.LoanData = res;
      
    })
   
  }

  onEdit(row : any){
    this.LooanModelobj.id = row.id;
    this.formValue.controls['accountNumber'].setValue(row.accountNumber);
    this.formValue.controls['loanType'].setValue(row.loanType);
    this.formValue.controls['loanAmount'].setValue(row.loanAmount);
    this.formValue.controls['status'].setValue(row.status);
    this.formValue.controls['date'].setValue(row.date);
  }


  updateLoanDetails(){

    this.LooanModelobj.accountNumber = this.formValue.value.accountNumber;
    this.LooanModelobj.loanType = this.formValue.value.loanType;
    this.LooanModelobj.loanAmount = this.formValue.value.loanAmount;
    this.LooanModelobj.status = this.formValue.value.status;
    this.LooanModelobj.date = this.formValue.value.date;
    console.log(this.LooanModelobj)

    this.api.updateLoan(this.LooanModelobj, this.LooanModelobj.id)
    .subscribe(res=>{
      alert("Updated Successfully");
      let ref = document.getElementById('cancel')
      ref?.click();
      this.formValue.reset();
      this.getLoanRequest();
    })
  }

}
