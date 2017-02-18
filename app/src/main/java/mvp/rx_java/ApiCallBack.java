package mvp.rx_java;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by jrm on 2017/2/12.
 * 实封装现RaJava里的方法
 */

public  abstract  class ApiCallBack <M> extends Subscriber<M>{

    public abstract  void onSucess(M model);
    public abstract  void onFailure(String msg);
    public abstract  void onFinish();

    @Override
    public void onCompleted() {
        onFinish();
    }
    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException){
            HttpException exception = (HttpException) e;
            String message = exception.getMessage();
            int code  = exception.code();
            if (code == 504) {
                message = "网络不给力";
            }
            if (code == 502 || code == 404) {
                message = "服务器异常，请稍后再试";
            }
            onFailure(message);
        }else{
            onFailure(e.getMessage());
        }
        onFinish();
    }

    @Override
    public void onNext(M t) {
        onSucess(t);
    }
}
