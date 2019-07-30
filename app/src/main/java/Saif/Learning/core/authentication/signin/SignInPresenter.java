package Saif.Learning.core.authentication.signin;
import Saif.Learning.models.ResponseAuth;
import Saif.Learning.network.NetworkClient;
import Saif.Learning.network.RequestAPI;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;



public class SignInPresenter{
    private SignInView view;
    private CompositeDisposable mCompositeDisposable;

    public SignInPresenter(SignInView view){
        this.view   = view;
    }

    public void loginProcess(String username, String password){
        view.showLoading("Pleasewait...");
        RequestAPI requestAPI   = NetworkClient.getRetrofit().create(RequestAPI.class);
        if (mCompositeDisposable == null)
            mCompositeDisposable    = new CompositeDisposable();

        mCompositeDisposable.add(requestAPI.login(username, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        responseAuth -> handleResponse(responseAuth),
                        throwable -> handleError(throwable)
                )
        );
    }
    private void handleResponse(ResponseAuth responseAuth){
        view.dataSuccess(responseAuth);
        view.hideLoading();
    }
    private void handleError(Throwable throwable){
        view.dataFailed(throwable.getLocalizedMessage().toString());
        view.hideLoading();
    }
    public void destroyData(){
        if (mCompositeDisposable != null){
            mCompositeDisposable.dispose();
        }
    }
}
