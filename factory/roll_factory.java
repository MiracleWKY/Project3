package factory;

public class roll_factory 
{
    public String name;
    public roll_factory(String name)
    {
        this.name = name;
    }
    public roll make_roll(String type, int id, double price)
    {
        if(type == "egg_roll")
        {
            roll r = new egg_roll(id, price);
            return r;
        }
        else if(type == "pastry_roll")
        {
            roll r = new pastry_roll(id, price);
            return r;
        }
        else if(type == "sausage_roll")
        {
            roll r = new sausage_roll(id, price);
            return r;
        }
        else if(type == "jelly_roll")
        {
            roll r = new jelly_roll(id, price);
            return r;
        }
        else
        {
            roll r = new spring_roll(id, price);
            return r;
        }
    }
}
