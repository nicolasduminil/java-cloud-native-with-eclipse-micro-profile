package fr.simplex_software.press_release.data;

import fr.simplex_software.press_release.domain.entities.*;
import io.quarkus.hibernate.orm.panache.*;

import javax.enterprise.context.*;

@ApplicationScoped
public class PressReleaseRepository implements PanacheRepository<PressReleaseEntity>
{
}
