package com.android.doublerecycleview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.hideonbush.R;
import com.android.recycleview.RecycleViewAdapter.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : philip-knight
 *     e-mail : meng.zhang@ihandysoft.com
 *     time   : 2019/09/04
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder> {

    private Context context;
    private OnItemClickListener mOnItemClickListener;
    private List<Boolean> isClicks;

    public ClassAdapter(Context context) {
        this.context = context;

        isClicks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            isClicks.add(false);
            if (i == 0) {
                isClicks.set(0, true);
            }
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_view_class, parent, false);
        ClassAdapter.ViewHolder holder = new ClassAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
//        return isClicks == null ? 0 : isClicks.size();
        return 20;
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.itemView.setTag(holder.tv_class_name);

        if (isClicks.get(position)) {
            holder.tv_class_name.setTextColor(Color.parseColor("#ff0000"));
        } else {
            holder.tv_class_name.setTextColor(Color.parseColor("#000000"));
        }

        holder.tv_class_name.setText("Class" + position);

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i = 0; i < isClicks.size(); i++) {
                        isClicks.set(i, false);
                    }
                    isClicks.set(position, true);
                    notifyDataSetChanged();
                    mOnItemClickListener.onItemClick(holder.itemView, position);
                }
            });
        }
    }

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_class_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_class_name = itemView.findViewById(R.id.class_rv);
        }
    }
}
