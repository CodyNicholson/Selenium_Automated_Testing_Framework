package Studies.OOP;

/**
 * Created by CAD5124 on 12/29/2016.
 */
public class HealthyBurger extends Hamburger
{
    private String healthyBurgerExtra1Name;
    private double healthyBurgerExtra1Price;

    private String healthyBurgerExtra2Name;
    private double healthyBurgerExtra2Price;

    public HealthyBurger(String meat, double price)
    {
        super("Healthy", meat, price, "Brownrye");
    }

    public void addHealthyAddition1(String name, double price)
    {
        this.healthyBurgerExtra1Name = name;
        this.healthyBurgerExtra1Price = price;
    }

    public void addHealthyAddition2(String name, double price)
    {
        this.healthyBurgerExtra2Name = name;
        this.healthyBurgerExtra2Price = price;
    }

    @Override
    public double itemizeHamburger() {
        double hamburgerPrice = super.itemizeHamburger();
        if(this.healthyBurgerExtra1Name != null)
        {
            hamburgerPrice += this.healthyBurgerExtra1Price;
            System.out.println("Adding the " + this.healthyBurgerExtra1Name + " costs " + healthyBurgerExtra1Price +
                    " and brings the total price to " + hamburgerPrice);
        }
        if(this.healthyBurgerExtra2Name != null)
        {
            hamburgerPrice += this.healthyBurgerExtra2Price;
            System.out.println("Adding the " + this.healthyBurgerExtra2Name + " costs " + healthyBurgerExtra2Price +
                    " and brings the total price to " + hamburgerPrice);
        }
        System.out.println("Total hamburger price is now: " + hamburgerPrice);
        return hamburgerPrice;
    }
}
