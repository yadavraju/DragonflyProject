package com.raju.dragonflyproject.Utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.raju.dragonflyproject.R;
import com.raju.dragonflyproject.datamanager.service.ApiService;

import org.jetbrains.annotations.Nullable;

public class Helper {

    @Nullable
    public static final String DRAGON = "DRAGON_DATA";

    public static void loadDragonImage(Context context, ApiService apiService, ImageView image, String id, String url) {
        if (context != null) {
            String mediaURL = apiService.getMediaURL(id, url);
            if (!TextUtils.isEmpty(mediaURL)) {
                apiService.getPicassoInstance(context)
                        .load(mediaURL)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .into(image);
            }
        }
    }
}
