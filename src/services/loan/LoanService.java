package services.loan;

import java.util.List;

import exceptions.LoanNotFoundException;
import models.loan.Loan;
import models.loan.LoanStatus;
import repository.LoanRepository;

public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService() {

        loanRepository = new LoanRepository();

    }

    /*
     * ==========================================
     * APPLY LOAN
     * ==========================================
     */

    public void applyLoan(Loan loan) {

        loan.setLoanStatus(LoanStatus.PENDING);

        loanRepository.addLoan(loan);

    }

    /*
     * ==========================================
     * APPROVE LOAN
     * ==========================================
     */

    public void approveLoan(String loanId)
            throws LoanNotFoundException {

        Loan loan =
                loanRepository.getLoan(loanId);

        loan.setLoanStatus(LoanStatus.APPROVED);

    }

    /*
     * ==========================================
     * REJECT LOAN
     * ==========================================
     */

    public void rejectLoan(String loanId)
            throws LoanNotFoundException {

        Loan loan =
                loanRepository.getLoan(loanId);

        loan.setLoanStatus(LoanStatus.REJECTED);

    }

    /*
     * ==========================================
     * CLOSE LOAN
     * ==========================================
     */

    public void closeLoan(String loanId)
            throws LoanNotFoundException {

        Loan loan =
                loanRepository.getLoan(loanId);

        loan.setLoanStatus(LoanStatus.CLOSED);

    }

    /*
     * ==========================================
     * SEARCH LOAN
     * ==========================================
     */

    public Loan searchLoan(String loanId)
            throws LoanNotFoundException {

        return loanRepository.getLoan(loanId);

    }

    /*
     * ==========================================
     * DELETE LOAN
     * ==========================================
     */

    public void deleteLoan(String loanId)
            throws LoanNotFoundException {

        loanRepository.removeLoan(loanId);

    }

    /*
     * ==========================================
     * VIEW ALL LOANS
     * ==========================================
     */

    public List<Loan> getAllLoans() {

        return loanRepository.getAllLoans();

    }

    /*
     * ==========================================
     * LOAN EXISTS
     * ==========================================
     */

    public boolean loanExists(String loanId) {

        return loanRepository.exists(loanId);

    }

}