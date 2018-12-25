package coco.coconutreserve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WalletInfo extends AppCompatActivity {
    TextView currentAmount, walletHeader, addAmountTV, savedInfoShow;
    EditText walletName;
    Button save ;
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

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WalletInfo.this, Home.class);
                startActivity(intent);
            }
        });

    }
}
