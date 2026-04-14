package com.qzimyion.braverbundles.fabric;

import com.qzimyion.braverbundles.BraverBundlesClient;
import com.qzimyion.braverbundles.common.BraverBundlesCommon;
import net.fabricmc.api.ModInitializer;

public final class BraverBundlesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        BraverBundlesCommon.init();
        BraverBundlesClient.init();
    }
}
