import static org.junit.jupiter.api.Assertions.assertEquals;
import model.ComputerRepairRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class ComputerRepairRequestTest {

    @Test
    @DisplayName("First Test")
    public void testExample() {
        ComputerRepairRequest request = new ComputerRepairRequest();
        assertEquals("", request.getOwnerName());
        assertEquals("", request.getOwnerAddress());
    }

    @Test
    @DisplayName("TestExemplu")
    public void testExample2() {
        assertEquals(2,2, "Numere egale");
    }

}
