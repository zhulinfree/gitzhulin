
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Date;

//third change
public class Delete {

    public static void main(String arg[]) {
        try {
            Connection con = null; //定义一个MYSQL链接对象
            Class.forName("com.mysql.jdbc.Driver").newInstance(); //MYSQL驱动
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/elec", "root", "112233"); //链接本地MYSQL

            Statement stmt; //创建声明
            stmt = con.createStatement();

            //删除一条数据
           // String sql = "DELETE FROM export_table WHERE MADE_NO='01Y0164101'";
            String sql = "DELETE FROM export_table";

            Date start_time = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String s_start_time = df.format(start_time);
            System.out.println("\n************************start_time : " + s_start_time + "************************");// new Date()为获取当前系统时间


            long deleteRes = stmt.executeUpdate(sql); //如果为0则没有进行删除操作，如果大于0，则记录删除的条数


            Date end_time = new Date();
            String s_end_time = df.format(end_time);
            long time_diff = end_time.getTime() - start_time.getTime();
            System.out.println("\n\nSucceed!" +
                    " It Takes times : " + time_diff +
                    " ms ;\n\n*************************end_time : " + s_end_time + "*************************");//record

            System.out.print("DELETE:" + deleteRes);


        } catch (Exception e) {
            System.out.print("MYSQL ERROR:" + e.getMessage());
        }

    }
}