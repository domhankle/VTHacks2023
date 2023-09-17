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
    this.initializeData();
  }

  public async initializeData(): Promise<void> {
    await this.putFileString();
    this.endpointService.getTokens();
  }

  public async putFileString(): Promise<void> {
    await this.endpointService.putFileString(
      'public static void main(String[] args )'
    );
    return Promise.resolve();
  }
}
