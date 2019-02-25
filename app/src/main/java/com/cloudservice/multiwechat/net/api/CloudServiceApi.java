package com.cloudservice.multiwechat.net.api;

import com.cloudservice.multiwechat.bean.HttpResult;
import com.cloudservice.multiwechat.net.HttpClientImp;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by fengguang.qiu on 2019/1/24.
 * <p>
 * 云客服相关接口
 *
 * 网络请求使用：
 * 1.{@link com.cloudservice.multiwechat.net.api.CloudServiceApi}定义接口
 * 2.{@link HttpClientImp}实现接口
 * 3.在需要的地方调用 如{@link com.cloudservice.multiwechat.ExampleInstrumentedTest#httpPost()}
 */

public interface CloudServiceApi {

    /**
     * http://gank.io/api/data/福利/1/2
     *
     * @param number number
     * @param page   page
     * @return result
     */
    @GET("data/福利/{number}/{page}")
    Flowable<String> apiTest_Get1(@Path("number") int number, @Path("page") int page);

    /**
     * Test:
     * <p>
     * 百科查询测试接口 (接口不稳定多试几次)
     * <p>
     * http://baike.baidu.com/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=关键字&bk_length=600
     */
    int t_scope = 103;
    String t_format = "json";
    String t_appid = "379020";
    int t_bk_length = 600;

    @GET("api/openapi/BaikeLemmaCardApi")
        //GET请求测试
    Flowable<HttpResult> apiTest_Get2(@Query("scope") int scope,
                                      @Query("format") String format,
                                      @Query("appid") String appid,
                                      @Query("bk_key") String bk_key,
                                      @Query("bk_length") int bk_length);

    /**
     * post请求测试
     *
     * @param scope     scope
     * @param format    format
     * @param appid     appid
     * @param bk_key    bk_key
     * @param bk_length bk_length
     * @return bean
     */
    @FormUrlEncoded
    @POST("api/openapi/BaikeLemmaCardApi")
    //POST请求测试
    Flowable<HttpResult> apiTest_Post(@Field("scope") int scope,
                                      @Field("format") String format,
                                      @Field("appid") String appid,
                                      @Field("bk_key") String bk_key,
                                      @Field("bk_length") int bk_length);

    /**
     * 上传文件测试
     *
     * @param resultFile RequestBody body = RequestBody.create(MediaType.parse("text/*"), file);
     * @param name       name可选参数
     * @return 结果String
     * <p>
     * 表单上传
     * RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
     * MultipartBody.Part image = MultipartBody.Part.createFormData("Avatar", file.getName(), requestFile);
     * RequestBody body = image.body();
     */
    @Multipart
    @POST("file")
    Flowable<String> apiTest_upload(
            @Part("testResult") RequestBody resultFile,
//            @Part("testResult") MultipartBody.Part resultFile,
//            @Part("DeviceID") RequestBody deviceId,
            @Query("name") String name);


    /**
     * 下载文件测试
     *
     * @param url 下载链接
     * @return byte[] bytes = responseBody.bytes();
     */
    @Streaming //Streaming注解，该注解的作用是在下载大文件中使用。添加了该注解后，下载文件不会将所有的下载内容加载到内存
    @GET
    Flowable<ResponseBody> apiTest_downloadFile(@Url String url);

}
