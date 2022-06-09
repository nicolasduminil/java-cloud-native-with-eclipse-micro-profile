package fr.simplex_software.press_release.domain.converters;

import jakarta.xml.bind.annotation.adapters.*;

import java.time.*;

import static java.time.format.DateTimeFormatter.*;

public class LocalDateXmlAdapter extends XmlAdapter<String, LocalDate>
{
  @Override
  public LocalDate unmarshal(String localDate)
  {
    return LocalDate.parse(localDate, ISO_LOCAL_DATE);
  }

  @Override
  public String marshal(LocalDate localDate)
  {
    return localDate.format(ISO_LOCAL_DATE);
  }
}
