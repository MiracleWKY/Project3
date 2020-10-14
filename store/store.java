package store;

import factory.roll_factory;
import observer.announcer;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import decorator.decorated_roll;
import factory.roll;


public class store 
{
    public String name;
    public roll_factory f;
    public Hashtable<String, List<roll>> inventry = new Hashtable<String, List<roll>>();
    public List<roll> spring_list  = new ArrayList<roll>();
    public List<roll> egg_list  = new ArrayList<roll>();
    public List<roll> pastry_list  = new ArrayList<roll>();
    public List<roll> sausage_list  = new ArrayList<roll>();
    public List<roll> jelly_list  = new ArrayList<roll>();
    
    public double p_spring;
    public double p_egg;
    public double p_pastry;
    public double p_sausage;
    public double p_jelly;
    public announcer a;

    public store(String name, roll_factory f, double p1, double p2, double p3, double p4, double p5)
    {
        this.name = name;
        this.f = f;
        this.p_spring = p1;
        this.p_egg = p2;
        this.p_pastry = p3;
        this.p_sausage = p4;
        this.p_jelly = p5;
        this.a = new announcer();

        inventry.put("spring_roll", spring_list);
        inventry.put("egg_roll", egg_list);
        inventry.put("pastry_roll", pastry_list);
        inventry.put("sausage_roll", sausage_list);
        inventry.put("jelly_roll", jelly_list);
    }
    public void prepare_rolls(int num_spring, int num_egg, int num_pastry, int num_sausage, int num_jelly)
    {
        int id = 1;
        for(int i = 0; i < num_spring; i++)
        {
            if(inventry.get("spring_roll") == null)
            {
                inventry.put("spring_roll", spring_list);
            }
            inventry.get("spring_roll").add(f.make_roll("spring_roll", id, p_spring));
            id++;
        }
        for(int i = 0; i < num_egg; i++)
        {
            if(inventry.get("egg_roll") == null)
            {
                inventry.put("egg_roll", egg_list);
            }
            inventry.get("egg_roll").add(f.make_roll("egg_roll", id, p_egg));
            id++;
        }
        for(int i = 0; i < num_pastry; i++)
        {
            if(inventry.get("pastry_roll") == null)
            {
                inventry.put("pastry_roll", pastry_list);
            }
            inventry.get("pastry_roll").add(f.make_roll("pastry_roll", id, p_pastry));
            id++;
        }
        for(int i = 0; i < num_sausage; i++)
        {
            if(inventry.get("sausage_roll") == null)
            {
                inventry.put("sausage_roll", sausage_list);
            }
            inventry.get("sausage_roll").add(f.make_roll("sausage_roll", id, p_sausage));
            id++;
        }
        for(int i = 0; i < num_jelly; i++)
        {
            if(inventry.get("jelly_roll") == null)
            {
                inventry.put("jelly_roll", jelly_list);
            }
            inventry.get("jelly_roll").add(f.make_roll("jelly_roll", id, p_jelly));
            id++;
        }
    }
    public Hashtable<String, List<roll>> check_inventry()
    {
        if(inventry.get("spring_roll") != null)
        {
            if(inventry.get("spring_roll").size() == 0)
            {
                inventry.remove("spring_roll");
                this.a.announce_out("spring_roll");
            }
        }
        if(inventry.get("egg_roll") != null)
        {
            if(inventry.get("egg_roll").size() == 0)
            {
                inventry.remove("egg_roll");
                this.a.announce_out("egg_roll");
            }
        }
        if(inventry.get("pastry_roll") != null)
        {
            if(inventry.get("pastry_roll").size() == 0)
            {
                inventry.remove("pastry_roll");
                this.a.announce_out("pastry_roll");
            }
        }
        if(inventry.get("sausage_roll") != null)
        {
            if(inventry.get("sausage_roll").size() == 0)
            {
                inventry.remove("sausage_roll");
                this.a.announce_out("sausage_roll");
            }
        }
        if(inventry.get("jelly_roll") != null)
        {
            if(inventry.get("jelly_roll").size() == 0)
            {
                inventry.remove("jelly_roll");
                this.a.announce_out("jelly_roll");
            }
        }
        
        return this.inventry;
    }
    public decorated_roll sell(String item, int num_sauce, int num_filling, int num_topping)
    {
        roll r = inventry.get(item).remove(0);
        decorated_roll rd = new decorated_roll(r.id, r.price, r);
        for(int i = 0; i < num_sauce && i <= 3; i++)
        {
            rd.add_sauce();
        }
        for(int i = 0; i < num_filling && i <= 1; i++)
        {
            rd.add_filling();
        }
        for(int i = 0; i < num_topping && i <= 2; i++)
        {
            rd.add_topping();
        }
        return rd;
    }
}
