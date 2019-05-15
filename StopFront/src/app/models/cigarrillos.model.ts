import { Usuario } from './usuario.model';


export class Cigarrillos{
    id : number;
    marcaCigarrillo : string;
    valorCigarrillo : number;
    cigarrosDiarios : number;
    tiempoConsumo : number;
    fechaInicio : Date;
    fechaFin : Date;
    usuario : Usuario;
}