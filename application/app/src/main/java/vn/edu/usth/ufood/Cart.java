package vn.edu.usth.ufood;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.usth.ufood.recycler.CartAdapter;
import vn.edu.usth.ufood.utils.StubData;

public class Cart extends BaseActivity {

    private RecyclerView cartViewItems;
    private CartAdapter mAdapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        setupToolbar(R.id.toolbar, "Cart", R.color.primary, R.color.white_trans, R.drawable.ic_arrow_back_pink);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        // changeStatusBarColor(R.color.primary);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_pink);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        cartViewItems = (RecyclerView) findViewById(R.id.recyclerView);

        mAdapterItems = new CartAdapter(generateCartItems(), this);
        LinearLayoutManager mLayoutManagerComment = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        cartViewItems.setLayoutManager(mLayoutManagerComment);
        cartViewItems.setItemAnimator(new DefaultItemAnimator());
        cartViewItems.setAdapter(mAdapterItems);

        Boolean isEmpty = StubData.StubCart.isEmpty();
        Button btn = findViewById(R.id.textButton);

        if (isEmpty) {
            btn.setText("Nothing here...");
            btn.setEnabled(false);
        }
        else {
            btn.setEnabled(true);
        }
    }

    @Override
    protected void setVars() {

    }

    protected List<StubData.Item> generateCartItems() {
        return StubData.StubCart;
    }

    public int total() {
        int res = 0;

        for (StubData.Item item : StubData.StubCart) {
            res += item.getPrice();
        }

        return res;
    }

    public void checkOut(View view) {
        int bruh = total();
        int bonus = bruh / 100;
        StubData.StubUser.setPoints(StubData.StubUser.getPoints() + bruh);
        StubData.StubCart.clear();
        Toast.makeText(this, "Purchase of " + bruh + " done, got " + bonus + " points", Toast.LENGTH_SHORT).show();
        finish();
    }
}
