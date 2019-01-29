import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import {UserService} from './services/user/user.service';
import {EmployeeService} from './services/employee/employee.service';

@Injectable({
  providedIn: 'root'
})
export class AutoguardGuard implements CanActivate {
  constructor( private user: UserService, private employee : EmployeeService){

  }


  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if(this.user.getUserLoggedIn())
    return this.user.getUserLoggedIn();
    else
      return this.employee.getEmployeeLoggedIn();
  }
}
