package com.matism.portfolio.model

import java.util.*

class Picture : MongoModel() {

    var title: String = ""

    // --> /data/userId/projectId/images/id
    var path: String = ""

    var uploadDate: Date? = null

    var description: String = ""

    fun createPath(basePath: String, picturesPath: String, separator: String, userId: String, projectId: String) {
        this.path = basePath.plus(userId)
                .plus(separator)
                .plus(projectId)
                .plus(picturesPath)
                .plus(id)
    }
}