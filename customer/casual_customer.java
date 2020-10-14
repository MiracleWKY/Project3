package customer;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import factory.*;
import store.store;

public class casual_customer extends customer
{
    public casual_customer(store s) 
    {
        super(s);
    }
    public List<String> generate_order()
    {
        Random rand = new Random(); 
        int num = rand.nextInt(3);
        for(int i = 0; i <= num; i++)
        {
            Hashtable<String, List<roll>> inventry = new Hashtable<String, List<roll>>();
            inventry = this.s.check_inventry();
            if(inventry.keySet().size() == 0)
            {
                break;
            }
            List<String> keysAsArray = new ArrayList<String>(inventry.keySet());
            

            String item = keysAsArray.get(rand.nextInt(keysAsArray.size()));
            int num_sauce = rand.nextInt(4);
            int num_filling = rand.nextInt(2);
            int num_topping = rand.nextInt(3);
            this.rolls.add(s.sell(item,num_sauce,num_filling,num_topping));
            this.order.add(item);
            
        }
        return this.order;
    }
}
