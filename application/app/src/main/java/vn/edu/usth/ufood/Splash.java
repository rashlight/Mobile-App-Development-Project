package vn.edu.usth.ufood;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;

public class Splash extends BaseActivity {

    private View background = null;
    private View splashPanel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        background = findViewById(R.id.background);
        splashPanel = findViewById(R.id.splashPanel);
        // setupToolbar(R.id.toolbar, this.getResources().getString(R.string.app_name), R.color.colorPink, R.color.colorWhiteTrans, R.drawable.ic_burger);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        switchToLoginActivity();
    }

    public void switchToLoginActivity() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(Splash.this, Login.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }, 1000);
    }
}
