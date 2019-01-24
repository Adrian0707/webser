import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';

class User {
  id_uzyt: number;
  imie: string;
  nazwisko: string;
  email: string;
  login: string;
  haslo: string;
}

class Zglo {
  id_zglosz: number;
  id_uzyt: number;
  id_kategoria: number;
  id_status: number;
  id_priorytet: number;
  opis: string;
  obraz: string;
  data_przyj: Date;
  data_max: Date;
  data_real: Date;
}

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  user: User;
  zglo: Zglo[];

  constructor(private  http: HttpClient) {
  }

  ngOnInit() {
    this.http.get<User>('http://localhost:8080/Uzytkownicy/1').subscribe(
      data => {
        this.user = data;

        this.http.get<Zglo[]>('http://localhost:8080/Zgloszenia/uz.' + this.user.id_uzyt).subscribe(
          data => {
            this.zglo = data;
          },
          err => {
            console.error('Error: Get Zglo[]', err);
          }
        );
      },
      err => {
        console.error('Error: Get User', err);
      }
    );
  }

  onClick() {

    this.http.put<User>('http://localhost:8080/Uzytkownicy', {
      id_uzyt: this.user.id_uzyt,
      imie: this.user.imie,
      nazwisko: this.user.nazwisko,
      email: this.user.email,
      login: this.user.login,
      haslo: this.user.haslo
    }).subscribe(data => {
    });


  }

}


