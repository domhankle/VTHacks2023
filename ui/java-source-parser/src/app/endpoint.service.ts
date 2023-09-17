import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EndpointService {
  constructor(private http: HttpClient) {}

  public getHelloWorld(): void {
    this.http
      .get('http://localhost:8080/home', { responseType: 'text' })
      .subscribe(
        (response: string) => {
          console.log(response); // This should print "Hello World!"
        },
        (error) => {
          console.error(error);
        }
      );
  }
}
