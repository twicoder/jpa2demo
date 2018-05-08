package com.chinwe.pojo;

import java.sql.*;

public class BookTest {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        persistBook(new Book(1L,"H2G2","Best Scifi Book",12.5f,"1234-5678-5678"));

        Book book = findBook(1L);
        System.out.println(book);

    }

    private static Book findBook(Long id) {
        Book book = new Book(id);
        String query = "SELECT ID,TITLE,DESCRIPTION,UNITCOST,ISBN FROM BOOK WHERE ID = ?";

        try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                book.setTitle(rs.getString("TITLE"));
                book.setDescription(rs.getString("DESCRIPTION"));
                book.setUnitCost(rs.getFloat("UNITCOST"));
                book.setIsbn(rs.getString("ISBN"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    private static void persistBook(Book book) {
        String query = "INSERT INTO BOOK(ID,TITLE,DESCRIPTION,UNITCOST,ISBN) VALUES(?,?,?,?,?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(query)) {
            stmt.setLong(1, book.getId());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getDescription());
            stmt.setFloat(4, book.getUnitCost());
            stmt.setString(5, book.getIsbn());

            stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/learnjpa?serverTimezone=UTC","root","Sybase123"
        );
    }
}
