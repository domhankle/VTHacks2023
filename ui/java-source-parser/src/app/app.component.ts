import { Component } from '@angular/core';
import { Inject } from '@angular/core';
import { EndpointService } from './endpoint.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'java-source-parser';
  myObj: string = '';

  constructor(
    @Inject(EndpointService) private endpointService: EndpointService
  ) {}

  public ngOnInit() {
    this.endpointService.getHelloWorld();
  }
}
