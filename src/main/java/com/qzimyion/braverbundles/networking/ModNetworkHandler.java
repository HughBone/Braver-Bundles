package com.qzimyion.braverbundles.networking;

import com.qzimyion.braverbundles.CommonModConfig;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.level.ServerPlayer;

public class ModNetworkHandler {

    public static void registerServer() {
        PayloadTypeRegistry.clientboundPlay().register(ConfigPackets.TYPE, ConfigPackets.STREAM_CODEC);
    }

    public static void sendToClient(ServerPlayer player) {
        ServerPlayNetworking.send(player, new ConfigPackets(CommonModConfig.UNSTACKING_FRACTIONS));
    }
}
