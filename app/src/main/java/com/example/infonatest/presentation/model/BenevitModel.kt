package com.example.infonatest.presentation.model

data class BenevitModel(
    val title: String,
    val items: List<ItemModel>
)
data class ItemModel(
    val img: String,
    val name: String,
    val label: String,
    val locked: Boolean
)
