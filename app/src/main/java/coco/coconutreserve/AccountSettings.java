package coco.coconutreserve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class AccountSettings extends AppCompatActivity {

    TextView aacountSettings , userNameTV ;
    EditText userNameET ;
    Switch premiumSwitch;
    Button walletSetings, saveAndExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

    }
}
