

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import customer.business_customer;
import customer.casual_customer;
import customer.catering_customer;
import customer.customer;
import factory.roll_factory;
import observer.announcer;
import store.store;

public class main
{
    public static void main(String[] args)
    {/*
        roll roll_1 = new spring_roll(1, 1.99);
        System.out.println(roll_1.get_id());
        roll_factory f = new roll_factory("roll_factory");
        String type = "egg_roll";
        int id = 2;
        double price = 1.99;
        roll roll_2 = f.make_roll(type, id, price);
        System.out.println(roll_2.get_id());
        store s = new store("Roll_Shop", f, 30, 30, 30, 30, 30);
        s.prepare_rolls(2, 2, 2, 2, 2);
        System.out.println(s.check_inventry());
        decorated_roll roll_2d = new decorated_roll(id, price, roll_2);
        roll_2d.add_sauce();
        System.out.println(roll_2d.get_price());
        List<roll> l  = new ArrayList<roll>();
        l.add(roll_2);
        System.out.println(l.remove(0));
        */

        Random rand = new Random();
        announcer a = new announcer();
        roll_factory f = new roll_factory("roll_factory");
        store s = new store("Roll_Shop", f, 2.99, 3.99, 4.99, 3.49, 2.49);
        s.prepare_rolls(30, 30, 30, 30, 30);

        for(int day = 0; day <= 30; day++)
        {
            a.announce_day(day);
            List<customer> customers  = new ArrayList<customer>();

            int num1 = rand.nextInt(12);
            int num2 = rand.nextInt(3);
            int num3 = rand.nextInt(3);

            int orders_count = 0;
            double income = 0.0;
            for(int i = 0; i <= num1; i++)
            {
                customer c = new casual_customer(s); 
                customers.add(c);
            }
            for(int i = 0; i <= num2; i++)
            {
                customer c = new business_customer(s); 
                customers.add(c);
            }
            for(int i = 0; i <= num3; i++)
            {
                customer c = new catering_customer(s); 
                customers.add(c);
            }
            while(customers.size()>0)
            {
                if(s.inventry.keySet().size() == 0)
                {
                    System.out.println("Store is closed due to out of inventry");
                    break;
                }
                //System.out.println(s.inventry.keySet().size());
                customer cust = customers.remove(rand.nextInt(customers.size()));
                List<String> order = cust.generate_order();
                double cost = 0;
                if(cust.rolls.size()>0)
                {
                    orders_count ++;
                    for(int i = 0; i<cust.rolls.size(); i++)
                    {
                        //System.out.println(cust.rolls);
                        cost += cust.rolls.get(i).get_price();
                    }
                }
                income += cost;
                    
                a.announce_action(cust, cost);
                s.check_inventry();
                //a.announce_inventry(s.inventry);
            }
            System.out.printf("This day tooks %d orders and earned a income of %f\n", orders_count, income);
            if(s.inventry.get("spring_roll") == null)
            {
                s.prepare_rolls(30, 0, 0, 0, 0);
            }
            if(s.inventry.get("egg_roll") == null)
            {
                s.prepare_rolls(0, 30, 0, 0, 0);
            }
            if(s.inventry.get("pastry_roll") == null)
            {
                s.prepare_rolls(0, 0, 30, 0, 0);
            }
            if(s.inventry.get("sausage_roll") == null)
            {
                s.prepare_rolls(0, 0, 0, 30, 0);
            }
            if(s.inventry.get("jelly_roll") == null)
            {
                s.prepare_rolls(0, 0, 0, 0, 30);
            }
        }
        
        store s_test = new store("Roll_Shop", f, 2.99, 3.99, 4.99, 3.49, 2.49);
        s_test.prepare_rolls(30, 30, 30, 30, 30);

        MyUnitTest.test_decorator();
        MyUnitTest.test_prepare_roll();
        MyUnitTest.test_sell();
        MyUnitTest.test_business_customer();
        MyUnitTest.test_business_customer2();
        MyUnitTest.test_catering_customer();
        MyUnitTest.test_catering_customer2();
        MyUnitTest.test_casual_customer();
        MyUnitTest.test_factory();
        MyUnitTest.test_check_inventry();
        
    }
}
