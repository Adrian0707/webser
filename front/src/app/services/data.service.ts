import { Injectable } from '@angular/core';
//import {HttpClient} from '@angular/common/http';


import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DataService {

 /* constructor(public  http:HttpClient) {
    console.log('data service conected');
  }
  getPosts(){
   return this.http.get('https://jsonplaceholder.typicode.com/posts')
     .pipe(map(res=>res));

  }*/

}
