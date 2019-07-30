package Saif.Learning.core.quiz;

import android.util.Log;

import com.google.gson.Gson;
import Saif.Learning.BaseApps;
import Saif.Learning.models.Examination;
import Saif.Learning.models.Hasil;
import Saif.Learning.models.RequestReport;
import Saif.Learning.models.ResponsePackage;
import Saif.Learning.models.ResponseReport;
import Saif.Learning.network.NetworkClient;
import Saif.Learning.network.RequestAPI;
import Saif.Learning.utils.SessionManagement;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

/**
 * Created by Raka Adi Nugroho on 5/31/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public class QuizPresenter {
    private CompositeDisposable mCompositeDisposable;
    private QuizView view;
    private SessionManagement mSessionManagement;
    private HashMap<String, String> user;

    public QuizPresenter(QuizView view) {
        this.view = view;
        mSessionManagement  = new SessionManagement(BaseApps.getAppContext());
        loadToken();
    }

    public void loadExamination(String examId){
        view.showLoading();
        RequestAPI requestAPI   = NetworkClient.getRetrofit().create(RequestAPI.class);
        if (mCompositeDisposable == null)
            mCompositeDisposable = new CompositeDisposable();

        mCompositeDisposable.add(requestAPI.examination(
                user.get(SessionManagement.key_token).toString(),
                examId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        responsePackage -> handleResponse(responsePackage),
                        throwable -> handleError(throwable)
                )
        );
    }

    // Get Available Token
    private void loadToken() {
        if (mSessionManagement != null){
            user = mSessionManagement.getUserDetails();
            Log.d(TAG, "loadToken: "+ user.get(SessionManagement.key_userid).toString());
        }
    }
    private void handleResponse(ResponsePackage responsePackage){
        view.loadExamination(responsePackage);
        view.hideLoading();
    }

    private void handleError(Throwable throwable){
        Log.d(TAG, "handleError: "+throwable.getMessage());
        view.loadExaminationError(throwable.getLocalizedMessage().toString());
        view.hideLoading();
    }

    public void changeQuiz(int position, List<Examination> examination){
        view.changeQuiz(examination.get(position));
    }

    public void submitExamination(String examId, List<Hasil> hasils){
        RequestReport requestReport;
        requestReport   = new RequestReport();
        /* Set Request Report Data */
        requestReport.setExamId(examId);
        requestReport.setUserId(user.get(SessionManagement.key_userkon).toString());
        requestReport.setHasil(hasils);

        view.submitShowLoading();
        RequestAPI requestAPI   = NetworkClient.getRetrofit().create(RequestAPI.class);
        if (mCompositeDisposable == null)
            mCompositeDisposable    = new CompositeDisposable();

        mCompositeDisposable.add(requestAPI.passreport(user.get(
                SessionManagement.key_token).toString(),
                requestReport)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        responseReport -> handleExamSubmit(responseReport),
                        throwable -> handleExamSubmitError(throwable)
                )
        );
    }

    private void handleExamSubmit(ResponseReport report){
        view.submitExamination(report);
        view.submitHideLoading();
    }
    private void handleExamSubmitError(Throwable t){
        view.submitExaminationError(t.getLocalizedMessage().toString());
        view.submitHideLoading();
    }
}
