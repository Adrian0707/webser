import {Injectable} from '@angular/core';
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

class Work {
  id: Number;
  id_zglosz: Number;
  id_prac: Number;
  czas: Number;
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
  nazwa: String;
}

class Comment {
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
  work: Work;
  private id: number;
  private i: number;

  constructor(private  http: HttpClient, private router: Router) {
    this.isEmployeeLoggedIn = false;
    this.employee = new Employee();
  }


  getEmployeesId_zglo(id_zglo) {
    this.http.get<Employee[]>('http://localhost:8080/Pracownicy/id_zglosz/' + id_zglo).subscribe(
      data => {
        this.employees = data;
      },
      err => {
        console.error('Error: Get User', err);
      }
    );

  }

  getEmployeeLogHasDB(login, haslo) {
    this.http.get<Employee>('http://localhost:8080/Pracownicy/' + login + '/' + haslo).subscribe(
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
        this.router.navigate(['/bad']);

      }
    );
  }

  setEmployeeLoggedIn() {
    this.isEmployeeLoggedIn = true;
  }

  getEmployeeLoggedIn() {
    return this.isEmployeeLoggedIn;
  }

  getEmployee() {
    return this.employee;
  }

  getEmployees() {
    return this.employees;
  }

  getAllEmployees() {
    this.http.get<Employee[]>('http://localhost:8080/Pracownicy').subscribe(
      data => {
        this.employeesall = data;
      },
      err => {
        console.error('Error: Get User', err);
      }
    );
  }

  getZglo() {
    return this.notify;
  }

  newEmployee() {
    this.employee = new Employee();
  }

  getAllNotify() {
    this.http.get<Notify[]>('http://localhost:8080/Zgloszenia').subscribe(
      data => {
        this.notifyall = data;
      },
      err => {
        console.error('Error: Get User', err);
      }
    );

  }

  putNotify(notif: Notify) {

      this.http.put('http://localhost:8080/Zgloszenia', {
        'id_zglosz': notif.id_zglosz,
        'id_uzyt': notif.id_uzyt,
        'id_kategoria': notif.id_kategoria,
        'id_status': notif.id_status,
        'id_priorytet': notif.id_priorytet,
        'opis': notif.opis,
        'obraz': notif.obraz,
        'data_przyj': notif.data_przyj,
        'data_max': notif.data_max,
        'data_real': notif.data_real,
        'nazwa': notif.nazwa
      }).subscribe(data => {
        console.log(data);
      });


  }

  getWork(id1: number, id2: number) {
    this.http.get<Work>('http://localhost:8080/Zadania_prac/' + id1 + '/' + id2).subscribe(
      data => {
        this.work = data;
      },
      err => {
        console.error('Error: Get Work', err);
      }
    );

  }

  delWork(id1: number, id2: number) {
    return this.http.delete('http://localhost:8080/Zadania_prac/del/' + id1 + '/' + id2,).subscribe(data => {
    });
  }

  insertWork(id: number, id2: number) {
    this.http.get<number>('http://localhost:8080/Zadania_prac/count').subscribe(
      data => {
        this.id = data;
        this.id++;
        {
          this.http.post<Work>('http://localhost:8080/Zadania_prac', {
            id: this.id,
            id_zglosz: id,
            id_prac: id2,
            czas: 0
          }).subscribe(data => {
          });
        }
      });
  }

  putWork(work: Work) {
    this.http.put('http://localhost:8080/Zadania_prac', {
      "id": work.id,
      "id_zglosz": work.id_zglosz,
      "id_prac": work.id_prac,
      "czas": work.czas
    }).subscribe(data => { console.log(data);
    });
  }

  getAllComents(id: number) {
    this.http.get<Comment[]>('http://localhost:8080/Komentarze/id_zglosz/' + id).subscribe(
      data => {
        this.coments = data;
      },
      err => {
        console.error('Error: Get User', err);
      }
    );

  }

  insertComent(coment: Comment) {
    this.http.get<number>('http://localhost:8080/Komentarze/count').subscribe(
      data => {
        this.id = data;
        this.id++;
        {
          this.http.post<Comment>('http://localhost:8080/Komentarze', {
            id_komentarza: this.id,
            id_prac: coment.id_prac,
            id_zglosz: coment.id_zglosz,
            comment: coment.comment,
            data: coment.data
          }).subscribe(data => {
          });
        }
      });
  }

}
