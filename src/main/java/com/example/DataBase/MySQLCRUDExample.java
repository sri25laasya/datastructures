package com.example.DataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLCRUDExample {
    private static final String URL = "jdbc:mysql://localhost:3306/employeemanagement";
    private static final String USER = "root";
    private static final String PASSWORD = "WJ28@krhps";

    private static Connection connection;
    private static Statement statement; 
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;
    
    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            createRecord();
            // readRecord();
            // updateRecord();
            // deleteRecord();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
     //following is my create table statement
    /*create table employees(
id int auto_increment primary key,
first_name varchar(50),
last_name varchar(50),
email varchar(100),
hire_date DATE,
salary decimal(10,2)
); */
    private static void createRecord() {
        String sql = "INSERT INTO employees (first_name, last_name, email, hire_date, salary) VALUES (?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "Laci");
            preparedStatement.setString(2, "Peterson");
            preparedStatement.setString(3, "Laci.peterson@gmail.com");
            preparedStatement.setDate(4, new Date(System.currentTimeMillis()));
            preparedStatement.setDouble(5, 50000.00);
            preparedStatement.executeUpdate();
            System.out.println("Record created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
        
    
}
