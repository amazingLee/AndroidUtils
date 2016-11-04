package io.github.amazinglee.androidutil.sys;

import android.os.Build;

/**
 * 项目名称：AndroidUtils
 * 类描述：
 * 创建人：renhao
 * 创建时间：2016/11/4 13:50
 * 修改备注：
 */
public class SystemUtil {

    /**
     * 获取手机的型号
     *
     * @return 手机的型号
     */
    public static String getPhoneModel() {
        return Build.MODEL;
    }

    /**
     * 获取手机的SDK版本
     *
     * @return SDK版本
     */
    public static String getSDK_Version() {
        return Build.VERSION.SDK;
    }

    /**
     * 获取系统的版本
     *
     * @return 系统的版本
     */
    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }
}
