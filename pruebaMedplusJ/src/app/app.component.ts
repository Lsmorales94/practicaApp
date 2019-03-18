import { Component, OnInit } from '@angular/core';
import { Usuario } from './service/Usuario';
import { UsuarioServiceService } from './service/usuario-service.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';
  public usuario: Usuario;
  public usuarios: Array<Usuario>;
  public mensaje: string;

  constructor(private usuarioService: UsuarioServiceService){
    this.usuario = new Usuario();
  }

  ngOnInit(){
    this.usuario = new Usuario();

    this.usuario.nombre = "sebastian"
    this.usuario.apellido = "morales"
    this.usuario.telefono = "345"
    this.usuario.correo = "lsm"
    this.usuario.edad = 23

   this.safe();
   //this.list();
    
  } 

  safe(){
    this.usuarioService.safe(this.usuario).subscribe(
      (success) =>{
       // console.log(success);
        this.list();
      }
    )
  }
  list(){
    this.usuarioService.listar().subscribe(
      (success) =>{
        this.usuarios = success;
        console.log(success);
        console.log(this.usuarios);
      },
      (err) =>{

      }
    )

  }
  
 

}
