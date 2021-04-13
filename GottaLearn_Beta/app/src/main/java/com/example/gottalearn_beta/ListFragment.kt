package com.example.gottalearn_beta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {




    private val exampleList=ArrayList<ExampleItem>()
    private val adapter=ExampleAdapter(exampleList)
//    private val exampleList= generateDummyList(20)
//    private val adapter=ExampleAdapter(exampleList)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view=inflater.inflate(R.layout.fragment_list, container, false)
        val List=arguments?.getParcelableArrayList<Assignment>("DATA_ASSIGNMENT")

        if(List!=null){
            for (i in List.indices){
                val item=ExampleItem(signImage(List[i].priority),List[i].title, List[i].date )
                exampleList.add(item)
            }

        }else{
            Toast.makeText(requireContext(), "tidak ada Assignment", Toast.LENGTH_LONG).show()
        }






        return view
    }

    private fun signImage(input:String):Int{
        val drawable= when (input){
            "Low"-> R.drawable.ic_bookmark_green
            "High"-> R.drawable.ic_bookmark_orange
            "Medium"-> R.drawable.ic_bookmark_yellow
            else -> R.drawable.ic_bookmark_red
        }
        return drawable
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView : RecyclerView =view.findViewById(R.id.recycle_view)
        recyclerView.adapter=adapter
        recyclerView.layoutManager= LinearLayoutManager(activity)
    }

//    private fun generateDummyList (size: Int): ArrayList<ExampleItem>{
//        val list=ArrayList<ExampleItem>()
//
//        for (i in 0 until size){
//            val drawable= when (i % 4){
//                0 -> R.drawable.ic_bookmark_green
//                1 -> R.drawable.ic_bookmark_orange
//                2 -> R.drawable.ic_bookmark_yellow
//                else -> R.drawable.ic_bookmark_red
//            }
//            val text1=when(i % 3){
//                0->"APSI"
//                1->"PBB"
//                else->"PPL1"
//            }
//            val item = ExampleItem(drawable, text1, text2 = "$i d 2h")
//            list+=item
//
//        }
//        return list
//    }

}
