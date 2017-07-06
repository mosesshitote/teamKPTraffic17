package com.kptrafficpolice.android.utilities;

/**
 * Created by Asus on 6/15/2017.
 */
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.kptrafficpolice.android.R;

import java.util.ArrayList;
import java.util.List;

public class MyComplaintsListAdapter extends RecyclerView.Adapter<MyComplaintsListAdapter.ViewHolder> {
    private ArrayList<String> mDataset;
    List<MyComplaintsHelper> complaintsHelperList;
    Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        CardView cv;
        TextView tvComplaintsID, tvComplaintDescription, tvComplaintStatus, tvComplaintDate;
        //ImageView  tvComplaintDate;
        LinearLayout lLCallNow;
        VideoView vvComplaints;


        public ViewHolder(View v) {
            super(v);
            tvComplaintsID = (TextView) itemView.findViewById(R.id.tv_complaint_id);
            tvComplaintStatus = (TextView) itemView.findViewById(R.id.tv_complaint_status);
            tvComplaintDescription = (TextView) itemView.findViewById(R.id.tv_complaint_description);
            tvComplaintDate = (TextView) itemView.findViewById(R.id.iv_complaint_image);


        }
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public MyComplaintsListAdapter(Context context, List<MyComplaintsHelper> myComplaintsHelperList) {
        this.complaintsHelperList = myComplaintsHelperList;
        this.context = context;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyComplaintsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_mycomplaints_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final MyComplaintsHelper helper = complaintsHelperList.get(position);
        holder.tvComplaintsID.setText(helper.getStrComplaintID());
        String strComplaintStatus = helper.getStrComplaintStatus();
        if (strComplaintStatus.equals("Pending")){
            holder.tvComplaintStatus.setTextColor(Color.parseColor("#F22613"));
        }else if (strComplaintStatus.equals("Completed")){
            holder.tvComplaintStatus.setTextColor(Color.parseColor("#019875"));
        }else if (strComplaintStatus.equals("In Progress")){
            holder.tvComplaintStatus.setTextColor(Color.parseColor("#E9D460"));
        }
        holder.tvComplaintStatus.setText(strComplaintStatus);
        holder.tvComplaintDescription.setText(helper.getStrDescription());
        String strDate = helper.getStrDate();
        strDate = strDate.substring(8,10);
        String strMonth = helper.getStrDate();
        strMonth = strMonth.substring(5,7);
        switch (strMonth){
            case "01":
                strMonth = "Jan";
                break;
            case "02":
                strMonth = "Feb";
                break;
            case "03":
                strMonth = "Mar";
                break;
            case "04":
                strMonth = "Apr";
                break;
            case "05":
                strMonth = "May";
                break;
            case "06":
                strMonth = "Jun";
                break;
            case "07":
                strMonth = "Jul";
                break;
            case "08":
                strMonth = "Aug";
                break;
            case "09":
                strMonth = "Sep";
                break;
            case "10":
                strMonth = "Oct";
                break;
            case "11":
                strMonth = "Nov";
                break;
            case "12":
                strMonth = "Dec";
                break;


        }
        holder.tvComplaintDate.setText(strDate+"\n"+strMonth);
//        strDate.substring(9,10);
       //Glide.with(context).load(Configuration.END_POINT_LIVE+"uploads/images").into(holder.tvComplaintDate);

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return complaintsHelperList.size();
        }
        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }
    }
