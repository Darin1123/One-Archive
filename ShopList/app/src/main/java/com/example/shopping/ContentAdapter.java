package com.example.shopping;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.shopping.adt.Item;
import com.example.shopping.adt.ItemList;
import com.example.shopping.util.Utility;

public class ContentAdapter extends BaseAdapter {

    private ItemList list;
    private LayoutInflater inflater;
    private DeleteClickListener deleteClickListener;
    private DoneClickListener doneClickListener;

    public ContentAdapter(Context context, DeleteClickListener deleteListener, DoneClickListener doneClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.deleteClickListener = deleteListener;
        this.doneClickListener = doneClickListener;
    }

    public void setList(ItemList list) { this.list=list; }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Item getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item, null);
            holder = new ViewHolder();

            holder.item_amount = convertView.findViewById(R.id.tv_amount);
            holder.item_name = convertView.findViewById(R.id.item_name);
            holder.delete = convertView.findViewById(R.id.btn_delete);
            holder.done = convertView.findViewById(R.id.btn_done);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Item item = getItem(position);

        //Button logic
        holder.delete.setTag(position);
        holder.delete.setOnClickListener(deleteClickListener);

        holder.done.setTag(position);
        holder.done.setOnClickListener(doneClickListener);

        //Update
        holder.item_name.setText(item.name());
        if (!item.amount().equals("0"))
            holder.item_amount.setText(item.amount());
        else
            holder.item_amount.setText("");
        if (item.isdone()) {
            convertView.setBackgroundColor(Color.parseColor("#ffdb4d"));
            holder.item_name.setTextColor(Color.parseColor("#cca300"));
        }
        else {
            convertView.setBackgroundColor(Color.parseColor("#fff5cc"));
            holder.item_name.setTextColor(Color.parseColor("#808080"));
        }
        Utility.setBtnBackground(holder.done, item.category());
        this.notifyDataSetChanged();

        return convertView;
    }

    public class ViewHolder {
        TextView item_amount;
        TextView item_name;
        Button delete;
        Button done;
    }

    public static abstract class DoneClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            myOnClick((Integer) v.getTag(), v);
        }

        public abstract void myOnClick(int position, View view);
    }

    public static abstract class DeleteClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            myOnClick((Integer) v.getTag(), v);
        }

        public abstract void myOnClick(int position, View view);
    }
}
