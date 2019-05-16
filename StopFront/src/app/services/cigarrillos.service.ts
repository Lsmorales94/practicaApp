import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Usuario } from '../models/usuario.model';
import { Cigarrillos } from '../models/cigarrillos.model';
import { Menssage } from '../models/menssage.model';

@Injectable({
  providedIn: 'root'
})
export class CigarrillosService {

  private headers: HttpHeaders;
  private accessPointUrl: string = 'http://localhost:8080/cigarrillos';
  /* static instance:UserRegisterService; */
  private loginState = false;
  constructor(private http: HttpClient, private currentUser: Usuario, private currentCigarrillo: Cigarrillos) {
    /*  UserRegisterService.instance = this; */
    this.headers = new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8' });
  }
  public add(cigarrillo : Cigarrillos, usuarioId) {
    return this.http.post<Cigarrillos>(this.accessPointUrl + '/usuario/'+usuarioId+'/agregarConsumo', cigarrillo, { headers: this.headers });
  } 

  public updateInfo(UsuarioId : number, cigarrilloId : number, cigarrillo: Cigarrillos) {
    return this.http.put<Cigarrillos>(this.accessPointUrl + '/usuarioId/' + UsuarioId + '/cigarrilloId/' + cigarrilloId+ '/actualizarConsumo', cigarrillo, { headers: this.headers });
  }

  public getInfoConsumo(UsuarioId) {
    return this.http.get<Array<Cigarrillos>>(this.accessPointUrl + '/usuario/' + UsuarioId + '/informacionCigarrillo', { headers: this.headers });
  }

  public onDeleteInfo(UsuarioId, cigarrilloId) {
    return this.http.delete<Menssage>(this.accessPointUrl + '/usuarioId/' + UsuarioId + '/cigarrilloId/' + cigarrilloId, { headers: this.headers });
  }


  

}
