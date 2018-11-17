//
//  ViewController.kt
//  ios
//
//  Created by Marcin Moskala on 17.07.2018.
//  Copyright © 2018 marcinmoskala. All rights reserved.
//

import kotlinx.cinterop.*
import platform.Foundation.*
import platform.UIKit.*
import com.diegolucasb.data.News
import com.diegolucasb.presentation.NewsPresenter
import com.diegolucasb.repository.NewsRepositoryImpl
import com.diegolucasb.view.NewsView

@ExportObjCClass
class ViewController : UIViewController {

    constructor(aDecoder: NSCoder): super(aDecoder)
    override fun initWithCoder(aDecoder: NSCoder) = initBy(ViewController(aDecoder))

    @ObjCOutlet lateinit var textView: UILabel
    @ObjCOutlet lateinit var sourceView: UILabel

    private val newsView = object : NewsView {
        override fun showNews(news: News) {
            textView.text = news.text
            sourceView.text = news.person
        }
    }
    private val repository = NewsRepositoryImpl()
    private val presenter = NewsPresenter(newsView, repository)

    override fun viewDidLoad() {
        presenter.onStart()
    }

    @ObjCAction
    fun onNext() {
        presenter.onNext()
    }
}
