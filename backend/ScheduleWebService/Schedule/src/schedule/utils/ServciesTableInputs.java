package schedule.utils;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ServciesTableInputs
{
  private String serviceName;
  private String serviceDescription;

  public void setServiceName(String serviceName)
  {
    this.serviceName = serviceName;
  }

  public String getServiceName()
  {
    return serviceName;
  }

  public void setServiceDescription(String serviceDescription)
  {
    this.serviceDescription = serviceDescription;
  }

  public String getServiceDescription()
  {
    return serviceDescription;
  }
}
