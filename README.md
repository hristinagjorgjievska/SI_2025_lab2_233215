# Втора лабораториска вежба по Софтверско инженерство
# Христина Ѓорѓиевска 233215
## 2. Control Flow Graph
![final](https://github.com/user-attachments/assets/9c2363e3-bfe2-4730-8a03-191621e3cf7b)

## 3. Цикломатска комплексност
- Според Control Flow Graph-от, со броење на регионите (8) + 1, добив дека цикломатската комплексност е 9.

## 4. Tест случаи според Every Statement критериум
#### Прв тест случај: Празна листа (allItems == null)
```java
        List<Item> items = null;
        exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items, "4972946510274820");
        });
        assertEquals("allItems list can't be null!", exception.getMessage());
```
#### Втор тест случај: Невалиден item (Празен стринг за name)
```java
        RuntimeException exception;

        List<Item> items1 = new ArrayList<>();
        items1.add(new Item("", 10, 5, 0.9));
        exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items1, "4972946510274820");
        });
        assertEquals("Invalid item!", exception.getMessage());
```
#### Трет тест случај: Погрешен формат на картичка (содржи букви)
```java
        RuntimeException exception;

        List<Item> items2 = new ArrayList<>();
        items2.add(new Item("item3", 3, 20, 0.5));
        exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items2, "4972a4651t274820");
        });
        assertEquals("Invalid character in card number!", exception.getMessage());
```
#### Четврт тест случај: Неточен број на картичка (не содржи 16 цифри)
```java
        RuntimeException exception;

        List<Item> items3 = new ArrayList<>();
        items3.add(new Item("item4", 5, 230, 2));
        exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items3, "4972946510");
        });
        assertEquals("Invalid card number!", exception.getMessage());
```
#### Петти тест случај: Сите податоци се точно внесени
```java
        List<Item> items4 = new ArrayList<>();
        items4.add(new Item("item5", 3, 350, 0.3));
        double checkCart2 = SILab2.checkCart(items4, "4972946510274820");
        assertEquals(705.0, checkCart2, 0.0001);
    }
```
### Минималниот број на тестови за Every Statement критериумот е 5.

## 5. Multiple Condition критериумот за условот if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)
#### Прв тест случај: FFF
```java
        String cardNumber = "0123456789876543";

        List<Item> items1 = new ArrayList<>();
        Item item1 = new Item("item1", 10, 40, 0.5);
        items1.add(item1);
        double checkCart1 = SILab2.checkCart(items1, cardNumber);
        assertEquals(170, checkCart1, 0.1);
```

##### Во овој тест случај сите услови се false, па така целиот if ќе биде исто така false.
#### Втор тест случај: FTX
```java
        String cardNumber = "0123456789876543";

        List<Item> items2 = new ArrayList<>();
        Item item2 = new Item("item2", 22, 232, 0.5);
        items2.add(item2);
        double checkCart2 = SILab2.checkCart(items2, cardNumber);
        assertEquals(2522, checkCart2, 0.0001);
```
##### Во овој тест, првиот услов е false, вториот е true, па штом веќе имаме true во еден од условите, целиот if ќе биде точен.
#### Tрет тест случај: FFT
```java
        String cardNumber = "4972946510274820";

        List<Item> items3 = new ArrayList<>();
        Item item3 = new Item("item3", 11, 103, 0);
        items3.add(item3);
        double checkCart3 = SILab2.checkCart(items3, cardNumber);
        assertEquals(1103, checkCart3);;
```
##### Во овој тест, првиот и вториот услов се false, па затоа третиот услов мора да биде точен, за целиот if да биде точен.
#### Четврт тест случај: TXX
```java
        String cardNumber = "0123456789876543";

        List<Item> items4 = new ArrayList<>();
        Item item4 = new Item("item4", 21, 732, 0.7);
        items4.add(item4);
        double checkCart4 = SILab2.checkCart(items4, cardNumber);
        assertEquals(4581.6, checkCart4);
```
##### Во овој тест случај, штом првиот услов е точен, тогаш не ни е важно дали другите услови ќе бидат true или false, целиот if услов е точен. 
### Минималниот број на тестови за Multiple Condition критериумот е 4.
