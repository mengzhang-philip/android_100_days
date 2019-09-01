package com.android.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author : philip-knight
 *     e-mail : meng.zhang@ihandysoft.com
 *     time   : 2019/09/01
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class SharedHelper {
    private Context mContext;

    public SharedHelper() {
    }

    public SharedHelper(Context mContext) {
        this.mContext = mContext;
    }

    public void save(String userName, String passWord) {
        SharedPreferences sp = mContext.getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("user_name", userName);
        editor.putString("user_password", passWord);
        editor.commit();
        Toast.makeText(mContext,"SharedPreference",Toast.LENGTH_LONG).show();
    }

    public Map<String,String> read(){
        Map<String,String> data = new HashMap<String,String>();
        SharedPreferences sp = mContext.getSharedPreferences("login", Context.MODE_PRIVATE);
        data.put("user_name",sp.getString("user_name",""));
        data.put("password",sp.getString("user_password",""));
        return data;
    }
}
