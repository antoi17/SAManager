package com.example.samanager.repositories

import androidx.lifecycle.MutableLiveData
import com.example.samanager.SerieDataItem

class WatcherRepository {

    val watch : MutableLiveData<SerieDataItem> by lazy {
        MutableLiveData<SerieDataItem>()
    }


}
