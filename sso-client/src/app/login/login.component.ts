import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { UserService } from '../_services/user.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { ActivatedRoute } from '@angular/router';
import { AppConstants } from '../common/app.constants';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  currentUser: any;
  googleURL = AppConstants.GOOGLE_AUTH_URL;
  facebookURL = AppConstants.FACEBOOK_AUTH_URL;
  githubURL = AppConstants.GITHUB_AUTH_URL;
  linkedinURL = AppConstants.LINKEDIN_AUTH_URL;

  constructor(
    private authService: AuthService,
    private tokenStorage: TokenStorageService,
    private route: ActivatedRoute,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.isLoggedIn = this.tokenStorage.isLoggedIn();
    this.userService.getCurrentUser().subscribe((data) => {
      this.currentUser = data.username;
      console.log(data.username);
    });
  }

  onSubmit(): void {
    this.authService.login(this.form).subscribe((data) => {
      this.tokenStorage.saveToken(data.token);
      this.isLoggedIn = true;
      this.userService.getCurrentUser().subscribe((data) => {
        this.currentUser = data.username;
        console.log(data.username);
      });
    });
  }
}
