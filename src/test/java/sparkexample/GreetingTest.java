package sparkexample;

import static junit.framework.Assert.*;
import org.junit.Test;

public class GreetingTest {

    @Test
    public void message_from_client_on_port_80() {
        String actual = Greeting.message();
        String expected = "Hello from spark_client on port 80";
        assertEquals(expected, actual);
    }

}
