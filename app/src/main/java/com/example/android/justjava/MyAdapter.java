package com.example.android.justjava;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] mDataset;
    private Context  mContext;
    private String[] mImageDataset;

    // Constructor
    MyAdapter(Context context, String[] dataset, String[] imageDataset) {
        this.mContext = context;
        this.mDataset = dataset;
        this.mImageDataset = imageDataset;
    }

    // Return the size of dataset (invoked by the layout manager)
    @Override
    public int getItemCount() { return mDataset.length; }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class ViewHolder extends RecyclerView.ViewHolder {
        // Each data item is just a string in this case
        TextView mTextView;
        ImageView mImageView;

        ViewHolder(View v) {
            super(v);
            mImageView = v.findViewById(R.id.img_android);
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
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        /*Picasso
                .get()
                .load(mDataset[position])
                .resize(120,180)
                .into(holder.mImageView);*/

        holder.getTextView().setText(mDataset[position]);
        Picasso
                .get()
                .load(mImageDataset[position])
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .resize(500,0)
                .centerCrop()
                .into(holder.mImageView);//android.get(position).getAndroid_image_url())

    }

}