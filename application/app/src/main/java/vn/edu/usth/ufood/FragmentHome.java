package vn.edu.usth.ufood;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.support.v4.os.IResultReceiver;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.usth.ufood.recycler.ItemRecipe;
import vn.edu.usth.ufood.recycler.RecipeAdapter;
import vn.edu.usth.ufood.recycler.RecyclerTouchListener;
import vn.edu.usth.ufood.utils.StubData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FragmentHome extends Fragment{
    private List<ItemRecipe> itemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecipeAdapter mAdapter;
    private AppCompatActivity appCompatActivity;

    public FragmentHome(){
        setHasOptionsMenu(true);
    }
    public void onCreate(Bundle a){
        super.onCreate(a);
        setHasOptionsMenu(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null, false);

        ((Main) requireActivity()).setupToolbar(
                R.id.toolbar,
                getString(R.string.appbar_welcome) + ", " + getString(R.string.appbar_user),
                R.color.colorPink,
                R.color.colorWhiteTrans,
                R.drawable.ic_burger
        );

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        mAdapter = new RecipeAdapter(setupRecipe(), getActivity());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mLayoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        appCompatActivity = (AppCompatActivity) getActivity();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                startActivity(new Intent(getActivity(), Detail.class));
                    //Detail.navigate(appCompatActivity, view.findViewById(R.id.iv_recipe));
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return view;
    }
  
    private List<ItemRecipe> setupRecipe(){
        itemList = new ArrayList<>();
        ArrayList<String> recipe = StubData.getItemNames(StubData.StubItems);
        ArrayList<String> img = StubData.getItemImageLinks(StubData.StubItems);
        ArrayList<String> time = StubData.getItemDurations(StubData.StubItems);
        ArrayList<String> price = StubData.getItemPrice(StubData.StubItems);
        ArrayList<Float> rating = StubData.getItemRatings(StubData.StubItems);

        for (int i = 0; i < recipe.size(); i++){
            ItemRecipe item = new ItemRecipe();
            item.setRecipe(recipe.get(i));
            item.setTime(time.get(i));
            item.setPrice(price.get(i) + "k VND");
            item.setRating(rating.get(i));
            item.setImg(img.get(i));
            itemList.add(item);
        }
        return itemList;
    }


    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_home, menu);
    }
}
