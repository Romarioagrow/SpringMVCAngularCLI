import {BrowserModule} from '@angular/platform-browser';
import {DoBootstrap, isDevMode, NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {ProductsComponent} from './products/products.component';
import {RouterModule} from "@angular/router";
import {ProductPageComponent} from './product-page/product-page.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatTableModule} from "@angular/material/table";
import {ProductTableComponent} from './product-table/product-table.component';
import {MatCardModule} from "@angular/material/card";
import {MatGridListModule} from "@angular/material/grid-list";
import {HttpClientModule} from '@angular/common/http';
import {NbButtonModule, NbCardModule, NbLayoutModule, NbThemeModule} from '@nebular/theme';
import {NbEvaIconsModule} from '@nebular/eva-icons';
import {APP_BASE_HREF} from '@angular/common';

/// const base_href = isDevMode() ? '/' : '/api-cli';

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
      {path: '', component: ProductsComponent, pathMatch: 'full'},
      {path: 'product/:productID', component: ProductPageComponent, pathMatch: 'full'},
    ]),
    BrowserAnimationsModule,
    MatTableModule,
    MatCardModule,
    MatGridListModule,
    HttpClientModule,
    NbThemeModule.forRoot({name: 'default'}),
    NbLayoutModule,
    NbEvaIconsModule,
    NbCardModule,
    NbButtonModule
  ],
  providers: [{provide: APP_BASE_HREF, useValue: '/app-cli'}], /// base_href
  bootstrap: [AppComponent]
})

export class AppModule implements DoBootstrap {
  ngDoBootstrap() {
  }
}
