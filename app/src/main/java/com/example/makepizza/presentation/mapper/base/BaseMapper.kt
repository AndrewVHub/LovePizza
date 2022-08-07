package com.example.makepizza.presentation.mapper.base

abstract class BaseMapper<From, To> {
    abstract fun map(from: From): To
}