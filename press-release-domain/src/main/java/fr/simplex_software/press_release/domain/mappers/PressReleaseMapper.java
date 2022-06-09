package fr.simplex_software.press_release.domain.mappers;

import fr.simplex_software.press_release.domain.dtos.*;
import fr.simplex_software.press_release.domain.entities.*;
import org.mapstruct.*;
import org.mapstruct.factory.*;

@Mapper
public interface PressReleaseMapper
{
  public PressReleaseMapper INSTANCE =
    Mappers.getMapper(PressReleaseMapper.class);

  public PressReleaseDto fromEntity(
    PressReleaseEntity pressReleaseEntity);

  public PressReleaseEntity toEntity(
    PressReleaseDto pressReleaseDto);

  public void updateEntityFromPOJO(PressReleaseDto pressReleaseDto,
                                   @MappingTarget
                                   PressReleaseEntity pressReleaseEntity);
}
