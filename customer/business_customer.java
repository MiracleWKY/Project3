package customer;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import factory.*;
import store.store;

public class business_customer extends customer
{
    public business_customer(store s)
    {
        super(s);
    }
    public List<String> generate_order()
    {
        Random rand = new Random(); 

        Hashtable<String, List<roll>> inventry = new Hashtable<String, List<roll>>();
        inventry = this.s.check_inventry();
        List<String> keysAsArray = new ArrayList<String>(inventry.keySet());
        if(keysAsArray.size() < 5)
        {
            System.out.println("Inventry not satified by the Business Customer.");
            return this.order;
        }
        for(int i = 0; i < keysAsArray.size(); i++)
        {
            String name = keysAsArray.get(i);
            if(inventry.get(name).size() < 2)
            {
                System.out.println("Inventry not satified by the Business Customer.");
                return this.order;
            }
        }

        for(int i = 0; i < keysAsArray.size(); i++)
        {
            String name = keysAsArray.get(i);
            int num_sauce = rand.nextInt(4);
            int num_filling = rand.nextInt(2);
            int num_topping = rand.nextInt(3);
            this.rolls.add(s.sell(name,num_sauce,num_filling,num_topping));
            this.order.add(name);

            num_sauce = rand.nextInt(4);
            num_filling = rand.nextInt(2);
            num_topping = rand.nextInt(3);
            this.rolls.add(s.sell(name,num_sauce,num_filling,num_topping));
            this.order.add(name);
        }
        return this.order;
    }
}
