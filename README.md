## 📚 Student Management System (Console + JDBC)

A simple Java-based console application that performs **CRUD operations on student records** using **JDBC**, designed with a clean modular architecture involving Controller, Service, and DAO layers.

---

### ✅ Features

* ➕ Add a new student
* 📄 View all students
* 🔍 Search student by **ID**, **Name**, or **Course**
* 📝 Update student details
* ❌ Delete student
* 💡 Uses **MySQL database** with JDBC
* 🧱 Modular design (Controller, Service, DAO)

---

### 📁 Project Structure

```
Student-Management-System-with-JDBC/
│
├── controller/
│   └── StudentController.java
│
├── service/
│   └── StudentService.java
│
├── dao/
│   ├── StudentDao.java
│   └── DBConnection.java
│
├── model/
│   └── Student.java
│
├── Main.java
└── README.md
```

---

### 🛠 Technologies Used

* 💻 Java (JDK 17+)
* 🗃 MySQL
* 🔌 JDBC API
* 📦 Eclipse IDE (can also be run via IntelliJ or CLI)

---

### 🗄 Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE studentdb;
USE studentdb;

CREATE TABLE students (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  email VARCHAR(100),
  course VARCHAR(100),
  age INT
);
```

Update DB credentials inside `DBConnection.java`:

```java
String url = "jdbc:mysql://localhost:3306/studentdb";
String username = "root";
String password = "your_mysql_password";
```

---

### 🚀 How to Run

1. Clone the repo:

   ```bash
   git clone https://github.com/SamK1828/Student-Management-System-with-JDBC.git
   ```

2. Open in Eclipse or any Java IDE

3. Run `Main.java`

---

### 🧑‍💻 Author

**Samarth Deelip Kalegaonkar**
🔗 [GitHub](https://github.com/SamK1828)

---

### 📄 License

This project is open-source and free to use under the MIT License.
