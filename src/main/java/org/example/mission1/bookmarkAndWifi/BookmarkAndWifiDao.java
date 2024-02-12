package org.example.mission1.bookmarkAndWifi;

import org.example.mission1.bookmark.BookmarkDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookmarkAndWifiDao {

    public BookmarkAndWifiDto select(int id) {
        BookmarkAndWifiDto bookmarkAndWifiDto = new BookmarkAndWifiDto();

        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "/Users/limseong-geun/Desktop/JSP/Mission1/Mission1.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = " select * from BOOKMARK_AND_WIFI where BOOKMARK_ID = ? ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            bookmarkAndWifiDto.setBookmarkId(rs.getInt("BOOKMARK_ID"));
            bookmarkAndWifiDto.setWifiId(rs.getString("WIFI_ID"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return bookmarkAndWifiDto;
    }
    public void save(BookmarkAndWifiDto bookmarkAndWifiDto) {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "/Users/limseong-geun/Desktop/JSP/Mission1/Mission1.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = " insert into BOOKMARK_AND_WIFI values (?, ?) ";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, bookmarkAndWifiDto.getBookmarkId());
            ps.setString(2, bookmarkAndWifiDto.getWifiId());

            int affected = ps.executeUpdate();
            if (affected > 0) {
                System.out.println("저장 성공");
            } else {
                System.out.println("저장 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
