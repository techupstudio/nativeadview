// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.techupstudio.nativeadview;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAdView;

/**
 * A class containing the optional styling options for the Native Template. *
 */
public class NativeAdViewHolder {
    private NativeAdView nativeAdView;
    private TextView primaryView;
    private TextView secondaryView;
    private TextView tertiaryView;
    private TextView priceView;
    private RatingBar ratingBar;
    private Button callToActionView;
    private ImageView iconView;
    private MediaView mediaView;
    private View background;

    public NativeAdViewHolder(TemplateView templateView) {
        this.nativeAdView = templateView.getNativeAdView();
        this.primaryView = templateView.getPrimaryView();
        this.secondaryView = templateView.getSecondaryView();
        this.tertiaryView = templateView.getTertiaryView();
        this.ratingBar = templateView.getRatingBar();
        this.callToActionView = templateView.getCallToActionView();
        this.iconView = templateView.getIconView();
        this.mediaView = templateView.getMediaView();
        this.background = templateView.getBackgroundView();
    }

    public NativeAdViewHolder() {
        //nothing here
    }

    public NativeAdView getNativeAdView() {
        return nativeAdView;
    }

    public void setNativeAdView(@NonNull NativeAdView nativeAdView) {
        this.nativeAdView = nativeAdView;
    }

    public TextView getPrimaryView() {
        return primaryView;
    }

    public void setPrimaryView(@NonNull TextView primaryView) {
        this.primaryView = primaryView;
    }

    public TextView getSecondaryView() {
        return secondaryView;
    }

    public void setSecondaryView(@NonNull TextView secondaryView) {
        this.secondaryView = secondaryView;
    }

    public TextView getTertiaryView() {
        return tertiaryView;
    }

    public void setTertiaryView(@NonNull TextView tertiaryView) {
        this.tertiaryView = tertiaryView;
    }

    public TextView getPriceView() {
        return priceView;
    }

    public void setPriceView(@NonNull TextView priceView) {
        this.priceView = priceView;
    }

    public RatingBar getRatingBar() {
        return ratingBar;
    }

    public void setRatingBar(@NonNull RatingBar ratingBar) {
        this.ratingBar = ratingBar;
    }

    public Button getCallToActionView() {
        return callToActionView;
    }

    public void setCallToActionView(@NonNull Button callToActionView) {
        this.callToActionView = callToActionView;
    }

    public ImageView getIconView() {
        return iconView;
    }

    public void setIconView(@NonNull ImageView iconView) {
        this.iconView = iconView;
    }

    public MediaView getMediaView() {
        return mediaView;
    }

    public void setMediaView(@NonNull MediaView mediaView) {
        this.mediaView = mediaView;
    }

    public View getBackground() {
        return background;
    }

    public void setBackground(@NonNull View background) {
        this.background = background;
    }

    /**
     * A class that provides helper methods to build a style object. *
     */
    public static class Builder {

        private final NativeAdViewHolder holder;

        public Builder() {
            this.holder = new NativeAdViewHolder();
        }

        public Builder setNativeAdView(NativeAdView nativeAdView) {
            holder.nativeAdView = nativeAdView;
            return this;
        }

        public Builder setPrimaryView(TextView primaryView) {
            holder.primaryView = primaryView;
            return this;
        }

        public Builder setSecondaryView(TextView secondaryView) {
            holder.secondaryView = secondaryView;
            return this;
        }

        public Builder setTertiaryView(TextView tertiaryView) {
            holder.primaryView = tertiaryView;
            return this;
        }

        public Builder setPriceView(TextView priceView) {
            holder.priceView = priceView;
            return this;
        }

        public Builder setRatingBar(RatingBar ratingBar) {
            holder.ratingBar = ratingBar;
            return this;
        }

        public Builder setCallToActionView(Button callToActionView) {
            holder.callToActionView = callToActionView;
            return this;
        }

        public Builder setIconView(ImageView iconView) {
            holder.iconView = iconView;
            return this;
        }

        public Builder setMediaView(MediaView mediaView) {
            holder.mediaView = mediaView;
            return this;
        }

        public Builder setBackground(View background) {
            holder.background = background;
            return this;
        }

        public NativeAdViewHolder build() {
            return holder;
        }
    }
}
