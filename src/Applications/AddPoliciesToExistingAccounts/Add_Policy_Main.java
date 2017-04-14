package Applications.AddPoliciesToExistingAccounts;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import Users.strategyContext;

/**
 * Created by cad5124 on 12/27/2016.
 */
public class Add_Policy_Main
{
    public static void main(String[] args)
    {
        //strategyContext strategy = new strategyContext(new codyStrategy());
        strategyContext strategy = new strategyContext();
        // Declare a variable to keep track of runtime
        long time = System.currentTimeMillis();

        // Get Number Of Accounts To Create
        int numPolicies = getRowCountFromExcelFile(strategy.createPolicyPath());

        for(int i = 0; i < numPolicies; i++)

        {
            // Create an AccountCreating Object
            Add_Policy accountCreatingObject = new Add_Policy(i);

            // Enter Account Creation Info Below
            String environmentURL = accountCreatingObject.get_envURL();
            String userName = accountCreatingObject.get_userName();
            String accountNumber = accountCreatingObject.get_accountNumber();
            String sicCode = accountCreatingObject.get_sicCode();
            String distributorCode = accountCreatingObject.get_distributorCode();
            String businessArea = accountCreatingObject.get_businessArea();
            String policyPrefix = accountCreatingObject.get_policyPrefix();
            String underwriterCID = accountCreatingObject.get_underwriterCID();

            try
            {
                // Use the Account Creating Object to Create Account and Add Policies
                accountCreatingObject.addPolicyToExistingAccount(environmentURL, userName, accountNumber, sicCode,
                        distributorCode, businessArea, policyPrefix, underwriterCID);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("Failed for the policy at row " + (i + 1) + ". Maybe there is a typo in the input data you put in the Excel sheet.");
            }
        }

        // Calculate runtime
        time = (System.currentTimeMillis() - time) / 1000;
        System.out.println("The program's runtime in seconds was: " + time);
    }

    public static int getRowCountFromExcelFile(String file)
    {
        try
        {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            HSSFCell cell;
            int physicalRows = sheet.getPhysicalNumberOfRows() - 1;
            int numberOfRows = 0;
            for(int r = 1; r <= physicalRows; r++)
            {
                row = sheet.getRow(r);
                if(row != null)
                {
                    cell = row.getCell(1);
                    if(cell == null || cell.toString().equals(""))
                    {
                        break;
                    }
                }
                numberOfRows++;
            }
            System.out.println("Adding " + numberOfRows + " policies in total across one or more accounts");
            return numberOfRows;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Could not find Excel doc at: " + file);
        }
        return 0;
    }
}
