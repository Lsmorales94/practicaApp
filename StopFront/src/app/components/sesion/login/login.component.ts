import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginService } from '../../../services/login.service';
import { Usuario } from '../../../models/usuario.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  
  public myForm:FormGroup;
  constructor(private formBuilder:FormBuilder, 
    private loginService : LoginService,private usr:Usuario,private router: Router) { }

  ngOnInit() {
    this.myForm = this.formBuilder.group({
      usuarioEmail:['',[Validators.required,Validators.email]],
      password:['',Validators.required]
    });
  }

  async Login()
  {
    let user = <Usuario>await this.loginService.getLogin(this.myForm.value).toPromise();
    
    if(user.id!=null)
    {
      this.loginService.setLoginInfo(user);
      this.router.navigate(['/home']);
    }
    else
    {
      alert("usuario o contraseña incorrectos"); 
    }
  }

}
