package coco.coconutreserve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class SaloonViewAsList extends AppCompatActivity {
    ListView saloonList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saloon_view_as_list);

        saloonList = (ListView) findViewById(R.id.listViewSaloon);

        /// buraya adaptor lazım. liste şeklinde göstermesi
        // gereken xml i yazdım : place viewelement diye görebilirsin.
        // liste şeklinde kullanarak seçtirmek çok daha mantıklı geldi.
        // burayı sana bırakıyorum . yazdıklarından sonra devamını bitireceğim.

    }
}
