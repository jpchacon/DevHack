package co.devhack.presentation.view.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import co.devhack.R;
import co.devhack.domain.model.Program;
import co.devhack.helpers.Utilities;

/**
 * Created by Juanpa on 14/12/2017.
 */
public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ProgramsViewHolder>{

    private List<Program> dataSet;
<<<<<<< HEAD
    private ProgramAdapter.ListenerClickView listenerClickView;

    public interface ListenerClickView{
        void click(Program program);
    }

    public ProgramAdapter(List<Program> dataSet, ProgramAdapter.ListenerClickView listenerClickView) {
=======
    private Context context;
    private static int lastPosition = -1;

    public ProgramAdapter(Context context,List<Program> dataSet) {
        this.context = context;
>>>>>>> 394c4c60e10933e75c66e2f0efdf277df9df19ed
        this.dataSet = dataSet;
        this.listenerClickView = listenerClickView;
    }

    @Override
    public ProgramsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_programs, parent, false);
        return new ProgramsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgramsViewHolder holder, int position) {
        Program program = dataSet.get(position);

        if(!Utilities.isEmpty(program.getImage())) {
            Glide.with(holder.itemView).load(program.getImage()).into(holder.ivLogoProgram);
        }
        holder.tvProgram.setText(program.getName());
        holder.tvStartDate.setText(program.getStartDate().toString());
        holder.tvDuration.setText(program.getDuration());

        setAnimation(holder.cardViewPrograms,position);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class ProgramsViewHolder extends RecyclerView.ViewHolder {

        private CardView cardViewPrograms;
        public ImageView ivLogoProgram;
        public TextView tvProgram, tvStartDate, tvDuration;

        public ProgramsViewHolder(View itemView) {
            super(itemView);

            cardViewPrograms = itemView.findViewById(R.id.cardViewPrograms);
            ivLogoProgram = itemView.findViewById(R.id.ivLogoProgram);
            tvProgram = itemView.findViewById(R.id.tvProgram);
            tvStartDate = itemView.findViewById(R.id.tvStartDate);
            tvDuration = itemView.findViewById(R.id.tvDuration);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Program program = dataSet.get(getAdapterPosition());
                    listenerClickView.click(program);
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
