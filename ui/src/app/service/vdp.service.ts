import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class VdpService {

  constructor(private httpClient: HttpClient) { }

  getVdpHelloWorld() {
    return this.httpClient.get("http://localhost:8080/api/v1/helloworld");
  }
}
