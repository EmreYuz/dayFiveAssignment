package com.company.business.concretes;

import com.company.business.abstracts.AuthService;
import com.company.core.abstracts.LoginService;
import com.company.core.concretes.EmailValidator;
import com.company.core.concretes.VerificationManager;
import com.company.dataAccess.abstracts.UserDao;
import com.company.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;


public class AuthManager implements AuthService {


    UserDao userDao;
    LoginService loginService;

    public AuthManager(UserDao userDao, LoginService loginService) {
        this.userDao = userDao;
        this.loginService = loginService;
    }

    @Override
    public void register(User user) {

        if (!EmailValidator.validate(user.getEmail())) {
            System.out.println("Geçerli bir e-posta adresi giriniz.");

            if (checkIfPasswordLengthIsMinSix(user.getPassword())) {

                if (checkIfEmailExists(user.getEmail())) {
                    System.out.println("Girdiğiniz e-posta adresi başka bir kullanıcı tarafından kullanılmaktadır.");

                    if (checkIfNameLengthIsMinTwo(user.getFirstName(), user.getLastName())) {
                        return;
                    }
                }
            }
        }


        VerificationManager verificationManager = new VerificationManager();
        verificationManager.sendVerification(user);


        if (verificationManager.receiveVerification(user)) {
            userDao.add(user);
            System.out.println("Kullanıcı oluşturuldu: " + user.getFirstName() + " " + user.getLastName());
        } else {
            System.out.println("Lütfen e-posta adresinize gönderilen doğrulama linkine tıklayınız.");
        }

    }

    @Override
    public void login(User user) {
        userDao.login(user.getEmail(), user.getPassword());
        System.out.println("Giriş başarılı: " + user.getFirstName() + " " + user.getLastName());
    }

    public boolean checkIfEmailExists(String email) {
        List<User> users = new ArrayList<>();

        for (User user : users) {
            if (user.getEmail() == email) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIfPasswordLengthIsMinSix(String password) {
        if (password.length() < 6) {
            System.out.println("Parolanız en az 6 karakterden oluşmalıdır.");
            return false;
        }
        return true;
    }

    public boolean checkIfNameLengthIsMinTwo(String firstName, String lastName) {
        if (firstName.length() < 2 && lastName.length() < 2) {
            System.out.println("Ad ve soyad en az iki karakterden oluşmalıdır.");
            return false;
        }
        return true;
    }
}
