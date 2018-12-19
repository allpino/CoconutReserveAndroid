package coco.coconutreserve.assets.core;

public class User
{
    private String name;
    private String appType;
    private String userType;
    private int points;
    private Wallet wallet;

    public User(String name, String appType, String userType) {

        if (name == null || appType == null || userType == null)
        {
            throw new NullPointerException("Null arguments in User constructor");
        }


        if (appType.equals(Constants.CINEMA) )
        {
            this.name = name;
            this.appType = appType;
            this.userType = userType;
            this.wallet = new Wallet(Utils.randomWithRange(20,50),Constants.CINEMA);
            this.points = 0;
        }
        else
        {
            throw new NullPointerException("Calling Cinema user constructor for other app");
        }
    }

    public User(String name, String appType)
    {
        if (name == null || appType == null)
        {
            throw new NullPointerException("Null arguments in User constructor");
        }

        this.name = name;
        this.appType = appType;

        this.wallet = new Wallet(Utils.randomWithRange(20,50),appType);
    }

    public String getName() {
        return name;
    }

    public String getAppType() {
        return appType;
    }

    public String getUserType() {
        if (appType.equals(Constants.CINEMA))
        {
            return userType;
        }
        else
            {
                throw new NullPointerException("Accessing userType which is not using cinema app");
            }
    }

    public int getPoints() {
        if (appType.equals(Constants.CINEMA))
        {
            return points;
        }
        else
        {
            throw new NullPointerException("Accessing points which is not using cinema app");
        }
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void addPoints(int val)
    {
        points += val;
    }

    public void subPoints(int val)
    {
        if (points - val >= 0)
        {
            points -= val;
        }
    }
}
