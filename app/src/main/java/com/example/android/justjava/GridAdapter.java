package com.example.android.justjava;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    private final Context mContext;
    private final String[] mDataset;

    // 1
    GridAdapter(Context context, String[] myDataset) {
        this.mContext = context;
        this.mDataset = myDataset;
    }

    // 2
    @Override
    public int getCount() {
        return mDataset.length;
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }
    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    private class ViewHolder {
        private final TextView gridTextView;
        ViewHolder(TextView gridTextView) {
            //super(v);
            //gridTextView = v.findViewById(R.id.my_recycler_view);
            this.gridTextView = gridTextView;
        }
/*        TextView getTextView() {
            return gridTextView;
        }*/
    }

    // 5
    @Override
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

    /*
    // Create new views (invoked by the layout manager)
    @NonNull
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_text_view, viewGroup, false);

        return new MyAdapter.ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.getTextView().setText(mDataset[position]);

    }*/

}
