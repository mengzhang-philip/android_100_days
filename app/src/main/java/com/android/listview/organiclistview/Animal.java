package com.android.listview.organiclistview;

/**
 * <pre>
 *     author : philip-knight
 *     e-mail : meng.zhang@ihandysoft.com
 *     time   : 2019/08/28
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Animal {
    private String mName;
    private String mSpeak;
    private int mIcon;

    public Animal(){
    }

    public Animal(String mName, String mSpeak, int mIcon){
        this.mName = mName;
        this.mSpeak = mSpeak;
        this.mIcon = mIcon;
    }


    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSpeak() {
        return mSpeak;
    }

    public void setmSpeak(String mSpeak) {
        this.mSpeak = mSpeak;
    }

    public int getmIcon() {
        return mIcon;
    }

    public void setmIcon(int mIcon) {
        this.mIcon = mIcon;
    }
}
