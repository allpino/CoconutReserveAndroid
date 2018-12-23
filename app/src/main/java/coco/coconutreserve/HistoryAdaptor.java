package coco.coconutreserve;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

import java.util.ArrayList;

import coco.coconutreserve.assets.core.Reservation;

public class HistoryAdaptor extends ArrayAdapter<Reservation>
{
    private static class ViewHolder {
        TextView reservationInfo;

    }

    private final LayoutInflater layoutInflater;
    private final Context context;
    private ViewHolder holder;
    private final ArrayList<Reservation> reservations;

    public HistoryAdaptor(Context context, ArrayList<Reservation> reservations)
    {
        super(context,0,reservations);
        this.reservations = reservations;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount(){
        return reservations.size();
    }

    @Override
    public Reservation getItem(int position)
    {
        return reservations.get(position);
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        if (convertView == null)
        {
            convertView = layoutInflater.inflate(R.layout.home_history,null);
            holder = new ViewHolder();
            holder.reservationInfo = (TextView) convertView.findViewById(R.id.filmHistory);
            convertView.setTag( holder);
        }
        else
        {
            holder = (ViewHolder)convertView.getTag();
        }

        Reservation reservation = reservations.get(position);

        if(reservation != null)
        {
            //holder.filmPic = reservation.getId()
            holder.reservationInfo.setText(reservation.getReservationInfo());

        }

        return convertView;



    }
}
