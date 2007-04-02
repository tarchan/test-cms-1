package org.seasar.cms.classbuilder.impl;

import java.net.URL;
import java.net.URLClassLoader;

import org.seasar.extension.unit.S2TestCase;
import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.S2ContainerFactory;
import org.seasar.framework.util.ResourceUtil;


public class RedefinableXmlS2ContainerBuilderTest extends S2TestCase
{
    public void test_コンポーネントの再定義ができること()
        throws Exception
    {
        include("test1.dicon");
        Hoe hoe = (Hoe)getComponent(Hoe.class);
        assertEquals("redefined", hoe.getName());
    }


    public void test_コンポーネントの追加ができること()
        throws Exception
    {
        include("test2.dicon");
        assertNotNull(getComponent(Hoe.class));
    }


    public void test_JARの外にある差分diconによってJARに入っているdiconファイルのコンポーネントの再定義ができること()
        throws Exception
    {
        ClassLoader cl = new URLClassLoader(new URL[] { new URL("jar:"
            + ResourceUtil.getResource("testinjar1.jar").toExternalForm()
            + "!/") }, getClass().getClassLoader());
        S2Container container = S2ContainerFactory.create("testinjar1.dicon",
            cl);
        Hoe hoe = (Hoe)container.getComponent(Hoe.class);
        assertEquals("redefined", hoe.getName());
    }


    public void test_diconのパスがURLであってもJARの外にある差分diconによってJARに入っているdiconファイルのコンポーネントの再定義ができること()
        throws Exception
    {
        String jarPath = "jar:"
            + ResourceUtil.getResource("testinjar1.jar").toExternalForm()
            + "!/";
        ClassLoader cl = new URLClassLoader(new URL[] { new URL(jarPath) },
            getClass().getClassLoader());
        S2Container container = S2ContainerFactory.create(jarPath
            + "testinjar1.dicon", cl);
        Hoe hoe = (Hoe)container.getComponent(Hoe.class);
        assertEquals("redefined", hoe.getName());
    }


    public void test_JARの外にある差分diconによってJARに入っているdiconの追加定義ができること()
        throws Exception
    {
        ClassLoader cl = new URLClassLoader(new URL[] { new URL("jar:"
            + ResourceUtil.getResource("testinjar2.jar").toExternalForm()
            + "!/") }, getClass().getClassLoader());
        S2Container container = S2ContainerFactory.create("testinjar2.dicon",
            cl);
        assertNotNull(container.getComponent(Hoe.class));
    }


    public void test_diconのパスがURLであってもJARの外にある差分diconによってJARに入っているdiconファイルの追加定義ができること()
        throws Exception
    {
        String jarPath = "jar:"
            + ResourceUtil.getResource("testinjar2.jar").toExternalForm()
            + "!/";
        ClassLoader cl = new URLClassLoader(new URL[] { new URL(jarPath) },
            getClass().getClassLoader());
        S2Container container = S2ContainerFactory.create(jarPath
            + "testinjar2.dicon", cl);
        assertNotNull(container.getComponent(Hoe.class));
    }
}
