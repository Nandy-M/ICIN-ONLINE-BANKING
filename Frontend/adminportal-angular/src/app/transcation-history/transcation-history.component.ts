import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-transcation-history',
  templateUrl: './transcation-history.component.html',
  styleUrls: ['./transcation-history.component.css']
})
export class TranscationHistoryComponent implements OnInit {

  TranscationData !: any;

  constructor(private api : UsersService) { }

  ngOnInit(): void {
    this.getTrascationHistory();
  }

  getTrascationHistory(){
    this.api.getTranscationHistory()
    .subscribe(res=>{
      console.log(res);
      this.TranscationData = res;
      
    })
  }
}
