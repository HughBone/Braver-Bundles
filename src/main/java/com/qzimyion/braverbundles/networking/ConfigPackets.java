package com.qzimyion.braverbundles.networking;

import com.qzimyion.braverbundles.BraverBundlesConstants;
import com.qzimyion.braverbundles.CommonModConfig;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record ConfigPackets(double fraction) implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<ConfigPackets> TYPE =
        new CustomPacketPayload.Type<>(BraverBundlesConstants.id("config_sync"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ConfigPackets> STREAM_CODEC =
        StreamCodec.of(
            (buf, packet) -> buf.writeDouble(packet.fraction()),
            buf -> new ConfigPackets(buf.readDouble())
        );

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public void applyOnClient() {
        CommonModConfig.UNSTACKING_FRACTIONS = fraction;
    }
}
