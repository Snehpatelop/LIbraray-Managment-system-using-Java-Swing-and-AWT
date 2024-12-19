import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class q1 {
    private JTextField titleField, authorField, isbnField, yearField;
    private JComboBox<String> genreBox;
    private JCheckBox availabilityCheck;
    private DefaultTableModel tableModel;
    private JTable bookTable;

    public q1() {
        // JFrame
        JFrame frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JMenuBar
        JMenuBar menu = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");
        menu.add(fileMenu);
        menu.add(editMenu);
        menu.add(helpMenu);
        frame.setJMenuBar(menu);

        // ToolBar
        JToolBar toolBar = new JToolBar();
        toolBar.setRollover(true);
        JButton addBookButton = new JButton("Add Book");
        JButton updateBookButton = new JButton("Update Book");
        JButton removeBookButton = new JButton("Remove Book");
        toolBar.add(addBookButton);
        toolBar.add(updateBookButton);
        toolBar.add(removeBookButton);
        frame.add(toolBar, BorderLayout.NORTH);

        // Book Details Panel (using GridLayout)
        JPanel bookDetailsPanel = new JPanel();
        bookDetailsPanel.setLayout(new GridLayout(7, 2, 5, 5));
        titleField = new JTextField();
        authorField = new JTextField();
        isbnField = new JTextField();
        yearField = new JTextField();
        genreBox = new JComboBox<>(new String[]{"Fiction", "Non-Fiction", "Sci-Fi", "Fantasy", "Others"});
        availabilityCheck = new JCheckBox("Available");

        bookDetailsPanel.add(new JLabel("Title:"));
        bookDetailsPanel.add(titleField);
        bookDetailsPanel.add(new JLabel("Author:"));
        bookDetailsPanel.add(authorField);
        bookDetailsPanel.add(new JLabel("ISBN:"));
        bookDetailsPanel.add(isbnField);
        bookDetailsPanel.add(new JLabel("Year:"));
        bookDetailsPanel.add(yearField);
        bookDetailsPanel.add(new JLabel("Genre:"));
        bookDetailsPanel.add(genreBox);
        bookDetailsPanel.add(availabilityCheck);
        bookDetailsPanel.add(new JLabel("By Sneh Pareshkumar Patel (RA2311003010884)"));
        bookDetailsPanel.add(addBookButton);
        bookDetailsPanel.add(updateBookButton);

        // Book List Panel
        JPanel bookListPanel = new JPanel(new BorderLayout());
        tableModel = new DefaultTableModel(new Object[]{"Title", "Author", "ISBN", "Year", "Genre", "Available"}, 0);
        bookTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(bookTable);
        bookListPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the panels to the tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Book Details", bookDetailsPanel);
        tabbedPane.addTab("Book List", bookListPanel);

        // Add tabbed pane to frame
        frame.add(tabbedPane, BorderLayout.CENTER);

        // Frame settings
        frame.setSize(800, 600);
        frame.setVisible(true);

        // Event Handlers
        addBookButton.addActionListener(e -> addBook());
        updateBookButton.addActionListener(e -> updateBook());
        removeBookButton.addActionListener(e -> removeBook());

        // Selection listener for the table to populate the fields
        bookTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && bookTable.getSelectedRow() != -1) {
                int selectedRow = bookTable.getSelectedRow();
                titleField.setText(tableModel.getValueAt(selectedRow, 0).toString());
                authorField.setText(tableModel.getValueAt(selectedRow, 1).toString());
                isbnField.setText(tableModel.getValueAt(selectedRow, 2).toString());
                yearField.setText(tableModel.getValueAt(selectedRow, 3).toString());
                genreBox.setSelectedItem(tableModel.getValueAt(selectedRow, 4).toString());
                availabilityCheck.setSelected((Boolean) tableModel.getValueAt(selectedRow, 5));
            }
        });
    }

    // Method to add a book
    private void addBook() {
        String title = titleField.getText();
        String author = authorField.getText();
        String isbn = isbnField.getText();
        String year = yearField.getText();
        String genre = genreBox.getSelectedItem().toString();
        boolean available = availabilityCheck.isSelected();

        // Add the book to the table
        tableModel.addRow(new Object[]{title, author, isbn, year, genre, available});

        // Clear the fields after adding
        clearFields();
    }

    // Method to update a book
    private void updateBook() {
        int selectedRow = bookTable.getSelectedRow();
        // Check if a row is selected
        if (selectedRow != -1) {
            String updatedTitle = titleField.getText();
            String updatedAuthor = authorField.getText();
            String updatedISBN = isbnField.getText();
            String updatedYear = yearField.getText();
            String updatedGenre = genreBox.getSelectedItem().toString();
            boolean updatedAvailability = availabilityCheck.isSelected();

            // Update the selected row in the table
            tableModel.setValueAt(updatedTitle, selectedRow, 0);
            tableModel.setValueAt(updatedAuthor, selectedRow, 1);
            tableModel.setValueAt(updatedISBN, selectedRow, 2);
            tableModel.setValueAt(updatedYear, selectedRow, 3);
            tableModel.setValueAt(updatedGenre, selectedRow, 4);
            tableModel.setValueAt(updatedAvailability, selectedRow, 5);

            // Clear the fields after updating
            clearFields();
        } else {
            JOptionPane.showMessageDialog(null, "Please select a book to update!", "No Selection", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Method to remove a book
    private void removeBook() {
        int selectedRow = bookTable.getSelectedRow();
        // Check if a row is selected
        if (selectedRow != -1) {
            // Remove the selected row from the table
            tableModel.removeRow(selectedRow);

            // Clear the fields after removal
            clearFields();
        } else {
            JOptionPane.showMessageDialog(null, "Please select a book to remove!", "No Selection", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Method to clear the form fields
    private void clearFields() {
        titleField.setText("");
        authorField.setText("");
        isbnField.setText("");
        yearField.setText("");
        genreBox.setSelectedIndex(0);
        availabilityCheck.setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(q1::new);
    }
}
