# emi-indo-cordova-plugin-fan
 Cordova Plugin  Facebook Audience Network (suppoet bidding admob)


###  Facebook Audience Network SDK (default: 6.+)
###  Facebook bidding SDK Admob (default: 6.13.7.0)
###  PLAY SERVICES VERSION Admob (default: 21.5.0)
- [How to Set Up Bidding ](https://developers.google.com/admob/android/mediation/meta?fbclid=IwAR19pu8T1R7yE1LcjU8fW_MMYmmpuMAPgbCIcRLTKTh-AKOD_Mttu4dvz38) 



> __Note__
> - ## It's Not a fork, it's purely rewritten, clean of 3rd party code.

> __Note__
> - ### No Ad-Sharing
> - ### No Remote Control
> - ### I guarantee 100% revenue for you.
> - [Code source:](https://developers.facebook.com/docs/audience-network/setting-up/ad-setup/android) - Audience Network:
  






https://user-images.githubusercontent.com/78555833/228741293-b2dab6fc-9d13-4f0e-8cd7-2b773f998b96.mp4







 ## Features

- Banner Ads
- Interstitial Ads
- Rewarded Video Ads

## Coming soon
- Rewarded Interstitial Ads
- Set banner position

## 💰Sponsor this project
  [![PayPal](https://img.shields.io/badge/PayPal-00457C?style=for-the-badge&logo=paypal&logoColor=white)](https://paypal.me/emiindo)   
  
## Installation

> __Note__
> This is bidding --variable APP_ID_ANDROID=ca-app-pub-3940256099942544~3347511713

```sh
cordova plugin add emi-indo-cordova-plugin-fan --variable APP_ID_ANDROID=ca-app-pub-3940256099942544~3347511713
```
### Or
```sh
cordova plugin add https://github.com/EMI-INDO/emi-indo-cordova-plugin-fan --variable APP_ID_ANDROID=ca-app-pub-3940256099942544~3347511713
```
## Remove
```sh
cordova plugin rm emi-indo-cordova-plugin-fan
```


## deviceready

[Example ](https://github.com/EMI-INDO/emi-indo-cordova-plugin-fan/blob/main/example/index.html) - index.html:

[How to Set Up Bidding ](https://developers.google.com/admob/android/mediation/meta?fbclid=IwAR19pu8T1R7yE1LcjU8fW_MMYmmpuMAPgbCIcRLTKTh-AKOD_Mttu4dvz38) 


```sh
// Initializing the SDK in Android
// This needs to be done only once, ideally at app launch.

/////////////////////   Initializing the SDK
cordova.plugins.emiFanPlugin.sdkInitialize();

var bannerPlacementID = "29607623xxxxxxx_xxxxxxxxxxxxx"
// Banner Size =   Standard-Banner | Large-Banner | Medium-Rectangle
var size = "Standard-Banner"

var interstitialPlacementID = "2960762xxxxxxx_34066902xxxxxxx"
var rewardedPlacementID = "6239166049xxxxxx_6239190xxxxxxx"

```
## Banner Ads

```sh

// Load a Show cordova.plugins.emiFanPlugin.showBannerAd(bannerPlacementID, size);
// Hide cordova.plugins.emiFanPlugin.hideBannerAd();

```


## Interstitial Ads

```sh

// Load cordova.plugins.emiFanPlugin.loadInterstitialAd(interstitialPlacementID);
// Show cordova.plugins.emiFanPlugin.showInterstitialAd();


```

## Rewarded Video Ads

```sh

// Load cordova.plugins.emiFanPlugin.loadRewardedVideoAd(rewardedPlacementID);
// Show cordova.plugins.emiFanPlugin.showRewardedVideoAd();

```


# Event | callback:
### event code

```sh
document.addEventListener('onBannerAdLoaded', () => {

alert("on Banner Ad Loaded");

});

```

## ( Banner Ads )

### Event Load a show

- onBannerError
- onBannerAdLoaded
- onBannerAdClicked
- onBannerLoggingImpression


## ( Interstitial Ads )

### Event Load a Show

- onInterstitialDisplayed
- onInterstitialDismissed
- onInterstitialError
- onInterstitialAdLoaded
- onInterstitialAdClicked
- onInterstitialLoggingImpression



## ( Video Ads )

### Event Load a Show


- onRewardedError
- onRewardedAdLoaded
- onRewardedAdClicked
- onRewardedLoggingImpression
- onRewardedVideoCompleted
- onRewardedVideoClosed


### Platform Support
- Android


## 💰Sponsor this project
  [![PayPal](https://img.shields.io/badge/PayPal-00457C?style=for-the-badge&logo=paypal&logoColor=white)](https://paypal.me/emiindo) 

 ## Earn more money, with other ad networks.
  - ### emi-indo-cordova-plugin-unityads
  
  [Cordova Plugin Unity:](https://github.com/EMI-INDO/emi-indo-cordova-plugin-unityads) - Ads:
  
   - ### emi-indo-cordova-plugin-admob
  
  [Admob:](https://github.com/EMI-INDO/emi-indo-cordova-plugin-admob) - Ads:




                  
                             
