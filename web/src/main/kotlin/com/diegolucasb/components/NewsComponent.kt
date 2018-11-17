package com.diegolucasb.components

import com.diegolucasb.data.News
import com.diegolucasb.presentation.NewsPresenter
import com.diegolucasb.repository.NewsRepositoryImpl
import com.diegolucasb.view.NewsView
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.button
import react.dom.div

class NewsComponent: RComponent<RProps, ManagerComponentState>(), NewsView {

    private val repository = NewsRepositoryImpl()
    private val presenter = NewsPresenter(this, repository)

    override fun componentDidMount() {
        presenter.onStart()
    }

    override fun RBuilder.render() {
        div(classes = "center") {
            val news = state.news
            if (news == null) {
                +"There is no news"
            } else {
                div(classes = "news-container") {
                    div(classes = "text") { +news.text }
                    div(classes = "source") { +news.source }
                    button(classes = "next") {
                        +"Next"
                        attrs { onClickFunction = { presenter.onNext() } }
                    }
                }
            }
        }
    }

    override fun showNews(news: News) {
        setState { this.news = news }

    }
}

external interface ManagerComponentState : RState {
    var news: News?
}