package com.teamfive.trailerflix.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teamfive.trailerflix.R;
import com.teamfive.trailerflix.model.Trailer;

import java.util.List;

public class AdapterTrailers extends RecyclerView.Adapter<AdapterTrailers.MyViewHolder> {

    List<Trailer> trailers;

    public AdapterTrailers(List<Trailer> trailers) {
        this.trailers = trailers;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View item_list = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_feedback, viewGroup, false);
        return new MyViewHolder(item_list);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Trailer feedback = trailers.get(i);

        myViewHolder.feedback.setText(feedback.getFeedback());
        myViewHolder.feedback_case.setText(feedback.getString_case());

        if (feedback.isToast_checked()) {
            myViewHolder.toast_enabled.setText("True");
        } else {
            myViewHolder.toast_enabled.setText("False");
        }
    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView feedback;
        TextView feedback_case;
        TextView toast_enabled;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            feedback = itemView.findViewById(R.id.tv_feedback);
            feedback_case = itemView.findViewById(R.id.tv_case);
            toast_enabled = itemView.findViewById(R.id.tv_toast);
        }
    }
}
