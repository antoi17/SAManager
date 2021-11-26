package com.example.samanager.Objects

import androidx.lifecycle.MutableLiveData
import com.example.samanager.Enum.TypeOfData

open class DataItem(pname: String, pid: String, pType: TypeOfData) {


    var name = pname

    var id = pid

    var type = pType


    /* List that represent the number of episodes stored at the indice
        of its corresponding season */

    var nb: MutableList<Int> = mutableListOf<Int>(0, 3)



}