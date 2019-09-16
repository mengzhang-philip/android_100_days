package com.android.doublerecycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.hideonbush.R;

/**
 * <pre>
 *     author : philip-knight
 *     e-mail : meng.zhang@ihandysoft.com
 *     time   : 2019/09/04
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private Context context;
    private int i = 0;

    public StudentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycle_view_student, parent, false);
        StudentAdapter.ViewHolder holder = new StudentAdapter.ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_name.setText("学生+" + i);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public void setData(int position) {
        this.i = position;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.student_rv);
        }
    }
}