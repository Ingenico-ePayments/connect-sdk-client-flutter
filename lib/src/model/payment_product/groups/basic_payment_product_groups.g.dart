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

part of 'basic_payment_product_groups.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

BasicPaymentProductGroups _$BasicPaymentProductGroupsFromJson(
        Map<String, dynamic> json) =>
    BasicPaymentProductGroups(
      (json['paymentProductGroups'] as List<dynamic>)
          .map((e) =>
              BasicPaymentProductGroup.fromJson(e as Map<String, dynamic>))
          .toList(),
    );

Map<String, dynamic> _$BasicPaymentProductGroupsToJson(
        BasicPaymentProductGroups instance) =>
    <String, dynamic>{
      'paymentProductGroups': instance.basicPaymentProductGroups,
    };
