package com.me.obo.opic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by obo on 2017/8/20.
 * Email:obo1993@gmail.com
 */

public class RemoteActivity extends Activity {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, RemoteActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote);

    }
}
