/**
 * a LIST OF THE SALES FIGURES BY DIVISION
 * Divisions increase from the previous quarter
 * Total sales
 *
 */

public class SalesStatistics {
    private double[][] sales = new double[3][5];
    enum divisions {DIVISION_1,DIVISION_2,DIVISION_3,DIVISION_4,DIVISION_5,DIVISION_6,ALL_DIVISIONS};
    enum quarters  {QUARTER_1,QUARTER_2,QUARTER_3,QUARTER_4};

    public SalesStatistics() {
        for(int x = 0; x < 4; x++) {
            for(int y = 0; y < 6; y++) {
                sales[x][y] = 0;
            }
        }
    }

    public SalesStatistics(double[] args1, double[] args2, double[] args3, double[] args4) {
        for(int x = 0; x < 4; x++) {
            if(x == 0) {
                for (int y = 0; y < 6; y++) {
                    sales[x][y] = args1[y];
                }
            }
            if(x == 1) {
                for (int y = 0; y < 6; y++) {
                    sales[x][y] = args2[y];
                }
            }
            if(x == 2) {
                for (int y = 0; y < 6; y++) {
                    sales[x][y] = args3[y];
                }
            }
            if(x == 3) {
                for (int y = 0; y < 6; y++) {
                    sales[x][y] = args4[y];
                }
            }
        }
    }

    public double getChange(quarters quarter, divisions division) {
        int numQuarter = getQuarterNum(quarter), numDivision = getDivisionNum(division);

        if (checkIfFirstQuarter(numQuarter)) {
            return 0;
        }
        else if (checkIfAllDivisions(numDivision)) {
            double totalCurrentMonth = 0, totalPreviousMonth = 0;
            for (int x = 0; x < 6; x++) {
                sales[numQuarter][x] += totalCurrentMonth;
            }
            for (int x = 0; x < 6; x++) {
                sales[numQuarter - 1][x] += totalCurrentMonth;
            }
            return  totalCurrentMonth/totalPreviousMonth;
        }
        else {
            return sales[numQuarter][numDivision]/sales[numQuarter - 1][numDivision];
        }
    }

    private int getDivisionNum(divisions division) {
        boolean isAllDivisions = false;
        int numDivision = 0;
        switch (division) {
            case DIVISION_1:
                numDivision = 0;
                break;
            case DIVISION_2:
                numDivision = 1;
                break;
            case DIVISION_3:
                numDivision = 2;
                break;
            case DIVISION_4:
                numDivision = 3;
                break;
            case DIVISION_5:
                numDivision = 4;
                break;
            case DIVISION_6:
                numDivision = 5;
                break;
            case ALL_DIVISIONS:
                numDivision = 6;
                break;
        }
        return numDivision;
    }
    private boolean checkIfAllDivisions(int numDivision) {
        return numDivision == 6;
    }

    private int getQuarterNum(quarters quarter) {
        int numQuarter = 0;
        switch (quarter) {
            default:
                break;
            case QUARTER_2:
                numQuarter = 1;
                break;
            case QUARTER_3:
                numQuarter = 2;
                break;
            case QUARTER_4:
                numQuarter = 3;
                break;
        }
        return numQuarter;
    }
    private boolean checkIfFirstQuarter(int numQuarter) {
        return numQuarter == 0;
    }

    public double getTotalSales(quarters quarter) {
        double total = 0;

        if (checkIfFirstQuarter(getQuarterNum(quarter))) {
            return 0;
        }
        else {
            int numQuarter = getQuarterNum(quarter);
            for (int x = 0; x < 6; x++) {
                total += sales[numQuarter][x];
            }
            return total;
        }
    }

    public double getTotalSales(divisions division) {
        double total = 0;

        int numDivision = getDivisionNum(division);
        if (checkIfAllDivisions(numDivision = getDivisionNum(division))) {
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 6; y++) {
                    total += sales[x][y];
                }
            }
            return total;
        }
        for (int x = 0; x < 6; x++) {
            total += sales[x][numDivision];
        }
        return total;
    }
}
