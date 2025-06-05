package org.justc2t.tpsPlaceholder;

import io.canvasmc.canvas.ThreadedBukkitServer;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class canvasmccommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            World world = player.getWorld();
            Chunk chunk = player.getLocation().getChunk();
            if (args[0].equalsIgnoreCase("tps")) {
                String arg = args[1];
                switch (arg) {

                    case "5s" -> {
                        player.sendMessage("TPS over " + arg + " is " + String.valueOf(ThreadedBukkitServer.getInstance().getRegionAtChunk(world, chunk.getX(), chunk.getZ()).getTickHandle().getTps5s().getAverage()).substring(0, 4));
                    }case "10s" -> {
                        player.sendMessage("TPS over " + arg + " is " + String.valueOf(ThreadedBukkitServer.getInstance().getRegionAtChunk(world, chunk.getX(), chunk.getZ()).getTickHandle().getTps10s().getAverage()).substring(0, 4));
                    }case "15s" -> {
                        player.sendMessage("TPS over " + arg + " is " + String.valueOf(ThreadedBukkitServer.getInstance().getRegionAtChunk(world, chunk.getX(), chunk.getZ()).getTickHandle().getTps15s().getAverage()).substring(0, 4));
                    }case "1m" -> {
                        player.sendMessage("TPS over " + arg + " is " + String.valueOf(ThreadedBukkitServer.getInstance().getRegionAtChunk(world, chunk.getX(), chunk.getZ()).getTickHandle().getTps1m().getAverage()).substring(0, 4));
                    }

                    default -> {
                        return false;
                    }
                }
            } else if(args[0].equalsIgnoreCase("mstp")){
                String arg = args[1];
                switch (arg) {

                    case "5s" -> {
                        player.sendMessage("MSTP over " + arg + " is " + String.valueOf(ThreadedBukkitServer.getInstance().getRegionAtChunk(world, chunk.getX(), chunk.getZ()).getTickHandle().getTickTimes5s().getAverage()).substring(0, 4));
                    }case "10s" -> {
                        player.sendMessage("MSTP over " + arg + " is " + String.valueOf(ThreadedBukkitServer.getInstance().getRegionAtChunk(world, chunk.getX(), chunk.getZ()).getTickHandle().getTickTimes10s().getAverage()).substring(0, 4));
                    }case "15s" -> {
                        player.sendMessage("MSTP over " + arg + " is " + String.valueOf(ThreadedBukkitServer.getInstance().getRegionAtChunk(world, chunk.getX(), chunk.getZ()).getTickHandle().getTickTimes15s().getAverage()).substring(0, 4));
                    }case "1m" -> {
                        player.sendMessage("MSTP over " + arg + " is " + String.valueOf(ThreadedBukkitServer.getInstance().getRegionAtChunk(world, chunk.getX(), chunk.getZ()).getTickHandle().getTickTimes60s().getAverage()).substring(0, 4));
                    }

                    default -> {
                        return false;
                    }
                }
            }

        }
        return false;
    }
}
