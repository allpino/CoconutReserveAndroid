package coco.coconutreserve;

import android.accounts.Account;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import coco.coconutreserve.assets.core.Constants;
import coco.coconutreserve.assets.core.Init;
import coco.coconutreserve.assets.core.User;

public class AccountSettings extends AppCompatActivity {

    TextView aacountSettings , userNameTV ;
    EditText userNameET ;
    Switch premiumSwitch;
    Button walletSetings, saveAndExit;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        user = Init.getInstance().getUser();

       aacountSettings =  (TextView) findViewById(R.id.accountSettingTV);
       userNameTV = ( TextView ) findViewById(R.id.userName);
       userNameET = (EditText) findViewById(R.id.userNameET);
       premiumSwitch = ( Switch ) findViewById(R.id.premiumSwitch);
       walletSetings = (Button) findViewById(R.id.walletSettings);
       saveAndExit = ( Button) findViewById(R.id.saveAndExit);

       if(user.isPremium())
       {
            //premiumSwitch.setChecked();
       }

       premiumSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked)
               user.setUserType(Constants.PREMIUM);
               else
                   user.setUserType(Constants.FREE);
           }});

       walletSetings.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(AccountSettings.this, WalletInfo.class);
               startActivity(intent);
           }
       });

    }
}
