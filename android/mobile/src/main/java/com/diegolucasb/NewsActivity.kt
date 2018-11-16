package com.diegolucasb

import android.app.Activity
import android.os.Bundle
import com.diegolucasb.data.News
import com.diegolucasb.presentation.NewsPresenter
import com.diegolucasb.repository.NewsRepositoryImpl
import com.diegolucasb.view.NewsView
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : Activity(), NewsView {

    private val repository = NewsRepositoryImpl()
    private val presenter = NewsPresenter(this, repository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        presenter.onStart()
        nextButton.setOnClickListener { presenter.onNext() }
    }

    override fun showNews(news: News) {
        textView.text = news.text
        sourceView.text = news.source
    }
}
