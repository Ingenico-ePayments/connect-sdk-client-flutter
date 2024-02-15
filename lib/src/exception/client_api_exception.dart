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

/// Exception that gets thrown when trying to access the [ClientApi] before initialization of the [ConnectSDK].
class ClientApiException implements Exception {
  String cause =
      "Initialise the ConnectSDK first before you use the ClientApi class.";
}
