import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void testEveryStatement(){
        RuntimeException exception;

        List<Item> items = null;
        exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items, "4972946510274820");
        });
        assertEquals("allItems list can't be null!", exception.getMessage());

        List<Item> items1 = new ArrayList<>();
        items1.add(new Item("", 10, 5, 0.9));
        exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items1, "4972946510274820");
        });
        assertEquals("Invalid item!", exception.getMessage());

        List<Item> items2 = new ArrayList<>();
        items2.add(new Item("item3", 3, 20, 0.5));
        exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items2, "4972a4651t274820");
        });
        assertEquals("Invalid character in card number!", exception.getMessage());

        List<Item> items3 = new ArrayList<>();
        items3.add(new Item("item4", 5, 230, 2));
        exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items3, "4972946510");
        });
        assertEquals("Invalid card number!", exception.getMessage());

        List<Item> items4 = new ArrayList<>();
        items4.add(new Item("item5", 3, 350, 0.3));
        double checkCart2 = SILab2.checkCart(items4, "4972946510274820");
        assertEquals(705.0, checkCart2, 0.0001);
    }

    @Test
    void testMultipleCondition(){
        String cardNumber = "4972946510274820";

        List<Item> items1 = new ArrayList<>();
        Item item1 = new Item("item1", 10, 40, 0.5);
        items1.add(item1);
        double checkCart1 = SILab2.checkCart(items1, cardNumber);
        assertEquals(170, checkCart1, 0.1);

        List<Item> items2 = new ArrayList<>();
        Item item2 = new Item("item2", 22, 232, 0.5);
        items2.add(item2);
        double checkCart2 = SILab2.checkCart(items2, cardNumber);
        assertEquals(2522, checkCart2, 0.0001);

        List<Item> items3 = new ArrayList<>();
        Item item3 = new Item("item3", 11, 103, 0);
        items3.add(item3);
        double checkCart3 = SILab2.checkCart(items3, cardNumber);
        assertEquals(1103, checkCart3);

        List<Item> items4 = new ArrayList<>();
        Item item4 = new Item("item4", 21, 732, 0.7);
        items4.add(item4);
        double checkCart4 = SILab2.checkCart(items4, cardNumber);
        assertEquals(4581.6, checkCart4);
    }
}
