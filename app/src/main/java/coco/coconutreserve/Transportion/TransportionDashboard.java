package coco.coconutreserve.Transportion;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import coco.coconutreserve.Home;
import coco.coconutreserve.LocationAdaptor;
import coco.coconutreserve.Notifications;
import coco.coconutreserve.R;
import coco.coconutreserve.assets.core.Constants;
import coco.coconutreserve.assets.core.Locations;

public class TransportionDashboard extends AppCompatActivity {

    private TextView mTextMessage;
    private int departureLocationId;
    private int arrivalLocationId;
    private int numberOfSelections = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Toast.makeText( getApplicationContext(),"Select your departure location",
                Toast.LENGTH_SHORT).show();


        ListView listView = (ListView) findViewById(R.id.activity_list_of_films);
        LocationAdaptor locationAdaptor = new LocationAdaptor(this, Locations.locations);
        listView.setAdapter(locationAdaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Locations.Location selectedLocation = (Locations.Location) listView.getItemAtPosition(i);

                if (numberOfSelections == 0)
                {
                    listView.getChildAt(i).setBackgroundColor(Color.LTGRAY);
                    departureLocationId = selectedLocation.getId();
                    numberOfSelections++;

                    Toast.makeText( getApplicationContext(),"Select your arrival location ",
                            Toast.LENGTH_SHORT).show();
                }
                else if (numberOfSelections == 1)
                {
                    if (selectedLocation.getId() == departureLocationId)
                    {
                        departureLocationId = -1;
                        listView.getChildAt(i).setBackgroundColor(Color.WHITE);
                        numberOfSelections--;
                        Toast.makeText( getApplicationContext(),"Select your departure location",
                                Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        arrivalLocationId = selectedLocation.getId();
                        numberOfSelections++;
                        Intent intent = new Intent(getApplicationContext(),TransportionViewAsList.class);
                        intent.putExtra("departureLocationId",departureLocationId);
                        intent.putExtra("arrivalLocationId",arrivalLocationId);
                        startActivity(intent);

                    }
                }
                else if (numberOfSelections >= 2)
                {
                    numberOfSelections = 0;
                    departureLocationId = -1;
                    arrivalLocationId = -1;
                    for (int j = 0; j <listView.getChildCount() ; j++) {
                        listView.getChildAt(j).setBackgroundColor(Color.WHITE);

                    }
                }

            }
        });
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_dashboard);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case (R.id.navigation_home):
                        Intent intent = new Intent(TransportionDashboard.this, Home.class);
                        intent.putExtra("appType",Constants.TRANSPORTION);
                        startActivity(intent);
                        break;
                    case (R.id.navigation_dashboard):
                        Intent intent2 = new Intent(TransportionDashboard.this, TransportionDashboard.class);
                        startActivity(intent2);
                        break;
                    case (R.id.navigation_notifications):
                        Intent intent3 = new Intent(TransportionDashboard.this, Notifications.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });

    }

}

