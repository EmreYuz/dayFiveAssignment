package com.company.core.concretes;

import GoogleAuth.GoogleAuthManager;
import com.company.core.abstracts.LoginService;
import com.company.entities.concretes.User;

public class GoogleLoginManagerAdapter implements LoginService {

    @Override
    public void registerWithGoogleAccount(String googleEmail, String googlePassword) {
        GoogleAuthManager googleAuthManager = new GoogleAuthManager();
        googleAuthManager.registerWithGoogle(googleEmail, googlePassword);
    }

    @Override
    public void loginWithGoogleAccount(String googleEmail, String googlePassword) {
        GoogleAuthManager googleAuthManager = new GoogleAuthManager();
        googleAuthManager.loginWithGoogle(googleEmail, googlePassword);
    }
}
