package com.example.arnav.ecellapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;
import java.util.logging.Handler;

public class ArchiveImageAdapter extends RecyclerView.Adapter<ArchiveImageAdapter.ViewHolder> {

    private final List<Event> events;

    public ArchiveImageAdapter(List<Event> events){
        this.events = events;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.archive_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(events.get(position).event_title);
        holder.imageView.setImageResource(events.get(position).eventImageId);
        holder.title.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder{

        String name,date;
        int image;
        TextView title;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.item_event_card_name);
            imageView = itemView.findViewById(R.id.item_event_card_image);

            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageView.setVisibility(View.VISIBLE);
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setVisibility(View.INVISIBLE);
                        }
                    },1500);
                }
            });*/
        }
    }
}
