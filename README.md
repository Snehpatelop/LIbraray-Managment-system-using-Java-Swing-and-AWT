# Library Management System

This project is a **Library Management System** built using Java Swing. It provides an interactive graphical user interface (GUI) to manage a collection of books in a library. Users can add, update, and remove books, as well as view the details of the books in a tabular format.

---

## Features

1. **Add Books**
   - Allows users to input the book's details (Title, Author, ISBN, Year, Genre, Availability) and add them to the list.

2. **Update Books**
   - Enables users to edit the details of a selected book and update the information in the table.

3. **Remove Books**
   - Allows users to remove a selected book from the list.

4. **View Book List**
   - Displays all books in a tabular format, including their details such as Title, Author, ISBN, Year, Genre, and Availability.

5. **Tabbed Interface**
   - The application provides two tabs:
     - **Book Details:** For adding and updating book details.
     - **Book List:** For viewing the list of books.

6. **Interactive GUI**
   - Built using Java Swing, providing an intuitive and easy-to-use interface.

---

## Tools and Technologies Used

- **Language:** Java
- **Framework:** Java Swing
- **IDE:** IntelliJ IDEA / Eclipse / NetBeans (or any preferred IDE for Java)

---

## How to Run

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/yourusername/library-management-system.git
   cd library-management-system
   ```

2. **Compile the Program:**
   Navigate to the folder containing the Java file and run:
   ```bash
   javac q1.java
   ```

3. **Run the Program:**
   Execute the compiled program:
   ```bash
   java q1
   ```

4. **Use the Application:**
   - Enter book details in the **Book Details** tab.
   - Click on the appropriate button to perform actions:
     - `Add Book` to add a new book.
     - `Update Book` to modify an existing book (select the book from the list first).
     - `Remove Book` to delete a selected book from the list.

---

## Program Structure

- **Menu Bar:**
  - Includes `File`, `Edit`, and `Help` options (currently non-functional placeholders for future enhancements).

- **Toolbar:**
  - Buttons for `Add Book`, `Update Book`, and `Remove Book` for quick access to core functionalities.

- **Book Details Form:**
  - Input fields for:
    - Title, Author, ISBN, Year, Genre (dropdown), and Availability (checkbox).

- **Book List:**
  - Displays all books in a table with columns for:
    - Title, Author, ISBN, Year, Genre, and Availability.

- **Tabbed Pane:**
  - Two tabs for **Book Details** and **Book List**.

---

## Future Enhancements

- Add search functionality to find books by Title, Author, or ISBN.
- Implement file saving/loading to persist the book data across sessions.
- Add a "Help" section with user instructions.
- Include sorting and filtering options for the book list.

---

## Contributing

Contributions are welcome! If you'd like to improve this project, feel free to fork the repository and submit a pull request.

---

## License

This project is open-source and available under the [MIT License](LICENSE).

---

## Acknowledgments

- This project was created by **Sneh Pareshkumar Patel** as part of the coursework.
- Student ID: **RA2311003010884**.

---
