import { Component, OnInit } from '@angular/core';
declare var particlesJS: any;
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Strona testowa ';



ngOnInit() {
  particlesJS.load('particles-js', 'assets/data/particles.json', function ()
   { console.log('callback - particles.js config loaded'); });
}
}