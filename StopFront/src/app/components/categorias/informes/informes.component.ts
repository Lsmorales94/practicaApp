import { Component, OnInit } from '@angular/core';
import { Cigarrillos } from 'src/app/models/cigarrillos.model';
import { ToastrService } from 'ngx-toastr';
import { LoginService } from 'src/app/services/login.service';
import { CigarrillosService } from 'src/app/services/cigarrillos.service';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Menssage } from 'src/app/models/menssage.model';

import { ChartType } from 'chart.js';
import { MultiDataSet, Label } from 'ng2-charts';

@Component({
  selector: 'app-informes',
  templateUrl: './informes.component.html',
  styleUrls: ['./informes.component.css']
})
export class InformesComponent implements OnInit {
  
  public menssage: Menssage;
  public infoCigarrillo: Array<Cigarrillos>;
  public UsuarioId: number;  
  public CigarrilloInfo: number;
  public mostrarDatos : boolean;
  public formUpdate: FormGroup;
  public dias_sin_fumar:number;
  
  public doughnutChartLabels: Label[] = ['Días de consumo', 'Días sin fumar'];
  public doughnutChartData: number[] = [0,0];
  public doughnutChartType: ChartType = 'doughnut';

  constructor(private toastr: ToastrService, private loginService: LoginService, private formBuilder: FormBuilder,
                config: NgbModalConfig, private modalService: NgbModal,
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
    })
    
  }

    // events donut
    public chartClicked({ event, active }: { event: MouseEvent, active: {}[] }): void {
      console.log(event, active);
    }
  
    public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
      console.log(event, active);
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
    let nuevoCigarrillo = <Cigarrillos>await this.cigarrillosService.updateInfo(this.UsuarioId,cigarrillId, cig).toPromise();
    console.log(nuevoCigarrillo);
   
    if (nuevoCigarrillo.id != null) {      
      this.toastr.success('Información de consumo Actualizada ');
      this.getInfo();    
    }else{    
      this.toastr.error('No se pudo actualizar la información')    
    }
  }
  //Apertura de modal para registrar nueva Actividad
  open(contentModal) {
    this.modalService.open(contentModal);
  }

  async calDias() {
    this.getInfo();
    let numTiempo_fumando: number;
    let dias_consumo:number;

    if (this.UsuarioId != null) {
      this.dias_sin_fumar = await this.cigarrillosService.calDias(this.UsuarioId).toPromise();      
      numTiempo_fumando = this.loginService.getCigarrilloTiempo();
       
    } else {
      this.dias_sin_fumar = 0;   
      numTiempo_fumando = 0; 
    }    
    dias_consumo=numTiempo_fumando * 30;
    this.doughnutChartData = [dias_consumo, this.dias_sin_fumar ]
  }

}
