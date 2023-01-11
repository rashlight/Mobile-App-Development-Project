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
import android.content.SharedPreferences;
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
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.ufood.api.APIClient;
import vn.edu.usth.ufood.api.APISchema;
import vn.edu.usth.ufood.api.UserTokenResult;
import vn.edu.usth.ufood.utils.StubData;

public class Login extends BaseActivity {

    private View hlSignin;
    private View hlSignup;
    private View hlTos;
    private View loginLayout;
    private View signupLayout;
    private View tosLayout;
    private TextView tosText;
    private TextInputEditText inputUsername;
    private TextInputEditText inputPassword;
    private TextInputEditText inputFirstName;
    private TextInputEditText inputLastName;
    private TextInputEditText inputUsernameSignup;
    private TextInputEditText inputPasswordSignup;
    private View loginButton;
    private View signupButton;
    private View progressLogin;
    private View progressSignup;
    private CheckBox tosCheckBox;
    private AlertDialog.Builder builder;
    private APISchema apiSchema;

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

        apiSchema = APIClient.getRetrofitInstance().create(APISchema.class);

        inputUsername = findViewById(R.id.input_username);
        inputPassword = findViewById(R.id.input_password);
        inputFirstName = findViewById(R.id.input_first_name);
        inputLastName = findViewById(R.id.input_second_name);
        inputUsernameSignup = findViewById(R.id.input_username_signup);
        inputPasswordSignup = findViewById(R.id.input_password_signup);

        loginButton = findViewById(R.id.login_button);
        signupButton = findViewById(R.id.signup_button);

        progressLogin = findViewById(R.id.process_login);
        progressSignup = findViewById(R.id.process_signup);

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
        String username = inputUsername.getText().toString();
        String password = inputPassword.getText().toString();

        loginButton.setVisibility(View.GONE);
        progressLogin.setVisibility(View.VISIBLE);

        Call<UserTokenResult> call = apiSchema.login(username, password);
        call.enqueue(new Callback<UserTokenResult>() {
            @Override
            public void onResponse(Call<UserTokenResult> call, Response<UserTokenResult> response) {
                if (response.code() != 200) {
                    showDialogOK(R.layout.dialog_text, "Login failed", "Username and/or password is correct.", new Runnable() {
                        @Override
                        public void run() {
                            loginButton.setVisibility(View.VISIBLE);
                            progressLogin.setVisibility(View.GONE);
                        }
                    });
                }
                else {
                    SharedPreferences sharedPreferences = getSharedPreferences("UFoodPref", MODE_PRIVATE);
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();

                    assert response.body() != null;
                    myEdit.putString("token", response.body().getToken());
                    myEdit.apply();

                    new Handler().post(() -> {
                        startActivity(new Intent(Login.this, Main.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        finish();
                    });
                }
            }

            @Override
            public void onFailure(Call<UserTokenResult> call, Throwable t) {
                call.cancel();
                showDialogOK(R.layout.dialog_text, "Login failed", "Check your internet connection. If the problems persists, contact the developers.", new Runnable() {
                    @Override
                    public void run() {
                        loginButton.setVisibility(View.VISIBLE);
                        progressLogin.setVisibility(View.GONE);
                    }
                });
            }
        });
    }

    public void trySignup(View view) {
        Toast.makeText(this, "Sign-up successful, please login", Toast.LENGTH_SHORT).show();
        // TODO: Check login input
        slideFromSignupToLogin();
    }

}