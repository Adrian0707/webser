import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user/user.service';
import {DataService} from '../../services/data.service';



class Zglo {
  id_zglosz: Number;
  id_uzyt: Number;
  id_kategoria: Number;
  id_status: Number;
  id_priorytet: Number;
  opis: string;
  obraz: string;
  data_przyj: Date;
  data_max: Date;
  data_real: Date;
}

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent implements OnInit {
zglo: Zglo;
  constructor(private user:UserService,private  data:DataService) { }

  ngOnInit() {this.zglo=new Zglo();
  }
  onClick($event,tekst){
    this.data.getTime().subscribe(data =>{
      this.zglo.data_przyj=new Date(data.currentDateTime);
    this.zglo.opis=tekst;
    this.zglo.id_uzyt=this.user.getUser().id_uzyt;
    this.zglo.id_priorytet=1;
    this.zglo.id_status=1;
    this.user.insertZgloDB(this.zglo)
    });
  }

}
