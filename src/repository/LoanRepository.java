package repository;

import java.util.ArrayList;
import java.util.List;

import exceptions.LoanNotFoundException;
import models.loan.Loan;
import storage.MemoryStorage;

public class LoanRepository {

    public void addLoan(Loan loan) {

        MemoryStorage.loanList.add(loan);

    }

    public Loan getLoan(String loanId)
            throws LoanNotFoundException {

        for (Loan loan : MemoryStorage.loanList) {

            if (loan.getLoanId().equalsIgnoreCase(loanId)) {

                return loan;

            }

        }

        throw new LoanNotFoundException("Loan not found.");

    }

    public List<Loan> getAllLoans() {

        return new ArrayList<>(MemoryStorage.loanList);

    }

    public void removeLoan(String loanId)
            throws LoanNotFoundException {

        Loan loan = getLoan(loanId);

        MemoryStorage.loanList.remove(loan);

    }

    public boolean exists(String loanId) {

        for (Loan loan : MemoryStorage.loanList) {

            if (loan.getLoanId().equalsIgnoreCase(loanId)) {

                return true;

            }

        }

        return false;

    }

}