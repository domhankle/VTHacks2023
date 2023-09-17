import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderBarComponent } from './header-bar/header-bar.component';
import { EndpointService } from './endpoint.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [AppComponent, HeaderBarComponent],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule],
  providers: [EndpointService],
  bootstrap: [AppComponent],
})
export class AppModule {}
