import {Injectable} from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {LocalStorage, LocalStorageService} from 'ngx-webstorage';

@Injectable({
  providedIn: 'root'
})

export class AuthGuard implements CanActivate {
  @LocalStorage()
  public key;
  constructor(private storage: LocalStorageService, private router: Router, private toastr: ToastrService) {
  }

  canActivate(route: ActivatedRouteSnapshot): boolean {
    if (this.key == null) {
      this.router.navigateByUrl('');
      this.toastr.warning('Chưa login', '401');
      return false;
    } else {
      return true;
    }
  }
}
