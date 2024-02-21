package Default;

import java.sql.*;

//Database 처리과정
//1.Database 연결: Connection
//2. SQL 연결

public class DBConnect {
    //	public static void main(String[] args) {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");  //Driver ����tkfkd
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/testdb", "root", "7564");
            System.out.println("DB 연결 성공");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }

    public static void close(Connection conn) {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void insertUser(String id, String name) {
        Statement stmt = null;
        Connection conn = getConnection();
        String sql = String.format("insert into user (id,name) values ('%s','%s')", id, name);
        try {
            stmt = conn.createStatement();
            int cnt = stmt.executeUpdate(sql);
            System.out.println(cnt + "개 데이터 삽입");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            close(conn);
        }
    }

    public static void userInfo(String id) {
        Connection conn = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        String sql = String.format("select id, name from user where id='%s'", id);
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sql);
            if (rset != null && rset.next()) {
                String rid = rset.getString("id");
                String rname = rset.getString("name");
                System.out.println(rid + "," + rname);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) rset.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            close(conn);
        }
    }
    public static void updateUserName(String id, String name){
        Connection conn = getConnection();
        Statement stmt = null;
        String sql = String.format("update user set name = '%s' where id='%s'",name, id);
        try{
            stmt = conn.createStatement();
            int cnt = stmt.executeUpdate(sql);
            System.out.println(cnt+"개 데이터 변경");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            close(conn);
        }
    }
    public static void deleteUser(String id, String name){
        Connection conn = getConnection();
        Statement stmt = null;
        String sql = String.format("delete from user where id='%s'",id);} catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            close(conn);
        }
    }

    public static void allUserInfo() {
        Connection conn = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        String sql = "select from user";


    }

    public static void main(String[] args) {
//        insertUser("song", "송송송");
        updateUserName("song", "송송이");
//        userInfo("song");
        deleteUser("song");

    }
}
