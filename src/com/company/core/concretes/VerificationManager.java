package com.company.core.concretes;

import com.company.core.abstracts.VerificationService;
import com.company.entities.concretes.User;

public class VerificationManager implements VerificationService {
    @Override
    public void sendVerification(User user) {
        System.out.println("Doğrulama e-postası "+user.getFirstName()+" "+user.getLastName()+" kullanıcısına gönderildi");
    }

    @Override
    public boolean receiveVerification(User user) {
        System.out.println(user.getFirstName()+" "+user.getLastName()+" kullanıcısı doğrulama işlemini gerçekleştirdi.");
        return true;
    }
}
