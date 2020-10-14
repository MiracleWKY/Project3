package customer;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import factory.*;
import store.store;

public class catering_customer extends customer
{
    public catering_customer(store s)
    {
        super(s);
    }
    public List<String> generate_order()
    {
        Random rand = new Random(); 

        Hashtable<String, List<roll>> inventry = new Hashtable<String, List<roll>>();
        inventry = this.s.check_inventry();
        List<String> keysAsArray = new ArrayList<String>(inventry.keySet());
        if(keysAsArray.size() >= 3)
        {
            int count = 0;
            List<String> l  = new ArrayList<String>();
            for(int i = 0; i < keysAsArray.size(); i++)
            {
                if(inventry.get(keysAsArray.get(i)).size()>=5)
                {
                    count ++;
                    l.add(keysAsArray.get(i));
                }
            }
            //System.out.println(l);
            if(count >= 3)
            {
                while(l.size()>3)
                {
                    l.remove(rand.nextInt(l.size()));
                }
                //System.out.println(l);
                for(int i = 0; i < l.size(); i++)
                {
                    for(int j = 0; j < 5; j++)
                    {
                        int num_sauce = rand.nextInt(4);
                        int num_filling = rand.nextInt(2);
                        int num_topping = rand.nextInt(3);
                        this.rolls.add(s.sell(l.get(i),num_sauce,num_filling,num_topping));
                        this.order.add(l.get(i));
                    }
                }
                return this.order;
            }
        }
        while(this.order.size() < 15)
        {
            inventry = new Hashtable<String, List<roll>>();
            inventry = this.s.check_inventry();
            if(inventry.keySet().size() == 0)
            {
                break;
            }
            keysAsArray = new ArrayList<String>(inventry.keySet());
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
