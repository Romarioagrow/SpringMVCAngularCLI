import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})

/*export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}*/

export class ProductPageComponent implements OnInit {
  constructor(private http: HttpClient){}

  productData :  Object = [];

  ngOnInit(): void {
    this.getProductData();
  }


  getProductData() {
    const currentURL = window.location.href
    const productID = currentURL.substr(currentURL.lastIndexOf('/') + 1)
    console.log(productID)

    const url = 'http://localhost:8080/app-cli/api/products/product/' + productID
    //const body = { productID: productID }
    const headers = { 'Access-Control-Allow-Origin': '*' }

    this.http.get<any>(url).subscribe(data => {
      console.log(data)
      this.productData = data;
    })



    /*this.http.post('http://localhost:8080/app-cli/api/products/product',{
      data:productID,
      headers: {'Access-Control-Allow-Origin':'*'}
    }).subscribe(data => {
      console.log(data);
      if (data) {
        this.productData = data;
      }
    });*/

  }

}
