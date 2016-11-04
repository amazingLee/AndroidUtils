package io.github.amazinglee.androidutil.toast;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import io.github.amazinglee.androidutil.R;
import io.github.amazinglee.androidutil.display.ViewUtil;

public class ToastUtils {

    private static ToastUtils instance = null;
    private static Toast toast;

    private Context mContext;

    public static ToastUtils getInstance(@NonNull Context context) {
        if (instance == null) {
            synchronized (ToastUtils.class) {
                if (instance == null) {
                    instance = new ToastUtils(context);
                    return instance;
                }
            }
        }
        return instance;
    }

    private ToastUtils(Context context) {
        mContext = context;
    }

    /**
     * 显示自定义的toast 默认背景
     *
     * @param msg 通知的消息
     */
    public void showCustomBgToast(String msg) {
        View view = null;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.toast_default, null);
        ViewUtil.scaleContentView((ViewGroup) view.findViewById(R.id.toast_custom_root_layout));
        TextView message = (TextView) view.findViewById(R.id.toast_tv);
        message.setText(msg);

        if (toast == null) {
            toast = new Toast(mContext);
        }
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 200);
        toast.setView(view);
        toast.show();
    }

    /**
     * 显示自定义的toast
     *
     * @param msg       如果toastView为空  必填
     * @param toastView 通知样式
     */
    public void showCustomBgToast(@Nullable String msg, View toastView) {
        View view = null;
        if (toastView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.toast_default, null);
            ViewUtil.scaleContentView((ViewGroup) view.findViewById(R.id.toast_custom_root_layout));
            TextView message = (TextView) view.findViewById(R.id.toast_tv);
            message.setText(msg);
        } else {
            view = toastView;
        }

        if (toast == null) {
            toast = new Toast(mContext);
        }
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 200);
        toast.setView(view);
        toast.show();
    }

    /**
     * 显示自定义通知
     *
     * @param toastView 通知样式
     * @param isShort   通知显示的时间
     */
    public void showCustomBgToast(@NonNull View toastView, boolean isShort) {
        if (toast == null) {
            toast = new Toast(mContext);
        }
        toast.setDuration(isShort ? Toast.LENGTH_SHORT : Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 200);
        toast.setView(toastView);
        toast.show();
    }

    /**
     * 影藏通知
     */
    public  void hideCustomBgToast() {
        if (toast != null) {
            toast.cancel();
        }
    }

    /**
     * 显示短时间通知
     *
     * @param msg 通知内容
     */
    public void showShortToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示长时间通知
     *
     * @param msg 通知内容
     */
    public void showLongToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * 显示短时间通知
     *
     * @param stringId 通知内容
     */
    public void showShortToast(@StringRes int stringId) {
        Toast.makeText(mContext, stringId, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示长时间通知
     *
     * @param strId 通知内容
     */
    public void showLongToast(@StringRes int strId) {
        Toast.makeText(mContext, strId, Toast.LENGTH_LONG).show();
    }
}
