package com.example.view_binding_tutorial.bookfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.view_binding_tutorial.book_homepage.Book_home_page_Activity
import com.example.view_binding_tutorial.R
import com.example.view_binding_tutorial.RecyclerViewInterface
import com.example.view_binding_tutorial.databinding.FragmentBookBinding
import java.util.Locale.getDefault
import kotlin.collections.ArrayList


class BookFragment:Fragment(R.layout.fragment_book), RecyclerViewInterface {
    private lateinit var binding: FragmentBookBinding
    private val bookItemList:MutableList<BookItem> = mutableListOf()
    private lateinit var bookItemAdapter: BookFragment_ItemAdapter
    private var examplelist:ArrayList<BookItem> = arrayListOf()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBookBinding.bind(view)

        val bookItem1 = BookItem("Apology","Platon","Classic",4.8F,"1", book_img = R.drawable.ic_baseline_book_24)
        val bookItem2 = BookItem("Whassup","Paton","History",1.8F,"in use", book_img = R.drawable.ic_baseline_book_24)
        bookItemList.add(bookItem1)
        bookItemList.add(bookItem2)

        bookItemAdapter = BookFragment_ItemAdapter(requireContext(),examplelist,this)
        binding.bookItemRV.adapter = bookItemAdapter
        binding.bookItemRV.layoutManager = LinearLayoutManager(requireContext())
        binding.bookItemRV.setHasFixedSize(true)

        examplelist.addAll(bookItemList)

        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener,androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                examplelist.clear()
                val searchText = newText!!.toLowerCase(getDefault())
                if(searchText.isNotEmpty()){
                    bookItemList.forEach(){
                        if(it.name.lowercase(getDefault()).contains(searchText)){
                            examplelist.add(it)
                        }
                    }
                    binding.bookItemRV.adapter!!.notifyDataSetChanged()
                }else{
                    examplelist.clear()
                    examplelist.addAll(bookItemList)
                    binding.bookItemRV.adapter?.notifyDataSetChanged()
                }
                return false
            }
        })

    }

    override fun onItemClick(position: Int) {

    }

    override fun onItemClickBook(position: Int) {
        val intent = Intent(context, Book_home_page_Activity::class.java)
        startActivity(intent)
    }
}