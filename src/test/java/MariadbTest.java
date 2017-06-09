import org.testng.annotations.Test;

import java.sql.*;

public class MariadbTest {

    @Test
    public void test() throws ClassNotFoundException, SQLException {
            String myDriver = "org.mariadb.jdbc.Driver";
            String myUrl = "jdbc:mariadb://127.0.0.1:3306/kaa?user=root&password=root\"";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            String querySelect = "SELECT * FROM tenant";
            String queryInsert = "INSERT into tenant VALUES (1, 'test');";

            Statement st = conn.createStatement();

            st.executeQuery(queryInsert);
            ResultSet rs = st.executeQuery(querySelect);

            while (rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                // print the results
                System.out.format("%s, %s", id, name);
            }
            st.close();
            //TODO: assert actual with expected
        }
    }

