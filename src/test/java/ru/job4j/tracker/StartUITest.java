package ru.job4j.tracker;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.util.List;

import static org.mockito.Mockito.*;
/**
 * Class StartUITest Автотесты для задач Части 002. ООП. Общая задача на второй модуль.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 15.05.2018
 * @version 1
 */
public class StartUITest {
    private Tracker tracker = new Tracker();
    private StubInput input = new StubInput(new String[] {"0", "TestName", "TestDsc", "0", "TestName2", "TestDsc2", "6"});
    private PrintStream stdout = System.out;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private void loadOut() {
        System.setOut(new PrintStream(this.out));
    }
    private void backOut() {
        System.setOut(this.stdout);
    }
    @Before
    public void runInit() {
        new StartUI(this.input, this.tracker).init();
    }
    /**
     * Тест метода добавления заявки.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Item item = new Item("TestName", "TestDsc", new Timestamp(System.currentTimeMillis()));
        item.setId(tracker.findAll().get(0).getId());
        assertThat(tracker.findAll().get(0), is(item));
    }
    /**
     * Тест метода замены заявки.
     */
    /**
     * Тест метода поиска заявки по имени.
     */
    @Test
    public void checkFindItemsByNameMock() {
        Input input = mock(Input.class);
        when(input.ask(any(String.class), any(List.class))).thenReturn(5).thenReturn(6);
        when(input.ask(any(String.class))).thenReturn("TestName2");
        loadOut();
        new StartUI(input, tracker).init();
        backOut();
        StringBuilder tst = new StringBuilder();
        tst.append("TRACKER MENU");
        tst.append(System.lineSeparator());
        tst.append("0. Add new Item");
        tst.append(System.lineSeparator());
        tst.append("1. Show all items");
        tst.append(System.lineSeparator());
        tst.append("2. Edit item");
        tst.append(System.lineSeparator());
        tst.append("3. Delete item");
        tst.append(System.lineSeparator());
        tst.append("4. Find item by Id");
        tst.append(System.lineSeparator());
        tst.append("5. Find items by name");
        tst.append(System.lineSeparator());
        tst.append("6. Exit Program");
        tst.append(System.lineSeparator());
        tst.append("7. Change item");
        tst.append(System.lineSeparator());
        tst.append("***Find items by Name Start***");
        tst.append(System.lineSeparator());
        tst.append("Item found ID=" + tracker.findAll().get(1).getId() + " Name=TestName2 Description=TestDsc2");
        tst.append(System.lineSeparator());
        tst.append("TRACKER MENU");
        tst.append(System.lineSeparator());
        tst.append("0. Add new Item");
        tst.append(System.lineSeparator());
        tst.append("1. Show all items");
        tst.append(System.lineSeparator());
        tst.append("2. Edit item");
        tst.append(System.lineSeparator());
        tst.append("3. Delete item");
        tst.append(System.lineSeparator());
        tst.append("4. Find item by Id");
        tst.append(System.lineSeparator());
        tst.append("5. Find items by name");
        tst.append(System.lineSeparator());
        tst.append("6. Exit Program");
        tst.append(System.lineSeparator());
        tst.append("7. Change item");
        tst.append(System.lineSeparator());
        tst.append("***EXIT***");
        tst.append(System.lineSeparator());
        assertThat(new String(out.toByteArray()), is(tst.toString()));
    }
    /**
     * Тест ввода несуществующего пункта меню.
     */
    @Test
    public void checkWrongMenuKeyMock() {
        Input input = mock(Input.class);
        when(input.ask(any(String.class), any(List.class))).thenReturn(10).thenReturn(6);
        loadOut();
        new StartUI(input, tracker).init();
        backOut();
        StringBuilder tst = new StringBuilder();
        tst.append("TRACKER MENU");
        tst.append(System.lineSeparator());
        tst.append("0. Add new Item");
        tst.append(System.lineSeparator());
        tst.append("1. Show all items");
        tst.append(System.lineSeparator());
        tst.append("2. Edit item");
        tst.append(System.lineSeparator());
        tst.append("3. Delete item");
        tst.append(System.lineSeparator());
        tst.append("4. Find item by Id");
        tst.append(System.lineSeparator());
        tst.append("5. Find items by name");
        tst.append(System.lineSeparator());
        tst.append("6. Exit Program");
        tst.append(System.lineSeparator());
        tst.append("7. Change item");
        tst.append(System.lineSeparator());
        tst.append("Wrong menu key");
        tst.append(System.lineSeparator());
        tst.append("TRACKER MENU");
        tst.append(System.lineSeparator());
        tst.append("0. Add new Item");
        tst.append(System.lineSeparator());
        tst.append("1. Show all items");
        tst.append(System.lineSeparator());
        tst.append("2. Edit item");
        tst.append(System.lineSeparator());
        tst.append("3. Delete item");
        tst.append(System.lineSeparator());
        tst.append("4. Find item by Id");
        tst.append(System.lineSeparator());
        tst.append("5. Find items by name");
        tst.append(System.lineSeparator());
        tst.append("6. Exit Program");
        tst.append(System.lineSeparator());
        tst.append("7. Change item");
        tst.append(System.lineSeparator());
        tst.append("***EXIT***");
        tst.append(System.lineSeparator());
        assertThat(new String(out.toByteArray()), is(tst.toString()));
    }
    /**
     * Тест ввода пункта меню в некорректном формате.
     */
    @Test
    public void checkWrongFormatMenuKey() {
        input = new StubInput(new String[] {"wrong", "6"});
        loadOut();
        new StartUI(input, tracker).init();
        backOut();
        StringBuilder tst = new StringBuilder();
        tst.append("TRACKER MENU");
        tst.append(System.lineSeparator());
        tst.append("0. Add new Item");
        tst.append(System.lineSeparator());
        tst.append("1. Show all items");
        tst.append(System.lineSeparator());
        tst.append("2. Edit item");
        tst.append(System.lineSeparator());
        tst.append("3. Delete item");
        tst.append(System.lineSeparator());
        tst.append("4. Find item by Id");
        tst.append(System.lineSeparator());
        tst.append("5. Find items by name");
        tst.append(System.lineSeparator());
        tst.append("6. Exit Program");
        tst.append(System.lineSeparator());
        tst.append("7. Change item");
        tst.append(System.lineSeparator());
        tst.append("Wrong format menu key");
        tst.append(System.lineSeparator());
        tst.append("***EXIT***");
        tst.append(System.lineSeparator());
        assertThat(new String(out.toByteArray()), is(tst.toString()));
    }
}