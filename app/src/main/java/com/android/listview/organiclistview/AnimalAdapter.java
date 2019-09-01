package com.android.listview.organiclistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.hideonbush.R;

import java.util.LinkedList;

/**
 * <pre>
 *     author : philip-knight
 *     e-mail : meng.zhang@ihandysoft.com
 *     time   : 2019/08/28
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class AnimalAdapter extends BaseAdapter {
    private LinkedList<Animal> mData;
    private Context mContext;


    AnimalAdapter(LinkedList<Animal> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        ImageView img_icon;
        TextView text_aName;
        TextView text_aSpeak;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_view_test, parent, false);
            holder = new ViewHolder();
            holder.img_icon = convertView.findViewById(R.id.image_header);
            holder.text_aName = convertView.findViewById(R.id.title);
            holder.text_aSpeak = convertView.findViewById(R.id.description);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.img_icon.setBackgroundResource(mData.get(position).getmIcon());
        holder.text_aName.setText(mData.get(position).getmName());
        holder.text_aSpeak.setText(mData.get(position).getmSpeak());
        return convertView;
    }
}
