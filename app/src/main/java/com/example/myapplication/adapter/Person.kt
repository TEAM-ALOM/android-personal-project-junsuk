package com.example.myapplication.adapter

data class Person (
    val name : String,
    val count : Int,
    val num : MutableList<Int> = MutableList(count, {i->i}),
        )