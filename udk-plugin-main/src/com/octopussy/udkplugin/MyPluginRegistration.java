package com.octopussy.udkplugin;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

public class MyPluginRegistration implements ApplicationComponent {
    public MyPluginRegistration() {
    }

    public void initComponent() {
        ActionManager am = ActionManager.getInstance();
        TestAction action = new TestAction();
        // Passes an instance of your custom TextBoxes class to the registerAction method of the ActionManager class.
        am.registerAction("MyPluginAction", action);
        // Gets an instance of the WindowMenu action group.
        DefaultActionGroup windowM = (DefaultActionGroup) am.getAction("WindowMenu");
        // Adds a separator and a new menu command to the WindowMenu group on the main menu.
        windowM.addSeparator();
        windowM.add(action);
    }

    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @NotNull
    public String getComponentName() {
        return "MyPluginRegistration";
    }
}
