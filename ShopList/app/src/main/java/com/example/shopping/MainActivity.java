package com.example.shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.shopping.adt.ItemList;
import com.example.shopping.adt.Item;
import com.example.shopping.childActivities.AddActivity;
import com.example.shopping.childActivities.LikeActivity;
import com.example.shopping.childActivities.OptionsActivity;
import com.example.shopping.dialog.ChangeTitleDialog;
import com.example.shopping.dialog.CleanDialog;
import com.example.shopping.dialog.EditDialog;
import com.example.shopping.io.Reader;
import com.example.shopping.io.Writer;
import com.example.shopping.util.Utility;

public class MainActivity
        extends
        AppCompatActivity
        implements
        CleanDialog.CleanDialogListener,
        EditDialog.EditDialogListener,
        ChangeTitleDialog.ChangeTitleDialogListener,
        AdapterView.OnItemLongClickListener {

    private ItemList itemList;
    private ItemList historyList;
    private Button cleanBtn;
    private ListView listView;
    private Button addBtn;
    private Button sortBtn;
    private ContentAdapter adapter;
    private Button listTitle;
    private Button optionBtn;
    private Button likeBtn;

    private boolean[] options = new boolean[2];

    private final String listFileName = "list.txt";
    private final String titleFileName = "title";
    private final String optionFileName = "options.txt";
    private final String historyFile = "history.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // customized navigation bar;
        Utility.setFullScreen(this);
        Utility.setNavigationBarColor(this, "#cca300");
        // load layout
        setContentView(R.layout.activity_main);

        //initialize widgets
        init();
        loadOption();
        Log.i("wd4", "loaded options");
        try{
            addItems(getIntent().getStringExtra("input"));
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

    }

    private void init() {
        //数据容器
        historyList = new ItemList();
        adapter = new ContentAdapter(this, deleteListener, doneClickListener);
        itemList = new ItemList();
        listTitle = findViewById(R.id.list_name);
        listTitle = findViewById(R.id.list_name);
        load();
        Reader.loadListWithOnlyNames(this, historyFile, historyList);
        loadOption();

        //组件
        cleanBtn = findViewById(R.id.btn_clean);
        listView = findViewById(R.id.lv_content);
        addBtn = findViewById(R.id.btn_add);
        sortBtn = findViewById(R.id.btn_sort);
        optionBtn = findViewById(R.id.btn_option);
        likeBtn = findViewById(R.id.btn_like);


        //设置组件
        optionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, OptionsActivity.class);
                startActivity(intent);
            }
        });
        listTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChangeTitleDialog();
            }
        });
        cleanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConfirmDialog();
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
        sortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.itemList.sort();
                save();
                adapter.notifyDataSetChanged();
            }
        });
        sortBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                MainActivity.this.itemList.merge();
                save();
                adapter.notifyDataSetChanged();
                return true;
            }
        });
        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, LikeActivity.class);
                startActivity(intent);
            }
        });

        adapter.setList(itemList);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(this);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        openEditDialog(position);
        return true;
    }

    private void openChangeTitleDialog() {
        ChangeTitleDialog changeTitleDialog = new ChangeTitleDialog();
        changeTitleDialog.show(getSupportFragmentManager(), "changetitledialog");
    }

    private void openConfirmDialog() {
        CleanDialog cleanDialog = new CleanDialog();
        cleanDialog.show(getSupportFragmentManager(), "cleandialog");
    }

    private void openEditDialog(int position) {
        EditDialog editDialog = new EditDialog();
        Item item = itemList.get(position);
        editDialog.setOld(item.name(), item.amount());
        editDialog.setPosition(position);
        editDialog.show(getSupportFragmentManager(), "addDialog");
    }

    public void addItems(String input) {
        String[] items = Utility.readInput(input);
        for (int i = 0; i < items.length; i++) {
            if (items[i] != "") {
                Item item = new Item(items[i]);
                itemList.add(item);
                historyList.add(item);
            }
        }
        historyList.merge();
        Writer.saveHistoryFile(this, historyFile, historyList);
        if (options[0])
            itemList.sort();
        adapter.notifyDataSetChanged();
        save();
    }

    @Override
    public void cleanItems() {
        itemList.clear();
        adapter.notifyDataSetChanged();
        save();
    }

    @Override
    public void changeTitle(String input) {
        listTitle.setText(input);
        Writer.saveTitle(this, titleFileName, input);
    }

    @Override
    public void editItems(int position, String newName, String newAmount) {
        Item item = itemList.get(position);
        if (newName.equals("")) {
            itemList.remove(position);
        } else {
            item.setName(newName);
            item.setAmount(newAmount);
        }
        adapter.notifyDataSetChanged();
        save();
    }

    public void load() {
        Reader.load(this, listFileName, titleFileName, listTitle, itemList);
    }

    private void loadOption() { Reader.loadOptions(this, optionFileName, options);}

    public void save() { Writer.saveFiles(this, listFileName, titleFileName, listTitle.getText().toString(), itemList); }

    private ContentAdapter.DeleteClickListener deleteListener = new ContentAdapter.DeleteClickListener() {
        @Override
        public void myOnClick(int position, View view) {
            itemList.remove(position);
            save();
            adapter.notifyDataSetChanged();
        }
    };

    private ContentAdapter.DoneClickListener doneClickListener = new ContentAdapter.DoneClickListener() {
        @Override
        public void myOnClick(int position, View view) {
            Item item = itemList.get(position);
            if (item.isdone()) {
                item.undone();
            } else {
                item.done();
            }
            save();
            adapter.notifyDataSetChanged();
        }
    };


}
