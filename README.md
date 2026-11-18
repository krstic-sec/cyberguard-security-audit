# CyberGuard - OOP Security Audit Tool

A console-based Java application designed to simulate user account security auditing, password strength evaluation, Brute-Force attack detection, and secure password generation.

> **Language Note:** While this documentation is written in English, the source code (class, variable, and method names), inline comments, and interactive console UI are written in **Serbian**.

---

## Features
* **User Account Management:** Stores user profiles (`username`, `password`, and `failedLoginAttempts`) in an array of objects (`KorisnickiNalog[]`).
* **Automated Password Strength Policy:** Checks each password for:
  * Minimum length (at least 8 characters)
  * At least one uppercase letter (`Character.isUpperCase`)
  * At least one numeric digit (`Character.isDigit`)
  * Common/leaked password blacklist check (e.g., `123456`, `password`, `admin`, `qwerty`, `12345678`)
* **Brute-Force Detection:** Flags accounts with `>= 5` failed login attempts as high-risk targets.
* **Risk Classification:** Automatically evaluates and assigns one of four security statuses upon object creation:
  * `SIGURAN` (Safe)
  * `RIZICAN` (Weak Password)
  * `VISOK RIZIK` (Brute-Force Risk)
  * `KRITICAN` (Critical – Weak Password + Brute-Force)
* **Strong Password Generator:** Generates randomized passwords of custom length containing uppercase letters, lowercase letters, digits, and special characters.
* **System Security Statistics:** Calculates and displays the total number of audited accounts and the overall percentage of compromised/at-risk profiles.

---

## Project Structure
Built using Object-Oriented Programming (OOP) principles (encapsulation, constructors, `this` keyword, and arrays of objects) in **Apache NetBeans**:

```text
Cyberguard/
└── src/
    └── cyberguard/
        ├── CyberGuard.java        # Main entry point, interactive CLI menu, generator & stats
        └── KorisnickiNalog.java   # Model class representing a user account & security audit logic
```

---

## How to Run
1. Clone or download the repository.
2. Open the project in **Apache NetBeans** (or any Java IDE), or compile and run via terminal:
   ```bash
   javac cyberguard/*.java
   java cyberguard.CyberGuard
   ```
3. Follow the interactive console menu to add accounts, run security scans, generate passwords, or view system statistics.