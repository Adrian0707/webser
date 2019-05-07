import {Component, OnInit} from '@angular/core';
import {EmployeeService} from '../../services/employee/employee.service';
import {UserService} from '../../services/user/user.service';

@Component({
  selector: 'app-new-work',
  templateUrl: './new-work.component.html',
  styleUrls: ['./new-work.component.css']
})
export class NewWorkComponent implements OnInit {
  private opened: number;

  constructor(public employee: EmployeeService, public user: UserService) {
  }

  ngOnInit() {
    this.employee.getAllNotify();
    this.employee.getAllEmployees();
  }

  notifyOpen(nr: number) {
    this.opened = nr;
    this.employee.getEmployeesId_zglo(nr);
  }

  addwork(id: number, id2: number) {
    this.employee.insertWork(id, id2);
  }
}
