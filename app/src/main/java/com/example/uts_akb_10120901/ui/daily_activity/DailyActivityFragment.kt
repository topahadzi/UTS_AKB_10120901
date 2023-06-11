package com.example.uts_akb_10120901.ui.daily_activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_akb_10120901.R

//Nama: Mustapha Hadzi
//Kelas: IF-10
//NIM: 10120901
//Tanggal Pengerjaan: 11 Juni 2023

class DailyActivityFragment : Fragment(R.layout.fragment_daily_activity) {

    private val friendAdapter = FriendAdapter()
    private val dailyAdapter = DailyAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val friend = listOf(
            FriendModel(R.drawable.john,"Johndy","IT Student"),
            FriendModel(R.drawable.deni,"Dennie","UI Developer"),
            FriendModel(R.drawable.gina,"Rizka","Mobile Developer"),
            FriendModel(R.drawable.alvin,"Alvin","Web Developer"),
            FriendModel(R.drawable.adit,"Ristian","Mobile Developer"),
        )

        val daily = listOf(
            DailyModel(R.drawable.coffee,"Working","Working as Devops Engineer from morning to evening"),
            DailyModel(R.drawable.jogging,"Jogging","If i wake up in the morning, i like to jogging"),
            DailyModel(R.drawable.badminton,"Badminton","Once a week im playing badminton to keep my body health"),
            DailyModel(R.drawable.gacoan,"Eat","Eating all food, one of the best food is Gacoan"),
            DailyModel(R.drawable.sleep,"Sleeping","Sleeping at night!!"),
        )

        val rvfriend = getView()?.findViewById<RecyclerView>(R.id.rvfriend)
        val rvdaily = getView()?.findViewById<RecyclerView>(R.id.rvdaily)
        rvfriend?.adapter = friendAdapter
        rvdaily?.adapter = dailyAdapter
        dailyAdapter.differ.submitList(daily)
        friendAdapter.differ.submitList(friend)


    }
}