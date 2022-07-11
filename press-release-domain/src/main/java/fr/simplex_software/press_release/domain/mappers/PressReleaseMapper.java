package fr.simplex_software.press_release.domain.mappers;

import fr.simplex_software.press_release.domain.dtos.*;
import fr.simplex_software.press_release.domain.entities.*;
import fr.simplex_software.tfp.plan_journey.jaxb.*;
import org.mapstruct.*;
import org.mapstruct.factory.*;

@Mapper
public interface PressReleaseMapper
{
  PressReleaseMapper INSTANCE = Mappers.getMapper(PressReleaseMapper.class);
  PressReleaseDto fromEntity(PressReleaseEntity pressReleaseEntity);
  PressReleaseEntity toEntity(PressReleaseDto pressReleaseDto);
  ContactDetailsDto fromEntity(ContactDetailsEntity contactDetailsEntity);
  ContactDetailsEntity toEntity(ContactDetailsDto contactDetailsDto);
  AddressDto fromEntity(AddressEntity addressEntity);
  AddressEntity toEntity(AddressDto addressDto);
  OrganizationDto fromEntity(OrganizationEntity organizationEntity);
  OrganizationEntity toEntity(OrganizationDto organizationDto);
  PressReleaseDto fromBean(PressReleaseType pressReleaseType);
  PressReleaseType toBean(PressReleaseDto pressReleaseDto);
  ContactDetailsDto fromBean(ContactDetailsType contactDetailsType);
  ContactDetailsType toBean (ContactDetailsDto contactDetailsDto);
  AddressDto fromBean(AddressType addressType);
  AddressType toBean (AddressDto addressDto);
  OrganizationDto fromBean (OrganizationType organizationType);
  OrganizationType toBean (OrganizationDto organizationDto);
  PressReleaseEntity toEntity (PressReleaseType pressReleaseType);
  PressReleaseType toBean (PressReleaseEntity pressReleaseEntity);
  ContactDetailsEntity toEntity (ContactDetailsType contactDetailsType);
  ContactDetailsType toBean (ContactDetailsEntity contactDetailsEntity);
  AddressEntity toEntity (AddressType addressType);
  AddressType toBean (AddressEntity addressEntity);
  OrganizationEntity toEntity (OrganizationType organizationType);
  OrganizationType toBean (OrganizationEntity organizationEntity);
}
