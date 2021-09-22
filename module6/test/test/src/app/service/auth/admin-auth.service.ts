import {Injectable} from '@angular/core';

import {ActivatedRouteSnapshot, CanActivate, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {LocalStorage, LocalStorageService} from 'ngx-webstorage';


@Injectable({
  providedIn: 'root'
})
export class AdminAuthService implements CanActivate {
  @LocalStorage()
  public key;
  constructor(private storage: LocalStorageService, private router: Router, private toastr: ToastrService) {
  }

  canActivate(route: ActivatedRouteSnapshot): boolean {
    if (this.key == null) {
      this.router.navigateByUrl('/');
      this.toastr.warning('Chưa login', '401');
      return false;
    } else if (!this.key || !this.isRole()) {
      this.router.navigateByUrl('/');
      this.toastr.error('Bạn không có quyền truy cập vào trang này', '403');
      return false;
    } else {
      return true;
    }
  }

  isRole() {
      return this.key.role === 'ROLE_ADMIN';
  }
}
