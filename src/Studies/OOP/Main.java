package Studies.OOP;

/**
 * Created by CAD5124 on 12/29/2016.
 */
public class Main
{
    public static void main(String[] args)
    {
        Hamburger hamburger = new Hamburger("Basic", "Sausage", 3.56, "White");
        double price = hamburger.itemizeHamburger();
        hamburger.addHamburgerAddition1("Tomato", 0.27);
        hamburger.addHamburgerAddition2("Lettuce", 0.75);
        hamburger.addHamburgerAddition3("Cheese", 2.13);
        hamburger.itemizeHamburger();

        HealthyBurger hb = new HealthyBurger("Bacon", 5.67);
        hb.addHealthyAddition1("Egg", 5.43);
        hb.addHealthyAddition2("Lentils", 3.41);
        hb.itemizeHamburger();

        DeluxeBurger db = new DeluxeBurger();
        db.addHamburgerAddition1("Should not be able to do this", 600.0);
        db.itemizeHamburger();
    }
}
