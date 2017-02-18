package mvp.ui.view;


import mvp.ui.base.baseView.BaseView;
import mvp.ui.entities.baseEntity.BaseModel;

/**
 * Created by jrm on 2017/2/12.
 * 继承baseView后拥有其方法
 * 处理业务所需的方法;
 */

public interface WeatherView extends BaseView {
    <T>void  getDataSucess(BaseModel<T> model);
    void getDataFaliure(String msg);
}
