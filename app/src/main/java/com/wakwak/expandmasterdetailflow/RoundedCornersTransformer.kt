package com.wakwak.expandmasterdetailflow

import android.graphics.*
import com.squareup.picasso.Transformation

/**
 * Created by Ryo on 2017/06/22.
 */

class RoundedCornersTransformer(private val radius: Int, private val margin: Int) : Transformation {

    override fun transform(source: Bitmap): Bitmap {
        //Bitmap cropped = createSquareBitmap(source);

        val rounded = Bitmap.createBitmap(source.width, source.height, Bitmap.Config.ARGB_8888)

        val c = Canvas(rounded)
        val p = Paint()
        p.isAntiAlias = true
        p.shader = BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

        val width = source.width - margin
        val height = source.height - margin

        c.drawRoundRect(RectF(margin.toFloat(), margin.toFloat(), width.toFloat(), height.toFloat()), radius.toFloat(), radius.toFloat(), p)

        source.recycle()
        return rounded
    }

    private fun createSquareBitmap(source: Bitmap): Bitmap {
        val cropped: Bitmap
        if (source.width >= source.height) {
            cropped = Bitmap.createBitmap(
                    source,
                    source.width / 2 - source.height / 2,
                    0,
                    source.height,
                    source.height
            )
        } else {
            cropped = Bitmap.createBitmap(
                    source,
                    source.height / 2 - source.width / 2,
                    0,
                    source.width,
                    source.width
            )
        }
        return cropped
    }

    override fun key(): String {
        return "SquareRoundedCornersTransformer(radius=$radius, (margin=$margin)"
    }
}
