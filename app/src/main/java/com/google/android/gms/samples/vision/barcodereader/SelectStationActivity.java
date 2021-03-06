package com.google.android.gms.samples.vision.barcodereader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SelectStationActivity extends AppCompatActivity {

    List<String> stops;
    RecyclerView recyclerView;
    BusStopAdapter busStopAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_station);

        stops = new ArrayList<>();

        stops.add(0,"Rohini");
        stops.add(1,"Janakpuri");
        stops.add(2,"Bawana");
        stops.add(3,"Rajouri");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        busStopAdapter = new BusStopAdapter(stops,this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(busStopAdapter);




    }
}
