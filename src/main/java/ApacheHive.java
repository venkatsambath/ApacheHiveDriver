import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;


public class ApacheHive
{
    public static void main(final String[] args) throws SQLException {
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        final Connection con = DriverManager.getConnection("jdbc:hive2://xxxx:10000/;principal=hive/_HOST@C6CITIDSE.COM");
        final Statement stmt = con.createStatement();
        stmt.setFetchSize(10000);
        stmt.setMaxRows(10000);
        ResultSet res = stmt.executeQuery("select * from airline_data.airlines_1million limit 370000");
        long time_1 = System.currentTimeMillis();
        while (res.next()) {
     //       System.out.println(res.getString(1));
        }
        long time_2 = System.currentTimeMillis();
        long difference = time_1 - time_2;
        System.out.println( difference + "milliseconds" );
        System.out.println( difference + "Tom" );

    }
}
