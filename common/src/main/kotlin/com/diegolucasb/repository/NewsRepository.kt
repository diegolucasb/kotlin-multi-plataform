package com.diegolucasb.repository

import com.diegolucasb.data.News

interface NewsRepository {
    val newsNumber: Int
    fun getNews(newsId: Int): News
}