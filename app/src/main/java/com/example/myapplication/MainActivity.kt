package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // ★★★ 就是这一行，加载你的 XML 布局 ★★★
        // 如果你要看线性布局（第3页），就用 R.layout.activity_linear
        // 如果你要看太空主题（第6页），就改成 R.layout.activity_constraint_page6
//        setContentView(R.layout.activity_linear)
//        setContentView(R.layout.activity_constraint_page6)
//        setContentView(R.layout.activity_linear)
//        setContentView(R.layout.activity_table)
        setContentView(R.layout.activity_constraint_calculator)
    }
}