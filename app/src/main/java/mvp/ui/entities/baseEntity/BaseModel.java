package mvp.ui.entities.baseEntity;


/**
 * Created by jrm on 2017/2/12.
 * 返回数据的统一格式
 */
public class BaseModel<M>{
    private int code;
    private String message;
    private M data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public M getData() {
        return data;
    }

    public void setData(M data) {
        this.data = data;
    }
}
