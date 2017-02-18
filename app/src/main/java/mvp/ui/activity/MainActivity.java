package mvp.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.wight.R;

import butterknife.BindView;
import butterknife.OnClick;
import mvp.ui.base.baseActivity.MVPActivity;
import mvp.ui.entities.baseEntity.BaseModel;
import mvp.ui.entities.nomalEntity.Weather;
import mvp.ui.presenter.WeatherPresenter;
import mvp.ui.view.WeatherView;

/**
 * Created by jrm on 2017/2/12.
 * 实现view的方法并且持有一个presenter引用
 */

public class MainActivity extends MVPActivity<WeatherPresenter> implements WeatherView {

    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.txt)
    TextView txt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @OnClick(R.id.btn)
    public void onBtnClick(View view){
        switch (view.getId()){
            case R.id.btn:
                //接口获取数据
                presenter.loadDataByCityId("101001001");
                break;
        }
    }

    @Override
    public WeatherPresenter createPresenter() {
        return new WeatherPresenter(this);
    }



    private <T> void dataSuccess(BaseModel<T> model) {
        if (model  != null){
            Weather weather = (Weather) model.getData();
            String desc = weather.getDesc();
            txt.setText(desc);
        }
    }

    @Override
    public <T> void getDataSucess(BaseModel<T> model) {
        //接口成功回调
        dataSuccess(model);
    }

    @Override
    public void getDataFaliure(String msg) {
        toastShow(msg);
    }
}
