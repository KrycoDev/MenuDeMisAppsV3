package com.krycoow.menudemisappsv3.todoapp

data class Task (val name:String, val category: TaskCategory, var isSelected:Boolean = false)