package unit_test

import data.Priority.HIGH
import data.Priority.LOW
import data.Priority.MEDIUM
import data.TasksRepositoryMemory
import extension_test_class.RepeatOnFailureExtension
import generateTask
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.ShouldSpec
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test


class PositiveTests: FunSpec({
    extension(RepeatOnFailureExtension())

    val tasksRepositoryMemory = TasksRepositoryMemory()


    test("Add, complete and get one task test") {
        val idTaskHigh = tasksRepositoryMemory.addTask(generateTask(HIGH))
        tasksRepositoryMemory.completeTask(idTaskHigh)
        assertEquals(1, tasksRepositoryMemory.getTasks(completed = true).size)
        assertEquals(1, tasksRepositoryMemory.tasks.size)
        assertEquals(0, tasksRepositoryMemory.getTasks(completed = false).size)
    }


    test("Add, complete and get three task test, check sort") {
        val tasks =
            listOf(
                generateTask(HIGH),
                generateTask(LOW),
                generateTask(MEDIUM)
            )
        val idTaskHigh = tasksRepositoryMemory.addTask(tasks[0])
        val idTaskLow = tasksRepositoryMemory.addTask(tasks[1])
        val idTaskMedium = tasksRepositoryMemory.addTask(tasks[2])

        tasksRepositoryMemory.completeTask(idTaskHigh)
        tasksRepositoryMemory.completeTask(idTaskLow)
        tasksRepositoryMemory.completeTask(idTaskMedium)
        assertEquals(3, tasksRepositoryMemory.getTasks(completed = true).size)
        assertEquals(3, tasksRepositoryMemory.tasks.size)
        assertEquals(0, tasksRepositoryMemory.getTasks(completed = false).size)
        assertEquals(tasks, tasksRepositoryMemory.getTasks(completed = true))

    }
})