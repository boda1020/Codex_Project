# 🎓 University Student Results Management System (Control Management)

A **desktop-based JavaFX application** designed to manage student information, academic records, and examination results efficiently within a university environment.
This project aims to simplify result management, minimize human errors, and provide an easy-to-use, visually appealing system for both administrators and staff.

---

## 🚀 Features

✅ **User Authentication**

* Secure Login & Logout functionality.
* Role-based access for Admins and Faculty members.

✅ **Student Management**

* Add, edit, delete, and search student records.
* Assign students to departments and academic levels.

✅ **Course & Result Management**

* Register new courses with unique codes and credits.
* Input and update marks for each student and subject.
* Automatic calculation of GPA / Percentage.
* View and print student transcripts or result summaries.

✅ **Reports & Export**

* Generate printable reports.
* Export data to **PDF** or **Excel** formats.

✅ **Modern JavaFX Interface**

* Built using **Scene Builder** for a clean, intuitive GUI.
* Responsive design with clear layout and visual elements.

---

## 🧠 System Objectives

* Simplify and automate result management.
* Minimize manual data entry errors.
* Provide instant result calculations.
* Maintain accurate and secure student data.
* Enable administrators to generate quick performance reports.

---

## 🛠️ Tech Stack

| Layer               | Technology                |
| ------------------- | ------------------------- |
| **Frontend**        | JavaFX (Scene Builder UI) |
| **Backend**         | Java (OOP + JDBC)         |
| **Database**        | MySQL / MariaDB           |
| **IDE**             | IntelliJ IDEA / NetBeans  |
| **Version Control** | Git + GitHub              |

---

## 🧩 Project Structure

```
├── src/
│   ├── mainfx/
│   │   ├── Main.java                # Entry point
│   │   ├── controllers/             # JavaFX controllers
│   │   ├── models/                  # Data models (Student, Course, Result)
│   │   ├── database/                # DB connection and queries
│   │   └── views/                   # FXML UI files
├── lib/                             # JavaFX SDK libraries
├── README.md
└── pom.xml or build.xml             # Build configuration
```

---

## ⚙️ Installation & Setup

### Step 1: Clone the Repository

```bash
git clone https://github.com/boda1020/Codex_Project.git
```

### Step 2: Add JavaFX SDK

Download JavaFX SDK (version 25 or above)
and add it to your project libraries:

```
File → Project Structure → Libraries → Add JavaFX SDK
```

### Step 3: Set VM Options (IntelliJ / NetBeans)

```
--module-path "C:\Program Files\JavaFX\javafx-sdk-25\lib" --add-modules javafx.controls,javafx.fxml
```

### Step 4: Configure Database (MySQL)

1. Create a database named `student_results_db`.
2. Import the provided SQL file (if available).
3. Update connection settings in the config class:

```

### Step 5: Run the Project 🚀

```bash
Run → Main.java
```

---


## 🧾 License

This project is developed as part of a **university graduation project**.
All rights reserved © 2025 – *CodeX Team* 🧠

---



