package com.example.bt_kotlin

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bt_kotlin.`interface`.OnItemClickListener
import com.example.bt_kotlin.adapter.GroupAdapter
import com.example.bt_kotlin.adapter.UserAdapter
import com.example.bt_kotlin.model.Group
import com.example.bt_kotlin.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mListUser: MutableList<User> = mutableListOf<User>()
    var mListGroup: MutableList<Group> = mutableListOf<Group>()
    lateinit var mAdapterGroup: GroupAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mListUser.add(User("Khoa", "Bình định", "111"))
        mListUser.add(User("Anh", "Quảng Nam", "111"))
        mListUser.add(User("Sang", "Quảng Nam", "111"))
        mListUser.add(User("Thầy", "Quảng Nam", "111"))
        mListUser.add(User("Nguyễn", "Quảng Nam", "111"))

        var mAdapterUser = UserAdapter(mListUser, object : OnItemClickListener {
            override fun onView(position: Int) {
                Toast.makeText(
                    this@MainActivity,
                    mListUser[position].name + " - " + mListUser[position].address,
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onCheck(position: Int, b: Boolean) {
                if (b) {
                    mListGroup.add(Group(position, mListUser[position].name))
                } else {
                    val iterator = mListGroup.iterator()
                    while (iterator.hasNext()){
                        if (iterator.next().idgroup == position){
                            iterator.remove()
//                            mListGroup.remove(iterator.next())
                        }
                    }
//                     cách này lỗi ConcurrentModificationException
//                    mListGroup.forEachIndexed { index, group ->
//                        if (group.idgroup == position) {
//                            mListGroup.remove(group)
//                            Log.d("nnn", ""+group.idgroup+"onCheck: "+position+" ::::"+index)
//                        }
//                    }
                }
                mAdapterGroup!!.notifyDataSetChanged();
            }
        })
        val linearLayoutUser = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRecyclerViewUser.layoutManager = linearLayoutUser
        mRecyclerViewUser.adapter = mAdapterUser

        mAdapterGroup = GroupAdapter(mListGroup)
        val linearLayoutGroup = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mRecyclerViewGroup.layoutManager = linearLayoutGroup
        mRecyclerViewGroup.adapter = mAdapterGroup
    }
}