import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {EmployeeService} from '../../services/employee/employee.service';
import {UserService} from '../../services/user/user.service';
import {DataService} from '../../services/data.service';
import {timer} from 'rxjs';

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

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class EmployeeComponent implements OnInit {
  public opened: number;
  public coment: Comment;
  public sec: number = 0;
  public comentsWindow: boolean = false;
  public statisticsWindow: boolean = false;

  interval;

  constructor(public employee: EmployeeService, public user: UserService, public data: DataService) {
  }

  ngOnInit() {
    this.coment = new Comment();
  }

  refresh() {
    this.employee.getEmployeeLogHasDB(this.employee.getEmployee().login, this.employee.getEmployee().haslo);
  }

  onClick($event, tekst, idNotify) {
    this.coment.data = new Date(Date.now());
    this.coment.id_zglosz = idNotify;
    this.coment.comment = tekst;
    this.coment.id_prac = this.employee.getEmployee().id_prac;
    this.employee.insertComent(this.coment);
  }

  comments() {

  }

  notifyOpen(nr: number, userNr: number) {
    this.sec = 0;
    this.opened = nr;
    this.employee.getWork(userNr, nr);
    //this.employee.getEmployeeLogHasDB(this.employee.getEmployee().login,this.employee.getEmployee().haslo);
    this.employee.employees = null;
    this.employee.getAllComents(nr);
    this.user.getUserNotifLogDB(userNr);
    this.employee.getAllEmployees();
    this.employee.getEmployeesId_zglo(nr);
  }

  changeStatus(notif: Notify) {
    this.employee.putNotify(notif);

  }

  commRefresh(nr: number) {
    this.employee.getAllComents(nr);
  }

  del(id: number, id2: number, nr: number) {

    this.employee.delWork(id, id2);
  }


  startTimer() {
    this.interval = setInterval(() => {
      this.sec++;
    }, 1000);
  }

  pauseTimer() {
    clearInterval(this.interval);
  }

  addtime() {
    this.employee.work.czas = this.employee.work.czas.valueOf() + (this.sec / 360);
    this.employee.putWork(this.employee.work);
    this.sec = 0;
  }

  commentsWindowSwitch() {
    this.comentsWindow = !this.comentsWindow;
  }

  statisticsWindowSwitch() {
    this.statisticsWindow = !this.statisticsWindow;
  }
}


