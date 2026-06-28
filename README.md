# 🏦 Bank Management System

A **Java Console-Based Bank Management System** developed using **Core Java** with an object-oriented, layered architecture. The application simulates real-world banking operations with role-based access control, customer and employee management, transactions, loans, and reporting.

---

# ✨ Features

## 🔐 Authentication & Authorization

* Secure login for multiple user roles
* Role-based access control
* Default users for quick testing

---

## 👥 User Roles

### 🧑‍💼 Bank Manager

* Register Employee
* Update Employee
* Delete Employee
* Register Customer
* Update Customer
* Delete Customer
* Approve / Reject Loans
* View Employees
* View Customers
* Bank Statistics

---

### 👨‍💻 Bank Employee

* Register Customer
* Search Customer
* Deposit Money
* Withdraw Money
* Transfer Funds
* Apply Loan
* View Customers

---

### 👤 Customer

* View My Accounts
* Balance Inquiry
* Transfer Funds
* View Transaction History
* Update Contact Number
* Update Email

---

### 📊 Financial Analyst

* Employee Report
* Customer Report
* Account Report
* Loan Report
* Transaction Report
* Summary Report

---

## 💳 Banking Features

* Automatic Account Creation during Customer Registration
* Savings & Checking Accounts
* Automatic Account Number Generation
* Deposit
* Withdraw
* Fund Transfer
* Balance Inquiry
* Transaction History
* Loan Application
* Loan Approval / Rejection

---

# 🏗️ Project Architecture

```
src
│
├── app
├── config
├── enums
├── exceptions
├── menu
├── models
│   ├── accounts
│   ├── loan
│   ├── transaction
│   └── users
├── repository
├── services
├── storage
└── util
```

The project follows a layered architecture:

```
Menu
   ↓
Service
   ↓
Repository
   ↓
Memory Storage
```

---

# 🛠 Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Collections Framework
* Exception Handling
* Layered Architecture
* Console-Based User Interface

---

# 🚀 Compile & Run

### Compile

```powershell
javac -d out (Get-ChildItem -Recurse src\*.java | ForEach-Object { $_.FullName })
```

### Run

```powershell
java -cp out app.Main
```

---

# 👤 Default Login Credentials

| Role              | User ID | Password |
| ----------------- | ------- | -------- |
| Bank Manager      | EMP1001 | 12345    |
| Bank Employee     | EMP1002 | 12345    |
| Financial Analyst | EMP1003 | 12345    |
| Customer          | CUS1001 | 12345    |

---

# 📂 Git Commands

### Check Status

```bash
git status
```

### Stage All Changes

```bash
git add .
```

### Commit

```bash
git commit -m "Your message"
```

### Push

```bash
git push
```

### Pull

```bash
git pull
```

---

# 📌 Project Highlights

* Role-Based Authentication
* Automatic Customer Account Creation
* Automatic Account Number Generation
* CRUD Operations
* Loan Management
* Transaction Management
* Financial Reports
* Console Dashboard
* Robust Exception Handling
* Modular & Maintainable Code

---

# 📈 Future Enhancements

* Database Integration (MySQL / PostgreSQL)
* JDBC Support
* Password Encryption
* Interest Calculation
* ATM Module
* Internet Banking
* Mobile Banking
* Fixed Deposit & Recurring Deposit
* Statement Export (PDF/Excel)
* Email & SMS Notifications

---

# 👨‍💻 Author

**Ashraf Ali**

Developed as a Core Java project to demonstrate object-oriented programming, layered architecture, and banking system workflows.
