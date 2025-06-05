package org.justc2t.tpsPlaceholder;

import io.canvasmc.canvas.ThreadedBukkitServer;
import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.minecraft.server.MinecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;

public class tpsRequest extends PlaceholderExpansion {

    private TpsPlaceholder main;
    private MinecraftServer minecraftServer = MinecraftServer.getServer();
    public tpsRequest(TpsPlaceholder main){
        this.main = main;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "canvasmc";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Just_c2t";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {
        World world = player.getWorld();
        Chunk chunk = player.getLocation().getChunk();

        switch(params){
            case "tps_5s" -> {
                return String.valueOf(ThreadedBukkitServer.getInstance().getRegionAtChunk(world, chunk.getX(), chunk.getZ()).getTickHandle().getTps5s().getAverage());
            }case "tps_10s" -> {
                return String.valueOf(ThreadedBukkitServer.getInstance().getRegionAtChunk(world, chunk.getX(), chunk.getZ()).getTickHandle().getTps10s().getAverage());
            }case "tps_15s" -> {
                return String.valueOf(ThreadedBukkitServer.getInstance().getRegionAtChunk(world, chunk.getX(), chunk.getZ()).getTickHandle().getTps15s().getAverage());
            }case "tps_1m" -> {
                return String.valueOf(ThreadedBukkitServer.getInstance().getRegionAtChunk(world, chunk.getX(), chunk.getZ()).getTickHandle().getTps1m().getAverage());
            }
            case "mstp_5s" -> {
                return String.valueOf(ThreadedBukkitServer.getInstance().getRegionAtChunk(world, chunk.getX(), chunk.getZ()).getTickHandle().getTickTimes5s().getAverage());
            }
            case "mstp_10s" -> {
                return String.valueOf(ThreadedBukkitServer.getInstance().getRegionAtChunk(world, chunk.getX(), chunk.getZ()).getTickHandle().getTickTimes10s().getAverage());
            }
            case "mstp_15s" -> {
                return String.valueOf(ThreadedBukkitServer.getInstance().getRegionAtChunk(world, chunk.getX(), chunk.getZ()).getTickHandle().getTickTimes15s().getAverage());
            }
            case "mstp_1m" -> {
                return String.valueOf(ThreadedBukkitServer.getInstance().getRegionAtChunk(world, chunk.getX(), chunk.getZ()).getTickHandle().getTickTimes60s().getAverage());
            }
            default -> {
                return null;
            }
        }

    }

}
