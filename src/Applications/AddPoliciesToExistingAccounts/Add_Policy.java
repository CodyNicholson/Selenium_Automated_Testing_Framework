package Applications.AddPoliciesToExistingAccounts;

import WebpageMethods.EPC_Methods._EPC_Master_Methods;

import java.util.ArrayList;
import java.util.List;
import Users.strategyContext;

/**
 * Created by cad5124 on 12/8/2016.
 */

public class Add_Policy
{
    private _EPC_Master_Methods user = new _EPC_Master_Methods();
    private strategyContext strategy = new strategyContext();
    private String _envURL;
    private String _userName;
    private String _accountNumber;
    private String _sicCode;
    private String _distributorCode;
    private String _businessArea;
    private String _policyPrefix;
    private String _underwriterCID;

    public Add_Policy(int r)
    {
        ArrayList<List<String>> policyData = user.readExcelFileRows(strategy.createPolicyPath());
        this._envURL = policyData.get(r).get(0);
        this._userName = policyData.get(r).get(1);
        this._accountNumber = policyData.get(r).get(2);
        this._sicCode = policyData.get(r).get(3);
        this._distributorCode = policyData.get(r).get(4);
        this._businessArea = policyData.get(r).get(5);
        this._policyPrefix = policyData.get(r).get(6);
        this._underwriterCID = policyData.get(r).get(7);
        System.out.println(this._envURL + " " + this._userName + " " + this._accountNumber + " " + this._sicCode + " " + this._distributorCode + " " + this._businessArea + " " + this._policyPrefix + " " + this._underwriterCID);
    }

    public void addPolicyToExistingAccount(String eteEnvURL, String userName, String accountNumber, String sicCode, String distributorCode, String businessArea, String policyPrefix, String underwriterCID)
    {
        user.goToEpcEnvAndLogin(eteEnvURL, userName);
        user.clickSearchTab();
        user.Search.clickAccountsTabOnSearchSidePanel();
        user.Search.setAccountNumAndSearchInAccountSearch(accountNumber);
        user.Search.clickFirstAccountNumberOnSearchAccountPageResults();
        user.Account.clickActionsDropDownMenuFromAccount();
        user.Account.clickNewSubmissionInActionsDropDownMenuOnAccount();
        user.Account.clickSicCodeSearchIconOnNewSubmissions();
        user.Account.setSicCodeInSicCodeSearch(sicCode);
        user.Account.clickSearchButtonInSicCodeSearch();
        user.Account.clickFirstSelectButtonOnSicCodeSearchTable();
        user.Account.clickDistributorNameSearchIconOnNewSubmissions();
        user.Account.setDistributorCodeInSicCodeSearch(distributorCode);
        user.Account.clickSearchButtonInDistributorSearch();
        user.Account.clickFirstSelectButtonOnDistributorSearchTable();
        user.Account.selectBusinessAreaInNewSubmissions(businessArea);
        user.Account.setCNAReceivedDateOnNewSubmissions(user.getCurrentDate());
        user.Account.setDefaultEffectiveDateOnNewSubmissions(user.getCurrentDatePlusOneDayPlusOneYear());
        user.Account.setExpirationDateOnNewSubmissions(user.getCurrentDatePlusOneDayPlusOneYear());
        user.Account.clickUnderwriterSearchIcon();
        user.Account.setCIDInSearchUsers(underwriterCID);
        user.Account.clickSearchButtonInSearchUsers();
        user.Account.clickSelectBtnFirstUserOnSearchUsersTable();
        user.Account.clickAddForPolicyPrefix(policyPrefix);
        user.Account.clickSubmitOnNewSubmissions();
        user.closeBrowser();
    }

    public ArrayList<List<String>> getInputDataFromExcel()
    {
        return user.readExcelFileRows(strategy.createAccountPath());
    }

    public String get_envURL() {
        return _envURL;
    }

    public String get_userName() {
        return _userName;
    }

    public String get_accountNumber() {
        return _accountNumber;
    }

    public String get_sicCode() {
        return _sicCode;
    }

    public String get_distributorCode() {
        return _distributorCode;
    }

    public String get_businessArea() {
        return _businessArea;
    }

    public String get_policyPrefix() {
        return _policyPrefix;
    }

    public String get_underwriterCID() {
        return _underwriterCID;
    }
}