package fr.simplex_software.press_release.domain.tests;

import fr.simplex_software.press_release.domain.dtos.*;
import org.junit.jupiter.api.*;

import java.time.*;

public class TestCreatePressReleaseXmlFile
{
  @Test
  public void createPressReleaseXmlFile()
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
                                                                 "zipCode1",
                                                                 "country1")),
                                                "phoneNumber1",
                                                "emailAddress1"),
                          "pathToLogo1", "pathToHeader1",
                          "pathToContent1", "pathToFinalNote");
    new TestCommon().marshalPressReleaseDtoToXmlFile(pressReleaseDto);
  }
}
