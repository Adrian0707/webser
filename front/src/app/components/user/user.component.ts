import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserService} from '../../services/user/user.service';
import {EmployeeService} from '../../services/employee/employee.service';



@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  public opened: number;


  constructor( public  userService:UserService, public employee:EmployeeService) {
  }

  ngOnInit() {

  }

  onClick(event) {

    this.userService.getUserLogHasDB(this.userService.getUser().login,this.userService.getUser().haslo)

  }
  notifyOpen(nr : number ){
    this.opened=nr;
    this.employee.getEmployeesId_zglo(nr);
  }

}


