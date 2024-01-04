import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { wallet } from '../../../wallet';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WalletServiceService {

  constructor(private httpClient:HttpClient) { }
  private addURL="http://localhost:8085/add";
  addUser(w:wallet):Observable<wallet>{
    return this.httpClient.post<wallet>(`${this.addURL}`, w);
  }

  private getDetails = "http://localhost:8085/";

  getUser(id: number,user:string): Observable<wallet> {
    const url = `${this.getDetails}${id}/${user}`; // Construct base URL with ID

     return this.httpClient.get<wallet>(url);
}
}
