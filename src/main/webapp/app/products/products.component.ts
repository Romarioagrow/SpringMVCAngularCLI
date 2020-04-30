import {Component, isDevMode} from '@angular/core';
import { HttpClient } from '@angular/common/http'
import {ProductTableComponent} from "app/product-table/product-table.component";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent {
  constructor(private http: HttpClient){}

  /*createProductsList() {

    console.log('createProductsList')

    let apiUrl = 'api/products/createList'
    let url = isDevMode() ? 'http://localhost:8080/app-cli/' + apiUrl : apiUrl
    console.log('let url: ' + url)

    this.http.get(url,{
      headers: {'Access-Control-Allow-Origin':'*'}
    }).subscribe(data => {
      console.log(data);
      if (data) {

        console.log(data)
        //ProductTableComponent.dataSource = data;
      }
    });

  }*/
}
