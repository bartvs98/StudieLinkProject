package nl.tudelft.cs4160.trustchain_android.SharedPreferences;

import android.content.Context;

public class LoginTypeStorage {

    static String loginTypeStorage = "loginTypeStorage";

    public static void setLoginType(Context contex, String loginType) {
        SharedPreferencesStorage.writeSharedPreferences(contex, loginTypeStorage, loginType);
    }

    public static String getLoginType(Context context) {
        return SharedPreferencesStorage.readSharedPreferences(context, loginTypeStorage);
    }

}
