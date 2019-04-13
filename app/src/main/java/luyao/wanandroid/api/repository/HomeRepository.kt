package luyao.wanandroid.api.repository

import luyao.base.BaseRepository
import luyao.base.WanResponse
import luyao.wanandroid.api.WanRetrofitClient
import luyao.wanandroid.model.bean.ArticleList
import luyao.wanandroid.model.bean.Banner

/**
 * Created by luyao
 * on 2019/4/10 14:09
 */
class HomeRepository : BaseRepository() {

    suspend fun getBanners(): WanResponse<List<Banner>> {
        return apiCall { WanRetrofitClient.service.getBanner().await() }
    }

    suspend fun getArticleList(page: Int): WanResponse<ArticleList> {
        return apiCall { WanRetrofitClient.service.getHomeArticles(page).await() }
    }

    suspend fun collectArticle(articleId: Int): WanResponse<ArticleList> {
        return apiCall { WanRetrofitClient.service.collectArticle(articleId).await() }
    }

    suspend fun unCollectArticle(articleId: Int): WanResponse<ArticleList> {
        return apiCall { WanRetrofitClient.service.cancelCollectArticle(articleId).await() }
    }
}