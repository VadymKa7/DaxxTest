package com.vadym.daxxtest.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

data class ComplicatedObject
        (
        @field:SerializedName("title")
        val title: String,
        @field:SerializedName("description")
        val desc: String,
        @field:SerializedName("language")
        val language: String,
        @field:SerializedName("item")
        val newsList: List<NewsItem>
)

@Parcelize
data class NewsItem(
        @field:SerializedName("title")
        val itemTitle: String,
        @field:SerializedName("link")
        val imageLink: String,
        @field:SerializedName("description")
        val itemDesc: String,
        @field:SerializedName("estimate")
        var estimate: Float = 0.0f,
        @field:SerializedName("content")
        val newsContent: @RawValue NewsContent
) : Parcelable

@Parcelize
data class NewsContent(
        @field:SerializedName("_url")
        val imageThumb: String
): Parcelable