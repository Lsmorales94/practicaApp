import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Tareas } from '../models/tareas.model';
import { Menssage } from '../models/menssage.model';

@Injectable({
  providedIn: 'root'
})
export class TareasService {

  
  private headers: HttpHeaders;
  private accessPointUrl: string = 'http://localhost:8080/tareas';
 
  constructor(private http: HttpClient, ) {
    this.headers = new HttpHeaders({ 'Content-Type': 'application/json; charset=utf-8' });
    
   }

  public getAllTareas(UsuarioId) {
    return this.http.get<Array<Tareas>>(this.accessPointUrl + '/usuario/'+UsuarioId+'/listartareas', { headers: this.headers});
  }
  
  public onDeleteTareas(UsuarioId, tareaId){
    return this.http.delete<Menssage>(this.accessPointUrl + '/usuarioId/'+UsuarioId+'/tareaId/'+tareaId, { headers: this.headers});
  }
}
