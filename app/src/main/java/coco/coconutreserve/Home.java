package coco.coconutreserve;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import coco.coconutreserve.Cinema.CinemaDashboard;
import coco.coconutreserve.Hotel.HotelDashboard;
import coco.coconutreserve.Transportion.TransportionDashboard;
import coco.coconutreserve.assets.core.Constants;
import coco.coconutreserve.assets.core.Init;
import coco.coconutreserve.assets.core.Reservation;
import coco.coconutreserve.assets.core.Transportion;
import coco.coconutreserve.assets.core.User;

public class Home extends AppCompatActivity {
    Button accountSettings, myWallet, logout, wishlist;
    TextView userName, wallet , numOfReservations;
    User user;
    ArrayList<Reservation> reservations;
    Init init;
    String appType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        appType = getIntent().getExtras().getString("appType");

        init = Init.getInstance(appType);
        reservations = Init.getInstance(appType).getReservations();
        user = Init.getInstance(appType).getUser();
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, WelcomeActivity.class);
                startActivity(intent);
            }
        });

        wishlist = findViewById(R.id.wishList);
        wishlist.setVisibility(View.INVISIBLE);
        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Wishlist.class);
                intent.putExtra("appType",appType);
                startActivity(intent);
            }
        });
        userName = findViewById(R.id.homeUserName);
        userName.setText("Username:" + user.getName());
        wallet = findViewById(R.id.homeWallet);
        wallet.setText("Wallet name: " + user.getWallet().getName() + ", amount: " + user.getWallet().getAmount());
        numOfReservations = findViewById(R.id.homeNumberOfReservations);
        numOfReservations.setText("Number of Reservations: " + reservations.size()+"");


        accountSettings = findViewById(R.id.accountSettings);
        myWallet = findViewById(R.id.walletSettings);

        accountSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, AccountSettings.class);
                intent.putExtra("appType",appType);
                startActivity(intent);
            }
        });

        myWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, WalletInfo.class);
                intent.putExtra("appType",appType);
                startActivity(intent);
            }
        });
        if (appType.equals(Constants.CINEMA))
        {
            TextView userType = findViewById(R.id.homeUserType);
            userType.setText("User Type: " + user.getUserType());
            TextView points = findViewById(R.id.homePoints);
            points.setText("Points: " + user.getPoints());
            wishlist.setVisibility(View.VISIBLE);
        }
        else
        {
            TextView userType = findViewById(R.id.homeUserType);
            TextView points = findViewById(R.id.homePoints);

            userType.setVisibility(View.INVISIBLE);
            points.setVisibility(View.INVISIBLE);
        }

        ListView listView = findViewById(R.id.activity_list_of_history);
        HistoryAdaptor historyAdaptor = new HistoryAdaptor(this,init.getReservations());
        listView.setAdapter(historyAdaptor);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_home);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case (R.id.navigation_home):
                        Intent intent = new Intent(Home.this, Home.class);
                        intent.putExtra("appType",appType);
                        startActivity(intent);
                        break;
                    case (R.id.navigation_dashboard):
                        Intent intent1 = null;
                        if (appType.equals(Constants.CINEMA))
                        {
                            intent1 = new Intent(Home.this, CinemaDashboard.class);
                        }
                        else if (appType.equals(Constants.HOTEL))
                        {
                            intent1 = new Intent(Home.this, HotelDashboard.class);
                        }
                        else if (appType.equals(Constants.TRANSPORTION))
                        {
                            intent1 = new Intent(Home.this,TransportionDashboard.class);
                        }
                        intent1.putExtra("appType",appType);
                        startActivity(intent1);
                        break;
                    case (R.id.navigation_notifications):
                        Intent intent2 = new Intent(Home.this, Notifications.class);
                        intent2.putExtra("appType",appType);
                        startActivity(intent2);
                        break;
                }
                return false;
            }
        });
    }


}
