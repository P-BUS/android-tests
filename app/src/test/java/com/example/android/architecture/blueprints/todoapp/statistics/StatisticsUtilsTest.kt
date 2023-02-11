package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertEquals
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // Arrange. Create an active task
        val tasks = listOf(
            Task("title", "desc", isCompleted = false)
        )
        // Act. Call your function
        val result = getActiveAndCompletedStats(tasks)
        // Assert. Check the result
        assertThat(result.completedTasksPercent, `is`(0f)) // Modified with Hamcrest
        assertEquals(result.activeTasksPercent, 100f) // Usual Junit expression
    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsZeroHundred() {
        // Arrange. Create an active task
        val tasks = listOf(
            Task("title", "desc", isCompleted = true)
        )
        // Act. Call your function
        val result = getActiveAndCompletedStats(tasks)
        // Assert. Check the result
        assertThat(result.completedTasksPercent, `is`(100f)) // Modified with Hamcrest
        assertEquals(result.activeTasksPercent, 0f) // Usual Junit expression
    }

    @Test
    fun getActiveAndCompletedStats_twoCompletedThreeActive_returnsForteSixte() {
        // Arrange. Create an active task
        val tasks = listOf(
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false)
        )
        // Act. Call your function
        val result = getActiveAndCompletedStats(tasks)
        // Assert. Check the result
        assertThat(result.completedTasksPercent, `is`(40f)) // Modified with Hamcrest
        assertEquals(result.activeTasksPercent, 60f) // Usual Junit expression
    }

    @Test
    fun getActiveAndCompletedStats_emptyList_returnZero() {
        // Arrange. Create an active task
        val tasks = listOf<Task>()
        // Act. Call your function
        val result = getActiveAndCompletedStats(tasks)
        // Assert. Check the result
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_null_returnZero() {
        // Arrange. Create an active task
        val tasks = null
        // Act. Call your function
        val result = getActiveAndCompletedStats(tasks)
        // Assert. Check the result
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }
}