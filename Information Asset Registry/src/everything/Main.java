package everything;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        new Main().test();
    }
    
    public void test() {
        Connection conn = DBUtil.getConnection();
        System.out.println(conn != null);
    }
}
