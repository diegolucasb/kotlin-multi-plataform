package com.diegolucasb.presentation

import com.diegolucasb.repository.NewsRepository
import com.diegolucasb.view.NewsView

class NewsPresenter(
        private val view: NewsView,
        private val repo: NewsRepository
) {
    private var newsNewsId = -1

    fun onStart() {
        onNext()
    }

    fun onNext() {
        newsNewsId = (newsNewsId + 1) % repo.newsNumber
        val news = repo.getNews(newsNewsId)
        view.showNews(news)
    }
}