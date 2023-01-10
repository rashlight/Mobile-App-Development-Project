package vn.edu.usth.ufood;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends BaseActivity {

    private View hlSignin;
    private View hlSignup;
    private View hlTos;
    private View loginLayout;
    private View signupLayout;
    private View tosLayout;
    private TextView tosText;
    private AlertDialog.Builder builder;

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if (signupLayout.getVisibility() == View.VISIBLE) {
            slideFromSignupToLogin();
        } else {
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginLayout = findViewById(R.id.loginPanel);
        signupLayout = findViewById(R.id.signupPanel);
        tosLayout = LayoutInflater.from(this).inflate(R.layout.dialog_license, (ViewGroup) getWindow().getDecorView().getRootView(), false);

        hlSignup = (View) findViewById(R.id.hl_signup);
        hlSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slideFromLoginToSignup();
            }
        });

        hlSignin = (View) findViewById(R.id.hl_signin);
        hlSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slideFromSignupToLogin();
            }
        });

        hlTos = (View) findViewById(R.id.hl_tos);
        hlTos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayTos();
            }
        });

        builder = new AlertDialog.Builder(this);
        builder.setTitle("The Unlicense");
        builder.setView(tosLayout);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        changeStatusBarColor(R.color.primary);
    }

    private void displayTos() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("The Unlicense");
        tosLayout = LayoutInflater.from(this).inflate(R.layout.dialog_license, (ViewGroup) getWindow().getDecorView().getRootView(), false);
        builder.setView(tosLayout);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();
    }

    public void slideFromLoginToSignup() {
        signupLayout.setVisibility(View.VISIBLE);
        signupLayout.setAlpha(0f);

        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(loginLayout, "alpha",  1f, 0f);
        fadeOut.setDuration(200);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(signupLayout, "alpha", 0f, 1f);
        fadeIn.setDuration(200);

        final AnimatorSet mAnimationSet = new AnimatorSet();

        mAnimationSet.play(fadeIn).after(fadeOut);

        mAnimationSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                loginLayout.setVisibility(View.GONE);
            }
        });
        mAnimationSet.start();
    }

    public void slideFromSignupToLogin() {
        loginLayout.setVisibility(View.VISIBLE);
        loginLayout.setAlpha(0f);

        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(signupLayout, "alpha",  1f, 0f);
        fadeOut.setDuration(200);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(loginLayout, "alpha", 0f, 1f);
        fadeIn.setDuration(200);

        final AnimatorSet mAnimationSet = new AnimatorSet();

        mAnimationSet.play(fadeIn).after(fadeOut);

        mAnimationSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                signupLayout.setVisibility(View.GONE);
            }
        });
        mAnimationSet.start();
    }

    public void tryLogin(View view) {
        new Handler().post(() -> {
            startActivity(new Intent(Login.this, Main.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        });
    }

    public void trySignup(View view) {
        Toast.makeText(this, "Sign-up successful, please login", Toast.LENGTH_SHORT).show();
        // TODO: Check login input
        slideFromSignupToLogin();
    }

}