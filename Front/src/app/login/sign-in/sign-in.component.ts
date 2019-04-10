import { Component, OnInit } from '@angular/core';
import { UsuarioServiceService } from '../../services/usuario-service.service';
import { AppRoutingModule } from '../../app-routing.module';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  isLoginError: boolean = false;
  constructor(private userService: UsuarioServiceService, private router:Router ) { }

  ngOnInit() {
  }

  OnSubmit(username, password){
    this.userService.userAuthentication(username, password).subscribe((data : any)=> {      
    this.router.navigate(['/home']);
    console.log(data);
    },    
    (err : HttpErrorResponse)=>{
      this.isLoginError = true;
    });
  }

}
