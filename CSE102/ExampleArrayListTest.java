package CSE102;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
public class ExampleArrayListTest {
    private ArrayList<String> list = new ArrayList<String>();
    @Before
    public void setUp() throws Exception {

    }
    @Test
    //testing two conditions in one method is not good...
    //must separate to two different methods...
    public void testInsertion() {
        list.add("Beijing");
        assertEquals("Beijing",list.get(0));
        list.add("Istanbul");
        list.add("Antalya");
        assertEquals("Antalya",list.get(list.size()-1));
    }
    @Test
    public void testDeletion(){
        list.clear();
        assertTrue(list.isEmpty());

    }
    @Test
    public void testRemoving() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.remove("B");
        assertEquals(2,list.size());
    }
}
