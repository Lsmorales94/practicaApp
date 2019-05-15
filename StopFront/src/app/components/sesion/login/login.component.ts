import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginService } from '../../../services/login.service';
import { Usuario } from '../../../models/usuario.model';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
 
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
}) 
export class LoginComponent implements OnInit {

  
  public myForm:FormGroup;
  constructor(private formBuilder:FormBuilder, private loginService : LoginService,
                private usr:Usuario, private toastr: ToastrService, private router: Router) { }

  ngOnInit() {
    this.myForm = this.formBuilder.group({
      usuarioEmail:['',[Validators.required,Validators.email]],
      password:['',Validators.required]
    });
  }

  async Login()
  {
    let user = <Usuario>await this.loginService.getLogin(this.myForm.value).toPromise();
    
    if(user!=null)
    {
      this.toastr.success('Bienvenido');
      console.log(user);
      this.loginService.setLoginInfo(user);
      this.router.navigate(['/home']);
    }
    else
    {
      this.toastr.error('Usuario o contraseña incorrectos');
    }
  }
  

}
