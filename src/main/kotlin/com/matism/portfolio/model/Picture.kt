package com.matism.portfolio.model

class Picture : MongoModel() {

    fun createPath(basePath: String, picturesPath: String, separator: String, userId: String, projectId: String) {
        this.path = basePath.plus(userId)
                .plus(separator)
                .plus(projectId)
                .plus(picturesPath)
                .plus(id)
    }

    var title: String = ""

    // --> /data/userId/projectId/images/id
    var path: String = ""
}