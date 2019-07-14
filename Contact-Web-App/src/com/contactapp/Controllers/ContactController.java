package com.contactapp.Controllers;

import com.contactapp.Models.ContactBean;
import com.db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactController {
    private static PreparedStatement statement;
    private static ResultSet resultSet;
    private static Connection conn;


    public static List<ContactBean> getContacts() {
        String query = "select * from contacts;";

        List<ContactBean> contactList = new ArrayList<ContactBean>();

        conn = Database.getConnection();

        try {
            statement = conn.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                ContactBean contact = new ContactBean(name, email, phone);
                contactList.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                Database.closeConnection(conn, statement, resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return contactList;
    }

    public static void addContact(String name, String email, String phone) {
        conn = Database.getConnection();

        String query = "insert into contacts (name, email, phone) values (?,?,?);";

        try {
            statement = conn.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, phone);
            statement.executeUpdate();

            System.out.println("Contact successfully added");
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            try {
                Database.closeConnection(conn, statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
