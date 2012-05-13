package org.octopussy.udkplugin.lang.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.octopussy.udkplugin.UnrealFileType;
import org.octopussy.udkplugin.lang.UnrealTokenTypes;
import org.octopussy.udkplugin.lang.lexer.UnrealFlexLexer;

import org.octopussy.udkplugin.lang.psi.UnrealPsiFactory;
import org.octopussy.udkplugin.lang.psi.impl.UnrealPsiFileImpl;

/**
 * Created with IntelliJ IDEA.
 * User: dmonych
 * Date: 17.04.12
 * Time: 16:55
 */
public class UnrealParserDefinition implements ParserDefinition {

  public static final IFileElementType UNREAL_SCRIPT_FILE_ELEMENT_TYPE = new IFileElementType("UNREAL_SCRIPT_FILE",
          UnrealFileType.UNREAL_SCRIPT_LANGUAGE);
  public static final TokenSet WS = TokenSet.create(TokenType.WHITE_SPACE);

  public static final TokenSet COMMENTS = TokenSet.create(UnrealTokenTypes.LINE_COMMENT, UnrealTokenTypes.C_STYLE_COMMENT,
          UnrealTokenTypes.DOC_COMMENT);
  public static final TokenSet LITERALS = TokenSet.create(UnrealTokenTypes.STRING_LITERAL);

  @NotNull
  @Override
  public Lexer createLexer(Project project) {
    return new UnrealFlexLexer();
  }

  @Override
  public PsiParser createParser(Project project) {
    return new UnrealParser();
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
    return UnrealPsiFactory.createElement(astNode);
  }

  @Override
  public PsiFile createFile(FileViewProvider fileViewProvider) {
    return new UnrealPsiFileImpl(fileViewProvider);
  }

  @Override
  public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode astNode, ASTNode astNode1) {
    return SpaceRequirements.MAY;
  }
}

