package com.net.bloomz.appium.pagefactory.framework.browser;

import javax.annotation.Nonnull;

import com.net.bloomz.appium.pagefactory.framework.pages.TopLevelPage;

public final class CachedPage {
    private final String url;
    private final TopLevelPage cachedPage;

    public CachedPage(@Nonnull String url, @Nonnull TopLevelPage cachedPage) {
        this.url = url;
        this.cachedPage = cachedPage;
    }

    public String getUrl() {
        return url;
    }

    public TopLevelPage getCachedPage() {
        return cachedPage;
    }
}
