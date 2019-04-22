package com.example.mdecinenotofication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mdecinenotofication.databases.Medecine;

import java.util.ArrayList;
import java.util.List;


public class MedicneAdapter extends RecyclerView.Adapter<MedicneAdapter.TasksViewHolder> {

    private Context mCtx ;
    private List<Medecine> taskList=new ArrayList<>();;

    public MedicneAdapter(Context mCtx,  List<Medecine> taskList) {
        this.mCtx = mCtx;
        this.taskList = taskList;
     }

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.list_row, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {
        Medecine t = taskList.get(position);
        holder.textshowtime.setText(t.getNameOfmedicine());


    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textshowtime, textViewTask, textViewDesc, textViewFinishBy;

        public TasksViewHolder(View itemView) {
            super(itemView);

            textshowtime = itemView.findViewById(R.id.textshowtime);
//            textViewTask = itemView.findViewById(R.id.textViewTask);
//            textViewDesc = itemView.findViewById(R.id.textViewDesc);
//            textViewFinishBy = itemView.findViewById(R.id.textViewFinishBy);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
