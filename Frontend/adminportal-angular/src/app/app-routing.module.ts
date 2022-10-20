import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { UserAccountComponent } from './user-account/user-account.component';
import { CheckbookRequestsComponent } from './checkbook-requests/checkbook-requests.component';
import { AuthGuard } from './guards/auth.guard'
import { AuthorizeRegistrationComponent } from './authorize-registration/authorize-registration.component';
import { TranscationHistoryComponent } from './transcation-history/transcation-history.component';
import { TransferDetailsComponent } from './transfer-details/transfer-details.component';
import { LoanComponent } from './loan/loan.component';
import { SampleComponent } from './sample/sample.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'user-account', component: UserAccountComponent, canActivate: [AuthGuard] },
  { path: 'checkbook-requests', component: CheckbookRequestsComponent, canActivate: [AuthGuard] },
  { path: 'authorize', component: AuthorizeRegistrationComponent, canActivate: [AuthGuard] },
  {path: 'transcation', component:TranscationHistoryComponent, canActivate: [AuthGuard]},
  {path: 'transfer', component:TransferDetailsComponent},
  {path: 'loanrequest', component:LoanComponent, canActivate: [AuthGuard]},
  {path:'home', component:SampleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
