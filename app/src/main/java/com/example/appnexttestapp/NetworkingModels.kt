package com.example.appnexttestapp

import com.google.gson.annotations.SerializedName

data class AppsListResult(

    @SerializedName("most_popular_apps") val most_popular_apps : List<AppResult>

)

data class AppResult(

    @SerializedName("rating") val rating : Double,
    @SerializedName("package_name") val package_name : String,
    @SerializedName("screenshots") val screenshots : List<String>,
    @SerializedName("badges") val badges : List<String>,
    @SerializedName("developer") val developer : String,
    @SerializedName("price_currency") val price_currency : String,
    @SerializedName("icon_72") val icon_72 : String,
    @SerializedName("title") val title : String,
    @SerializedName("interactive_elements") val interactive_elements : List<String>,
    @SerializedName("privacy_policy") val privacy_policy : String,
    @SerializedName("category") val category : String,
    @SerializedName("version_code") val version_code : Int,
    @SerializedName("version") val version : String,
    @SerializedName("size") val size : Int,
    @SerializedName("price_i18n_countries") val price_i18n_countries : List<String>,
    @SerializedName("cat_int") val cat_int : Int,
    @SerializedName("created") val created : String,
    @SerializedName("market_update") val market_update : String,
    @SerializedName("market_url") val market_url : String,
    @SerializedName("cat_key") val cat_cat_key : String,
    @SerializedName("downloads") val downloads : String,
    @SerializedName("cat_keys") val cat_cat_keyss : List<String>,
    @SerializedName("from_developer") val from_developer : List<String>,
    @SerializedName("iap") val iap : Boolean,
    @SerializedName("website") val website : String,
    @SerializedName("promo_video") val promo_video : String,
    @SerializedName("content_descriptors") val content_descriptors : List<String>,
    @SerializedName("what_is_new") val what_is_new : String,
    @SerializedName("number_ratings") val number_ratings : Int,
    @SerializedName("similar") val similar : List<String>,
    @SerializedName("screenshots_count") val screenshots_count : Int,
    @SerializedName("market_status") val market_status : String,
    @SerializedName("short_desc") val short_desc : String,
    @SerializedName("downloads_max") val downloads_max : String,
    @SerializedName("price_numeric") val price_numeric : Int,
    @SerializedName("contains_ads") val contains_ads : Boolean,
    @SerializedName("description") val description : String,
    @SerializedName("price") val price : String,
    @SerializedName("i18n_lang") val i18n_lang : List<String>,
    @SerializedName("downloads_min") val downloads_min : String,
    @SerializedName("promo_video_image") val promo_video_image : String,
    @SerializedName("icon") val icon : String,
    @SerializedName("lang") val lang : String,
    @SerializedName("cat_type") val cat_type : Int,
    @SerializedName("content_rating") val content_rating : String,
    @SerializedName("ratings_4") val ratings_4 : Int,
    @SerializedName("ratings_5") val ratings_5 : Int,
    @SerializedName("ratings_2") val ratings_2 : Int,
    @SerializedName("ratings_3") val ratings_3 : Int,
    @SerializedName("ratings_1") val ratings_1 : Int
)

