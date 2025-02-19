package schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import schedule.utils.ChartOutputData;
import schedule.utils.CustomersTableInputs;
import schedule.utils.DashboardNextActivityData;
import schedule.utils.ScheduleNotesInputs;
import schedule.utils.ScheduleTableFilterInputs;
import schedule.utils.ScheduleTableInputs;
import schedule.utils.ServciesTableInputs;
import schedule.utils.ServicesUtils;
import schedule.utils.UserInfo;
import schedule.utils.UserTableInputs;

@Path("ScheduleServices")
public class ScheduleWebServices
{
 
 /***********  jet_services table web services *****************************/

  @GET
  @Path("/getServices")
  @Produces(MediaType.APPLICATION_JSON)
  public List<ServciesTableInputs> getServices()
  {
    PreparedStatement stat = null;
    ResultSet rs = null;
    Connection conn = null;
    String sql = null;
    List<ServciesTableInputs> servicesList = new ArrayList<ServciesTableInputs>();
    try
    {
      sql = "SELECT service_name, service_description FROM jet_services";
      conn = ServicesUtils.getDatabaseConnection();
      stat = conn.prepareStatement(sql);
      rs = stat.executeQuery();
      while(rs.next())
      {
        ServciesTableInputs service = new ServciesTableInputs();
        service.setServiceName(rs.getString(1));
        service.setServiceDescription(rs.getString(2));
        servicesList.add(service);
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
        rs.close();
        stat.close();
        conn.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return servicesList;
  }
  
  @POST
  @Path("/insertService")
  @Produces(MediaType.APPLICATION_JSON)
  public String insertNewService(ServciesTableInputs input)
  {
    try
    {
      int rowInserted = ServicesUtils.executeDMLStatement("INSERT INTO jet_services (`service_name`, `service_description`) VALUES ('" +
                                       input.getServiceName() + "', '" + input.getServiceDescription() + "')");
      if(rowInserted > 0)
      {
        return "Y";
      }
      
    }
    catch (Exception e)
    {
      // TODO: Add catch code
      e.printStackTrace();
    }
    return "N";
  }
  
  
  @POST
  @Path("/updateService")
  @Produces(MediaType.APPLICATION_JSON)
  public String updateService(ServciesTableInputs input)
  {
    try
    {
      ServicesUtils.executeDMLStatement("UPDATE jet_services SET `service_description` = '"+input.getServiceDescription()+"' WHERE (`service_name` = '"+input.getServiceName()+"')");
      return "Y";
    }
    catch (Exception e)
    {
      // TODO: Add catch code
      e.printStackTrace();
    }
    return "N";
  }
  
  
  @POST
  @Path("/deleteService")
  @Produces(MediaType.APPLICATION_JSON)
  public String deleteService(ServciesTableInputs input)
  {
    try
    {
      ServicesUtils.executeDMLStatement("DELETE FROM jet_services WHERE (`service_name` = '" + input.getServiceName() + "')");
      return "Y";
    }
    catch (Exception e)
    {
      // TODO: Add catch code
      e.printStackTrace();
    }
    return "N";
  }

/************************ End of jet_services table ******************************************/
  
  
  


 /**********************  jet_customers table web services *****************************/

  @GET
  @Path("/getCustomers")
  @Produces(MediaType.APPLICATION_JSON)
  public List<CustomersTableInputs> getCustomers()
  {
    PreparedStatement stat = null;
    ResultSet rs = null;
    Connection conn = null;
    String sql = null;
    List<CustomersTableInputs> customersList = new ArrayList<CustomersTableInputs>();
    try
    {
      sql = "SELECT customer_id, customer_name, customer_address, customer_email, customer_website, customer_phone,customer_description FROM jet_customers";
      conn = ServicesUtils.getDatabaseConnection();
      stat = conn.prepareStatement(sql);
      rs = stat.executeQuery();
      while(rs.next())
      {
        CustomersTableInputs customer = new CustomersTableInputs();
        customer.setCustomerId(rs.getString(1));
        customer.setCustomerName(rs.getString(2));
        customer.setCustomerAddress((rs.getString(3) == null ? "" : rs.getString(3)));
        customer.setCustomerEmail((rs.getString(4) == null ? "" : rs.getString(4)));
        customer.setCustomerWebsite((rs.getString(5) == null ? "" : rs.getString(5)));
        customer.setCustomerPhone((rs.getString(6) == null ? "" : rs.getString(6)));
        customer.setCustomerDescription((rs.getString(7) == null ? "" : rs.getString(7)));
        customersList.add(customer);
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
        rs.close();
        stat.close();
        conn.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return customersList;
  }
  
  @POST
  @Path("/insertCustomer")
  @Produces(MediaType.APPLICATION_JSON)
  public String insertNewCustomer(CustomersTableInputs input)
  {
    try
    {
      ServicesUtils.executeDMLStatement("INSERT INTO jet_customers (`customer_id`, `customer_name`, `customer_address`, `customer_email`, `customer_website`, `customer_phone`, `customer_description`) VALUES ('" + input.getCustomerId() + "', '" + input.getCustomerName() + "', '" + input.getCustomerAddress() + "', '" + input.getCustomerEmail() + "', '" + input.getCustomerWebsite() + "', '" + input.getCustomerPhone() + "', '" + input.getCustomerDescription() + "')");
      return "Y";
    }
    catch (Exception e)
    {
      // TODO: Add catch code
      e.printStackTrace();
    }
    return "N";
  }
  
  
  @POST
  @Path("/updateCustomer")
  @Produces(MediaType.APPLICATION_JSON)
  public String updateCustomer(CustomersTableInputs input)
  {
    try
    {
      ServicesUtils.executeDMLStatement("UPDATE jet_customers SET `customer_name` = '" + input.getCustomerName() + "', `customer_address` = '" + input.getCustomerAddress() + "', `customer_email` = '" + input.getCustomerEmail() + "', `customer_website` = '" + input.getCustomerWebsite() + "', `customer_phone` = '" + input.getCustomerPhone() + "', `customer_description` = '" + input.getCustomerDescription() + "' WHERE (`customer_id` = '" + input.getCustomerId() + "')");
      return "Y";
    }
    catch (Exception e)
    {
      // TODO: Add catch code
      e.printStackTrace();
    }
    return "N";
  }
  
  
  @POST
  @Path("/deleteCustomer")
  @Produces(MediaType.APPLICATION_JSON)
  public String deleteCustomer(CustomersTableInputs input)
  {
    try
    {
      ServicesUtils.executeDMLStatement("DELETE FROM jet_customers WHERE (`customer_id` = '" + input.getCustomerId() + "')");
      return "Y";
    }
    catch (Exception e)
    {
      // TODO: Add catch code
      e.printStackTrace();
    }
    return "N";
  }

/************************ End of jet_customers table ******************************************/  
  
  
  
  
   /***********  jet_users table web services *****************************/

  @GET
  @Path("/getUsers")
  @Produces(MediaType.APPLICATION_JSON)
  public List<UserTableInputs> getUsers()
  {
    PreparedStatement stat = null;
    ResultSet rs = null;
    Connection conn = null;
    String sql = null;
    List<UserTableInputs> usersList = new ArrayList<UserTableInputs>();
    try
    {
      sql = "SELECT user_name, user_password, user_display_name, user_active, user_type FROM services.jet_users";
      conn = ServicesUtils.getDatabaseConnection();
      stat = conn.prepareStatement(sql);
      rs = stat.executeQuery();
      while(rs.next())
      {
        UserTableInputs user = new UserTableInputs();
        user.setUserName(rs.getString(1));
        user.setUserPassword(rs.getString(2));
        user.setUserDisplayName(rs.getString(3));
        user.setUserActive(rs.getString(4));
        user.setUserType(rs.getString(5));
        usersList.add(user);
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
        rs.close();
        stat.close();
        conn.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return usersList;
  }
  
  @POST
  @Path("/insertUser")
  @Produces(MediaType.APPLICATION_JSON)
  public String insertNewUser(UserTableInputs input)
  {
    try
    {
      ServicesUtils.executeDMLStatement("INSERT INTO jet_users (`user_name`, `user_password`, `user_display_name`, `user_active`, `user_type`) VALUES ('" + input.getUserName() + "', '" + input.getUserPassword() + "', '" + input.getUserDisplayName() + "', '" + input.getUserActive() + "', '" + input.getUserType() + "')");
      return "Y";
    }
    catch (Exception e)
    {
      // TODO: Add catch code
      e.printStackTrace();
    }
    return "N";
  }
  
  
  @POST
  @Path("/updateUser")
  @Produces(MediaType.APPLICATION_JSON)
  public String updateUser(UserTableInputs input)
  {
    try
    {
      ServicesUtils.executeDMLStatement("UPDATE jet_users SET `user_password` = '" + input.getUserPassword() + "', `user_display_name` = '" + input.getUserDisplayName() + "', `user_active` = '" + input.getUserActive() + "', `user_type` = '" + input.getUserType() + "' WHERE (`user_name` = '" + input.getUserName() + "')");
      return "Y";
    }
    catch (Exception e)
    {
      // TODO: Add catch code
      e.printStackTrace();
    }
    return "N";
  }
  
  
  @POST
  @Path("/deleteUser")
  @Produces(MediaType.APPLICATION_JSON)
  public String deleteUser(UserTableInputs input)
  {
    try
    {
      ServicesUtils.executeDMLStatement("DELETE FROM jet_users WHERE (`user_name` = '" + input.getUserName() + "')");
      return "Y";
    }
    catch (Exception e)
    {
      // TODO: Add catch code
      e.printStackTrace();
    }
    return "N";
  }

/************************ End of jet_users table ******************************************/
  
  
  
  
/*********************  jet_services_schedule table web services *****************************/

  @POST
  @Path("/getSchedule")
  @Produces(MediaType.APPLICATION_JSON)
  public List<ScheduleTableInputs> getSchedule(ScheduleTableFilterInputs filter)
  {
    PreparedStatement stat = null;
    ResultSet rs = null;
    Connection conn = null;
    String sql = null;
    List<ScheduleTableInputs> scheduleList = new ArrayList<ScheduleTableInputs>();
    try
    {
      String where = null;
      if(filter.getCustomer() != null && !filter.getCustomer().trim().equals("") && !filter.getCustomer().equals("ALL"))
      {
        where = "schedule_customer_fk = '" + filter.getCustomer() + "'";
      }
      
      if(filter.getService() != null && !filter.getService().trim().equals("") && !filter.getService().equals("ALL"))
      {
        if(where == null)
        {
          where = "schedule_service_fk='" + filter.getService() + "'";
        }
        else
        {
          where = where + " and schedule_service_fk='" + filter.getService() + "'";
        }
      }
      
      if(filter.getStatus() != null && !filter.getStatus().trim().equals("") && !filter.getStatus().equals("ALL"))
      {
        if(where == null)
        {
          where = "schedule_status='" + filter.getStatus() + "'";
        }
        else
        {
          where = where + " and schedule_status='" + filter.getStatus() + "'";
        }
      }
      
      if(filter.getDateFrom() == null || filter.getDateFrom().trim().equals(""))
      {
        filter.setDateFrom("2000-01-01");
      }
      
      if(filter.getDateTo() == null || filter.getDateTo().trim().equals(""))
      {
        filter.setDateFrom("2050-01-01");
      }

      if(where == null)
      {
        where = "date(schedule_date) between date('" + filter.getDateFrom() + "') and date('" + filter.getDateTo() + "')";
      }
      else
      {
        where = where + " and date(schedule_date) between date('" + filter.getDateFrom() + "') and date('" + filter.getDateTo() + "')";
      }
      
      
      System.out.println("where: " + where);
      
    
      sql = "SELECT schedule_id, schedule_customer_fk, schedule_service_fk, schedule_status, schedule_description, schedule_date, schedule_added_by, schedule_added_date FROM jet_services_schedule where " + where + " order by schedule_date asc";
      conn = ServicesUtils.getDatabaseConnection();
      stat = conn.prepareStatement(sql);
      rs = stat.executeQuery();
      while(rs.next())
      {
        ScheduleTableInputs schedule = new ScheduleTableInputs();
        schedule.setScheduleId(rs.getString(1));
        schedule.setScheduleCustomer(rs.getString(2));
        schedule.setScheduleService(rs.getString(3));
        schedule.setScheduleStatus(rs.getString(4));
        schedule.setScheduleDescription(rs.getString(5));
        schedule.setScheduleDate(rs.getString(6) == null ? "" : rs.getString(6).split(" ")[0]);
        schedule.setScheduleAddedBy(rs.getString(7));
        schedule.setScheduleAddedDate(rs.getString(8) == null ? "" : rs.getString(8).split(" ")[0]);
        scheduleList.add(schedule);
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
        rs.close();
        stat.close();
        conn.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return scheduleList;
  }
  
  @POST
  @Path("/insertSchedule")
  @Produces(MediaType.APPLICATION_JSON)
  public String insertNewSchedule(ScheduleTableInputs input)
  {
    try
    {
      ServicesUtils.executeDMLStatement("INSERT INTO jet_services_schedule (`schedule_customer_fk`, `schedule_service_fk`, `schedule_status`, `schedule_description`, `schedule_date`, `schedule_added_by`, `schedule_added_date`) VALUES ('" + input.getScheduleCustomer() + "', '" + input.getScheduleService() + "', '" + input.getScheduleStatus() + "', '" + input.getScheduleDescription() + "', '" + input.getScheduleDate() + "', '" + input.getScheduleAddedBy() + "', sysdate())");
      return "Y";
    }
    catch (Exception e)
    {
      // TODO: Add catch code
      e.printStackTrace();
    }
    return "N";
  }
  
  
  @POST
  @Path("/updateSchedule")
  @Produces(MediaType.APPLICATION_JSON)
  public String updateSchedule(ScheduleTableInputs input)
  {
    try
    {
      ServicesUtils.executeDMLStatement("UPDATE jet_services_schedule SET `schedule_customer_fk` = '" + input.getScheduleCustomer() + "', `schedule_service_fk` = '" + input.getScheduleService() + "', `schedule_status` = '" + input.getScheduleStatus() + "', `schedule_description` = '" + input.getScheduleDescription() + "', `schedule_date` = '" + input.getScheduleDate() + "' WHERE (`schedule_id` = '" + input.getScheduleId() + "')");
      return "Y";
    }
    catch (Exception e)
    {
      // TODO: Add catch code
      e.printStackTrace();
    }
    return "N";
  }
  
  @POST
  @Path("/changeScheduleStatus")
  @Produces(MediaType.APPLICATION_JSON)
  public String changeScheduleStatus(ScheduleTableInputs input)
  {
    try
    {
      ServicesUtils.executeDMLStatement("UPDATE jet_services_schedule SET `schedule_status` = '" + input.getScheduleStatus() + "' WHERE (`schedule_id` = '" + input.getScheduleId() + "')");
      
      if(input.getScheduleDescription() != null && !input.getScheduleDescription().trim().equals(""))
      {
        ServicesUtils.executeDMLStatement("INSERT INTO jet_schedule_notes (`schedule_fk`, `schedule_note_description`, `schedule_note_added_by`, `schedule_note_added_date`) VALUES ('" + input.getScheduleId() + "', '" + input.getScheduleDescription() + "', '" + input.getScheduleAddedBy() + "', sysdate())");
      }
      
      return "Y";
    }
    catch (Exception e)
    {
      // TODO: Add catch code
      e.printStackTrace();
    }
    return "N";
  }


/************************ End of jet_services_schedule table ******************************************/
  
  
  
  
     /***********  jet_schedule_notes table web services *****************************/

  @GET
  @Path("/getScheduleNotes")
  @Produces(MediaType.APPLICATION_JSON)
  public List<ScheduleNotesInputs> getScheduleNotes(@QueryParam("scheduleId") String scheduleId)
  {
    PreparedStatement stat = null;
    ResultSet rs = null;
    Connection conn = null;
    String sql = null;
    List<ScheduleNotesInputs> notesList = new ArrayList<ScheduleNotesInputs>();
    try
    {
      sql = "SELECT schedule_note_pk, schedule_fk, schedule_note_description, schedule_note_added_by, schedule_note_added_date FROM jet_schedule_notes where schedule_fk = '" + scheduleId + "' order by schedule_note_added_date desc";
      conn = ServicesUtils.getDatabaseConnection();
      stat = conn.prepareStatement(sql);
      rs = stat.executeQuery();
      while(rs.next())
      {
        ScheduleNotesInputs note = new ScheduleNotesInputs();
        note.setNoteId(rs.getString(1));
        note.setNoteSchedule(rs.getString(2));
        note.setNoteDescription(rs.getString(3));
        note.setNoteAddedBy(rs.getString(4));
        note.setNoteAddedDate(rs.getString(5));
        notesList.add(note);
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
        rs.close();
        stat.close();
        conn.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return notesList;
  }
  
  @POST
  @Path("/insertScheduleNote")
  @Produces(MediaType.APPLICATION_JSON)
  public String insertNewScheduleNote(ScheduleNotesInputs input)
  {
    try
    {
      ServicesUtils.executeDMLStatement("INSERT INTO jet_schedule_notes (`schedule_fk`, `schedule_note_description`, `schedule_note_added_by`, `schedule_note_added_date`) VALUES ('" + input.getNoteSchedule() + "', '" + input.getNoteDescription() + "', '" + input.getNoteAddedBy() + "', sysdate())");
      return "Y";
    }
    catch (Exception e)
    {
      // TODO: Add catch code
      e.printStackTrace();
    }
    return "N";
  }
  
  
  @POST
  @Path("/updateScheduleNote")
  @Produces(MediaType.APPLICATION_JSON)
  public String updateScheduleNote(ScheduleNotesInputs input)
  {
    try
    {
      ServicesUtils.executeDMLStatement("UPDATE jet_schedule_notes SET `schedule_note_description` = '" + input.getNoteDescription() + "' WHERE (`schedule_note_pk` = '" + input.getNoteId() + "')");
      return "Y";
    }
    catch (Exception e)
    {
      // TODO: Add catch code
      e.printStackTrace();
    }
    return "N";
  }
  
  
  @POST
  @Path("/deleteScheduleNote")
  @Produces(MediaType.APPLICATION_JSON)
  public String deleteScheduleNote(ScheduleNotesInputs input)
  {
    try
    {
      ServicesUtils.executeDMLStatement("DELETE FROM jet_schedule_notes WHERE (`schedule_note_pk` = '" + input.getNoteId() + "')");
      return "Y";
    }
    catch (Exception e)
    {
      // TODO: Add catch code
      e.printStackTrace();
    }
    return "N";
  }

/************************ End of jet_schedule_notes table ******************************************/
  
  
/********************** Dashboard Next Service **************************************************/
  
  @GET
  @Path("/getNextService")
  @Produces(MediaType.APPLICATION_JSON)
  public List<DashboardNextActivityData> getNextService()
  {
    PreparedStatement stat = null;
    ResultSet rs = null;
    Connection conn = null;
    String sql = null;
    List<DashboardNextActivityData>  servicesList = new ArrayList<DashboardNextActivityData>();

    try
    {
      sql = "select schedule_id, schedule_customer_fk, schedule_service_fk, schedule_description, schedule_date from jet_services_schedule where schedule_status = 'ACTIVE' order by schedule_date asc";
      conn = ServicesUtils.getDatabaseConnection();
      stat = conn.prepareStatement(sql);
      rs = stat.executeQuery();
      while(rs.next())
      {
        DashboardNextActivityData service = new DashboardNextActivityData();
        service.setServiceName(rs.getString(3));
        service.setServiceDate(rs.getString(5));
        service.setServiceCustomer(rs.getString(2));
        service.setServiceDescription(rs.getString(4));
        String[] noteData = ServicesUtils.getLatestNoteInfo(rs.getString(1));
        service.setLastNote(noteData[0] == null ? "" : (noteData[0]));
        service.setLastNoteAddedBy(noteData[1] == null ? "" : (noteData[1]));
        service.setLastNoteAddedDate(noteData[2] == null ? "" : (noteData[2]));
        servicesList.add(service);
        break;
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
        rs.close();
        stat.close();
        conn.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return servicesList;
  }
  
/*********************** End of Dashboard Next Activity ********************************************/


/********************** Dashboard Services this month **************************************************/
  
  @GET
  @Path("/getServicesThisMonth")
  @Produces(MediaType.APPLICATION_JSON)
  public List<ChartOutputData> getServicesThisMonth()
  {
    PreparedStatement stat = null;
    ResultSet rs = null;
    Connection conn = null;
    String sql = null;
    List<ChartOutputData> outList = new ArrayList<ChartOutputData>();
    try
    {
      sql = "select count(schedule_service_fk), schedule_service_fk from jet_services_schedule where MONTH(`schedule_date`) = MONTH (sysdate()) and YEAR(`schedule_date`) = YEAR (sysdate()) and schedule_status = 'ACTIVE' group by schedule_service_fk";
      conn = ServicesUtils.getDatabaseConnection();
      stat = conn.prepareStatement(sql);
      rs = stat.executeQuery();
      int id = 0;
      while(rs.next())
      {
        ChartOutputData out = new ChartOutputData();
        id++;
        out.setId(id);
        out.setGroup(rs.getString(2));
        out.setSeries(rs.getString(2));
        out.setValue(rs.getLong(1));
        outList.add(out);
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
        rs.close();
        stat.close();
        conn.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return outList;
  }
  
/*********************** End of Dashboard Services this month ********************************************/


/********************** Dashboard Services this Year **************************************************/
  
  @GET
  @Path("/getServicesThisYear")
  @Produces(MediaType.APPLICATION_JSON)
  public List<ChartOutputData> getServicesThisYear()
  {
    PreparedStatement stat = null;
    ResultSet rs = null;
    Connection conn = null;
    String sql = null;
    List<ChartOutputData> outList = new ArrayList<ChartOutputData>();
    try
    {
      sql = "select count(schedule_service_fk), schedule_service_fk, MONTH(`schedule_date`) from jet_services_schedule where YEAR(`schedule_date`) = YEAR (sysdate()) and schedule_status = 'ACTIVE' group by schedule_service_fk, MONTH(`schedule_date`) order by MONTH(`schedule_date`) asc";
      conn = ServicesUtils.getDatabaseConnection();
      stat = conn.prepareStatement(sql);
      rs = stat.executeQuery();
      int id = 0;
      while(rs.next())
      {
        ChartOutputData out = new ChartOutputData();
        id++;
        out.setId(id);
        out.setGroup(ServicesUtils.getMonthName(rs.getInt(3)));
        out.setSeries(rs.getString(2));
        out.setValue(rs.getLong(1));
        outList.add(out);
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
        rs.close();
        stat.close();
        conn.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return outList;
  }
  
/*********************** End of Dashboard Services this Year ********************************************/



/********************** Dashboard Services per customer **************************************************/
  
  @GET
  @Path("/getServicesPerCustomer")
  @Produces(MediaType.APPLICATION_JSON)
  public List<ChartOutputData> getServicesPerCustomer()
  {
    PreparedStatement stat = null;
    ResultSet rs = null;
    Connection conn = null;
    String sql = null;
    List<ChartOutputData> outList = new ArrayList<ChartOutputData>();
    try
    {
      sql = "select count(schedule_customer_fk), schedule_customer_fk from jet_services_schedule group by schedule_customer_fk";
      conn = ServicesUtils.getDatabaseConnection();
      stat = conn.prepareStatement(sql);
      rs = stat.executeQuery();
      int id = 0;
      while(rs.next())
      {
        ChartOutputData out = new ChartOutputData();
        id++;
        out.setId(id);
        out.setGroup(rs.getString(2));
        out.setSeries(rs.getString(2));
        out.setValue(rs.getLong(1));
        outList.add(out);
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
        rs.close();
        stat.close();
        conn.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return outList;
  }
  
/*********************** End of Dashboard Services this Year ********************************************/

  @POST
  @Path("/login")
  @Produces(MediaType.APPLICATION_JSON)
  public List<UserInfo> login(UserInfo input)
  {
    List<UserInfo> userList = new ArrayList<UserInfo>();
    PreparedStatement stat = null;
    ResultSet rs = null;
    Connection conn = null;
    String sql = null;
    try
    {
      sql = "select user_display_name, user_active, user_type from jet_users where user_name ='" + input.getUsername() + "' and user_password= '" + input.getPassword() + "'";
      conn = ServicesUtils.getDatabaseConnection();
      stat = conn.prepareStatement(sql);
      rs = stat.executeQuery();
      int id = 0;
      while(rs.next())
      {
        UserInfo user = new UserInfo();
        if(rs.getString(2) != null && rs.getString(2).trim().equals("Y"))
        {
          
          user.setDisplayName(rs.getString(1));
          user.setType(rs.getString(3));
          user.setUsername(input.getUsername());
          user.setMessage("");
          userList.add(user);
          return userList;
        }
        else
        {
          user.setMessage("User is not active. Please back to the system administrator");
          userList.add(user);
          return userList;
        }
        
      }
      UserInfo user = new UserInfo();
      user.setMessage("Invalid username or password");
      userList.add(user);
      return userList;
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        rs.close();
        stat.close();
        conn.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    UserInfo user = new UserInfo();
    user.setMessage("Error in Login. Please contact system administrator");
    userList.add(user);
    return userList;
  }


}
