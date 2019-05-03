import { Component, OnInit } from '@angular/core';
import { TareasService } from 'src/app/services/tareas.service';
import { LoginService } from 'src/app/services/login.service';
import { Tareas } from 'src/app/models/tareas.model';
import { ToastrService } from 'ngx-toastr';
import { Menssage } from 'src/app/models/menssage.model';

@Component({
  selector: 'app-actividad',
  templateUrl: './actividad.component.html',
  styleUrls: ['./actividad.component.css']
})
export class ActividadComponent implements OnInit {
  public menssage : Menssage;
  public tareas: Array<Tareas>;
  UsuarioId: number;
  constructor(private tareasService: TareasService, private loginService: LoginService, private toastr: ToastrService, ) {
    this.UsuarioId = this.loginService.getUserId();

  }

  ngOnInit() {
    this.list();
  }
  //Carga la lista de tareas por usuario 
  list() {
    this.tareasService.getAllTareas(this.UsuarioId).subscribe(
      (success) => {
        this.tareas = success;
        console.log(this.tareas);
      },
      (err) => {
        this.toastr.error('No se cargaron las Actividades ');
      }
    )
  }
  async onDeleteTarea(id: number)
   {
      var menssage = new Menssage();
      menssage =  <Menssage>await this.tareasService.onDeleteTareas(this.UsuarioId, id).toPromise();      
        this.toastr.info(menssage.text);
      
   } 
  /*onDeleteTarea(id: number) {
    let info = this.tareasService.onDeleteTareas(this.UsuarioId, id).subscribe(
      (success) => {
        console.log(success);
      },
      (err) => {
        this.toastr.error('No se elimino la Actividad');
      }
    )
  }*/
}
