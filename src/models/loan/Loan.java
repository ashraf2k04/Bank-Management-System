package models.loan;

import models.users.Customer;
import util.DateUtil;

public class Loan {

    private String loanId;

    private Customer customer;

    private LoanType loanType;

    private LoanStatus loanStatus;

    private String employer;

    private String occupation;

    private double loanAmount;

    private int durationMonths;

    private String applicationDate;

    public Loan() {

        applicationDate = DateUtil.getCurrentDate();

    }

    public Loan(String loanId,
                Customer customer,
                LoanType loanType,
                LoanStatus loanStatus,
                String employer,
                String occupation,
                double loanAmount,
                int durationMonths) {

        this.loanId = loanId;
        this.customer = customer;
        this.loanType = loanType;
        this.loanStatus = loanStatus;
        this.employer = employer;
        this.occupation = occupation;
        this.loanAmount = loanAmount;
        this.durationMonths = durationMonths;
        this.applicationDate = DateUtil.getCurrentDate();

    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    @Override
    public String toString() {

        return """
               ----------------------------------------
               Loan ID       : %s
               Customer      : %s %s
               Loan Type     : %s
               Status        : %s
               Employer      : %s
               Occupation    : %s
               Amount        : ₹%.2f
               Duration      : %d Months
               Applied On    : %s
               ----------------------------------------
               """.formatted(
                loanId,
                customer.getFirstName(),
                customer.getLastName(),
                loanType,
                loanStatus,
                employer,
                occupation,
                loanAmount,
                durationMonths,
                applicationDate
        );

    }

}