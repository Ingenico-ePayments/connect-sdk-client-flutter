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

part of 'validation_rule_terms_and_conditions.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

ValidationRuleTermsAndConditions _$ValidationRuleTermsAndConditionsFromJson(
    Map<String, dynamic> json) {
  $checkKeys(
    json,
    requiredKeys: const ['validationType', 'messageId'],
  );
  return ValidationRuleTermsAndConditions(
    $enumDecode(_$ValidationTypeEnumMap, json['validationType']),
    json['messageId'] as String,
  );
}

Map<String, dynamic> _$ValidationRuleTermsAndConditionsToJson(
        ValidationRuleTermsAndConditions instance) =>
    <String, dynamic>{
      'validationType': _$ValidationTypeEnumMap[instance.validationType]!,
      'messageId': instance.messageId,
    };

const _$ValidationTypeEnumMap = {
  ValidationType.boletoBancarioRequiredness: 'BOLETOBANCARIOREQUIREDNESS',
  ValidationType.expirationDate: 'EXPIRATIONDATE',
  ValidationType.emailAddress: 'EMAILADDRESS',
  ValidationType.fixedList: 'FIXEDLIST',
  ValidationType.iban: 'IBAN',
  ValidationType.length: 'LENGTH',
  ValidationType.luhn: 'LUHN',
  ValidationType.range: 'RANGE',
  ValidationType.regularExpression: 'REGULAREXPRESSION',
  ValidationType.residentIdNumber: 'RESIDENTIDNUMBER',
  ValidationType.required: 'REQUIRED',
  ValidationType.type: 'TYPE',
  ValidationType.termsAndConditions: 'TERMSANDCONDITIONS',
};
