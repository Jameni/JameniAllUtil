package com.jameni.allutillib.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.jameni.allutillib.common.CommonUtil;
import com.jameni.allutillib.i.GetImageBitmapListener;


public class GlideUtil {


    //网络图片
    public static void displayImage(Context context, String url, ImageView img) {

        if (CommonUtil.isNotNull(context) && CommonUtil.isNotNull(img)) {
            Glide.with(context).load(url).apply(getOptions()).into(img);
        }
    }


    //网络图片
    public static void displayImage_preload(Context context, String url, ImageView img) {

        if (CommonUtil.isNotNull(context) && CommonUtil.isNotNull(img)) {
            Glide.with(context).load(url).apply(getOptions_preload()).into(img);
        }
    }


    //资源图片
    public static void displayImage(Context context, int resId, ImageView img) {

        if (CommonUtil.isNotNull(context) && CommonUtil.isNotNull(img) && resId > 0) {
            Glide.with(context).load(resId).apply(getOptions()).into(img);
//            .apply(getOptions())
        }
    }


    //资源图片
    public static void displayImage_preload(Context context, int resId, ImageView img) {

        if (CommonUtil.isNotNull(context) && CommonUtil.isNotNull(img) && resId > 0) {
            Glide.with(context).load(resId).apply(getOptions_preload()).into(img);
        }
    }


    //圆形图片
    public static void displayImage_circle(Context context, String url, ImageView img) {

        if (CommonUtil.isNotNull(context) && CommonUtil.isNotNull(img)) {
            Glide.with(context).load(url).apply(getOptions_circle()).into(img);
        }
    }

    //圆角图片
    public static void displayImage_round(Context context, String url, ImageView img) {

        if (CommonUtil.isNotNull(context) && CommonUtil.isNotNull(img)) {
            Glide.with(context).load(url).apply(getOptions_round(context)).into(img);
        }
    }

    public static void getImageBitmap(Context context, String url, final GetImageBitmapListener listener, final int flag) {


        Glide.with(context).asBitmap().load(url).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {

                if (listener != null) {
                    listener.getBitmapSuccess(resource, flag);
                }

            }

        }); //方法中设置asBitmap可以设置回调类型
    }


    public static RequestOptions options;//普通
    public static RequestOptions options_preload;//普通
    public static RequestOptions options_round;//圆角
    public static RequestOptions options_circle;//圆形

    public static RequestOptions getOptions() {

        if (!CommonUtil.isNotNull(options)) {
            options = new RequestOptions()
                    .centerCrop()
//                    .placeholder(R.mipmap.ic_launcher)
//                    .error(R.mipmap.ic_launcher)
                    .priority(Priority.NORMAL);

        }
        return options;
    }


    //有预加载图片
    public static RequestOptions getOptions_preload() {

        if (!CommonUtil.isNotNull(options_preload)) {
            options_preload = new RequestOptions()
                    .centerCrop()
                    .priority(Priority.NORMAL);

        }
        return options_preload;
    }


    public static RequestOptions getOptions_circle() {


        if (!CommonUtil.isNotNull(options_circle)) {
            options_circle = new RequestOptions()
                    .centerCrop()
                    .priority(Priority.NORMAL)
                    .transform(new GlideCircleTransform());

        }
        return options_circle;
    }


    public static RequestOptions getOptions_round(Context context) {

        if (!CommonUtil.isNotNull(options_round)) {
            options_round = new RequestOptions()
                    .centerCrop()
                    .priority(Priority.NORMAL)
                    .transform(new GlideRoundTransform(context));

        }
        return options_round;
    }

}
