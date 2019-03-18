import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from './Usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioServiceService {

  private url : string;

  constructor(private http: HttpClient) { 
    this.url = "";
  }

  safe(usuario : Usuario){
    this.url ="http://192.168.0.9:8080/usuario/registrar"
    return this.http.post<Usuario>(this.url,usuario);
  }
 
  listar (){
    this.url = "http://192.168.0.9:8080/usuario/listar"
    return this.http.get<Array<Usuario>>(this.url);
  }
}
