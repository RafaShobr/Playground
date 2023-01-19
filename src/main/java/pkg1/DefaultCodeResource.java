package pkg1;

import javax.annotation.Resource;
import javax.enterprise.inject.Default;
import java.util.List;

@Resource
@Default
public class DefaultCodeResource {
    public List<String> getHiddenTypeCodeNames() {
        return List.of("notMocked", "notAtAll");
    }
}
