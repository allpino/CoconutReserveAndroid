package coco.coconutreserve.assets.core;

import java.util.ArrayList;

import coco.coconutreserve.R;

public class Cinema implements Place{

    //IMPORTANT: If new variable is added, change Init as well
    private int cinemaId;
    private String name;
    private String description;
    private double score;
    private int numOfSaloons;
    private int capacity;
    private CinemaSaloon[] cinemaSaloons;
    private int pictureId;


    public Cinema(int cinemaId, String name, String description, int numOfSaloons, double score, int pictureId)
    {
        if (name == null || description == null || score == 0 || numOfSaloons == 0 )
        {
            throw new NullPointerException("Parameters of cinema is empty");
        }
        else if (score > 10.0)
        {
            throw new ArithmeticException("Score can not be higher than 10");
        }


        this.name = name;
        this.cinemaId = cinemaId;
        this.description = description;
        this.score = score;
        this.capacity = 0;
        this.numOfSaloons = numOfSaloons;
        this.pictureId = pictureId;

        cinemaSaloons = new CinemaSaloon[numOfSaloons];
        ArrayList<Films.Film> films = new ArrayList<>();
        for (int i = 0; i < Films.films.length ; i++) {
            films.add(Films.films[i]);
        }

        for (int i = 0; i < numOfSaloons; i++)
        {
            int randomNumber = Utils.randomWithRange(0,films.size()-1);
            int columnCount = Utils.randomWithRange(3,5);
            CinemaSaloon saloon = new CinemaSaloon(i,"S"+i, films.remove(randomNumber) ,
                    (randomNumber+1)*5, Utils.randomWithRange(5,9)*columnCount, columnCount ,
                    R.drawable.saloon); //
            cinemaSaloons[i] = saloon;

            capacity += saloon.getCapacity();
        }

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public double getScore() {
        return score;
    }

    public CinemaSaloon getSaloonByFilm(int filmID)
    {
        for (int i = 0; i < numOfSaloons; i++)
        {
            if (cinemaSaloons[i].getFilm().getId() == filmID)
            {
                return cinemaSaloons[i];
            }
        }
        return null;
    }



    public int getNumOfSaloons() {
        return numOfSaloons;
    }

    public CinemaSaloon[] getCinemaSaloons() {
        return cinemaSaloons;
    }

    @Override
    public SeatAndRoom[] getSeats(int indexOfMid) {
        return cinemaSaloons[indexOfMid].getSeats();
    }

    @Override
    public SeatAndRoom[] getSeats() {
        throw new NullPointerException("You must specify cinemaSaloon number");
    }

    public String toString(){
        return name;
    }

    @Override
    public int getPicture() {
        return pictureId;
    }

    @Override
    public int getId() {
        return cinemaId;
    }

}