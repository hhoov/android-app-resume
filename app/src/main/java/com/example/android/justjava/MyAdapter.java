package com.example.android.justjava;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

// Adapter receives the collection (array, list, set, etc.) of MovieData items. The adapter
// should just be responsible for adapting that data to the views in the RecyclerView
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<MovieData> movieData = new ArrayList<>();

    MyAdapter() { }

    // Return the size of dataset (invoked by the layout manager)
    @Override
    public int getItemCount() { return movieData.size(); }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class ViewHolder extends RecyclerView.ViewHolder {
        // Each data item is just a string in this case
        TextView mTextView;
        ImageView mImageView;

        ViewHolder(View v) {
            super(v);
            mImageView = v.findViewById(R.id.posterImageView);
            mTextView = v.findViewById(R.id.listTextView);
        }

        TextView getTextView() { return mTextView; }
        ImageView getImageView() { return mImageView; }
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_text_view, viewGroup, false);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        // Get element from your dataset at this position
        // Replace the contents of the view with that element

        holder.getTextView().setText(movieData.get(position).title);
        // If URL is empty, provide error image
        if (movieData.get(position).poster.isEmpty()) {
            Picasso.get()
                    .load(R.drawable.error)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.error)
                    .into(holder.mImageView);
        } else {
            Picasso
                    .get()
                    .load(movieData.get(position).poster)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.error)
                    .resize(500,0)
                    .centerCrop()
                    .into(holder.mImageView);
        }
    }

    public void setData(List<MovieData> data) {
        movieData.clear();
        movieData = data;
        notifyDataSetChanged();
    }

}