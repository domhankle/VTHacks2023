import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderBarComponent } from './header-bar/header-bar.component';
import { EndpointService } from './endpoint.service';
import { HttpClientModule } from '@angular/common/http';
import { FileInputComponent } from './file-section/file-input/file-input.component';
import { FileSectionComponent } from './file-section/file-section.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HeaderBarComponent,
    FileInputComponent,
    FileSectionComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [EndpointService],
  bootstrap: [AppComponent],
})
export class AppModule {}
