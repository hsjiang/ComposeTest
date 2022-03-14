package com.hsjiang.composetest.data.model

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("articleId")
    val articleId: String?,
    @SerializedName("articleUrl")
    val articleUrl: String?,
    @SerializedName("browseVolume")
    val browseVolume: Int?,
    val cities: String?,
    @SerializedName("citiesList")
    val citiesList: Array<Int>?,
    @SerializedName("miniUrl")
    val miniUrl: String?,
    @SerializedName("closeReason")
    val closeReason: String?,
    @SerializedName("commentIsRead")
    val commentIsRead: String?,
    @SerializedName("commentNum")
    val commentNum: String?,
    @SerializedName("contentType")
    val contentType: Int?,
    @SerializedName("isBig")
    val isBig: Int?,
    @SerializedName("isDeleted")
    val isDeleted: Int?,
    @SerializedName("isTop")
    val isTop: Long?,
    @SerializedName("picUrl")
    val picUrl: String?,
    @SerializedName("platformId")
    val platformId: String?,
    @SerializedName("platformIntroduce")
    val platformIntroduce: String?,
    @SerializedName("platformName")
    val platformName: String?,
    @SerializedName("platformPic")
    val platformPic: String?,
    @SerializedName("pubTime")
    val pubTime: String?,
    @SerializedName("relatedArticleId")
    val relatedArticleId: String?,
    @SerializedName("repetitionRate")
    val repetitionRate: String?,
    @SerializedName("simHash")
    val simHash: String?,
    val stages: String?,
    @SerializedName("stagesList")
    val stagesList: Array<Int>?,
    /**
     * 0未发布，1已发布，2已下架
     */
    val status: Int?,
    val summary: String?,
    @SerializedName("thematicList")
    val thematicList: Any??,
    val thematics: String?,
    @SerializedName("thumbsUpNum")
    val thumbsUpNum: Int?,
    val title: String?,
    val type: Int?,
    @SerializedName("updateTime")
    val updateTime: String?,
    @SerializedName("wechatUrl")
    val wechatUrl: String?,
)