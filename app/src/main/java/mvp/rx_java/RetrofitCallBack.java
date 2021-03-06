package mvp.rx_java;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/2/12.
 */

public abstract  class RetrofitCallBack<M> implements Callback<M> {

    public abstract  void onSucess(M model);
    public abstract  void onFailure(int code,String msg);
    public abstract  void onThrowable(Throwable t);
    public abstract  void onFinish();

    @Override
    public void onResponse(Call<M> call, Response<M> response) {
        if (response.isSuccessful()){
            onSucess(response.body());
        }else {
            onFailure(response.code(),response.errorBody().toString());
        }
        onFinish();
    }

    @Override
    public void onFailure(Call<M> call, Throwable t) {
        onThrowable(t);
        onFinish();

    }
}
