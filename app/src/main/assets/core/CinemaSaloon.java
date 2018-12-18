package assets.core;

public class CinemaSaloon {

    private String name;
    private int capacity;
    private Films.Film film;
    private int price; //This is here because film prices can change per cinema
    private CinemaSeat[][] seats;
    private int rowCount;
    private int columnCount;

    public CinemaSaloon(String name, Films.Film film, int price, int rowCount, int columnCount) {
        this.name = name;
        this.film = film;
        this.price = price;
        capacity = 0;
        this.rowCount = rowCount;
        this.columnCount = columnCount;

        this.seats = new CinemaSeat[rowCount][columnCount];

        for (int i = 0; i < rowCount; i++)
        {
            for (int j = 0; j < columnCount; j++)
            {
                CinemaSeat seat = new CinemaSeat((char)(65 +i) + "-" + j, price, rowCount, columnCount);
                seats[i][j] = seat;
                capacity = rowCount * columnCount;
            }
        }

    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public CinemaSeat[][] getSeats() {
        return seats;
    }

    public Films.Film getFilm() {
        return film;
    }

}
