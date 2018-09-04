package com.example.vaishnavi.simplemvpdemo.login;

public interface LoginView {
    void showProgress();
    void hideProgress();
    void setUserNameError();
    void setPasswordError();
    void navigateToHome();
}
