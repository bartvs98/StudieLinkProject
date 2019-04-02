package com.studielink.trustchain.color;

import android.content.Context;

import com.studielink.trustchain.R;

public class ChainColor {
    /**
     * Get color based hash
     * @param context
     * @param hash
     * @return
     */
    public static int getColor(Context context, String hash) {
        int[] colors = context.getResources().getIntArray(R.array.colorsChain);
        int number = Math.abs(hash.hashCode() % colors.length);
        return colors[number];
    }

    /**
     * Get the color of the current app user
     * @param context
     * @return
     */
    public static int getMyColor(Context context){
        return context.getResources().getColor(R.color.colorPrimary);
    }
}