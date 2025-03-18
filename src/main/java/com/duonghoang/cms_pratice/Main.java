package com.duonghoang.cms_pratice;

import com.duonghoang.cms_pratice.util.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            DBUtils dbUtils = DBUtils.getInstance();
            Connection connection = dbUtils.getConnection();

            if (connection == null) {
                System.out.println("Kết nối cơ sở dữ liệu không thành công.");
                return;
            }

            if (connection.isClosed()) {
                System.out.println("Kết nối cơ sở dữ liệu đã bị đóng.");
                return;
            }

            System.out.println("Kết nối cơ sở dữ liệu thành công!");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT 1"); // Truy vấn đơn giản
            if (resultSet.next()) {
                System.out.println("Truy vấn kiểm tra thành công. Kết nối hoạt động.");
            } else {
                System.out.println("Truy vấn kiểm tra thất bại.");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Lỗi kiểm tra kết nối: " + e.getMessage());
        }
    }
}
