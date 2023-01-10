package vn.edu.usth.ufood;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.SubMenu;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import vn.edu.usth.ufood.utils.CircleGlide;
import vn.edu.usth.ufood.utils.CustomTypefaceSpan;
import vn.edu.usth.ufood.utils.StubData;

public class Main extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar(R.id.toolbar, this.getResources().getString(R.string.app_name), R.color.primary, R.color.white_trans, R.drawable.ic_burger);

        FragmentTransaction ft;
        FragmentHome fragmentHome = new FragmentHome();
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, fragmentHome).commit();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Menu m = navigationView.getMenu();
        for (int i=0; i < m.size(); i++) {
            MenuItem mi = m.getItem(i);
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu != null && subMenu.size() >0 ) {
                for (int j=0; j < subMenu.size(); j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }
            applyFontToMenuItem(mi);
        }

        FloatingActionButton fab = findViewById(R.id.app_bar).findViewById(R.id.app_bar_content).findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            startActivity(new Intent(Main.this, Cart.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        View header = navigationView.getHeaderView(0);
        ImageView imageView = (ImageView) header.findViewById(R.id.imageView);
        Glide.with(this)
                .load(Uri.parse(StubData.StubUser.getAvatarLink()))
                .transform(new CircleGlide())
                .into(imageView);

        TextView name = (TextView) header.findViewById(R.id.nameView);
        name.setText(StubData.StubUser.getFullName().toUpperCase());

        TextView point = (TextView) header.findViewById(R.id.pointView);
        point.setText(StubData.StubUser.getPoints() + " Points");
    }
    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-Semibold.otf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (item.getItemId()) {
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);  // OPEN DRAWER
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void triggerRebirth() {
        Intent intent = new Intent(this, Splash.class);
        intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
        ((Activity) this).finish();

        Runtime.getRuntime().exit(0);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.cart) {
            startActivity(new Intent(Main.this, Cart.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        } else if (id == R.id.history) {
            Toast.makeText(this, "This feature is not available.", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.profile) {
            Toast.makeText(this, "This feature is not available.", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.setting) {
            Toast.makeText(this, "This feature is not available.", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.logout) {
            showDialogOkCancel(R.layout.dialog_text, "", "Are you sure you want to logout?",
            new Runnable() {
                @Override
                public void run() {
                    triggerRebirth();
                }
            }, new Runnable() {
                @Override
                public void run() {

                }
            });
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openCart(View view) {
        Toast.makeText(this, "bruh", Toast.LENGTH_SHORT).show();
    }
}
