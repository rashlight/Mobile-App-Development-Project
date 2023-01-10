package vn.edu.usth.ufood;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;
import java.util.concurrent.Callable;

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
    public void changeStatusBarColor(int id) {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(id));
    }

    public void showDialogEmpty(int id, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogLayout = LayoutInflater.from(this).inflate(id, (ViewGroup) getWindow().getDecorView().getRootView(), false);
        TextView dialogText = dialogLayout.findViewById(R.id.dialog_content);
        dialogText.setText(message);
        builder.setView(dialogLayout);
        builder.show();
    }

    public void showDialogOK(int id, String title, String message, Runnable onOK) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        View dialogLayout = LayoutInflater.from(this).inflate(id, (ViewGroup) getWindow().getDecorView().getRootView(), false);
        TextView dialogText = dialogLayout.findViewById(R.id.dialog_content);
        dialogText.setText(message);
        builder.setView(dialogLayout);

        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                onOK.run();
            }
        });

        builder.show();
    }

    public void showDialogOkCancel(int id, String title, String message, Runnable onOK, Runnable onCancel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        View dialogLayout = LayoutInflater.from(this).inflate(id, (ViewGroup) getWindow().getDecorView().getRootView(), false);
        TextView dialogText = dialogLayout.findViewById(R.id.dialog_content);
        dialogText.setText(message);
        builder.setView(dialogLayout);

        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                onOK.run();
            }
        });

        builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                onCancel.run();
            }
        });

        builder.show();
    }
}
