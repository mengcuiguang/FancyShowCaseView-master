package com.meng.fancyshowcasesample;

import android.support.v7.app.AppCompatActivity;

import com.meng.fancyshowcase.FancyShowCaseView;

/**
 * Created by mengcuiguang on 17/06/28.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        if (FancyShowCaseView.isVisible(this)) {
            FancyShowCaseView.hideCurrent(this);
        } else {
            super.onBackPressed();
        }
    }
}
