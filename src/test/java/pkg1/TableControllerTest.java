package pkg1;

import org.easymock.EasyMock;
import org.easymock.Mock;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.junit.MockBean;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.jboss.weld.junit5.auto.ExcludeBean;
import org.jboss.weld.junit5.auto.WeldJunit5AutoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Bean;
import javax.inject.Inject;

import java.util.Collections;

import static org.easymock.EasyMock.expect;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(WeldJunit5AutoExtension.class)
class TableControllerTest {
    @WeldSetup
    public WeldInitiator weld = WeldInitiator.from(new Weld("unmanaged").enableDiscovery().disableIsolation())
            .addBeans(createCodeResourceBean())
            .build();

    @Mock
    @Produces
    @ExcludeBean
    private DefaultCodeResource codeResource = EasyMock.mock(DefaultCodeResource.class);

    Bean<?> createCodeResourceBean() {
        return MockBean.builder()
                .types(DefaultCodeResource.class)
                .selectedAlternative(DefaultCodeResource.class)
                .creating(codeResource)
                .globallySelectedAlternative(1)
                .priority(1)
                .build();
    }

    @Inject
    private TableController tableController;

    @Test
    public void testInjectionMocked() {
        expect(codeResource.getHiddenTypeCodeNames()).andReturn(Collections.singletonList("MOCK!")).anyTimes();

        assertEquals("MOCK!", tableController.getTypeCode());
    }
}