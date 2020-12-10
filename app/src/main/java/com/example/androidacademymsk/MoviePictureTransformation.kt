package com.example.androidacademymsk

import android.graphics.Bitmap
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import java.security.MessageDigest

class MoviePictureTransformation(private val containerWidth: Int) : BitmapTransformation() {

    override fun transform(
        pool: BitmapPool,
        picToTransform: Bitmap,
        outWidth: Int,
        outHeight: Int
    ): Bitmap {
        return Bitmap.createBitmap(picToTransform, 0, 0, containerWidth, containerWidth * 248 / 16)
    }

    override fun updateDiskCacheKey(messageDigest: MessageDigest?) {
    }
}