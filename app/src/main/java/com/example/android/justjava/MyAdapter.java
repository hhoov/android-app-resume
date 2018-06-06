package com.example.android.justjava;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.justjava.model.MovieData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

// MyAdapter receives the collection (array, list, set, etc.) of MovieData items. The adapter
// should just be responsible for adapting that provider to the views in the RecyclerView
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements ProgressPresenter.ProgressView{
    private List<MovieData> movieData = new ArrayList<>();

    // Create subject/observable
    private ProgressProvider progressProvider = new ProgressProvider(0);
    // Create observer -- will be instantiated in onBindVH()
    private ProgressPresenter progressPresenter;



    MyAdapter() { }

    // Return the size of dataset (invoked by the layout manager)
    @Override
    public int getItemCount() { return movieData.size(); }


    // Provide a reference to the views for each provider item
    // Complex provider items may need more than one view per item, and
    // you provide access to all the views for a provider item in a view holder
    static class ViewHolder extends RecyclerView.ViewHolder {
        // Each provider item is just a string in this case
        ImageView mImageView;
        TextView mRankTextView;
        TextView mTitleTextView;
        TextView mYearTextView;
        TextView mImdbIdTextView;
        TextView mImdbRatingTextView;
        TextView mImdbVotesTextView;
        TextView mImdbLinkTextView;

        ViewHolder(View v) {
            super(v);
            mImageView = v.findViewById(R.id.posterImageView);
            mRankTextView = v.findViewById(R.id.rankTextView);
            mTitleTextView = v.findViewById(R.id.titleTextView);
            mYearTextView = v.findViewById(R.id.yearTextView);
            mImdbIdTextView = v.findViewById(R.id.imdbIdTextView);
            mImdbRatingTextView = v.findViewById(R.id.imdbRatingTextView);
            mImdbVotesTextView = v.findViewById(R.id.imdbVotesTextView);
            mImdbLinkTextView = v.findViewById(R.id.imdbLinkTextView);

        }

        ImageView getImageView() { return mImageView; }
        TextView getRankTextView() { return mRankTextView; }
        TextView getTitleTextView() { return mTitleTextView; }
        TextView getYearTextView() { return mYearTextView; }
        TextView getImdbIdTextView() { return mImdbIdTextView; }
        TextView getImdbRatingTextView() { return mImdbRatingTextView; }
        TextView getImdbVotesTextView() { return mImdbVotesTextView; }
        TextView getImdbLinkTextView() { return  mImdbLinkTextView; }

    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view
        final TextView itemView = new TextView(viewGroup.getContext());
        itemView.setTag(new ProgressPresenter(progressProvider));

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_text_view, viewGroup, false);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        // Attaching presenter to viewholder to keep track of which presenter should be de-registered
        ((ProgressPresenter) holder.itemView.getTag()).present(movieData.get(position).getImdbId());

        // Get element from your dataset at this position
        // Replace the contents of the view with that element
        holder.getRankTextView().setText(String.valueOf(movieData.get(position).getRank()));
        holder.getTitleTextView().setText(movieData.get(position).getTitle());
        holder.getYearTextView().setText(String.valueOf(movieData.get(position).getYear()));
        holder.getImdbIdTextView().setText(movieData.get(position).getImdbId());
        holder.getImdbRatingTextView().setText(String.valueOf(movieData.get(position).getImdbRating()));
        holder.getImdbVotesTextView().setText(String.valueOf(movieData.get(position).getImdbVotes()));
        holder.getImdbLinkTextView().setText(movieData.get(position).getImdbLink());

        // If URL is empty, provide error image
        if (movieData.get(position).getPoster().isEmpty()) {
            Picasso.get()
                    .load(R.drawable.error)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.error)
                    .into(holder.mImageView);
        } else {
            Picasso
                    .get()
                    .load(movieData.get(position).getPoster())
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

    public boolean returnPoll() {
        // if the holder's id matches provider's
        //if == progressProvider.getMovieID()) { }
        return true;
    }

    @Override
    public void showProgressStatus(int progress) {


    }

    @Override
    public void hideProgressStatus() {

    }

    //@Override
    public void onViewRecycled(ViewHolder holder, ProgressPresenter progressPresenter) {
        super.onViewRecycled(holder);

    }

}