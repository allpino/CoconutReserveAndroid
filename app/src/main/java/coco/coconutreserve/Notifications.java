package coco.coconutreserve;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

import coco.coconutreserve.Cinema.CinemaDashboard;
import coco.coconutreserve.Hotel.HotelDashboard;
import coco.coconutreserve.Transportion.TransportionDashboard;
import coco.coconutreserve.assets.core.Constants;
import coco.coconutreserve.assets.core.Discount;
import coco.coconutreserve.assets.core.Transportion;

public class Notifications extends AppCompatActivity {
    private String appType;
    private ListView discountView;
    private DiscountAdaptor discountAdaptor;
    private ArrayList<Discount> discounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        discounts = new ArrayList<Discount>();
        appType = getIntent().getExtras().getString("appType");
        discountView = findViewById(R.id.list_of_discounts);
        discountAdaptor= new DiscountAdaptor(this, discounts); // ToDo: buraya bakarlar
        discountView.setAdapter(discountAdaptor);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_notifications);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(appType.equals(Constants.CINEMA)){
                switch (item.getItemId()) {
                    case (R.id.navigation_home):
                        Intent intent = new Intent(Notifications.this, Home.class);
                        intent.putExtra("appType",Constants.CINEMA);
                        startActivity(intent);
                        break;
                    case (R.id.navigation_dashboard):
                        Intent intent1 = new Intent(Notifications.this, CinemaDashboard.class);
                        intent1.putExtra("appType",Constants.CINEMA);
                        startActivity(intent1);
                        break;
                    case (R.id.navigation_notifications):
                        Intent intent2 = new Intent(Notifications.this, Notifications.class);
                        intent2.putExtra("appType",Constants.CINEMA);
                        startActivity(intent2);
                        break;
                }}
                else if(appType.equals(Constants.HOTEL)){
                    switch (item.getItemId()) {
                        case (R.id.navigation_home):
                            Intent intent = new Intent(Notifications.this, Home.class);
                            intent.putExtra("appType",Constants.HOTEL);
                            startActivity(intent);
                            break;
                        case (R.id.navigation_dashboard):
                            Intent intent1 = new Intent(Notifications.this, HotelDashboard.class);
                            intent1.putExtra("appType",Constants.HOTEL);
                            startActivity(intent1);
                            break;
                        case (R.id.navigation_notifications):
                            Intent intent2 = new Intent(Notifications.this, Notifications.class);
                            intent2.putExtra("appType",Constants.HOTEL);
                            startActivity(intent2);
                            break;
                    }}
                else if(appType.equals(Constants.TRANSPORTION)){
                    switch (item.getItemId()) {
                        case (R.id.navigation_home):
                            Intent intent = new Intent(Notifications.this, Home.class);
                            intent.putExtra("appType",Constants.TRANSPORTION);
                            startActivity(intent);
                            break;
                        case (R.id.navigation_dashboard):
                            Intent intent1 = new Intent(Notifications.this, TransportionDashboard.class);
                            intent1.putExtra("appType",Constants.TRANSPORTION);
                            startActivity(intent1);
                            break;
                        case (R.id.navigation_notifications):
                            Intent intent2 = new Intent(Notifications.this, Notifications.class);
                            intent2.putExtra("appType",Constants.TRANSPORTION);
                            startActivity(intent2);
                            break;
                    }}
                return false;
            }
        });

    }

}
