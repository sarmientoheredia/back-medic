package com.sanjuan.backmedic.config.audit4j;

import org.audit4j.core.dto.AuditEvent;
import org.audit4j.core.dto.EventBatch;
import org.audit4j.core.dto.Field;
import org.audit4j.core.exception.HandlerException;
import org.audit4j.handler.db.DatabaseAuditHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import java.util.stream.Collectors;


public class CustomDatabaseAuditHandler extends DatabaseAuditHandler {


private String dbUrl="jdbc:postgresql://localhost:5432/postgres";
private String dbUser="postgres";
private String dbPassword="heredia.89";

    @Override
    public void handle(AuditEvent event) {
//        String names = event.getFields().stream()
//                .map(field -> field.getName() + "=" + field.getValue())
//                .collect(Collectors.joining(", "));
//        String identifier = UUID.randomUUID().toString();
//
//        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
//            String sql = "INSERT INTO audit (timestamp,actor,origin, action, elements) VALUES ( ?, ?, ?,?,?)";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//
////            pstmt.setString(1, identifier);
//            pstmt.setTimestamp(1, new java.sql.Timestamp(event.getTimestamp().getTime()));
//            pstmt.setString(2, event.getActor());
//            pstmt.setString(3, event.getOrigin());
//            pstmt.setString(4, event.getAction());
//            pstmt.setString(5, names); // Puedes personalizar esta parte según los campos que quieras guardar
//            pstmt.executeUpdate();
//
//        } catch (SQLException e) {
//            System.err.println("Error al guardar el evento de auditoría en la base de datos: " + e.getMessage());
//        }


    }

    @Override
    public void handle(String s) throws HandlerException {
//        System.out.println("EL METODO DE HANDLE"+s);
    }

    @Override
    public void handle(EventBatch eventBatch) throws HandlerException {
//        System.out.println(eventBatch);

    }

}