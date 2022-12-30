package vn.edu.usth.ufood.recycler;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.edu.usth.ufood.R;
import vn.edu.usth.ufood.utils.CircleGlide;
import vn.edu.usth.ufood.utils.StubData;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {

    private List<StubData.Item> items;
    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public ImageView img;

        public MyViewHolder(View view) {
            super(view);

            img = (ImageView) view.findViewById(R.id.iv_picture);
            name = (TextView) view.findViewById(R.id.tv_name);
        }

    }


    public CartAdapter(List<StubData.Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public CartAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart_item, parent, false);

        return new CartAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CartAdapter.MyViewHolder holder, int position) {
        StubData.Item itemShopping = items.get(position);
        holder.name.setText(itemShopping.getName());

        Glide.with(context)
                .load(Uri.parse(itemShopping.getImageLink()))
                .transform(new CircleGlide())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}