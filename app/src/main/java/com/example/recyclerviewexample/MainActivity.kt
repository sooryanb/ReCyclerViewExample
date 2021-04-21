package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todoList = mutableListOf(
            Todo("Learn Recyler View", true),
            Todo("Learn ViewPages", false),
            Todo("Learn Tab Layout", false),
            Todo("Learn Drawbles", false),
            Todo("Learn Animations", false),
            Todo("Learn navigations", true),
            Todo("Learn drawables navigations", true),
            Todo("Learn Bottom Navigations", true),
            Todo("Learn Cooking", false)
        )

        val adapter = ToDoAdapter(todoList)
        val rvTodo = findViewById<RecyclerView>(R.id.rvTodo)
        rvTodo.scrollToPosition(todoList.size - 1)
        rvTodo.adapter  = adapter
        rvTodo.layoutManager = LinearLayoutManager(this)

        val btnAddTodo = findViewById<Button>(R.id.btnAddTodo)
        btnAddTodo.setOnClickListener {
            val title = findViewById<EditText>(R.id.etTodo).text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
            rvTodo.scrollToPosition(todoList.size - 1)
        }

    }
}