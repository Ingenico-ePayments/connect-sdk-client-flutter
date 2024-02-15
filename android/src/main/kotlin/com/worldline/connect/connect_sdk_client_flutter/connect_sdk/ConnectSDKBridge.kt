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

package com.worldline.connect.connect_sdk_client_flutter.connect_sdk

import com.google.gson.Gson
import com.ingenico.connect.gateway.sdk.client.android.ConnectSDK
import com.ingenico.connect.gateway.sdk.client.android.sdk.model.ConvertedAmountResponse
import com.ingenico.connect.gateway.sdk.client.android.sdk.model.EncryptedPaymentRequest
import com.ingenico.connect.gateway.sdk.client.android.sdk.model.PaymentProductDirectoryResponse
import com.ingenico.connect.gateway.sdk.client.android.sdk.model.PublicKeyResponse
import com.ingenico.connect.gateway.sdk.client.android.sdk.model.ThirdPartyStatusResponse
import com.ingenico.connect.gateway.sdk.client.android.sdk.model.iin.IinDetailsResponse
import com.ingenico.connect.gateway.sdk.client.android.sdk.model.paymentproduct.BasicPaymentItems
import com.ingenico.connect.gateway.sdk.client.android.sdk.model.paymentproduct.BasicPaymentProductGroups
import com.ingenico.connect.gateway.sdk.client.android.sdk.model.paymentproduct.BasicPaymentProducts
import com.ingenico.connect.gateway.sdk.client.android.sdk.model.paymentproduct.PaymentProduct
import com.ingenico.connect.gateway.sdk.client.android.sdk.model.paymentproduct.PaymentProductGroup
import com.ingenico.connect.gateway.sdk.client.android.sdk.network.ApiErrorResponse
import com.worldline.connect.connect_sdk_client_flutter.client_api.models.ConvertAmountRequest
import com.worldline.connect.connect_sdk_client_flutter.client_api.models.IinDetailsRequest
import com.worldline.connect.connect_sdk_client_flutter.client_api.models.PaymentProductDirectoryRequest
import com.worldline.connect.connect_sdk_client_flutter.client_api.models.PaymentProductGroupRequest
import com.worldline.connect.connect_sdk_client_flutter.client_api.models.PaymentProductRequest
import com.worldline.connect.connect_sdk_client_flutter.client_api.models.Result
import com.worldline.connect.connect_sdk_client_flutter.client_api.models.ThirdPartyStatusRequest
import com.worldline.connect.connect_sdk_client_flutter.connect_sdk.models.EncryptPaymentRequest
import com.worldline.connect.connect_sdk_client_flutter.connect_sdk.models.InitializeSDKRequest
import io.flutter.plugin.common.MethodChannel

object ConnectSDKBridge {
    private val gson = Gson()

    private val connectSDK = ConnectSDK
    private var initialized = false
    fun isInitialized() : Boolean {
        return initialized
    }

    fun initializeConnectSDK(request: InitializeSDKRequest) {
        connectSDK.initialize(request.connectSDKConfiguration, request.paymentConfiguration)
        initialized = true
    }

    fun getPublicKey(result: MethodChannel.Result) {
        connectSDK.getClientApi().getPublicKey(
            onSuccess = { publicKeyResponse ->
                handleResponse<PublicKeyResponse>(response = publicKeyResponse, resultChannel = result)
            },
            onApiError = { apiError ->
                handleResponse<PublicKeyResponse>(apiError = apiError, resultChannel = result)
            },
            onFailure = { t ->
                handleResponse<PublicKeyResponse>(throwable = t, resultChannel = result)
            }
        )
    }

    fun getBasicPaymentProducts(result: MethodChannel.Result) {
        connectSDK.getClientApi().getPaymentProducts(
            onSuccess = { basicPaymentProducts ->
                handleResponse<BasicPaymentProducts>(response = basicPaymentProducts, resultChannel = result)
            },
            onApiError = { apiError ->
                handleResponse<BasicPaymentProducts>(apiError = apiError, resultChannel = result)
            },
            onFailure = { t ->
                handleResponse<BasicPaymentProducts>(throwable = t, resultChannel = result)
            })
    }

    fun getPaymentProduct(result: MethodChannel.Result, request: PaymentProductRequest) {
        // Calls that use payment context needs re-initializing since the paymentContext might have changed
        connectSDK.getClientApi().getPaymentProduct(request.productId,
            onSuccess = { paymentProduct ->
                handleResponse<PaymentProduct>(response = paymentProduct, resultChannel = result)
            },
            onApiError = { apiError ->
                handleResponse<PaymentProduct>(apiError = apiError, resultChannel = result)
            },
            onFailure = { t ->
                handleResponse<PaymentProduct>(throwable = t, resultChannel = result)
            })
    }

    fun getPaymentProductGroups(result: MethodChannel.Result) {
        connectSDK.getClientApi().getPaymentProductGroups(
            onSuccess = { basicPaymentProductGroups ->
                handleResponse<BasicPaymentProductGroups>(response = basicPaymentProductGroups, resultChannel = result)
            },
            onApiError = { apiError ->
                handleResponse<BasicPaymentProductGroups>(apiError = apiError, resultChannel = result)
            },
            onFailure = { t ->
                handleResponse<BasicPaymentProductGroups>(throwable = t, resultChannel = result)
            })
    }

    fun getPaymentProductGroup(result: MethodChannel.Result, request: PaymentProductGroupRequest) {
        connectSDK.getClientApi().getPaymentProductGroup(request.paymentProductGroupId,
            onSuccess = { paymentProductGroup ->
                handleResponse<PaymentProductGroup>(response = paymentProductGroup, resultChannel = result)
            },
            onApiError = { apiError ->
                handleResponse<PaymentProductGroup>(apiError = apiError, resultChannel = result)
            },
            onFailure = { t ->
                handleResponse<PaymentProductGroup>(throwable = t, resultChannel = result)
            })
    }

    fun getIinDetails(result: MethodChannel.Result, request: IinDetailsRequest) {
        connectSDK.getClientApi().getIINDetails(request.partialCreditCardNumber,
            onSuccess = { iinDetails ->
                handleResponse<IinDetailsResponse>(response = iinDetails, resultChannel = result)
            },
            onApiError = { apiError ->
                handleResponse<IinDetailsResponse>(apiError = apiError, resultChannel = result)
            },
            onFailure = { t ->
                handleResponse<IinDetailsResponse>(throwable = t, resultChannel = result)
            })
    }

    fun getPaymentItems(result: MethodChannel.Result) {
        connectSDK.getClientApi().getPaymentItems(
            onSuccess = { basicPaymentItems ->
                handleResponse<BasicPaymentItems>(response = basicPaymentItems, resultChannel = result)
            },
            onApiError = { apiError ->
                handleResponse<BasicPaymentItems>(apiError = apiError, resultChannel = result)
            },
            onFailure = { t ->
                handleResponse<BasicPaymentItems>(throwable = t, resultChannel = result)
            })
    }

    fun getPaymentProductDirectory(result: MethodChannel.Result, request: PaymentProductDirectoryRequest) {
        connectSDK.getClientApi().getPaymentProductDirectory(request.productId,
            onSuccess = { paymentProductDirectory ->
                handleResponse<PaymentProductDirectoryResponse>(response = paymentProductDirectory, resultChannel = result)
            },
            onApiError = { apiError ->
                handleResponse<PaymentProductDirectoryResponse>(apiError = apiError, resultChannel = result)
            },
            onFailure = { t ->
                handleResponse<PaymentProductDirectoryResponse>(throwable = t, resultChannel = result)
            })
    }

    fun getThirdPartyStatus(result: MethodChannel.Result, request: ThirdPartyStatusRequest) {
        connectSDK.getClientApi().getThirdPartyStatus(request.paymentId,
            onSuccess = { thirdPartyStatusResponse ->
                handleResponse<ThirdPartyStatusResponse>(response = ThirdPartyStatusResponse(thirdPartyStatusResponse), resultChannel = result)
            },
            onApiError = { apiError ->
                handleResponse<ThirdPartyStatusResponse>(apiError = apiError, resultChannel = result)
            },
            onFailure = { t ->
                handleResponse<ThirdPartyStatusResponse>(throwable = t, resultChannel = result)
            })
    }

    fun convertAmount(result: MethodChannel.Result, request: ConvertAmountRequest) {
        connectSDK.getClientApi().convertAmount(request.source, request.target, request.amount,
            onSuccess = { convertedAmount ->
                handleResponse<ConvertedAmountResponse>(response = ConvertedAmountResponse(convertedAmount), resultChannel = result)
            },
            onApiError = { apiError ->
                handleResponse<ConvertedAmountResponse>(apiError = apiError, resultChannel = result)
            },
            onFailure = { t ->
                handleResponse<ConvertedAmountResponse>(throwable = t, resultChannel = result)
            })
    }

    fun encryptPaymentRequest(result: MethodChannel.Result, request: EncryptPaymentRequest) {
        connectSDK.encryptPaymentRequest(request.paymentRequest,
            onSuccess = { encryptedPaymentRequest ->
                handleResponse<EncryptedPaymentRequest>(response = encryptedPaymentRequest, resultChannel = result)
            },
            onFailure = { t ->
                handleResponse<EncryptedPaymentRequest>(throwable = t, resultChannel = result)
            })
    }

    private fun <T> handleResponse(response: T? = null, apiError: ApiErrorResponse? = null, throwable: Throwable? = null, resultChannel: MethodChannel.Result) {
        if (response == null && apiError == null && throwable == null) {
            resultChannel.error("No response when handling response", "response, apiError and throwable were all null", null)
            return
        }

        val sdkResult = when {
            response != null -> Result<T>(data = response)
            apiError != null -> Result(error = apiError)
            else -> Result(throwable = throwable)
        }

        val json = gson.toJson(sdkResult)
        resultChannel.success(json)
    }
}