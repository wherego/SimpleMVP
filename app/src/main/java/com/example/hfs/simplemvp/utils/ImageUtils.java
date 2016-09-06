package com.example.hfs.simplemvp.utils;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.hfs.simplemvp.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class ImageUtils {
	 /**
     * 异步加载图片
     *
     * @param context 上下文
     * @param ivImg   加载图片的ImageView
     * @param picUrl  图片地址
     */
    public static void loadImg(Context context, final ImageView ivImg, String picUrl) {
        Glide.with(context).load(picUrl).into(new GlideDrawableImageViewTarget(ivImg){
        	@Override
        	public void onLoadFailed(Exception e, Drawable errorDrawable) {
        		// TODO Auto-generated method stub
        		super.onLoadFailed(e, errorDrawable);
        		 ivImg.setImageResource(R.mipmap.ic_launcher);
        	}
        });
               
    }

    public static int i = 0;

    public static int getI() {
        return i;
    }

    public static void setI(int j) {
        i = j;
    }

}
