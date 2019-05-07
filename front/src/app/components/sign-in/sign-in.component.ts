import {Component, OnInit} from '@angular/core';
import {UserService} from '../../services/user/user.service';
import {Router} from '@angular/router';

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
  created: Boolean;

  constructor(private userService: UserService, private router: Router) {
  }

  ngOnInit() {
    this.user = new User();

  }

  onClick(event) {
    this.created = false;
    if ((this.user.login.length > 0) && (this.user.haslo.length > 2)) {

      this.userService.getUserNotifLogDBCheck(this.user.login).subscribe(
        data => {
          this.created = false;
        },
        err => {
          this.userService.insertUserDB(this.user);
          this.created = true;
        }
      );
    }
  }
}
