package mvp.ui.presenter;

import mvp.rx_java.ApiCallBack;
import mvp.ui.base.basePresenter.BasePresenter;
import mvp.ui.entities.baseEntity.BaseModel;
import mvp.ui.entities.nomalEntity.Weather;
import mvp.ui.view.WeatherView;

/**
 * Created by jrm on 2017/2/12.
 * P层的实现,持有view层的引用
 * 实现下载天气情况
 */

public class WeatherPresenter extends BasePresenter<WeatherView> {

    public WeatherPresenter(WeatherView view){
        attchView(view);
    }

    //网络请求获取数据
    public void loadDataByCityId(String cityId){
        view.showLoading();
        addSubscription(apiStores.loadDataByCityId(cityId), new ApiCallBack<BaseModel<Weather>>() {
            @Override
            public void onSucess(BaseModel<Weather> model) {
                view.getDataSucess(model);
            }

            @Override
            public void onFailure(String msg) {
                view.getDataFaliure(msg);
            }

            @Override
            public void onFinish() {
                view.hideLoading();
            }
        });
    }
}
