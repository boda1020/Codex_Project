
# 🎓 University Student Results Management System

This project is a **JavaFX-based desktop application** designed to manage student results for a university.  
It follows the **MVC (Model–View–Controller)** architecture to ensure clean structure, scalability, and maintainability.

---

## 🧱 Project Overview

- **Language:** Java (JavaFX)
- **IDE:** IntelliJ IDEA / NetBeans
- **Database:** MySQL
- **Architecture:** MVC (Model–View–Controller)
- **Version Control:** GitHub

---

## 🎨 Front-End (User Interface)

> Built using **JavaFX** and **Scene Builder**, this layer manages all user interactions.

**📁 Package:** `view`

| File | Description |
|------|--------------|
| `Login.fxml` | Login screen interface |
| `Dashboard.fxml` | Main navigation screen after login |
| `Students.fxml` | Manage student data visually |
| `Courses.fxml` | Manage course details |
| `Results.fxml` | View and edit student results |
| `Report.fxml` | Display reports and analytics |

---

## ⚙️ Back-End (Application Logic)

> Controls the behavior of the system and connects the front-end to the database.

**📁 Package:** `controller`

| File | Description |
|------|--------------|
| `LoginController.java` | Handles user authentication |
| `DashboardController.java` | Controls navigation between screens |
| `StudentController.java` | Manages student-related logic |
| `CourseController.java` | Manages course-related logic |
| `ResultController.java` | Manages student result logic |
| `ReportController.java` | Generates and displays reports |

---

## 📦 Model (Data Layer)

> Defines data structures that represent database entities.

**📁 Package:** `model`

| File | Description |
|------|--------------|
| `Student.java` | Represents a student |
| `Course.java` | Represents a course |
| `Result.java` | Represents a student's result |
| `User.java` | Represents user data (username, password, role) |

---

## 🧩 DAO (Data Access Objects)

> Responsible for CRUD (Create, Read, Update, Delete) operations with the MySQL database.

**📁 Package:** `dao`

| File | Description |
|------|--------------|
| `StudentDAO.java` | Performs operations on students table |
| `CourseDAO.java` | Performs operations on courses table |
| `ResultDAO.java` | Performs operations on results table |
| `UserDAO.java` | Validates user login and credentials |

---

## 🔧 Utils (Helper Classes)

> Contains helper methods used across the project.

**📁 Package:** `utils`

| File | Description |
|------|--------------|
| `AlertHelper.java` | Displays error, success, and info alerts |
| `ValidationUtils.java` | Validates user input before saving |

---

## 🗄️ Database Layer

> Manages database connectivity and configuration.

**📁 Package:** `database`

| File | Description |
|------|--------------|
| `DatabaseConnection.java` | Handles MySQL connection setup |
| `db.properties` | Contains database configuration (host, user, password, db name) |

---

## ⚡ Setup Instructions

1. Install **JDK 23** or newer.  
2. Download and configure **JavaFX SDK** in your IDE.  
3. Add **MySQL Connector/J** library to your project.  
4. Create the required MySQL database and update the credentials in `db.properties`.  
5. Run the project and start managing student results efficiently 🎯

---

## 👨‍💻 Team

**Team Name:** CodeX Team  
**Project Leader:** Abdulrahman Khamis  

---

## 🧠 Notes

- Ensure all FXML files are properly linked to their controllers.  
- Maintain clear separation between UI, logic, and data layers.  
- Follow consistent naming conventions and structure.  

---

🚀 *A professional desktop system for efficient university result management, powered by JavaFX.*
