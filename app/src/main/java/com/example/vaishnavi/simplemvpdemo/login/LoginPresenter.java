package com.example.vaishnavi.simplemvpdemo.login;

public class LoginPresenter implements LoginInteractor.OnLoginFinishedListener {
    LoginView loginView;
    LoginInteractor loginInteractor;

    public LoginPresenter(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginInteractor = loginInteractor;
        this.loginView = loginView;
    }

    public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }
        loginInteractor.login(username, password, this);
    }

    @Override
    public void onUsernameError() {
        if (loginView != null) {
            loginView.setUserNameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setUserNameError();
            loginView.hideProgress();
        }

    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToHome();
        }
    }

    public void onDestroy() {
        loginView = null;
    }

}
