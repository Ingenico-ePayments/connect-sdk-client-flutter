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

// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'encrypted_payment_request.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

EncryptedPaymentRequest _$EncryptedPaymentRequestFromJson(
    Map<String, dynamic> json) {
  $checkKeys(
    json,
    requiredKeys: const ['encryptedFields', 'encodedClientMetaInfo'],
  );
  return EncryptedPaymentRequest(
    json['encryptedFields'] as String,
    json['encodedClientMetaInfo'] as String,
  );
}

Map<String, dynamic> _$EncryptedPaymentRequestToJson(
        EncryptedPaymentRequest instance) =>
    <String, dynamic>{
      'encryptedFields': instance.encryptedFields,
      'encodedClientMetaInfo': instance.encodedClientMetaInfo,
    };
