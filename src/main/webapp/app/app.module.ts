import { BrowserModule } from '@angular/platform-browser';
import {DoBootstrap, NgModule} from '@angular/core';
import { AppComponent } from './app.component';
import { ProductsComponent } from './products/products.component';
import {RouterModule} from "@angular/router";
import { ProductPageComponent } from './product-page/product-page.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatTableModule} from "@angular/material/table";
import { ProductTableComponent } from './product-table/product-table.component';
import {MatCardModule} from "@angular/material/card";
import {MatGridListModule} from "@angular/material/grid-list";
import { HttpClientModule } from '@angular/common/http';
import { NbThemeModule, NbLayoutModule } from '@nebular/theme';
import { NbEvaIconsModule } from '@nebular/eva-icons';
/*import { MatTableModule } from "@angular/material"*/


@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    ProductPageComponent,
    ProductTableComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      /*{ path: '', component: ProductListComponent },*/
      /*{ path: 'products/:productId', component: ProductDetailsComponent },*/
      {path: '', component: ProductsComponent},
      {path: 'product', component: ProductPageComponent},
    ]),
    BrowserAnimationsModule,
    MatTableModule,
    MatCardModule,
    MatGridListModule,
    HttpClientModule,
    NbThemeModule.forRoot({ name: 'default' }),
    NbLayoutModule,
    NbEvaIconsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})




export class AppModule implements DoBootstrap {
  ngDoBootstrap() {
  }

}
