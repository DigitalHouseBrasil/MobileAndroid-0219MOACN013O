package br.com.digitalhouse.firebaseapp.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class AppUtil {

    public static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo;

        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected() &&
                    (networkInfo.getType() == ConnectivityManager.TYPE_WIFI
                            || networkInfo.getType() == ConnectivityManager.TYPE_MOBILE);
        }
        return false;
    }

    public static void salvarIdUsuario(Context context, String uiid) {
        SharedPreferences preferences = context.getSharedPreferences("APP", Context.MODE_PRIVATE);
        preferences.edit().putString("UIID", uiid).apply();
    }

    public static String getIdUsuario(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("APP", Context.MODE_PRIVATE);
        return preferences.getString("UIID", "");
    }
}
