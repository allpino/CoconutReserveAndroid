package coco.coconutreserve;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import coco.coconutreserve.assets.core.Place;


public class PlaceAdaptor extends ArrayAdapter<Place>
{
    private static class ViewHolder {
        TextView placeName;
        TextView placeDescription;
        TextView placeCapacity;
        TextView placeScore;
        ImageView placePic;
    }

    private final LayoutInflater layoutInflater;
    private final Context context;
    private ViewHolder holder;
    private final Place[] places;


    public PlaceAdaptor(Context context, Place[] places)
    {
        super(context,0,places);
        this.places = places;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount(){
        return places.length;
    }

    @Override
    public Place getItem(int position)
    {
        return places[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
        {
            if (parent.getContext() instanceof MainActivity) // I will fix this after activities are complete
            {
                convertView = layoutInflater.inflate(R.layout.activity_list_of_films,null); // I know this is wrong atm
            }

            holder = new ViewHolder();
            holder.placeName = (TextView) convertView.findViewById(R.id.place_name);
            holder.placeCapacity = (TextView) convertView.findViewById(R.id.place_capacity);
            holder.placeDescription = (TextView) convertView.findViewById(R.id.place_description);
            holder.placeScore = (TextView) convertView.findViewById(R.id.place_score);
            holder.placePic = (ImageView) convertView.findViewById(R.id.place_pic);
            convertView.setTag( holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        Place place = places[position];

        if(place != null)
        {

            holder.placePic.setImageResource(place.getPicture());
            holder.placeName.setText(place.getName());
            holder.placeDescription.setText(place.getDescription());
            holder.placeScore.setText(place.getCapacity());
        }

        return convertView;



    }

}
