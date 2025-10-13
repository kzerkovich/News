package com.kzerk.news.domain.entity

data class Article(
    val title: String,
    val description: String,
    val imageUrl: String?,
    val sourceNAme: String,
    val publishedAt: Long,
    val url: String
)
