import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EndpointService {
  constructor(private http: HttpClient) {}

  public getTokens(): void {
    this.http.get('http://localhost:8080/tokens/translate').subscribe(
      (response) => {
        console.log(response); // This should print "Hello World!"
      },
      (error) => {
        console.error(error);
      }
    );
  }

  public putFileString(fileString: string): void {
    this.http.put('http://localhost:8080/tokens/parse', fileString).subscribe(
      (response) => {
        console.log(response);
      },
      (error) => {
        console.error(error);
      }
    );
  }
}
