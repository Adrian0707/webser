import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {DataService} from './services/data.service';
import {AppComponent} from './app.component';
import {UserComponent} from './components/user/user.component';
import {HttpClientModule} from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import {Routes, Router, RouterModule} from '@angular/router';
import { NavigationComponent } from './components/navigation/navigation.component';
import { MailComponent } from './components/mail/mail.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import {MatButtonModule,MatCheckboxModule} from '@angular/material';

const appRoutes: Routes = [
  {
    path:'user',
    component:UserComponent
  },
  {
    path:'mail',
    component:MailComponent
  },
  {
    path: 'login',
    component:LoginComponent,
    //pathMatch: 'full'
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
    MailComponent,
    SignInComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    MatButtonModule,
    MatCheckboxModule
  ],
  exports:[
    MatButtonModule,
    MatCheckboxModule

  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class PizzaPartyAppModule { }
export class MyOwnCustomMaterialModule { }
export class AppModule {
}
