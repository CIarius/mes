package com.clarius.mes;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class OracleConnectorTest {

    private static final String VALID_USERNAME = "mes";
    private static final String VALID_PASSWORD = "mes";
    private static final String INVALID_PASSWORD = "sem";

    @Test
    void testValidConnection() {
        try (Connection conn = OracleConnector.getConnection(VALID_USERNAME, VALID_PASSWORD)) {
            assertNotNull(conn, "Connection should not be null");
            assertTrue(conn.isValid(2), "Connection should be valid");
        } catch (SQLException e) {
            fail("Should not throw SQLException for valid credentials: " + e.getMessage());
        }
    }

    @Test
    void testInvalidCredentialsThrowsException() {
        assertThrows(SQLException.class, () -> {
            OracleConnector.getConnection(VALID_USERNAME, INVALID_PASSWORD);
        }, "Should throw SQLException for invalid credentials");
    }

}
