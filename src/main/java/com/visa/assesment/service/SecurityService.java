package com.visa.assesment.service;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}
