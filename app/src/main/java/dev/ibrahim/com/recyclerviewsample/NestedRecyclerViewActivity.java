package dev.ibrahim.com.recyclerviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NestedRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mainRecyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_recycler_view);

        mainRecyclerview = findViewById(R.id.main_recyclerview);

        List<ListItem> parentList = new LinkedList<>();

        ListItem listItem = new ListItem();
        listItem.setListType("normal");
        Item item = new Item();
        item.setImage(R.drawable.samplebanner);
        listItem.setItem(item);

        ListItem listItem1 = new ListItem();
        listItem1.setListType("ad");

        List<Item> childItemlList = new LinkedList<>();

        for (int i = 0; i < 8; i++){
            Item childItem = new Item();
            childItem.setImage(R.drawable.sample_image);
            childItemlList.add(childItem);
        }

        listItem1.setItemList(childItemlList);

        parentList.add(listItem);
        parentList.add(listItem1);


        System.out.println("**********"+parentList.size());
        MainRecyclerviewAdapter mainRecyclerviewAdapter = new MainRecyclerviewAdapter(parentList);
//        ChildAdapter childAdapter = new ChildAdapter(itemList);
        mainRecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        mainRecyclerview.setAdapter(mainRecyclerviewAdapter);
    }
}
