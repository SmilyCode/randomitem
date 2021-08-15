package smily.plugin.summonrandomitem.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import smily.plugin.summonrandomitem.summon.RandomItem;

import java.util.ArrayList;
import java.util.List;

public class SetPlayerCommand implements CommandExecutor, TabCompleter{
    Plugin plugin = Bukkit.getPluginManager().getPlugin("SummonRandomItem");

    Player targeted;
    boolean started;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0){
            if (sender instanceof Player){
                sender.sendMessage("There is not enough argument");
            } else {
                System.out.println("There is not enough argument");
            }
        }
        if (args.length == 2){
            if (args[0].equals("at")){
                Player target = Bukkit.getPlayerExact(args[1]);

                if (target != null){
                    if (sender instanceof Player) {
                        sender.sendMessage(target.getDisplayName() + " targeted");
                    } else {
                        System.out.println(target.getDisplayName() + " targeted");
                    }
                    targeted = target;
                }
            }

        } else if (args.length == 1){
            if (args[0].equals("start")) {
                if (started) {
                    if (sender instanceof Player) {
                        sender.sendMessage("cannot proceed, game has started already");
                    } else {
                        System.out.println("cannot proceed, game has started already");
                    }
                } else {
                    if (targeted != null) {
                        started = true;
                        new RandomItem().spawnItem(targeted);
                        if (sender instanceof Player) {
                            sender.sendMessage("game started");
                        } else {
                            System.out.println("game started");
                        }
                    } else {
                        if (sender instanceof Player) {
                            sender.sendMessage("No one is targeted");
                        } else {
                            System.out.println("No one is targeted");
                        }
                    }
                }
            }

            if (args[0].equals("clear")){
                if (targeted != null){
                    if (sender instanceof Player) {
                        sender.sendMessage("target cleared");
                    } else {
                        System.out.println("target cleared");
                    }
                    targeted = null;
                } else {
                    if (sender instanceof Player) {
                        sender.sendMessage("No one is targeted");
                    } else {
                        System.out.println("No one is targeted");
                    }
                }
            }

            if (args[0].equals("stop")){
                if (started){
                    started = false;
                    Bukkit.getScheduler().cancelTasks(plugin);
                    if (sender instanceof Player) {
                        sender.sendMessage("game stopped");
                    } else {
                        System.out.println("game stopped");
                    }
                } else {
                    if (sender instanceof Player) {
                        sender.sendMessage("cannot proceed, no game is running");
                    } else {
                        System.out.println("cannot proceed, no game is running");
                    }
                }
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> arguments = new ArrayList<>();

        if (args.length == 1){
            arguments.add("at");
            arguments.add("start");
            arguments.add("clear");
            arguments.add("stop");
        } else if (args.length == 2){
            for (Player a : Bukkit.getOnlinePlayers()){
                arguments.add(a.getDisplayName());
            }
        }

        return arguments;
    }
}
