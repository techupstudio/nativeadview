package com.techupstudio.nativeadview;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;

import java.util.Arrays;
import java.util.List;

/**
 * Base class for a template view. *
 */

public class NativeAdViewController {

    private final NativeAdView nativeAdView;
    private final TextView primaryView;
    private final TextView secondaryView;
    private final RatingBar ratingBar;
    private final TextView tertiaryView;
    private final TextView priceView;
    private final ImageView iconView;
    private final MediaView mediaView;
    private final Button callToActionView;
    private final View background;

    private NativeTemplateStyle styles;
    private NativeAd nativeAd;

    private View viewForNativeAdView;
    private View viewForMediaContent;
    private View viewForIcon;
    private View viewForStore;
    private View viewForStarRating;
    private View viewForAdvertiser;
    private View viewForHeadline;
    private View viewForPrice;
    private View viewForBody;
    private View viewForCta;

    public NativeAdViewController(NativeAdViewHolder nativeAdViewHolder) {
        this.nativeAdView = nativeAdViewHolder.getNativeAdView();
        this.primaryView = nativeAdViewHolder.getPrimaryView();
        this.secondaryView = nativeAdViewHolder.getSecondaryView();
        this.priceView = nativeAdViewHolder.getPriceView();
        this.ratingBar = nativeAdViewHolder.getRatingBar();
        this.ratingBar.setEnabled(false);
        this.tertiaryView = nativeAdViewHolder.getTertiaryView();
        this.iconView = nativeAdViewHolder.getIconView();
        this.mediaView = nativeAdViewHolder.getMediaView();
        this.callToActionView = nativeAdViewHolder.getCallToActionView();
        this.background = nativeAdViewHolder.getBackground();
    }

    public void setStyles(NativeTemplateStyle styles) {
        this.styles = styles;
        this.applyStyles();
    }

    public View getNativeAdView() {
        return viewForNativeAdView;
    }

    public View getViewForMediaContent() {
        return viewForMediaContent;
    }

    public View getViewForIcon() {
        return viewForIcon;
    }

    public View getViewForStore() {
        return viewForStore;
    }

    public View getViewForStarRating() {
        return viewForStarRating;
    }

    public View getViewForAdvertiser() {
        return viewForAdvertiser;
    }

    public View getViewForHeadline() {
        return viewForHeadline;
    }

    public View getViewForPrice() {
        return viewForPrice;
    }

    public View getViewForBody() {
        return viewForBody;
    }

    public View getViewForCta() {
        return viewForCta;
    }

    public void setNativeAd(NativeAd nativeAd) {

        if (nativeAd == null)
            return;
        this.nativeAd = nativeAd;

        List<View> controlViews = Arrays.asList(
                viewForNativeAdView, viewForMediaContent,
                viewForIcon, viewForStore,
                viewForAdvertiser, viewForHeadline,
                viewForPrice, viewForBody,
                viewForStarRating, viewForCta
        );

        View[] nativeAdViewViews = new View[]{nativeAdView};
        View[] mediaViews = new View[]{mediaView};
        View[] headlineViews = new View[]{primaryView, secondaryView, tertiaryView};
        View[] bodyViews = new View[]{primaryView, secondaryView, tertiaryView};
        View[] advertiserViews = new View[]{tertiaryView, secondaryView, primaryView};
        View[] storeViews = new View[]{tertiaryView, secondaryView, primaryView};
        View[] priceViews = new View[]{priceView, tertiaryView, secondaryView, primaryView};
        View[] ctaViews = new View[]{callToActionView, primaryView, secondaryView, tertiaryView};
        View[] starRatingViews = new View[]{ratingBar};
        View[] iconViews = new View[]{iconView};

        viewForNativeAdView = getUnusedView(controlViews, nativeAdViewViews);
        if (viewForNativeAdView != null) {
            viewForNativeAdView.setVisibility(View.VISIBLE);
            ((NativeAdView) viewForNativeAdView).setNativeAd(nativeAd);
        } else {
            throw new NullPointerException("NativeAdView must be set in the NativeAdViewHolder");
        }

        if ((viewForMediaContent = getUnusedView(controlViews, mediaViews)) != null) {
            if (nativeAd.getMediaContent() == null) {
                viewForMediaContent.setVisibility(View.GONE);
                viewForMediaContent = null;
            } else {
                viewForMediaContent.setVisibility(View.VISIBLE);
                ((MediaView) viewForMediaContent).setMediaContent(nativeAd.getMediaContent());
                nativeAdView.setMediaView((MediaView) viewForMediaContent);
            }
        }

        if ((viewForHeadline = getUnusedView(controlViews, headlineViews)) != null) {
            if (nativeAd.getHeadline() == null) {
                viewForHeadline.setVisibility(View.GONE);
                viewForHeadline = null;
            } else {
                viewForHeadline.setVisibility(View.VISIBLE);
                ((TextView) viewForHeadline).setText(nativeAd.getHeadline());
                nativeAdView.setHeadlineView(viewForHeadline);
            }
        }

        if ((viewForBody = getUnusedView(controlViews, bodyViews)) != null) {
            if (nativeAd.getBody() == null) {
                viewForBody.setVisibility(View.GONE);
                viewForBody = null;
            } else {
                viewForBody.setVisibility(View.VISIBLE);
                ((TextView) viewForBody).setText(nativeAd.getBody());
                nativeAdView.setBodyView(viewForBody);
            }
        }

        if ((viewForAdvertiser = getUnusedView(controlViews, advertiserViews)) != null) {
            if (nativeAd.getAdvertiser() == null) {
                viewForAdvertiser.setVisibility(View.GONE);
                viewForAdvertiser = null;
            } else {
                viewForAdvertiser.setVisibility(View.VISIBLE);
                ((TextView) viewForAdvertiser).setText(nativeAd.getAdvertiser());
                nativeAdView.setAdvertiserView(viewForAdvertiser);
            }
        }

        if ((viewForStore = getUnusedView(controlViews, storeViews)) != null) {
            if (nativeAd.getStore() == null) {
                viewForStore.setVisibility(View.GONE);
                viewForStore = null;
            } else {
                viewForStore.setVisibility(View.VISIBLE);
                ((TextView) viewForStore).setText(nativeAd.getStore());
                nativeAdView.setStoreView(viewForStore);
            }
        }

        if ((viewForPrice = getUnusedView(controlViews, priceViews)) != null) {
            if (nativeAd.getPrice() == null) {
                viewForPrice.setVisibility(View.GONE);
                viewForPrice = null;
            } else {
                viewForPrice.setVisibility(View.VISIBLE);
                ((TextView) viewForPrice).setText(nativeAd.getPrice());
                nativeAdView.setPriceView(viewForPrice);
            }
        }

        if ((viewForCta = getUnusedView(controlViews, ctaViews)) != null) {
            if (nativeAd.getAdvertiser() != null) {
                viewForCta.setVisibility(View.GONE);
                viewForCta = null;
            } else {
                viewForCta.setVisibility(View.VISIBLE);
                ((TextView) viewForCta).setText(nativeAd.getCallToAction());
                nativeAdView.setCallToActionView(viewForCta);
            }
        }

        if ((viewForStarRating = getUnusedView(controlViews, starRatingViews)) != null) {
            if (nativeAd.getStarRating() != null && nativeAd.getStarRating().floatValue() <= 0) {
                viewForStarRating.setVisibility(View.GONE);
                viewForStarRating = null;
            } else {
                viewForStarRating.setVisibility(View.VISIBLE);
                ((RatingBar) viewForStarRating).setRating(nativeAd.getStarRating().floatValue());
                nativeAdView.setStarRatingView(viewForStarRating);
            }
        }

        if ((viewForIcon = getUnusedView(controlViews, iconViews)) != null) {
            if (nativeAd.getIcon() == null) {
                viewForIcon.setVisibility(View.GONE);
                viewForIcon = null;
            } else {
                viewForIcon.setVisibility(View.VISIBLE);
                ((ImageView) viewForIcon).setImageDrawable(nativeAd.getIcon().getDrawable());
                nativeAdView.setIconView(viewForIcon);
            }
        }

        nativeAdView.setNativeAd(nativeAd);
    }

    private View getUnusedView(List<View> controlViews, View[] viewChoices) {
        for (View view : viewChoices) {
            if (view != null) {
                if (!controlViews.contains(view)) {
                    return view;
                }
            }
        }
        return null;
    }

    private void applyStyles() {

        Drawable mainBackground = styles.getMainBackgroundColor();
        if (mainBackground != null) {
            background.setBackground(mainBackground);
            if (primaryView != null) {
                primaryView.setBackground(mainBackground);
            }
            if (secondaryView != null) {
                secondaryView.setBackground(mainBackground);
            }
            if (tertiaryView != null) {
                tertiaryView.setBackground(mainBackground);
            }
        }

        Typeface primary = styles.getPrimaryTextTypeface();
        if (primary != null && primaryView != null) {
            primaryView.setTypeface(primary);
        }

        Typeface secondary = styles.getSecondaryTextTypeface();
        if (secondary != null && secondaryView != null) {
            secondaryView.setTypeface(secondary);
        }

        Typeface tertiary = styles.getTertiaryTextTypeface();
        if (tertiary != null && tertiaryView != null) {
            tertiaryView.setTypeface(tertiary);
        }

        Typeface ctaTypeface = styles.getCallToActionTextTypeface();
        if (ctaTypeface != null && callToActionView != null) {
            callToActionView.setTypeface(ctaTypeface);
        }

        int primaryTypefaceColor = styles.getPrimaryTextTypefaceColor();
        if (primaryTypefaceColor > 0 && primaryView != null) {
            primaryView.setTextColor(primaryTypefaceColor);
        }

        int secondaryTypefaceColor = styles.getSecondaryTextTypefaceColor();
        if (secondaryTypefaceColor > 0 && secondaryView != null) {
            secondaryView.setTextColor(secondaryTypefaceColor);
        }

        int tertiaryTypefaceColor = styles.getTertiaryTextTypefaceColor();
        if (tertiaryTypefaceColor > 0 && tertiaryView != null) {
            tertiaryView.setTextColor(tertiaryTypefaceColor);
        }

        int ctaTypefaceColor = styles.getCallToActionTypefaceColor();
        if (ctaTypefaceColor > 0 && callToActionView != null) {
            callToActionView.setTextColor(ctaTypefaceColor);
        }

        float ctaTextSize = styles.getCallToActionTextSize();
        if (ctaTextSize > 0 && callToActionView != null) {
            callToActionView.setTextSize(ctaTextSize);
        }

        float primaryTextSize = styles.getPrimaryTextSize();
        if (primaryTextSize > 0 && primaryView != null) {
            primaryView.setTextSize(primaryTextSize);
        }

        float secondaryTextSize = styles.getSecondaryTextSize();
        if (secondaryTextSize > 0 && secondaryView != null) {
            secondaryView.setTextSize(secondaryTextSize);
        }

        float tertiaryTextSize = styles.getTertiaryTextSize();
        if (tertiaryTextSize > 0 && tertiaryView != null) {
            tertiaryView.setTextSize(tertiaryTextSize);
        }

        Drawable ctaBackground = styles.getCallToActionBackgroundColor();
        if (ctaBackground != null && callToActionView != null) {
            callToActionView.setBackground(ctaBackground);
        }

        Drawable primaryBackground = styles.getPrimaryTextBackgroundColor();
        if (primaryBackground != null && primaryView != null) {
            primaryView.setBackground(primaryBackground);
        }

        Drawable secondaryBackground = styles.getSecondaryTextBackgroundColor();
        if (secondaryBackground != null && secondaryView != null) {
            secondaryView.setBackground(secondaryBackground);
        }

        Drawable tertiaryBackground = styles.getTertiaryTextBackgroundColor();
        if (tertiaryBackground != null && tertiaryView != null) {
            tertiaryView.setBackground(tertiaryBackground);
        }
    }


    /**
     * To prevent memory leaks, make sure to destroy your ad when you don't need it anymore. This
     * method does not destroy the template view.
     * https://developers.google.com/admob/android/native-unified#destroy_ad
     */
    public void destroyNativeAd() {
        nativeAd.destroy();
    }

}
