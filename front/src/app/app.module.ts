import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AppComponent} from './app.component';
import {UserComponent} from './components/user/user.component';
import {HttpClientModule} from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import {Routes, RouterModule} from '@angular/router';
import { NavigationComponent } from './components/navigation/navigation.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import {UserService} from './services/user/user.service';
import {AutoguardGuard} from './autoguard.guard';
import { EmployeeComponent } from './components/employee/employee.component';
import {EmployeeService} from './services/employee/employee.service';
import { NotificationComponent } from './components/notification/notification.component';
import { NewWorkComponent } from './components/new-work/new-work.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import {MatButtonModule, MatCheckboxModule} from '@angular/material';
import {MatInputModule} from '@angular/material/input';
import {MatMenuModule} from '@angular/material/menu';
import {MatCardModule} from '@angular/material/card'; 
import {ScrollDispatchModule} from '@angular/cdk/scrolling';


const appRoutes: Routes = [
  {
    path:'user',
    canActivate:[AutoguardGuard],
    component:UserComponent
  },
  {
    path:'notif',
    //canActivate:[AutoguardGuard],
    component:NotificationComponent
  },
  {
    path:'emp',
    canActivate:[AutoguardGuard],
    component:EmployeeComponent
  },
  {
    path: 'new-work',
    canActivate:[AutoguardGuard],
    component:NewWorkComponent
  },
  {
    path: 'Log',
    component:LoginComponent,
    pathMatch: 'full'
  },
  {
    path: '',
    component:HomePageComponent,
    pathMatch: 'full'
  },
  {
    path: 'sign-in',
    component:SignInComponent
  },
  {
    path: '**',
    component:NotFoundComponent
  }

];
@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    LoginComponent,
    NotFoundComponent,
    NavigationComponent,
    SignInComponent,
    EmployeeComponent,
    NotificationComponent,
    NewWorkComponent,
    HomePageComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    MatButtonModule,
    MatCheckboxModule,
    MatInputModule,
    MatMenuModule,
    MatCardModule,
    ScrollDispatchModule
  ],
  exports:[

  ],
  providers: [UserService,EmployeeService, AutoguardGuard],
  bootstrap: [AppComponent]
})
//export class PizzaPartyAppModule { }
export class AppModule {
}
