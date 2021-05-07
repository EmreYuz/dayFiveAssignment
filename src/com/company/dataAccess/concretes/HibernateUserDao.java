package com.company.dataAccess.concretes;

import com.company.dataAccess.abstracts.UserDao;
import com.company.entities.concretes.User;

import java.util.List;

public class HibernateUserDao implements UserDao {

    @Override
    public void add(User user) {
        System.out.println("Kullanıcı veri tabanına kaydedildi: "+user.getFirstName()+" "+user.getLastName());
    }

    @Override
    public void update(User user) {
        System.out.println("Kullanıcı bilgileri veri tabanında güncellendi: "+user.getFirstName()+" "+user.getLastName());
    }

    @Override
    public void delete(User user) {
        System.out.println("Kullanıcı veri tabanından silindi: "+user.getFirstName()+" "+user.getLastName());
    }

    @Override
    public void login(String email, String password) {

    }
}
