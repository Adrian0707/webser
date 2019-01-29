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
   return this.http.get<Datee>(this.apiUrl)



  }


}
