package coco.coconutreserve.assets.core;

public class Constants {
    public static final int CINEMA = 0;
    public static final int TRANSPORTION = 1;
    public static final int HOTEL = 2;

    public static final int NUM_OF_CINEMAS = 5;
    public static final int NUM_OF_HOTELS= 5;
    public static final int NUM_OF_TRANSPORTIONS= 5;

    public static final String BUS = "BUS";
    public static final String PLANE = "PLANE";
    public static final String TRAIN = "TRAIN";





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


