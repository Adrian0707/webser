import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

class Datee{
  $id:number;
  currentDateTime:string;
  utcOffset	:string;
  isDayLightSavingsTime	:Boolean;
  dayOfTheWeek	:string;
  timeZoneName	:string;
  currentFileTime	:Number;
  ordinalDate	:string;
  serviceResponse	:string;
}
@Injectable({
  providedIn: 'root'
})
export class DataService {

  private  apiUrl ='http://worldclockapi.com/api/json/utc/now'
  public data: Datee;
  private actual: boolean;
  constructor(private http:HttpClient){
  }
  getTime(){
    this.http.get<Datee>(this.apiUrl).subscribe(data =>{
      console.log(data);
      this.data=data;
      this.actual=true;
    })



  }
  getData(){

  this.getTime();

    return new Date(this.data.currentDateTime);
  }

}
