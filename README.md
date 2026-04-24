# Year Up United – Learning to Code Academy (LTCA)

## 📚 Overview

This repository contains my projects and exercises from the **Year Up United Learning to Code Academy (LTCA)** program. It demonstrates my ability to build Java applications that handle real-world data using structured file formats like CSV and JSON.

The focus of this repository includes:

* Object-Oriented Programming (OOP)
* File parsing and data processing
* Input validation and error handling
* Working with collections and dynamic data

---

## 🚀 Technologies Used

* Java
* IntelliJ IDEA
* Git & GitHub
* CSV & JSON file handling

---

## 📁 Key Features & Functionality

### 🔹 Product Management System

* Stores product data using `List<Product>` and `ArrayList`
* Supports:

  * Adding products with validation
  * Preventing null or invalid entries
  * Clearing and managing lists dynamically
  * Returning read-only lists using `Collections.unmodifiableList()`

---

### 🔹 CSV File Parsing

* Reads structured data such as:

```text
id|name|price
```

* Uses:

  * `split("\\|")` for parsing
  * `.trim()` for cleaning input
* Converts values into proper data types:

  * `int` → `Integer.parseInt()`
  * `double` → `Double.parseDouble()`
  * `float` → `Float.parseFloat()`

---

### 🔹 JSON File Creation

* Dynamically generates JSON output
* Uses:

  * `String.format()` for structured formatting
  * Loop logic to handle multiple objects
  * Conditional commas to maintain valid JSON syntax

---

### 🔹 Data Validation & Error Handling

* Implements defensive programming techniques:

  * Throws `IllegalArgumentException` for invalid inputs
  * Validates values (e.g., negative prices, null objects)
* Uses `try-catch` blocks to prevent crashes during file operations

Example:

```java
if (price < 0) {
    throw new IllegalArgumentException("Price cannot be negative");
}
```

---

### 🔹 Collections & Data Management

* Uses Java Collections Framework:

  * `ArrayList` for dynamic storage
* Common operations:

  * `.add()` → insert data
  * `.clear()` → reset list
  * `.size()` → track elements
  * `.isEmpty()` → check state

---

### 🔹 Output Formatting

* Uses `System.out.printf()` for clean and readable output
* Formats:

  * Currency (`%.2f`)
  * Structured console output
  * Aligned data display

---

### 🔹 Date & Time Handling

* Formats dates using:

  * `DateTimeFormatter`
  * Local and GMT time zones
* Supports:

  * Full weekday names (`EEEE`)
  * Custom formatted strings with literals

---

## 🧠 Key Concepts Demonstrated

* Object-Oriented Programming (Encapsulation, Classes, Methods)
* Idempotent operations and safe data handling
* Package naming conventions and project structure
* Defensive programming using validation and exceptions
* Working with file-based data storage

---

## 📌 Example Workflow

1. Load product data from a CSV file
2. Parse each line into a `Product` object
3. Store objects in an `ArrayList`
4. Validate data before adding
5. Display formatted output
6. Export data to JSON or CSV

---

## 🔧 How to Run

1. Clone the repository:

```bash
git clone https://github.com/cjdeniz9/ltca.git
```

2. Open in IntelliJ IDEA

3. Run the main class:

```bash
Main.java
```

---

## 📈 Future Improvements

* Integrate a database (MySQL)
* Implement REST APIs
* Use JSON libraries like Gson or Jackson
* Add unit testing (JUnit)
* Build a user interface (CLI or GUI)

---

## 🙌 Acknowledgments

Completed as part of the **Year Up United Learning to Code Academy**, focused on developing real-world technical and professional skills.

---

## 📬 Contact

Feel free to explore the repository and reach out for collaboration or feedback.
