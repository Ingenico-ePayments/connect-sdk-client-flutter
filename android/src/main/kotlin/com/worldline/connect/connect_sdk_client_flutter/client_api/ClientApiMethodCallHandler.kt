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

package com.worldline.connect.connect_sdk_client_flutter.client_api

import android.content.Context
import com.google.gson.Gson
import com.worldline.connect.connect_sdk_client_flutter.client_api.models.ConvertAmountRequest
import com.worldline.connect.connect_sdk_client_flutter.client_api.models.IinDetailsRequest
import com.worldline.connect.connect_sdk_client_flutter.client_api.models.PaymentProductDirectoryRequest
import com.worldline.connect.connect_sdk_client_flutter.client_api.models.PaymentProductGroupRequest
import com.worldline.connect.connect_sdk_client_flutter.client_api.models.PaymentProductRequest
import com.worldline.connect.connect_sdk_client_flutter.client_api.models.ResultError
import com.worldline.connect.connect_sdk_client_flutter.client_api.models.ThirdPartyStatusRequest
import com.worldline.connect.connect_sdk_client_flutter.connect_sdk.ConnectSDKBridge
import com.worldline.connect.connect_sdk_client_flutter.getRequestOrReturnError
import java.lang.ref.WeakReference
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler

class ClientApiMethodCallHandler(private val gson: Gson)
    : MethodChannel.MethodCallHandler {
    companion object {
        private const val TAG = "ApiCallMethodHandler"
    }

    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        when (call.method) {
            "getPublicKey" -> getPublicKey(result)
            "getBasicPaymentProducts" -> getBasicPaymentProducts(result)
            "getPaymentProduct" -> getPaymentProduct(call, result)
            "getIinDetails" -> getIinDetails(call, result)
            "getBasicPaymentProductGroups" -> getBasicPaymentProductGroups(result)
            "getPaymentProductGroup" -> getPaymentProductGroup(call, result)
            "getPaymentItems" -> getPaymentItems(result)
            "getPaymentProductDirectory" -> getPaymentProductDirectory(call, result)
            "getThirdPartyStatus" -> getThirdPartyStatus(call, result)
            "convertAmount" -> convertAmount(call, result)
            else -> result.notImplemented()
        }
    }

    private fun callSdkIfInitialized(result: MethodChannel.Result, runWhenInitialized: () -> Unit) {
        if (ConnectSDKBridge.isInitialized()) {
            runWhenInitialized()
        } else {
            return ResultError.sdkNotInitialized(result)
        }
    }

    private fun getPublicKey(result: MethodChannel.Result) {
        callSdkIfInitialized(result) {
            ConnectSDKBridge.getPublicKey(result)
        }
    }

    private fun getBasicPaymentProducts(result: MethodChannel.Result) {
        callSdkIfInitialized(result) {
            ConnectSDKBridge.getBasicPaymentProducts(result)
        }
    }

    private fun getPaymentProduct(call: MethodCall, result: MethodChannel.Result) {
        val request = call.getRequestOrReturnError(PaymentProductRequest::class.java, result, gson)
        request ?: return
        callSdkIfInitialized(result) {
            ConnectSDKBridge.getPaymentProduct(result, request)
        }
    }

    private fun getIinDetails(call: MethodCall, result: MethodChannel.Result) {
        val request = call.getRequestOrReturnError(IinDetailsRequest::class.java, result, gson)
        request ?: return
        callSdkIfInitialized(result) {
            ConnectSDKBridge.getIinDetails(result, request)
        }
    }

    private fun getBasicPaymentProductGroups(result: MethodChannel.Result) {
        callSdkIfInitialized(result) {
            ConnectSDKBridge.getPaymentProductGroups(result)
        }
    }

    private fun getPaymentProductGroup(call: MethodCall, result: MethodChannel.Result) {
        val request = call.getRequestOrReturnError(PaymentProductGroupRequest::class.java, result, gson)
        request ?: return
        callSdkIfInitialized(result) {
            ConnectSDKBridge.getPaymentProductGroup(result, request)
        }
    }

    private fun getPaymentItems(result: MethodChannel.Result) {
        callSdkIfInitialized(result) {
            ConnectSDKBridge.getPaymentItems(result)
        }
    }

    private fun getPaymentProductDirectory(call: MethodCall, result: MethodChannel.Result) {
        val request = call.getRequestOrReturnError(PaymentProductDirectoryRequest::class.java, result, gson)
        request ?: return
        callSdkIfInitialized(result) {
            ConnectSDKBridge.getPaymentProductDirectory(result, request)
        }
    }

    private fun getThirdPartyStatus(call: MethodCall, result: MethodChannel.Result) {
        val request = call.getRequestOrReturnError(ThirdPartyStatusRequest::class.java, result, gson)
        request ?: return
        callSdkIfInitialized(result) {
            ConnectSDKBridge.getThirdPartyStatus(result, request)
        }
    }

    private fun convertAmount(call: MethodCall, result: MethodChannel.Result) {
        val request = call.getRequestOrReturnError(ConvertAmountRequest::class.java, result, gson)
        request ?: return
        callSdkIfInitialized(result) {
            ConnectSDKBridge.convertAmount(result, request)
        }
    }
}