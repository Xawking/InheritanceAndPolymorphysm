package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {
    @Test
    public void shouldFindSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Task 1");

        boolean expected = true;
        boolean actual = simpleTask.matches("Task 1");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotFindSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Task 1");

        boolean expected = false;
        boolean actual = simpleTask.matches("Task 2");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFindEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);
        boolean expected = true;
        boolean actual = epic.matches("Молоко");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);
        boolean expected = false;
        boolean actual = epic.matches("Огурцы");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotFindMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = false;
        boolean actual = meeting.matches("Кредитная Карта");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldGetTaskId() {
        SimpleTask simpleTask = new SimpleTask(123, "Task 1");

        int expected = 123;
        int actual = simpleTask.getId();
        Assertions.assertEquals(expected, actual);

    }


}