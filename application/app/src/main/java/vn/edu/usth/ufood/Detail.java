package vn.edu.usth.ufood;

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
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import vn.edu.usth.ufood.recycler.CommentsAdapter;
import vn.edu.usth.ufood.recycler.ItemComment;
import vn.edu.usth.ufood.recycler.ItemPreparation;
import vn.edu.usth.ufood.recycler.ItemShopping;
import vn.edu.usth.ufood.utils.CircleGlide;

import java.util.ArrayList;
import java.util.List;

public class Detail extends BaseActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout;

    private RecyclerView recyclerViewComments;
    private CommentsAdapter mAdapterComments;
    private CoordinatorLayout rootView;

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

        recyclerViewComments = (RecyclerView) findViewById(R.id.recyclerComment);

        mAdapterComments = new CommentsAdapter(generateComments(), this);
        LinearLayoutManager mLayoutManagerComment = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewComments.setLayoutManager(mLayoutManagerComment);
        recyclerViewComments.setItemAnimator(new DefaultItemAnimator());
        recyclerViewComments.setAdapter(mAdapterComments);


        final ImageView imageComment = (ImageView) findViewById(R.id.iv_user);
        Glide.with(this)
                .load(Uri.parse("https://randomuser.me/api/portraits/women/75.jpg"))
                .transform(new CircleGlide())
                .into(imageComment);

        final ImageView image = (ImageView) findViewById(R.id.image);
        Glide.with(this).load(Uri.parse("https://images.pexels.com/photos/140831/pexels-photo-140831.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb")).into(image);

    }

    public static ArrayList<String> getUsername(int position){
        //int position = getIntent().getIntExtra("position", 0);
        ArrayList<String> results = new ArrayList<>();
        StubData.Item item = StubData.StubItems.get(position);

        return results;
    }


    public static ArrayList<String> getDate(int position){
        ArrayList<String> results = new ArrayList<>();
        StubData.Item item = StubData.StubItems.get(position);
        return results;
    }


    public static ArrayList<String> getComments(int position){
        ArrayList<String> results = new ArrayList<>();
        StubData.Item item = StubData.StubItems.get(position);
        return results;
    }


    public static ArrayList<String> getUserphoto(int position){
        ArrayList<String> results = new ArrayList<>();
        StubData.Item item = StubData.StubItems.get(position);
        return results;
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
        String username[] = {"LAURA MAGNAGO"};
        String date[] = {".27-01-2017"};
        String comments[] = {"Made this for a BBQ today and it was amazing. Bought 2 Madiera cakes from Tesco and cut them Into wedges. Poured the coffee over the top. And used 75ml of Ameretti instead of masala in the cream. Will be making again next week for a gathering and probably many more times! :)"};
        String userphoto[] = {"https://randomuser.me/api/portraits/women/20.jpg"};
        String img1[] = {"https://images.pexels.com/photos/8382/pexels-photo.jpg?h=350&auto=compress&cs=tinysrgb"};
        String img2[] = {"https://images.pexels.com/photos/134574/pexels-photo-134574.jpeg?h=350&auto=compress&cs=tinysrgb"};

        //ArrayList<String> username = StubData.getItemComments();

//  List<String> username = new ArrayList<>();
//  username.add("");
//  username.add("");
//  username.add("");
//  username.add("");
//  username.add("");
//  List<String> date = new ArrayList<>();
//  date.add(".27-01-2017");
//  date.add(".28-02-2017");
//  date.add(".29-03-2017");
//  date.add(".30-04-2017");
//  date.add(".30-04-2017");
//  List<String> comments = new ArrayList<>();
//  comments.add("Made this for a BBQ today and it was amazing. Bought 2 Madiera cakes from Tesco and cut them Into wedges. Poured the coffee over the top. And used 75ml of Ameretti instead of masala in the cream. Will be making again next week");
//  comments.add("Made this for a BBQ today and it was amazing. Bought 2 Madiera cakes from Tesco and cut them Into wedges. Poured the coffee over the top. And used 75ml of Ameretti instead of masala in the cream. Will be making again next week");
//  comments.add("Made this for a BBQ today and it was amazing. Bought 2 Madiera cakes from Tesco and cut them Into wedges. Poured the coffee over the top. And used 75ml of Ameretti instead of masala in the cream. Will be making again next week");
//  comments.add("Made this for a BBQ today and it was amazing. Bought 2 Madiera cakes from Tesco and cut them Into wedges. Poured the coffee over the top. And used 75ml of Ameretti instead of masala in the cream. Will be making again next week");
//  List<String> userphoto = new ArrayList<>();
//  userphoto.add("");
//  userphoto.add("");
//  userphoto.add("");
//  userphoto.add("");
//  userphoto.add("");

        for (int i = 0; i < username.length; i++){
            ItemComment comment = new ItemComment();
            comment.setUsername(username[i]);
            comment.setUserphoto(userphoto[i]);
            comment.setDate(date[i]);
            comment.setComments(comments[i]);
            comment.setImg1(img1[i]);
            comment.setImg2(img2[i]);
            itemList.add(comment);
        }
        return itemList;
    }

}

