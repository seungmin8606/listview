package com.example.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.listview.RoomAdapter
import com.example.listview.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_room_detail.*
import android.text.Editable

import android.text.TextWatcher
import android.widget.SearchView


class MainActivity : BaseActivity() {

    val mRoomList = ArrayList<Room>()
    lateinit var mRoomAdapter: RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()

    }

    override fun setupEvents() {
        // 메인화면의 이벤트관련 코드를 모아두는 장소
        // 검색 이벤트
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filterWine = ArrayList<Room>()
                for(i: Int in 0..mRoomList.size-1) {
                    val wine = mRoomList[i]

                    if (newText != null) {
                        if(wine.wineEN.toLowerCase().contains(newText.toLowerCase())){
                            filterWine.add(wine);
                        }
                    }
                }

                mRoomAdapter = RoomAdapter(mContext, R.layout.room_list_item, filterWine)
                roomListView.adapter = mRoomAdapter

                return true
            }
        })

        // 리스트 클릭 이벤트 - 리스트뷰의 각 줄이 눌리는 시점의 이벤트
        roomListView.setOnItemClickListener { adapterView, view, i, l ->

            // 눌린 위치에 해당하는 목록이 어떤 목록인지 가져오기
            val clickedRoom = mRoomList[i]
            // 선택된 목록정보를 가져왔으면 이제 화면 이동
            val myIntent = Intent(mContext, RoomDetailActivity::class.java)
            // 정보를 담아주기
            // 2번에서는 해당 부분 오류남. 3번하고 난 다음 여기로 다시 와야함
            myIntent.putExtra("roomInfo", clickedRoom)
            // 화면 전환
            startActivity(myIntent)
        }
    }

    override fun setValues() {
        mRoomList.add(Room("기센 와인", "Giesen Wines", "마운트 릿지 리슬링", 40000, "Mount Ridge Riesling"))
        mRoomList.add(Room("캘리포니아 드리머", "California Dreamer", "캘리포니아 골드 마이너 레드", 40000, "California Gold Miner's Red"))
        mRoomList.add(Room("헤븐스 와이너리", "Havens Winery", "메를로 나파밸리", 80000, "Merlot Napa Valley"))

        mRoomAdapter = RoomAdapter(mContext, R.layout.room_list_item, mRoomList)
        roomListView.adapter = mRoomAdapter
    }
}