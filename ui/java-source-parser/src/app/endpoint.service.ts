import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EndpointService {
  constructor(private http: HttpClient) {}

  public getSimilarity(): Observable<any> {
    return this.http.get('http://localhost:8080/tokens/compare');
  }

  public putFileStrings(
    fileString1: string,
    fileString2: string
  ): Observable<any> {
    return this.http.put('http://localhost:8080/tokens/parse', [
      fileString1,
      fileString2,
    ]);
  }
}
