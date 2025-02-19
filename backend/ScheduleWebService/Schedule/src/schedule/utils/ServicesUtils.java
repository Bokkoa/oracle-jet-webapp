package schedule.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ServicesUtils {
    
    public static Connection getDatabaseConnection()
    {
      Connection conn = null;
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/services", "services", "services12345");
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
      return conn;
    }
    
    public static int executeDMLStatement(String sql) // for insert, update, delete sql statements
    {
      PreparedStatement stat = null;
      Connection conn = null;
      try
      {
        conn = getDatabaseConnection();
        stat = conn.prepareStatement(sql);
        int out = stat.executeUpdate();
        //conn.commit();
        return out;
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
      finally
      {
        try
        {
          stat.close();
          conn.close();
        }
        catch (Exception e)
        {
          //e.printStackTrace();
        }
      }
      return 0;
    }
    
    public static String[] getLatestNoteInfo(String scheduleId)
    {
      PreparedStatement stat = null;
      ResultSet rs = null;
      Connection conn = null;
      String sql = null;
      String[] out = new String[3];
      try
      {
        sql = "select schedule_note_description, schedule_note_added_by, schedule_note_added_date from jet_schedule_notes where schedule_fk = '" + scheduleId + "' order by schedule_note_added_date desc";
        conn = getDatabaseConnection();
        stat = conn.prepareStatement(sql);
        rs = stat.executeQuery();
        while(rs.next())
        {
          out[0] = rs.getString(1);
          out[1] = rs.getString(2);
          out[2] = rs.getString(3);
          return out;
        }
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
      finally
      {
        try
        {
          stat.close();
          conn.close();
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
      return out;
    }
    
    public static String getMonthName(int monthNumber)
    {
      if (monthNumber == 1)
      {
        return "JAN";
      }

      if (monthNumber == 2)
      {
        return "FEB";
      }

      if (monthNumber == 3)
      {
        return "MARCH";
      }

      if (monthNumber == 4)
      {
        return "APRIL";
      }

      if (monthNumber == 5)
      {
        return "MAY";
      }

      if (monthNumber == 6)
      {
        return "JUNE";
      }

      if (monthNumber == 7)
      {
        return "JULY";
      }

      if (monthNumber == 8)
      {
        return "AUG";
      }

      if (monthNumber == 9)
      {
        return "SEB";
      }

      if (monthNumber == 10)
      {
        return "OCT";
      }

      if (monthNumber == 11)
      {
        return "NOV";
      }
      return "DEC";
    }
}
