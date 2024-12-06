package com.example.bersamakasiredclayout

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bersamakasiredclayout.adapter.DummyTransactionDataAdapter
import com.example.bersamakasiredclayout.data.DummyTransactionData
import com.google.gson.Gson

class TransactionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_transactions)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val transactionRecyclerView: RecyclerView = findViewById(R.id.rv_productList)
        transactionRecyclerView.layoutManager = LinearLayoutManager(this)

        val jsonData = """
            [
                {"name": "Product 1", "short_description": "Description for Product 1", "price": 10.5, "image": "https://images.unsplash.com/photo-1700483540153-212f6b292447?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"},
                {"name": "Product 2", "short_description": "Description for Product 2", "price": 20.0, "image": "https://images.unsplash.com/photo-1485962093642-5f4386e84429?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"},
                {"name": "Product 3", "short_description": "Description for Product 3", "price": 30.0, "image": "https://images.unsplash.com/photo-1485962093642-5f4386e84429?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"},
                {"name": "Product 3", "short_description": "Description for Product 3", "price": 30.0, "image": "https://images.unsplash.com/photo-1485962093642-5f4386e84429?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"},
                {"name": "Product 2", "short_description": "Description for Product 2", "price": 20.0, "image": "https://images.unsplash.com/photo-1485962093642-5f4386e84429?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"}
            ]
        """

        val gson = Gson()
        val itemList: List<DummyTransactionData> =
            gson.fromJson(jsonData, Array<DummyTransactionData>::class.java).toList()

        val adapter = DummyTransactionDataAdapter(itemList)
        transactionRecyclerView.adapter = adapter
    }
}
