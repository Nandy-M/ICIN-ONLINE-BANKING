import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, NgModel } from '@angular/forms'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { EnableService } from './enable.service';
import { DisableService } from './disable.service';
import { UserAccountComponent } from './user-account/user-account.component';
import { CheckbookRequestsComponent } from './checkbook-requests/checkbook-requests.component';
import { HttpClientModule } from '@angular/common/http';
import { AuthorizeRegistrationComponent } from './authorize-registration/authorize-registration.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { ReactiveFormsModule } from '@angular/forms';
import { from } from 'rxjs';
import { TranscationHistoryComponent } from './transcation-history/transcation-history.component';
import { TransferDetailsComponent } from './transfer-details/transfer-details.component';
import { LoanComponent } from './loan/loan.component';
import { SampleComponent } from './sample/sample.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserAccountComponent,
    CheckbookRequestsComponent,
    AuthorizeRegistrationComponent,
    TranscationHistoryComponent,
    TransferDetailsComponent,
    LoanComponent,
    SampleComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    Ng2SearchPipeModule,
    ReactiveFormsModule
  ],
  providers: [EnableService, DisableService,],
  bootstrap: [AppComponent]
})
export class AppModule { }
