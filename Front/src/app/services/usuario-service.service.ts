import { Injectable } from '@angular/core';
import { User } from '../models/User';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioServiceService {
 
  readonly rootUrl = 'http://localhost:8080/usuario';
  constructor(private http: HttpClient) { }

  registerUser(user: User) {
    const body: User = {
      username: user.username,
      password: user.password,
      usuarioNombre: user.usuarioNombre,
      usuarioApellido: user.usuarioApellido,
      usuarioEdad: user.usuarioEdad,
      usuarioEmail: user.usuarioEmail,
      usuarioTelefono: user.usuarioTelefono
    }
    return this.http.post(this.rootUrl+'usuario/registrar',body);
  }
    userAuthentication(username, password) {
       return this.http.post<User>(this.rootUrl+'/login/'+username+'/password/'+password, username);
    }

  
}


  