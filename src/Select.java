

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.company.DBHelper;

public class Select {

    static String sql = null;
    static DBHelper db1 = null;
    static ResultSet ret = null;

    public static void main(String[] args) {
        sql = "select * from export_table where A='市北供电公司'";//SQL语句
        db1 = new DBHelper(sql);//创建DBHelper对象
		//look me ,I am playing github!
        try {
            Date start_time = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String s_start_time = df.format(start_time);
            System.out.println("\n************************start_time : " + s_start_time + "************************");// new Date()为获取当前系统时间


            ret = db1.pst.executeQuery();//执行语句，得到结果集


            Date end_time = new Date();
            String s_end_time = df.format(end_time);
            //      时间差
            long time_diff = end_time.getTime() - start_time.getTime();

            System.out.println("\n\nSucceed!" +
                    " It Takes times : " + time_diff +
                    " ms ;\n\n*************************end_time : " + s_end_time + "*************************");//record

            int count=0;
            while (ret.next()) {
                count++;
             /*   String uid = ret.getString(1);
                String ufname = ret.getString(2);
                String ulname = ret.getString(3);
                String udate = ret.getString(4);
                System.out.println(uid + "\t" + ufname + "\t" + ulname + "\t" + udate );
*/
            }//显示数据

            System.out.println("datacount="+count);
            ret.close();
            db1.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}