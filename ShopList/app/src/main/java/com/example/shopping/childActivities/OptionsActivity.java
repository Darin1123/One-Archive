package com.example.shopping.childActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shopping.MainActivity;
import com.example.shopping.R;
import com.example.shopping.io.Reader;
import com.example.shopping.io.Writer;
import com.example.shopping.util.Utility;

import javax.crypto.spec.OAEPParameterSpec;

public class OptionsActivity extends AppCompatActivity {
    private Button backBtn;
    private Button autoSortBtn;
    /**
     * index        item
     * -----------------------
     * 0            autoSort
     */
    private boolean[] options = new boolean[1];
    private final String optionFileName = "options.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utility.setFullScreen(this);
        Utility.setNavigationBarColor(this, "#cca300");
        setContentView(R.layout.activity_options);

        init();

    }

    public void init() {
        Reader.loadOptions(this, optionFileName, options);
        backBtn = findViewById(R.id.btn_back);
        autoSortBtn = findViewById(R.id.btn_auto_sort);
        if (options[0]) {
            autoSortBtn.setText("yes");
        } else {
            autoSortBtn.setText("no");
        }


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(OptionsActivity.this, MainActivity.class);
                intent.putExtra("go", "go");
                startActivity(intent);
            }
        });

        autoSortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (options[0]) {
                    options[0] = false;
                    autoSortBtn.setText("no");
                } else {
                    options[0] = true;
                    autoSortBtn.setText("yes");
                }
                Writer.saveOptionsFiles(OptionsActivity.this, optionFileName, options);
            }
        });
    }
}
