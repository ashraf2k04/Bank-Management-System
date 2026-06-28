package services.customer;

import java.util.List;

import exceptions.AccountNotFoundException;
import exceptions.CustomerNotFoundException;
import exceptions.DuplicateAadhaarException;
import exceptions.DuplicateCustomerException;
import exceptions.DuplicatePANException;
import exceptions.DuplicateSSNException;
import exceptions.NegativeAmountException;
import models.accounts.BankAccount;
import models.users.Customer;
import repository.AccountRepository;
import repository.CustomerRepository;
import services.account.AccountService;

public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final AccountService accountService;

    public CustomerService() {

        customerRepository = new CustomerRepository();
        accountRepository = new AccountRepository();
        accountService = new AccountService();

    }

    /*
     * ============================================
     * REGISTER CUSTOMER
     * ============================================
     */

    public void registerCustomer(Customer customer)
            throws DuplicateCustomerException,
            DuplicateAadhaarException,
            DuplicatePANException,
            DuplicateSSNException {

        customerRepository.addCustomer(customer);

    }

    /*
     * ============================================
     * UPDATE CUSTOMER
     * ============================================
     */

    public void updateCustomer(Customer customer)
            throws CustomerNotFoundException {

        customerRepository.updateCustomer(customer);

    }

    /*
     * ============================================
     * SEARCH CUSTOMER
     * ============================================
     */

    public Customer searchCustomer(String customerId)
            throws CustomerNotFoundException {

        return customerRepository.getCustomer(customerId);

    }

    /*
     * ============================================
     * DELETE CUSTOMER
     * ============================================
     */

    public void deleteCustomer(String customerId)
            throws CustomerNotFoundException {

        customerRepository.deleteCustomer(customerId);

    }

    /*
     * ============================================
     * LINK ACCOUNT
     * ============================================
     */

    public void addAccount(Customer customer,
                           BankAccount account) {

        customer.addAccount(account);

    }

    /*
     * ============================================
     * VIEW ACCOUNTS
     * ============================================
     */

    public List<BankAccount> getAccounts(String customerId)
            throws CustomerNotFoundException {

        return customerRepository
                .getCustomer(customerId)
                .getAccounts();

    }

    /*
     * ============================================
     * BALANCE
     * ============================================
     */

    public double checkBalance(String accountNumber)
            throws AccountNotFoundException {

        return accountService.getBalance(accountNumber);

    }

    /*
     * ============================================
     * UPDATE CONTACT
     * ============================================
     */

    public void updateContactNumber(String customerId,
                                    String contactNumber)
            throws CustomerNotFoundException {

        Customer customer =
                customerRepository.getCustomer(customerId);

        customer.setContactNumber(contactNumber);

        customerRepository.updateCustomer(customer);

    }

    /*
     * ============================================
     * UPDATE EMAIL
     * ============================================
     */

    public void updateEmail(String customerId,
                            String email)
            throws CustomerNotFoundException {

        Customer customer =
                customerRepository.getCustomer(customerId);

        customer.setEmail(email);

        customerRepository.updateCustomer(customer);

    }

    /*
     * ============================================
     * CREATE SAVINGS ACCOUNT
     * ============================================
     */

    public void openSavingsAccount(String customerId,
                                   double openingBalance)
            throws Exception {

        Customer customer =
                customerRepository.getCustomer(customerId);

        customer.addAccount(
                accountService.createSavingsAccount(openingBalance));

        customerRepository.updateCustomer(customer);

    }

    /*
     * ============================================
     * CREATE CHECKING ACCOUNT
     * ============================================
     */

    public void openCheckingAccount(String customerId,
                                    double openingBalance)
            throws Exception {

        Customer customer =
                customerRepository.getCustomer(customerId);

        customer.addAccount(
                accountService.createCheckingAccount(openingBalance));

        customerRepository.updateCustomer(customer);

    }

    /*
     * ============================================
     * CREATE CURRENT ACCOUNT
     * ============================================
     */

    public void openCurrentAccount(String customerId,
                                   double openingBalance)
            throws Exception {

        Customer customer =
                customerRepository.getCustomer(customerId);

        customer.addAccount(
                accountService.createCurrentAccount(openingBalance));

        customerRepository.updateCustomer(customer);

    }

    /*
     * ============================================
     * CUSTOMER EXISTS
     * ============================================
     */

    public boolean customerExists(String customerId) {

        return customerRepository.exists(customerId);

    }

}