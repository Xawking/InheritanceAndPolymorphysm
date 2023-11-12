package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ToDosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        ToDos todos = new ToDos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void queryForThreeDifferentTasks() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить хлеб");

        String[] subtasks = {"Купить молоко", "Купить яйца", "Купить хлеб"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Купить хлеб",
                "Закупка продуктов",
                "Во вторник после обеда"
        );

        ToDos todos = new ToDos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void queryForSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить хлеб");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        ToDos todos = new ToDos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Купить хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void queryForEpic() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        String[] subtasks = {"Купить молоко", "Купить яйца", "Купить хлеб"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        ToDos todos = new ToDos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Купить хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void queryForMeeting() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Купить хлеб",
                "Закупка продуктов",
                "Во вторник после обеда"
        );

        ToDos todos = new ToDos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Купить хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void queryFail() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить хлеб");

        String[] subtasks = {"Купить молоко", "Купить яйца", "Купить хлеб"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Купить хлеб",
                "Закупка продуктов",
                "Во вторник после обеда"
        );

        ToDos todos = new ToDos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Купить машину");
        Assertions.assertArrayEquals(expected, actual);
    }


}