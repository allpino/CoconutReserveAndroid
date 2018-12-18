package assets.core;

public class Constants {
    public static final int CINEMA = 0;
    public static final int TRANSPORTION = 1;
    public static final int HOTEL = 2;

    public static final int NUM_OF_CINEMAS = 5;
    public static final int NUM_OF_HOTELS= 5;
    public static final int NUM_OF_TRANSPORTIONS= 5;

    public static final int BUS = Character.getNumericValue('B')+Character.getNumericValue('U')+
                                    Character.getNumericValue('S');
    public static final int PLANE = Character.getNumericValue('P') + Character.getNumericValue('L')+
                                    Character.getNumericValue('A');
    public static final int TRAIN = Character.getNumericValue('T') + Character.getNumericValue('R') +
                                    Character.getNumericValue('A');





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


