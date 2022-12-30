package vn.edu.usth.ufood;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class BaseActivity extends AppCompatActivity {
    Toolbar toolbar;
    protected void setVars() {

    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
    public void setupToolbar(int toolbarId, String title, @ColorRes int titleColor, @ColorRes int colorBg, @DrawableRes int burger){
        toolbar = (Toolbar) findViewById(toolbarId);
        toolbar.setBackgroundColor(getResources().getColor(colorBg));
        setSupportActionBar(toolbar);
        TextView pageTitle = (TextView) toolbar.findViewById(R.id.tv_title);
        pageTitle.setText(title);
        pageTitle.setTextColor(getResources().getColor(titleColor));
        Objects.requireNonNull(getSupportActionBar()).setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(burger);
    }
    public void changeStatusBarColor() {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.colorPink));
    }
}
