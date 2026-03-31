import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmpWageBuilder implements IComputeEmpWage {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    private ArrayList<CompanyEmpWage> companyEmpWageList;
    private Map<String, CompanyEmpWage> companyToEmpWageMap;

    public EmpWageBuilder() {
        companyEmpWageList = new ArrayList<>();
        companyToEmpWageMap = new HashMap<>();
    }

    @Override
    public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
        companyEmpWageList.add(companyEmpWage);
        companyToEmpWageMap.put(company, companyEmpWage);
    }

    @Override
    public void computeEmpWage() {
        for (CompanyEmpWage companyEmpWage : companyEmpWageList) {
            companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
            System.out.println(companyEmpWage);
        }
    }

    @Override
    public int getTotalWage(String company) {
        return companyToEmpWageMap.get(company).totalEmpWage;
    }

    private int computeEmpWage(CompanyEmpWage companyEmpWage) {
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;
        ArrayList<Integer> dailyWages = new ArrayList<>();

        while (totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {
            totalWorkingDays++;
            int empHrs = getEmpHours();
            totalEmpHrs += empHrs;

            int dailyWage = empHrs * companyEmpWage.empRatePerHour;
            dailyWages.add(dailyWage);
        }

        return totalEmpHrs * companyEmpWage.empRatePerHour;
    }

    private int getEmpHours() {
        int empCheck = (int) Math.floor(Math.random() * 10) % 3;
        switch (empCheck) {
            case IS_FULL_TIME:
                return 8;
            case IS_PART_TIME:
                return 4;
            default:
                return 0;
        }
    }
}
