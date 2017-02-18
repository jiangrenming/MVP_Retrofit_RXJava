package mvp.retrofit.retrofitUrl;

import mvp.ui.entities.baseEntity.BaseModel;
import mvp.ui.entities.nomalEntity.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by jrm on 2017/2/11.
 * 网络请求所需的接口方法
 */

public interface ApiStores {
    //前缀base路径
    public static final String base_URL ="http://www.baidu.com/";
   //加载天气User/User/App_Get_UserInfo"
    @GET("User/User/App_Get_UserInfo")
    Observable<BaseModel<Weather>> loadDataByCityId(@Path("cityId")String cityId);



}
