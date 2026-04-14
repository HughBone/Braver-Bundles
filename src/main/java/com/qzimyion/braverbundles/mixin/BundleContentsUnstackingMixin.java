package com.qzimyion.braverbundles.mixin;

import com.mojang.serialization.DataResult;
import com.qzimyion.braverbundles.CommonModConfig;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.component.BundleContents;
import org.apache.commons.lang3.math.Fraction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BundleContents.class)
public class BundleContentsUnstackingMixin {

	@Inject(method = "getWeight", at = @At("TAIL"), cancellable = true)
	private static void getWeight(ItemInstance itemInstance, CallbackInfoReturnable<DataResult<Fraction>> info) {
		if (itemInstance.getMaxStackSize() == 1) {
			info.setReturnValue(DataResult.success(Fraction.getFraction(CommonModConfig.UNSTACKING_FRACTIONS)));
		}
	}
}
