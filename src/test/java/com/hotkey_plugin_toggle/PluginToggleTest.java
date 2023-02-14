package com.hotkey_plugin_toggle;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class PluginToggleTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(PluginToggle.class);
		RuneLite.main(args);
	}
}