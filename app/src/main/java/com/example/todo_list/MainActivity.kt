package com.example.todo_list

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdapter
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())
        val rvTodoItems : RecyclerView = findViewById(R.id.rvTodoItems)
        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)
        val btnAddTo : Button = findViewById(R.id.btnAddTodo)
        btnAddTo.setOnClickListener {
            val etTodoTitle : EditText = findViewById(R.id.etTodoTitle)
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle)
                todoAdapter.addToDo(todo)
                etTodoTitle.text.clear()
            }
        }
    val btnDeleteTodos : Button = findViewById(R.id.btnDeleteTodos)
        btnDeleteTodos.setOnClickListener {
            todoAdapter.deleteToDo()
        }
    }
}