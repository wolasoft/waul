package com.wolasoft.waul.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.wolasoft.waul.encryptions.AESEncryption;
import com.wolasoft.waul.encryptions.Encryption;

import java.lang.reflect.Type;

public class BasePreferences {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Gson gson;

    public BasePreferences(Context context, String prefsName) {
        this.gson = new Gson();
        this.preferences = context.getApplicationContext().getSharedPreferences(
                prefsName, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    /**
     * Save an object to app preference
     * @param key Value key
     * @param data Object to save
     * @param <T> Generic object type
     */
    public <T> void saveObject(String key, T data) {
        String jsonData = this.gson.toJson(data);
        editor.putString(Encryption.toBase64(key), Encryption.toBase64(jsonData));
        editor.apply();
    }

    /**
     * Save an object to app preference
     * @param key The value key
     * @param data The object to save
     * @param type The specific genericized type of the object
     * @param <T> Generic object type
     */
    public <T> void saveObject(String key, T data, Type type) {
        String jsonData = this.gson.toJson(data, type);
        try {
            String encryptedKey = AESEncryption.encrypt(key);
            String encryptedData = AESEncryption.encrypt(jsonData);
            editor.putString(encryptedKey, encryptedData);
            editor.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Save an object to app preference
     * @param key The value key
     * @param type The specific genericized type of the object
     * @param defaultValue The default value to return if no value found
     * @param <T> Generic object type
     * @return
     */
    public <T> T getObject(String key, Type type, T defaultValue) {
        T decodedObject = null;

        try {
            String encryptedKey = AESEncryption.encrypt(key);
            String encryptedData = preferences.getString(encryptedKey, null);
            String decodedData = AESEncryption.decrypt(encryptedData);

            decodedObject = this.gson.fromJson(decodedData, type);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return decodedObject != null ? decodedObject : defaultValue;
    }

    public void remove(String key) {
        try {
            String encryptedKey = AESEncryption.encrypt(key);
            editor.remove(encryptedKey);
            editor.commit();
            editor.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
