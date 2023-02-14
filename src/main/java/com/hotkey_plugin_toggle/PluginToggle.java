package com.hotkey_plugin_toggle;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginInstantiationException;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.util.HotkeyListener;
import net.runelite.client.input.KeyManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Locale;
import java.util.Objects;

@Slf4j
@PluginDescriptor(
		name = "Plugin Toggle Hotkeys",
		description = "Shortcut keys to toggle arbitrary RuneLite plugins"
)
public class PluginToggle extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private PluginToggleConfig config;

	@Inject
	private PluginManager pm;

	@Inject
	private KeyManager km;

	@Getter(AccessLevel.PACKAGE)
	private final HotkeyListener hk_1_listener = new HotkeyListener(() -> config.hk_1())
	{
		@Override
		public void hotkeyPressed()
		{
			handleHotkey(config.plugin_1());
		}
	};
	private final HotkeyListener hk_2_listener = new HotkeyListener(() -> config.hk_2())
	{
		@Override
		public void hotkeyPressed()
		{
			handleHotkey(config.plugin_2());
		}
	};
	private final HotkeyListener hk_3_listener = new HotkeyListener(() -> config.hk_3())
	{
		@Override
		public void hotkeyPressed()
		{
			handleHotkey(config.plugin_3());
		}
	};
	private final HotkeyListener hk_4_listener = new HotkeyListener(() -> config.hk_4())
	{
		@Override
		public void hotkeyPressed()
		{
			handleHotkey(config.plugin_4());
		}
	};
	private final HotkeyListener hk_5_listener = new HotkeyListener(() -> config.hk_5())
	{
		@Override
		public void hotkeyPressed()
		{
			handleHotkey(config.plugin_5());
		}
	};

	public void handleHotkey(String pluginsStr) {
		List<String> pluginsList = parsePluginsList(pluginsStr);
		for (Plugin plugin : pm.getPlugins()) {
			String name = plugin.getName().toLowerCase(Locale.ROOT);
			for (String pluginStr : pluginsList) {
				if (Objects.equals(name, pluginStr.toLowerCase(Locale.ROOT))) {
					boolean enabled = pm.isPluginEnabled(plugin);
					try {
						if (enabled) {
							pm.setPluginEnabled(plugin, false);
							pm.stopPlugin(plugin);
						} else {
							pm.setPluginEnabled(plugin, true);
							pm.startPlugin(plugin);
						}
					} catch (PluginInstantiationException ex) {
						log.warn("Error when starting plugin {}", plugin.getClass().getSimpleName(), ex);
					}
				}
			}
		}
	}
	protected List<String> parsePluginsList(String pluginsStr) {
		List<String> pluginsList = new ArrayList<>();
		for (String p : pluginsStr.split(",")) {
			pluginsList.add(p.strip());
		}
		return pluginsList;
	}

	@Override
	protected void startUp() throws Exception
	{
		km.registerKeyListener(hk_1_listener);
		km.registerKeyListener(hk_2_listener);
		km.registerKeyListener(hk_3_listener);
		km.registerKeyListener(hk_4_listener);
		km.registerKeyListener(hk_5_listener);
	}

	@Provides
	PluginToggleConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PluginToggleConfig.class);
	}
}
