import data.Priority
import data.Task
import kotlin.random.Random.Default.nextInt

fun generateTask(priority: Priority, completed: Boolean = false, numberOfTask: Int): List<Task> {
    val taskId = nextInt(1,1000)
    var listTasks = listOf<Task>()
    for (i in 1..numberOfTask) {
        listTasks = listOf(Task(id = taskId, name = "myTask$taskId", priority = priority, completed = completed))
    }
    return listTasks
}