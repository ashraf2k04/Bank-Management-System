package services.data;

import storage.MemoryStorage;

public class DataAdministratorService {

    /*
     * ==========================================
     * CLEAR ALL DATA
     * ==========================================
     */

    public void clearDatabase() {

        MemoryStorage.clearAll();

    }

    /*
     * ==========================================
     * BACKUP
     * ==========================================
     */

    public void backupData() {

        System.out.println();
        System.out.println("Runtime backup completed.");
        System.out.println();

    }

    /*
     * ==========================================
     * RESTORE
     * ==========================================
     */

    public void restoreData() {

        System.out.println();
        System.out.println("Runtime restore completed.");
        System.out.println();

    }

    /*
     * ==========================================
     * DATA INTEGRITY
     * ==========================================
     */

    public void checkIntegrity() {

        System.out.println();
        System.out.println("========== DATA STATUS ==========");

        System.out.println("Customers    : " +
                MemoryStorage.customerMap.size());

        System.out.println("Employees    : " +
                MemoryStorage.employeeMap.size());

        System.out.println("Accounts     : " +
                MemoryStorage.accountMap.size());

        System.out.println("Transactions : " +
                MemoryStorage.transactionList.size());

        System.out.println("Loans        : " +
                MemoryStorage.loanList.size());

        System.out.println("=================================");

    }

    /*
     * ==========================================
     * SYSTEM INFO
     * ==========================================
     */

    public void systemInformation() {

        Runtime runtime = Runtime.getRuntime();

        System.out.println();

        System.out.println("Processors : "
                + runtime.availableProcessors());

        System.out.println("Max Memory : "
                + runtime.maxMemory());

        System.out.println("Free Memory: "
                + runtime.freeMemory());

        System.out.println("Total Memory: "
                + runtime.totalMemory());

        System.out.println();

    }

}