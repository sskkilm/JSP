package org.example.mission1.bookmark;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookmarkRepository {

    public void delete(int id) {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "/Users/limseong-geun/Desktop/JSP/Mission1/Mission1.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = " delete from BOOKMARK where ID = ? ";
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

    public BookmarkDto select(int id) {
        BookmarkDto bookmarkDto = new BookmarkDto();

        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "/Users/limseong-geun/Desktop/JSP/Mission1/Mission1.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = " select * from BOOKMARK where ID = ? ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            bookmarkDto.setId(rs.getInt("ID"));
            bookmarkDto.setBookmarkName(rs.getString("BOOKMARK_NAME"));
            bookmarkDto.setWifiName(rs.getString("WIFI_NAME"));
            bookmarkDto.setRegisterDate(rs.getString("REGISTER_DATE"));

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

        return bookmarkDto;
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


        String sql = " select MAX(ID) from BOOKMARK ";
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

    public void save(BookmarkDto bookmarkDto) {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "/Users/limseong-geun/Desktop/JSP/Mission1/Mission1.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = " insert into BOOKMARK values (?, ?, ?, ?) ";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, bookmarkDto.getId());
            ps.setString(2, bookmarkDto.getBookmarkName());
            ps.setString(3, bookmarkDto.getWifiName());
            ps.setString(4, bookmarkDto.getRegisterDate());

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
    public List<BookmarkDto> selectAll() {
        List<BookmarkDto> bookmarkDtoList = new ArrayList<>();

        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFile = "/Users/limseong-geun/Desktop/JSP/Mission1/Mission1.db";
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = " select * from BOOKMARK ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                BookmarkDto bookmarkDto = new BookmarkDto();

                bookmarkDto.setId(rs.getInt("ID"));
                bookmarkDto.setBookmarkName(rs.getString("BOOKMARK_NAME"));
                bookmarkDto.setWifiName(rs.getString("WIFI_NAME"));
                bookmarkDto.setRegisterDate(rs.getString("REGISTER_DATE"));

                bookmarkDtoList.add(bookmarkDto);
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

        return bookmarkDtoList;
    }
}
