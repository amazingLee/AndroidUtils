package io.github.amazinglee.androidutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.github.amazinglee.androidutil.sys.SystemUtil;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textview);
        mTextView.setText("手机型号:" + SystemUtil.getPhoneModel() +
                ",SDK版本:" + SystemUtil.getSDK_Version() +
                ",系统版本:" + SystemUtil.getSystemVersion());
    }
}
