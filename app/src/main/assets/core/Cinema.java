package assets.core;

public class Cinema implements Place{

    //IMPORTANT: If new variable is added, change Init as well
    private String name;
    private String description;
    private double score;
    private int numOfSaloons;
    private int capacity;
    private CinemaSaloon[] cinemaSaloons;

    public Cinema(String name, String description, int numOfSaloons, double score)
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
        this.description = description;
        this.score = score;
        this.capacity = 0;
        this.numOfSaloons = numOfSaloons;

        cinemaSaloons = new CinemaSaloon[numOfSaloons];
        for (int i = 0; i < numOfSaloons; i++)
        {
            int randomNumber = Utils.randomWithRange(0,4);
            CinemaSaloon saloon = new CinemaSaloon("S"+i, Films.films[randomNumber],
                    (randomNumber+1)*5, Utils.randomWithRange(3,5), Utils.randomWithRange(3,5));
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


    public int getNumOfSaloons() {
        return numOfSaloons;
    }

    public CinemaSaloon[] getCinemaSaloons() {
        return cinemaSaloons;
    }

    public String toString(){
        return name;
    }
}