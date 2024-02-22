package Default;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class ArticleDB {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Properties db = new Properties();
            db.load(new FileInputStream("props.properties"));
            Class.forName("org.mariadb.jdbc.Driver"); // Driver 설정
            conn = DriverManager.getConnection(db.getProperty("url"),
                    db.getProperty("user"),
                    db.getProperty("password"));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn) {
        try {
            if(conn != null) conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertArticle(Article article){
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into article (title, content, writer) values (?,?,?)"; // ? : 바뀌는 내용
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, article.getTitle()); // 첫번째 ?에 데이터 채워준다.
            pstmt.setString(2, article.getContent());
            pstmt.setString(3, article.getWriter());
            int cnt = pstmt.executeUpdate();
            System.out.println(cnt + "개 데이터 삽입");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null) pstmt.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
            close(conn);
        }
    }

    public static void selectArticleByWriter(String writer){
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = String.format("select * from article where writer = ?");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, writer);
            rset = pstmt.executeQuery();

            if(rset != null) {
                while(rset.next()){
                    int num = rset.getInt(1);
                    String title = rset.getString(2);
                    String content = rset.getString(3);
                    String id = rset.getString(4);
                    Article article = new Article(num, title, content, id);
                    System.out.println(article);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rset != null) rset.close();
                if(pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            close(conn);
        }
    }

    public static void updateArticle(int num, String title, String content) {
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        String sql = "update article set title=?, content=? where num=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setInt(3, num);
            int cnt  =pstmt.executeUpdate();
            System.out.println(cnt +"개 데이터 수정");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            close(conn);
        }

    }
    public static void deleteArticle(int num) {
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        String sql = "delete from article where=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            int cnt  = pstmt.executeUpdate();
            System.out.println(cnt +"개 데이터 삭제");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            close(conn);
        }

    }

    public static void main(String[] args) {
//        insertArticle(new Article("스포츠", "축구협회", "gong"));
//        selectArticleByWriter("gong");
//        updateArticle(1,"헤드라인", "창원시, 수소차량 1대단 보조금 3310만 지원");
//        deleteArticle(1);
    }
}