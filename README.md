# Banking System Simulator - JAVA

A fully interactive, console-based Java application that simulates a simple banking environment. This project was developed as an Object-Oriented Programming (OOP) semester project.

## Features

**Authentication System:**
- **Create Account:** Securely register with a username and password.
- **Login / Logout:** Authenticate users before granting access to core banking features.

**Core Banking Operations:**
- **Check Balance:** View current account balance at any time.
- **Deposit Funds:** Add money to the account securely.
- **Withdraw Funds:** Withdraw money, featuring built-in constraints such as checking for valid amounts and enforcing a minimum balance (₹1000).
- **Manage Account:** Change the account type (e.g., Savings, Current).
- **View Details:** Display full account information including Name, Account Number, Account Type, and Current Balance.

**Technical Highlights:**
- **Object-Oriented Design:** Code encapsulates banking logic in a `Bank` class while handling user interface flows in the `Main` class.
- **In-Memory Storage:** Uses Java `HashMap` to store and verify user credentials dynamically during runtime.
- **Robust Input Handling:** Implements exception handling (like `InputMismatchException`) to gracefully manage invalid user inputs.

## Getting Started

1. **Environment:** Ensure you have Java Development Kit (JDK) installed on your system.
2. **IDE Setup:** You can open this project directly in IntelliJ IDEA (utilizing the included `.idea` folder and `.iml` file) or any preferred Java IDE.
3. **Execution:** 
   - Navigate to `src/Banking_Project_Spandan/Main.java`.
   - Compile and run the `Main.java` file.
4. **Usage:** Follow the on-screen console prompts to interact with the **PGSR Bank** system. Start by creating an account, logging in, and exploring the user menu.
