package vn.edu.usth.ufood;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

public class Splash extends BaseActivity {

    private View background = null;
    private View splashPanel = null;
    private View loginPanel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        background = findViewById(R.id.background);
        splashPanel = findViewById(R.id.splashPanel);
        loginPanel = findViewById(R.id.loginPanel);
        // setupToolbar(R.id.toolbar, this.getResources().getString(R.string.app_name), R.color.colorPink, R.color.colorWhiteTrans, R.drawable.ic_burger);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        changeStatusBarColor();

        new Handler().postDelayed(() -> {
            changeLoginColor();
            changeSplashVisibility();
            changeLoginVisibility();

        }, 1000);
    }

    @Override
    protected void setVars() {

    }

    public void changeLoginColor() {
        int colorFrom = getResources().getColor(R.color.colorPinkTrans);
        int colorTo = getResources().getColor(R.color.colorWhiteTrue);
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(300); // milliseconds
        colorAnimation.addUpdateListener(animator -> background.setBackgroundColor((int) animator.getAnimatedValue()));
        colorAnimation.start();
    }

    public void changeSplashVisibility() {
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
        fadeOut.setDuration(300);
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                splashPanel.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        AnimationSet splashSet = new AnimationSet(false);
        splashSet.addAnimation(fadeOut);

        splashPanel.startAnimation(splashSet);
    }

    public void changeLoginVisibility() {
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(300);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                loginPanel.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                loginPanel.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        }

        );
        AnimationSet loginSet = new AnimationSet(false);
        loginSet.addAnimation(fadeIn);

        loginPanel.startAnimation(loginSet);
    }

    public void tryLogin(View view) {
        new Handler().post(() -> {
            startActivity(new Intent(Splash.this, Main.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        });
    }
}
