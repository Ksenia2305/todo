import data.Priority.HIGH

class TestDataRepository {
    private val numberOfTasks = 10

    val testTasks = generateTask(priority = HIGH, completed = false, numberOfTask = numberOfTasks)
}