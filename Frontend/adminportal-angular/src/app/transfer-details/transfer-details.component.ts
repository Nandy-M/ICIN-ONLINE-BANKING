import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-transfer-details',
  templateUrl: './transfer-details.component.html',
  styleUrls: ['./transfer-details.component.css']
})
export class TransferDetailsComponent implements OnInit {

  TransferData !: any;

  constructor(private api : UsersService) { }

  ngOnInit(): void {
    this.getTransferHistory();
  }

  getTransferHistory(){
    this.api.getTransferDetails()
    .subscribe(res=>{
      console.log(res);
      this.TransferData = res;
      
    })
  }
}

