package org.justc2t.tpsPlaceholder;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class canvasmccommandtabcompleter implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        List<String> result = new ArrayList<>();
        if(args.length == 1){
            result.add("tps");
            result.add("mstp");
        } else if(args.length == 2){
            result.add("5s");
            result.add("10s");
            result.add("15s");
            result.add("1m");
        }
        return  result;
    }
}
