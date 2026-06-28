package models.transaction;

import util.DateUtil;

public class Transaction {

    private String transactionId;

    private String sourceAccountNumber;

    private String destinationAccountNumber;

    private double amount;

    private TransactionType transactionType;

    private TransactionStatus transactionStatus;

    private String transactionDateTime;

    public Transaction() {

        transactionDateTime = DateUtil.getCurrentDateTime();

    }

    public Transaction(String transactionId,
                       String sourceAccountNumber,
                       String destinationAccountNumber,
                       double amount,
                       TransactionType transactionType,
                       TransactionStatus transactionStatus) {

        this.transactionId = transactionId;
        this.sourceAccountNumber = sourceAccountNumber;
        this.destinationAccountNumber = destinationAccountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionStatus = transactionStatus;
        this.transactionDateTime = DateUtil.getCurrentDateTime();

    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public void setSourceAccountNumber(String sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }

    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public void setDestinationAccountNumber(String destinationAccountNumber) {
        this.destinationAccountNumber = destinationAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    @Override
    public String toString() {

        return """
               ----------------------------------------
               Transaction ID : %s
               Source Account : %s
               Destination    : %s
               Amount         : ₹%.2f
               Type           : %s
               Status         : %s
               Date & Time    : %s
               ----------------------------------------
               """.formatted(
                transactionId,
                sourceAccountNumber,
                destinationAccountNumber,
                amount,
                transactionType,
                transactionStatus,
                transactionDateTime
        );

    }

}