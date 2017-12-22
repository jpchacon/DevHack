package co.devhack.presentation.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private ProgramAdapter.ListenerClickView listenerClickView;

    public interface ListenerClickView{
        void click(Program program);
    }

    public ProgramAdapter(List<Program> dataSet, ProgramAdapter.ListenerClickView listenerClickView) {
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
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class ProgramsViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivLogoProgram;
        public TextView tvProgram, tvStartDate, tvDuration;

        public ProgramsViewHolder(View itemView) {
            super(itemView);

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
}
