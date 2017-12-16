package co.devhack.presentation.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import co.devhack.R;

/**
 * Created by Juanpa on 14/12/2017.
 */

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.WorkViewHolder> {


    @Override
    public WorkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(WorkViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class WorkViewHolder extends RecyclerView.ViewHolder {



        public WorkViewHolder(View itemView) {
            super(itemView);


        }
    }
}
