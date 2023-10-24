package load.data;

import org.demo.util.ConnectionFactory;
import org.demo.util.CrateTablesRoutine;
import org.junit.jupiter.api.Test;

/**
 * @author Igor Adulyan
 */
public class CreateTablesTest {
    @Test
    public void testCreateTables(){
        CrateTablesRoutine.createTables();
    }
}
