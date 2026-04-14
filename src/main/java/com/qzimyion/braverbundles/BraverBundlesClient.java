package com.qzimyion.braverbundles;

import com.qzimyion.braverbundles.networking.ModNetworkHandler;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;

public class BraverBundlesClient {

    public static void init() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) ->
            ModNetworkHandler.sendToClient(handler.player));
        ModNetworkHandler.registerServer();
    }
}
