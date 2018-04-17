
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;


//third change
public class Insert {

    public static void main(String arg[]) {
        try {
            Connection con = null; //定义一个MYSQL链接对象
            Class.forName("com.mysql.jdbc.Driver").newInstance(); //MYSQL驱动
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/elec", "root", "112233"); //链接本地MYSQL

            Statement stmt; //创建声明
            stmt = con.createStatement();

            Date start_time = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String s_start_time = df.format(start_time);
            System.out.println("\n************************start_time : " + s_start_time + "************************");// new Date()为获取当前系统时间

            //新增一条数据
            int count =1;
            while(count!=0) {
                stmt.executeUpdate("INSERT INTO `EXPORT_TABLE` VALUES ('01Y0164101', '2014-01-03', '市北供电公司', '银杏路30弄92号501b室', '交流220V', 44694.6)");
                count=count-1;
            }
            Date end_time = new Date();
            String s_end_time = df.format(end_time);
            long time_diff = end_time.getTime() - start_time.getTime();
            System.out.println("\n\nSucceed!" +
                    " It Takes times : " + time_diff +
                    " ms ;\n\n*************************end_time : " + s_end_time + "*************************");//record

           /* String  ret_id;
            if (res.next()) {
                ret_id = res.getString(1);
                System.out.print(ret_id);
            }
            */

        } catch (Exception e) {
            System.out.print("MYSQL ERROR:" + e.getMessage());
        }

    }
}