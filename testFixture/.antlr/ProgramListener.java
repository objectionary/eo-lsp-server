// Generated from /home/gasabaev/gh_repos/eo-lsp-server/testFixture/Program.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ProgramParser}.
 */
public interface ProgramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ProgramParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ProgramParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ProgramParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#license}.
	 * @param ctx the parse tree
	 */
	void enterLicense(ProgramParser.LicenseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#license}.
	 * @param ctx the parse tree
	 */
	void exitLicense(ProgramParser.LicenseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#metas}.
	 * @param ctx the parse tree
	 */
	void enterMetas(ProgramParser.MetasContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#metas}.
	 * @param ctx the parse tree
	 */
	void exitMetas(ProgramParser.MetasContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#objects}.
	 * @param ctx the parse tree
	 */
	void enterObjects(ProgramParser.ObjectsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#objects}.
	 * @param ctx the parse tree
	 */
	void exitObjects(ProgramParser.ObjectsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(ProgramParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(ProgramParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#abstraction}.
	 * @param ctx the parse tree
	 */
	void enterAbstraction(ProgramParser.AbstractionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#abstraction}.
	 * @param ctx the parse tree
	 */
	void exitAbstraction(ProgramParser.AbstractionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#attributes}.
	 * @param ctx the parse tree
	 */
	void enterAttributes(ProgramParser.AttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#attributes}.
	 * @param ctx the parse tree
	 */
	void exitAttributes(ProgramParser.AttributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(ProgramParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(ProgramParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(ProgramParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(ProgramParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#tail}.
	 * @param ctx the parse tree
	 */
	void enterTail(ProgramParser.TailContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#tail}.
	 * @param ctx the parse tree
	 */
	void exitTail(ProgramParser.TailContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#suffix}.
	 * @param ctx the parse tree
	 */
	void enterSuffix(ProgramParser.SuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#suffix}.
	 * @param ctx the parse tree
	 */
	void exitSuffix(ProgramParser.SuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(ProgramParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(ProgramParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterScope(ProgramParser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitScope(ProgramParser.ScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#application}.
	 * @param ctx the parse tree
	 */
	void enterApplication(ProgramParser.ApplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#application}.
	 * @param ctx the parse tree
	 */
	void exitApplication(ProgramParser.ApplicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#htail}.
	 * @param ctx the parse tree
	 */
	void enterHtail(ProgramParser.HtailContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#htail}.
	 * @param ctx the parse tree
	 */
	void exitHtail(ProgramParser.HtailContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#head}.
	 * @param ctx the parse tree
	 */
	void enterHead(ProgramParser.HeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#head}.
	 * @param ctx the parse tree
	 */
	void exitHead(ProgramParser.HeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#has}.
	 * @param ctx the parse tree
	 */
	void enterHas(ProgramParser.HasContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#has}.
	 * @param ctx the parse tree
	 */
	void exitHas(ProgramParser.HasContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#data}.
	 * @param ctx the parse tree
	 */
	void enterData(ProgramParser.DataContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#data}.
	 * @param ctx the parse tree
	 */
	void exitData(ProgramParser.DataContext ctx);
}
