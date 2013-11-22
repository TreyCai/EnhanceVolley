package com.enhancevolley;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public class DefaultResponseErrorListener implements Response.ErrorListener {
    
    private Context mContext;
    private String mErrorMsg;
    
    public DefaultResponseErrorListener(Context context) {
        mContext = context;
        mErrorMsg = "Request Error. Please try again later.";
    }
    
    public DefaultResponseErrorListener(Context context, String errorMsg) {
        mContext = context;
        mErrorMsg = errorMsg;
    }
    
    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(mContext, mErrorMsg, Toast.LENGTH_SHORT).show();
    }
    
}
