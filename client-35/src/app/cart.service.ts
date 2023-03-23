import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cart } from './models';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor( private httpClient: HttpClient ) {}

  private URL = "http://localhost:8080/api/order"

  postForm$(cart: Cart) {
    return this.httpClient.post(this.URL, cart);
  }

  
}
