package com.example.shopping.io;

import android.app.Activity;
import android.content.Context;

import com.example.shopping.MainActivity;
import com.example.shopping.adt.Item;
import com.example.shopping.adt.ItemList;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Writer {

    public static void saveFiles(Activity activity, String listFile, String titleFile, String title, ItemList list) {
        String data;
        FileOutputStream fos = null;

        // prepare data
        if (list==null) {
            data = "0";
        }
        else {
            data = "";
            for (int i=0; i<list.size(); i++) {
                Item item = list.get(i);
                data += item.name()+"01010011"+item.amount()+"01010011"+item.isdone()+"\n";
            }
        }

        //write data into the list file.
        try {
            fos = activity.openFileOutput(listFile, activity.MODE_PRIVATE);
            fos.write(data.getBytes());
            fos = activity.openFileOutput(titleFile, Context.MODE_PRIVATE);
            fos.write(title.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void saveTitle(Activity activity, String titleFile, String title) {
        FileOutputStream fos = null;

        //write data into the title file.
        try {
            fos = activity.openFileOutput(titleFile, activity.MODE_PRIVATE);
            fos.write(title.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void saveOptionsFiles(Activity activity, String optionFile, boolean[] options) {
        String data = "";
        FileOutputStream fos = null;

        // prepare data
        for (int i=0; i<options.length; i++)
            data += options[i] + "\n";

        //write data into the list file.
        try {
            fos = activity.openFileOutput(optionFile, activity.MODE_PRIVATE);
            fos.write(data.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void saveHistoryFile(Activity activity, String historyFile, ItemList list) {
        String data;
        FileOutputStream fos = null;

        // prepare data
        if (list==null) {
            data = "0";
        }
        else {
            data = "";
            for (int i=0; i<list.size(); i++) {
                Item item = list.get(i);
                data += item.name()+"\n";
            }
        }

        //write data into the list file.
        try {
            fos = activity.openFileOutput(historyFile, activity.MODE_PRIVATE);
            fos.write(data.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void saveLikeFile(Activity activity, String likeFile, ItemList list) {
        String data;
        FileOutputStream fos = null;

        // prepare data
        if (list==null) {
            data = "0";
        }
        else {
            data = "";
            for (int i=0; i<list.size(); i++) {
                Item item = list.get(i);
                data += item.name()+"\n";
            }
        }

        //write data into the list file.
        try {
            fos = activity.openFileOutput(likeFile, activity.MODE_PRIVATE);
            fos.write(data.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
