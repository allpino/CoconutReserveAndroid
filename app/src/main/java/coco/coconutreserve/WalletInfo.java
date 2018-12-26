package coco.coconutreserve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import coco.coconutreserve.Cinema.CinemaDashboard;
import coco.coconutreserve.Hotel.HotelDashboard;
import coco.coconutreserve.Transportion.TransportionDashboard;
import coco.coconutreserve.assets.core.Constants;

public class WalletInfo extends AppCompatActivity {
    TextView currentAmount, walletHeader, addAmountTV, savedInfoShow;
    EditText walletName;
    Button save ;
    String appType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_info);
        currentAmount = findViewById(R.id.currentAmountNumber);
        walletHeader =  findViewById(R.id.walletHeader);
        addAmountTV = findViewById(R.id.addAmountTV);
        savedInfoShow = findViewById(R.id.savedInfoShow);
        walletName = findViewById(R.id.walletName);
        save = findViewById(R.id.save);
        appType = getIntent().getExtras().getString("appType");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(appType.equals(Constants.HOTEL))
                {
                    Intent intent = new Intent(WalletInfo.this, HotelDashboard.class);
                    startActivity(intent);
                }
                else if(appType.equals(Constants.CINEMA))
                {
                    Intent intent1 = new Intent(WalletInfo.this, CinemaDashboard.class);
                    startActivity(intent1);
                }
                else
                {
                    Intent intent2 = new Intent(WalletInfo.this, TransportionDashboard.class);
                    startActivity(intent2);
                }
        }

    });
}
}