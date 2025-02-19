package schedule.utils;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ScheduleTableFilterInputs
{
  private String status;
  private String customer;
  private String service;
  private String dateFrom;
  private String dateTo;

  public void setStatus(String status)
  {
    this.status = status;
  }

  public String getStatus()
  {
    return status;
  }

  public void setCustomer(String customer)
  {
    this.customer = customer;
  }

  public String getCustomer()
  {
    return customer;
  }

  public void setService(String service)
  {
    this.service = service;
  }

  public String getService()
  {
    return service;
  }

  public void setDateFrom(String dateFrom)
  {
    this.dateFrom = dateFrom;
  }

  public String getDateFrom()
  {
    return dateFrom;
  }

  public void setDateTo(String dateTo)
  {
    this.dateTo = dateTo;
  }

  public String getDateTo()
  {
    return dateTo;
  }
}
