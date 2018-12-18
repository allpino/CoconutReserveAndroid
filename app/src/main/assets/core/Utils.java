package assets.core;

public final class Utils {

    public static int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    public static double randomWithRange(double min, double max)
    {
        double range = (max - min) + 1;
        return (Math.random() * range) + min;
    }
}
