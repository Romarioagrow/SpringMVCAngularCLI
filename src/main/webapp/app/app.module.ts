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
import {
  NbActionsModule,
  NbButtonModule,
  NbCardModule,
  NbIconModule, NbInputModule,
  NbLayoutModule,
  NbThemeModule
} from '@nebular/theme';
import {NbEvaIconsModule} from '@nebular/eva-icons';
import {APP_BASE_HREF} from '@angular/common';
import { LoginComponent } from './login/login.component';

/// const base_href = isDevMode() ? '/' : '/api-cli';

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    ProductPageComponent,
    ProductTableComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {path: '', component: ProductsComponent, pathMatch: 'full'},
      {path: 'login', component: LoginComponent, pathMatch: 'full'},
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
    NbButtonModule,
    NbIconModule,
    NbActionsModule,
    NbInputModule
  ],
  providers: [{provide: APP_BASE_HREF, useValue: '/app-cli'}], /// base_href
  bootstrap: [AppComponent]
})

export class AppModule implements DoBootstrap {
  ngDoBootstrap() {
  }
}
