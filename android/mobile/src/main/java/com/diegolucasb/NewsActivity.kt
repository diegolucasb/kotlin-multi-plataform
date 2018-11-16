package com.diegolucasb

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_quotations.*
import com.diegolucasb.data.News
import com.diegolucasb.presentation.NewsPresenter
import com.diegolucasb.repository.NewsRepositoryImpl
import com.diegolucasb.view.NewsView

class NewsActivity : Activity(), NewsView {

    private val repository = NewsRepositoryImpl()
    private val presenter = NewsPresenter(this, repository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotations)
        presenter.onStart()
        nextButton.setOnClickListener { presenter.onNext() }
    }

    override fun showNews(news: News) {
//        textView.text = quote.text
//        authorView.text = quote.person
    }
}
