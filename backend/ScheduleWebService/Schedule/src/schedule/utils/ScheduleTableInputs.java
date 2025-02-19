package schedule.utils;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ScheduleTableInputs
{
  private String scheduleId;
  private String scheduleCustomer;
  private String scheduleService;
  private String scheduleStatus;
  private String scheduleDate;
  private String scheduleDescription;
  private String scheduleAddedBy;
  private String scheduleAddedDate;

  public void setScheduleId(String scheduleId)
  {
    this.scheduleId = scheduleId;
  }

  public String getScheduleId()
  {
    return scheduleId;
  }

  public void setScheduleCustomer(String scheduleCustomer)
  {
    this.scheduleCustomer = scheduleCustomer;
  }

  public String getScheduleCustomer()
  {
    return scheduleCustomer;
  }

  public void setScheduleService(String scheduleService)
  {
    this.scheduleService = scheduleService;
  }

  public String getScheduleService()
  {
    return scheduleService;
  }

  public void setScheduleStatus(String scheduleStatus)
  {
    this.scheduleStatus = scheduleStatus;
  }

  public String getScheduleStatus()
  {
    return scheduleStatus;
  }

  public void setScheduleDate(String scheduleDate)
  {
    this.scheduleDate = scheduleDate;
  }

  public String getScheduleDate()
  {
    return scheduleDate;
  }

  public void setScheduleDescription(String scheduleDescription)
  {
    this.scheduleDescription = scheduleDescription;
  }

  public String getScheduleDescription()
  {
    return scheduleDescription;
  }

  public void setScheduleAddedBy(String scheduleAddedBy)
  {
    this.scheduleAddedBy = scheduleAddedBy;
  }

  public String getScheduleAddedBy()
  {
    return scheduleAddedBy;
  }

  public void setScheduleAddedDate(String scheduleAddedDate)
  {
    this.scheduleAddedDate = scheduleAddedDate;
  }

  public String getScheduleAddedDate()
  {
    return scheduleAddedDate;
  }
}
