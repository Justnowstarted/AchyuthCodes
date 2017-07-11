package com.mateoj.multiactivitydrawer.Interfaces;

import com.mateoj.multiactivitydrawer.LoginPojo.LoginResp;
import com.mateoj.multiactivitydrawer.POJO.Example;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

/**
 * Created by pavan on 4/8/16.
 */
public interface GoogleClient {

    @GET
    Call<Example> getTestData(@Url String url);
    //Call<Example> loadMaps();

    @Multipart
    @POST
    Call<ResponseBody> uploadMultipleFiles(@Url String url,
                                           @Part MultipartBody.Part GalleryFile);


    @Multipart
    @POST
    Call<ResponseBody> TestReport(@Url String url,

                                  @Part("name") RequestBody User,
                                  @Part("emergency") RequestBody Emergency,
                                  @Part("type") RequestBody IncidentType,
                                  @Part("message") RequestBody DES,

                                  @Part("lat") RequestBody LAT,
                                  @Part("lng") RequestBody LNG,
                                  @Part MultipartBody.Part GAL);


    @Multipart
    @POST
    Call<ResponseBody> Feedback(@Url String url,

                                @Part("name") RequestBody User,
                                @Part("Feedback") RequestBody DES,
                                @Part("Liked") RequestBody l1,
                                @Part("Helps") RequestBody h1,
                                @Part("Reports") RequestBody r1,
                                @Part("Witness") RequestBody v1);


    @Multipart
    @POST
    Call<ResponseBody> CommunityRating(@Url String url,

                                @Part("name") RequestBody User,
                                @Part("Area") RequestBody ar,
                                @Part("Comment") RequestBody c1,
                                @Part("Patrol") RequestBody m1,
                                @Part("Night_Safety") RequestBody n1,
                                @Part("Basics") RequestBody o1,

                                @Part("Overall") RequestBody l1);

    @Multipart
    @POST
    Call<ResponseBody> onlyText(@Url String url,
                                @Part("name") RequestBody User,
                                @Part("emergency") RequestBody Emergency,
                                @Part("type") RequestBody IncidentType,
                                @Part("message") RequestBody DES,

                                @Part("lat") RequestBody LAT,
                                @Part("lng") RequestBody LNG);



    @Multipart
    @POST
    Call<ResponseBody> WomenReport(@Url String url,
                                @Part("name") RequestBody User,
                                @Part("id") RequestBody Complaint_Id,
                                @Part("type") RequestBody Ar_0,
                                @Part("location") RequestBody LOC,
                                @Part("date") RequestBody DAT,
                                @Part("complaint") RequestBody DES,
                                @Part("connect") RequestBody Ar_1);


    @GET
    Call<LoginResp> Registration(@Url String url
    );



    @GET
    Call<LoginResp> LoginAuth(@Url String url


    );


    @Multipart
    @POST
    Call<ResponseBody> AlertPref(@Url String url,
                                   @Part("name") RequestBody User,
                                   @Part("emergency") RequestBody emer,
                                   @Part("safety") RequestBody saf,
                                   @Part("traffic") RequestBody traf,
                                   @Part("area") RequestBody area);




}
