package Saif.Learning.network;

import Saif.Learning.models.RequestReport;
import Saif.Learning.models.ResponseAuth;
import Saif.Learning.models.ResponseCategory;
import Saif.Learning.models.ResponseDetailCategory;
import Saif.Learning.models.ResponseHistory;
import Saif.Learning.models.ResponseLatest;
import Saif.Learning.models.ResponsePackage;
import Saif.Learning.models.ResponsePassedExam;
import Saif.Learning.models.ResponseReport;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Raka Adi Nugroho on 5/11/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public interface RequestAPI {
    @FormUrlEncoded
    @POST("/auth/signin")
    Observable<ResponseAuth> login(@Field("username") String username,
                                   @Field("password") String password);
    @FormUrlEncoded
    @POST("/auth/signup")
    Observable<ResponseAuth> register(@Field("username") String username,
                                      @Field("password") String password,
                                      @Field("fullname") String fullname,
                                      @Field("stage") String level);
    @GET("/category")
    Observable<ResponseCategory> category(@Header("Authorization") String token);
    @GET("/package/latest")
    Observable<ResponseLatest> latestpackage(@Header("Authorization") String token);
    @GET("/category/detail")
    Observable<ResponseDetailCategory> detailcategory(@Header("Authorization") String token,
                                                      @Query("id") String categoryId);
    @GET("/package")
    Observable<ResponsePackage> examination(@Header("Authorization") String token,
                                            @Query("id") String examId);
    @GET("/package/passexam")
    Observable<ResponsePassedExam> passedexam(@Header("Authorization") String token,
                                              @Query("user") String userId,
                                              @Query("exam") String examId);
    @POST("/package/passexam")
    Observable<ResponseReport> passreport(@Header("Authorization") String token,
                                          @Body RequestReport requestReport);

    @GET("/package/history")
    Observable<ResponseHistory> myhistory(@Header("Authorization") String token,
                                          @Query("user") String userKon);

    @FormUrlEncoded
    @POST("/auth/change")
    Observable<ResponseAuth> changepassword(@Header("Authorization") String token,
                                            @Field("username") String username,
                                            @Field("oldpassword") String oldpassword,
                                            @Field("newpassword") String newpassword);
}
