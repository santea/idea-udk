package org.octopussy.udkplugin;

import com.intellij.lang.Language;

public class UnrealLanguage extends Language {
    protected UnrealLanguage() {
        super("UnrealScript");
    }

    @Override
    public boolean isCaseSensitive() {
        return false;
    }
}
