import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/sesion/login/login.component';
import { RegistroComponent } from './components/sesion/registro/registro.component';
import { RecuperarClaveComponent } from './components/sesion/recuperar-clave/recuperar-clave.component';
import { PerfilComponent } from './components/sesion/perfil/perfil.component';
import { EquipoComponent } from './components/sesion/equipo/equipo.component';
import { DiarioComponent } from './components/tratamientos/diario/diario.component';
import { InformesComponent } from './components/tratamientos/informes/informes.component';
import { ActividadesDiaComponent } from './components/tratamientos/actividades-dia/actividades-dia.component';
import { ActividadComponent } from './components/tratamientos/actividad/actividad.component';
import { MedicamentoComponent } from './components/tratamientos/crud/medicamento/medicamento.component';
import {IndexComponent} from './components/index/index.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  {path:'',component : IndexComponent},
  { path: 'login', component: LoginComponent },
  { path: 'registro', component: RegistroComponent },
  { path:  'home' , component: HomeComponent},
  { path: 'resetpass', component: RecuperarClaveComponent },
  { path: 'perfil', component: PerfilComponent },
  { path: 'equipo', component: EquipoComponent },
  { path: 'diario', component: DiarioComponent },
  { path: 'informes', component: InformesComponent },
  { path: 'actividadDia', component: ActividadesDiaComponent },
  { path: 'actividad', component: ActividadComponent },
  { path: 'medicamento', component: MedicamentoComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
