package com.example.assignmateguide

object TaskValidator {

    fun isValidTaskTitle(title: String): Boolean {
        return title.isNotBlank()
    }
}