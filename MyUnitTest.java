
import java.util.List;

import customer.business_customer;
import customer.casual_customer;
import customer.catering_customer;
import decorator.decorated_roll;
import factory.roll;
import factory.roll_factory;
import factory.spring_roll;
import store.store;

public class MyUnitTest 
{
    public static void test_decorator() 
    {
        System.out.println("Testing decorator...");
        roll roll_1 = new spring_roll(1, 1.99);
        decorated_roll roll_2 = new decorated_roll(roll_1.id, roll_1.price, roll_1);
        roll_2.add_filling();
        assert roll_2.get_price() > roll_1.price;
        System.out.println("OK.");
    }
    public static void test_prepare_roll() 
    {
        System.out.println("Testing prepare_roll function...");
        roll_factory f = new roll_factory("roll_factory");
        store s = new store("Roll_Shop", f, 2.99, 3.99, 4.99, 3.49, 2.49);
        s.prepare_rolls(10, 5, 5, 5, 5);
        assert s.inventry.size()==5;
        assert s.inventry.get("spring_roll").size()==10 : "error";
        assert s.inventry.get("jelly_roll").size()==5 : "error";
        System.out.println("OK.");
    }
    public static void test_sell() 
    {
        System.out.println("Testing sell function...");
        roll_factory f = new roll_factory("roll_factory");
        store s = new store("Roll_Shop", f, 2.99, 3.99, 4.99, 3.49, 2.49);
        s.prepare_rolls(10, 5, 5, 5, 5);
        s.sell("spring_roll", 1, 1, 1);
        assert s.inventry.get("spring_roll").size()==9;
        System.out.println("OK.");
    }
    public static void test_business_customer() 
    {
        System.out.println("Testing business_customer...");
        roll_factory f = new roll_factory("roll_factory");
        store s = new store("Roll_Shop", f, 2.99, 3.99, 4.99, 3.49, 2.49);
        s.prepare_rolls(10, 5, 5, 5, 5);
        business_customer b = new business_customer(s);
        b.generate_order();
        assert s.inventry.get("spring_roll").size()==8;
        System.out.println("OK.");
    }
    public static void test_business_customer2() 
    {
        System.out.println("Testing business_customer...");
        roll_factory f = new roll_factory("roll_factory");
        store s = new store("Roll_Shop", f, 2.99, 3.99, 4.99, 3.49, 2.49);
        s.prepare_rolls(1, 5, 5, 5, 5);
        business_customer b = new business_customer(s);
        List<String> order = b.generate_order();
        assert order.size()==0;
        System.out.println("OK.");
    }
    public static void test_catering_customer() 
    {
        System.out.println("Testing catering_customer...");
        roll_factory f = new roll_factory("roll_factory");
        store s = new store("Roll_Shop", f, 2.99, 3.99, 4.99, 3.49, 2.49);
        s.prepare_rolls(3, 6, 6, 6, 2);
        catering_customer c = new catering_customer(s);
        c.generate_order();
        assert s.inventry.get("spring_roll").size()==3;
        assert s.inventry.get("egg_roll").size()==1;
        System.out.println("OK.");
    }
    public static void test_catering_customer2() 
    {
        System.out.println("Testing catering_customer...");
        roll_factory f = new roll_factory("roll_factory");
        store s = new store("Roll_Shop", f, 2.99, 3.99, 4.99, 3.49, 2.49);
        s.prepare_rolls(3, 6, 6, 1, 2);
        catering_customer c = new catering_customer(s);
        List<String> order = c.generate_order();
        assert order.size() == 15;
        System.out.println("OK.");
    }
    public static void test_casual_customer() 
    {
        System.out.println("Testing casual_customer...");
        roll_factory f = new roll_factory("roll_factory");
        store s = new store("Roll_Shop", f, 2.99, 3.99, 4.99, 3.49, 2.49);
        s.prepare_rolls(0, 0, 0, 0, 1);
        casual_customer c = new casual_customer(s);
        c.generate_order();
        assert s.check_inventry().size()==0;
        System.out.println("OK.");
    }
    public static void test_factory() 
    {
        System.out.println("Testing factory...");
        roll_factory f = new roll_factory("roll_factory");
        roll r = f.make_roll("spring_roll", 1, 1.99);
        assert r.get_price() == 1.99;
        assert r.get_id() == 1;
        System.out.println("OK.");
    }
    public static void test_check_inventry() 
    {
        System.out.println("Testing check_inventry...");
        roll_factory f = new roll_factory("roll_factory");
        store s = new store("Roll_Shop", f, 2.99, 3.99, 4.99, 3.49, 2.49);
        s.prepare_rolls(3, 6, 6, 6, 2);
        assert s.check_inventry()==s.inventry;
        System.out.println("OK.");
    }
    public static void test_nested_decorator() 
    {
        System.out.println("Testing nested decorator...");
        roll roll_1 = new spring_roll(1, 1.99);
        decorated_roll roll_2 = new decorated_roll(roll_1.id, roll_1.price, roll_1);

        decorated_roll roll_3 = new decorated_roll(roll_2.id, roll_2.price, roll_2);
        assert roll_3.undecorated_roll.undecorated_roll.get_price() == roll_1.get_price();
        System.out.println("OK.");
    }
}