package dev.ibrahim.com.recyclerviewsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nestedRecyclerView(View view) {
        Intent intent = new Intent(MainActivity.this,NestedRecyclerViewActivity.class);
        startActivity(intent);
    }
}
