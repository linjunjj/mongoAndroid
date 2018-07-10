package com.linjun.component


import com.linjun.ui.home.fragment.HomeRecommendFragment
import dagger.Component

/**
 * desc: .
 * author: Will .
 * date: 2017/9/2 .
 */
@Component(dependencies = [(ApplicationComponent::class)])
interface HttpComponent {
  fun inject(homeRecommentFragment : HomeRecommendFragment)

}
