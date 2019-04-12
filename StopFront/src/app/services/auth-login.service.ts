import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthLoginService {

  constructor() { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
   /*  if (this.userService.getLoginState()) {
      return true;
    } else {
      this.router.navigate(['/login'], {
        queryParams: {
          return: state.url
        }
      }); */
      return false;
    }
}
