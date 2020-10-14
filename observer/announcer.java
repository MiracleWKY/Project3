package observer;

import java.util.Hashtable;
import java.util.List;

import customer.customer;
import factory.roll;

public class announcer implements observer
{
    public void announce_day(int day)
    {
        System.out.println("------------------------------------------");
        System.out.printf("Day %d\n", day);
    }
    public void announce_inventry(Hashtable<String, List<roll>> inventry)
    {
        System.out.println("------------------------------------------");
        System.out.println("Inventry:");
        if(inventry.get("spring_roll") != null)
        {
            System.out.printf("Number of Spring Roll: %d\n", inventry.get("spring_roll").size());
        }
        if(inventry.get("egg_roll") != null)
        {
            System.out.printf("Number of Egg Roll: %d\n", inventry.get("egg_roll").size());
        }
        if(inventry.get("pastry_roll") != null)
        {
            System.out.printf("Number of Pastry Roll: %d\n", inventry.get("pastry_roll").size());
        }
        if(inventry.get("sausage_roll") != null)
        {
            System.out.printf("Number of Sausage Roll: %d\n", inventry.get("sausage_roll").size());
        }
        if(inventry.get("jelly_roll") != null)
        {
            System.out.printf("Number of Jelly Roll: %d\n", inventry.get("jelly_roll").size());
        }
    }
    public void announce_action(customer c)
    {
        System.out.println("------------------------------------------");
        System.out.printf("%s is buying ", c.getClass().getName());
        System.out.println(c.order);
    }
    public void announce_out(String type)
    {
        System.out.println("------------------------------------------");
        System.out.printf("%s is out of stock.\n", type);
    }
}
