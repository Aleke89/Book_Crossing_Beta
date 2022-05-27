package com.example.view_binding_tutorial.userratingfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.view_binding_tutorial.R
import com.example.view_binding_tutorial.RecyclerViewInterface
import com.example.view_binding_tutorial.databinding.FragmentUserRatingBinding
import kotlinx.android.synthetic.main.activity_user_profile.*
import java.util.*
import kotlin.collections.ArrayList


class UserRatingFragment : Fragment(R.layout.fragment_user_rating), RecyclerViewInterface {
    private lateinit var binding: FragmentUserRatingBinding
    private val userratingItemList:MutableList<UserRatingItem> = mutableListOf()
    private lateinit var  userRatingAdapter: UserRatingFragment_ItemAdapter
    private var examplelist:ArrayList<UserRatingItem> = arrayListOf()
    val userratingItem1 = UserRatingItem("Vasya","4","4","4","Math",R.drawable.person_icon_fr,"vasya@gmail.com","87052185060")
    val userratingItem2 = UserRatingItem("Donjuan","1","2","4","Phylosophia",R.drawable.person_icon_fr,"donjuan@gmail.com","87125462543")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserRatingBinding.bind(view)


        userratingItemList.add(userratingItem1)
        userratingItemList.add(userratingItem2)
        userRatingAdapter = UserRatingFragment_ItemAdapter(requireContext(),examplelist,this)
        binding.userratingItemRV.adapter = userRatingAdapter
        binding.userratingItemRV.layoutManager = LinearLayoutManager(requireContext())
        binding.userratingItemRV.setHasFixedSize(true)

        examplelist.addAll(userratingItemList)

        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener,androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                examplelist.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if(searchText.isNotEmpty()){
                    userratingItemList.forEach(){
                        if(it.person_name.lowercase(Locale.getDefault()).contains(searchText)){
                            examplelist.add(it)
                        }
                    }
                    binding.userratingItemRV.adapter!!.notifyDataSetChanged()
                }else{
                    examplelist.clear()
                    examplelist.addAll(userratingItemList)
                    binding.userratingItemRV.adapter?.notifyDataSetChanged()
                }
                return false
            }
        })



    }

    override fun onItemClick(position: Int) {

    }

    override fun onItemClickBook(position: Int) {

    }

}

