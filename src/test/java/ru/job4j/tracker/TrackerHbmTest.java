package ru.job4j.tracker;
import org.junit.Test;
import java.sql.Timestamp;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class TrackerHbmTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new TrackerHbm()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertTrue(result.getName().equals(item.getName()));
        }
    }
    @Test
    public void whenFindByNameGotElements() throws Exception {
        try (var tracker = new TrackerHbm()) {
            Item item1 = tracker.add(new Item("item","dsc",new Timestamp(System.currentTimeMillis())));
            Item item2 = tracker.add(new Item("item", "dsc2", new Timestamp(System.currentTimeMillis())));
            assertThat(tracker.findByName("item")).containsAll(List.of(item1, item2));
        }
    }
    @Test
    public void whenFindByIdGotElements() throws Exception {
        try (var tracker = new TrackerHbm()) {
            Item item1 = tracker.add(new Item("item","dsc",new Timestamp(System.currentTimeMillis())));
            Item item2 = tracker.add(new Item("item", "dsc2", new Timestamp(System.currentTimeMillis())));
            assertThat(tracker.findById(item1.getId()).getDescription()).isEqualTo("dsc");
        }
    }
    @Test
    public void whenDeleteItemThanDeleted() throws Exception {
        try (var tracker = new TrackerHbm()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            assertThat(tracker.delete(item.getId())).isTrue();
        }
    }
    @Test
    public void whenReplaceItemThanReplaced() throws Exception {
        try (var tracker = new TrackerHbm()) {
            Item item1 = tracker.add(new Item("item","dsc",new Timestamp(System.currentTimeMillis())));
            Item item2 = tracker.add(new Item("item2", "dsc2", new Timestamp(System.currentTimeMillis())));
            tracker.replace(item1.getId(), item2);
            assertThat(item2.getName().equals("item2"));
        }
    }
    @Test
    public void whenChangeItemThanChanged() throws Exception {
        try (var tracker = new TrackerHbm()) {
            Item item1 = tracker.add(new Item("item","dsc",new Timestamp(System.currentTimeMillis())));
            Item item2 = tracker.add(new Item("item2", "dsc2", new Timestamp(System.currentTimeMillis())));
            tracker.change(item1.getId(), item2);
            assertThat(item1.getName().equals("item2"));
        }
    }
    @Test
    public void whenFindAllGotAll() throws Exception {
        try (var tracker = new TrackerHbm()) {
            Item item1 = tracker.add(new Item("item","dsc",new Timestamp(System.currentTimeMillis())));
            Item item2 = tracker.add(new Item("item2", "dsc2", new Timestamp(System.currentTimeMillis())));
            assertThat(tracker.findAll()).containsAll(List.of(item1, item2));
        }
    }
}
