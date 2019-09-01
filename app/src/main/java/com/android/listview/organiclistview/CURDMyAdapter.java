package com.android.listview.organiclistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.hideonbush.R;

import java.util.Date;
import java.util.LinkedList;

/**
 * <pre>
 *     author : philip-knight
 *     e-mail : meng.zhang@ihandysoft.com
 *     time   : 2019/08/30
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class CURDMyAdapter extends BaseAdapter {
    private Context mContext;
    private LinkedList<CRUDData> mData;

    public CURDMyAdapter(){}

    public CURDMyAdapter(LinkedList<CRUDData> mData, Context mContext){
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_view_item_data_crud,parent,false);
            holder = new ViewHolder();
            holder.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
            holder.text_content = (TextView) convertView.findViewById(R.id.text_content);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.img_icon.setImageResource(mData.get(position).getImgId());
        holder.text_content.setText(mData.get(position).getContent());
        return convertView;
    }

    private class ViewHolder{
        ImageView img_icon;
        TextView text_content;
    }

    public void add(CRUDData data){
        if (mData == null){
            mData = new LinkedList<>();
        }
        mData.add(data);
        notifyDataSetChanged();
    }

    public void remove(CRUDData data){
        if (mData != null){
            mData.remove(data);
        }
        notifyDataSetChanged();
    }

    public void removeSpecficPositionItem(int position){
        if (mData != null){
            mData.remove(position);
        }
        notifyDataSetChanged();
    }

    public void clear(CRUDData data){
        if (mData != null){
            mData.clear();
        }
        notifyDataSetChanged();
    }
}
