package com.s00154277.joanne.sligo_social_mobile_app;

/*
* RecyclerView.Adapter
* RecyclerView.ViewHolder
* */

import android.app.usage.UsageEvents;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsViewHolder> {

    private Context mCtx;
    private List<Events> eventList;

    public EventsAdapter(Context mCtx, List<Events> eventList) {
        this.mCtx = mCtx;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventsAdapter.EventsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_events_layout, null);
        EventsViewHolder holder = new EventsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(EventsViewHolder holder, int position) {
        Events event = eventList.get(position);

        holder.textViewTitle.setText(event.getTitle());
        holder.textViewDesc.setText(event.getShortdesc());

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(event.getImage()));

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    class EventsViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewTitle, textViewDesc;

        public EventsViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDesc = itemView.findViewById(R.id.textViewShortDesc);
        }
    }

}
