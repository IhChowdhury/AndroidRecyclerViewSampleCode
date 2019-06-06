package dev.ibrahim.com.recyclerviewsample;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class MainRecyclerviewAdapter extends RecyclerView.Adapter<MainRecyclerviewAdapter.ViewHolder> {

    //    private List<Item> tempItemList;
    private List<ListItem> listItems;
    private Context context;

    public MainRecyclerviewAdapter(List<ListItem> listItems) {
        this.listItems = listItems;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.vertical_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        final ListItem listItem = listItems.get(i);
        Item item = listItem.getItem();
        if (listItem.getListType().equalsIgnoreCase("ad")) {
            viewHolder.imageView.setVisibility(View.INVISIBLE);
            viewHolder.recyclerView.setVisibility(View.VISIBLE);
            ChildAdapter childAdapter = new ChildAdapter(listItem.getItemList());
            viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            viewHolder.recyclerView.setAdapter(childAdapter);

        } else {
            viewHolder.recyclerView.setVisibility(View.INVISIBLE);
            viewHolder.imageView.setVisibility(View.VISIBLE);
            viewHolder.imageView.setImageResource(item.getImage());
        }


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public RecyclerView recyclerView;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.sample_banner);
            recyclerView = itemView.findViewById(R.id.horizontal_recyclerview);
        }
    }
}
