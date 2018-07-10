package com.example.android.justjava;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.justjava.model.MovieSummaryData;
import com.example.android.justjava.provider.ProgressProvider;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

// MovieAdapter receives the collection (array, list, set, etc.) of MovieSummaryData items. The adapter
// should just be responsible for adapting that provider to the views in the RecyclerView
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<MovieSummaryData> movieSummaryData = new ArrayList<>();
    private ProgressProvider progressProvider = new ProgressProvider();

    MovieAdapter() {  }

    // Return the size of dataset (invoked by the layout manager)
    @Override
    public int getItemCount() { return movieSummaryData.size(); }

    // Provide a reference to the views for each provider item
    // Complex provider items may need more than one view per item, and
    // you provide access to all the views for a provider item in a view holder
    static class ViewHolder extends RecyclerView.ViewHolder  implements MovieSummaryPresenter.MovieSummaryView {
        // Each provider item is just a string in this case
        ImageView imageView;
        TextView rankTextView;
        TextView titleTextView;
        TextView yearTextView;
        TextView imdbIdTextView;
        TextView imdbRatingTextView;
        TextView imdbVotesTextView;
        TextView imdbLinkTextView;
        ProgressBar progressItem;
        TextView progressPercentage;
        MovieSummaryPresenter movieSummaryPresenter;

        ViewHolder(View v) {

            super(v);
            imageView = v.findViewById(R.id.posterImageView);
            rankTextView = v.findViewById(R.id.rankTextView);
            titleTextView = v.findViewById(R.id.titleTextView);
            yearTextView = v.findViewById(R.id.yearTextView);
            imdbIdTextView = v.findViewById(R.id.imdbIdTextView);
            imdbRatingTextView = v.findViewById(R.id.imdbRatingTextView);
            imdbVotesTextView = v.findViewById(R.id.imdbVotesTextView);
            imdbLinkTextView = v.findViewById(R.id.imdbLinkTextView);
            progressItem = v.findViewById(R.id.progress_bar);
            progressPercentage = v.findViewById(R.id.textView);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    movieSummaryPresenter.onMovieClicked();
                }
            });
        }

        ImageView getImageView() { return imageView; }
        TextView getRankTextView() { return rankTextView; }
        TextView getTitleTextView() { return titleTextView; }
        TextView getYearTextView() { return yearTextView; }
        TextView getImdbIdTextView() { return imdbIdTextView; }
        TextView getImdbRatingTextView() { return imdbRatingTextView; }
        TextView getImdbVotesTextView() { return imdbVotesTextView; }
        TextView getImdbLinkTextView() { return  imdbLinkTextView; }

        @Override
        public void launchDetailActivity(String imdbId) {
            Intent intent = new Intent(imageView.getContext(), MovieDetailActivity.class);
            intent.putExtra("imdbId", imdbId);
            imageView.getContext().startActivity(intent);
        }

        @Override
        public void showProgressBar(int progress) {
            progressItem.setProgress(progress);
            progressPercentage.setText(String.format("%s%%", String.valueOf(progress)));
            progressItem.setVisibility(View.VISIBLE);
        }

        @Override
        public void hideProgressBar() {
            progressItem.setVisibility(View.GONE);
        }
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_summary_view, viewGroup, false);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final String imdbId = movieSummaryData.get(holder.getAdapterPosition()).getImdbId();
        holder.movieSummaryPresenter = new MovieSummaryPresenter(progressProvider, imdbId);

        // Get element from your dataset at this position
        // Replace the contents of the view with that element
        holder.getRankTextView().setText(String.valueOf(movieSummaryData.get(position).getRank()));
        holder.getTitleTextView().setText(movieSummaryData.get(position).getTitle());
        holder.getYearTextView().setText(String.valueOf(movieSummaryData.get(position).getYear()));
        holder.getImdbIdTextView().setText(movieSummaryData.get(position).getImdbId());
        holder.getImdbRatingTextView().setText(String.valueOf(movieSummaryData.get(position).getImdbRating()));
        holder.getImdbVotesTextView().setText(String.valueOf(movieSummaryData.get(position).getImdbVotes()));
        holder.getImdbLinkTextView().setText(movieSummaryData.get(position).getImdbLink());

        holder.movieSummaryPresenter.attach(holder);
        holder.movieSummaryPresenter.present();

        // If URL is empty, provide error image
        if (movieSummaryData.get(position).getPoster().isEmpty()) {
            Picasso.get()
                    .load(R.drawable.error)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.error)
                    .into(holder.imageView);
        } else {
            Picasso
                    .get()
                    .load(movieSummaryData.get(position).getPoster())
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.error)
                    .resize(500,0)
                    .centerCrop()
                    .into(holder.imageView);
        }
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.movieSummaryPresenter.detach();
    }

    @Override
    public void onViewAttachedToWindow(@NonNull ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.movieSummaryPresenter.attach(holder);
        holder.movieSummaryPresenter.present();
    }

    public void setData(List<MovieSummaryData> data) {
        movieSummaryData.clear();
        movieSummaryData = data;
        notifyDataSetChanged();
    }

}