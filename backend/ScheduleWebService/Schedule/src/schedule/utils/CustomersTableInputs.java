package schedule.utils;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomersTableInputs
{
  private String customerId;
  private String customerName;
  private String customerAddress;
  private String customerEmail;
  private String customerWebsite;
  private String customerPhone;
  private String customerDescription;

  public void setCustomerId(String customerId)
  {
    this.customerId = customerId;
  }

  public String getCustomerId()
  {
    return customerId;
  }

  public void setCustomerName(String customerName)
  {
    this.customerName = customerName;
  }

  public String getCustomerName()
  {
    return customerName;
  }

  public void setCustomerAddress(String customerAddress)
  {
    this.customerAddress = customerAddress;
  }

  public String getCustomerAddress()
  {
    return customerAddress;
  }

  public void setCustomerEmail(String customerEmail)
  {
    this.customerEmail = customerEmail;
  }

  public String getCustomerEmail()
  {
    return customerEmail;
  }

  public void setCustomerWebsite(String customerWebsite)
  {
    this.customerWebsite = customerWebsite;
  }

  public String getCustomerWebsite()
  {
    return customerWebsite;
  }

  public void setCustomerPhone(String customerPhone)
  {
    this.customerPhone = customerPhone;
  }

  public String getCustomerPhone()
  {
    return customerPhone;
  }

  public void setCustomerDescription(String customerDescription)
  {
    this.customerDescription = customerDescription;
  }

  public String getCustomerDescription()
  {
    return customerDescription;
  }
}
