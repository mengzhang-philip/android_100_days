package com.android.listview.organiclistview;

/**
 * <pre>
 *     author : philip-knight
 *     e-mail : meng.zhang@ihandysoft.com
 *     time   : 2019/08/30
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class CRUDData {
    private int imgId;
    private String content;

    public CRUDData() {
    }

    public CRUDData(int imgId, String content) {
        this.imgId = imgId;
        this.content = content;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
