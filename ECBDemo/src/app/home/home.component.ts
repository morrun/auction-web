import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  selectedIndex: number;
  transform: number;
  constructor() {
    this.selectedIndex = 0;
    this.transform = 100;
  }

  sliderArray = [
    {img: 'http://bloquo.cc/img/works/1.jpg', alt: '', text: '365 Days Of weddings a year'},
    {img: 'http://bloquo.cc/img/works/2.jpg', alt: '',  text: '365 Days Of weddings a year'},
    {img: 'http://bloquo.cc/img/works/3.jpg', alt: '', text: '365 Days Of weddings a year'},
    {img: 'http://bloquo.cc/img/works/4.jpg', alt: '',  text: '365 Days Of weddings a year'},
    {img: 'http://bloquo.cc/img/works/5.jpg', alt: '', text: '365 Days Of weddings a year'}
  ];

  ngOnInit() {}

  selected(x) {
    this.downSelected(x);
    this.selectedIndex = x;

  }

  keySelected(x) {
    this.downSelected(x);
    this.selectedIndex = x;
  }
  downSelected(i) {
    this.transform =  100 - (i) * 50;
    this.selectedIndex = this.selectedIndex + 1;
    if(this.selectedIndex > 4) {
      this.selectedIndex = 0;
    }
  }
}
