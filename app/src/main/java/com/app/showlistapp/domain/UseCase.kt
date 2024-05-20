package com.app.showlistapp.domain

abstract class UseCase<Input, Output> {
    abstract suspend operator fun invoke(params: Input): Result<Output>
}