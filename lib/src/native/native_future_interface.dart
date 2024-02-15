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

part of '../../connect_sdk.dart';

class _NativeFutureListener<T> {
  final void Function(T data) success;
  final void Function(ApiErrorResponse apiError) apiError;
  final void Function(NativeException e) failure;

  _NativeFutureListener(
      {required this.success, required this.apiError, required this.failure});
}
