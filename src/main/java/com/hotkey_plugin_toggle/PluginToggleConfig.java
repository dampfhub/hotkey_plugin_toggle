package com.hotkey_plugin_toggle;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup("plugin_toggle")
public interface PluginToggleConfig extends Config
{
	@ConfigItem(
			keyName = "hk_1",
			name = "Hotkey 1",
			description = "",
			position = 1
	)
	default Keybind hk_1()
	{
		return Keybind.NOT_SET;
	}
	@ConfigItem(
			keyName = "plugin_1",
			name = "Plugin 1",
			description = "Comma separated list of plugin names to toggle",
			position = 2
	)
	default String plugin_1()
	{
		return "";
	}
	@ConfigItem(
			keyName = "hk_2",
			name = "Hotkey 2",
			description = "",
			position = 3
	)
	default Keybind hk_2()
	{
		return Keybind.NOT_SET;
	}
	@ConfigItem(
			keyName = "plugin_2",
			name = "Plugin 2",
			description = "Comma separated list of plugin names to toggle",
			position = 4
	)
	default String plugin_2()
	{
		return "";
	}
	@ConfigItem(
			keyName = "hk_3",
			name = "Hotkey 3",
			description = "",
			position = 5
	)
	default Keybind hk_3()
	{
		return Keybind.NOT_SET;
	}
	@ConfigItem(
			keyName = "plugin_3",
			name = "Plugin 3",
			description = "Comma separated list of plugin names to toggle",
			position = 6
	)
	default String plugin_3()
	{
		return "";
	}
	@ConfigItem(
			keyName = "hk_4",
			name = "Hotkey 4",
			description = "",
			position = 7
	)
	default Keybind hk_4()
	{
		return Keybind.NOT_SET;
	}
	@ConfigItem(
			keyName = "plugin_4",
			name = "Plugin 4",
			description = "Comma separated list of plugin names to toggle",
			position = 8
	)
	default String plugin_4()
	{
		return "";
	}
	@ConfigItem(
			keyName = "hk_5",
			name = "Hotkey 5",
			description = "",
			position = 9
	)
	default Keybind hk_5()
	{
		return Keybind.NOT_SET;
	}
	@ConfigItem(
			keyName = "plugin_5",
			name = "Plugin 5",
			description = "Comma separated list of plugin names to toggle",
			position = 10
	)
	default String plugin_5()
	{
		return "";
	}
}