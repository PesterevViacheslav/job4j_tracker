package ru.job4j.lombok;
/**
 * Class LombokUsage - Использование шаблона Builder. Решение задачи 3.3.1. Lombok 3. @Builder [#504890]
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 30.10.2022
 * @version 1
 */
public class LombokUsage {
    public static void main(String[] args) {
        var permission = Permission.of()
                .id(1)
                .name("DML permission")
                .accessBy("insert")
                .accessBy("update")
                .accessBy("delete")
                .build();
        System.out.println(permission);
    }
}