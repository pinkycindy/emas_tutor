package com.pinkycindy.emas_tutor.modul.schedule.inDay;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pinkycindy.emas_tutor.R;
import com.pinkycindy.emas_tutor.data.model.ClassroomItem;

import java.util.ArrayList;

/**
 * Created by Pinky Cindy
 */
public class DayScheduleAdapter extends RecyclerView.Adapter<DayScheduleAdapter.DayScheduleViewHolder> {

    private ArrayList<ClassroomItem> classroomItem;
    Context context;

    public DayScheduleAdapter(ArrayList<ClassroomItem> classroomItem, Context context) {
        this.classroomItem = classroomItem;
        this.context = context;
    }

    @NonNull
    @Override
    public DayScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule, parent, false);
        return new DayScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DayScheduleViewHolder holder, int position) {

       // Log.d("class", String.valueOf(classroomItem.get(position).getId()));

        holder.tvClassName.setText(classroomItem.get(position).getName());
        holder.tvSpotName.setText(classroomItem.get(position).getNameSpots());
        holder.tvAdress.setText(classroomItem.get(position).getAddress());
        holder.tvHour.setText(classroomItem.get(position).getHourFirst());
        holder.tvDay.setText(String.valueOf(classroomItem.get(position).getDayFirst()));
    }

    @Override
    public int getItemCount() {
        return classroomItem.size();
    }

//    public ClassroomItem getItem(){
//
//    }

    public class DayScheduleViewHolder extends RecyclerView.ViewHolder{
        private TextView tvClassName, tvSpotName, tvAdress, tvHour, tvDay;
        public DayScheduleViewHolder(View itemView) {
            super(itemView);
            tvClassName = itemView.findViewById(R.id.tv_class_name);
            tvSpotName = itemView.findViewById(R.id.tv_spot_name);
            tvAdress = itemView.findViewById(R.id.tv_address);
            tvHour = itemView.findViewById(R.id.tv_hour);
            tvDay = itemView.findViewById(R.id.tv_day);

        }
    }
}
