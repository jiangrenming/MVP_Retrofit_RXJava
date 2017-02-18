package mvp.ui.entities.nomalEntity;

/**
 * Created by jrm on 2017/2/12.
 */

public class Weather {

    private String desc;
    private float tempture;

    public float getTempture() {
        return tempture;
    }

    public void setTempture(float tempture) {
        this.tempture = tempture;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
