import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { Cigarrillos } from 'src/app/models/cigarrillos.model';
import { CigarrillosService } from 'src/app/services/cigarrillos.service';
import { LoginService } from 'src/app/services/login.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cigarrillos',
  templateUrl: './cigarrillos.component.html',
  styleUrls: ['./cigarrillos.component.css']
})
export class CigarrillosComponent implements OnInit {


  public CigarrilloInfo: number;
  UsuarioId: number;
  public myForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private cigarrillosService: CigarrillosService,
    private loginService: LoginService, private toastr: ToastrService, private router: Router) {

    this.UsuarioId = this.loginService.getUserId();
  }

  ngOnInit() {
    this.myForm = this.formBuilder.group({
      cigarrosDiarios: ['', Validators.required],
      marcaCigarrillo: ['', Validators.required],
      valorCigarrillo: ['', Validators.required],
      tiempoConsumo: ['', Validators.required]
    });
  }
  async onSaveInfo() {

    var cigarrillo = new Cigarrillos();
    var cig = <Cigarrillos>this.myForm.value;
    let nuevoCig = <Cigarrillos>await this.cigarrillosService.add(cig, this.UsuarioId).toPromise();
    console.log(nuevoCig);
    if (nuevoCig.id != null) {
      this.toastr.success('Información de consumo agregada');
      this.router.navigate(['/home']);
    } else {
      this.toastr.error('No se pudo actualizar la información')
    }
  }

}


