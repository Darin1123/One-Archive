package com.example.shopping.childActivities;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.shopping.R;
import com.example.shopping.adt.Item;
import com.example.shopping.adt.ItemList;
import com.example.shopping.util.Utility;

public class AddAdapter extends BaseAdapter {
    private ItemList list;
    private LayoutInflater inflater;
    private CheckOnClickListener checkOnClickListener;

    public AddAdapter(Context context, CheckOnClickListener checkOnClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.checkOnClickListener = checkOnClickListener;
    }

    public void setList(ItemList list) { this.list = list; }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null) {
            convertView = inflater.inflate(R.layout.add_item, null);
            holder = new ViewHolder();

            holder.imgBtn = convertView.findViewById(R.id.btn_add);
            holder.name = convertView.findViewById(R.id.item_name);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Item item = (Item) getItem(position);

        holder.name.setText(item.name());
        Utility.setBtnBackground(holder.imgBtn, item.category());
        holder.imgBtn.setTag(position);
        holder.imgBtn.setOnClickListener(checkOnClickListener);

        if (!item.isdone()) {
            convertView.setBackgroundColor(Color.parseColor("#e6f5ff"));
            holder.name.setTextColor(Color.parseColor("#808080"));
        }
        else {
            convertView.setBackgroundColor(Color.parseColor("#80ccff"));
            holder.name.setTextColor(Color.parseColor("#008ae6"));
        }

        return convertView;
    }

    public static abstract class CheckOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            myOnClick((Integer) v.getTag(), v);
        }

        public abstract void myOnClick(int position, View view);
    }

    public class ViewHolder {
        Button imgBtn;
        TextView name;
    }
}
