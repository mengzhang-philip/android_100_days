package com.android.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.hideonbush.R;

import java.util.ArrayList;

/**
 * <pre>
 *     author : philip-knight
 *     e-mail : meng.zhang@ihandysoft.com
 *     time   : 2019/09/03
 *     desc   :
 *     version: 1.0onItemClickListener
 * </pre>
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private ArrayList<String> mData;
    private RecycleViewAdapter.OnItemClickListener onItemClickListener;


    public RecycleViewAdapter(ArrayList<String> data) {
        this.mData = data;
    }

    public void updateData(ArrayList<String> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
//        if (viewType == 1) {
//            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_tall,
//                    parent, false);
//        } else {
//            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_short,
//                    parent, false);
//        }
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_item,
                parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        // 绑定图片

        viewHolder.mLeftImgView.setImageResource(Integer.parseInt(mData.get(position)));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                if (onItemClickListener != null) {
                    int pos = viewHolder.getLayoutPosition();
                    onItemClickListener.onItemClick(viewHolder.itemView, pos);
                }
            }
        });

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(final View v) {
                if (onItemClickListener != null) {
                    int pos = viewHolder.getLayoutPosition();
                    onItemClickListener.onItemLongClick(viewHolder.itemView, pos);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void addNewItem() {
        if (mData == null) {
            mData = new ArrayList<>();
        }
        mData.add(0, Integer.toString(R.mipmap.recommended_hd_20));
        notifyItemInserted(0);
    }

    public void deleteItem() {
        if (mData == null || mData.isEmpty()) {
            return;
        }
        mData.remove(0);
        notifyItemRemoved(0);
    }


    public void setOnItemClickListener(RecycleViewAdapter.OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mLeftImgView, mRightImgView;

        public ViewHolder(View itemView) {
            super(itemView);
            mLeftImgView = (ImageView) itemView.findViewById(R.id.left_img);
//            mRightImgView = itemView.findViewById(R.id.rv_right_img);
//            mLeftImgView = itemView.findViewById(R.id.rv_img);
//            mRightImgView = itemView.findViewById(R.id.right_img);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }
}
