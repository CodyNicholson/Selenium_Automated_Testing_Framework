package Applications.CreateAccount;

import WebpageMethods.EPC_Methods._EPC_Master_Methods;

import java.util.ArrayList;
import java.util.List;
import Users.strategyContext;

/**
 * Created by cad5124 on 12/8/2016.
 */

public class Create_Account
{
    private _EPC_Master_Methods user = new _EPC_Master_Methods();
    private strategyContext strategy = new strategyContext();
    private String _envURL;
    private String _userName;
    private String _accountName;
    private String _street;
    private String _city;
    private String _state;
    private String _zipCode;
    private String _sicCode;
    private String _distributorCode;
    private String _businessArea;
    private String _policyPrefix;
    private String _underwriterCID;

    public Create_Account(int r)
    {
        ArrayList<List<String>> accountData = user.readExcelFileRows(strategy.createAccountPath());
        this._envURL = accountData.get(r).get(0);
        this._userName = accountData.get(r).get(1);
        this._accountName = accountData.get(r).get(2);
        this._street = accountData.get(r).get(3);
        this._city = accountData.get(r).get(4);
        this._state = accountData.get(r).get(5);
        this._zipCode = accountData.get(r).get(6);
        this._sicCode = accountData.get(r).get(7);
        this._distributorCode = accountData.get(r).get(8);
        this._businessArea = accountData.get(r).get(9);
        this._policyPrefix = accountData.get(r).get(10);
        this._underwriterCID = accountData.get(r).get(11);
        System.out.println(this._envURL + " " + this._accountName + " " + this._street + " " + this._city + " " + this._state + " " + this._zipCode + " " + this._sicCode + " " + this._distributorCode + " " + this._policyPrefix + " " + this._underwriterCID);
    }

    public void createAccountWithPolicy(String envURL, String userName, String accountName, String street, String city, String state, String zipCode, String sicCode, String distributorCode, String businessArea, String policyPrefix, String underwriterCID)
    {
        user.goToEpcEnvAndLogin(envURL, userName);
        user.clickActionsDropDownMenuFromDesktop();
        user.clickNewSubmissionInActionsDropDownMenuOnDesktop();
        user.Account.clickSearchOnEnterAccountInfoPage();
        user.Account.clickCreateNewAccountMenuOnAccountInfoPage();
        user.Account.clickCompanyInCreateNewAccountMenuOnEnterAccountIntoPage();
        user.Account.setAccountHolderNameInCreateAccount(accountName);
        user.Account.setAddressLine1InCreateAccount(street);
        user.Account.setCityInCreateAccount(city);
        user.Account.selectStateInCreateAccount(state);
        user.Account.setZipCodeOnCreateAccount(zipCode);
        user.Account.clickStandardizeAddressBtnOnCreateAccount();
        user.Account.clickSicCodeSearchIconOnCreateAccount();
        user.Account.setSicCodeInSicCodeSearch(sicCode);
        user.Account.clickSearchButtonInSicCodeSearch();
        user.Account.clickFirstSelectButtonOnSicCodeSearchTable();
        user.Account.clickDistributorNameSearchIconOnCreateAccount();
        user.Account.setDistributorCodeInSicCodeSearch(distributorCode);
        user.Account.clickSearchButtonInDistributorSearch();
        user.Account.clickFirstSelectButtonOnDistributorSearchTable();
        user.Account.clickUpdateButtonOnCreateAccount();
        user.Account.selectBusinessAreaInNewSubmissions(businessArea);
        user.Account.setCNAReceivedDateOnNewSubmissions(user.getCurrentDate());
        user.Account.setDefaultEffectiveDateOnNewSubmissions(user.getCurrentDatePlusOneDayPlusOneYear());
        user.Account.setExpirationDateOnNewSubmissions(user.getCurrentDatePlusOneDayPlusOneYear());
        user.Account.clickUnderwriterSearchIcon();
        user.Account.setCIDInSearchUsers(underwriterCID);
        user.Account.clickSearchButtonInSearchUsers();
        user.Account.clickSelectBtnFirstUserOnSearchUsersTable();
        // CLICK OVERRIDE
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

    public String get_accountName() {
        return _accountName;
    }

    public String get_street() {
        return _street;
    }

    public String get_city() {
        return _city;
    }

    public String get_state() {
        return _state;
    }

    public String get_zipCode() {
        return _zipCode;
    }

    public String get_sicCode() {
        return _sicCode;
    }

    public String get_distributorCode() {
        return _distributorCode;
    }

    public String get_policyPrefix() {
        return _policyPrefix;
    }

    public String get_underwriterCID() {
        return _underwriterCID;
    }

    public String get_userName() {
        return _userName;
    }

    public String get_businessArea() {
        return _businessArea;
    }
}