package com.raju.dragonflyproject.datamanager.service

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Raju Yadav
 * Factory class for convenient creation of the Api Service interface
 */

object ApiService {
    val USER_NAME: String = "anything";
    val PASS_WORD: String = "evalpass";
    private var picasso: Picasso? = null;

    var client = OkHttpClient.Builder()
            .addInterceptor(BasicAuthInterceptor(USER_NAME, PASS_WORD))
            .build()

    fun getDragonFlyService(): DragonService? {
        return Retrofit.Builder()
                .baseUrl(DragonService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
                .create(DragonService::class.java)
    }

    /**
     * Singleton instance for Picasso
     */
    fun getPicassoInstance(context: Context): Picasso? {
        if (picasso == null) {
            picasso = Picasso.Builder(context)
                    .downloader(OkHttp3Downloader(client))
                    .build()
        }
        return picasso;
    }

    /**
     * get media url for loading image
     */
    fun getMediaURL(eventId: String, mediaId: String): String {
        return DragonService.BASE_URL + "api/dfkey/events/" + eventId + "/media/" + mediaId;
    }
}
