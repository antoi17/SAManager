package com.example.samanager

class SerieDataCollection(fname: String, fid: String) {


    var name = fname

    var id = fid


    /* List that represent the number of episodes stored at the indice of its correspoçnding season */

    var nb: MutableList<Int> = mutableListOf<Int>(0, 3)

    fun changeEpisodeNumberFromTo(position: Int, value: Int) {
        nb[position] = value
    }

    fun addEpisodeOfNewSeason(value: Int) {
        nb.add(value)
    }
}