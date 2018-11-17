package com.diegolucasb

import com.diegolucasb.data.News
import com.diegolucasb.presentation.NewsPresenter
import com.diegolucasb.repository.NewsRepository
import com.diegolucasb.view.NewsView
import io.mockk.*
import kotlin.test.Test

class NewsPresenterUnitTest {

    @Test
    fun shouldReturnNewsAfterStart() {
        val view = mockk<NewsView>()
        val repo = mockk<NewsRepository>()
        every { view.showNews(any()) } just runs
        every { repo.newsNumber } returns 1
        every { repo.getNews(0) } returns news1

        val presenter = NewsPresenter(view, repo)
        // When
        presenter.onStart()
        // Then
        verifyAll { view.showNews(news1) }
    }

    @Test
    fun shouldReturnNewsWhenClickOnNext() {
        val view = mockk<NewsView>()
        val repo = mockk<NewsRepository>()
        every { view.showNews(any()) } just runs
        every { repo.newsNumber } returns 2
        every { repo.getNews(0) } returns news1
        every { repo.getNews(1) } returns news2

        val presenter = NewsPresenter(view, repo)
        // When
        presenter.onStart()
        presenter.onNext()
        // Then
        verifyOrder {
            view.showNews(news1)
            view.showNews(news2)
        }
    }

    // After last quote, first quote is displayed
    @Test
    fun shouldShowTheFirstNewsAfterShowTheLastOne() {
        val view = mockk<NewsView>()
        val repo = mockk<NewsRepository>()
        every { view.showNews(any()) } just runs
        every { repo.newsNumber } returns 2
        every { repo.getNews(0) } returns news1
        every { repo.getNews(1) } returns news2

        val presenter = NewsPresenter(view, repo)
        // When
        presenter.onStart()
        repeat(4) {
            presenter.onNext()
        }
        // Then
        verifyOrder {
            view.showNews(news1)
            view.showNews(news2)
            view.showNews(news1)
            view.showNews(news2)
        }
    }

    companion object {
        val news1 = News("AAA", "BBB", "CCC", "DDD")
        val news2 = News("CCC", "DDD", "CCC", "DDD")
    }


}