package com.example.arnav.ecellapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class EventCardAdapter extends ArrayAdapter<EventCard> {

    public EventCardAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        ViewHolder holder;

        if (contentView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            contentView = inflater.inflate(R.layout.item_event_card, parent, false);
            holder = new ViewHolder(contentView);
            contentView.setTag(holder);
        } else {
            holder = (ViewHolder) contentView.getTag();
        }

        EventCard eventList = getItem(position);

        holder.name.setText(eventList.name);
        holder.city.setText(eventList.city);
        //Glide.with(getContext()).load(eventList.url).into(holder.image);
        holder.image.setImageDrawable(eventList.img);

        return contentView;
    }

    private static class ViewHolder {
        public TextView name;
        public TextView city;
        public ImageView image;

        public ViewHolder(View view) {
            this.name = view.findViewById(R.id.item_event_card_name);
            this.city = view.findViewById(R.id.item_event_card_city);
            this.image = view.findViewById(R.id.item_event_card_image);
        }
    }

}

