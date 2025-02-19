package schedule.utils;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ChartOutputData
{
  private int id;
  private String group;
  private String series;
  private long value;

  public void setId(int id)
  {
    this.id = id;
  }

  public int getId()
  {
    return id;
  }

  public void setGroup(String group)
  {
    this.group = group;
  }

  public String getGroup()
  {
    return group;
  }

  public void setSeries(String series)
  {
    this.series = series;
  }

  public String getSeries()
  {
    return series;
  }

  public void setValue(long value)
  {
    this.value = value;
  }

  public long getValue()
  {
    return value;
  }
}
