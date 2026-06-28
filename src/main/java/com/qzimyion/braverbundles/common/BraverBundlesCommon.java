package com.qzimyion.braverbundles.common;

import com.qzimyion.braverbundles.BraverBundlesConstants;
import com.qzimyion.braverbundles.CommonModConfig;
import eu.midnightdust.lib.config.MidnightConfig;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.DispenserBlock;

public final class BraverBundlesCommon {

    public static void init() {
        MidnightConfig.init(BraverBundlesConstants.MOD_ID, CommonModConfig.class);
        DispenserBlock.registerBehavior(Items.BUNDLE, new BundleDispenserBehavior());
        Items.DYED_BUNDLE.forEach(bundle -> DispenserBlock.registerBehavior(bundle, new BundleDispenserBehavior()));
    }
}
