package com.example.arnav.ecellapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RViewAdapter extends RecyclerView.Adapter<RViewAdapter.EventViewHolder> {

    /* private OnItemClickListener myListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        myListener=listener;
    }*/

    private static EventsActivity current;
    private List<Event> events;

    RViewAdapter(List<Event> events,EventsActivity current){
        this.events=events;
        RViewAdapter.current=current;
    }

    public int getItemCount(){
        return events.size();
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item,parent,false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.eventTitle.setText(events.get(position).event_title);
        holder.eventDate.setText(events.get(position).event_date);
        holder.eventTiming.setText(events.get(position).event_timing);
        holder.eventImage.setImageResource(events.get(position).eventImageId);
        holder.eventImage.setTag(events.get(position).eventImageId);
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder{
        CardView CView;
        TextView eventTitle;
        TextView eventDate;
        TextView eventTiming;
        ImageView eventImage;

        EventViewHolder(View itemView){
            super(itemView);

            eventTitle= itemView.findViewById(R.id.event_title);
            eventDate= itemView.findViewById(R.id.event_date);
            eventTiming= itemView.findViewById(R.id.event_timing);
            eventImage= itemView.findViewById(R.id.event_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("MY_LOG","ON CLICK WORKS!");

                    Intent intent=new Intent(current,EventDetailActivity.class);
                    intent.putExtra("EVENT_IMAGE_ID",(Integer)eventImage.getTag());
                    intent.putExtra("EVENT_TITLE",eventTitle.getText());
                    current.startActivity(intent);

                }
            });
        }
    }
}
