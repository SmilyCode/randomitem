package smily.plugin.summonrandomitem.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.springframework.lang.NonNull;
import smily.plugin.summonrandomitem.PluginContext;
import smily.plugin.summonrandomitem.event.RandomItem;
import smily.plugin.summonrandomitem.time.Minute;
import smily.plugin.summonrandomitem.time.Second;
import smily.plugin.summonrandomitem.time.Tick;
import smily.plugin.summonrandomitem.time.TimeContext;

import java.util.ArrayList;
import java.util.List;

public class SetPlayerCommand implements CommandExecutor, TabCompleter{
    Plugin plugin = Bukkit.getPluginManager().getPlugin("SummonRandomItem");

    Player targeted;
    boolean started;
    RandomItem randomItem = PluginContext.context.getBean(RandomItem.class);
    Minute minute = TimeContext.context.getBean(Minute.class);
    Second second = TimeContext.context.getBean(Second.class);
    Tick tick = TimeContext.context.getBean(Tick.class);

    @Override
    public boolean onCommand(@NonNull CommandSender sender,@NonNull Command command,@NonNull String label, String[] args) {

        if (args.length == 0){
            if (sender instanceof Player){
                sender.sendMessage("There is not enough argument");
            } else {
                System.out.println("There is not enough argument");
            }
        }
        if (args.length == 2) {
            if (args[0].equals("at")) {
                Player target = Bukkit.getPlayerExact(args[1]);

                if (target != null) {
                    if (sender instanceof Player) {
                        sender.sendMessage(target.getDisplayName() + " targeted");
                    } else {
                        System.out.println(target.getDisplayName() + " targeted");
                    }
                    targeted = target;
                }
            }

        } else if (args.length == 3||args.length == 4){
             if (args[0].equals("start")) {
                if (started) {
                    if (sender instanceof Player) {
                        sender.sendMessage("cannot proceed, game has started already");
                    } else {
                        System.out.println("cannot proceed, game has started already");
                    }
                } else {
                    if (targeted != null) {
                        if (args[1].equals("time")) {
                            if (args[2] != null) {
                                switch (args[3]) {
                                    case "second":
                                        started = true;
                                        randomItem.setCooldown(second.setTick(Integer.parseInt(args[2])));
                                        randomItem.executeRandomize(targeted);
                                        if (sender instanceof Player) {
                                            sender.sendMessage("game started");
                                        } else {
                                            System.out.println("game started");
                                        }
                                        break;
                                    case "minute":
                                        started = true;
                                        randomItem.setCooldown(minute.setTick(Integer.parseInt(args[2])));
                                        randomItem.executeRandomize(targeted);
                                        if (sender instanceof Player) {
                                            sender.sendMessage("game started");
                                        } else {
                                            System.out.println("game started");
                                        }
                                        break;
                                    case "tick":
                                        started = true;
                                        randomItem.setCooldown(tick.setTick(Integer.parseInt(args[2])));
                                        randomItem.executeRandomize(targeted);
                                        if (sender instanceof Player) {
                                            sender.sendMessage("game started");
                                        } else {
                                            System.out.println("game started");
                                        }
                                        break;
                                    default:
                                        if (sender instanceof Player) {
                                            sender.sendMessage("Format doesn't exist");
                                        } else {
                                            System.out.println("Format doesn't exist");
                                        }
                                        break;
                                }
                            } else {
                                if (sender instanceof Player) {
                                    sender.sendMessage("time cannot be null");
                                } else {
                                    System.out.println("time cannot be null");
                                }
                            }
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
        } else if (args.length == 1){
            switch (args[0]){
                case "clear":
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
                break;

            case "stop":
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
                break;

            case "start":
                if (started) {
                    if (sender instanceof Player) {
                        sender.sendMessage("cannot proceed, game has started already");
                    } else {
                        System.out.println("cannot proceed, game has started already");
                    }
                } else {
                    if (targeted != null) {
                        started = true;
                        new RandomItem().executeRandomize(targeted);
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
                break;
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(@NonNull CommandSender sender,@NonNull Command command,@NonNull String alias, String[] args) {
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
            if (args[0].equals("start")) {
                arguments.add("time");
            }

        }else if (args.length == 4){
            arguments.add("tick");
            arguments.add("second");
            arguments.add("minute");
        }

        return arguments;
    }
}
