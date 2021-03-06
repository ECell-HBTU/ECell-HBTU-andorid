package com.example.arnav.ecellapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RViewAdapter extends RecyclerView.Adapter<RViewAdapter.EventViewHolder> {
    public static class EventViewHolder extends RecyclerView.ViewHolder{
        CardView CView;
        TextView eventTitle;
        TextView eventDate;
        TextView eventTiming;
        ImageView eventImage;

        EventViewHolder(View itemView){
            super(itemView);                        //what does this constructor do and how are we able to call fvbi on a view object
            CView= itemView.findViewById(R.id.CView);
            eventTitle= itemView.findViewById(R.id.event_title);
            eventDate= itemView.findViewById(R.id.event_date);
            eventTiming= itemView.findViewById(R.id.event_timing);
            eventImage= itemView.findViewById(R.id.event_image);
        }
    }

    private List<Event> events;

    RViewAdapter(List<Event> events){
        this.events=events;
    }

    public int getItemCount(){
        return events.size();
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_card,parent,false);
        EventViewHolder evh=new EventViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.eventTitle.setText(events.get(position).event_title);
        holder.eventDate.setText(events.get(position).event_date);
        holder.eventTiming.setText(events.get(position).event_timing);
        holder.eventImage.setImageResource(events.get(position).eventImageId);

    }
}
