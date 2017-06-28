package com.meng.fancyshowcasesample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.meng.fancyshowcase.FancyShowCaseQueue;
import com.meng.fancyshowcase.FancyShowCaseView;
import com.meng.fancyshowcase.FocusShape;

/**
 * Created by mengcuiguang on 17/06/28.
 */

public class QueueActivity extends BaseActivity {


    @BindView(R.id.btn_queue_1)
    Button mButton1;
    @BindView(R.id.btn_queue_2)
    Button mButton2;
    @BindView(R.id.btn_queue_3)
    Button mButton3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);
        ButterKnife.bind(this);

        final FancyShowCaseView fancyShowCaseView1 = new FancyShowCaseView.Builder(this)
                .title("我是小红的提示")
                .focusOn(mButton1)
                .build();

        final FancyShowCaseView fancyShowCaseView2 = new FancyShowCaseView.Builder(this)
                .title("我是小明的提示")
                .focusOn(mButton2)
                .build();

        final FancyShowCaseView fancyShowCaseView3 = new FancyShowCaseView.Builder(this)
                .title("我是小延期吖的提示")
                .focusOn(mButton3)
                .build();

        mButton1.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isFinishing()) {
                    new FancyShowCaseQueue()
                            .add(fancyShowCaseView1)
                            .add(fancyShowCaseView2)
                            .add(fancyShowCaseView3)
                            .show();
                }
            }
        }, 500);
    }

    @OnClick(R.id.btn_queue_2)
    public void focusRectWithBorderColor(View view) {
        new FancyShowCaseView.Builder(this)
                .focusOn(view)
                .title("我是小明的提示")
                .focusShape(FocusShape.ROUNDED_RECTANGLE)
                .roundRectRadius(50)
                .focusBorderSize(5)
                .focusBorderColor(Color.BLUE)
                .titleStyle(0, Gravity.TOP)
                .build()
                .show();
    }
}
