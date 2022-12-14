package vn.edu.usth.ufood;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import vn.edu.usth.ufood.recycler.CommentsAdapter;
import vn.edu.usth.ufood.recycler.ItemComment;
import vn.edu.usth.ufood.recycler.ItemPreparation;
import vn.edu.usth.ufood.recycler.ItemShopping;
import vn.edu.usth.ufood.utils.CircleGlide;
import vn.edu.usth.ufood.utils.StubData;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Detail extends BaseActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout;

    private RecyclerView recyclerViewComments;
    private CommentsAdapter mAdapterComments;
    private CoordinatorLayout rootView;
    private StubData.Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        rootView = (CoordinatorLayout) findViewById(R.id.rootview);
        setupToolbar(R.id.toolbar, "Bruh moment", android.R.color.white, android.R.color.transparent, R.drawable.ic_arrow_back);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitleEnabled(false);

//        recyclerView = (RecyclerView) findViewById(R.id.recyclerShopping);

//        mAdapter = new ShoppingAdapter(generateShopping(), this);
//        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mAdapter);

//        recyclerViewPreparation = (RecyclerView) findViewById(R.id.recyclerPreparation);

//        mAdapterPreparation = new PreparationAdapter(getBaseContext(), generatePreparation(),this);
//        LinearLayoutManager mLayoutManagerPreparation = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerViewPreparation.setLayoutManager(mLayoutManagerPreparation);
//        recyclerViewPreparation.setItemAnimator(new DefaultItemAnimator());
//        recyclerViewPreparation.setAdapter(mAdapterPreparation);

        int position = getIntent().getIntExtra("position", 0);
        item = StubData.StubItems.get(position);

        final ImageView imageComment = (ImageView) findViewById(R.id.iv_user);
        Glide.with(this)
                .load(Uri.parse(StubData.StubUser.getAvatarLink()))
                .transform(new CircleGlide())
                .into(imageComment);

        final ImageView image = (ImageView) findViewById(R.id.image);
        Glide.with(this).load(Uri.parse(item.getImageLink())).into(image);

        final TextView item_name = findViewById(R.id.tv_recipe_name);
        final RatingBar item_rating = findViewById(R.id.ratingBar);
        final TextView item_price = findViewById(R.id.tv_price);
        final TextView item_duration = findViewById(R.id.tv_time);

        item_name.setText(item.getName().toUpperCase());
        item_rating.setRating(item.getRating());
        item_price.setText(String.valueOf(item.getPrice()));

        long s = item.getPrepTime().toSeconds();
        String time = String.format("%dm %02ds", s / 60, (s % 60));
        item_duration.setText(time);

        recyclerViewComments = (RecyclerView) findViewById(R.id.recyclerComment);

        mAdapterComments = new CommentsAdapter(generateComments(), this);
        LinearLayoutManager mLayoutManagerComment = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewComments.setLayoutManager(mLayoutManagerComment);
        recyclerViewComments.setItemAnimator(new DefaultItemAnimator());
        recyclerViewComments.setAdapter(mAdapterComments);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        Drawable drawable = menu.findItem(R.id.action_search).getIcon();

        drawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawable, ContextCompat.getColor(this,android.R.color.white));
        menu.findItem(R.id.action_search).setIcon(drawable);
        return true;
    }

    public List<ItemComment> generateComments(){
        List<ItemComment> itemList = new ArrayList<>();

        ArrayList<String> username = new ArrayList<>();
        for (StubData.Comment c : item.getComments()) {
            username.add(c.getUser().getFullName());
        }

        ArrayList<String> date = new ArrayList<>();
        for (StubData.Comment c : item.getComments()) {
            String dateToStr = DateFormat.getInstance().format(c.getPostDate());
            date.add(dateToStr);
        }

        ArrayList<String> comments = new ArrayList<>();
        for (StubData.Comment c : item.getComments()) {
            comments.add(c.getContent());
        }

        ArrayList<String> userphoto = new ArrayList<>();
        for (StubData.Comment c : item.getComments()) {
            userphoto.add(c.getUser().getAvatarLink());
        }

        String img1[] = {"https://images.pexels.com/photos/8382/pexels-photo.jpg?h=350&auto=compress&cs=tinysrgb"};
        String img2[] = {"https://images.pexels.com/photos/134574/pexels-photo-134574.jpeg?h=350&auto=compress&cs=tinysrgb"};

        for (int i = 0; i < username.size(); i++){
            ItemComment comment = new ItemComment();
            comment.setUsername(username.get(i));
            comment.setUserphoto(userphoto.get(i));
            comment.setDate(date.get(i));
            comment.setComments(comments.get(i));
            itemList.add(comment);
        }

        return itemList;
    }

    public void addCart(View view) {
        StubData.StubCart.add(item);
        Toast.makeText(this, item.getName() + " added to cart", Toast.LENGTH_LONG).show();
        finish();
    }

    public void shareContent(View view) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, "Enjoy " + item.getName() + " with me in UFood! #UFood #OrderInStyle #TruongAnhHoang");
        startActivity(Intent.createChooser(share, "Share Text"));
    }
}

