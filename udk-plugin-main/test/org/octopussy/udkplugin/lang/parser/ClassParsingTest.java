package org.octopussy.udkplugin.lang.parser;

import com.intellij.testFramework.ParsingTestCase;

/**
 * User: dmonych
 * Date: 22.05.12
 */
public class ClassParsingTest extends ParsingTestCase{
  public ClassParsingTest() {
    super("parser/classes", "uc", new UnrealParserDefinition());
  }

  @Override
  protected String getTestDataPath() {
    return "testData";
  }

  public void testClass1() throws Throwable { doTest(true); }
}
