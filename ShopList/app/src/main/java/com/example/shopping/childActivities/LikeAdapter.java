package com.example.shopping.childActivities;

import android.content.Context;
import android.util.Log;
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

public class LikeAdapter extends BaseAdapter {
    private ItemList likeList;
    private LayoutInflater inflater;
    private DeleteClickListener deleteClickListener;

    public LikeAdapter(Context context, DeleteClickListener deleteClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.deleteClickListener = deleteClickListener;
    }

    public void setList(ItemList list) { this.likeList = list; }

    @Override
    public int getCount() {
        return likeList.size();
    }

    @Override
    public Object getItem(int position) {
        return likeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.like_item, null);
            holder = new ViewHolder();

            holder.name = convertView.findViewById(R.id.item_name);
            holder.img = convertView.findViewById(R.id.img_item);
            holder.delete = convertView.findViewById(R.id.btn_delete);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Item item = (Item) getItem(position);

        //Button logic
        holder.delete.setTag(position);
        holder.delete.setOnClickListener(deleteClickListener);

        //Update
        holder.name.setText(item.name());
        Log.i("wd4", item.category().toString());
        Utility.setImgBackground(holder.img, item.category());
        this.notifyDataSetChanged();

        return convertView;
    }

    public static abstract class DeleteClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            myOnClick((Integer) v.getTag(), v);
        }

        public abstract void myOnClick(int position, View view);
    }

    public class ViewHolder {
        TextView name;
        Button delete;
        ImageView img;
    }
}
