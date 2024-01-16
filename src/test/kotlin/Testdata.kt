import data.Priority
import data.Task
import kotlin.random.Random.Default.nextInt

fun generateTask(priority: Priority, completed: Boolean = false): Task {
    val taskId = nextInt(1,1000)
    return Task(id = taskId, name = "myTask$taskId", priority = priority, completed = completed)
}