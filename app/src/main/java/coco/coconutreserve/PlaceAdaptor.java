package coco.coconutreserve;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import coco.coconutreserve.assets.core.Constants;
import coco.coconutreserve.assets.core.Place;


public class PlaceAdaptor extends ArrayAdapter<Place>
{
    private static class ViewHolder {
        TextView placeName;
        TextView placeDescription;
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

            convertView = layoutInflater.inflate(R.layout.place_view_listelement,null); // I know this is wrong atm


            holder = new ViewHolder();
            holder.placeName = (TextView) convertView.findViewById(R.id.saloonName);
            holder.placeDescription = (TextView) convertView.findViewById(R.id.saloonText);
            holder.placeScore = (TextView) convertView.findViewById(R.id.saloonScore2);
            holder.placePic = (ImageView) convertView.findViewById(R.id.placeImage);
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
            String score = Double.toString(place.getScore()).charAt(0) + "." + Double.toString(place.getScore()).charAt(2);
            holder.placeScore.setText(score);
        }

        return convertView;

    }

}
