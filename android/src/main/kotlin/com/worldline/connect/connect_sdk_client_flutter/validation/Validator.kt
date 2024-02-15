/*
 *
 *  * Do not remove or alter the notices in this preamble.
 *  *
 *  * This software is owned by Worldline and may not be be altered, copied, reproduced, republished, uploaded, posted, transmitted or distributed in any way, without the prior written consent of Worldline.
 *  *
 *  * Copyright © 2023 Worldline and/or its affiliates.
 *  *
 *  * All rights reserved. License grant and user rights and obligations according to the applicable license agreement.
 *  *
 *  * Please contact Worldline for questions regarding license and user rights.
 *
 */

package com.worldline.connect.connect_sdk_client_flutter.validation

import com.google.gson.Gson
import com.worldline.connect.connect_sdk_client_flutter.validation.models.ValidationRequest
import com.ingenico.connect.gateway.sdk.client.android.sdk.model.paymentproduct.PaymentProduct
import com.ingenico.connect.gateway.sdk.client.android.sdk.model.validation.ValidationErrorMessage
import io.flutter.plugin.common.MethodChannel

object Validator {
    private const val TAG = "AndroidValidator"
    private val gson = Gson()

    fun validate(result: MethodChannel.Result, request: ValidationRequest) {
        val errorMessages = request.validate()
        postValidation(errorMessages, result)
    }

    private fun postValidation(errorMessages: List<ValidationErrorMessage>, result: MethodChannel.Result) {
        val resultJson = gson.toJson(errorMessages)
        result.success(resultJson)
    }
}