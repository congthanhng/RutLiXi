package vn.tcong.rutlixi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import vn.tcong.rutlixi.R;
import vn.tcong.rutlixi.entity.RedEnvolop;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MyViewHolder>{
    Context context;
    List<RedEnvolop> listRedEnvolop;

    public MainRecyclerViewAdapter(Context context, List<RedEnvolop> listRedEnvolop) {
        this.context = context;
        this.listRedEnvolop = listRedEnvolop;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main,viewGroup,false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MainRecyclerViewAdapter.MyViewHolder viewHolder, int i) {
        Picasso.with(context).load(listRedEnvolop.get(i).getSrc()).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return listRedEnvolop.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
//        TextView textView;
        public MyViewHolder(View itemView){
            super(itemView);
//            textView=(TextView) itemView.findViewById(R.id.src_name);
            imageView = (ImageView) itemView.findViewById(R.id.imageview_item_main);
        }
    }
}
