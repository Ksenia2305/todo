import data.Priority
import data.Task
import kotlin.random.Random.Default.nextInt

fun generateTask(priority: Priority, completed: Boolean = false, numberOfTask: Int): List<Task> {
    var listTasks = mutableListOf<Task>()
    for (i in 1..numberOfTask) {
        listTasks.add((i - 1), Task(id = i, name = "myTask$i", priority = priority, completed = completed))
    }
    return listTasks
}