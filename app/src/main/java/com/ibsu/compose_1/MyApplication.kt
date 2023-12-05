package com.ibsu.compose_1

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.request.CachePolicy
import coil.util.DebugLogger

class MyApplication : Application(), ImageLoaderFactory {
    override fun newImageLoader(): ImageLoader {
        return ImageLoader(this).newBuilder()
            .memoryCachePolicy(CachePolicy.DISABLED)
            .memoryCache {
                MemoryCache.Builder(this)
                    .maxSizePercent(0.1)
                    .strongReferencesEnabled(true) //images that would not be garbage collected
                    .weakReferencesEnabled(false) //images that could be garbage collected
                    .build()
            }
            .diskCachePolicy(CachePolicy.DISABLED)
            .diskCache {
                DiskCache.Builder()
                    .maxSizePercent(0.03)
                    .directory(cacheDir) //where you want to cash images
                    .build()

            }
            .logger(logger = DebugLogger())
            .build()
    }

}