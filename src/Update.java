
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Update {

    public static void main(String arg[]) {
        try {
            Connection con = null; //定义一个MYSQL链接对象
            Class.forName("com.mysql.jdbc.Driver").newInstance(); //MYSQL驱动
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/elec", "root", "112233"); //链接本地MYSQL

            Statement stmt; //创建声明
            stmt = con.createStatement();

            //更新一条数据
           String updateSql = "UPDATE export_table SET DATA_DATE = '2014-01-03' ,A='市北供电公司',ELEC_ADDR='银杏路30弄92号501室',PAP_R='44694.6' ";

          //String updateSql = "UPDATE export_table SET DATA_DATE = '2014-01-19' ,A='青浦供电公司'";
         //   String updateSql = "UPDATE export_table SET A='市区供电公司'";
            Date start_time = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String s_start_time = df.format(start_time);
            System.out.println("\n************************start_time : " + s_start_time + "************************");// new Date()为获取当前系统时间




            long updateRes = stmt.executeUpdate(updateSql);


            Date end_time = new Date();
            String s_end_time = df.format(end_time);
            long time_diff = end_time.getTime() - start_time.getTime();

            System.out.println("\n\nSucceed!" +
                    " It Takes times : " + time_diff +
                    " ms ;\n\n*************************end_time : " + s_end_time + "*************************");//record



            System.out.print("UPDATE:" + updateRes);

        } catch (Exception e) {
            System.out.print("MYSQL ERROR:" + e.getMessage());
        }

    }
}