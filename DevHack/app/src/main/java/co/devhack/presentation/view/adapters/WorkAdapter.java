package co.devhack.presentation.view.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    private Context context;
    private static int lastPosition = -1;

    public interface ListenerClickView{
        void click(Work work);
    }

    public WorkAdapter(Context context,List<Work> dataSet, ListenerClickView listenerClickView){
        this.context = context;
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
        holder.tvCityCard.setText(work.getCiudad());
        holder.tvFechaCard.setText(work.getFecha());

        setAnimation(holder.cardViewWork,position);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    public class WorkViewHolder extends RecyclerView.ViewHolder {

        private CardView cardViewWork;
        private TextView tvEmpresaCard;
        private TextView tvCargoCard;
        private TextView tvCityCard;
        private TextView tvFechaCard;

        public WorkViewHolder(View itemView) {
            super(itemView);

            cardViewWork = itemView.findViewById(R.id.cardViewWork);
            tvEmpresaCard = itemView.findViewById(R.id.tvEmpresaCard);
            tvCargoCard = itemView.findViewById(R.id.tvCargoCard);
            tvCityCard = itemView.findViewById(R.id.tvCityCard);
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
    private void setAnimation(View viewToAnimate, int position){

        if (position > lastPosition){
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }

    }
}
