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

package com.worldline.connect.connect_sdk_client_flutter.validation.models

import com.ingenico.connect.gateway.sdk.client.android.sdk.model.PaymentRequest
import com.ingenico.connect.gateway.sdk.client.android.sdk.model.validation.AbstractValidationRule
import com.ingenico.connect.gateway.sdk.client.android.sdk.model.validation.ValidationErrorMessage
import com.worldline.connect.connect_sdk_client_flutter.validation.models.ValidationRequest

data class PaymentRequestRuleValidationRequest(
    val paymentRequest: PaymentRequest,
    val fieldId: String,
    val rule: AbstractValidationRule
) : ValidationRequest {
    override fun validate(): List<ValidationErrorMessage> {
        return if (rule.validate(paymentRequest, fieldId)) emptyList() else listOf(
            ValidationErrorMessage(rule.messageId, fieldId, rule)
        )
    }
}