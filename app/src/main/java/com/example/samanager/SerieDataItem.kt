package com.example.samanager

class SerieDataItem(pname: String, pid: String) {


    var name = pname

    var id = pid


    /* List that represent the number of episodes stored at the indice
        of its corresponding season */

    var nb: MutableList<Int> = mutableListOf<Int>(0, 3)

    fun changeEpisodeNumberFromTo(position: Int, value: Int) {
        nb[position] = value
    }

    fun addEpisodeOfNewSeason(value: Int) {
        nb.add(value)
    }
}