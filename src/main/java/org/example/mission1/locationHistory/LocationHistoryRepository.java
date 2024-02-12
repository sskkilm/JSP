package org.example.mission1.locationHistory;

import org.example.mission1.wifiInfo.WifiInfoDto;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LocationHistoryRepository {
    public void delete(int id) {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "/Users/limseong-geun/Desktop/JSP/Mission1/Mission1.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = " delete from LOCATION_HISTORY where ID = ? ";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int affected = ps.executeUpdate();
            if (affected > 0) {
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제 실패");
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

    public int getMaxId() {
        int id = 0;

        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "/Users/limseong-geun/Desktop/JSP/Mission1/Mission1.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }


        String sql = " select MAX(ID) from LOCATION_HISTORY ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            id = rs.getInt("MAX(ID)");
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

        return id;
    }

    public void save(LocationHistoryDto locationHistoryDto) {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "/Users/limseong-geun/Desktop/JSP/Mission1/Mission1.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        PreparedStatement ps = null;
        String sql = " insert into LOCATION_HISTORY " +
                " values (?, ?, ?, ?) ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, locationHistoryDto.getId());
            ps.setDouble(2, locationHistoryDto.getGpsX());
            ps.setDouble(3, locationHistoryDto.getGpsY());
            ps.setString(4, locationHistoryDto.getViewDate());

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

    public List<LocationHistoryDto> selectAll() {
        List<LocationHistoryDto> locationHistoryDtoList = new ArrayList<>();

        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "/Users/limseong-geun/Desktop/JSP/Mission1/Mission1.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = " select * from LOCATION_HISTORY ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                LocationHistoryDto locationHistoryDto = new LocationHistoryDto();

                locationHistoryDto.setId(rs.getInt("ID"));
                locationHistoryDto.setGpsX(rs.getDouble("GPS_X"));
                locationHistoryDto.setGpsY(rs.getDouble("GPS_Y"));
                locationHistoryDto.setViewDate(rs.getString("VIEW_DATE"));

                locationHistoryDtoList.add(locationHistoryDto);
            }
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

        return locationHistoryDtoList;
    }
}
