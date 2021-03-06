package com.google.android.gms.samples.vision.barcodereader;

/**
 * Created by samarthgupta on 09/04/17.
 */
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samarthgupta on 08/04/17.
 */

public class BusStopAdapter extends RecyclerView.Adapter<BusStopAdapter.BusStopHolder> {

    List<String> stops= new ArrayList<>();
    Context c;

    public BusStopAdapter(List<String> stops, Context context)
    {
        this.stops = stops;
        c= context;
    }

    @Override
    public BusStopHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        BusStopHolder holder = new BusStopHolder(view,stops);
        return holder;
    }

    @Override
    public void onBindViewHolder(BusStopHolder holder, int position) {

        holder.stopName.setText(stops.get(position));
    }

    @Override
    public int getItemCount() {
        return stops.size();
    }


    public class BusStopHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView stopName;
        RadioButton stopSelect;
        List<String> stops;
        AlertDialog alertDialog;
        String stopNameClicked;

        public BusStopHolder(View itemView,List<String> busStops) {
            super(itemView);
            itemView.setOnClickListener(this);
            stops=busStops;
            stopName = (TextView)itemView.findViewById(R.id.tv_name);
            stopSelect = (RadioButton)itemView.findViewById(R.id.tv_select);
        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            Log.i("TAG","CLICK on position "+position);
            Log.i("TAG",stops.get(position));
            stopNameClicked = stops.get(position);
            stopSelect.setChecked(true);
            setAlertDialog();

        }

        void setAlertDialog() {
            alertDialog = new AlertDialog.Builder(c).create();
            alertDialog.setTitle("Select Destination");
            alertDialog.setMessage("Select "+ stopNameClicked +" as destination?");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "PROCEED",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            //SEND INTENT
                        }
                    });

            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "CANCEL",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            stopSelect.setChecked(false);
                        }
                    });

            alertDialog.show();

        }
    }
}

//compile 'com.android.support:support-v4:23.0.1'