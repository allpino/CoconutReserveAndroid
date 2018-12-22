package coco.coconutreserve.assets.core;

import coco.coconutreserve.R;

public class CinemaSaloon {

    private int saloonId;
    private String name;
    private int capacity;
    private Films.Film film;
    private int price; //This is here because film prices can change per cinema
    private CinemaSeat[] seats;
    private int numOfSeats;
    private int columnCount;
    private int pictureId;

    public CinemaSaloon(int id, String name, Films.Film film, int price, int numOfSeats, int columnCount, int pictureId) {

        this.saloonId = id;
        this.name = name;
        this.film = film;
        this.price = price;
        capacity = 0;
        this.numOfSeats = numOfSeats;
        this.columnCount = columnCount;
        this.pictureId = pictureId;

        this.seats = new CinemaSeat[numOfSeats];

        for (int i = 0; i < numOfSeats; i++)
        {
            CinemaSeat seat = new CinemaSeat(i,(char)(65 +i/columnCount) + "-" + i%columnCount, price, columnCount, R.drawable.seat_empty);
            seats[i] = seat;
            capacity = numOfSeats;
        }

    }

    public String getName() {
        return name;
    }

    public int getPicture() {
        return pictureId;
    }

    public int getCapacity() {
        return capacity;
    }

    public CinemaSeat[] getSeats() {
        return seats;
    }

    public Films.Film getFilm() {
        return film;
    }

    public int getSaloonId() {
        return saloonId;
    }
}
