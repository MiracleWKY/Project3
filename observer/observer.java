package observer;

import java.util.Hashtable;
import java.util.List;

import customer.customer;
import factory.roll;

public interface observer 
{
    public void announce_day(int day);
    public void announce_inventry(Hashtable<String, List<roll>> inventry);
    public void announce_action(customer c, double cost);
}
