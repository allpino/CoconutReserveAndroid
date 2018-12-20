package coco.coconutreserve;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import coco.coconutreserve.assets.core.Films;

public class FilmAdaptor extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Films>     mFilmList;

    public FilmAdaptor(Activity activity, List<Films> filmsList) {
        //XML'i alıp View'a çevirecek inflater'ı örnekleyelim
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        //gösterilecek listeyi de alalım
        mFilmList = filmsList;
    }

    @Override
    public int getCount() {
        return mFilmList.size();
    }

    @Override
    public Films getItem(int position) {
        //şöyle de olabilir: public Object getItem(int position)
        return mFilmList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View lineView;

        lineView = mInflater.inflate(R.layout.satir_layout, null);
        TextView textView =
                (TextView) lineView.findViewById(R.id.isimsoyisim);
        ImageView imageView =
                (ImageView) lineView.findViewById(R.id.simge);

        Films film = mFilmList.get(position);

        textView.setText(film.getIsim());

        return lineView;
    }
}