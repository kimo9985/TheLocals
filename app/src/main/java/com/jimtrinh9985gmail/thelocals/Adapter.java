package com.jimtrinh9985gmail.thelocals;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Kimo on 8/27/2016.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public final ImageView rowOneImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            rowOneImage = (ImageView) itemView.findViewById(R.id.imageView1);
        }
    }
}
