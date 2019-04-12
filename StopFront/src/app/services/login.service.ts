import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { TipoUsuario } from '../models/tipousuario.model';
import { Observable } from 'rxjs';
import { Usuario } from '../models/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private headers: HttpHeaders;
  private accessPointUrl: string = 'http://localhost:8080/usuario';
  /* static instance:UserRegisterService; */
  private loginState = false;
  constructor(private http: HttpClient, private currentUser: Usuario) {
    /*  UserRegisterService.instance = this; */
    this.headers = new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8' });
  }

  public add(user) {
    return this.http.post(this.accessPointUrl + "/registrar", user, { headers: this.headers });
  }

  public getLogin(usr) {
    return this.http.get(this.accessPointUrl + '/login/email/'+usr.usuarioEmail+"/password/"+usr.password, { headers: this.headers });
  }
  public getTipoUsuario(credentials) {
    return this.http.get(this.accessPointUrl + '/getTipousuario', { headers: this.headers, params: credentials });
  }


  public setLoginInfo(usr) {
    this.currentUser = usr;
    this.loginState = true;
  }

  public getLoginState() {
    return this.loginState;
  }

  public getUserName() {
    return this.currentUser.usuarioNombre + " " + this.currentUser.usuarioApellido;
  }

  public getUserId() {
    return this.currentUser.id;
  }
}