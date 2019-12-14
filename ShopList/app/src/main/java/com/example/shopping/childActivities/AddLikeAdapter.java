package com.example.shopping.childActivities;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shopping.R;
import com.example.shopping.adt.Item;
import com.example.shopping.adt.ItemList;
import com.example.shopping.util.Utility;

public class AddLikeAdapter extends BaseAdapter {
    ItemList historyList;
    ItemList likeList;
    LayoutInflater inflater;
    DeleteOnClickListener deleteOnClickListener;
    LikeOnClickListener likeOnClickListener;

    public AddLikeAdapter(Context context,
                          DeleteOnClickListener deleteOnClickListener,
                          LikeOnClickListener likeOnClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.deleteOnClickListener = deleteOnClickListener;
        this.likeOnClickListener = likeOnClickListener;
    }

    public void setHistoryList(ItemList itemList) { this.historyList = itemList; }
    public void setLikeList(ItemList itemList) { this.likeList = itemList; }

    @Override
    public int getCount() {
        return historyList.size();
    }

    @Override
    public Object getItem(int position) {
        return historyList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null) {
            convertView = inflater.inflate(R.layout.history_item, null);
            holder = new ViewHolder();

            holder.deleteButton = convertView.findViewById(R.id.btn_delete);
            holder.likeButton = convertView.findViewById(R.id.btn_like_it);
            holder.img = convertView.findViewById(R.id.img_item);
            holder.tv_name = convertView.findViewById(R.id.item_name);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Item item = historyList.get(position);

        holder.tv_name.setText(item.name());
        holder.tv_name.setTextColor(Color.parseColor("#734d26"));
        holder.likeButton.setBackgroundResource(R.drawable.big_heart);
        for (Item like : likeList) {
            if (item.name().equals(like.name()))
                holder.likeButton.setBackgroundResource(R.drawable.big_heart_pink);
        }
        holder.deleteButton.setTag(position);
        holder.deleteButton.setOnClickListener(deleteOnClickListener);
        holder.likeButton.setTag(position);
        holder.likeButton.setOnClickListener(likeOnClickListener);
        Utility.setImgBackground(holder.img, item.category());
        return convertView;
    }

    public static abstract class DeleteOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            deleteOnClick(v, (Integer) v.getTag());
        }

        public abstract void deleteOnClick(View v, int position);

    }

    public static abstract class LikeOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            likeOnClick(v, (Integer) v.getTag());
        }

        public abstract void likeOnClick(View v, int position);
    }

    public class ViewHolder {
        TextView tv_name;
        ImageView img;
        Button deleteButton;
        Button likeButton;
    }
}
