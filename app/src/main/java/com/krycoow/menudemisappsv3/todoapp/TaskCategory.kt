package com.krycoow.menudemisappsv3.todoapp

sealed class TaskCategory {

    object Personal :TaskCategory()
    object Business :TaskCategory()
    object Other :TaskCategory()



}