package com.diegolucasb.repository

import com.diegolucasb.data.News

class NewsRepositoryImpl : NewsRepository {

    override val newsNumber: Int
        get() = news.size

    override fun getNews(newsId: Int): News = news[newsId]

    companion object {
        private val news = listOf(
                News(
                        "Governo cubano quer tirar seus médicos do Brasil até o fim do ano",
                        "Brasil",
                        "Globo.com",
                        "https://g1.globo.com/politica/noticia/2018/11/15/conselho-diz-que-foi-avisado-pela-embaixada-de-cuba-que-medicos-deixarao-brasil-ate-fim-do-ano.ghtml"),
                News(
                        "Google descobre forma de economizar bateria de celular em até 63%",
                        "Tecnologia",
                        "TechTudo",
                        "https://www.techtudo.com.br/noticias/2018/11/google-descobre-forma-de-economizar-bateria-de-celular-em-ate-63.ghtml"),
                News(
                        "Vice-presidente dos EUA diz que Donald Trump deve ter 2º encontro com Kim Jong-Un em 2019",
                        "Mundo",
                        "G1",
                        "https://g1.globo.com/mundo/noticia/2018/11/15/vice-presidente-dos-eua-diz-que-donald-trump-deve-ter-2o-encontro-com-kim-jong-un-em-2019.ghtml")
        )
    }
}