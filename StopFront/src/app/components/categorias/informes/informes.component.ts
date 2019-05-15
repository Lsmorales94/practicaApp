import { Component, OnInit } from '@angular/core';
import { Cigarrillos } from 'src/app/models/cigarrillos.model';
import { ToastrService } from 'ngx-toastr';
import { LoginService } from 'src/app/services/login.service';
import { CigarrillosService } from 'src/app/services/cigarrillos.service';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-informes',
  templateUrl: './informes.component.html',
  styleUrls: ['./informes.component.css']
})
export class InformesComponent implements OnInit {
            
  public infoCigarrillo: Array<Cigarrillos>;
  public UsuarioId: number;  
  public CigarrilloInfo: number;
  public mostrarDatos : boolean;
  public formUpdate: FormGroup;

  constructor(private toastr: ToastrService, private loginService: LoginService, private formBuilder: FormBuilder,
                private config: NgbModalConfig, private modalService: NgbModal,
                private cigarrillosService: CigarrillosService, ) {

      this.UsuarioId = this.loginService.getUserId();
      // customize default values of modals used by this component tree
      config.backdrop = 'static';
      config.keyboard = false;
  }

  ngOnInit() {
    this.mostrarDatos = false;
    this.getInfo();
    this.formUpdate = this.formBuilder.group({
      cigarrosDiarios: ['', Validators.required],
      marcaCigarrillo: ['', Validators.required],
      valorCigarrillo: ['', Validators.required],
      tiempoConsumo: ['', Validators.required]
    });
  }

  
  getInfo() {
    this.cigarrillosService.getInfoConsumo(this.UsuarioId).subscribe(
      (success) => {
        this.mostrarDatos = true;
        this.infoCigarrillo = success;
        console.log(this.infoCigarrillo);
      },
      (err) => {
        this.toastr.error('No se cargo la información de Consumo ');
      }
    )
  }
  async updateInfo(cigarrillId:number){
    var cig = <Cigarrillos>this.formUpdate.value;
    let nuevaTarea = <Cigarrillos>await this.cigarrillosService.updateInfo(this.UsuarioId,cigarrillId, cig).toPromise();
    console.log(nuevaTarea);
    if (nuevaTarea.id != null) {
      this.toastr.success('Activida Actualizada ');
      this.getInfo();
    }else{
      this.toastr.error('No se pudo actualizar la actividad')
    }
  }
  //Apertura de modal para registrar nueva Actividad
  open(contentModal) {
    this.modalService.open(contentModal);
  }

}
