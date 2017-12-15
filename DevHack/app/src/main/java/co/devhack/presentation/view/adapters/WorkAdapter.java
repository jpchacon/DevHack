package co.devhack.presentation.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import co.devhack.R;

/**
 * Created by Juanpa on 14/12/2017.
 */

public class WorkAdapter {

    //TODO IMPLEMENTAR WORKADAPTER

    /*private List<Work> dataSet;

    public WorkAdapter(List<Work> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public WorkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_work, parent, false);
        return new WorkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WorkViewHolder holder, int position) {
        Work work = dataSet.get(position);

        holder.tvEmpresa.setText(work.getFinished());
        holder.tvCargo.setText(work.getDescription());
        holder.tvFecha.setText(work.getFinishDate().toString());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }*/

    public class WorkViewHolder extends RecyclerView.ViewHolder {

        public TextView tvEmpresa, tvCargo, tvFecha;

        public WorkViewHolder(View itemView) {
            super(itemView);

            tvEmpresa = itemView.findViewById(R.id.tvEmpresa);
            tvCargo = itemView.findViewById(R.id.tvCargo);
            tvFecha = itemView.findViewById(R.id.tvFecha);
        }
    }
}
