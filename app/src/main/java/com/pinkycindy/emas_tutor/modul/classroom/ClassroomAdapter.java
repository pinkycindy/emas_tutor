package com.pinkycindy.emas_tutor.modul.classroom;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pinkycindy.emas_tutor.R;
import com.pinkycindy.emas_tutor.data.model.ClassroomItem;

import java.util.ArrayList;


/**
 * Created by Pinky Cindy
 */

public class ClassroomAdapter extends RecyclerView.Adapter<ClassroomAdapter.ClassroomViewHolder> {

    private ArrayList<ClassroomItem> data;
    Context context;

    public ClassroomAdapter(ArrayList<ClassroomItem> data, Context context) {
        this.data = data;
        this.context = context;

    }

    @Override
    public ClassroomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_classroom,parent,false);
        return new ClassroomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClassroomViewHolder holder, final int position) {
        holder.tvName.setText(data.get(position).getName());
        holder.tvSpot.setText(data.get(position).getNameSpots());
        holder.tvAddress.setText(data.get(position).getAddress());
        holder.tvDay1.setText(data.get(position).getDayFirst()+","+data.get(position).getHourFirst());
        holder.tvDay2.setText(data.get(position).getDayFirst()+","+data.get(position).getHourSecond());

        //   holder.tvLat.setText((int)data.get(position).getLat());
      //  holder.tvLng.setText((int) data.get(position).getLng());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public ClassroomItem getItem(int position) {

        return data.get(position);
    }


    public class ClassroomViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvSpot, tvAddress, tvDay1, tvDay2;
        private Button btnAbsen;
        public ClassroomViewHolder(View itemview){
            super(itemview);
            tvName = (TextView) itemview.findViewById(R.id.tv_name);
            tvSpot = (TextView) itemview.findViewById(R.id.tv_spot);
            tvAddress = (TextView) itemview.findViewById(R.id.tv_address);
            tvDay1 = (TextView) itemview.findViewById(R.id.tv_day1);
            tvDay2 = (TextView) itemview.findViewById(R.id.tv_day2);
            btnAbsen = (Button) itemview.findViewById(R.id.btnAbsen);
        }
    }
}
