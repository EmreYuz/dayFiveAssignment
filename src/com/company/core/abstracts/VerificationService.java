package com.company.core.abstracts;

import com.company.entities.concretes.User;

public interface VerificationService {
    void sendVerification(User user);
    boolean receiveVerification(User user);
}
