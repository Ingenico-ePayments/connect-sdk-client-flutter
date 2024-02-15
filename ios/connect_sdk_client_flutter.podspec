#
# To learn more about a Podspec see http://guides.cocoapods.org/syntax/podspec.html.
# Run `pod lib lint connect_sdk_client_flutter.podspec` to validate before publishing.
#
Pod::Spec.new do |s|
  s.name             = 'connect_sdk_client_flutter'
  s.version          = '1.0.0'
  s.summary          = 'Connect Flutter SDK iOS Plugin'
  s.description      = <<-DESC
iOS plugin for the Connect Flutter SDK.
                       DESC
  s.homepage         = 'https://github.com/Ingenico-ePayments/connect-sdk-client-flutter'
  s.license          = { :type => "MIT", :file => "../LICENSE" }
  s.author           =  "Worldline"
  s.source           = { :path => '.' }
  s.source_files = 'Classes/**/*'
  s.dependency 'Flutter'
  s.dependency 'IngenicoConnectKit', '~> 5.13'
  s.platform = :ios, '12.0'

  # Flutter.framework does not contain a i386 slice.
  s.pod_target_xcconfig = { 'DEFINES_MODULE' => 'YES', 'EXCLUDED_ARCHS[sdk=iphonesimulator*]' => 'i386' }
  s.swift_version = '5.0'
end
