package schedule.utils;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DashboardNextActivityData
{
  private String serviceName;
  private String serviceDate;
  private String serviceCustomer;
  private String serviceDescription;
  private String lastNote;
  private String lastNoteAddedBy;
  private String lastNoteAddedDate;

  public void setServiceName(String serviceName)
  {
    this.serviceName = serviceName;
  }

  public String getServiceName()
  {
    return serviceName;
  }

  public void setServiceDate(String serviceDate)
  {
    this.serviceDate = serviceDate;
  }

  public String getServiceDate()
  {
    return serviceDate;
  }

  public void setServiceCustomer(String serviceCustomer)
  {
    this.serviceCustomer = serviceCustomer;
  }

  public String getServiceCustomer()
  {
    return serviceCustomer;
  }

  public void setServiceDescription(String serviceDescription)
  {
    this.serviceDescription = serviceDescription;
  }

  public String getServiceDescription()
  {
    return serviceDescription;
  }

  public void setLastNote(String lastNote)
  {
    this.lastNote = lastNote;
  }

  public String getLastNote()
  {
    return lastNote;
  }

  public void setLastNoteAddedBy(String lastNoteAddedBy)
  {
    this.lastNoteAddedBy = lastNoteAddedBy;
  }

  public String getLastNoteAddedBy()
  {
    return lastNoteAddedBy;
  }

  public void setLastNoteAddedDate(String lastNoteAddedDate)
  {
    this.lastNoteAddedDate = lastNoteAddedDate;
  }

  public String getLastNoteAddedDate()
  {
    return lastNoteAddedDate;
  }
}
