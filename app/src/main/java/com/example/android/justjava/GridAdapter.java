package com.example.android.justjava;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private final Context mContext;
    private final String[] mDataset;

    // 1
    GridAdapter(Context context, String[] myDataset) {
        this.mContext = context;
        this.mDataset = myDataset;
    }

    // 2
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView gridTextView;
        ViewHolder(View v) {
            super(v);
            gridTextView = v.findViewById(R.id.my_recycler_view);
            //this.v = v;
        }
        TextView getTextView() {
            return gridTextView;
        }
    }

    // 5

    public View getView(int position, View convertView, ViewGroup parent) {
        //final String data = mDataset[position];

        if (convertView == null) {
            final LayoutInflater layoutInflater= LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.my_text_view, null);

            final TextView gridTextView = convertView.findViewById(R.id.gridTextView);

            //gridTextView.setText(mContext.getString(mDataset[position]));
            final ViewHolder viewHolder = new ViewHolder(gridTextView);
            convertView.setTag(viewHolder);

        }

        final ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.gridTextView.setText(mDataset[position]);

        return convertView;

        /*TextView dummyTextView = new TextView(mContext);
        dummyTextView.setText(String.valueOf(position));
        return dummyTextView;*/
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    public GridAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_text_view, viewGroup, false);

        return new GridAdapter.ViewHolder(v);
    }

    @Override
    // Replace the contents of a view (invoked by the layout manager)
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.getTextView().setText(mDataset[position]);

    }

}
