package com.vadym.daxxtest.ui.home

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vadym.daxxtest.data.DataRepository
import javax.inject.Inject
import kotlin.properties.Delegates

class HomeViewModel  @Inject constructor(private val newsRepository: DataRepository) : ViewModel() {

    var oPage by Delegates.notNull<Int>()
    var oLimit by Delegates.notNull<Int>()

    var scrollPosition = MutableLiveData<Int>().apply { value = 0 }
    var isShowProgress = MutableLiveData<Int>().apply { value = View.VISIBLE }

    val newsList by lazy { newsRepository.getNewsList(oPage , oLimit) }

    private val _text = MutableLiveData<String>().apply {
        value = "News Fragment"
    }
    val text: LiveData<String> = _text
}