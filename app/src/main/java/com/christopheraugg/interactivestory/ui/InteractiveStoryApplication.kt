package com.christopheraugg.interactivestory.ui

import android.app.Activity
import android.app.Application
import android.content.pm.ActivityInfo
import android.os.Bundle

/**
 * Created by chrisa on 8/17/17.
 */
class InteractiveStoryApplication: Application() {

    override fun onCreate() {
        super.onCreate()
            registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {

                override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
                    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                }

                override fun onActivityStarted(activity: Activity) {}
                override fun onActivityResumed(activity: Activity) {}
                override fun onActivityPaused(activity: Activity) {}
                override fun onActivityStopped(activity: Activity) {}
                override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle?) {}
                override fun onActivityDestroyed(activity: Activity) {}
            })
        }
}