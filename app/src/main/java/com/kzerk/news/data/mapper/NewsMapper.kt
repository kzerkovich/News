package com.kzerk.news.data.mapper

import com.kzerk.news.data.local.ArticleDbModel
import com.kzerk.news.data.remote.NewsResponseDto
import com.kzerk.news.domain.entity.Article
import com.kzerk.news.domain.entity.Interval
import com.kzerk.news.domain.entity.Language
import java.text.SimpleDateFormat
import java.util.Locale

fun NewsResponseDto.toDbModels(topic: String): List<ArticleDbModel> {
    return articles.map {
        ArticleDbModel(
            title = it.title,
            description = it.description,
            url = it.url,
            imageUrl = it.urlToImage,
            sourceName = it.source.name,
            topic = topic,
            publishedAt = it.publishedAt.toTimeStamp()
        )
    }
}

fun List<ArticleDbModel>.toEntities(): List<Article> {
    return map {
        Article(
            title = it.title,
            description = it.description,
            imageUrl = it.imageUrl,
            sourceName = it.sourceName,
            publishedAt = it.publishedAt,
            url = it.url
        )
    }.distinct()
}

fun Int.toInterval(): Interval {
    return Interval.entries.first { it.minutes == this }
}

fun Language.toQueryParam(): String {
    return when (this) {
        Language.ENGLISH -> "en"
        Language.FRENCH -> "fr"
        Language.RUSSIAN -> "ru"
        Language.GERMAN -> "de"
    }
}

private fun String.toTimeStamp(): Long {
    val dateFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    return dateFormatter.parse(this)?.time ?: System.currentTimeMillis()
}