package Results.Results_Generator;

/**
 * Created by cad5124 on 1/6/2017.
 */
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import  org.apache.poi.hssf.usermodel.HSSFCellStyle;
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import  org.apache.poi.hssf.usermodel.HSSFRow;

import Users.strategyContext;
import org.apache.poi.hssf.util.HSSFColor;

public class Results_Generator
{
    private static strategyContext strategy = new strategyContext();
    private static String testSuiteName = "";

    //Test Data
    private ArrayList<String> testCaseNames     = new ArrayList<>();
    private ArrayList<String> testCaseParents   = new ArrayList<>();
    private ArrayList<String> testCaseResults   = new ArrayList<>();
    private ArrayList<String> testCaseRuntimes  = new ArrayList<>();
    private String totalRuntime = "";

    public String createTestResultsSpreadsheet()
    {
        try
        {
            //Get Date
            DateFormat timeFormat = new SimpleDateFormat("HHmm");
            Date timeObj = new Date();
            String time = timeFormat.format(timeObj);

            //Create excel file with date included in the title
            String fileName = strategy.getTestResultPath() + testSuiteName + "_" + time + ".xls" ;

            //Create the workbook and sheet
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet(testSuiteName + " Test Results");

            /*****************
            ***   Styles   ***
            *****************/

            //Set Header Cell Style
            HSSFCellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
            headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
            headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
            headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);

            // Set Failure style
            HSSFCellStyle failureStyle = workbook.createCellStyle();
            failureStyle.setFillForegroundColor(HSSFColor.RED.index);
            failureStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            failureStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            failureStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
            failureStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
            failureStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);

            // Set Pass style
            HSSFCellStyle passStyle = workbook.createCellStyle();
            passStyle.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
            passStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            passStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            passStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
            passStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
            passStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);

            // Set Failure wordwrap style
            HSSFCellStyle failureWrapStyle = workbook.createCellStyle();
            failureWrapStyle.setFillForegroundColor(HSSFColor.RED.index);
            failureWrapStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            failureWrapStyle.setWrapText(true);
            failureWrapStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            failureWrapStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
            failureWrapStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
            failureWrapStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);

            // Set Failure numeric style
            HSSFCellStyle failureStyleInteger = workbook.createCellStyle();
            failureStyleInteger.setFillForegroundColor(HSSFColor.RED.index);
            failureStyleInteger.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            failureStyleInteger.setDataFormat(workbook.createDataFormat().getFormat("0"));
            failureStyleInteger.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            failureStyleInteger.setBorderTop(HSSFCellStyle.BORDER_THIN);
            failureStyleInteger.setBorderRight(HSSFCellStyle.BORDER_THIN);
            failureStyleInteger.setBorderLeft(HSSFCellStyle.BORDER_THIN);

            // Set Percent Style
            HSSFCellStyle percentStyle = workbook.createCellStyle();
            percentStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
            percentStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            percentStyle.setDataFormat(workbook.createDataFormat().getFormat("0.0%"));
            percentStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            percentStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
            percentStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
            percentStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);

            // Set Header Numeric Style
            HSSFCellStyle headerIntegerStyle = workbook.createCellStyle();
            headerIntegerStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
            headerIntegerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            headerIntegerStyle.setDataFormat(workbook.createDataFormat().getFormat("0"));
            headerIntegerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            headerIntegerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
            headerIntegerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
            headerIntegerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);

            // Set Numeric Style
            HSSFCellStyle integerStyle = workbook.createCellStyle();
            integerStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
            integerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            integerStyle.setDataFormat(workbook.createDataFormat().getFormat("0"));
            integerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            integerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
            integerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
            integerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);

            /***********************
            ***   Row Creation   ***
            ***********************/

            //Create the header row
            HSSFRow rowHead = sheet.createRow(0);
            rowHead.createCell(0).setCellValue("Parent ID");
            rowHead.createCell(1).setCellValue("Name");
            rowHead.createCell(2).setCellValue("Pass/Fail");
            rowHead.createCell(3).setCellValue("Runtime (Sec)");
            rowHead.createCell(4).setCellValue("Failure Details");
            rowHead.createCell(5).setCellValue("Comments");
            rowHead.getCell(0).setCellStyle(headerStyle);
            rowHead.getCell(1).setCellStyle(headerStyle);
            rowHead.getCell(2).setCellStyle(headerStyle);
            rowHead.getCell(3).setCellStyle(headerStyle);
            rowHead.getCell(4).setCellStyle(headerStyle);
            rowHead.getCell(5).setCellStyle(headerStyle);

            //Create test case rows
            int rowNumber;
            String passFailString;
            for(rowNumber = 1; rowNumber <= testCaseNames.size(); rowNumber++)
            {
                passFailString = (testCaseResults.get(rowNumber-1).equals("N/A")) ? "pass" : "fail";
                addTestRow(rowNumber, sheet, testCaseParents.get(rowNumber-1), testCaseNames.get(rowNumber-1), passFailString, testCaseRuntimes.get(rowNumber-1), testCaseResults.get(rowNumber-1), failureStyle, passStyle, failureWrapStyle);
            }

            // Create Percent Pass Row
            HSSFRow rowTail = sheet.createRow(rowNumber);
            rowTail.createCell(0).setCellValue("Pass %");
            rowTail.createCell(1).setCellFormula("COUNTIF(C2:C"+rowNumber+",\"pass\")/(COUNTIF(C2:C"+rowNumber+",\"pass\")+COUNTIF(C2:C"+rowNumber+",\"fail\"))");
            rowTail.createCell(2).setCellValue("Total runtime");
            rowTail.createCell(3).setCellValue(totalRuntime);
            rowTail.createCell(4).setCellValue("Total # of Tests");
            rowTail.createCell(5).setCellValue(testCaseNames.size());
            rowTail.getCell(0).setCellStyle(headerStyle);
            rowTail.getCell(1).setCellStyle(percentStyle);
            rowTail.getCell(2).setCellStyle(headerStyle);
            rowTail.getCell(3).setCellStyle(headerIntegerStyle);
            rowTail.getCell(4).setCellStyle(headerStyle);
            rowTail.getCell(5).setCellStyle(headerStyle);

            // Auto-size all the columns
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.setColumnWidth(4,10000);
            sheet.setColumnWidth(5,8000);

            //Write all the data to the file and close
            FileOutputStream fileOut = new FileOutputStream(fileName);
            workbook.write(fileOut);
            fileOut.close();
            System.out.println("Your test results file has been generated");
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
        return "test documented";
    }

    /*************************
    ***   Helper Methods   ***
    *************************/

    private void addTestRow(int testIndex, HSSFSheet sheet, String parent, String testName, String passFailString, String runtime, String results, HSSFCellStyle failureStyle, HSSFCellStyle passStyle, HSSFCellStyle failWrapStyle)
    {
        results = results.equals("") ? "Issues with server latency, manual check may be required" : results;

        HSSFRow row = sheet.createRow(testIndex);

        row.createCell(0).setCellValue(parent);
        row.createCell(1).setCellValue(testName);
        row.createCell(2).setCellValue(passFailString);
        row.createCell(3).setCellValue(runtime);
        row.createCell(4).setCellValue(results);
        row.createCell(5).setCellValue("");

        if (passFailString.equals("pass"))
        {
            row.getCell(0).setCellStyle(passStyle);
            row.getCell(1).setCellStyle(passStyle);
            row.getCell(2).setCellStyle(passStyle);
            row.getCell(3).setCellStyle(passStyle);
            row.getCell(4).setCellStyle(passStyle);
            row.getCell(5).setCellStyle(passStyle);
        }
        else
        {
            row.getCell(0).setCellStyle(failureStyle);
            row.getCell(1).setCellStyle(failureStyle);
            row.getCell(2).setCellStyle(failureStyle);
            row.getCell(3).setCellStyle(failureStyle);
            row.getCell(4).setCellStyle(failWrapStyle);
            row.getCell(5).setCellStyle(failureStyle);
        }
    }

    public void setClassName(String fullClassName)
    {
        //Split string into tokens
        String[] tokens = fullClassName.split("[.]+");

        // Get last token as final className
        String className = tokens[tokens.length - 1];

        // Return the name
        testSuiteName = className;
    }

    /********************
    ***   Accessors   ***
    ********************/

    public ArrayList<String> getTestCaseNames() {
        return testCaseNames;
    }

    public ArrayList<String> getTestCaseParents() {
        return testCaseParents;
    }

    public ArrayList<String> getTestCaseResults() {
        return testCaseResults;
    }

    public ArrayList<String> getTestCaseRuntimes() {
        return testCaseRuntimes;
    }

    public void setTotalRuntime(String totalRuntime) {
        this.totalRuntime = totalRuntime;
    }

    public static void main(String[] args)
    {
        Results_Generator creator = new Results_Generator();
    }
}
