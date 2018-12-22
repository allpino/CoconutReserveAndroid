package coco.coconutreserve;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import coco.coconutreserve.assets.core.SeatAndRoom;

public class SeatAdaptor extends ArrayAdapter<SeatAndRoom>
{
    private static class ViewHolder {
        TextView seatName;
        TextView seatPrice;
        TextView seatCapacity;
        ImageView seatPic;
    }

    private final LayoutInflater layoutInflater;
    private final Context context;
    private ViewHolder holder;
    private final SeatAndRoom[] seatAndRooms;


    public SeatAdaptor(Context context, SeatAndRoom[] seatAndRooms)
    {
        super(context,0,seatAndRooms);
        this.seatAndRooms = seatAndRooms;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount(){
        return seatAndRooms.length;
    }

    @Override
    public SeatAndRoom getItem(int position)
    {
        return seatAndRooms[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
        {
            if (parent.getContext() instanceof SeatSelection) // I will fix this after activities are complete
            {
                convertView = layoutInflater.inflate(R.layout.seat_view_listelement,null); // I know this is wrong atm
            }

            holder = new ViewHolder();
            holder.seatName = (TextView) convertView.findViewById(R.id.seatName);
            holder.seatPic = (ImageView) convertView.findViewById(R.id.seatPic);
            convertView.setTag( holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.seatPic.setImageResource(seatAndRooms[position].getPicture());
        holder.seatName.setText(seatAndRooms[position].getName());

        return convertView;



    }

}
