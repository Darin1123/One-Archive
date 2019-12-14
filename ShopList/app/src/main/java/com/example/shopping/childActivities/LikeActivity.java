package com.example.shopping.childActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.shopping.MainActivity;
import com.example.shopping.R;
import com.example.shopping.adt.Item;
import com.example.shopping.adt.ItemList;
import com.example.shopping.io.Reader;
import com.example.shopping.io.Writer;
import com.example.shopping.util.Utility;

public class LikeActivity extends AppCompatActivity {
    private Button backBtn;
    private ListView likeLv;
    private Button addLikeBtn;
    private LikeAdapter adapter;
    private ItemList likeList;
    private final String likeFile = "like.txt";
    private LikeAdapter.DeleteClickListener deleteClickListener = new LikeAdapter.DeleteClickListener() {
        @Override
        public void myOnClick(int position, View view) {
            likeList.remove(position);
            Writer.saveLikeFile(LikeActivity.this, likeFile, likeList);
            adapter.notifyDataSetChanged();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utility.setFullScreen(this);
        Utility.setNavigationBarColor(this, "#d95858");
        setContentView(R.layout.activity_like);

        init();
        try{
            String data = getIntent().getStringExtra("new likes");
            addLikeItems(data);
            Writer.saveLikeFile(LikeActivity.this, likeFile, likeList);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    private void addLikeItems(String input) {
        String[] items = Utility.readInput(input);
        for (int i = 0; i < items.length; i++) {
            if (items[i] != "") {
                Item item = new Item(items[i]);
                likeList.add(item);
            }
        }
        likeList.merge();
        Writer.saveLikeFile(this, likeFile, likeList);
        adapter.notifyDataSetChanged();
    }

    private void init() {
        likeList = new ItemList();
        loadLike();
        backBtn = findViewById(R.id.btn_back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LikeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        addLikeBtn = findViewById(R.id.btn_add_like);
        addLikeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LikeActivity.this, AddLikeActivity.class);
                startActivity(intent);
            }
        });
        likeLv = findViewById(R.id.lv_like);
        adapter = new LikeAdapter(this, deleteClickListener);
        adapter.setList(likeList);
        likeLv.setAdapter(adapter);
    }

    private void loadLike() {
        Reader.loadListWithOnlyNames(this, likeFile, likeList);
        likeList.sort();
    }
}
