var exec = require('cordova/exec');

exports.sdkInitialize = function (arg0, success, error) {
    exec(success, error, 'emiFanPlugin', 'sdkInitialize', [arg0]);
};

exports.hideBannerAd = function (arg0, success, error) {
    exec(success, error, 'emiFanPlugin', 'hideBannerAd', [arg0]);
};

exports.showBannerAd = function (bannerPlacementID, size, success, error) {
    exec(success, error, 'emiFanPlugin', 'showBannerAd', [bannerPlacementID, size]);
};

exports.loadInterstitialAd = function (arg0, success, error) {
    exec(success, error, 'emiFanPlugin', 'loadInterstitialAd', [arg0]);
};

exports.showInterstitialAd = function (arg0, success, error) {
    exec(success, error, 'emiFanPlugin', 'showInterstitialAd', [arg0]);
};

exports.loadRewardedVideoAd = function (arg0, success, error) {
    exec(success, error, 'emiFanPlugin', 'loadRewardedVideoAd', [arg0]);
};

exports.showRewardedVideoAd = function (arg0, success, error) {
    exec(success, error, 'emiFanPlugin', 'showRewardedVideoAd', [arg0]);
};
