import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistroComponent } from './components/sesion/registro/registro.component';
import { LoginComponent } from './components/sesion/login/login.component';
import { RecuperarClaveComponent } from './components/sesion/recuperar-clave/recuperar-clave.component';
import { PerfilComponent } from './components/sesion/perfil/perfil.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule,ReactiveFormsModule } from "@angular/forms"; 
import { ToastrModule } from 'ngx-toastr';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';


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
import { LayoutModule } from '@angular/cdk/layout';
import { IndexComponent } from './components/index/index.component';
import { HomeComponent } from './components/home/home.component';
import { Usuario } from './models/usuario.model';
import { InformesComponent } from './components/categorias/informes/informes.component';
import { ActividadComponent } from './components/categorias/actividad/actividad.component';
import { CigarrillosComponent } from './components/categorias/cigarrillos/cigarrillos.component';
import { Cigarrillos } from './models/cigarrillos.model';


@NgModule({
  declarations: [
    AppComponent,
    RegistroComponent,
    LoginComponent,
    RecuperarClaveComponent,
    PerfilComponent,
    InformesComponent,
    ActividadComponent,
    IndexComponent,
    HomeComponent,
    InformesComponent,
    CigarrillosComponent
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
    ReactiveFormsModule,
    NgbModule,    
    ToastrModule.forRoot({
      timeOut: 1500,
      positionClass: 'toast-top-right',
      preventDuplicates: false,
    })
  ],
  providers: [Usuario, Cigarrillos],
  bootstrap: [AppComponent]
})
export class AppModule { }