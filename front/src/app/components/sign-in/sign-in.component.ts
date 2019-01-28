import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserService} from '../../services/user/user.service';
class User {
  id_uzyt: Number;
  imie: string;
  nazwisko: string;
  email: string;
  login: string;
  haslo: string;
}
@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})


export class SignInComponent implements OnInit {

  user: User;


  constructor(private userService:UserService) {
  }

  ngOnInit() {
    this.user=new User();

  }

  onClick(event) {

    this.userService.insertUserDB(this.user);

}
}
