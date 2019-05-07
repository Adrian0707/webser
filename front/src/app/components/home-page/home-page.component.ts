import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {UserService} from '../../services/user/user.service';
import {EmployeeService} from '../../services/employee/employee.service';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  private emp: boolean = false;

  constructor(private router: Router, private userService: UserService, private employeeService: EmployeeService) {
  }


  ngOnInit() {
  }

  loginUser(event) {
    event.preventDefault();
    const target = event.target;
    const username = target.querySelector('#username').value;
    const password = target.querySelector('#password').value;
    if ((password.length > 0) && (username.length > 0)) {
      if (!this.emp) {
        this.userService.getUserLogHasDB(username, password);
      } else {
        this.employeeService.getEmployeeLogHasDB(username, password);

      }
    }
  }
}
