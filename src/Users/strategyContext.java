package Users;

import Users.strategies.codyStrategy;

public class strategyContext {

    /*********************************************
     ***                  Users                 ***
     *                                            *
     * Create your strategy                       *
     * Import your strategy                       *
     * Hot swap it as the parameter               *
     * for the new strategyContext object         *
     *                                            *
     ***                                        ***
     *********************************************/

    private userStrategyClass strategy = new codyStrategy();

    /*********************************************/

    public strategyContext()
    {
        this.strategy = strategy;
    }

    public String chromeApplicationPath()
    {
        return strategy.getChromeApplicationPath();
    }

    public String IEApplicationPath() {
        return strategy.getIEApplicationPath();
    }

    public String getTestResultPath()
    {
        return strategy.getTestResultsPath();
    }

}
