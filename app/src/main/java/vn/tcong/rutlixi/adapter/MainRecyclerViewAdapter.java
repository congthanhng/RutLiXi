package vn.tcong.rutlixi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import vn.tcong.rutlixi.R;
import vn.tcong.rutlixi.entity.RedEnvolopEntity;

import static vn.tcong.rutlixi.commons.Constant.*;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MyViewHolder>{
    Context context;
    List<RedEnvolopEntity> listRedEnvolopEntity;

    public MainRecyclerViewAdapter(Context context, List<RedEnvolopEntity> listRedEnvolopEntity) {
        this.context = context;
        this.listRedEnvolopEntity = listRedEnvolopEntity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main,viewGroup,false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MainRecyclerViewAdapter.MyViewHolder viewHolder, final int i) {
        Picasso.with(context).load(listRedEnvolopEntity.get(i).getSrc()).resize(SCREEN_WIDTH / 2,SCREEN_HEIGHT / 2).into(viewHolder.imageView);
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(viewHolder.itemView.getContext(),"year: "+ listRedEnvolopEntity.get(i).getYear(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setRedEnvolops(List<RedEnvolopEntity> listRedEnvolop){
        this.listRedEnvolopEntity = listRedEnvolop;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listRedEnvolopEntity.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
//        TextView textView;
        public MyViewHolder(View itemView){
            super(itemView);
//            textView=(TextView) itemView.findViewById(R.id.src_name);
            imageView = (ImageView) itemView.findViewById(R.id.imageview_item_main);
//            imageView.setOnClickListener(this);
        }


    }
}
