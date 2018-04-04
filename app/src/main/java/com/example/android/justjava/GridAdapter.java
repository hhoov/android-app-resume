package com.example.android.justjava;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private final Context mContext;
    private final String[] mDataset;

    // Constructor
    GridAdapter(Context context, String[] dataset) {
        this.mContext = context;
        this.mDataset = dataset;
    }

    // Return the size of dataset (invoked by the layout manager)
    @Override
    public int getItemCount() { return mDataset.length; }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class ViewHolder extends RecyclerView.ViewHolder {
        // Each data item is just a string in this case
        private final TextView mGridTextView;

        ViewHolder(View v) {
            super(v);
            mGridTextView = v.findViewById(R.id.gridTextView);
        }

        TextView getTextView() { return mGridTextView; }
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public GridAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view
        View v = LayoutInflater.from(mContext).inflate(R.layout.my_text_view, viewGroup, false);

        return new GridAdapter.ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.getTextView().setText(mDataset[position]);

    }

/*
    public View getView(int position, View convertView, ViewGroup parent) {
        //final String data = mDataset[position];

        if (convertView == null) {
            final LayoutInflater layoutInflater= LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.my_text_view, null);

            final TextView mGridTextView = convertView.findViewById(R.id.mGridTextView);

            //mGridTextView.setText(mContext.getString(mDataset[position]));
            final ViewHolder viewHolder = new ViewHolder(mGridTextView);
            convertView.setTag(viewHolder);

        }

        final ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.mGridTextView.setText(mDataset[position]);

        return convertView;

        *//*TextView dummyTextView = new TextView(mContext);
        dummyTextView.setText(String.valueOf(position));
        return dummyTextView;*//*
    }*/








}
