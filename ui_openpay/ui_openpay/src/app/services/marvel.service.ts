import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const baseUrl = 'http://localhost:8080/api/marvel';

@Injectable({
  providedIn: 'root'
})
export class MarvelService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get(`${baseUrl}/v1/public/characters`);
  }

  get(id) {
    return this.http.get(`${baseUrl}/v1/public/characters/{characterId}`);
  }

  findByTitle(title) {
    return this.http.get(`${baseUrl}?title=${title}`);
  }
}
