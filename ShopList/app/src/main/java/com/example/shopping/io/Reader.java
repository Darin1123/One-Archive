package com.example.shopping.io;

import android.app.Activity;
import android.util.Log;
import android.widget.Button;

import com.example.shopping.adt.Item;
import com.example.shopping.adt.ItemList;
import com.example.shopping.childActivities.LikeActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.LinkOption;

public class Reader {
    public static void load(Activity activity, String listFile, String titleFile, Button titleBtn, ItemList list) {
        FileInputStream fis = null;

        try {
            fis = activity.openFileInput(listFile);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] lineData = line.split("01010011");
                Item item = new Item(lineData[0], lineData[1], Boolean.valueOf(lineData[2]));
                list.add(item);
            }

            fis = activity.openFileInput(titleFile);
            InputStreamReader isr1 = new InputStreamReader(fis);
            BufferedReader br1 = new BufferedReader(isr1);

            String title = br1.readLine();
            titleBtn.setText(title);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.i("wd4", "read title failed");
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("wd4", "read title failed");
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void loadOptions(Activity activity, String listFile, boolean[] options) {
        FileInputStream fis = null;

        try {
            fis = activity.openFileInput(listFile);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            int index=0;

            while ((line = br.readLine()) != null) {
                options[index] = Boolean.valueOf(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.i("wd4", "read title failed");
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("wd4", "read title failed");
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Only for list @ MainActivity
     * @param activity
     * @param listFile
     * @param list
     */
    public static void loadList(Activity activity, String listFile, ItemList list) {
        FileInputStream fis = null;

        try {
            fis = activity.openFileInput(listFile);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] lineData = line.split("01010011");
                Item item = new Item(lineData[0], lineData[1]);
                list.add(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.i("wd4", "read title failed");
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("wd4", "read title failed");
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void loadListWithOnlyNames(Activity activity, String listFile, ItemList list) {
        FileInputStream fis = null;

        try {
            fis = activity.openFileInput(listFile);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;

            while ((line = br.readLine()) != null) {
                Item item = new Item(line);
                list.add(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.i("wd4", "read title failed");
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("wd4", "read title failed");
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
