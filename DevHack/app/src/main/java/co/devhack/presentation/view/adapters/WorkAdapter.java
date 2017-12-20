package co.devhack.presentation.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import co.devhack.R;
import co.devhack.domain.model.Work;

/**
 * Created by Juanpa on 14/12/2017.
 */

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.WorkViewHolder>{

    List<Work> dataSet;
    private ListenerClickView listenerClickView;

    public interface ListenerClickView{
        void click(Work work);
    }

    public WorkAdapter(List<Work> dataSet, ListenerClickView listenerClickView){
        this.dataSet = dataSet;
        this.listenerClickView = listenerClickView;
    }

    @Override
    public WorkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_work,parent,false);
        return new WorkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WorkViewHolder holder, int position) {
        Work work = dataSet.get(position);

        holder.tvEmpresaCard.setText(work.getEmpresa());
        holder.tvCargoCard.setText(work.getTitulo());
        holder.tvTipoCard.setText(work.getModalidad()+", "+work.getCiudad());
        holder.tvFechaCard.setText(work.getFecha());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    public class WorkViewHolder extends RecyclerView.ViewHolder {

        private TextView tvEmpresaCard;
        private TextView tvCargoCard;
        private TextView tvTipoCard;
        private TextView tvFechaCard;

        public WorkViewHolder(View itemView) {
            super(itemView);

            tvEmpresaCard = itemView.findViewById(R.id.tvEmpresaCard);
            tvCargoCard = itemView.findViewById(R.id.tvCargoCard);
            tvTipoCard = itemView.findViewById(R.id.tvTipoCard);
            tvFechaCard = itemView.findViewById(R.id.tvFechaCard);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Work work = dataSet.get(getAdapterPosition());
                    listenerClickView.click(work);
                }
            });
        }
    }
}
