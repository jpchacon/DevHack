package co.devhack.presentation.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import co.devhack.R;
import co.devhack.domain.model.Programs;

/**
 * Created by Juanpa on 14/12/2017.
 */
public class ProgramsAdapter extends RecyclerView.Adapter<ProgramsAdapter.ProgramsViewHolder>{

    private List<Programs> dataSet;

    public ProgramsAdapter(List<Programs> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public ProgramsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_programs, parent, false);
        return new ProgramsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgramsViewHolder holder, int position) {
        Programs programs = dataSet.get(position);

        //TODO ivLogoProgram
        //holder.ivLogoProgram.setImageDrawable();
        holder.tvProgram.setText(programs.getDescription());
        holder.tvStartDate.setText(programs.getStartDate().toString());
        //TODO FORMATEAR FECHA USANDO java.text.SimpleDateFormat
        holder.tvDuration.setText(programs.getDuration());
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
        }
    }
}
