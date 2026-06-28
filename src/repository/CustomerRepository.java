package repository;

import exceptions.CustomerNotFoundException;
import exceptions.DuplicateAadhaarException;
import exceptions.DuplicateCustomerException;
import exceptions.DuplicatePANException;
import exceptions.DuplicateSSNException;
import models.users.Customer;
import storage.MemoryStorage;

public class CustomerRepository {

    public void addCustomer(Customer customer)
            throws DuplicateCustomerException,
            DuplicateAadhaarException,
            DuplicatePANException,
            DuplicateSSNException {

        if (MemoryStorage.customerMap.containsKey(customer.getId())) {

            throw new DuplicateCustomerException(
                    "Customer ID already exists.");

        }

        if (MemoryStorage.aadhaarNumbers.contains(customer.getAadhaarNo())) {

            throw new DuplicateAadhaarException(
                    "Duplicate Aadhaar Number.");

        }

        if (MemoryStorage.panNumbers.contains(customer.getPanNo())) {

            throw new DuplicatePANException(
                    "Duplicate PAN Number.");

        }

        if (MemoryStorage.ssnNumbers.contains(customer.getSsn())) {

            throw new DuplicateSSNException(
                    "Duplicate SSN.");

        }

        MemoryStorage.customerMap.put(
                customer.getId(),
                customer);

        MemoryStorage.customerIds.add(
                customer.getId());

        MemoryStorage.aadhaarNumbers.add(
                customer.getAadhaarNo());

        MemoryStorage.panNumbers.add(
                customer.getPanNo());

        MemoryStorage.ssnNumbers.add(
                customer.getSsn());

        MemoryStorage.emails.add(
                customer.getEmail());

    }

    public Customer getCustomer(String customerId)
            throws CustomerNotFoundException {

        Customer customer =
                MemoryStorage.customerMap.get(customerId);

        if (customer == null) {

            throw new CustomerNotFoundException(
                    "Customer not found.");

        }

        return customer;

    }

    public void updateCustomer(Customer customer)
            throws CustomerNotFoundException {

        if (!MemoryStorage.customerMap.containsKey(customer.getId())) {

            throw new CustomerNotFoundException(
                    "Customer not found.");

        }

        MemoryStorage.customerMap.put(
                customer.getId(),
                customer);

    }

    public void deleteCustomer(String customerId)
            throws CustomerNotFoundException {

        Customer customer =
                getCustomer(customerId);

        MemoryStorage.customerMap.remove(customerId);

        MemoryStorage.customerIds.remove(customerId);

        MemoryStorage.aadhaarNumbers.remove(
                customer.getAadhaarNo());

        MemoryStorage.panNumbers.remove(
                customer.getPanNo());

        MemoryStorage.ssnNumbers.remove(
                customer.getSsn());

        MemoryStorage.emails.remove(
                customer.getEmail());

    }

    public boolean exists(String customerId) {

        return MemoryStorage.customerMap.containsKey(customerId);

    }

}