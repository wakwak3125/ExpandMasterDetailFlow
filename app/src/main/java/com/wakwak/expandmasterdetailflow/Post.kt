package com.wakwak.expandmasterdetailflow

/**
 * Created by Ryo on 2017/06/25.
 */

class Post(
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
        var numOfComments: Int = 2,
        var theme: String = "light"
) {

    companion object {

        fun getMockPosts(): MutableList<Post> {
            val post = Post()
            return mutableListOf(
                    post.graphicPostArticle(0),
                    post.domesticPostArticle1(1),
                    post.domesticPostArticle2(2),
                    post.domesticPostArticle1(3),
                    post.domesticPostArticle2(4))
        }
    }

    fun graphicPostArticle(id: Int): Post = Post(
            id = id,
            user = "Wantedly People Graphics",
            title = "出会った人との話題が見つかるコンテンツをお届けします。先ずは下の絵をタップしてみよう。",
            reason = "はじめに読もう",
            foregroundImage = "http://blog-imgs-96.fc2.com/o/s/h/osharebantyoh/shinbun_man.png"
    )

    fun domesticPostArticle1(id: Int): Post = Post(
            id = id,
            user = "国内ニュース",
            title = "男性向け腕時計の月額レンタルサービス「KARITOKE」が開始",
            reason = "セイコーエプソン株式会社に関連",
            source = "朝日新聞",
            backgroundImage = "http://mensdrip.com/wp-content/uploads/2017/05/KARITOKE-2.jpg",
            theme = "dark"
    )

    fun domesticPostArticle2(id: Int): Post = Post(
            id = id,
            user = "国内ニュース",
            title = "セキュリティ事故対策は時斬が肝心。IBMが「プロアクティブ」な新サービス",
            reason = "IMBに関連",
            source = "ZDNet Japan"
    )
}
