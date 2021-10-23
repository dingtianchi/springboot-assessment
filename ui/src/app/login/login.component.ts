import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  username = ''
  password = ''
  invalidLogin = false

  @Input() error: string | null;

  constructor(private router: Router,
    private authService: AuthenticationService) {
    this.error = ''
  }

  ngOnInit() {
  }

  checkLogin() {
    (this.authService.authenticate(this.username, this.password).subscribe(
      data => {
        this.router.navigate(['home'])
        this.invalidLogin = false;
      },
      error => {
        this.invalidLogin = true;
        this.error = error.message;
      }
    )
    );

  }

}
