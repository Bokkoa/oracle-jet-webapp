package schedule.utils;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ScheduleNotesInputs
{
  private String noteId;
  private String noteSchedule;
  private String noteDescription;
  private String noteAddedBy;
  private String noteAddedDate;

  public void setNoteId(String noteId)
  {
    this.noteId = noteId;
  }

  public String getNoteId()
  {
    return noteId;
  }

  public void setNoteSchedule(String noteSchedule)
  {
    this.noteSchedule = noteSchedule;
  }

  public String getNoteSchedule()
  {
    return noteSchedule;
  }

  public void setNoteDescription(String noteDescription)
  {
    this.noteDescription = noteDescription;
  }

  public String getNoteDescription()
  {
    return noteDescription;
  }

  public void setNoteAddedBy(String noteAddedBy)
  {
    this.noteAddedBy = noteAddedBy;
  }

  public String getNoteAddedBy()
  {
    return noteAddedBy;
  }

  public void setNoteAddedDate(String noteAddedDate)
  {
    this.noteAddedDate = noteAddedDate;
  }

  public String getNoteAddedDate()
  {
    return noteAddedDate;
  }
}
