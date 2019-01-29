import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../../services/employee/employee.service';
import {UserService} from '../../services/user/user.service';
import {DataService} from '../../services/data.service';
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

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  public opened: number;
  public coment: Comment;
  constructor(public employee:EmployeeService, public user:UserService, public data:DataService) { }

  ngOnInit() {
    this.coment=new Comment();
  }

  refresh(){
    this.employee.getEmployeeLogHasDB(this.employee.getEmployee().login,this.employee.getEmployee().haslo);
  }
  onClick($event,tekst,idNotify) {


    this.coment.data= new Date(Date.now());
    this.coment.id_zglosz=idNotify;
    this.coment.comment = tekst.toString();
    this.coment.id_prac=this.employee.getEmployee().id_prac;
    this.employee.insertComent(this.coment);

  }

  notifyOpen(nr : number ,userNr: number){
    this.opened=nr;
    this.employee.getEmployeeLogHasDB(this.employee.getEmployee().login,this.employee.getEmployee().haslo);
    this.employee.getEmployeesId_zglo(nr);
    this.employee.getAllComents(nr);
    this.user.getUserNotifLogDB(userNr);
    this.employee.getAllEmployees();
  }
  changeStatus(notif: Notify){
    this.employee.putNotify(notif);

  }
  del(id:number, id2:number,nr:number){

  this.employee.delWork(id,id2);
  }
}
