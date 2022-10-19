import { Component, OnInit } from '@angular/core';
import{ AuthenticationService } from 'src/app/service/authentication/authentication.service';


@Component({
  selector: 'app-sample',
  templateUrl: './sample.component.html',
  styleUrls: ['./sample.component.css']
})
export class SampleComponent implements OnInit {

  constructor(public authenticationService:AuthenticationService) {
  }
  ngOnInit(): void {
  }
  logout(){
    this.authenticationService.logout();
  }
}
