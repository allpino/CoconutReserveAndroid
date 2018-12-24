package coco.coconutreserve.assets.core;

public class Constants {
    public static final String CINEMA = "CINEMA";
    public static final String TRANSPORTION = "TRANSPORTION";
    public static final String HOTEL = "HOTEL";

    public static final int NUM_OF_CINEMAS = 5;
    public static final int NUM_OF_HOTELS= 10;
    public static final int NUM_OF_TRANSPORTIONS= 40;


    public static final String FREE = "FREE";
    public static final String PREMIUM = "PREMIUM";

    public static final String BUS = "BUS";
    public static final String PLANE = "PLANE";
    public static final String TRAIN = "TRAIN";

    public static final String FINGERPRINT = "FINGERPRINT";
    public static final String CREDITCARD = "CREDITCARD";
    public static final String PAYPAL = "PAYPAL";
    public static final String WALLET = "WALLET";
    public static final String POINTS = "POINTS";





    // PRIVATE //

    /**
     The caller references the constants using <tt>Consts.EMPTY_STRING</tt>,
     and so on. Thus, the caller should be prevented from constructing objects of
     this class, by declaring this private constructor.
     */
    private Constants(){
        //this prevents even the native class from
        //calling this ctor as well :
        throw new AssertionError();
    }
}


