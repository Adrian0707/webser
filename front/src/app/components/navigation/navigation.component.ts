import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user/user.service';
import {EmployeeService} from '../../services/employee/employee.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(private user:UserService, private employee:EmployeeService) { }

  ngOnInit() {
  }

}