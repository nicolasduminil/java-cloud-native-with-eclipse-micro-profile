package fr.simplex_software.press_release.domain.tests;

import fr.simplex_software.press_release.domain.commons.*;
import fr.simplex_software.press_release.domain.dtos.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.file.*;
import java.time.*;

import static org.assertj.core.api.Assertions.*;

public class TestCreatePressReleaseXmlFile
{
  @Test
  public void createPressReleaseXmlFileShouldSucceed()
  {
    PressReleaseDto pressReleaseDto =
      new PressReleaseDto(null, "pressReleaseName1", LocalDate.now(),
                          new ContactDetailsDto(null, "lastName1",
                                                "firstName1",
                                                new OrganizationDto(
                                                  null,
                                                  "oraganizationName1",
                                                  "organizationRegistrationNumber1",
                                                  new AddressDto(null,
                                                                 "streetAddress1",
                                                                 "city1",
                                                                 "state1",
                                                                 "12345",
                                                                 "country1")),
                                                "phoneNumber1",
                                                "emailAddress1"),
                          "pathToLogo1", "pathToHeader1",
                          "pathToContent1", "pathToFinalNote");
    Path filePath = Paths.get("src/test/resources/pr.xml");
    try
    {
      Files.delete(filePath);
    }
    catch (IOException e)
    {
      fail("### Cannot delete file pr.xml");
      throw new RuntimeException(e);
    }
    new TestCommons().marshalPressReleaseDtoToXmlFile(pressReleaseDto);
    assertThat (Files.exists(filePath)).isTrue();
  }
}
