package org.octopussy.udkplugin.commenter;

import com.intellij.lang.Commenter;

/**
 * User: dmonych
 * Date: 20.04.12
 */
public class UnrealCommenter implements Commenter {
  public String getLineCommentPrefix() {
    return "//";
  }

  public String getBlockCommentPrefix() {
    return "/*";
  }

  public String getBlockCommentSuffix() {
    return "*/";
  }

  public String getCommentedBlockCommentPrefix() {
    return null;
  }

  public String getCommentedBlockCommentSuffix() {
    return null;
  }
}