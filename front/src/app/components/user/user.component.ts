import {Component, OnInit} from '@angular/core';
import {HttpErrorResponse} from '@angular/common/http';
import {HttpClient} from '@angular/common/http';

interface UserResponse {
  login: string,
  bio: string,
  company: string


}

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  name: string;
  age: number;
  email: string;
  adress: Adress;
  hobbies: string[];
  hello: any;
  log:string;
  bio:string;
  company:string;

  constructor(private  http: HttpClient) {
    console.log('construktor');
  }

  ngOnInit() {
    console.log('init');
    this.name = 'John jo';
    this.email = 'kotkoko@com.pl';
    this.age = 30;
    this.adress = {
      street: 'przytyk',
      city: 'warsaw',
      state: 'mazwoeckie'

    };
    this.hobbies = ['write', 'music'];
    this.http.get<UserResponse>('http://localhost:8080/Uzytkownicy').subscribe(data => {
        console.log('User login: ' + data.login);
        this.log=data.login;
        console.log('User bio: ' + data.bio);
        this.bio=data.bio;
        console.log('User company: ' + data.company);
        this.company=data.company;
      },(err: HttpErrorResponse)=>{
      if(err.error instanceof  Error){
        console.log('client errror');
      }
      else{
      console.log("server error")}
      }
    )
    const req = this.http.post('http://jsonplaceholder.typicode.com/posts', {
      title: 'foo',
      body: 'bar',
      userId: 1
    })
      .subscribe(
        res=>{
          console.log(res);
        },
        err=>{
          console.log("Error");
        }
      )
  }

  onClick() {
    console.log('hello');
    this.name = 'MORRRRRRRRRRR';
    this.hobbies.push('hobbbbson');
  }

  deleteHobby(hobby) {
    for (let i = 0; i < this.hobbies.length; i++) {
      if (this.hobbies[i] === hobby) {
        this.hobbies.splice(i, 1);
      }
    }
  }

  addHobby(hobby) {
    console.log(hobby);
    this.hobbies.unshift(hobby);
    return false;

  }

}

interface Adress {
  street: string;
  city: string;
  state: string;
}
