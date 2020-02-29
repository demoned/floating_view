package com.bojun.msgshowview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.bojun.floating.ViewFloat;
import com.bojun.floating.enums.ShowPattern;
import com.bojun.floating.enums.SidePattern;
import com.bojun.floating.interfaces.OnInvokeView;
import com.bojun.floating.interfaces.OnPermissionResult;
import com.bojun.floating.permission.PermissionUtils;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean hasPermission = PermissionUtils.checkPermission(this);
        if (!hasPermission) {
            requestPermission();
        }
    }

    public void onclick(View view) {
        showAppFloat();
    }

    private void showAppFloat() {
        ViewFloat.with(this)
                .setShowPattern(ShowPattern.ALL_TIME)
                .setSidePattern(SidePattern.RESULT_SIDE)
                // 设置浮窗是否可拖拽，默认可拖拽
                .setDragEnable(false)
                // 设置浮窗固定坐标，ps：设置固定坐标，Gravity属性和offset属性将无效
                .setLocation(0, 100)
                // 设置浮窗的对齐方式和坐标偏移量
                .setGravity(Gravity.CENTER_HORIZONTAL, 0, 200)
                // 设置宽高是否充满父布局，直接在xml设置match_parent属性无效
                .setMatchParent(true, false)
                .setLayout(R.layout.float_app, new OnInvokeView() {
                    @Override
                    public void invoke(View view) {
                        TextView msg = view.findViewById(R.id.msg);
                        msg.setText("121312312312kjksdjfksdfsdhfjhdsjfhdsjf");
                        view.findViewById(R.id.msg_view).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ViewFloat.dismissAppFloat();
                            }
                        });
                    }
                }).show();

    }

    /**
     * 主动申请浮窗权限
     */
    private void requestPermission() {
        PermissionUtils.requestPermission(this, new OnPermissionResult() {
            @Override
            public void permissionResult(boolean b) {

            }
        });
    }
}
