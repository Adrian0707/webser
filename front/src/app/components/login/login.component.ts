import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {UserService} from '../../services/user/user.service';
import {EmployeeService} from '../../services/employee/employee.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private emp: boolean;

  constructor(private router: Router, private userService: UserService, private employeeService:EmployeeService) {
  }


  ngOnInit() {
  }

  loginUser(event) {
    event.preventDefault();
    const target = event.target;
    const username = target.querySelector('#username').value;
    const password = target.querySelector('#password').value;

    if (!this.emp) {
      this.userService.getUserLogHasDB(username, password);
    }
    else {
      this.employeeService.getEmployeeLogHasDB(username, password);

    }
  }
}
