package coco.coconutreserve.Hotel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import coco.coconutreserve.R;
import coco.coconutreserve.assets.core.Films;
import coco.coconutreserve.assets.core.Locations;

public class PlaceAdaptor extends ArrayAdapter<Locations.Location>
{
    private static class ViewHolder {
        TextView locationName;
        ImageView locationPic;

    }

    private final LayoutInflater layoutInflater;
    private final Context context;
    private ViewHolder holder;
    private final Locations.Location[] locations;

    public PlaceAdaptor(Context context, Locations.Location[] locations)
    {
        super(context,0,locations);
        this.locations = locations;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount(){
        return locations.length;
    }

    @Override
    public Locations.Location getItem(int position)
    {
        return locations[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
        {
            convertView = layoutInflater.inflate(R.layout.list_of_locations,null);
            holder = new ViewHolder();
            holder.locationName = (TextView) convertView.findViewById(R.id.location_name);
            holder.locationPic = (ImageView) convertView.findViewById(R.id.location_image);
            convertView.setTag( holder);
        }
        else
        {
            holder = (ViewHolder)convertView.getTag();
        }

        Locations.Location location = locations[position];

        if(location != null)
        {
            holder.locationPic.setImageResource(location.getPicture());
            holder.locationName.setText(location.getLocationName());

        }

        return convertView;

    }
}