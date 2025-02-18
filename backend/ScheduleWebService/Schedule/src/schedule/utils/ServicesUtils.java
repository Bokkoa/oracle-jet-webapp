package schedule.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ServicesUtils {
    
    
    
    public static Connection getDbConnection(){
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3606/services", "services", "services1234");
            
        } catch(Exception ex){
            ex.printStackTrace();
        }
        
        return conn;
    }
    
    public static int executeDMLStatement(String sql){
        PreparedStatement stat = null;
        Connection conn = null;
        
        try {
        
            conn = ServicesUtils.getDbConnection();
            stat = conn.prepareStatement(sql);
            
            int out = stat.executeUpdate();
            
            
            return out;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            
            try {
                stat.close();
                conn.close();
            } catch(Exception ex){
                ex.printStackTrace();
            }
            
        }
        
        return 0;
    }
}
