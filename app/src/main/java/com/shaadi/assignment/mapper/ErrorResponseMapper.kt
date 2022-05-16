package com.shaadi.assignment.mapper

import com.shaadi.assignment.model.UserErrorResponse
import com.skydoves.sandwich.ApiErrorModelMapper
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message

/**
 * A mapper for mapping [ApiResponse.Failure.Error] response as custom [UserErrorResponse] instance.
 *
 * @see [ApiErrorModelMapper](https://github.com/skydoves/sandwich#apierrormodelmapper)
 */
object ErrorResponseMapper : ApiErrorModelMapper<UserErrorResponse> {

  /**
   * maps the [ApiResponse.Failure.Error] to the [UserErrorResponse] using the mapper.
   *
   * @param apiErrorResponse The [ApiResponse.Failure.Error] error response from the network request.
   * @return A customized [UserErrorResponse] error response.
   */
  override fun map(apiErrorResponse: ApiResponse.Failure.Error<*>): UserErrorResponse {
    return UserErrorResponse(apiErrorResponse.statusCode.code, apiErrorResponse.message())
  }
}
