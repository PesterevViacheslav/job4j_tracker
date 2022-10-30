package ru.job4j.lombok;
import lombok.*;
/**
 * Class Category. Решение задачи 3.3.1. Lombok 2. @Setter, @Getter и другие.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 30.10.2022
 * @version 1
 */
@Data
@RequiredArgsConstructor
public class Category {
    @Getter
    @EqualsAndHashCode.Include
    @NonNull
    private int id;
    @Getter
    @Setter
    private String name;
}
