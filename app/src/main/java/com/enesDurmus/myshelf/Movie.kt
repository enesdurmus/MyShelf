package com.enesDurmus.myshelf

class Movie(name: String, imageUrl: String) {

    internal val _name: String
    internal val _imageUrl: String

    init {
        _name = name
        _imageUrl = imageUrl
    }
}