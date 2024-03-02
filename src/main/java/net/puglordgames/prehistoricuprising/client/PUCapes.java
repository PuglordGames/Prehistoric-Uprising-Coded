package net.puglordgames.prehistoricuprising.client;

import net.puglordgames.prehistoricuprising.PrehistoricUprising;
import com.google.common.collect.ImmutableSet;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

@Mod.EventBusSubscriber(modid = PrehistoricUprising.MOD_ID)
public class PUCapes {

    private static final ImmutableSet<String> DEV_UUID = ImmutableSet.of(
            "380df991-f603-344c-a090-369bad2a924a", // Dev (testing environment player)
            "d656f692-54a6-4fa7-94b2-f042847878be", // BartekNieznany.gif
            "2696f0bf-b4c4-4cfc-bc46-1720de288660"); // PuglordGames
    private static final Set<String> done = Collections.newSetFromMap(new WeakHashMap<>());

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onRenderPlayer(RenderPlayerEvent.Post event) {
        Player player = event.getEntity();
        String uuid = player.getUUID().toString();
        if(player instanceof AbstractClientPlayer clientPlayer && DEV_UUID.contains(uuid) && !done.contains(uuid)) {
            if(clientPlayer.isCapeLoaded()) {
                PlayerInfo info = clientPlayer.playerInfo;
                Map<MinecraftProfileTexture.Type, ResourceLocation> textures = info.textureLocations;
                ResourceLocation loc = new ResourceLocation("prehistoricuprising", "textures/capes/dev_cape.png");
                textures.put(MinecraftProfileTexture.Type.CAPE, loc);
                textures.put(MinecraftProfileTexture.Type.ELYTRA, loc);
                done.add(uuid);
            }
        }
    }
}
