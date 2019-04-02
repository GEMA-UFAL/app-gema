package br.com.gema.Fragments.Community.Model

class ForumPost(
    var alternativeTitle : String = "",
    var title : String = "",
    var imageUrl : String = "",
    var tag1 : String = "",
    var tag2 : String = "",
    var description : String = "") {

    constructor() : this("", "", "", "", "", "")

    data class Builder(
        private var alternativeTitle : String = "",
        private var title : String = "",
        private var imageUrl : String = "",
        private var tag1 : String = "",
        private var tag2 : String = "",
        private var description : String = "") {

        fun alternativeTitle(alternativeTitle : String) = apply {this.alternativeTitle = alternativeTitle}

        fun title(title : String) = apply {this.title = title}

        fun imageUrl(imageUrl : String) = apply {this.imageUrl = imageUrl}

        fun tag1(tag1: String) = apply {this.tag1 = tag1}

        fun tag2(tag2: String) = apply {this.tag2 = tag2}

        fun description(description: String) = apply {this.description = description}

        fun build() : ForumPost {
            return ForumPost(
                alternativeTitle,
                title,
                imageUrl,
                tag1,
                tag2,
                description
            )
        }
    }
}