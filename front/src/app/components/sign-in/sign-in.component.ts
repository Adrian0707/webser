import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
class User {
  id_uzyt: number;
  imie: string;
  nazwisko: string;
  email: string;
  login: string;
  haslo: string
}

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})

export class SignInComponent implements OnInit {
  user: User;
  id: number

  constructor(private  http: HttpClient) {
  }

  ngOnInit() {
    this.user= new User();
  }

  onClick() {
    this.http.get<number>('http://localhost:8080/Uzytkownicy/count').subscribe(
      data => {
       this.id = data;
       this.id++;
    {
      this.http.post<User>('http://localhost:8080/Uzytkownicy', {
        id_uzyt: this.id,
        imie: this.user.imie,
        nazwisko: this.user.nazwisko,
        email: this.user.email,
        login: this.user.login,
        haslo: this.user.haslo
      }).subscribe(data => {
      });
    }
  })
}
}
