import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class HangManTest {

  @Test
  public void CheckifMatchFoundTest() {
    HangMan testHangMan = new HangMan();
    boolean expectedOutput = true;
    assertEquals(expectedOutput, testHangMan.CheckifMatchFound("mulu","mulu"));
  }

  @Test
  public void CheckifCharFoundInStringTest() {
    HangMan testHangMan = new HangMan();
    boolean expectedOutput = false;
    assertEquals(expectedOutput, testHangMan.CheckifMatchFound("Mulu","u"));
  }
  @Test
  public void CheckifStringFoundInStringTest() {
    HangMan testHangMan = new HangMan();
    boolean expectedOutput = false;
    assertEquals(expectedOutput, testHangMan.CheckifMatchFound("Mulu","Mu"));
  }

}
