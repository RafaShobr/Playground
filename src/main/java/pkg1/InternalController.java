package pkg1;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class InternalController {

    @Inject
    private ControllerUtil util;

    public String getInternalTypes() {
        return util.getTypes();
    }
}
