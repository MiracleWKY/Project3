package customer;

import java.util.ArrayList;
import java.util.List;

import decorator.decorated_roll;
import store.store;

public abstract class customer
{
    public store s;
    public List<String> order  = new ArrayList<String>();
    public List<decorated_roll> rolls  = new ArrayList<decorated_roll>();
    public customer(store s)
    {
        this.s = s;
    }
	public List<String> generate_order() {
        return null;
	}
}