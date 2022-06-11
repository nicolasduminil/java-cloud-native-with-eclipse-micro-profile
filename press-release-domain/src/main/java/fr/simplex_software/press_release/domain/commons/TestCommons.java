package fr.simplex_software.press_release.domain.commons;

import fr.simplex_software.press_release.domain.dtos.*;
import jakarta.xml.bind.*;

import java.io.*;

public class TestCommons
{
  public void marshalPressReleaseDtoToXmlFile(
    PressReleaseDto pressReleaseDto)
  {
    try
    {
      Marshaller marshaller =
        JAXBContext.newInstance(PressReleaseDto.class)
                   .createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                             Boolean.TRUE);
      marshaller.marshal(pressReleaseDto, new File(
        "src/test" + "/resources/pr" + ".xml"));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public PressReleaseDto unmarshalXmlFileToPressReleaseDto(File xml)
  {
    PressReleaseDto PressReleaseDto = null;
    try
    {
      PressReleaseDto =
        (PressReleaseDto) JAXBContext.newInstance(PressReleaseDto.class)
                                     .createUnmarshaller()
                                     .unmarshal(xml);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return PressReleaseDto;
  }
}
