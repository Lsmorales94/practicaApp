
import { Component, OnInit } from '@angular/core';
import { TareasService } from 'src/app/services/tareas.service';
import { LoginService } from 'src/app/services/login.service';
import { Tareas } from 'src/app/models/tareas.model';
import { ToastrService } from 'ngx-toastr';
import { Menssage } from 'src/app/models/menssage.model';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-actividad',
  templateUrl: './actividad.component.html',
  styleUrls: ['./actividad.component.css'],
  providers: [NgbModalConfig, NgbModal]
})
export class ActividadComponent implements OnInit {
  public menssage: Menssage;
  public tareas: Array<Tareas>;
  UsuarioId: number;
  
  constructor(private tareasService: TareasService, private loginService: LoginService,
    private toastr: ToastrService, config: NgbModalConfig, private modalService: NgbModal, ) {
    this.UsuarioId = this.loginService.getUserId();
    // customize default values of modals used by this component tree
    config.backdrop = 'static';
    config.keyboard = false;
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

  onSaveTarea(tareasForm : NgForm){
      

  }
  async onDeleteTarea(id: number) {
    var menssage = new Menssage();
    menssage = <Menssage>await this.tareasService.onDeleteTareas(this.UsuarioId, id).toPromise();
    this.toastr.info(menssage.text);

  }
  //Apertura de modal para registrar nueva Actividad
  open(content) {
    this.modalService.open(content);
  }

}