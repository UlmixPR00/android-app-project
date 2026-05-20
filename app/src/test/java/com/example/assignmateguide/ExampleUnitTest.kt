package com.example.assignmateguide

import org.junit.Test
import org.junit.Assert.*


class ExampleUnitTest {

    @Test
    fun testValidTaskTitle_returnsTrue() {

        val inputTitle = "Finish Homework"


        val expectedOutput = true


        val actualOutput = TaskValidator.isValidTaskTitle(inputTitle)


        assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun testEmptyTaskTitle_returnsFalse() {

        val inputTitle = ""


        val expectedOutput = false


        val actualOutput = TaskValidator.isValidTaskTitle(inputTitle)


        assertEquals(expectedOutput, actualOutput)
    }
}