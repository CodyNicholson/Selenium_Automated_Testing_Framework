package Users;

import Users.strategies.codyStrategy;

/**
 * Created by cad6025 on 2/2/2017.
 */

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

    public String createAccountPath() {
        return strategy.getCreateAccountPath();
    }

    public String createPolicyPath() {
        return strategy.getCreatePolicyPath();
    }

    public String addDocumentPath()
    {
        return strategy.getAddDocumentPath();
    }

    public String createTestResultSpreadsheetPath()
    {
        return strategy.getCreateTestResultSpreadsheetPath();
    }

    public String TestCheckInCheckOutPath_DMF_Smoke_Test()
    {
        return strategy.getTestCheckInCheckOutPath_DMF_Smoke_Test();
    }

    public String TestDistributePath_DMF_Smoke_Test() { return strategy.getTestDistributePath_DMF_Smoke_Test(); }
}
