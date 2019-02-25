package com.cloudservice.multiwechat.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by fengguang.qiu on 2019/1/24.
 */

public class HttpResult {

    /**
     * id : 390935
     * subLemmaId : 390935
     * newLemmaId : 7105697
     * key : 关键字
     * desc : 搜索引擎用语
     * title : 关键字
     * card : [{"key":"m25_nameC","name":"中文名","value":["关键字"],"format":["关键字"]},{"key":"m25_nameE","name":"外文名","value":["keyword"],"format":["keyword"]},{"key":"m25_ext_0","name":"用途","value":["搜索引擎，电脑语言"],"format":["搜索引擎，电脑语言"]},{"key":"m25_ext_1","name":"别名","value":["保留字"],"format":["保留字"]}]
     * image : http://f.hiphotos.baidu.com/baike/pic/item/d62a6059252dd42a6df63733093b5bb5c8eab8ae.jpg
     * src : d62a6059252dd42a6df63733093b5bb5c8eab8ae
     * imageHeight : 554
     * imageWidth : 489
     * isSummaryPic : y
     * abstract : 关键字又称保留字（keyword）是指在搜索引擎行业中，希望访问者了解的产品、服务或者公司等内容名称的用语。另外，关键字也是电脑语言用语。
     * moduleIds : []
     * url : http://baike.baidu.com/subview/390935/390935.htm
     * wapUrl : http://wapbaike.baidu.com/item/%E5%85%B3%E9%94%AE%E5%AD%97/7105697
     * hasOther : 1
     * totalUrl : http://baike.baidu.com/view/390935.htm
     * catalog : ["<a href='http://baike.baidu.com/subview/390935/390935.htm#1'>基本介绍<\/a>","<a href='http://baike.baidu.com/subview/390935/390935.htm#2'>软道语录<\/a>","<a href='http://baike.baidu.com/subview/390935/390935.htm#3'>编程语言<\/a>","<a href='http://baike.baidu.com/subview/390935/390935.htm#4'>使用技巧<\/a>"]
     * wapCatalog : ["<a href='http://wapbaike.baidu.com/item/%E5%85%B3%E9%94%AE%E5%AD%97/7105697#1'>基本介绍<\/a>","<a href='http://wapbaike.baidu.com/item/%E5%85%B3%E9%94%AE%E5%AD%97/7105697#2'>软道语录<\/a>","<a href='http://wapbaike.baidu.com/item/%E5%85%B3%E9%94%AE%E5%AD%97/7105697#3'>编程语言<\/a>","<a href='http://wapbaike.baidu.com/item/%E5%85%B3%E9%94%AE%E5%AD%97/7105697#4'>使用技巧<\/a>"]
     * logo : http://img.baidu.com/img/baike/logo-baike.gif
     * copyrights : 以上内容来自百度百科平台，由百度百科网友创作。
     * customImg :
     * redirect : []
     */

    private int id;
    private int subLemmaId;
    private int newLemmaId;
    private String key;
    private String desc;
    private String title;
    private String image;
    private String src;
    private int imageHeight;
    private int imageWidth;
    private String isSummaryPic;
    @SerializedName("abstract")
    private String abstractX;
    private String url;
    private String wapUrl;
    private int hasOther;
    private String totalUrl;
    private String logo;
    private String copyrights;
    private String customImg;
    private List<CardBean> card;
    private List<?> moduleIds;
    private List<String> catalog;
    private List<String> wapCatalog;
    private List<?> redirect;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubLemmaId() {
        return subLemmaId;
    }

    public void setSubLemmaId(int subLemmaId) {
        this.subLemmaId = subLemmaId;
    }

    public int getNewLemmaId() {
        return newLemmaId;
    }

    public void setNewLemmaId(int newLemmaId) {
        this.newLemmaId = newLemmaId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getIsSummaryPic() {
        return isSummaryPic;
    }

    public void setIsSummaryPic(String isSummaryPic) {
        this.isSummaryPic = isSummaryPic;
    }

    public String getAbstractX() {
        return abstractX;
    }

    public void setAbstractX(String abstractX) {
        this.abstractX = abstractX;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWapUrl() {
        return wapUrl;
    }

    public void setWapUrl(String wapUrl) {
        this.wapUrl = wapUrl;
    }

    public int getHasOther() {
        return hasOther;
    }

    public void setHasOther(int hasOther) {
        this.hasOther = hasOther;
    }

    public String getTotalUrl() {
        return totalUrl;
    }

    public void setTotalUrl(String totalUrl) {
        this.totalUrl = totalUrl;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(String copyrights) {
        this.copyrights = copyrights;
    }

    public String getCustomImg() {
        return customImg;
    }

    public void setCustomImg(String customImg) {
        this.customImg = customImg;
    }

    public List<CardBean> getCard() {
        return card;
    }

    public void setCard(List<CardBean> card) {
        this.card = card;
    }

    public List<?> getModuleIds() {
        return moduleIds;
    }

    public void setModuleIds(List<?> moduleIds) {
        this.moduleIds = moduleIds;
    }

    public List<String> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<String> catalog) {
        this.catalog = catalog;
    }

    public List<String> getWapCatalog() {
        return wapCatalog;
    }

    public void setWapCatalog(List<String> wapCatalog) {
        this.wapCatalog = wapCatalog;
    }

    public List<?> getRedirect() {
        return redirect;
    }

    public void setRedirect(List<?> redirect) {
        this.redirect = redirect;
    }

    public static class CardBean {
        /**
         * key : m25_nameC
         * name : 中文名
         * value : ["关键字"]
         * format : ["关键字"]
         */

        private String key;
        private String name;
        private List<String> value;
        private List<String> format;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }

        public List<String> getFormat() {
            return format;
        }

        public void setFormat(List<String> format) {
            this.format = format;
        }

        @Override
        public String toString() {
            return "CardBean{" +
                    "key='" + key + '\'' +
                    ", name='" + name + '\'' +
                    ", value=" + value +
                    ", format=" + format +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "id=" + id +
                ", subLemmaId=" + subLemmaId +
                ", newLemmaId=" + newLemmaId +
                ", key='" + key + '\'' +
                ", desc='" + desc + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", src='" + src + '\'' +
                ", imageHeight=" + imageHeight +
                ", imageWidth=" + imageWidth +
                ", isSummaryPic='" + isSummaryPic + '\'' +
                ", abstractX='" + abstractX + '\'' +
                ", url='" + url + '\'' +
                ", wapUrl='" + wapUrl + '\'' +
                ", hasOther=" + hasOther +
                ", totalUrl='" + totalUrl + '\'' +
                ", logo='" + logo + '\'' +
                ", copyrights='" + copyrights + '\'' +
                ", customImg='" + customImg + '\'' +
                ", card=" + card +
                ", moduleIds=" + moduleIds +
                ", catalog=" + catalog +
                ", wapCatalog=" + wapCatalog +
                ", redirect=" + redirect +
                '}';
    }
}
