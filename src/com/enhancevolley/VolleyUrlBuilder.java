package com.enhancevolley;

import java.util.HashMap;
import java.util.Map;

import android.text.TextUtils;

/**
 * @author cqy
 */
public class VolleyUrlBuilder {
    
    private StringBuilder mUrl;
    private HashMap<String, String> mQueryParamsMap;
    private String mFinalUrl;
    
    public VolleyUrlBuilder(String baseUrl) {
        mUrl = new StringBuilder(baseUrl);
        mQueryParamsMap = new HashMap<String, String>();
    }
    
    public VolleyUrlBuilder(String baseUrl, String subUrl) {
        mUrl = new StringBuilder(baseUrl);
        mUrl.append(subUrl);
        mQueryParamsMap = new HashMap<String, String>();
    }
    
    public String getFinalRequestUrl() {
        if (TextUtils.isEmpty(mFinalUrl)) {
            StringBuilder query = getQueryString();
            if (TextUtils.isEmpty(query)) {
                mFinalUrl = mUrl.toString();
            } else {
                mFinalUrl = mUrl.append(getQueryString()).toString();
            }
        }
        return mFinalUrl;
    }
    
    private StringBuilder getQueryString() {
        if (mQueryParamsMap != null && mQueryParamsMap.size() > 0) {
            StringBuilder queryString = new StringBuilder();
            for (Map.Entry<String, String> entry : mQueryParamsMap.entrySet()) {
                queryString.append('&');
                queryString.append(entry.getKey());
                queryString.append('=');
                queryString.append(entry.getValue());
            }
            // replace first "&" to "?" then return "?attr1=...&attr2=..."
            return queryString.replace(0, 1, "?");
        }
        return null;
    }
    
    /**
     * @param name
     *            param's name
     * @param value
     *            param's boolean value
     * @param isConvertToString
     * <br/ >
     *            Set true: value => "true"/"false"<br/ >
     *            Set false: value => "1"/"0"
     */
    public void appendParam(String name, boolean value,
            boolean isConvertToString) {
        if (isConvertToString) {
            mQueryParamsMap.put(name, String.valueOf(value));
        } else {
            if (value) {
                mQueryParamsMap.put(name, String.valueOf(1));
            } else {
                mQueryParamsMap.put(name, String.valueOf(0));
            }
        }
    }
    
    public void appendParam(String name, String value) {
        mQueryParamsMap.put(name, value);
    }
    
    public void appendParam(String name, int value) {
        mQueryParamsMap.put(name, String.valueOf(value));
    }
    
    public void appendParam(String name, float value) {
        mQueryParamsMap.put(name, String.valueOf(value));
    }
    
    public void appendParam(String name, double value) {
        mQueryParamsMap.put(name, String.valueOf(value));
    }
    
    public void appendParam(String name, long value) {
        mQueryParamsMap.put(name, String.valueOf(value));
    }
    
    public void removeParam(String name) {
        mQueryParamsMap.remove(name);
    }
}
