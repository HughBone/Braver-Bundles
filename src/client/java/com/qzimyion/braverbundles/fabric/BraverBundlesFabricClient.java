package com.qzimyion.braverbundles.fabric;

import com.qzimyion.braverbundles.networking.ConfigPackets;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class BraverBundlesFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(
            ConfigPackets.TYPE,
            (payload, context) -> payload.applyOnClient()
        );
    }
}
