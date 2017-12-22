package co.devhack.presentation.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import co.devhack.R;
import co.devhack.domain.model.Modules;
import co.devhack.helpers.Utilities;

/**
 * Created by cdcalvo on 21/12/17.
 */

public class DetailProgramAdapter extends RecyclerView.Adapter<DetailProgramAdapter.DetailProgramViewHolder> {

    private List<Modules> dataSet;

    public DetailProgramAdapter(List<Modules> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public DetailProgramViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        return new DetailProgramViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailProgramViewHolder holder, int position) {
        Modules modules = dataSet.get(position);

        holder.tvHeader.setText(modules.getName());
        holder.tvDetailItem.setText(Utilities.convertList(modules.getThemes()));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class DetailProgramViewHolder extends RecyclerView.ViewHolder {

        public TextView tvDetailItem;
        public TextView tvHeader;

        public DetailProgramViewHolder(View itemView) {
            super(itemView);

            tvDetailItem = itemView.findViewById(R.id.tvDetailItem);
            tvHeader = itemView.findViewById(R.id.tvHeader);

        }
    }
}
