package com.example.shopping.childActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.shopping.R;
import com.example.shopping.adt.Item;
import com.example.shopping.adt.ItemList;
import com.example.shopping.io.Reader;
import com.example.shopping.io.Writer;
import com.example.shopping.util.Utility;

public class AddLikeActivity extends AppCompatActivity {
    private ItemList historyList;
    private ItemList likeList;
    private Button back;
    private Button add;
    private EditText editText;
    ListView listView;
    AddLikeAdapter adapter;
    private final String likeFile = "like.txt";
    private final String historyFile = "history.txt";

    private AddLikeAdapter.DeleteOnClickListener deleteOnClickListener = new AddLikeAdapter.DeleteOnClickListener() {
        @Override
        public void deleteOnClick(View v, int position) {
            historyList.remove(position);
            Writer.saveHistoryFile(AddLikeActivity.this, historyFile, historyList);
            adapter.notifyDataSetChanged();
        }
    };

    private AddLikeAdapter.LikeOnClickListener likeOnClickListener = new AddLikeAdapter.LikeOnClickListener() {
        @Override
        public void likeOnClick(View v, int position) {
            Item item = historyList.get(position);
            boolean isIn = false;
            for (Item like : likeList) {
                if (item.name().equals(like.name())) {
                    isIn=true;
                    break;
                }
            }
            if (isIn)
                likeList.remove(item.name());
            else
                likeList.add(item);
            Writer.saveLikeFile(AddLikeActivity.this, likeFile, likeList);
            adapter.notifyDataSetChanged();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Utility.setFullScreen(this);
        Utility.setNavigationBarColor(this, "#734d26");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_like);
        init();
    }

    private void init() {
        likeList = new ItemList();
        Reader.loadListWithOnlyNames(this, likeFile, likeList);
        historyList = new ItemList();
        Reader.loadListWithOnlyNames(this, historyFile, historyList);
        back = findViewById(R.id.btn_back);
        add = findViewById(R.id.btn_add);
        editText = findViewById(R.id.et_input);
        listView = findViewById(R.id.lv_history);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AddLikeActivity.this, LikeActivity.class);
                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AddLikeActivity.this, LikeActivity.class);
                intent.putExtra("new likes", editText.getText().toString());
                startActivity(intent);
            }
        });

        adapter = new AddLikeAdapter(this, deleteOnClickListener, likeOnClickListener);
        adapter.setHistoryList(historyList);
        adapter.setLikeList(likeList);
        listView.setAdapter(adapter);
    }
}
