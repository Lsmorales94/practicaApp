import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { TipoUsuario } from 'src/app/models/tipousuario.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Usuario } from '../../../models/usuario.model';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  public myForm: FormGroup;
  constructor(private formBuilder: FormBuilder, private loginService: LoginService, private usr: Usuario) {
    /* this.getTipoUsuario(); */
  }

  ngOnInit() {
    this.myForm = this.formBuilder.group({
      usuarioNombre: ['', Validators.required],
      usuarioApellido: ['', Validators.required],
      usuarioTelefono: ['', Validators.required],
      usuarioEmail: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }
  async registrarse() {

    let currentUser = <Usuario>this.myForm.value;
    console.log(currentUser);
    let newUser = <Usuario>await this.loginService.add(currentUser).toPromise();
    if (newUser.id != null) {
      alert("Usuario Registrado correctamente");
    }
  }

}
