package com.company.core.abstracts;

import com.company.entities.concretes.User;

public interface LoginService {
    void registerWithGoogleAccount(String googleEmail, String googlePassword);

    void loginWithGoogleAccount(String googleEmail, String googlePassword);
}
