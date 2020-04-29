import { Component, OnInit } from '@angular/core';
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
    this.http.get('api/products',{
      headers: {'Access-Control-Allow-Origin':'*'}
    }).subscribe(data => {
      console.log(data);
      if (data) {
        this.dataSource = data;
      }
    });
  }
}
