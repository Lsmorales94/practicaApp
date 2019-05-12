import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/sesion/login/login.component';
import { RegistroComponent } from './components/sesion/registro/registro.component';
import { RecuperarClaveComponent } from './components/sesion/recuperar-clave/recuperar-clave.component';
import { PerfilComponent } from './components/sesion/perfil/perfil.component';
import { InformesComponent } from './components/categorias/informes/informes.component';
import { ActividadComponent } from './components/categorias/actividad/actividad.component';
import {IndexComponent} from './components/index/index.component';
import { HomeComponent } from './components/home/home.component';
import { CigarrillosComponent } from './components/categorias/cigarrillos/cigarrillos.component';

const routes: Routes = [
  {path:'',component : IndexComponent},
  { path: 'login', component: LoginComponent },
  { path: 'registro', component: RegistroComponent },
  { path:  'home' , component: HomeComponent},
  { path: 'resetpass', component: RecuperarClaveComponent },
  { path: 'perfil', component: PerfilComponent },
  { path: 'informes', component: InformesComponent },
  { path: 'actividad', component: ActividadComponent },
  {  path: 'cigarrillos', component: CigarrillosComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
