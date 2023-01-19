package pkg1;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ControllerUtil {

    @Inject
    private DefaultCodeResource codeResource;
    public String getTypes() {
        return codeResource.getHiddenTypeCodeNames().get(0);
    }
}
