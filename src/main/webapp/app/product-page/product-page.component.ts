import {Component, isDevMode, OnInit} from '@angular/core';
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

export class ProductPageComponent implements OnInit {
  constructor(private http: HttpClient){}

  productData : ProductObject[] = [];

  ngOnInit(): void {
    this.getProductData();
  }

  getProductData() {
    const productID = ProductPageComponent.resolveProductID();
    console.log(productID)

    let apiUrl = 'api/products/product/' + productID
    let url = isDevMode() ? 'http://localhost:8080/app-cli/' + apiUrl : apiUrl

    const headers = { 'Access-Control-Allow-Origin': '*' }
    console.log('let url: ' + url)

    this.http.get<any>(url).subscribe(data => {
      console.log(data)
      this.productData = data;
    })
  }

  private static resolveProductID() {
    const currentURL = window.location.href
    return currentURL.substr(currentURL.lastIndexOf('/') + 1)
  }
}
