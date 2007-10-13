package org.seasar.cms.wiki.engine.plugin;

public abstract class AbstractChildPluginExecuter implements
		ChildPluginExecuter {

	private PluginExecuter executer;

	public void setParent(PluginExecuter executer) {
		this.executer = executer;
	}

	public PluginExecuter getParent() {
		return executer;
	}

}
