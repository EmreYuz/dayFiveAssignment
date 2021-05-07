package com.company;

import GoogleAuth.GoogleAuthManager;
import com.company.business.concretes.AuthManager;
import com.company.core.concretes.GoogleLoginManagerAdapter;
import com.company.dataAccess.concretes.HibernateUserDao;
import com.company.entities.concretes.User;

public class Main {

    public static void main(String[] args) {
        AuthManager authManager = new AuthManager(new HibernateUserDao(),new GoogleLoginManagerAdapter());
        User user1 = new User(1,"Ali","Veli","ali@veli.com","123456");
        User user2 = new User(2,"Ahmet","Mehmet","ahmet@mehmet.com","234567");
        User user3 = new User(3,"Fikret","Saffet","fikret@saffet.com","345678");

        authManager.register(user1);

        authManager.login(user1);
        
    }
}
