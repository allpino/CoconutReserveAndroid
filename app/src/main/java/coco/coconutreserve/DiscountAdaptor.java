package coco.coconutreserve;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

import java.util.ArrayList;

import coco.coconutreserve.assets.core.Discount;
import coco.coconutreserve.assets.core.Reservation;

public class DiscountAdaptor extends ArrayAdapter<Discount>
{
    private static class ViewHolder {
        TextView discountInformation;
        String nameOfDiscountOwner;
    }

    private final LayoutInflater layoutInflater;
    private final Context context;
    private ViewHolder holder;
    private final ArrayList<Discount> discounts;

    public DiscountAdaptor(Context context, ArrayList<Discount> discounts)
    {
        super();
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.discounts = discounts;
    }

    @Override
    public int getCount(){
        return discounts.size();
    }

    @Override
    public Discount getItem(int position)
    {
        return discounts.get(position);
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        if (convertView == null)
        {
            convertView = layoutInflater.inflate(R.layout.home_history,null);
            holder = new ViewHolder();
            holder.discountInformation = (TextView) convertView.findViewById(R.id.filmHistory);
            convertView.setTag( holder);
        }
        else
        {
            holder = (ViewHolder)convertView.getTag();
        }

        Discount discount = discounts.get(position);

        if( discount.doesHave() != false)
        {
            //holder.filmPic = reservation.getId()
            holder.discountInformation.setText( "Discount amount of hotel is : " + discount.getDiscountAmount());

        }

        return convertView;



    }
}
