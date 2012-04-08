package com.octopussy.udkplugin;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;
public class UnrealScriptFileFactory extends FileTypeFactory {
    public void createFileTypes(@NotNull FileTypeConsumer consumer) {
        consumer.consume(UnrealScriptFileType.UNREAL_SCRIPT_FILE_TYPE);
    }
}
