package com.example.shopping.childActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.shopping.MainActivity;
import com.example.shopping.R;
import com.example.shopping.adt.Item;
import com.example.shopping.adt.ItemList;
import com.example.shopping.io.Reader;
import com.example.shopping.util.Utility;

public class AddActivity extends AppCompatActivity {
    private Button backBtn;
    private Button addBtn;
    private EditText inputBox;
    private ItemList countList;
    private ListView lv_addItem;
    private AddAdapter adapter;
    private AddAdapter.CheckOnClickListener checkOnClickListener = new AddAdapter.CheckOnClickListener() {
        @Override
        public void myOnClick(int position, View view) {
            Item item = countList.get(position);
            if (!item.isdone())
                if (inputBox.getText().toString().equals(""))
                    inputBox.setText(item.name());
                else
                    inputBox.setText(inputBox.getText()+", "+item.name());
            item.done();
            adapter.notifyDataSetChanged();
        }
    };
    private final String likeFile = "like.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utility.setFullScreen(this);
        Utility.setNavigationBarColor(this, "#007acc");
        setContentView(R.layout.activity_add);
        init();
    }

    private void init() {
        countList = new ItemList();
        Reader.loadListWithOnlyNames(this, likeFile, countList);
        backBtn = findViewById(R.id.btn_back);
        inputBox = findViewById(R.id.et_input);
        addBtn = findViewById(R.id.btn_add);
        lv_addItem = findViewById(R.id.lv_quick_add);
        adapter = new AddAdapter(this, checkOnClickListener);
        adapter.setList(countList);
        lv_addItem.setAdapter(adapter);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AddActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AddActivity.this, MainActivity.class);
                String data = inputBox.getText().toString();
                intent.putExtra("input", data);
                startActivity(intent);
            }
        });
    }
}
