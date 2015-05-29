package me.gal0511.bungeechat;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin implements Listener
{
  public void onEnable(){
    getProxy().getPluginManager().registerListener(this, this);
    

    getProxy().getPluginManager().registerCommand(this, new Command("chat"){
      @SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args){
        ProxiedPlayer player = (ProxiedPlayer)sender;
        if (player.hasPermission("staffchat.use")){
          if (args.length == 0){
            player.sendMessage("§e§m--------------------§bStaffChat§e§m--------------------");
            player.sendMessage("§aYour available chats:");
            if (player.hasPermission("staffchat.helper")) {
              player.sendMessage("§eHelper - §a/chat helper {message}");
            }
            if (player.hasPermission("staffchat.mod")) {
              player.sendMessage("§2Mod - §a/chat mod {message}");
            }
            if (player.hasPermission("staffchat.admin")) {
              player.sendMessage("§4Admin - §a/chat admin {message}");
            }
            if (player.hasPermission("staffchat.co-owner")) {
              player.sendMessage("§cCo-Owner - §a/chat co-owner {message}");
            }
            if (player.hasPermission("staffchat.all")) {
              player.sendMessage("All Staff - §a/chat all {message}");
            }
            player.sendMessage("§e§m--------------------§bStaffChat§e§m--------------------");
            return;
          }
          if ((args[0].equalsIgnoreCase("helper")) && 
            (player.hasPermission("staffchat.helper")))
          {
            if (args.length == 1) {
              player.sendMessage("§cPlease specify a message!");
            }
            if (args.length > 1)
            {
              StringBuilder helps = new StringBuilder();
              for (int i = 1; i < args.length; i++) {
                helps.append(args[i] + " ");
              }
              String help = helps.toString();
              for (ProxiedPlayer p : Main.this.getProxy().getPlayers()) {
                if (p.hasPermission("staffchat.helper")) {
                  p.sendMessage("§9[§9HelperChat§9] §r" + player.getName() + ": " + help);
                }
              }
            }
          }
          if ((args[0].equalsIgnoreCase("mod")) && 
            (player.hasPermission("staffchat.mod")))
          {
            if (args.length == 1) {
              player.sendMessage("§cPlease specify a message!");
            }
            if (args.length > 1)
            {
              StringBuilder mods = new StringBuilder();
              for (int i = 1; i < args.length; i++) {
                mods.append(args[i] + " ");
              }
              String mod = mods.toString();
              for (ProxiedPlayer p : Main.this.getProxy().getPlayers()) {
                if (p.hasPermission("staffchat.mod")) {
                  player.sendMessage("§9[§2ModChat§9] §r" + player.getName() + ": " + mod);
                }
              }
            }
          }
          if ((args[0].equalsIgnoreCase("admin")) && 
            (player.hasPermission("staffchat.admin")))
          {
            if (args.length == 1) {
              player.sendMessage("§cPlease specify a message!");
            }
            if (args.length > 1)
            {
              StringBuilder admins = new StringBuilder();
              for (int i = 1; i < args.length; i++) {
                admins.append(args[i] + " ");
              }
              String admin = admins.toString();
              for (ProxiedPlayer p : Main.this.getProxy().getPlayers()) {
                if (p.hasPermission("staffchat.admin")) {
                  player.sendMessage("§9[§4AdminChat§9] §r" + player.getName() + ": " + admin);
                }
              }
            }
          }
          if ((args[0].equalsIgnoreCase("co-owner")) && 
            (player.hasPermission("staffchat.co-owner")))
          {
            if (args.length == 1) {
              player.sendMessage("§cPlease specify a message!");
            }
            if (args.length > 1)
            {
              StringBuilder co = new StringBuilder();
              for (int i = 1; i < args.length; i++) {
                co.append(args[i] + " ");
              }
              String com = co.toString();
              for (ProxiedPlayer p : Main.this.getProxy().getPlayers()) {
                if (p.hasPermission("staffchat.co-owner")) {
                  player.sendMessage("§9[§cCo-OwnerChat§9] §r" + player.getName() + ": " + com);
                }
              }
            }
          }
          if ((args[0].equalsIgnoreCase("all")) && 
            (player.hasPermission("staffchat.all")))
          {
            if (args.length == 1) {
              player.sendMessage("§cPlease specify a message!");
            }
            if (args.length > 1)
            {
              StringBuilder alls = new StringBuilder();
              for (int i = 1; i < args.length; i++) {
                alls.append(args[i] + " ");
              }
              String all = alls.toString();
              for (ProxiedPlayer p : Main.this.getProxy().getPlayers()) {
                if (p.hasPermission("staffchat.all")) {
                  player.sendMessage("§9[§bStaffChat§9] §r" + player.getName() + ": " + all);
                }
              }
            }
          }
        }
      }
    });
  }
}
