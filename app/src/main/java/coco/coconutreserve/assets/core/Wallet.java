package coco.coconutreserve.assets.core;

public class Wallet
{
    private String name;
    private int amount;
    private String passport;
    private String appType;


    public Wallet(String name, int amount, String appType) {
        this.name = name;
        this.amount = amount;
        this.appType = appType;
    }


   public Wallet(String name, int amount, String appType, String passport)
    {
        if (appType.equals(Constants.TRANSPORTION))
        {
            this.name = name;
            this.amount = amount;
            this.appType = appType;
            this.passport = passport;
        }
        else
        {
            throw new NullPointerException("You can not have passport outside of Cinema app");
        }
    }

    public void addFunds(int val)
    {
        this.amount += val;
    }

    public boolean subFunds(int val)
    {
        if(amount - val >= 0)
        {
            this.amount -= val;
            return true;
        }
        return false;
    }

    public String getPassport() {
        return passport;
    }

    public String getName() {
        return name;
    }

    public String getAppType() {
        return appType;
    }

    public int getAmount() {
        return amount;
    }
}
