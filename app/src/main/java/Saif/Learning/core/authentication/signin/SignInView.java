package Saif.Learning.core.authentication.signin;

import Saif.Learning.models.ResponseAuth;



public interface SignInView {
    void showLoading(String loadingMessages);
    void hideLoading();
    void dataFailed(String message);
    void dataSuccess(ResponseAuth responseAuth);
}
