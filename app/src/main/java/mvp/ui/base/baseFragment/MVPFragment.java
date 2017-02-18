package mvp.ui.base.baseFragment;

import android.os.Bundle;
import android.view.View;


/**
 * Created by jrm on 2017/2/12.
 */

public abstract  class MVPFragment<P extends BasePresenter> extends BaseFragment {
    protected P mvpPresenter;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpPresenter = createPresenter();
    }
    protected abstract P createPresenter();
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mvpPresenter != null) {
            mvpPresenter.onDetchView();
        }
    }
}
