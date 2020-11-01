package com.padcx.happy_food_delivery.network

import android.util.Log
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.padcx.happy_food_delivery.data.vos.*
import java.util.*
import kotlin.collections.HashMap

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

    override fun getPopularChoices(
        onSuccess: (popularChoices: List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("popular_choices")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: "Please check internet connection")
                } ?: run {
                    onSuccess(fetchRestaurants(value))
                }

            }
    }

    override fun getNewRestaurants(
        onSuccess: (newsRestaurants: List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("new_restaurants")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: "Please check internet connection")
                } ?: run {
                    onSuccess(fetchRestaurants(value))
                }

            }
    }

    override fun getFoodsOrderFromBasket(
        onSuccess: (orders: List<MyOrderVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("basket")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: "Please check internet connection")
                } ?: run{
                    val orders: MutableList<MyOrderVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()

                    for(document in result){
                        val data = document.data
                        val order = MyOrderVO()

                        order.count = (data?.get("count") as Long).toInt()
                        order.name = data["name"] as String
                        order.price = (data["price"] as Long).toInt()
                        order.origin_price = (data["origin_price"] as Long).toInt()
                        orders.add(order)
                    }
                    onSuccess(orders)
                }
            }
    }

    override fun addFoodToBasket(name: String, count: Int, price: Int, originPrice: Int) {
        val myOrderMap = hashMapOf(
            "name" to name,
            "price" to price,
            "count" to count,
            "origin_price" to originPrice
        )

        db.collection("basket")
            .document(name)
            .set(myOrderMap)
            .addOnSuccessListener { Log.d("Success", "==> Successfully added food to Basket") }
            .addOnFailureListener { Log.d("Failure", "==> Failed to add food to Basket") }
    }

    override fun deleteFoodFromBasket(name: String) {
        db.collection("basket")
            .document(name)
            .delete()
            .addOnSuccessListener { Log.d("Success", "==> Successfully delete food from Basket") }
            .addOnFailureListener { Log.d("Failure", "==> Failed to delete food") }
    }

    override fun deleteAllFoodInBasket() {
        db.collection("basket")
            .document()
            .delete()
            .addOnSuccessListener { Log.d("Success", "==> Successfully delete food from Basket") }
            .addOnFailureListener { Log.d("Failure", "==> Failed to delete food") }
    }


    override fun getFoodItems(
        documentId: String,
        onSuccess: (foodItems: List<FoodItemVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("new_restaurants/${documentId}/food_items")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: "Please check internet connection")
                } ?: run{

                    val foodList: MutableList<FoodItemVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val data = document.data
                        val foodItemVO = FoodItemVO()

                        foodItemVO.image = data?.get("image") as String
                        foodItemVO.name = data?.get("name") as String
                        foodItemVO.isPopular = data?.get("is_popular") as Boolean
                        foodItemVO.price = (data?.get("price") as Long).toInt()

                        foodList.add(foodItemVO)
                    }
                    onSuccess(foodList)
                }
            }
    }

    override fun getPopularFoodItems(
        documentId: String,
        onSuccess: (foodItems: List<PopularChoiceVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        db.collection("new_restaurants/${documentId}/popular_choices")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFailure(it.message ?: "Please check internet connection")
                } ?: run{

                    val foodList: MutableList<PopularChoiceVO> = arrayListOf()

                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val data = document.data
                        val foodItemVO = PopularChoiceVO()

                        foodItemVO.image = data?.get("image") as String
                        foodItemVO.name = data?.get("name") as String
                        foodItemVO.price = (data?.get("price") as Long).toInt()

                        foodList.add(foodItemVO)
                    }
                    onSuccess(foodList)
                }
            }
    }


    private fun fetchRestaurants(value: QuerySnapshot?): List<RestaurantVO> {
        val restaurantList: MutableList<RestaurantVO> = arrayListOf()
        val result = value?.documents ?: arrayListOf()

        for (document in result){
            val data = document.data
            val restaurant = RestaurantVO()
            restaurant.id = document.id
            restaurant.name = data?.get("name") as String
            restaurant.rating = data["rating"] as Double
            restaurant.location = data["location"] as String
            restaurant.image = data["image"] as String
            restaurant.estimate_time = data["estimate_time"] as String
            restaurant.type = data["type"] as String

            restaurantList.add(restaurant)
        }
        return restaurantList
    }
}