import { Component } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  title = 'AngularMaterialGettingStarted';

  isMenuOpen = false;
  contentMargin = 240;
  nombreUsuario = "";
  actividad:boolean;
  perfil:boolean; 

  public showActividadComponent = false;
  public showPerfilComponent = false;
  
  constructor(private loginService: LoginService, private router: Router) { 
    
  }

  task: string[] = [
    '1 semana sin fumar', '2 Semanas sin fumar', '1 Mes sin fumar', '3 Meses sin fumar', ' 6 Meses sin fumar'
  ]
  ngOnInit() {
    this.nombreUsuario = this.loginService.getUserName();
  }
  onToolbarMenuToggle() {
    console.log('On toolbar toggled', this.isMenuOpen);
    this.isMenuOpen = !this.isMenuOpen;

    if (!this.isMenuOpen) {
      this.contentMargin = 70;
    } else {
      this.contentMargin = 240;
    }
  }
  logOut() {
    this.router.navigate(['/login']);
  }

  public navigateComponent(componente)
  {
    this.showActividadComponent = false;
    this.showPerfilComponent = false;
    switch(componente)
    {
        case 'actividad':{this.showActividadComponent = true;break;}
        case 'perfil':{this.showPerfilComponent = true;break;}
    }
  };
}