package com.wakwak.expandmasterdetailflow

/**
 * Created by Ryo on 2017/06/25.
 */

data class Post(
        var id: Int = -1,
        var user: String = "",
        var userImage: String = "https://pbs.twimg.com/profile_images/796931988594651136/NI7wmOLE_400x400.jpg",
        var title: String = "",
        var reason: String = "",
        var description: String = "",
        var source: String = "",
        var backgroundImage: String = "",
        var foregroundImage: String = "",
        var numOfLikes: Int = 64,
        var numOfComments: Int = 2
) {


    fun getMockPosts(): MutableList<Post> {
        return mutableListOf(graphicPostArticle(0), domesticPostArticle1(1), domesticPostArticle2(2))
    }

    private fun graphicPostArticle(id: Int): Post = Post(
            id = id,
            user = "Wantedly People Graphics",
            title = "出会った人との話題が見つかるコンテンツをお届けします。先ずは下の絵をタップしてみよう。",
            reason = "はじめに読もう",
            foregroundImage = "" /*TODO: 画像*/
    )

    private fun domesticPostArticle1(id: Int): Post = Post(
            id = id,
            user = "国内ニュース",
            title = "男性向け腕時計の月額レンタルサービス「KARITOKE」が開始",
            reason = "セイコーエプソン株式会社に関連",
            source = "朝日新聞",
            backgroundImage = "http://mensdrip.com/wp-content/uploads/2017/05/KARITOKE-2.jpg"
    )

    private fun domesticPostArticle2(id: Int): Post = Post(
            id = id,
            user = "国内ニュース",
            title = "セキュリティ事故対策は時斬が肝心。IBMが「プロアクティブ」な新サービス",
            reason = "IMBに関連",
            source = "ZDNet Japan"
    )
}
