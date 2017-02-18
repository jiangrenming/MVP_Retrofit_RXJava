package mvp.retrofit.retrofitContants;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jrm on 2017/2/11.
 * 一般api接口请求必须有的四个参数分别是:
 * 1，app key；服务器与前端使用同一个名字来匹配。
   2，时间戳；目的是为了控制这个请求在一个时间范围内有效。例如：两分钟。如果超过了两分钟，还在用这个请求请求服务器那就不会成功。
   3，接口版本号；升级专用。前端app升级后为了兼容后台接口而定制的。
   4，sign（md5加密）；这个加密方式每个人有每个人的做法。我的做法是将所有的请求参数加起来生成一个md5密文然后后台拿到我的请求参数后同样的方法生成一个md5密文然后匹配。
     这些参数应该和服务器一起去协商定义。
 */

public class SignUtils {
    /**
     * 生成默认参数和参数map实例
     */
    public static final String KEY_SIGN = "sign";
    public static final String KEY_PRIVATE = "key";
    public static final String KEY_TIMESTAMP = "timestamp";
    public static final String KEY_VERSION = "version";

    public static String getSignMD5(Map<String, Object> param) {
        Collection<String> keySet = param.keySet();
        List<String> list = new ArrayList<>(keySet);
        //对key键值按字典升序排序
        Collections.sort(list);
        String paramStr = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(KEY_SIGN)) continue;
            paramStr += list.get(i) + "=" + param.get(list.get(i)) + "&";
        }
        if (!TextUtils.isEmpty(paramStr))
            paramStr = paramStr.substring(0, paramStr.length() - 1);
        return MD5Utils.getMD5String(paramStr);
    }

    public static Map<String, Object> getParameters() {
        Map<String, Object> params = new HashMap<>();
        params.put(KEY_PRIVATE, "alsfoxShop_plat");
        params.put(KEY_VERSION,"1.01");
        params.put(KEY_TIMESTAMP, System.currentTimeMillis());
        return params;
    }
}
