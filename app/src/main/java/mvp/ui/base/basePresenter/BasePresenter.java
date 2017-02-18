package mvp.ui.base.basePresenter;

import mvp.retrofit.RequestManager;
import mvp.retrofit.retrofitUrl.ApiStores;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by jrm on 2017/2/12.
 * P层的父抽象类
 * 获取路径类，取消注册；添加监听
 */

public abstract  class BasePresenter<V> {
    public V view ;
    protected ApiStores apiStores;
    private CompositeSubscription subscription;

    //绑定V层的view
    public void attchView(V view){
        this.view = view;
        apiStores = RequestManager.retrofit().create(ApiStores.class);
    }
    //解绑V层的view
    public void onDetchView(){
        this.view = null;
        onUnsubscribe();
    }
    //RxJava取消注册，避免内存泄漏
    public void onUnsubscribe(){
        if (subscription != null && subscription.hasSubscriptions()){
            subscription.unsubscribe();
        }
    }
    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (subscription == null) {
            subscription = new CompositeSubscription();
        }
        subscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }
}
