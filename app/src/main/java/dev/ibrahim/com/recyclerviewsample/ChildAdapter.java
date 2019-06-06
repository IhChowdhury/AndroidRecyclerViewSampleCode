package dev.ibrahim.com.recyclerviewsample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder>{

    private List<Item> itemList;

    public ChildAdapter(List<Item> itemList){
        this.itemList = itemList;
    }


    @Override
    public ChildViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.horizontal_item,viewGroup,false);
        ChildViewHolder childViewHolder = new ChildViewHolder(view);
        return childViewHolder;
    }

    @Override
    public void onBindViewHolder( ChildViewHolder childViewHolder, int i) {
        final Item item = itemList.get(i);
        childViewHolder.childImage.setImageResource(item.getImage());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder{

        public ImageView childImage;
        public ChildViewHolder( View itemView) {
            super(itemView);
            childImage = itemView.findViewById(R.id.horizontal_sample_image);
        }
    }
}
