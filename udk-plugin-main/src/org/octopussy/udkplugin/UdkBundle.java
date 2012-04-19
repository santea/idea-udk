package org.octopussy.udkplugin;

import com.intellij.CommonBundle;
import org.jetbrains.annotations.PropertyKey;

import java.util.ResourceBundle;

/**
 * User: dmonych
 * Date: 19.04.12
 */
public class UdkBundle {

  private static final String BUNDLE_NAME = "messages.UdkBundle";
  private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

  public static String message(@PropertyKey(resourceBundle = BUNDLE_NAME) String key, Object... params) {
    return CommonBundle.message(BUNDLE, key, params);
  }
}
