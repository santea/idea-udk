package org.octopussy.udkplugin;

import com.intellij.lang.Language;

public class UnrealScriptLanguage extends Language {
    protected UnrealScriptLanguage() {
        super("UnrealScript");
    }

    @Override
    public boolean isCaseSensitive() {
        return false;
    }
}
