package com.padcx.happy_food_delivery.network

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.padcx.happy_food_delivery.data.vos.FoodVO
import com.padcx.happy_food_delivery.data.vos.RestaurantVO

object CloudFirestoreFirebaseApiImpl: FirebaseApi {

    private val db = Firebase.firestore


    override fun getRestaurants(
        onSuccess: (restaurants: List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("restaurants")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: "Please check internet connection")
                } ?: run {
                    val restaurantList: MutableList<RestaurantVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()

                    for (document in result){
                        val data = document.data
                        val restaurant = RestaurantVO()
                        restaurant.name = data?.get("name") as String
                        restaurant.rating = data["rating"] as Double
                        restaurant.location = data["location"] as String
                        restaurant.image = data["image"] as String
                        restaurant.estimate_time = data["estimate_time"] as String
                        restaurant.type = data["type"] as String
                        restaurantList.add(restaurant)
                    }
                    onSuccess(restaurantList)
                }

            }
    }

    override fun getFoodCategories(
        onSuccess: (categories: List<FoodVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("food_categories")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: "Please check internet connection")
                } ?: run {
                    val foodCategoryList: MutableList<FoodVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()

                    for (document in result){
                        val data = document.data
                        val category = FoodVO()

                        category.id = (data?.get("id") as Long).toInt()
                        category.type = data["type"] as String
                        category.image = data["image"] as String
                        foodCategoryList.add(category)
                    }
                    onSuccess(foodCategoryList)
                }
            }
    }
}