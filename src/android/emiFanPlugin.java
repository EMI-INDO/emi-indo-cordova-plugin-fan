package emi.indo.cordova.plugin.fan;import android.view.View;import android.view.ViewGroup;import android.widget.RelativeLayout;import com.facebook.ads.Ad;import com.facebook.ads.AdError;import com.facebook.ads.AdListener;import com.facebook.ads.AdSettings;import com.facebook.ads.AdSize;import com.facebook.ads.AdView;import com.facebook.ads.AudienceNetworkAds;import com.facebook.ads.BuildConfig;import com.facebook.ads.InterstitialAd;import com.facebook.ads.InterstitialAdListener;import com.facebook.ads.RewardedVideoAd;import com.facebook.ads.RewardedVideoAdListener;import org.apache.cordova.CordovaInterface;import org.apache.cordova.CordovaPlugin;import org.apache.cordova.CallbackContext;import org.apache.cordova.CordovaWebView;import org.json.JSONArray;import org.json.JSONException;import java.util.Objects;public class emiFanPlugin extends CordovaPlugin{private static final String TAG="emiFanPlugin";private CordovaWebView cWebView;private InterstitialAd interstitialAd;private RewardedVideoAd rewardedVideoAd;private RelativeLayout bannerViewLayout;private AdView bannerView;static boolean _isBannerShowing=false;public void initialize(CordovaInterface cordova,CordovaWebView webView){super.initialize(cordova,webView);cWebView=webView;}public boolean execute(String action,JSONArray args,final CallbackContext callbackContext)throws JSONException{switch(action){case "sdkInitialize":cordova.getActivity().runOnUiThread(()->{AudienceNetworkAds.initialize(cordova.getActivity());});return true;case "showBannerAd":cordova.getActivity().runOnUiThread(()->{final String bannerPlacementID=args.optString(0);final String size=args.optString(1);if(!_isBannerShowing){_isBannerShowing=true;if(bannerViewLayout==null){bannerViewLayout=new RelativeLayout(cordova.getActivity());RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);bannerViewLayout.setLayoutParams(params);((ViewGroup)Objects.requireNonNull(cWebView.getView())).addView(bannerViewLayout);}bannerView=new AdView(cordova.getActivity(),bannerPlacementID,getBannerAdSize(size));AdListener adListener=new AdListener(){@Override public void onError(Ad ad,AdError adError){cWebView.loadUrl("javascript:cordova.fireDocumentEvent('onBannerError');");}@Override public void onAdLoaded(Ad ad){cWebView.loadUrl("javascript:cordova.fireDocumentEvent('onBannerAdLoaded');");}@Override public void onAdClicked(Ad ad){cWebView.loadUrl("javascript:cordova.fireDocumentEvent('onBannerAdClicked');");}@Override public void onLoggingImpression(Ad ad){cWebView.loadUrl("javascript:cordova.fireDocumentEvent('onBannerLoggingImpression');");}};bannerView.loadAd(bannerView.buildLoadAdConfig().withAdListener(adListener).build());RelativeLayout.LayoutParams bannerParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);bannerParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);bannerParams.addRule(RelativeLayout.CENTER_HORIZONTAL);bannerView.setLayoutParams(bannerParams);bannerViewLayout.addView(bannerView);}});return true;case "hideBannerAd":cordova.getActivity().runOnUiThread(()->{if(_isBannerShowing){if(bannerView!=null){bannerView.destroy();bannerView=null;_isBannerShowing=false;}}});return true;case "loadInterstitialAd":cordova.getActivity().runOnUiThread(()->{final String interstitialPlacementID=args.optString(0);interstitialAd=new InterstitialAd(cordova.getActivity(),interstitialPlacementID);InterstitialAdListener interstitialAdListener=new InterstitialAdListener(){@Override public void onInterstitialDisplayed(Ad ad){cWebView.loadUrl("javascript:cordova.fireDocumentEvent('onInterstitialDisplayed');");}@Override public void onInterstitialDismissed(Ad ad){cWebView.loadUrl("javascript:cordova.fireDocumentEvent('onInterstitialDismissed');");}@Override public void onError(Ad ad,AdError adError){cWebView.loadUrl("javascript:cordova.fireDocumentEvent('onInterstitialError');");}@Override public void onAdLoaded(Ad ad){cWebView.loadUrl("javascript:cordova.fireDocumentEvent('onInterstitialAdLoaded');");}@Override public void onAdClicked(Ad ad){cWebView.loadUrl("javascript:cordova.fireDocumentEvent('onInterstitialAdClicked');");}@Override public void onLoggingImpression(Ad ad){cWebView.loadUrl("javascript:cordova.fireDocumentEvent('onInterstitialLoggingImpression');");}};interstitialAd.loadAd(interstitialAd.buildLoadAdConfig().withAdListener(interstitialAdListener).build());});return true;case "showInterstitialAd":cordova.getActivity().runOnUiThread(()->{if(interstitialAd==null||!interstitialAd.isAdLoaded()){return;}if(interstitialAd.isAdInvalidated()){return;}interstitialAd.show();});return true;case "loadRewardedVideoAd":cordova.getActivity().runOnUiThread(()->{final String rewardedPlacementID=args.optString(0);rewardedVideoAd=new RewardedVideoAd(cordova.getActivity(),rewardedPlacementID);RewardedVideoAdListener rewardedVideoAdListener=new RewardedVideoAdListener(){@Override public void onError(Ad ad,AdError error){cWebView.loadUrl("javascript:cordova.fireDocumentEvent('onRewardedError');");}@Override public void onAdLoaded(Ad ad){cWebView.loadUrl("javascript:cordova.fireDocumentEvent('onRewardedAdLoaded');");}@Override public void onAdClicked(Ad ad){cWebView.loadUrl("javascript:cordova.fireDocumentEvent('onRewardedAdClicked');");}@Override public void onLoggingImpression(Ad ad){cWebView.loadUrl("javascript:cordova.fireDocumentEvent('onRewardedLoggingImpression');");}@Override public void onRewardedVideoCompleted(){cWebView.loadUrl("javascript:cordova.fireDocumentEvent('onRewardedVideoCompleted');");}@Override public void onRewardedVideoClosed(){cWebView.loadUrl("javascript:cordova.fireDocumentEvent('onRewardedVideoClosed');");}};rewardedVideoAd.loadAd(rewardedVideoAd.buildLoadAdConfig().withAdListener(rewardedVideoAdListener).build());});return true;case "showRewardedVideoAd":cordova.getActivity().runOnUiThread(()->{if(rewardedVideoAd==null||!rewardedVideoAd.isAdLoaded()){return;}if(rewardedVideoAd.isAdInvalidated()){return;}rewardedVideoAd.show();});return true;}return false;}public AdSize getBannerAdSize(String size){AdSize sz;if(Objects.equals(size,"Standard-Banner")){sz=AdSize.BANNER_HEIGHT_50;}else if(Objects.equals(size,"Large-Banner")){sz=AdSize.BANNER_HEIGHT_90;}else if(Objects.equals(size,"Medium-Rectangle")){sz=AdSize.RECTANGLE_HEIGHT_250;}else{sz=AdSize.BANNER_HEIGHT_50;}return sz;}@Override public void onDestroy(){if(bannerView!=null){bannerView.destroy();}if(interstitialAd!=null){interstitialAd.destroy();}if(rewardedVideoAd!=null){rewardedVideoAd.destroy();rewardedVideoAd=null;}super.onDestroy();}}