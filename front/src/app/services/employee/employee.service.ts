import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

class Employee {
  id_prac: Number;
  imie: String;
  nazwisko: String;
  email: String;
  login: String;
  haslo: String;
  nadzorca: Boolean;
}
class Work{
  id: Number;
  id_zglosz: Number;
  id_prac: Number;
}
class Notify {
  id_zglosz: Number;
  id_uzyt: Number;
  id_kategoria: Number;
  id_status: Number;
  id_priorytet: Number;
  opis: String;
  obraz: String;
  data_przyj: Date;
  data_max: Date;
  data_real: Date;
}
class Comment{
  id_komentarza: Number;
  id_prac: Number;
  id_zglosz: Number;
  comment: String;
  data: Date;

}
@Injectable({
  providedIn: 'root'
})

export class EmployeeService {
  private isEmployeeLoggedIn;
  private employee: Employee;
  employees: Employee[];
   employeesall: Employee[];
    notify: Notify[];
   notifyall: Notify[];
   coments: Comment[];
  private id: number;
  private i: number;
  constructor(private  http: HttpClient ,private router:Router) {
    this.isEmployeeLoggedIn=false;
    this.employee= new Employee();
  }
  getEmployeesId_zglo(id_zglo){
    this.http.get<Employee[]>('http://localhost:8080/Pracownicy/id_zglosz/'+id_zglo).subscribe(
    data => {
      this.employees = data;
    },
    err => {
      console.error('Error: Get User', err);
    }
  );

}
  getEmployeeLogHasDB(login,haslo){
    this.http.get<Employee>('http://localhost:8080/Pracownicy/'+login+"/"+haslo).subscribe(
      data => {
        this.employee = data;

        this.http.get<Notify[]>('http://localhost:8080/Zgloszenia/id_prac/' + this.employee.id_prac).subscribe(
          data => {
            this.notify = data;
            this.setEmployeeLoggedIn();
            this.router.navigate(['/emp']);
          },
          err => {
            console.error('Error: Get Notify[]', err);
          }
        );
      },
      err => {
        console.error('Error: Get User', err);
      }
    );
  }
  setEmployeeLoggedIn(){
    this.isEmployeeLoggedIn=true;
  }
  getEmployeeLoggedIn(){
    return this.isEmployeeLoggedIn;
  }
  getEmployee(){
    return this.employee;
  }
  getEmployees(){
    return this.employees;
  }
  getZglo(){
    return this.notify;
  }
  newEmployee(){
    this.employee= new Employee();
  }
  putNotify(notif:Notify){
    {
      this.http.put('http://localhost:8080/Zgloszenia', {
        "id_zglosz": notif.id_zglosz,
      "id_uzyt": notif.id_uzyt,
      "id_kategoria": notif.id_kategoria,
      "id_status": notif.id_status,
      "id_priorytet": notif.id_priorytet,
      "opis": notif.opis,
      "obraz": notif.obraz,
      "data_przyj": notif.data_przyj,
      "data_max": notif.data_max,
      "data_real": notif.data_real
      }).subscribe(data => { console.log(data);
      });
      console.log("prooogdog "+ notif.id_status);
    }
  }
  delWork(id1 :number, id2: number) {
   return this.http.delete('http://localhost:8080/Zadania_prac/del/'+id1+'/'+id2,).subscribe(data => {
   });
  }
  insertWork(id:number, id2:number){
    this.http.get<number>('http://localhost:8080/Zadania_prac/count').subscribe(
      data => {
        this.id = data;
        this.id++;
        {
          this.http.post<Work>('http://localhost:8080/Zadania_prac', {
            id: this.id,
          id_zglosz: id,
          id_prac: id2
          }).subscribe(data => {
          });
        }
      })
  }
  getAllEmployees(){
    this.http.get<Employee[]>('http://localhost:8080/Pracownicy').subscribe(
      data => {
        this.employeesall = data;
      },
      err => {
        console.error('Error: Get User', err);
      }
    );
  }
  getAllNotify(){
    this.http.get<Notify[]>('http://localhost:8080/Zgloszenia').subscribe(
      data => {
        this.notifyall = data;
      },
      err => {
        console.error('Error: Get User', err);
      }
    );

  }
  getAllComents(id:number){
    this.http.get<Comment[]>('http://localhost:8080/Komentarze/id_zglosz/'+id).subscribe(
      data => {
        this.coments = data;
      },
      err => {
        console.error('Error: Get User', err);
      }
    );
    
  }
  getName(id:number): String{
    for (let prop of this.employeesall) {
      if(prop.id_prac==this.id){
        return prop.login;
      }
    }
  }

}
