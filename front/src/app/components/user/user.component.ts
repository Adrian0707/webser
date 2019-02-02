import {Component, OnInit,ChangeDetectionStrategy} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserService} from '../../services/user/user.service';
import {EmployeeService} from '../../services/employee/employee.service';
import {Router} from '@angular/router';



@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class UserComponent implements OnInit {
  public opened: number;
  items = Array.from({length: 100000}).map((_, i) => `Item #${i}`);

  constructor( public  userService:UserService, public employee:EmployeeService,private  router:Router) {
  }

  ngOnInit() {

  }

  onClick(event) {

    this.userService.getUserLogHasDB(this.userService.getUser().login,this.userService.getUser().haslo)

  }
  notifyOpen(nr : number ){
    this.employee.employees=null;
    this.employee.getEmployeesId_zglo(nr);
    this.opened=nr;
    
    

  }

}


