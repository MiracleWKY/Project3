package factory;

public abstract class roll
{
    public final roll undecorated_roll = null;
	public int id;
    public double price;
    public roll(int id, double price)
    {
        this.id = id;
        this.price = price;
    }
    public int get_id()
    {
        return this.id;
    }
    public double get_price()
    {
        return this.price;
    }
}