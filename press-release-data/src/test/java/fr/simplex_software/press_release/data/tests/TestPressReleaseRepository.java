package fr.simplex_software.press_release.data.tests;

import de.hilling.junit.cdi.*;
import fr.simplex_software.press_release.data.*;
import fr.simplex_software.press_release.domain.commons.*;
import fr.simplex_software.press_release.domain.dtos.*;
import fr.simplex_software.press_release.domain.entities.*;
import fr.simplex_software.press_release.domain.mappers.*;
import lombok.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;

import javax.inject.*;
import java.io.*;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(CdiTestJunitExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPressReleaseRepository extends TestCommons
{
  @Inject
  private PressReleaseRepository pressReleaseRepository;

  @Test
  @Order(1)
  public void testPressreleaseRepositorySholdBeNonNull()
  {
    assertThat(pressReleaseRepository).isNotNull();
  }

  @Test
  @Order(2)
  public void testPressreleaseRepository()
  {
    PressReleaseDto pressReleaseDto = unmarshalXmlFileToPressReleaseDto(
      new File("src/test/resources/pr.xml"));
    assertThat(pressReleaseDto).isNotNull();
    PressReleaseEntity pressReleaseEntity =
      PressReleaseMapper.INSTANCE.toEntity(pressReleaseDto);
    pressReleaseRepository.persist(pressReleaseEntity);
  }
}
