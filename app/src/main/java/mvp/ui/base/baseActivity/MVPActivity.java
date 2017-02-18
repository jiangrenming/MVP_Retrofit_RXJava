package mvp.ui.base.baseActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import mvp.ui.base.basePresenter.BasePresenter;


/**
 * Created by jrm on 2017/2/12.
 */

public abstract  class MVPActivity <P extends BasePresenter>extends BaseActivity {
    protected P presenter;
    public abstract  P createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter !=  null){
            presenter.onDetchView();
        }
    }
    public void showLoading() {
        showProgressDialog();
    }
    public void hideLoading() {
        dismissProgressDialog();
    }
}
