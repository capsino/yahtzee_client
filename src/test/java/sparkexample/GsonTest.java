package sparkexample;

import static junit.framework.Assert.*;
import org.junit.Test;

import com.google.gson.Gson;
import java.util.Map;
import java.util.HashMap;

public class GsonTest {

  @Test
  public void example_of_hash_to_json_to_hash_round_trip() {
      Gson gson = new Gson();
      Map<String,Object> src = new HashMap<String,Object>();
      src.put( "brand", "Jeep" );
      src.put( "doors", 3 );
      String json = gson.toJson(src);

      Map args = (Map)gson.fromJson(json, Object.class);
      assertEquals("Jeep", args.get("brand"));
      assertEquals(3.0, args.get("doors"));
  }

}
