package ru.job4j.lombok;
import lombok.*;
import java.util.List;
/**
 * Class Permission. Решение задачи 3.3.1. Lombok 3. @Builder [#504890]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 30.10.2022
 * @version 1
 */
@Builder(builderMethodName = "of")
@ToString
@Getter
public class Permission {
    private int id;
    private String name;
    @Singular("accessBy")
    private List<String> rules;
}