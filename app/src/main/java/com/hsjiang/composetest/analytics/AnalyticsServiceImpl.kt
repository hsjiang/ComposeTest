package com.hsjiang.composetest.analytics

import android.util.Log
import javax.inject.Inject

class AnalyticsServiceImpl @Inject constructor() : AnalyticsService {

    override fun analyze() {
        Log.d("AnalyticsService", "AnalyticsServiceImpl analyze called")
    }
}