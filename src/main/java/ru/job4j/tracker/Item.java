package ru.job4j.tracker;
import javax.persistence.*;
import java.sql.Timestamp;
import lombok.*;
@Data
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "item")
/**
 * Class Item - Заявка. Решение задачи Части 002. ООП. Общая задача на второй модуль.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 25.04.2018
 * @version 1
 */
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private int id;
    @Column(name = "item_name")
    @EqualsAndHashCode.Include
    @NonNull
    private String name;
    @Column(name = "item_description")
    @EqualsAndHashCode.Include
    @NonNull
    private String description;
    @NonNull
    private Timestamp created;
    /**
     * Method Item. Конструктор.
     * @param name Названия заявки.
     * @param description Описание заявки.
     * @param created Дата создания.
     */
/*
    public Item(String name, String description, Timestamp created) {
        //this.id = generateId();
        this.name = name;
        this.description = description;
        this.created = created;
    }
*/

}