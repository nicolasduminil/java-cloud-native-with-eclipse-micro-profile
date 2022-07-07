package fr.simplex_software.press_release.domain.entities;

import fr.simplex_software.press_release.domain.converters.*;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.adapters.*;
import lombok.*;

import java.io.*;
import java.time.*;

@Entity
@Table(name="PRESS_RELEASES")
@NamedQuery(name = "all", query = "SELECT pr FROM PressReleaseEntity pr")
@NamedQuery(name = "byName", query = "SELECT pr FROM PressReleaseEntity pr where pr.pressReleaseName = :name")
@NamedQuery(name = "byDate", query = "SELECT pr FROM PressReleaseEntity pr where pr.releaseDate = :date")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PressReleaseEntity implements Serializable
{
  @Id
  @SequenceGenerator(name = "PRESS_RELEASE_ID_GENERATOR", sequenceName =
    "PRESS_RELEASE_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
    "PRESS_RELEASE_ID_GENERATOR")
  @Column(name = "PRESS_RELEASE_ID", unique = true, nullable = false,
          length = 5)
  private Long pressReleaseId;
  @Column(name = "PRESS_RELEASE_NAME", nullable = false, length = 40)
  private String pressReleaseName;
  @Column(name = "RELEASE_DATE", nullable = false, length = 40)
  @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
  private LocalDate releaseDate;
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name="CONTACT_DETAILS_ID")
  private ContactDetailsEntity contact;
  @Column(name = "PATH_TO_LOGO", nullable = false, length = 120)
  private String pathToLogo;
  @Column(name = "PATH_TO_HEADER", nullable = false, length = 120)
  private String pathToHeader;
  @Column(name = "PATH_TO_CONTENT", nullable = false, length = 120)
  private String pathToContent;
  @Column(name = "PATH_TO_FINAL_NOTE", nullable = false, length = 120)
  private String pathToFinalNote;
}
