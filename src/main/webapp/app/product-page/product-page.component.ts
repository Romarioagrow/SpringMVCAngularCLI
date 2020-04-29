import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

export interface ProductObject {
  productID: string;
  productName: string;
  productType: string;
  productPrice: number;
}

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
//displayedColumns: string[] = ['productID', 'productName', 'productType', 'productPrice'];

export class ProductPageComponent implements OnInit {
  constructor(private http: HttpClient){}

  productData : ProductObject[] = [];

  ngOnInit(): void {
    this.getProductData();
  }

  getProductData() {
    const currentURL = window.location.href
    const productID = currentURL.substr(currentURL.lastIndexOf('/') + 1)
    console.log(productID)

    const url = 'api/products/product/' + productID
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
