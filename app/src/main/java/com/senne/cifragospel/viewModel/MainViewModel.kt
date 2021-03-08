package com.senne.cifragospel.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.senne.cifragospel.MusicModel

class MainViewModel: ViewModel() {


fun getData(): LiveData<MutableList<MusicModel>> {
    val mutableData = MutableLiveData<MutableList<MusicModel>>()
    FirebaseFirestore.getInstance().collection("Antonio Cirilo").get()
            .addOnSuccessListener {result ->
                val list = mutableListOf<MusicModel>()
                for(document in result) {
                    val titulo = document.getString("titulo")
                    val banda = document.getString("banda")
                    val id = document.id.toString()
                    val music = MusicModel("$id", titulo!!,banda!!)
                    list.add(music)
                }

                mutableData.value = list

            }
    return mutableData
}





}