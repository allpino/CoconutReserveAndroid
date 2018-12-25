package coco.coconutreserve.assets.core;

public class Discount {
    //a class for having discount information
    // each place will have it own. this will return itself.
    private int discountAmount;
    private boolean doesHave;

    public Discount(){
        discountAmount = Utils.randomWithRange(10,15);
        int zeroOrOne = Utils.randomWithRange(0,1);
        if(zeroOrOne == 1)
        {
            doesHave = true;
        }
        else doesHave =false;

    }

    // Getters and Setters

    public int getDiscountAmount() {
        if(doesHave)
        return discountAmount;
        else return 0;
    }

    public boolean doesHave() {
        return doesHave;
    }

    public void setDiscountAmount(int discountAmount) {

        this.discountAmount = discountAmount;
    }






}
