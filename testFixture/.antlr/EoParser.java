// Generated from /home/gasabaev/gh_repos/eo-lsp-server/testFixture/Eo.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENTARY=1, META=2, ROOT=3, HOME=4, STAR=5, CONST=6, COLON=7, ARROW=8, 
		XI=9, PLUS=10, MINUS=11, QUESTION=12, SPACE=13, DOT=14, LSQ=15, RSQ=16, 
		LB=17, RB=18, PHI=19, RHO=20, HASH=21, TILDE=22, EOL=23, BYTES=24, STRING=25, 
		INT=26, FLOAT=27, HEX=28, NAME=29, TEXT=30, TAB=31, UNTAB=32;
	public static final int
		RULE_program = 0, RULE_eop = 1, RULE_metas = 2, RULE_objects = 3, RULE_comment = 4, 
		RULE_commentOptional = 5, RULE_commentMandatory = 6, RULE_object = 7, 
		RULE_bound = 8, RULE_subMaster = 9, RULE_masterBody = 10, RULE_just = 11, 
		RULE_justNamed = 12, RULE_atom = 13, RULE_formation = 14, RULE_innersOrEol = 15, 
		RULE_inners = 16, RULE_voids = 17, RULE_void = 18, RULE_application = 19, 
		RULE_happlication = 20, RULE_happlicationExtended = 21, RULE_happlicationReversed = 22, 
		RULE_happlicationHead = 23, RULE_happlicationHeadExtended = 24, RULE_applicable = 25, 
		RULE_happlicationTail = 26, RULE_happlicationTailReversedFirst = 27, RULE_happlicationArg = 28, 
		RULE_vapplication = 29, RULE_vapplicationHead = 30, RULE_compactArray = 31, 
		RULE_vapplicationHeadNamed = 32, RULE_vapplicationArgs = 33, RULE_vapplicationArgsReversed = 34, 
		RULE_vapplicationArgsSpecific = 35, RULE_vapplicationArgBound = 36, RULE_vapplicationArgBoundCurrent = 37, 
		RULE_vapplicationArgBoundNext = 38, RULE_vapplicationArgUnbound = 39, 
		RULE_vapplicationArgUnboundCurrent = 40, RULE_vapplicationArgUnboundNext = 41, 
		RULE_formationNamed = 42, RULE_hformation = 43, RULE_hanonym = 44, RULE_onlyphi = 45, 
		RULE_onlyphiTail = 46, RULE_hanonymInner = 47, RULE_method = 48, RULE_methodNamed = 49, 
		RULE_hmethod = 50, RULE_vmethod = 51, RULE_vmethodHead = 52, RULE_vmethodHeadApplicationTail = 53, 
		RULE_vmethodHeadVapplication = 54, RULE_methodTail = 55, RULE_beginner = 56, 
		RULE_finisher = 57, RULE_reversed = 58, RULE_fname = 59, RULE_oname = 60, 
		RULE_suffix = 61, RULE_spacedArrow = 62, RULE_scope = 63, RULE_as = 64, 
		RULE_data = 65;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "eop", "metas", "objects", "comment", "commentOptional", "commentMandatory", 
			"object", "bound", "subMaster", "masterBody", "just", "justNamed", "atom", 
			"formation", "innersOrEol", "inners", "voids", "void", "application", 
			"happlication", "happlicationExtended", "happlicationReversed", "happlicationHead", 
			"happlicationHeadExtended", "applicable", "happlicationTail", "happlicationTailReversedFirst", 
			"happlicationArg", "vapplication", "vapplicationHead", "compactArray", 
			"vapplicationHeadNamed", "vapplicationArgs", "vapplicationArgsReversed", 
			"vapplicationArgsSpecific", "vapplicationArgBound", "vapplicationArgBoundCurrent", 
			"vapplicationArgBoundNext", "vapplicationArgUnbound", "vapplicationArgUnboundCurrent", 
			"vapplicationArgUnboundNext", "formationNamed", "hformation", "hanonym", 
			"onlyphi", "onlyphiTail", "hanonymInner", "method", "methodNamed", "hmethod", 
			"vmethod", "vmethodHead", "vmethodHeadApplicationTail", "vmethodHeadVapplication", 
			"methodTail", "beginner", "finisher", "reversed", "fname", "oname", "suffix", 
			"spacedArrow", "scope", "as", "data"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'Q'", "'QQ'", "'*'", "'!'", "':'", "'>'", "'$'", "'+'", 
			"'-'", "'?'", "' '", "'.'", "'['", "']'", "'('", "')'", "'@'", "'^'", 
			"'#'", "'~'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENTARY", "META", "ROOT", "HOME", "STAR", "CONST", "COLON", 
			"ARROW", "XI", "PLUS", "MINUS", "QUESTION", "SPACE", "DOT", "LSQ", "RSQ", 
			"LB", "RB", "PHI", "RHO", "HASH", "TILDE", "EOL", "BYTES", "STRING", 
			"INT", "FLOAT", "HEX", "NAME", "TEXT", "TAB", "UNTAB"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Eo.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public ObjectsContext objects() {
			return getRuleContext(ObjectsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(EoParser.EOF, 0); }
		public MetasContext metas() {
			return getRuleContext(MetasContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==META) {
				{
				setState(132);
				metas();
				}
			}

			setState(135);
			objects();
			setState(136);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EopContext extends ParserRuleContext {
		public List<TerminalNode> EOL() { return getTokens(EoParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(EoParser.EOL, i);
		}
		public EopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eop; }
	}

	public final EopContext eop() throws RecognitionException {
		EopContext _localctx = new EopContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_eop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(EOL);
			setState(139);
			match(EOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MetasContext extends ParserRuleContext {
		public List<TerminalNode> META() { return getTokens(EoParser.META); }
		public TerminalNode META(int i) {
			return getToken(EoParser.META, i);
		}
		public EopContext eop() {
			return getRuleContext(EopContext.class,0);
		}
		public List<TerminalNode> EOL() { return getTokens(EoParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(EoParser.EOL, i);
		}
		public MetasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metas; }
	}

	public final MetasContext metas() throws RecognitionException {
		MetasContext _localctx = new MetasContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_metas);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(141);
					match(META);
					setState(142);
					match(EOL);
					}
					} 
				}
				setState(147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(148);
			match(META);
			setState(149);
			eop();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectsContext extends ParserRuleContext {
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public List<TerminalNode> EOL() { return getTokens(EoParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(EoParser.EOL, i);
		}
		public ObjectsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objects; }
	}

	public final ObjectsContext objects() throws RecognitionException {
		ObjectsContext _localctx = new ObjectsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_objects);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(151);
				object();
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EOL) {
					{
					setState(152);
					match(EOL);
					}
				}

				}
				}
				setState(157); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2136638010L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommentContext extends ParserRuleContext {
		public TerminalNode COMMENTARY() { return getToken(EoParser.COMMENTARY, 0); }
		public TerminalNode EOL() { return getToken(EoParser.EOL, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(COMMENTARY);
			setState(160);
			match(EOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommentOptionalContext extends ParserRuleContext {
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public CommentOptionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commentOptional; }
	}

	public final CommentOptionalContext commentOptional() throws RecognitionException {
		CommentOptionalContext _localctx = new CommentOptionalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_commentOptional);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(162);
					comment();
					}
					} 
				}
				setState(167);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommentMandatoryContext extends ParserRuleContext {
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public CommentMandatoryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commentMandatory; }
	}

	public final CommentMandatoryContext commentMandatory() throws RecognitionException {
		CommentMandatoryContext _localctx = new CommentMandatoryContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_commentMandatory);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(168);
				comment();
				}
				}
				setState(171); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMENTARY );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectContext extends ParserRuleContext {
		public CommentMandatoryContext commentMandatory() {
			return getRuleContext(CommentMandatoryContext.class,0);
		}
		public MasterBodyContext masterBody() {
			return getRuleContext(MasterBodyContext.class,0);
		}
		public BoundContext bound() {
			return getRuleContext(BoundContext.class,0);
		}
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_object);
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				commentMandatory();
				setState(174);
				masterBody();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				bound();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoundContext extends ParserRuleContext {
		public CommentOptionalContext commentOptional() {
			return getRuleContext(CommentOptionalContext.class,0);
		}
		public ApplicationContext application() {
			return getRuleContext(ApplicationContext.class,0);
		}
		public TerminalNode EOL() { return getToken(EoParser.EOL, 0); }
		public MethodNamedContext methodNamed() {
			return getRuleContext(MethodNamedContext.class,0);
		}
		public JustNamedContext justNamed() {
			return getRuleContext(JustNamedContext.class,0);
		}
		public BoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bound; }
	}

	public final BoundContext bound() throws RecognitionException {
		BoundContext _localctx = new BoundContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			commentOptional();
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(180);
				application();
				}
				break;
			case 2:
				{
				setState(183);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(181);
					methodNamed();
					}
					break;
				case 2:
					{
					setState(182);
					justNamed();
					}
					break;
				}
				setState(185);
				match(EOL);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubMasterContext extends ParserRuleContext {
		public CommentOptionalContext commentOptional() {
			return getRuleContext(CommentOptionalContext.class,0);
		}
		public MasterBodyContext masterBody() {
			return getRuleContext(MasterBodyContext.class,0);
		}
		public SubMasterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subMaster; }
	}

	public final SubMasterContext subMaster() throws RecognitionException {
		SubMasterContext _localctx = new SubMasterContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_subMaster);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			commentOptional();
			setState(190);
			masterBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MasterBodyContext extends ParserRuleContext {
		public FormationContext formation() {
			return getRuleContext(FormationContext.class,0);
		}
		public TerminalNode EOL() { return getToken(EoParser.EOL, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public HanonymContext hanonym() {
			return getRuleContext(HanonymContext.class,0);
		}
		public OnameContext oname() {
			return getRuleContext(OnameContext.class,0);
		}
		public MasterBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_masterBody; }
	}

	public final MasterBodyContext masterBody() throws RecognitionException {
		MasterBodyContext _localctx = new MasterBodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_masterBody);
		try {
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				formation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(193);
					atom();
					}
					break;
				case 2:
					{
					setState(194);
					hanonym();
					setState(195);
					oname();
					}
					break;
				}
				setState(199);
				match(EOL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JustContext extends ParserRuleContext {
		public BeginnerContext beginner() {
			return getRuleContext(BeginnerContext.class,0);
		}
		public FinisherContext finisher() {
			return getRuleContext(FinisherContext.class,0);
		}
		public JustContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_just; }
	}

	public final JustContext just() throws RecognitionException {
		JustContext _localctx = new JustContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_just);
		try {
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ROOT:
			case HOME:
			case STAR:
			case XI:
			case BYTES:
			case STRING:
			case INT:
			case FLOAT:
			case HEX:
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				beginner();
				}
				break;
			case PHI:
			case RHO:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				finisher();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JustNamedContext extends ParserRuleContext {
		public JustContext just() {
			return getRuleContext(JustContext.class,0);
		}
		public OnameContext oname() {
			return getRuleContext(OnameContext.class,0);
		}
		public JustNamedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_justNamed; }
	}

	public final JustNamedContext justNamed() throws RecognitionException {
		JustNamedContext _localctx = new JustNamedContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_justNamed);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			just();
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(208);
				oname();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomContext extends ParserRuleContext {
		public VoidsContext voids() {
			return getRuleContext(VoidsContext.class,0);
		}
		public SuffixContext suffix() {
			return getRuleContext(SuffixContext.class,0);
		}
		public TerminalNode SPACE() { return getToken(EoParser.SPACE, 0); }
		public TerminalNode QUESTION() { return getToken(EoParser.QUESTION, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			voids();
			setState(212);
			suffix();
			setState(213);
			match(SPACE);
			setState(214);
			match(QUESTION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FormationContext extends ParserRuleContext {
		public VoidsContext voids() {
			return getRuleContext(VoidsContext.class,0);
		}
		public OnameContext oname() {
			return getRuleContext(OnameContext.class,0);
		}
		public InnersOrEolContext innersOrEol() {
			return getRuleContext(InnersOrEolContext.class,0);
		}
		public FormationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formation; }
	}

	public final FormationContext formation() throws RecognitionException {
		FormationContext _localctx = new FormationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_formation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			voids();
			setState(217);
			oname();
			setState(218);
			innersOrEol();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InnersOrEolContext extends ParserRuleContext {
		public InnersContext inners() {
			return getRuleContext(InnersContext.class,0);
		}
		public TerminalNode EOL() { return getToken(EoParser.EOL, 0); }
		public InnersOrEolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innersOrEol; }
	}

	public final InnersOrEolContext innersOrEol() throws RecognitionException {
		InnersOrEolContext _localctx = new InnersOrEolContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_innersOrEol);
		try {
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				inners();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				match(EOL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InnersContext extends ParserRuleContext {
		public List<TerminalNode> EOL() { return getTokens(EoParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(EoParser.EOL, i);
		}
		public TerminalNode TAB() { return getToken(EoParser.TAB, 0); }
		public TerminalNode UNTAB() { return getToken(EoParser.UNTAB, 0); }
		public List<BoundContext> bound() {
			return getRuleContexts(BoundContext.class);
		}
		public BoundContext bound(int i) {
			return getRuleContext(BoundContext.class,i);
		}
		public List<SubMasterContext> subMaster() {
			return getRuleContexts(SubMasterContext.class);
		}
		public SubMasterContext subMaster(int i) {
			return getRuleContext(SubMasterContext.class,i);
		}
		public InnersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inners; }
	}

	public final InnersContext inners() throws RecognitionException {
		InnersContext _localctx = new InnersContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_inners);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(EOL);
			setState(225);
			match(TAB);
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(226);
				bound();
				}
				break;
			case 2:
				{
				setState(227);
				subMaster();
				}
				break;
			}
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2145026618L) != 0)) {
				{
				setState(235);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(230);
					bound();
					}
					break;
				case 2:
					{
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==EOL) {
						{
						setState(231);
						match(EOL);
						}
					}

					setState(234);
					subMaster();
					}
					break;
				}
				}
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(240);
			match(UNTAB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VoidsContext extends ParserRuleContext {
		public TerminalNode LSQ() { return getToken(EoParser.LSQ, 0); }
		public TerminalNode RSQ() { return getToken(EoParser.RSQ, 0); }
		public List<VoidContext> void_() {
			return getRuleContexts(VoidContext.class);
		}
		public VoidContext void_(int i) {
			return getRuleContext(VoidContext.class,i);
		}
		public List<TerminalNode> SPACE() { return getTokens(EoParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(EoParser.SPACE, i);
		}
		public VoidsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voids; }
	}

	public final VoidsContext voids() throws RecognitionException {
		VoidsContext _localctx = new VoidsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_voids);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(LSQ);
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PHI || _la==NAME) {
				{
				setState(243);
				void_();
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACE) {
					{
					{
					setState(244);
					match(SPACE);
					setState(245);
					void_();
					}
					}
					setState(250);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(253);
			match(RSQ);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VoidContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(EoParser.NAME, 0); }
		public TerminalNode PHI() { return getToken(EoParser.PHI, 0); }
		public VoidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_void; }
	}

	public final VoidContext void_() throws RecognitionException {
		VoidContext _localctx = new VoidContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_void);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			_la = _input.LA(1);
			if ( !(_la==PHI || _la==NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ApplicationContext extends ParserRuleContext {
		public HapplicationExtendedContext happlicationExtended() {
			return getRuleContext(HapplicationExtendedContext.class,0);
		}
		public TerminalNode EOL() { return getToken(EoParser.EOL, 0); }
		public OnameContext oname() {
			return getRuleContext(OnameContext.class,0);
		}
		public VapplicationContext vapplication() {
			return getRuleContext(VapplicationContext.class,0);
		}
		public ApplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_application; }
	}

	public final ApplicationContext application() throws RecognitionException {
		ApplicationContext _localctx = new ApplicationContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_application);
		int _la;
		try {
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(257);
				happlicationExtended();
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(258);
					oname();
					}
				}

				setState(261);
				match(EOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				vapplication();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HapplicationContext extends ParserRuleContext {
		public HapplicationHeadContext happlicationHead() {
			return getRuleContext(HapplicationHeadContext.class,0);
		}
		public HapplicationTailContext happlicationTail() {
			return getRuleContext(HapplicationTailContext.class,0);
		}
		public HapplicationReversedContext happlicationReversed() {
			return getRuleContext(HapplicationReversedContext.class,0);
		}
		public HapplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_happlication; }
	}

	public final HapplicationContext happlication() throws RecognitionException {
		HapplicationContext _localctx = new HapplicationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_happlication);
		try {
			setState(270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(266);
				happlicationHead();
				setState(267);
				happlicationTail();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(269);
				happlicationReversed();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HapplicationExtendedContext extends ParserRuleContext {
		public HapplicationHeadExtendedContext happlicationHeadExtended() {
			return getRuleContext(HapplicationHeadExtendedContext.class,0);
		}
		public HapplicationTailContext happlicationTail() {
			return getRuleContext(HapplicationTailContext.class,0);
		}
		public HapplicationReversedContext happlicationReversed() {
			return getRuleContext(HapplicationReversedContext.class,0);
		}
		public HapplicationExtendedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_happlicationExtended; }
	}

	public final HapplicationExtendedContext happlicationExtended() throws RecognitionException {
		HapplicationExtendedContext _localctx = new HapplicationExtendedContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_happlicationExtended);
		try {
			setState(276);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				happlicationHeadExtended();
				setState(273);
				happlicationTail();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(275);
				happlicationReversed();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HapplicationReversedContext extends ParserRuleContext {
		public ReversedContext reversed() {
			return getRuleContext(ReversedContext.class,0);
		}
		public TerminalNode SPACE() { return getToken(EoParser.SPACE, 0); }
		public HapplicationTailReversedFirstContext happlicationTailReversedFirst() {
			return getRuleContext(HapplicationTailReversedFirstContext.class,0);
		}
		public HapplicationTailContext happlicationTail() {
			return getRuleContext(HapplicationTailContext.class,0);
		}
		public HapplicationReversedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_happlicationReversed; }
	}

	public final HapplicationReversedContext happlicationReversed() throws RecognitionException {
		HapplicationReversedContext _localctx = new HapplicationReversedContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_happlicationReversed);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			reversed();
			setState(279);
			match(SPACE);
			setState(280);
			happlicationTailReversedFirst();
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(281);
				happlicationTail();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HapplicationHeadContext extends ParserRuleContext {
		public HmethodContext hmethod() {
			return getRuleContext(HmethodContext.class,0);
		}
		public ApplicableContext applicable() {
			return getRuleContext(ApplicableContext.class,0);
		}
		public HapplicationHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_happlicationHead; }
	}

	public final HapplicationHeadContext happlicationHead() throws RecognitionException {
		HapplicationHeadContext _localctx = new HapplicationHeadContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_happlicationHead);
		try {
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				hmethod();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				applicable();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HapplicationHeadExtendedContext extends ParserRuleContext {
		public VmethodContext vmethod() {
			return getRuleContext(VmethodContext.class,0);
		}
		public HapplicationHeadContext happlicationHead() {
			return getRuleContext(HapplicationHeadContext.class,0);
		}
		public HapplicationHeadExtendedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_happlicationHeadExtended; }
	}

	public final HapplicationHeadExtendedContext happlicationHeadExtended() throws RecognitionException {
		HapplicationHeadExtendedContext _localctx = new HapplicationHeadExtendedContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_happlicationHeadExtended);
		try {
			setState(290);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				vmethod();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				happlicationHead();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ApplicableContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(EoParser.STAR, 0); }
		public TerminalNode NAME() { return getToken(EoParser.NAME, 0); }
		public TerminalNode PHI() { return getToken(EoParser.PHI, 0); }
		public ApplicableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_applicable; }
	}

	public final ApplicableContext applicable() throws RecognitionException {
		ApplicableContext _localctx = new ApplicableContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_applicable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 537395232L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HapplicationTailContext extends ParserRuleContext {
		public List<TerminalNode> SPACE() { return getTokens(EoParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(EoParser.SPACE, i);
		}
		public List<HapplicationArgContext> happlicationArg() {
			return getRuleContexts(HapplicationArgContext.class);
		}
		public HapplicationArgContext happlicationArg(int i) {
			return getRuleContext(HapplicationArgContext.class,i);
		}
		public List<AsContext> as() {
			return getRuleContexts(AsContext.class);
		}
		public AsContext as(int i) {
			return getRuleContext(AsContext.class,i);
		}
		public HapplicationTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_happlicationTail; }
	}

	public final HapplicationTailContext happlicationTail() throws RecognitionException {
		HapplicationTailContext _localctx = new HapplicationTailContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_happlicationTail);
		try {
			int _alt;
			setState(308);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(298); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(294);
						match(SPACE);
						setState(295);
						happlicationArg();
						setState(296);
						as();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(300); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(304); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(302);
						match(SPACE);
						setState(303);
						happlicationArg();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(306); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HapplicationTailReversedFirstContext extends ParserRuleContext {
		public HapplicationArgContext happlicationArg() {
			return getRuleContext(HapplicationArgContext.class,0);
		}
		public HapplicationTailReversedFirstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_happlicationTailReversedFirst; }
	}

	public final HapplicationTailReversedFirstContext happlicationTailReversedFirst() throws RecognitionException {
		HapplicationTailReversedFirstContext _localctx = new HapplicationTailReversedFirstContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_happlicationTailReversedFirst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			happlicationArg();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HapplicationArgContext extends ParserRuleContext {
		public JustContext just() {
			return getRuleContext(JustContext.class,0);
		}
		public HmethodContext hmethod() {
			return getRuleContext(HmethodContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public HapplicationArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_happlicationArg; }
	}

	public final HapplicationArgContext happlicationArg() throws RecognitionException {
		HapplicationArgContext _localctx = new HapplicationArgContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_happlicationArg);
		try {
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(312);
				just();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(313);
				hmethod();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(314);
				scope();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VapplicationContext extends ParserRuleContext {
		public VapplicationHeadNamedContext vapplicationHeadNamed() {
			return getRuleContext(VapplicationHeadNamedContext.class,0);
		}
		public VapplicationArgsContext vapplicationArgs() {
			return getRuleContext(VapplicationArgsContext.class,0);
		}
		public ReversedContext reversed() {
			return getRuleContext(ReversedContext.class,0);
		}
		public VapplicationArgsReversedContext vapplicationArgsReversed() {
			return getRuleContext(VapplicationArgsReversedContext.class,0);
		}
		public OnameContext oname() {
			return getRuleContext(OnameContext.class,0);
		}
		public VapplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vapplication; }
	}

	public final VapplicationContext vapplication() throws RecognitionException {
		VapplicationContext _localctx = new VapplicationContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_vapplication);
		int _la;
		try {
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(317);
				vapplicationHeadNamed();
				setState(318);
				vapplicationArgs();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(320);
				reversed();
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(321);
					oname();
					}
				}

				setState(324);
				vapplicationArgsReversed();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VapplicationHeadContext extends ParserRuleContext {
		public ApplicableContext applicable() {
			return getRuleContext(ApplicableContext.class,0);
		}
		public HmethodContext hmethod() {
			return getRuleContext(HmethodContext.class,0);
		}
		public VmethodContext vmethod() {
			return getRuleContext(VmethodContext.class,0);
		}
		public CompactArrayContext compactArray() {
			return getRuleContext(CompactArrayContext.class,0);
		}
		public VapplicationHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vapplicationHead; }
	}

	public final VapplicationHeadContext vapplicationHead() throws RecognitionException {
		VapplicationHeadContext _localctx = new VapplicationHeadContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_vapplicationHead);
		try {
			setState(332);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				applicable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(329);
				hmethod();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(330);
				vmethod();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(331);
				compactArray();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompactArrayContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(EoParser.NAME, 0); }
		public TerminalNode SPACE() { return getToken(EoParser.SPACE, 0); }
		public TerminalNode STAR() { return getToken(EoParser.STAR, 0); }
		public TerminalNode INT() { return getToken(EoParser.INT, 0); }
		public CompactArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compactArray; }
	}

	public final CompactArrayContext compactArray() throws RecognitionException {
		CompactArrayContext _localctx = new CompactArrayContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_compactArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			match(NAME);
			setState(335);
			match(SPACE);
			setState(336);
			match(STAR);
			setState(338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(337);
				match(INT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VapplicationHeadNamedContext extends ParserRuleContext {
		public VapplicationHeadContext vapplicationHead() {
			return getRuleContext(VapplicationHeadContext.class,0);
		}
		public OnameContext oname() {
			return getRuleContext(OnameContext.class,0);
		}
		public VapplicationHeadNamedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vapplicationHeadNamed; }
	}

	public final VapplicationHeadNamedContext vapplicationHeadNamed() throws RecognitionException {
		VapplicationHeadNamedContext _localctx = new VapplicationHeadNamedContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_vapplicationHeadNamed);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			vapplicationHead();
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(341);
				oname();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VapplicationArgsContext extends ParserRuleContext {
		public TerminalNode EOL() { return getToken(EoParser.EOL, 0); }
		public TerminalNode TAB() { return getToken(EoParser.TAB, 0); }
		public VapplicationArgsSpecificContext vapplicationArgsSpecific() {
			return getRuleContext(VapplicationArgsSpecificContext.class,0);
		}
		public TerminalNode UNTAB() { return getToken(EoParser.UNTAB, 0); }
		public VapplicationArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vapplicationArgs; }
	}

	public final VapplicationArgsContext vapplicationArgs() throws RecognitionException {
		VapplicationArgsContext _localctx = new VapplicationArgsContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_vapplicationArgs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			match(EOL);
			setState(345);
			match(TAB);
			setState(346);
			vapplicationArgsSpecific();
			setState(347);
			match(UNTAB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VapplicationArgsReversedContext extends ParserRuleContext {
		public TerminalNode EOL() { return getToken(EoParser.EOL, 0); }
		public TerminalNode TAB() { return getToken(EoParser.TAB, 0); }
		public VapplicationArgUnboundContext vapplicationArgUnbound() {
			return getRuleContext(VapplicationArgUnboundContext.class,0);
		}
		public TerminalNode UNTAB() { return getToken(EoParser.UNTAB, 0); }
		public VapplicationArgsSpecificContext vapplicationArgsSpecific() {
			return getRuleContext(VapplicationArgsSpecificContext.class,0);
		}
		public VapplicationArgsReversedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vapplicationArgsReversed; }
	}

	public final VapplicationArgsReversedContext vapplicationArgsReversed() throws RecognitionException {
		VapplicationArgsReversedContext _localctx = new VapplicationArgsReversedContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_vapplicationArgsReversed);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(EOL);
			setState(350);
			match(TAB);
			setState(351);
			vapplicationArgUnbound();
			setState(353);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2136638010L) != 0)) {
				{
				setState(352);
				vapplicationArgsSpecific();
				}
			}

			setState(355);
			match(UNTAB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VapplicationArgsSpecificContext extends ParserRuleContext {
		public List<VapplicationArgBoundContext> vapplicationArgBound() {
			return getRuleContexts(VapplicationArgBoundContext.class);
		}
		public VapplicationArgBoundContext vapplicationArgBound(int i) {
			return getRuleContext(VapplicationArgBoundContext.class,i);
		}
		public List<VapplicationArgUnboundContext> vapplicationArgUnbound() {
			return getRuleContexts(VapplicationArgUnboundContext.class);
		}
		public VapplicationArgUnboundContext vapplicationArgUnbound(int i) {
			return getRuleContext(VapplicationArgUnboundContext.class,i);
		}
		public VapplicationArgsSpecificContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vapplicationArgsSpecific; }
	}

	public final VapplicationArgsSpecificContext vapplicationArgsSpecific() throws RecognitionException {
		VapplicationArgsSpecificContext _localctx = new VapplicationArgsSpecificContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_vapplicationArgsSpecific);
		int _la;
		try {
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(358); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(357);
					vapplicationArgBound();
					}
					}
					setState(360); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2136638010L) != 0) );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(363); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(362);
					vapplicationArgUnbound();
					}
					}
					setState(365); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2136638010L) != 0) );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VapplicationArgBoundContext extends ParserRuleContext {
		public VapplicationArgBoundCurrentContext vapplicationArgBoundCurrent() {
			return getRuleContext(VapplicationArgBoundCurrentContext.class,0);
		}
		public TerminalNode EOL() { return getToken(EoParser.EOL, 0); }
		public VapplicationArgBoundNextContext vapplicationArgBoundNext() {
			return getRuleContext(VapplicationArgBoundNextContext.class,0);
		}
		public VapplicationArgBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vapplicationArgBound; }
	}

	public final VapplicationArgBoundContext vapplicationArgBound() throws RecognitionException {
		VapplicationArgBoundContext _localctx = new VapplicationArgBoundContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_vapplicationArgBound);
		try {
			setState(373);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(369);
				vapplicationArgBoundCurrent();
				setState(370);
				match(EOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(372);
				vapplicationArgBoundNext();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VapplicationArgBoundCurrentContext extends ParserRuleContext {
		public TerminalNode LB() { return getToken(EoParser.LB, 0); }
		public HapplicationExtendedContext happlicationExtended() {
			return getRuleContext(HapplicationExtendedContext.class,0);
		}
		public TerminalNode RB() { return getToken(EoParser.RB, 0); }
		public AsContext as() {
			return getRuleContext(AsContext.class,0);
		}
		public OnameContext oname() {
			return getRuleContext(OnameContext.class,0);
		}
		public CommentOptionalContext commentOptional() {
			return getRuleContext(CommentOptionalContext.class,0);
		}
		public HanonymContext hanonym() {
			return getRuleContext(HanonymContext.class,0);
		}
		public FnameContext fname() {
			return getRuleContext(FnameContext.class,0);
		}
		public JustContext just() {
			return getRuleContext(JustContext.class,0);
		}
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public VapplicationArgBoundCurrentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vapplicationArgBoundCurrent; }
	}

	public final VapplicationArgBoundCurrentContext vapplicationArgBoundCurrent() throws RecognitionException {
		VapplicationArgBoundCurrentContext _localctx = new VapplicationArgBoundCurrentContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_vapplicationArgBoundCurrent);
		int _la;
		try {
			setState(398);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(375);
				match(LB);
				setState(376);
				happlicationExtended();
				setState(377);
				match(RB);
				setState(378);
				as();
				setState(380);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(379);
					oname();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(382);
				commentOptional();
				setState(383);
				match(LB);
				setState(384);
				hanonym();
				setState(385);
				match(RB);
				setState(386);
				as();
				setState(388);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(387);
					fname();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(392);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(390);
					just();
					}
					break;
				case 2:
					{
					setState(391);
					method();
					}
					break;
				}
				setState(394);
				as();
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(395);
					oname();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VapplicationArgBoundNextContext extends ParserRuleContext {
		public CommentOptionalContext commentOptional() {
			return getRuleContext(CommentOptionalContext.class,0);
		}
		public VoidsContext voids() {
			return getRuleContext(VoidsContext.class,0);
		}
		public AsContext as() {
			return getRuleContext(AsContext.class,0);
		}
		public InnersOrEolContext innersOrEol() {
			return getRuleContext(InnersOrEolContext.class,0);
		}
		public FnameContext fname() {
			return getRuleContext(FnameContext.class,0);
		}
		public VapplicationHeadContext vapplicationHead() {
			return getRuleContext(VapplicationHeadContext.class,0);
		}
		public VapplicationArgsContext vapplicationArgs() {
			return getRuleContext(VapplicationArgsContext.class,0);
		}
		public OnameContext oname() {
			return getRuleContext(OnameContext.class,0);
		}
		public ReversedContext reversed() {
			return getRuleContext(ReversedContext.class,0);
		}
		public VapplicationArgsReversedContext vapplicationArgsReversed() {
			return getRuleContext(VapplicationArgsReversedContext.class,0);
		}
		public VapplicationArgBoundNextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vapplicationArgBoundNext; }
	}

	public final VapplicationArgBoundNextContext vapplicationArgBoundNext() throws RecognitionException {
		VapplicationArgBoundNextContext _localctx = new VapplicationArgBoundNextContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_vapplicationArgBoundNext);
		int _la;
		try {
			setState(422);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(400);
				commentOptional();
				setState(401);
				voids();
				setState(402);
				as();
				setState(404);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(403);
					fname();
					}
				}

				setState(406);
				innersOrEol();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(408);
				vapplicationHead();
				setState(409);
				as();
				setState(411);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(410);
					oname();
					}
				}

				setState(413);
				vapplicationArgs();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(415);
				reversed();
				setState(416);
				as();
				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(417);
					oname();
					}
				}

				setState(420);
				vapplicationArgsReversed();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VapplicationArgUnboundContext extends ParserRuleContext {
		public VapplicationArgUnboundCurrentContext vapplicationArgUnboundCurrent() {
			return getRuleContext(VapplicationArgUnboundCurrentContext.class,0);
		}
		public TerminalNode EOL() { return getToken(EoParser.EOL, 0); }
		public VapplicationArgUnboundNextContext vapplicationArgUnboundNext() {
			return getRuleContext(VapplicationArgUnboundNextContext.class,0);
		}
		public VapplicationArgUnboundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vapplicationArgUnbound; }
	}

	public final VapplicationArgUnboundContext vapplicationArgUnbound() throws RecognitionException {
		VapplicationArgUnboundContext _localctx = new VapplicationArgUnboundContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_vapplicationArgUnbound);
		try {
			setState(428);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(424);
				vapplicationArgUnboundCurrent();
				setState(425);
				match(EOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(427);
				vapplicationArgUnboundNext();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VapplicationArgUnboundCurrentContext extends ParserRuleContext {
		public HapplicationExtendedContext happlicationExtended() {
			return getRuleContext(HapplicationExtendedContext.class,0);
		}
		public OnameContext oname() {
			return getRuleContext(OnameContext.class,0);
		}
		public CommentOptionalContext commentOptional() {
			return getRuleContext(CommentOptionalContext.class,0);
		}
		public HanonymContext hanonym() {
			return getRuleContext(HanonymContext.class,0);
		}
		public FnameContext fname() {
			return getRuleContext(FnameContext.class,0);
		}
		public JustNamedContext justNamed() {
			return getRuleContext(JustNamedContext.class,0);
		}
		public MethodNamedContext methodNamed() {
			return getRuleContext(MethodNamedContext.class,0);
		}
		public VapplicationArgUnboundCurrentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vapplicationArgUnboundCurrent; }
	}

	public final VapplicationArgUnboundCurrentContext vapplicationArgUnboundCurrent() throws RecognitionException {
		VapplicationArgUnboundCurrentContext _localctx = new VapplicationArgUnboundCurrentContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_vapplicationArgUnboundCurrent);
		int _la;
		try {
			setState(441);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(430);
				happlicationExtended();
				setState(432);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(431);
					oname();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(434);
				commentOptional();
				setState(435);
				hanonym();
				setState(437);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(436);
					fname();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(439);
				justNamed();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(440);
				methodNamed();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VapplicationArgUnboundNextContext extends ParserRuleContext {
		public FormationNamedContext formationNamed() {
			return getRuleContext(FormationNamedContext.class,0);
		}
		public VapplicationHeadNamedContext vapplicationHeadNamed() {
			return getRuleContext(VapplicationHeadNamedContext.class,0);
		}
		public VapplicationArgsContext vapplicationArgs() {
			return getRuleContext(VapplicationArgsContext.class,0);
		}
		public ReversedContext reversed() {
			return getRuleContext(ReversedContext.class,0);
		}
		public VapplicationArgsReversedContext vapplicationArgsReversed() {
			return getRuleContext(VapplicationArgsReversedContext.class,0);
		}
		public OnameContext oname() {
			return getRuleContext(OnameContext.class,0);
		}
		public VapplicationArgUnboundNextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vapplicationArgUnboundNext; }
	}

	public final VapplicationArgUnboundNextContext vapplicationArgUnboundNext() throws RecognitionException {
		VapplicationArgUnboundNextContext _localctx = new VapplicationArgUnboundNextContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_vapplicationArgUnboundNext);
		int _la;
		try {
			setState(453);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(443);
				formationNamed();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(444);
				vapplicationHeadNamed();
				setState(445);
				vapplicationArgs();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(447);
				reversed();
				setState(449);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(448);
					oname();
					}
				}

				setState(451);
				vapplicationArgsReversed();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FormationNamedContext extends ParserRuleContext {
		public CommentOptionalContext commentOptional() {
			return getRuleContext(CommentOptionalContext.class,0);
		}
		public VoidsContext voids() {
			return getRuleContext(VoidsContext.class,0);
		}
		public InnersOrEolContext innersOrEol() {
			return getRuleContext(InnersOrEolContext.class,0);
		}
		public FnameContext fname() {
			return getRuleContext(FnameContext.class,0);
		}
		public FormationNamedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formationNamed; }
	}

	public final FormationNamedContext formationNamed() throws RecognitionException {
		FormationNamedContext _localctx = new FormationNamedContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_formationNamed);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			commentOptional();
			setState(456);
			voids();
			setState(458);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(457);
				fname();
				}
			}

			setState(460);
			innersOrEol();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HformationContext extends ParserRuleContext {
		public VoidsContext voids() {
			return getRuleContext(VoidsContext.class,0);
		}
		public List<HanonymInnerContext> hanonymInner() {
			return getRuleContexts(HanonymInnerContext.class);
		}
		public HanonymInnerContext hanonymInner(int i) {
			return getRuleContext(HanonymInnerContext.class,i);
		}
		public HformationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hformation; }
	}

	public final HformationContext hformation() throws RecognitionException {
		HformationContext _localctx = new HformationContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_hformation);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			voids();
			setState(464); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(463);
					hanonymInner();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(466); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HanonymContext extends ParserRuleContext {
		public HformationContext hformation() {
			return getRuleContext(HformationContext.class,0);
		}
		public OnlyphiContext onlyphi() {
			return getRuleContext(OnlyphiContext.class,0);
		}
		public HanonymContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hanonym; }
	}

	public final HanonymContext hanonym() throws RecognitionException {
		HanonymContext _localctx = new HanonymContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_hanonym);
		try {
			setState(470);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(468);
				hformation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(469);
				onlyphi(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OnlyphiContext extends ParserRuleContext {
		public OnlyphiTailContext onlyphiTail() {
			return getRuleContext(OnlyphiTailContext.class,0);
		}
		public HmethodContext hmethod() {
			return getRuleContext(HmethodContext.class,0);
		}
		public HapplicationContext happlication() {
			return getRuleContext(HapplicationContext.class,0);
		}
		public HformationContext hformation() {
			return getRuleContext(HformationContext.class,0);
		}
		public JustContext just() {
			return getRuleContext(JustContext.class,0);
		}
		public OnlyphiContext onlyphi() {
			return getRuleContext(OnlyphiContext.class,0);
		}
		public OnlyphiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_onlyphi; }
	}

	public final OnlyphiContext onlyphi() throws RecognitionException {
		return onlyphi(0);
	}

	private OnlyphiContext onlyphi(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OnlyphiContext _localctx = new OnlyphiContext(_ctx, _parentState);
		OnlyphiContext _prevctx = _localctx;
		int _startState = 90;
		enterRecursionRule(_localctx, 90, RULE_onlyphi, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(477);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				{
				setState(473);
				hmethod();
				}
				break;
			case 2:
				{
				setState(474);
				happlication();
				}
				break;
			case 3:
				{
				setState(475);
				hformation();
				}
				break;
			case 4:
				{
				setState(476);
				just();
				}
				break;
			}
			setState(479);
			onlyphiTail();
			}
			_ctx.stop = _input.LT(-1);
			setState(485);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OnlyphiContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_onlyphi);
					setState(481);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(482);
					onlyphiTail();
					}
					} 
				}
				setState(487);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OnlyphiTailContext extends ParserRuleContext {
		public SpacedArrowContext spacedArrow() {
			return getRuleContext(SpacedArrowContext.class,0);
		}
		public VoidsContext voids() {
			return getRuleContext(VoidsContext.class,0);
		}
		public OnlyphiTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_onlyphiTail; }
	}

	public final OnlyphiTailContext onlyphiTail() throws RecognitionException {
		OnlyphiTailContext _localctx = new OnlyphiTailContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_onlyphiTail);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			spacedArrow();
			setState(489);
			voids();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HanonymInnerContext extends ParserRuleContext {
		public TerminalNode SPACE() { return getToken(EoParser.SPACE, 0); }
		public TerminalNode LB() { return getToken(EoParser.LB, 0); }
		public OnameContext oname() {
			return getRuleContext(OnameContext.class,0);
		}
		public TerminalNode RB() { return getToken(EoParser.RB, 0); }
		public HmethodContext hmethod() {
			return getRuleContext(HmethodContext.class,0);
		}
		public HapplicationContext happlication() {
			return getRuleContext(HapplicationContext.class,0);
		}
		public HanonymContext hanonym() {
			return getRuleContext(HanonymContext.class,0);
		}
		public JustContext just() {
			return getRuleContext(JustContext.class,0);
		}
		public HanonymInnerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hanonymInner; }
	}

	public final HanonymInnerContext hanonymInner() throws RecognitionException {
		HanonymInnerContext _localctx = new HanonymInnerContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_hanonymInner);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			match(SPACE);
			setState(492);
			match(LB);
			setState(497);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				setState(493);
				hmethod();
				}
				break;
			case 2:
				{
				setState(494);
				happlication();
				}
				break;
			case 3:
				{
				setState(495);
				hanonym();
				}
				break;
			case 4:
				{
				setState(496);
				just();
				}
				break;
			}
			setState(499);
			oname();
			setState(500);
			match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodContext extends ParserRuleContext {
		public HmethodContext hmethod() {
			return getRuleContext(HmethodContext.class,0);
		}
		public VmethodContext vmethod() {
			return getRuleContext(VmethodContext.class,0);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_method);
		try {
			setState(504);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(502);
				hmethod();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(503);
				vmethod();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodNamedContext extends ParserRuleContext {
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public OnameContext oname() {
			return getRuleContext(OnameContext.class,0);
		}
		public MethodNamedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodNamed; }
	}

	public final MethodNamedContext methodNamed() throws RecognitionException {
		MethodNamedContext _localctx = new MethodNamedContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_methodNamed);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
			method();
			setState(508);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(507);
				oname();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HmethodContext extends ParserRuleContext {
		public JustContext just() {
			return getRuleContext(JustContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public List<MethodTailContext> methodTail() {
			return getRuleContexts(MethodTailContext.class);
		}
		public MethodTailContext methodTail(int i) {
			return getRuleContext(MethodTailContext.class,i);
		}
		public HmethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hmethod; }
	}

	public final HmethodContext hmethod() throws RecognitionException {
		HmethodContext _localctx = new HmethodContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_hmethod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(512);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ROOT:
			case HOME:
			case STAR:
			case XI:
			case PHI:
			case RHO:
			case BYTES:
			case STRING:
			case INT:
			case FLOAT:
			case HEX:
			case NAME:
			case TEXT:
				{
				setState(510);
				just();
				}
				break;
			case LB:
				{
				setState(511);
				scope();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(515); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(514);
				methodTail();
				}
				}
				setState(517); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DOT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VmethodContext extends ParserRuleContext {
		public VmethodHeadContext vmethodHead() {
			return getRuleContext(VmethodHeadContext.class,0);
		}
		public MethodTailContext methodTail() {
			return getRuleContext(MethodTailContext.class,0);
		}
		public VmethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vmethod; }
	}

	public final VmethodContext vmethod() throws RecognitionException {
		VmethodContext _localctx = new VmethodContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_vmethod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			vmethodHead(0);
			setState(520);
			methodTail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VmethodHeadContext extends ParserRuleContext {
		public VmethodHeadVapplicationContext vmethodHeadVapplication() {
			return getRuleContext(VmethodHeadVapplicationContext.class,0);
		}
		public TerminalNode EOL() { return getToken(EoParser.EOL, 0); }
		public JustNamedContext justNamed() {
			return getRuleContext(JustNamedContext.class,0);
		}
		public HanonymContext hanonym() {
			return getRuleContext(HanonymContext.class,0);
		}
		public OnameContext oname() {
			return getRuleContext(OnameContext.class,0);
		}
		public FormationNamedContext formationNamed() {
			return getRuleContext(FormationNamedContext.class,0);
		}
		public VmethodHeadContext vmethodHead() {
			return getRuleContext(VmethodHeadContext.class,0);
		}
		public MethodTailContext methodTail() {
			return getRuleContext(MethodTailContext.class,0);
		}
		public VmethodHeadApplicationTailContext vmethodHeadApplicationTail() {
			return getRuleContext(VmethodHeadApplicationTailContext.class,0);
		}
		public VmethodHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vmethodHead; }
	}

	public final VmethodHeadContext vmethodHead() throws RecognitionException {
		return vmethodHead(0);
	}

	private VmethodHeadContext vmethodHead(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VmethodHeadContext _localctx = new VmethodHeadContext(_ctx, _parentState);
		VmethodHeadContext _prevctx = _localctx;
		int _startState = 104;
		enterRecursionRule(_localctx, 104, RULE_vmethodHead, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(523);
				vmethodHeadVapplication();
				}
				break;
			case 2:
				{
				setState(529);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
				case 1:
					{
					setState(524);
					justNamed();
					}
					break;
				case 2:
					{
					setState(525);
					hanonym();
					setState(527);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SPACE) {
						{
						setState(526);
						oname();
						}
					}

					}
					break;
				}
				setState(531);
				match(EOL);
				}
				break;
			case 3:
				{
				setState(533);
				formationNamed();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(542);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VmethodHeadContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_vmethodHead);
					setState(536);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(537);
					methodTail();
					setState(538);
					vmethodHeadApplicationTail();
					}
					} 
				}
				setState(544);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VmethodHeadApplicationTailContext extends ParserRuleContext {
		public VapplicationArgsContext vapplicationArgs() {
			return getRuleContext(VapplicationArgsContext.class,0);
		}
		public TerminalNode EOL() { return getToken(EoParser.EOL, 0); }
		public OnameContext oname() {
			return getRuleContext(OnameContext.class,0);
		}
		public HapplicationTailContext happlicationTail() {
			return getRuleContext(HapplicationTailContext.class,0);
		}
		public VmethodHeadApplicationTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vmethodHeadApplicationTail; }
	}

	public final VmethodHeadApplicationTailContext vmethodHeadApplicationTail() throws RecognitionException {
		VmethodHeadApplicationTailContext _localctx = new VmethodHeadApplicationTailContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_vmethodHeadApplicationTail);
		int _la;
		try {
			setState(558);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(546);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(545);
					oname();
					}
				}

				setState(550);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
				case 1:
					{
					setState(548);
					vapplicationArgs();
					}
					break;
				case 2:
					{
					setState(549);
					match(EOL);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(552);
				happlicationTail();
				setState(554);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(553);
					oname();
					}
				}

				setState(556);
				match(EOL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VmethodHeadVapplicationContext extends ParserRuleContext {
		public VapplicationArgsContext vapplicationArgs() {
			return getRuleContext(VapplicationArgsContext.class,0);
		}
		public ApplicableContext applicable() {
			return getRuleContext(ApplicableContext.class,0);
		}
		public HmethodContext hmethod() {
			return getRuleContext(HmethodContext.class,0);
		}
		public OnameContext oname() {
			return getRuleContext(OnameContext.class,0);
		}
		public ReversedContext reversed() {
			return getRuleContext(ReversedContext.class,0);
		}
		public VapplicationArgsReversedContext vapplicationArgsReversed() {
			return getRuleContext(VapplicationArgsReversedContext.class,0);
		}
		public VmethodHeadVapplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vmethodHeadVapplication; }
	}

	public final VmethodHeadVapplicationContext vmethodHeadVapplication() throws RecognitionException {
		VmethodHeadVapplicationContext _localctx = new VmethodHeadVapplicationContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_vmethodHeadVapplication);
		int _la;
		try {
			setState(575);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(562);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
				case 1:
					{
					setState(560);
					applicable();
					}
					break;
				case 2:
					{
					setState(561);
					hmethod();
					}
					break;
				}
				setState(565);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(564);
					oname();
					}
				}

				setState(567);
				vapplicationArgs();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(569);
				reversed();
				setState(571);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(570);
					oname();
					}
				}

				setState(573);
				vapplicationArgsReversed();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodTailContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(EoParser.DOT, 0); }
		public FinisherContext finisher() {
			return getRuleContext(FinisherContext.class,0);
		}
		public TerminalNode TILDE() { return getToken(EoParser.TILDE, 0); }
		public TerminalNode INT() { return getToken(EoParser.INT, 0); }
		public MethodTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodTail; }
	}

	public final MethodTailContext methodTail() throws RecognitionException {
		MethodTailContext _localctx = new MethodTailContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_methodTail);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(577);
			match(DOT);
			setState(581);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PHI:
			case RHO:
			case NAME:
				{
				setState(578);
				finisher();
				}
				break;
			case TILDE:
				{
				setState(579);
				match(TILDE);
				setState(580);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BeginnerContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(EoParser.STAR, 0); }
		public TerminalNode ROOT() { return getToken(EoParser.ROOT, 0); }
		public TerminalNode HOME() { return getToken(EoParser.HOME, 0); }
		public TerminalNode XI() { return getToken(EoParser.XI, 0); }
		public DataContext data() {
			return getRuleContext(DataContext.class,0);
		}
		public BeginnerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beginner; }
	}

	public final BeginnerContext beginner() throws RecognitionException {
		BeginnerContext _localctx = new BeginnerContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_beginner);
		try {
			setState(588);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(583);
				match(STAR);
				}
				break;
			case ROOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(584);
				match(ROOT);
				}
				break;
			case HOME:
				enterOuterAlt(_localctx, 3);
				{
				setState(585);
				match(HOME);
				}
				break;
			case XI:
				enterOuterAlt(_localctx, 4);
				{
				setState(586);
				match(XI);
				}
				break;
			case BYTES:
			case STRING:
			case INT:
			case FLOAT:
			case HEX:
			case TEXT:
				enterOuterAlt(_localctx, 5);
				{
				setState(587);
				data();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FinisherContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(EoParser.NAME, 0); }
		public TerminalNode PHI() { return getToken(EoParser.PHI, 0); }
		public TerminalNode RHO() { return getToken(EoParser.RHO, 0); }
		public FinisherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finisher; }
	}

	public final FinisherContext finisher() throws RecognitionException {
		FinisherContext _localctx = new FinisherContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_finisher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 538443776L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReversedContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(EoParser.DOT, 0); }
		public FinisherContext finisher() {
			return getRuleContext(FinisherContext.class,0);
		}
		public TerminalNode TILDE() { return getToken(EoParser.TILDE, 0); }
		public TerminalNode INT() { return getToken(EoParser.INT, 0); }
		public ReversedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reversed; }
	}

	public final ReversedContext reversed() throws RecognitionException {
		ReversedContext _localctx = new ReversedContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_reversed);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PHI:
			case RHO:
			case NAME:
				{
				setState(592);
				finisher();
				}
				break;
			case TILDE:
				{
				setState(593);
				match(TILDE);
				setState(594);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(597);
			match(DOT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FnameContext extends ParserRuleContext {
		public OnameContext oname() {
			return getRuleContext(OnameContext.class,0);
		}
		public TerminalNode SPACE() { return getToken(EoParser.SPACE, 0); }
		public List<TerminalNode> ARROW() { return getTokens(EoParser.ARROW); }
		public TerminalNode ARROW(int i) {
			return getToken(EoParser.ARROW, i);
		}
		public TerminalNode CONST() { return getToken(EoParser.CONST, 0); }
		public FnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fname; }
	}

	public final FnameContext fname() throws RecognitionException {
		FnameContext _localctx = new FnameContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_fname);
		int _la;
		try {
			setState(606);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(599);
				oname();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(600);
				match(SPACE);
				setState(601);
				match(ARROW);
				setState(602);
				match(ARROW);
				setState(604);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONST) {
					{
					setState(603);
					match(CONST);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OnameContext extends ParserRuleContext {
		public SuffixContext suffix() {
			return getRuleContext(SuffixContext.class,0);
		}
		public TerminalNode CONST() { return getToken(EoParser.CONST, 0); }
		public OnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oname; }
	}

	public final OnameContext oname() throws RecognitionException {
		OnameContext _localctx = new OnameContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_oname);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
			suffix();
			setState(610);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST) {
				{
				setState(609);
				match(CONST);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SuffixContext extends ParserRuleContext {
		public SpacedArrowContext spacedArrow() {
			return getRuleContext(SpacedArrowContext.class,0);
		}
		public TerminalNode PHI() { return getToken(EoParser.PHI, 0); }
		public TerminalNode NAME() { return getToken(EoParser.NAME, 0); }
		public SuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suffix; }
	}

	public final SuffixContext suffix() throws RecognitionException {
		SuffixContext _localctx = new SuffixContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_suffix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612);
			spacedArrow();
			setState(613);
			_la = _input.LA(1);
			if ( !(_la==PHI || _la==NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpacedArrowContext extends ParserRuleContext {
		public List<TerminalNode> SPACE() { return getTokens(EoParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(EoParser.SPACE, i);
		}
		public TerminalNode ARROW() { return getToken(EoParser.ARROW, 0); }
		public SpacedArrowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spacedArrow; }
	}

	public final SpacedArrowContext spacedArrow() throws RecognitionException {
		SpacedArrowContext _localctx = new SpacedArrowContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_spacedArrow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(615);
			match(SPACE);
			setState(616);
			match(ARROW);
			setState(617);
			match(SPACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ScopeContext extends ParserRuleContext {
		public TerminalNode LB() { return getToken(EoParser.LB, 0); }
		public TerminalNode RB() { return getToken(EoParser.RB, 0); }
		public HapplicationContext happlication() {
			return getRuleContext(HapplicationContext.class,0);
		}
		public HanonymContext hanonym() {
			return getRuleContext(HanonymContext.class,0);
		}
		public ScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope; }
	}

	public final ScopeContext scope() throws RecognitionException {
		ScopeContext _localctx = new ScopeContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_scope);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619);
			match(LB);
			setState(622);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				{
				setState(620);
				happlication();
				}
				break;
			case 2:
				{
				setState(621);
				hanonym();
				}
				break;
			}
			setState(624);
			match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AsContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(EoParser.COLON, 0); }
		public TerminalNode NAME() { return getToken(EoParser.NAME, 0); }
		public TerminalNode INT() { return getToken(EoParser.INT, 0); }
		public AsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_as; }
	}

	public final AsContext as() throws RecognitionException {
		AsContext _localctx = new AsContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_as);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(626);
			match(COLON);
			setState(627);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataContext extends ParserRuleContext {
		public TerminalNode BYTES() { return getToken(EoParser.BYTES, 0); }
		public TerminalNode TEXT() { return getToken(EoParser.TEXT, 0); }
		public TerminalNode STRING() { return getToken(EoParser.STRING, 0); }
		public TerminalNode INT() { return getToken(EoParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(EoParser.FLOAT, 0); }
		public TerminalNode HEX() { return getToken(EoParser.HEX, 0); }
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1593835520L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 45:
			return onlyphi_sempred((OnlyphiContext)_localctx, predIndex);
		case 52:
			return vmethodHead_sempred((VmethodHeadContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean onlyphi_sempred(OnlyphiContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean vmethodHead_sempred(VmethodHeadContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001 \u0278\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"+
		"A\u0007A\u0001\u0000\u0003\u0000\u0086\b\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0005\u0002\u0090\b\u0002\n\u0002\f\u0002\u0093\t\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0003\u0003\u009a\b\u0003\u0004"+
		"\u0003\u009c\b\u0003\u000b\u0003\f\u0003\u009d\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0005\u0005\u00a4\b\u0005\n\u0005\f\u0005\u00a7"+
		"\t\u0005\u0001\u0006\u0004\u0006\u00aa\b\u0006\u000b\u0006\f\u0006\u00ab"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00b2\b\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00b8\b\b\u0001\b\u0001\b\u0003"+
		"\b\u00bc\b\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u00c6\b\n\u0001\n\u0001\n\u0003\n\u00ca\b\n\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00ce\b\u000b\u0001\f\u0001\f\u0003\f\u00d2\b\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u00df\b\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00e5\b\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u00e9\b\u0010\u0001\u0010\u0005\u0010\u00ec\b"+
		"\u0010\n\u0010\f\u0010\u00ef\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00f7\b\u0011\n\u0011"+
		"\f\u0011\u00fa\t\u0011\u0003\u0011\u00fc\b\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0003\u0013\u0104\b\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0109\b\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u010f\b\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0115\b\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u011b\b\u0016\u0001\u0017"+
		"\u0001\u0017\u0003\u0017\u011f\b\u0017\u0001\u0018\u0001\u0018\u0003\u0018"+
		"\u0123\b\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0004\u001a\u012b\b\u001a\u000b\u001a\f\u001a\u012c\u0001"+
		"\u001a\u0001\u001a\u0004\u001a\u0131\b\u001a\u000b\u001a\f\u001a\u0132"+
		"\u0003\u001a\u0135\b\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0003\u001c\u013c\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0003\u001d\u0143\b\u001d\u0001\u001d\u0001\u001d"+
		"\u0003\u001d\u0147\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0003\u001e\u014d\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0003\u001f\u0153\b\u001f\u0001 \u0001 \u0003 \u0157\b \u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u0162\b"+
		"\"\u0001\"\u0001\"\u0001#\u0004#\u0167\b#\u000b#\f#\u0168\u0001#\u0004"+
		"#\u016c\b#\u000b#\f#\u016d\u0003#\u0170\b#\u0001$\u0001$\u0001$\u0001"+
		"$\u0003$\u0176\b$\u0001%\u0001%\u0001%\u0001%\u0001%\u0003%\u017d\b%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0003%\u0185\b%\u0001%\u0001%\u0003"+
		"%\u0189\b%\u0001%\u0001%\u0003%\u018d\b%\u0003%\u018f\b%\u0001&\u0001"+
		"&\u0001&\u0001&\u0003&\u0195\b&\u0001&\u0001&\u0001&\u0001&\u0001&\u0003"+
		"&\u019c\b&\u0001&\u0001&\u0001&\u0001&\u0001&\u0003&\u01a3\b&\u0001&\u0001"+
		"&\u0003&\u01a7\b&\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u01ad\b\'\u0001"+
		"(\u0001(\u0003(\u01b1\b(\u0001(\u0001(\u0001(\u0003(\u01b6\b(\u0001(\u0001"+
		"(\u0003(\u01ba\b(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0003)\u01c2"+
		"\b)\u0001)\u0001)\u0003)\u01c6\b)\u0001*\u0001*\u0001*\u0003*\u01cb\b"+
		"*\u0001*\u0001*\u0001+\u0001+\u0004+\u01d1\b+\u000b+\f+\u01d2\u0001,\u0001"+
		",\u0003,\u01d7\b,\u0001-\u0001-\u0001-\u0001-\u0001-\u0003-\u01de\b-\u0001"+
		"-\u0001-\u0001-\u0001-\u0005-\u01e4\b-\n-\f-\u01e7\t-\u0001.\u0001.\u0001"+
		".\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0003/\u01f2\b/\u0001/\u0001"+
		"/\u0001/\u00010\u00010\u00030\u01f9\b0\u00011\u00011\u00031\u01fd\b1\u0001"+
		"2\u00012\u00032\u0201\b2\u00012\u00042\u0204\b2\u000b2\f2\u0205\u0001"+
		"3\u00013\u00013\u00014\u00014\u00014\u00014\u00014\u00034\u0210\b4\u0003"+
		"4\u0212\b4\u00014\u00014\u00014\u00034\u0217\b4\u00014\u00014\u00014\u0001"+
		"4\u00054\u021d\b4\n4\f4\u0220\t4\u00015\u00035\u0223\b5\u00015\u00015"+
		"\u00035\u0227\b5\u00015\u00015\u00035\u022b\b5\u00015\u00015\u00035\u022f"+
		"\b5\u00016\u00016\u00036\u0233\b6\u00016\u00036\u0236\b6\u00016\u0001"+
		"6\u00016\u00016\u00036\u023c\b6\u00016\u00016\u00036\u0240\b6\u00017\u0001"+
		"7\u00017\u00017\u00037\u0246\b7\u00018\u00018\u00018\u00018\u00018\u0003"+
		"8\u024d\b8\u00019\u00019\u0001:\u0001:\u0001:\u0003:\u0254\b:\u0001:\u0001"+
		":\u0001;\u0001;\u0001;\u0001;\u0001;\u0003;\u025d\b;\u0003;\u025f\b;\u0001"+
		"<\u0001<\u0003<\u0263\b<\u0001=\u0001=\u0001=\u0001>\u0001>\u0001>\u0001"+
		">\u0001?\u0001?\u0001?\u0003?\u026f\b?\u0001?\u0001?\u0001@\u0001@\u0001"+
		"@\u0001A\u0001A\u0001A\u0000\u0002ZhB\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDF"+
		"HJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0000\u0005\u0002\u0000\u0013"+
		"\u0013\u001d\u001d\u0003\u0000\u0005\u0005\u0013\u0013\u001d\u001d\u0002"+
		"\u0000\u0013\u0014\u001d\u001d\u0002\u0000\u001a\u001a\u001d\u001d\u0002"+
		"\u0000\u0018\u001c\u001e\u001e\u029a\u0000\u0085\u0001\u0000\u0000\u0000"+
		"\u0002\u008a\u0001\u0000\u0000\u0000\u0004\u0091\u0001\u0000\u0000\u0000"+
		"\u0006\u009b\u0001\u0000\u0000\u0000\b\u009f\u0001\u0000\u0000\u0000\n"+
		"\u00a5\u0001\u0000\u0000\u0000\f\u00a9\u0001\u0000\u0000\u0000\u000e\u00b1"+
		"\u0001\u0000\u0000\u0000\u0010\u00b3\u0001\u0000\u0000\u0000\u0012\u00bd"+
		"\u0001\u0000\u0000\u0000\u0014\u00c9\u0001\u0000\u0000\u0000\u0016\u00cd"+
		"\u0001\u0000\u0000\u0000\u0018\u00cf\u0001\u0000\u0000\u0000\u001a\u00d3"+
		"\u0001\u0000\u0000\u0000\u001c\u00d8\u0001\u0000\u0000\u0000\u001e\u00de"+
		"\u0001\u0000\u0000\u0000 \u00e0\u0001\u0000\u0000\u0000\"\u00f2\u0001"+
		"\u0000\u0000\u0000$\u00ff\u0001\u0000\u0000\u0000&\u0108\u0001\u0000\u0000"+
		"\u0000(\u010e\u0001\u0000\u0000\u0000*\u0114\u0001\u0000\u0000\u0000,"+
		"\u0116\u0001\u0000\u0000\u0000.\u011e\u0001\u0000\u0000\u00000\u0122\u0001"+
		"\u0000\u0000\u00002\u0124\u0001\u0000\u0000\u00004\u0134\u0001\u0000\u0000"+
		"\u00006\u0136\u0001\u0000\u0000\u00008\u013b\u0001\u0000\u0000\u0000:"+
		"\u0146\u0001\u0000\u0000\u0000<\u014c\u0001\u0000\u0000\u0000>\u014e\u0001"+
		"\u0000\u0000\u0000@\u0154\u0001\u0000\u0000\u0000B\u0158\u0001\u0000\u0000"+
		"\u0000D\u015d\u0001\u0000\u0000\u0000F\u016f\u0001\u0000\u0000\u0000H"+
		"\u0175\u0001\u0000\u0000\u0000J\u018e\u0001\u0000\u0000\u0000L\u01a6\u0001"+
		"\u0000\u0000\u0000N\u01ac\u0001\u0000\u0000\u0000P\u01b9\u0001\u0000\u0000"+
		"\u0000R\u01c5\u0001\u0000\u0000\u0000T\u01c7\u0001\u0000\u0000\u0000V"+
		"\u01ce\u0001\u0000\u0000\u0000X\u01d6\u0001\u0000\u0000\u0000Z\u01d8\u0001"+
		"\u0000\u0000\u0000\\\u01e8\u0001\u0000\u0000\u0000^\u01eb\u0001\u0000"+
		"\u0000\u0000`\u01f8\u0001\u0000\u0000\u0000b\u01fa\u0001\u0000\u0000\u0000"+
		"d\u0200\u0001\u0000\u0000\u0000f\u0207\u0001\u0000\u0000\u0000h\u0216"+
		"\u0001\u0000\u0000\u0000j\u022e\u0001\u0000\u0000\u0000l\u023f\u0001\u0000"+
		"\u0000\u0000n\u0241\u0001\u0000\u0000\u0000p\u024c\u0001\u0000\u0000\u0000"+
		"r\u024e\u0001\u0000\u0000\u0000t\u0253\u0001\u0000\u0000\u0000v\u025e"+
		"\u0001\u0000\u0000\u0000x\u0260\u0001\u0000\u0000\u0000z\u0264\u0001\u0000"+
		"\u0000\u0000|\u0267\u0001\u0000\u0000\u0000~\u026b\u0001\u0000\u0000\u0000"+
		"\u0080\u0272\u0001\u0000\u0000\u0000\u0082\u0275\u0001\u0000\u0000\u0000"+
		"\u0084\u0086\u0003\u0004\u0002\u0000\u0085\u0084\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0003\u0006\u0003\u0000\u0088\u0089\u0005\u0000\u0000\u0001"+
		"\u0089\u0001\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u0017\u0000\u0000"+
		"\u008b\u008c\u0005\u0017\u0000\u0000\u008c\u0003\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0005\u0002\u0000\u0000\u008e\u0090\u0005\u0017\u0000\u0000"+
		"\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0093\u0001\u0000\u0000\u0000"+
		"\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000"+
		"\u0092\u0094\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u0005\u0002\u0000\u0000\u0095\u0096\u0003\u0002\u0001\u0000"+
		"\u0096\u0005\u0001\u0000\u0000\u0000\u0097\u0099\u0003\u000e\u0007\u0000"+
		"\u0098\u009a\u0005\u0017\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000"+
		"\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009c\u0001\u0000\u0000\u0000"+
		"\u009b\u0097\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000"+
		"\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000"+
		"\u009e\u0007\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u0001\u0000\u0000"+
		"\u00a0\u00a1\u0005\u0017\u0000\u0000\u00a1\t\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a4\u0003\b\u0004\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a6\u000b\u0001\u0000\u0000\u0000\u00a7\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a8\u00aa\u0003\b\u0004\u0000\u00a9\u00a8\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\r\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ae\u0003\f\u0006\u0000\u00ae\u00af\u0003\u0014\n"+
		"\u0000\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00b2\u0003\u0010\b\u0000"+
		"\u00b1\u00ad\u0001\u0000\u0000\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b2\u000f\u0001\u0000\u0000\u0000\u00b3\u00bb\u0003\n\u0005\u0000\u00b4"+
		"\u00bc\u0003&\u0013\u0000\u00b5\u00b8\u0003b1\u0000\u00b6\u00b8\u0003"+
		"\u0018\f\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005\u0017"+
		"\u0000\u0000\u00ba\u00bc\u0001\u0000\u0000\u0000\u00bb\u00b4\u0001\u0000"+
		"\u0000\u0000\u00bb\u00b7\u0001\u0000\u0000\u0000\u00bc\u0011\u0001\u0000"+
		"\u0000\u0000\u00bd\u00be\u0003\n\u0005\u0000\u00be\u00bf\u0003\u0014\n"+
		"\u0000\u00bf\u0013\u0001\u0000\u0000\u0000\u00c0\u00ca\u0003\u001c\u000e"+
		"\u0000\u00c1\u00c6\u0003\u001a\r\u0000\u00c2\u00c3\u0003X,\u0000\u00c3"+
		"\u00c4\u0003x<\u0000\u00c4\u00c6\u0001\u0000\u0000\u0000\u00c5\u00c1\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c2\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c8\u0005\u0017\u0000\u0000\u00c8\u00ca\u0001"+
		"\u0000\u0000\u0000\u00c9\u00c0\u0001\u0000\u0000\u0000\u00c9\u00c5\u0001"+
		"\u0000\u0000\u0000\u00ca\u0015\u0001\u0000\u0000\u0000\u00cb\u00ce\u0003"+
		"p8\u0000\u00cc\u00ce\u0003r9\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000"+
		"\u00cd\u00cc\u0001\u0000\u0000\u0000\u00ce\u0017\u0001\u0000\u0000\u0000"+
		"\u00cf\u00d1\u0003\u0016\u000b\u0000\u00d0\u00d2\u0003x<\u0000\u00d1\u00d0"+
		"\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u0019"+
		"\u0001\u0000\u0000\u0000\u00d3\u00d4\u0003\"\u0011\u0000\u00d4\u00d5\u0003"+
		"z=\u0000\u00d5\u00d6\u0005\r\u0000\u0000\u00d6\u00d7\u0005\f\u0000\u0000"+
		"\u00d7\u001b\u0001\u0000\u0000\u0000\u00d8\u00d9\u0003\"\u0011\u0000\u00d9"+
		"\u00da\u0003x<\u0000\u00da\u00db\u0003\u001e\u000f\u0000\u00db\u001d\u0001"+
		"\u0000\u0000\u0000\u00dc\u00df\u0003 \u0010\u0000\u00dd\u00df\u0005\u0017"+
		"\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00de\u00dd\u0001\u0000"+
		"\u0000\u0000\u00df\u001f\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005\u0017"+
		"\u0000\u0000\u00e1\u00e4\u0005\u001f\u0000\u0000\u00e2\u00e5\u0003\u0010"+
		"\b\u0000\u00e3\u00e5\u0003\u0012\t\u0000\u00e4\u00e2\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e5\u00ed\u0001\u0000\u0000"+
		"\u0000\u00e6\u00ec\u0003\u0010\b\u0000\u00e7\u00e9\u0005\u0017\u0000\u0000"+
		"\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000"+
		"\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u00ec\u0003\u0012\t\u0000\u00eb"+
		"\u00e6\u0001\u0000\u0000\u0000\u00eb\u00e8\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ef\u0001\u0000\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed"+
		"\u00ee\u0001\u0000\u0000\u0000\u00ee\u00f0\u0001\u0000\u0000\u0000\u00ef"+
		"\u00ed\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005 \u0000\u0000\u00f1!\u0001"+
		"\u0000\u0000\u0000\u00f2\u00fb\u0005\u000f\u0000\u0000\u00f3\u00f8\u0003"+
		"$\u0012\u0000\u00f4\u00f5\u0005\r\u0000\u0000\u00f5\u00f7\u0003$\u0012"+
		"\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f7\u00fa\u0001\u0000\u0000"+
		"\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fc\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000"+
		"\u0000\u00fb\u00f3\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000"+
		"\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005\u0010\u0000"+
		"\u0000\u00fe#\u0001\u0000\u0000\u0000\u00ff\u0100\u0007\u0000\u0000\u0000"+
		"\u0100%\u0001\u0000\u0000\u0000\u0101\u0103\u0003*\u0015\u0000\u0102\u0104"+
		"\u0003x<\u0000\u0103\u0102\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000"+
		"\u0000\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105\u0106\u0005\u0017"+
		"\u0000\u0000\u0106\u0109\u0001\u0000\u0000\u0000\u0107\u0109\u0003:\u001d"+
		"\u0000\u0108\u0101\u0001\u0000\u0000\u0000\u0108\u0107\u0001\u0000\u0000"+
		"\u0000\u0109\'\u0001\u0000\u0000\u0000\u010a\u010b\u0003.\u0017\u0000"+
		"\u010b\u010c\u00034\u001a\u0000\u010c\u010f\u0001\u0000\u0000\u0000\u010d"+
		"\u010f\u0003,\u0016\u0000\u010e\u010a\u0001\u0000\u0000\u0000\u010e\u010d"+
		"\u0001\u0000\u0000\u0000\u010f)\u0001\u0000\u0000\u0000\u0110\u0111\u0003"+
		"0\u0018\u0000\u0111\u0112\u00034\u001a\u0000\u0112\u0115\u0001\u0000\u0000"+
		"\u0000\u0113\u0115\u0003,\u0016\u0000\u0114\u0110\u0001\u0000\u0000\u0000"+
		"\u0114\u0113\u0001\u0000\u0000\u0000\u0115+\u0001\u0000\u0000\u0000\u0116"+
		"\u0117\u0003t:\u0000\u0117\u0118\u0005\r\u0000\u0000\u0118\u011a\u0003"+
		"6\u001b\u0000\u0119\u011b\u00034\u001a\u0000\u011a\u0119\u0001\u0000\u0000"+
		"\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b-\u0001\u0000\u0000\u0000"+
		"\u011c\u011f\u0003d2\u0000\u011d\u011f\u00032\u0019\u0000\u011e\u011c"+
		"\u0001\u0000\u0000\u0000\u011e\u011d\u0001\u0000\u0000\u0000\u011f/\u0001"+
		"\u0000\u0000\u0000\u0120\u0123\u0003f3\u0000\u0121\u0123\u0003.\u0017"+
		"\u0000\u0122\u0120\u0001\u0000\u0000\u0000\u0122\u0121\u0001\u0000\u0000"+
		"\u0000\u01231\u0001\u0000\u0000\u0000\u0124\u0125\u0007\u0001\u0000\u0000"+
		"\u01253\u0001\u0000\u0000\u0000\u0126\u0127\u0005\r\u0000\u0000\u0127"+
		"\u0128\u00038\u001c\u0000\u0128\u0129\u0003\u0080@\u0000\u0129\u012b\u0001"+
		"\u0000\u0000\u0000\u012a\u0126\u0001\u0000\u0000\u0000\u012b\u012c\u0001"+
		"\u0000\u0000\u0000\u012c\u012a\u0001\u0000\u0000\u0000\u012c\u012d\u0001"+
		"\u0000\u0000\u0000\u012d\u0135\u0001\u0000\u0000\u0000\u012e\u012f\u0005"+
		"\r\u0000\u0000\u012f\u0131\u00038\u001c\u0000\u0130\u012e\u0001\u0000"+
		"\u0000\u0000\u0131\u0132\u0001\u0000\u0000\u0000\u0132\u0130\u0001\u0000"+
		"\u0000\u0000\u0132\u0133\u0001\u0000\u0000\u0000\u0133\u0135\u0001\u0000"+
		"\u0000\u0000\u0134\u012a\u0001\u0000\u0000\u0000\u0134\u0130\u0001\u0000"+
		"\u0000\u0000\u01355\u0001\u0000\u0000\u0000\u0136\u0137\u00038\u001c\u0000"+
		"\u01377\u0001\u0000\u0000\u0000\u0138\u013c\u0003\u0016\u000b\u0000\u0139"+
		"\u013c\u0003d2\u0000\u013a\u013c\u0003~?\u0000\u013b\u0138\u0001\u0000"+
		"\u0000\u0000\u013b\u0139\u0001\u0000\u0000\u0000\u013b\u013a\u0001\u0000"+
		"\u0000\u0000\u013c9\u0001\u0000\u0000\u0000\u013d\u013e\u0003@ \u0000"+
		"\u013e\u013f\u0003B!\u0000\u013f\u0147\u0001\u0000\u0000\u0000\u0140\u0142"+
		"\u0003t:\u0000\u0141\u0143\u0003x<\u0000\u0142\u0141\u0001\u0000\u0000"+
		"\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000"+
		"\u0000\u0144\u0145\u0003D\"\u0000\u0145\u0147\u0001\u0000\u0000\u0000"+
		"\u0146\u013d\u0001\u0000\u0000\u0000\u0146\u0140\u0001\u0000\u0000\u0000"+
		"\u0147;\u0001\u0000\u0000\u0000\u0148\u014d\u00032\u0019\u0000\u0149\u014d"+
		"\u0003d2\u0000\u014a\u014d\u0003f3\u0000\u014b\u014d\u0003>\u001f\u0000"+
		"\u014c\u0148\u0001\u0000\u0000\u0000\u014c\u0149\u0001\u0000\u0000\u0000"+
		"\u014c\u014a\u0001\u0000\u0000\u0000\u014c\u014b\u0001\u0000\u0000\u0000"+
		"\u014d=\u0001\u0000\u0000\u0000\u014e\u014f\u0005\u001d\u0000\u0000\u014f"+
		"\u0150\u0005\r\u0000\u0000\u0150\u0152\u0005\u0005\u0000\u0000\u0151\u0153"+
		"\u0005\u001a\u0000\u0000\u0152\u0151\u0001\u0000\u0000\u0000\u0152\u0153"+
		"\u0001\u0000\u0000\u0000\u0153?\u0001\u0000\u0000\u0000\u0154\u0156\u0003"+
		"<\u001e\u0000\u0155\u0157\u0003x<\u0000\u0156\u0155\u0001\u0000\u0000"+
		"\u0000\u0156\u0157\u0001\u0000\u0000\u0000\u0157A\u0001\u0000\u0000\u0000"+
		"\u0158\u0159\u0005\u0017\u0000\u0000\u0159\u015a\u0005\u001f\u0000\u0000"+
		"\u015a\u015b\u0003F#\u0000\u015b\u015c\u0005 \u0000\u0000\u015cC\u0001"+
		"\u0000\u0000\u0000\u015d\u015e\u0005\u0017\u0000\u0000\u015e\u015f\u0005"+
		"\u001f\u0000\u0000\u015f\u0161\u0003N\'\u0000\u0160\u0162\u0003F#\u0000"+
		"\u0161\u0160\u0001\u0000\u0000\u0000\u0161\u0162\u0001\u0000\u0000\u0000"+
		"\u0162\u0163\u0001\u0000\u0000\u0000\u0163\u0164\u0005 \u0000\u0000\u0164"+
		"E\u0001\u0000\u0000\u0000\u0165\u0167\u0003H$\u0000\u0166\u0165\u0001"+
		"\u0000\u0000\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u0168\u0166\u0001"+
		"\u0000\u0000\u0000\u0168\u0169\u0001\u0000\u0000\u0000\u0169\u0170\u0001"+
		"\u0000\u0000\u0000\u016a\u016c\u0003N\'\u0000\u016b\u016a\u0001\u0000"+
		"\u0000\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d\u016b\u0001\u0000"+
		"\u0000\u0000\u016d\u016e\u0001\u0000\u0000\u0000\u016e\u0170\u0001\u0000"+
		"\u0000\u0000\u016f\u0166\u0001\u0000\u0000\u0000\u016f\u016b\u0001\u0000"+
		"\u0000\u0000\u0170G\u0001\u0000\u0000\u0000\u0171\u0172\u0003J%\u0000"+
		"\u0172\u0173\u0005\u0017\u0000\u0000\u0173\u0176\u0001\u0000\u0000\u0000"+
		"\u0174\u0176\u0003L&\u0000\u0175\u0171\u0001\u0000\u0000\u0000\u0175\u0174"+
		"\u0001\u0000\u0000\u0000\u0176I\u0001\u0000\u0000\u0000\u0177\u0178\u0005"+
		"\u0011\u0000\u0000\u0178\u0179\u0003*\u0015\u0000\u0179\u017a\u0005\u0012"+
		"\u0000\u0000\u017a\u017c\u0003\u0080@\u0000\u017b\u017d\u0003x<\u0000"+
		"\u017c\u017b\u0001\u0000\u0000\u0000\u017c\u017d\u0001\u0000\u0000\u0000"+
		"\u017d\u018f\u0001\u0000\u0000\u0000\u017e\u017f\u0003\n\u0005\u0000\u017f"+
		"\u0180\u0005\u0011\u0000\u0000\u0180\u0181\u0003X,\u0000\u0181\u0182\u0005"+
		"\u0012\u0000\u0000\u0182\u0184\u0003\u0080@\u0000\u0183\u0185\u0003v;"+
		"\u0000\u0184\u0183\u0001\u0000\u0000\u0000\u0184\u0185\u0001\u0000\u0000"+
		"\u0000\u0185\u018f\u0001\u0000\u0000\u0000\u0186\u0189\u0003\u0016\u000b"+
		"\u0000\u0187\u0189\u0003`0\u0000\u0188\u0186\u0001\u0000\u0000\u0000\u0188"+
		"\u0187\u0001\u0000\u0000\u0000\u0189\u018a\u0001\u0000\u0000\u0000\u018a"+
		"\u018c\u0003\u0080@\u0000\u018b\u018d\u0003x<\u0000\u018c\u018b\u0001"+
		"\u0000\u0000\u0000\u018c\u018d\u0001\u0000\u0000\u0000\u018d\u018f\u0001"+
		"\u0000\u0000\u0000\u018e\u0177\u0001\u0000\u0000\u0000\u018e\u017e\u0001"+
		"\u0000\u0000\u0000\u018e\u0188\u0001\u0000\u0000\u0000\u018fK\u0001\u0000"+
		"\u0000\u0000\u0190\u0191\u0003\n\u0005\u0000\u0191\u0192\u0003\"\u0011"+
		"\u0000\u0192\u0194\u0003\u0080@\u0000\u0193\u0195\u0003v;\u0000\u0194"+
		"\u0193\u0001\u0000\u0000\u0000\u0194\u0195\u0001\u0000\u0000\u0000\u0195"+
		"\u0196\u0001\u0000\u0000\u0000\u0196\u0197\u0003\u001e\u000f\u0000\u0197"+
		"\u01a7\u0001\u0000\u0000\u0000\u0198\u0199\u0003<\u001e\u0000\u0199\u019b"+
		"\u0003\u0080@\u0000\u019a\u019c\u0003x<\u0000\u019b\u019a\u0001\u0000"+
		"\u0000\u0000\u019b\u019c\u0001\u0000\u0000\u0000\u019c\u019d\u0001\u0000"+
		"\u0000\u0000\u019d\u019e\u0003B!\u0000\u019e\u01a7\u0001\u0000\u0000\u0000"+
		"\u019f\u01a0\u0003t:\u0000\u01a0\u01a2\u0003\u0080@\u0000\u01a1\u01a3"+
		"\u0003x<\u0000\u01a2\u01a1\u0001\u0000\u0000\u0000\u01a2\u01a3\u0001\u0000"+
		"\u0000\u0000\u01a3\u01a4\u0001\u0000\u0000\u0000\u01a4\u01a5\u0003D\""+
		"\u0000\u01a5\u01a7\u0001\u0000\u0000\u0000\u01a6\u0190\u0001\u0000\u0000"+
		"\u0000\u01a6\u0198\u0001\u0000\u0000\u0000\u01a6\u019f\u0001\u0000\u0000"+
		"\u0000\u01a7M\u0001\u0000\u0000\u0000\u01a8\u01a9\u0003P(\u0000\u01a9"+
		"\u01aa\u0005\u0017\u0000\u0000\u01aa\u01ad\u0001\u0000\u0000\u0000\u01ab"+
		"\u01ad\u0003R)\u0000\u01ac\u01a8\u0001\u0000\u0000\u0000\u01ac\u01ab\u0001"+
		"\u0000\u0000\u0000\u01adO\u0001\u0000\u0000\u0000\u01ae\u01b0\u0003*\u0015"+
		"\u0000\u01af\u01b1\u0003x<\u0000\u01b0\u01af\u0001\u0000\u0000\u0000\u01b0"+
		"\u01b1\u0001\u0000\u0000\u0000\u01b1\u01ba\u0001\u0000\u0000\u0000\u01b2"+
		"\u01b3\u0003\n\u0005\u0000\u01b3\u01b5\u0003X,\u0000\u01b4\u01b6\u0003"+
		"v;\u0000\u01b5\u01b4\u0001\u0000\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000"+
		"\u0000\u01b6\u01ba\u0001\u0000\u0000\u0000\u01b7\u01ba\u0003\u0018\f\u0000"+
		"\u01b8\u01ba\u0003b1\u0000\u01b9\u01ae\u0001\u0000\u0000\u0000\u01b9\u01b2"+
		"\u0001\u0000\u0000\u0000\u01b9\u01b7\u0001\u0000\u0000\u0000\u01b9\u01b8"+
		"\u0001\u0000\u0000\u0000\u01baQ\u0001\u0000\u0000\u0000\u01bb\u01c6\u0003"+
		"T*\u0000\u01bc\u01bd\u0003@ \u0000\u01bd\u01be\u0003B!\u0000\u01be\u01c6"+
		"\u0001\u0000\u0000\u0000\u01bf\u01c1\u0003t:\u0000\u01c0\u01c2\u0003x"+
		"<\u0000\u01c1\u01c0\u0001\u0000\u0000\u0000\u01c1\u01c2\u0001\u0000\u0000"+
		"\u0000\u01c2\u01c3\u0001\u0000\u0000\u0000\u01c3\u01c4\u0003D\"\u0000"+
		"\u01c4\u01c6\u0001\u0000\u0000\u0000\u01c5\u01bb\u0001\u0000\u0000\u0000"+
		"\u01c5\u01bc\u0001\u0000\u0000\u0000\u01c5\u01bf\u0001\u0000\u0000\u0000"+
		"\u01c6S\u0001\u0000\u0000\u0000\u01c7\u01c8\u0003\n\u0005\u0000\u01c8"+
		"\u01ca\u0003\"\u0011\u0000\u01c9\u01cb\u0003v;\u0000\u01ca\u01c9\u0001"+
		"\u0000\u0000\u0000\u01ca\u01cb\u0001\u0000\u0000\u0000\u01cb\u01cc\u0001"+
		"\u0000\u0000\u0000\u01cc\u01cd\u0003\u001e\u000f\u0000\u01cdU\u0001\u0000"+
		"\u0000\u0000\u01ce\u01d0\u0003\"\u0011\u0000\u01cf\u01d1\u0003^/\u0000"+
		"\u01d0\u01cf\u0001\u0000\u0000\u0000\u01d1\u01d2\u0001\u0000\u0000\u0000"+
		"\u01d2\u01d0\u0001\u0000\u0000\u0000\u01d2\u01d3\u0001\u0000\u0000\u0000"+
		"\u01d3W\u0001\u0000\u0000\u0000\u01d4\u01d7\u0003V+\u0000\u01d5\u01d7"+
		"\u0003Z-\u0000\u01d6\u01d4\u0001\u0000\u0000\u0000\u01d6\u01d5\u0001\u0000"+
		"\u0000\u0000\u01d7Y\u0001\u0000\u0000\u0000\u01d8\u01dd\u0006-\uffff\uffff"+
		"\u0000\u01d9\u01de\u0003d2\u0000\u01da\u01de\u0003(\u0014\u0000\u01db"+
		"\u01de\u0003V+\u0000\u01dc\u01de\u0003\u0016\u000b\u0000\u01dd\u01d9\u0001"+
		"\u0000\u0000\u0000\u01dd\u01da\u0001\u0000\u0000\u0000\u01dd\u01db\u0001"+
		"\u0000\u0000\u0000\u01dd\u01dc\u0001\u0000\u0000\u0000\u01de\u01df\u0001"+
		"\u0000\u0000\u0000\u01df\u01e0\u0003\\.\u0000\u01e0\u01e5\u0001\u0000"+
		"\u0000\u0000\u01e1\u01e2\n\u0001\u0000\u0000\u01e2\u01e4\u0003\\.\u0000"+
		"\u01e3\u01e1\u0001\u0000\u0000\u0000\u01e4\u01e7\u0001\u0000\u0000\u0000"+
		"\u01e5\u01e3\u0001\u0000\u0000\u0000\u01e5\u01e6\u0001\u0000\u0000\u0000"+
		"\u01e6[\u0001\u0000\u0000\u0000\u01e7\u01e5\u0001\u0000\u0000\u0000\u01e8"+
		"\u01e9\u0003|>\u0000\u01e9\u01ea\u0003\"\u0011\u0000\u01ea]\u0001\u0000"+
		"\u0000\u0000\u01eb\u01ec\u0005\r\u0000\u0000\u01ec\u01f1\u0005\u0011\u0000"+
		"\u0000\u01ed\u01f2\u0003d2\u0000\u01ee\u01f2\u0003(\u0014\u0000\u01ef"+
		"\u01f2\u0003X,\u0000\u01f0\u01f2\u0003\u0016\u000b\u0000\u01f1\u01ed\u0001"+
		"\u0000\u0000\u0000\u01f1\u01ee\u0001\u0000\u0000\u0000\u01f1\u01ef\u0001"+
		"\u0000\u0000\u0000\u01f1\u01f0\u0001\u0000\u0000\u0000\u01f2\u01f3\u0001"+
		"\u0000\u0000\u0000\u01f3\u01f4\u0003x<\u0000\u01f4\u01f5\u0005\u0012\u0000"+
		"\u0000\u01f5_\u0001\u0000\u0000\u0000\u01f6\u01f9\u0003d2\u0000\u01f7"+
		"\u01f9\u0003f3\u0000\u01f8\u01f6\u0001\u0000\u0000\u0000\u01f8\u01f7\u0001"+
		"\u0000\u0000\u0000\u01f9a\u0001\u0000\u0000\u0000\u01fa\u01fc\u0003`0"+
		"\u0000\u01fb\u01fd\u0003x<\u0000\u01fc\u01fb\u0001\u0000\u0000\u0000\u01fc"+
		"\u01fd\u0001\u0000\u0000\u0000\u01fdc\u0001\u0000\u0000\u0000\u01fe\u0201"+
		"\u0003\u0016\u000b\u0000\u01ff\u0201\u0003~?\u0000\u0200\u01fe\u0001\u0000"+
		"\u0000\u0000\u0200\u01ff\u0001\u0000\u0000\u0000\u0201\u0203\u0001\u0000"+
		"\u0000\u0000\u0202\u0204\u0003n7\u0000\u0203\u0202\u0001\u0000\u0000\u0000"+
		"\u0204\u0205\u0001\u0000\u0000\u0000\u0205\u0203\u0001\u0000\u0000\u0000"+
		"\u0205\u0206\u0001\u0000\u0000\u0000\u0206e\u0001\u0000\u0000\u0000\u0207"+
		"\u0208\u0003h4\u0000\u0208\u0209\u0003n7\u0000\u0209g\u0001\u0000\u0000"+
		"\u0000\u020a\u020b\u00064\uffff\uffff\u0000\u020b\u0217\u0003l6\u0000"+
		"\u020c\u0212\u0003\u0018\f\u0000\u020d\u020f\u0003X,\u0000\u020e\u0210"+
		"\u0003x<\u0000\u020f\u020e\u0001\u0000\u0000\u0000\u020f\u0210\u0001\u0000"+
		"\u0000\u0000\u0210\u0212\u0001\u0000\u0000\u0000\u0211\u020c\u0001\u0000"+
		"\u0000\u0000\u0211\u020d\u0001\u0000\u0000\u0000\u0212\u0213\u0001\u0000"+
		"\u0000\u0000\u0213\u0214\u0005\u0017\u0000\u0000\u0214\u0217\u0001\u0000"+
		"\u0000\u0000\u0215\u0217\u0003T*\u0000\u0216\u020a\u0001\u0000\u0000\u0000"+
		"\u0216\u0211\u0001\u0000\u0000\u0000\u0216\u0215\u0001\u0000\u0000\u0000"+
		"\u0217\u021e\u0001\u0000\u0000\u0000\u0218\u0219\n\u0004\u0000\u0000\u0219"+
		"\u021a\u0003n7\u0000\u021a\u021b\u0003j5\u0000\u021b\u021d\u0001\u0000"+
		"\u0000\u0000\u021c\u0218\u0001\u0000\u0000\u0000\u021d\u0220\u0001\u0000"+
		"\u0000\u0000\u021e\u021c\u0001\u0000\u0000\u0000\u021e\u021f\u0001\u0000"+
		"\u0000\u0000\u021fi\u0001\u0000\u0000\u0000\u0220\u021e\u0001\u0000\u0000"+
		"\u0000\u0221\u0223\u0003x<\u0000\u0222\u0221\u0001\u0000\u0000\u0000\u0222"+
		"\u0223\u0001\u0000\u0000\u0000\u0223\u0226\u0001\u0000\u0000\u0000\u0224"+
		"\u0227\u0003B!\u0000\u0225\u0227\u0005\u0017\u0000\u0000\u0226\u0224\u0001"+
		"\u0000\u0000\u0000\u0226\u0225\u0001\u0000\u0000\u0000\u0227\u022f\u0001"+
		"\u0000\u0000\u0000\u0228\u022a\u00034\u001a\u0000\u0229\u022b\u0003x<"+
		"\u0000\u022a\u0229\u0001\u0000\u0000\u0000\u022a\u022b\u0001\u0000\u0000"+
		"\u0000\u022b\u022c\u0001\u0000\u0000\u0000\u022c\u022d\u0005\u0017\u0000"+
		"\u0000\u022d\u022f\u0001\u0000\u0000\u0000\u022e\u0222\u0001\u0000\u0000"+
		"\u0000\u022e\u0228\u0001\u0000\u0000\u0000\u022fk\u0001\u0000\u0000\u0000"+
		"\u0230\u0233\u00032\u0019\u0000\u0231\u0233\u0003d2\u0000\u0232\u0230"+
		"\u0001\u0000\u0000\u0000\u0232\u0231\u0001\u0000\u0000\u0000\u0233\u0235"+
		"\u0001\u0000\u0000\u0000\u0234\u0236\u0003x<\u0000\u0235\u0234\u0001\u0000"+
		"\u0000\u0000\u0235\u0236\u0001\u0000\u0000\u0000\u0236\u0237\u0001\u0000"+
		"\u0000\u0000\u0237\u0238\u0003B!\u0000\u0238\u0240\u0001\u0000\u0000\u0000"+
		"\u0239\u023b\u0003t:\u0000\u023a\u023c\u0003x<\u0000\u023b\u023a\u0001"+
		"\u0000\u0000\u0000\u023b\u023c\u0001\u0000\u0000\u0000\u023c\u023d\u0001"+
		"\u0000\u0000\u0000\u023d\u023e\u0003D\"\u0000\u023e\u0240\u0001\u0000"+
		"\u0000\u0000\u023f\u0232\u0001\u0000\u0000\u0000\u023f\u0239\u0001\u0000"+
		"\u0000\u0000\u0240m\u0001\u0000\u0000\u0000\u0241\u0245\u0005\u000e\u0000"+
		"\u0000\u0242\u0246\u0003r9\u0000\u0243\u0244\u0005\u0016\u0000\u0000\u0244"+
		"\u0246\u0005\u001a\u0000\u0000\u0245\u0242\u0001\u0000\u0000\u0000\u0245"+
		"\u0243\u0001\u0000\u0000\u0000\u0246o\u0001\u0000\u0000\u0000\u0247\u024d"+
		"\u0005\u0005\u0000\u0000\u0248\u024d\u0005\u0003\u0000\u0000\u0249\u024d"+
		"\u0005\u0004\u0000\u0000\u024a\u024d\u0005\t\u0000\u0000\u024b\u024d\u0003"+
		"\u0082A\u0000\u024c\u0247\u0001\u0000\u0000\u0000\u024c\u0248\u0001\u0000"+
		"\u0000\u0000\u024c\u0249\u0001\u0000\u0000\u0000\u024c\u024a\u0001\u0000"+
		"\u0000\u0000\u024c\u024b\u0001\u0000\u0000\u0000\u024dq\u0001\u0000\u0000"+
		"\u0000\u024e\u024f\u0007\u0002\u0000\u0000\u024fs\u0001\u0000\u0000\u0000"+
		"\u0250\u0254\u0003r9\u0000\u0251\u0252\u0005\u0016\u0000\u0000\u0252\u0254"+
		"\u0005\u001a\u0000\u0000\u0253\u0250\u0001\u0000\u0000\u0000\u0253\u0251"+
		"\u0001\u0000\u0000\u0000\u0254\u0255\u0001\u0000\u0000\u0000\u0255\u0256"+
		"\u0005\u000e\u0000\u0000\u0256u\u0001\u0000\u0000\u0000\u0257\u025f\u0003"+
		"x<\u0000\u0258\u0259\u0005\r\u0000\u0000\u0259\u025a\u0005\b\u0000\u0000"+
		"\u025a\u025c\u0005\b\u0000\u0000\u025b\u025d\u0005\u0006\u0000\u0000\u025c"+
		"\u025b\u0001\u0000\u0000\u0000\u025c\u025d\u0001\u0000\u0000\u0000\u025d"+
		"\u025f\u0001\u0000\u0000\u0000\u025e\u0257\u0001\u0000\u0000\u0000\u025e"+
		"\u0258\u0001\u0000\u0000\u0000\u025fw\u0001\u0000\u0000\u0000\u0260\u0262"+
		"\u0003z=\u0000\u0261\u0263\u0005\u0006\u0000\u0000\u0262\u0261\u0001\u0000"+
		"\u0000\u0000\u0262\u0263\u0001\u0000\u0000\u0000\u0263y\u0001\u0000\u0000"+
		"\u0000\u0264\u0265\u0003|>\u0000\u0265\u0266\u0007\u0000\u0000\u0000\u0266"+
		"{\u0001\u0000\u0000\u0000\u0267\u0268\u0005\r\u0000\u0000\u0268\u0269"+
		"\u0005\b\u0000\u0000\u0269\u026a\u0005\r\u0000\u0000\u026a}\u0001\u0000"+
		"\u0000\u0000\u026b\u026e\u0005\u0011\u0000\u0000\u026c\u026f\u0003(\u0014"+
		"\u0000\u026d\u026f\u0003X,\u0000\u026e\u026c\u0001\u0000\u0000\u0000\u026e"+
		"\u026d\u0001\u0000\u0000\u0000\u026f\u0270\u0001\u0000\u0000\u0000\u0270"+
		"\u0271\u0005\u0012\u0000\u0000\u0271\u007f\u0001\u0000\u0000\u0000\u0272"+
		"\u0273\u0005\u0007\u0000\u0000\u0273\u0274\u0007\u0003\u0000\u0000\u0274"+
		"\u0081\u0001\u0000\u0000\u0000\u0275\u0276\u0007\u0004\u0000\u0000\u0276"+
		"\u0083\u0001\u0000\u0000\u0000U\u0085\u0091\u0099\u009d\u00a5\u00ab\u00b1"+
		"\u00b7\u00bb\u00c5\u00c9\u00cd\u00d1\u00de\u00e4\u00e8\u00eb\u00ed\u00f8"+
		"\u00fb\u0103\u0108\u010e\u0114\u011a\u011e\u0122\u012c\u0132\u0134\u013b"+
		"\u0142\u0146\u014c\u0152\u0156\u0161\u0168\u016d\u016f\u0175\u017c\u0184"+
		"\u0188\u018c\u018e\u0194\u019b\u01a2\u01a6\u01ac\u01b0\u01b5\u01b9\u01c1"+
		"\u01c5\u01ca\u01d2\u01d6\u01dd\u01e5\u01f1\u01f8\u01fc\u0200\u0205\u020f"+
		"\u0211\u0216\u021e\u0222\u0226\u022a\u022e\u0232\u0235\u023b\u023f\u0245"+
		"\u024c\u0253\u025c\u025e\u0262\u026e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}