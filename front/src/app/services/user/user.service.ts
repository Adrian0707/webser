import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
class User {
  id_uzyt: Number;
  imie: string;
  nazwisko: string;
  email: string;
  login: string;
  haslo: string;
}
class Notify {
  id_zglosz: Number;
  id_uzyt: Number;
  id_kategoria: Number;
  id_status: Number;
  id_priorytet: Number;
  opis: string;
  obraz: string;
  data_przyj: Date;
  data_max: Date;
  data_real: Date;
  nazwa:String;
}

@Injectable({
  providedIn: 'root'
})

export class UserService {
  private isUserLoggedIn;
  private user: User;
  private userNotfy: User;
  private notifies: Notify[];
  private id: number;
  private i: number;
  constructor(private  http: HttpClient,private router: Router) {
    this.isUserLoggedIn=false;
    this.user= new User();
  }
  putUserDB(){
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
  insertZgloDB(zglo:Notify){
    this.http.get<number>('http://localhost:8080/Zgloszenia/count').subscribe(
      data => {
        this.id = data;
        this.id++;
        {
          this.http.post<Notify>('http://localhost:8080/Zgloszenia', {

            id_zglosz: this.id,
          id_uzyt: zglo.id_uzyt,
          id_kategoria: zglo.id_kategoria,
          id_status: zglo.id_status,
          id_priorytet: zglo.id_priorytet,
          opis: zglo.opis,
          obraz: zglo.obraz,
          data_przyj: zglo.data_przyj,
          data_max: zglo.data_max,
          data_real: zglo.data_real,
          nazwa: zglo.nazwa
          }).subscribe(data => {
            
          });
        }
      })
      this.router.navigate(['/user']);
  }
  insertUserDB(user){

    this.http.get<number>('http://localhost:8080/Uzytkownicy/count').subscribe(
      data => {
        this.id = data;
        this.id++;
        {
          this.http.post<User>('http://localhost:8080/Uzytkownicy', {
            id_uzyt: this.id,
            imie: user.imie,
            nazwisko: user.nazwisko,
            email: user.email,
            login: user.login,
            haslo: user.haslo
          }).subscribe(data => {
            
          });
        }
      })
  }
  getUserLogHasDB(login,haslo){
    this.http.get<User>('http://localhost:8080/Uzytkownicy/'+login+"/"+haslo).subscribe(
      data => {
        this.user = data;

        this.http.get<Notify[]>('http://localhost:8080/Zgloszenia/uz.' + this.user.id_uzyt).subscribe(
          data => {
            this.notifies = data;
            this.setUserLoggedIn();
            this.router.navigate(['/user']);
          },
          err => {
            console.error('Error: Get Notify[]', err);

          }
        );
      },
      err => {
        console.error('Error: Get User', err);
        this.router.navigate(['/bad']);
      }
    );
  }
  getUserNotifLogDB(id:number){
    this.http.get<User>('http://localhost:8080/Uzytkownicy/'+id).subscribe(
      data => {
       // this.user = data;
       this.userNotfy=data;
      },
      err => {
        console.error('Error: Get User', err);

      }
    );
    //this.isUserLoggedIn=true;

  }
  getUserNotifLogDBCheck(name:string){
   return this.http.get<User>('http://localhost:8080/Uzytkownicy/'+name+"/get")
  }
  setUserLoggedIn(){
    this.isUserLoggedIn=true;
  }
  getUserLoggedIn(){
    return this.isUserLoggedIn;
  }
  getUser(){
    return this.user;
  }
  getUserNotif(){
    return this.userNotfy;
}
  getNotify(){
    return this.notifies;
  }
  newUser(){
    this.user= new User();
  }
  translateId_status(notyf : Notify){
    if(notyf.id_status==1)
      return "przyjete";
    else if(notyf.id_status==2)
      return "rozpatrzone";
    else if(notyf.id_status==3)
      return "zakonczone";

  }
  translateId_priorytet(notyf : Notify){
    if(notyf.id_priorytet==1)
      return "niski";
    else if(notyf.id_priorytet==2)
      return "sredni";
    else if(notyf.id_priorytet==3)
      return "wysoki";

  }
  translateId_kategoria(notyf : Notify){
    if(notyf.id_kategoria==1)
      return "pralka";
    else if(notyf.id_kategoria==2)
      return "zmywarka";
    else if(notyf.id_kategoria==3)
      return "lodówka";

  }
  translateId_statusL(notyf : number){
    if(notyf==1)
      return "przyjete";
    else if(notyf==2)
      return "rozpatrzone";
    else if(notyf==3)
      return "zakonczone";

  }
  translateId_priorytetL(notyf : number){
    if(notyf==1)
      return "niski";
    else if(notyf==2)
      return "sredni";
    else if(notyf==3)
      return "wysoki";

  }
  translateId_kategoriaL(notyf : number){
    if(notyf==1)
      return "pralka";
    else if(notyf==2)
      return "zmywarka";
    else if(notyf==3)
      return "lodówka";

  }

}
