package pkg1;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.jboss.weld.junit5.auto.WeldJunit5AutoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(WeldJunit5AutoExtension.class)
class TableControllerTestNotMocked {
    @WeldSetup
    public WeldInitiator weld = WeldInitiator.from(new Weld("unmanaged").enableDiscovery().disableIsolation())
            .build();

    @Inject
    private TableController tableController;

    @Test
    public void testInjectionNotMocked() {
        assertEquals("notMocked", tableController.getTypeCode());
    }
}