package com.epam.webproject.buber;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTest {
    private static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try (Statement statement =connection.createStatement()){
            String query = "INSERT INTO cars (id, model, year_issue, color) VALUES (5, 'HONDA', 2010, 'WHITE')";
            statement.execute(query);
            System.out.println("ok");

        } catch (SQLException e) {
            logger.log(Level.ERROR, "ffff {}", e.getMessage());
        } finally {
            connectionPool.returnConnection(connection);
        }

    }
}
