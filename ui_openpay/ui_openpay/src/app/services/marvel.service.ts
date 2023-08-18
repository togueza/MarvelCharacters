import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const baseUrl = 'http://localhost:8080/v1/characters';

@Injectable({
  providedIn: 'root'
})
export class MarvelService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get(`${baseUrl}`);
  }

  get(id) {
    return this.http.get(`${baseUrl}/{characterId}`);
  }

  create(data) {
    return this.http.post(baseUrl, data);
  }

  findByCharacter(character) {
    return this.http.get(`${baseUrl}?character=${character}`);
  }
}
