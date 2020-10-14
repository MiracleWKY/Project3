package decorator;
import factory.roll;

public class decorated_roll extends roll 
{
    public roll undecorated_roll;

    public int extra_sauce;
    public int extra_filling;
    public int extra_topping;

    public double price_sauce;
    public double price_filling;
    public double price_topping;

    public decorated_roll(int id, double price, roll r) 
    {
        super(id, price);
        this.undecorated_roll = r;
        this.extra_sauce = 0;
        this.extra_filling = 0;
        this.extra_topping = 0;

        this.price_sauce = 0.5;
        this.price_filling = 2.0;
        this.price_topping = 1.0;
    }
    public void add_sauce()
    {
        this.extra_sauce ++;
    }
    public void add_filling()
    {
        this.extra_filling ++;
    }
    public void add_topping()
    {
        this.extra_topping ++;
    }
    public double get_price()
    {
        return this.price_sauce*this.extra_sauce + this.price_filling*this.extra_filling + this.price_topping*this.extra_topping + this.price;
    }
}
