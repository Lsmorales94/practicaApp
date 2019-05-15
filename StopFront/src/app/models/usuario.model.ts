import { NumberSymbol } from '@angular/common';
import { Tareas } from './tareas.model';
import { Cigarrillos } from './cigarrillos.model';

export class Usuario{
  id: number;
  usuarioNombre: string;
  usuarioApellido:string;
  usuarioTelefono:string;
  usuarioEmail: string;
  password: string;
  tareas : Tareas;
  cigarrillos : Cigarrillos;
  
}
