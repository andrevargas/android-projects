package br.univali.sisnet.autonomy.utils;


import android.content.Context;
import android.content.res.Resources;

public class Util {

    public static int getDrawableIdByName(Context context, String drawableName) {
        final Resources res = context.getResources();
        return res.getIdentifier(drawableName, "drawable", context.getPackageName());
    }

}
