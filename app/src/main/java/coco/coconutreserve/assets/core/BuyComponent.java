package coco.coconutreserve.assets.core;

public class BuyComponent
{
    public boolean buy(Wallet wallet,Reservation reservation)
    {
        if (wallet.getAmount() >= reservation.getPrice())
        {
            if (wallet.subFunds(reservation.getPrice()))
            {
                reservation.setAsPaid();
                return true;
            }
        }
        return false;
    }

    public boolean buy(String paymentType, Reservation reservation)
    {
        if (paymentType.equals(Constants.FINGERPRINT) || paymentType.equals(Constants.CREDITCARD) ||
                paymentType.equals(Constants.PAYPAL))
        {
            reservation.setAsPaid();
            return true;
        }
        return false;
    }

    public boolean buyWithPoints(User user, Reservation reservation)
    {
        if (user.getAppType().equals( Constants.CINEMA )&& user.getUserType().equals(Constants.PREMIUM) &&
                reservation.getPlace() instanceof Cinema )
        {
            if (user.getPoints() >= reservation.getPrice())
            {
                user.subPoints(reservation.getPrice());
                reservation.setAsPaid();
                return true;
            }
        }
        return false;
    }

}
