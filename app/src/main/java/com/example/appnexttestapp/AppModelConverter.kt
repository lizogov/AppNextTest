package com.example.appnexttestapp

object AppModelConverter {
    fun convertNetworkAppToModel(model: AppsListResult): List<AppModel> {
        return model.most_popular_apps.map {
            AppModel(
                package_name = it.package_name,
                title = it.title,
                icon = it.icon,
                description = it.description,
                screenshots = it.screenshots[0],
                rating = it.rating,
                size = it.size,
                downloads_min = it.downloads_min,
                developer = it.developer
            )
        }
    }

//    fun convertTrailerResultToModel(trailerListResult: TrailersListResult): TrailerModel? {
//        val results: List<TrailerResult> = trailerListResult.results
//        if (results.isNotEmpty()) {
//            val videoResult: TrailerResult = results[0]
//            return TrailerModel(trailerListResult.id, videoResult.id, videoResult.key)
//        }
//        return null
//    }

}