package schedule.utils;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserTableInputs
{
  private String userName;
  private String userPassword;
  private String userDisplayName;
  private String userActive;
  private String userType;

  public void setUserName(String userName)
  {
    this.userName = userName;
  }

  public String getUserName()
  {
    return userName;
  }

  public void setUserPassword(String userPassword)
  {
    this.userPassword = userPassword;
  }

  public String getUserPassword()
  {
    return userPassword;
  }

  public void setUserDisplayName(String userDisplayName)
  {
    this.userDisplayName = userDisplayName;
  }

  public String getUserDisplayName()
  {
    return userDisplayName;
  }

  public void setUserActive(String userActive)
  {
    this.userActive = userActive;
  }

  public String getUserActive()
  {
    return userActive;
  }

  public void setUserType(String userType)
  {
    this.userType = userType;
  }

  public String getUserType()
  {
    return userType;
  }
}
