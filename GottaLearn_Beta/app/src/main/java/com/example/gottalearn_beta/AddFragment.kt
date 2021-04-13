package com.example.gottalearn_beta

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

lateinit var comm: Communicator
class AddFragment : Fragment() {



    override fun onCreateView(
        @NonNull inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_add, container, false)
        comm = activity as Communicator





        /*Spinner untuk memilih mata pelajaran*/
        val mapel= resources.getStringArray(R.array.mapel)
        val spinnerMapel:Spinner = view.findViewById(R.id.a_mapel)
        if(spinnerMapel !=null){
            val adapter=  ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, mapel)
            spinnerMapel.adapter=adapter

            spinnerMapel.onItemSelectedListener=object :
                AdapterView.OnItemSelectedListener{
                @RequiresApi(Build.VERSION_CODES.O)
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
                }
        }




        /*DatePicker untuk memilih due date dari tugas*/

        val cal=Calendar.getInstance()
        val fdisplayDate:TextView=view.findViewById(R.id.a_date);
        val fDateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd/MM/yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            fdisplayDate.text = sdf.format(cal.time)

        }


        fdisplayDate.setOnClickListener{
                DatePickerDialog(requireContext(), fDateSetListener,
                        cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)).show()
      }


        /*Spinner untuk memilih priority */
        val priority= resources.getStringArray(R.array.priority)
        val spinnerPriority:Spinner = view.findViewById(R.id.a_priority)
        if(spinnerPriority !=null){
            val adapter=  ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, priority)
            spinnerPriority.adapter=adapter

            spinnerPriority.onItemSelectedListener=object :
                AdapterView.OnItemSelectedListener{
                @RequiresApi(Build.VERSION_CODES.O)
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        /*Button add Assignment*/
        val addAssignment=view.findViewById<Button>(R.id.addAssignmentButton)
        val list=ArrayList<Assignment>()
        val editTitle=view.findViewById<EditText>(R.id.a_title)
        val editDescription=view.findViewById<EditText>(R.id.a_description)

        addAssignment.setOnClickListener{


            val title=editTitle.text.toString()
            val description=editDescription.text.toString()
            val subject=spinnerMapel.selectedItem.toString()
            val date=cal.time.toString()
            val priority=spinnerPriority.selectedItem.toString()

            val data=Assignment(title,description,subject,date,priority)
            list.add(data)

            comm.passDataCom(list)

//            postData(list)


        }





        return view
    }




//    private fun postData(input: ArrayList<Assignment>){
//        val queue:RequestQueue= Volley.newRequestQueue(requireContext())
//        val url="http://192.168.100.12/Volley_Example/assignment.php"
//
//        val stringReq : StringRequest =
//            object : StringRequest(Method.POST, url,
//                Response.Listener { response ->
//                    // response
//                    var strResp = response.toString()
//                    Toast.makeText(requireContext(), strResp,Toast.LENGTH_LONG).show()
//                    Log.d("API", strResp)
//                },
//                Response.ErrorListener { error ->
//                    Toast.makeText(requireContext(), "error => $error",Toast.LENGTH_LONG).show()
//                    Log.d("API", "error => $error")
//                }
//            ){
//                override fun getParams(): MutableMap<String, String> {
//                    val gson=Gson()
//                    val params:MutableMap<String,String> = mutableMapOf()
//                    val string=gson.toJson(input)
//                    params.put("terms", string)
//                    return params
//                }
//            }
//        queue.add(stringReq)
//
//    }




}


