package coco.coconutreserve.Cinema;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import coco.coconutreserve.R;
import coco.coconutreserve.assets.core.Films;

public class FilmAdaptor extends ArrayAdapter<Films.Film>
{
    private static class ViewHolder {
        TextView filmName;
        TextView filmDuration;
        ImageView filmPic;

    }

    private final LayoutInflater layoutInflater;
    private final Context context;
    private ViewHolder holder;
    private final Films.Film[] films;

    public FilmAdaptor(Context context, Films.Film[] films)
    {
        super(context,0,films);
        this.films = films;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount(){
        return films.length;
    }

    @Override
    public Films.Film getItem(int position)
    {
        return films[position];
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        if (convertView == null)
        {
            convertView = layoutInflater.inflate(R.layout.list_of_films,null);
            holder = new ViewHolder();
            holder.filmName = (TextView) convertView.findViewById(R.id.film_name);
            holder.filmDuration =  (TextView) convertView.findViewById(R.id.film_duration);
            holder.filmPic = (ImageView) convertView.findViewById(R.id.film_image);
            convertView.setTag( holder);
        }
        else
        {
            holder = (ViewHolder)convertView.getTag();
        }

        Films.Film film = films[position];

        if(film != null)
        {
            holder.filmPic.setImageResource(film.getPicture());
            holder.filmName.setText(film.getFilmName());
            String duration = "Film Duration: " + film.getDuration().getHour()+ " Hours " + film.getDuration().getMinute() + " Minutes";
            holder.filmDuration.setText(duration);

        }

        return convertView;



    }
}