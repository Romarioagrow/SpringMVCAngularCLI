import {Component, isDevMode, OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Component({
  selector: 'app-product-table',
  templateUrl: './product-table.component.html',
  styleUrls: ['./product-table.component.css']
})
export class ProductTableComponent implements OnInit {
  constructor(private http: HttpClient){}

  displayedColumns: string[] = ['productID', 'productName', 'productType', 'productPrice'];
  dataSource :  Object = [];

  ngOnInit(): void {
    let apiUrl = 'api/products'
    let url = isDevMode() ? 'http://localhost:8080/app-cli/' + apiUrl : apiUrl
    console.log('let url: ' + url)

    this.http.get(url,{
      headers: {'Access-Control-Allow-Origin':'*'}
    }).subscribe(data => {
      console.log(data);
      if (data) {
        this.dataSource = data;
      }
    });
  }
}
