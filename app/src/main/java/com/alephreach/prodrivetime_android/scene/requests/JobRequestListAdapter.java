package com.alephreach.prodrivetime_android.scene.requests;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alephreach.prodrivetime_android.R;
import com.alephreach.prodrivetime_android.domain.JobRequest;
import com.alephreach.prodrivetime_android.utils.CurrencyFormat;

import java.util.ArrayList;
import java.util.List;

public class JobRequestListAdapter extends RecyclerView.Adapter<JobRequestListAdapter.ViewHolder> {

    interface Listener {
        void onRequestClicked(JobRequest request);
    }

    private Listener mListener;
    private List<JobRequest> mJobRequestList = new ArrayList<>();

    public void bindRequests(List<JobRequest> jobRequests) {
        mJobRequestList = jobRequests;
        notifyDataSetChanged();
    }

    public void bindListener(Listener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.view_request_item, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JobRequest request = mJobRequestList.get(position);
        holder.mTitle.setText(request.getLoadTitle());
        holder.mPrice.setText(CurrencyFormat.getCurrencyFormat(request.getAmountOffered()));
        holder.mEmail.setText(request.getCompanyEmail());
        holder.mTimeStamp.setText(request.getTimeStamp());
        holder.mDestination.setText(request.getDropOffAddress());
    }

    @Override
    public int getItemCount() {

        if(mJobRequestList == null) {
            return 0;
        }

        return mJobRequestList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTitle;
        TextView mPrice;
        TextView mEmail;
        TextView mTimeStamp;
        TextView mDestination;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.request_list_title);
            mPrice = itemView.findViewById(R.id.request_list_price);
            mEmail = itemView.findViewById(R.id.request_list_client_email);
            mTimeStamp = itemView.findViewById(R.id.request_list_time_posted);
            mDestination = itemView.findViewById(R.id.request_list_destination);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onRequestClicked(mJobRequestList.get(getAdapterPosition()));
                }
            });

        }
    }

}




















