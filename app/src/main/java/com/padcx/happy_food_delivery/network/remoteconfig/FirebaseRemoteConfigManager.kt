package com.padcx.happy_food_delivery.network.remoteconfig

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

object FirebaseRemoteConfigManager {

    private val remoteConfig = Firebase.remoteConfig

    init {
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 0
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
    }

    fun setUpRemoteConfigWithDefaultValuer(){
        val defaultValues: Map<String, Any> = hashMapOf(
            "restaurantScreenViewType" to 0
        )

        remoteConfig.setDefaultsAsync(defaultValues)
    }

    fun fetchRemoteConfig(){
        remoteConfig.fetch()
            .addOnCompleteListener {task ->
                if (task.isSuccessful){
                    Log.d("Firebase", "Firebase remote config fetch success")
                    remoteConfig.activate().addOnCompleteListener {
                        Log.d("Firebase", "Firebase Remote Config activated")
                    }
                }else{
                    Log.d("Firebase", "Firebase remote config fetch failed")
                }
            }
    }

    fun getViewType(): Int{
        return remoteConfig.getValue("restaurantScreenViewType").asString().toInt()
    }

}