import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User';
import { ToastrService } from 'ngx-toastr';
import { UsuarioServiceService } from '../../services/usuario-service.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  user : User;
  constructor(private userService: UsuarioServiceService, private toastr: ToastrService ) { }

  ngOnInit() {
    this.resetForm();
  }

  resetForm(form?: NgForm) {
    if (form != null)
      form.reset();
    this.user = {
      usuarioNombre:'',
      usuarioApellido:'',
      usuarioEdad: 0,
      username: '',
      password: '',
      usuarioEmail: '',
      usuarioTelefono: '',
    }
  }

}
