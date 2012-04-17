package org.octopussy.udkplugin;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.octopussy.udkplugin.parser.UnrealScriptFlexLexer;
import org.octopussy.udkplugin.parser.UnrealScriptParser;
import org.octopussy.udkplugin.psi.UnrealScriptFile;
import org.octopussy.udkplugin.psi.UnrealScriptTokenType;
import org.octopussy.udkplugin.psi.UnrealScriptTypes;
import org.octopussy.udkplugin.psi.impl.UnrealScriptFileImpl;

/**
 * Created with IntelliJ IDEA.
 * User: dmonych
 * Date: 17.04.12
 * Time: 16:55
 */
public class UnrealScriptParserDefinition implements ParserDefinition {

  public static final IFileElementType UNREAL_SCRIPT_FILE_ELEMENT_TYPE = new IFileElementType("UNREAL_SCRIPT_FILE",
          UnrealScriptFileType.UNREAL_SCRIPT_LANGUAGE);
  public static final TokenSet WS = TokenSet.create(TokenType.WHITE_SPACE);
  public static final IElementType BNF_LINE_COMMENT = new UnrealScriptTokenType("US_LINE_COMMENT");
  public static final IElementType BNF_BLOCK_COMMENT = new UnrealScriptTokenType("US_BLOCK_COMMENT");
  public static final TokenSet COMMENTS = TokenSet.create(BNF_LINE_COMMENT, BNF_BLOCK_COMMENT);
  public static final TokenSet LITERALS = TokenSet.create(UnrealScriptTypes.US_STRING);

  @NotNull
  @Override
  public Lexer createLexer(Project project) {
    return new UnrealScriptFlexLexer();
  }

  @Override
  public PsiParser createParser(Project project) {
    return new UnrealScriptParser();
  }

  @Override
  public IFileElementType getFileNodeType() {
    return UNREAL_SCRIPT_FILE_ELEMENT_TYPE;
  }

  @NotNull
  @Override
  public TokenSet getWhitespaceTokens() {
    return WS;
  }

  @NotNull
  @Override
  public TokenSet getCommentTokens() {
    return COMMENTS;
  }

  @NotNull
  @Override
  public TokenSet getStringLiteralElements() {
    return LITERALS;
  }

  @NotNull
  @Override
  public PsiElement createElement(ASTNode astNode) {
    return UnrealScriptTypes.Factory.createElement(astNode);
  }

  @Override
  public PsiFile createFile(FileViewProvider fileViewProvider) {
    return new UnrealScriptFileImpl(fileViewProvider);
  }

  @Override
  public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode astNode, ASTNode astNode1) {
    return SpaceRequirements.MAY;
  }
}

