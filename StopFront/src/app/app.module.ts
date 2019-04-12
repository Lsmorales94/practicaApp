import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistroComponent } from './components/sesion/registro/registro.component';
import { LoginComponent } from './components/sesion/login/login.component';
import { RecuperarClaveComponent } from './components/sesion/recuperar-clave/recuperar-clave.component';
import { PerfilComponent } from './components/sesion/perfil/perfil.component';
import { EquipoComponent } from './components/sesion/equipo/equipo.component';
import { DiarioComponent } from './components/tratamientos/diario/diario.component';
import { InformesComponent } from './components/tratamientos/informes/informes.component';
import { ActividadesDiaComponent } from './components/tratamientos/actividades-dia/actividades-dia.component';
import { ActividadComponent } from './components/tratamientos/actividad/actividad.component';
import { MedicamentoComponent } from './components/tratamientos/crud/medicamento/medicamento.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule,ReactiveFormsModule } from "@angular/forms";


// Material
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { SlidemenuComponent } from './components/master/slidemenu/slidemenu.component';
import { LayoutModule } from '@angular/cdk/layout';
import { IndexComponent } from './components/index/index.component';
import { HomeComponent } from './components/home/home.component';
import { Usuario } from './models/usuario.model';


@NgModule({
  declarations: [
    AppComponent,
    RegistroComponent,
    LoginComponent,
    RecuperarClaveComponent,
    PerfilComponent,
    EquipoComponent,
    DiarioComponent,
    InformesComponent,
    ActividadesDiaComponent,
    ActividadComponent,
    MedicamentoComponent,
    SlidemenuComponent,
    IndexComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    LayoutModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [Usuario],
  bootstrap: [AppComponent]
})
export class AppModule { }
