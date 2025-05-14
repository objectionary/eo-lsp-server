// Generated from /home/gasabaev/gh_repos/eo-lsp-server/testFixture/Program.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ProgramParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, META=2, ROOT=3, HOME=4, STAR=5, DOTS=6, CONST=7, SLASH=8, COLON=9, 
		COPY=10, ARROW=11, VERTEX=12, SIGMA=13, XI=14, PLUS=15, MINUS=16, QUESTION=17, 
		SPACE=18, DOT=19, LSQ=20, RSQ=21, LB=22, RB=23, AT=24, RHO=25, HASH=26, 
		EOL=27, BYTES=28, BOOL=29, STRING=30, INT=31, FLOAT=32, HEX=33, NAME=34, 
		TEXT=35, TAB=36, UNTAB=37;
	public static final int
		RULE_program = 0, RULE_license = 1, RULE_metas = 2, RULE_objects = 3, 
		RULE_object = 4, RULE_abstraction = 5, RULE_attributes = 6, RULE_attribute = 7, 
		RULE_label = 8, RULE_tail = 9, RULE_suffix = 10, RULE_method = 11, RULE_scope = 12, 
		RULE_application = 13, RULE_htail = 14, RULE_head = 15, RULE_has = 16, 
		RULE_data = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "license", "metas", "objects", "object", "abstraction", "attributes", 
			"attribute", "label", "tail", "suffix", "method", "scope", "application", 
			"htail", "head", "has", "data"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'Q'", "'QQ'", "'*'", "'...'", "'!'", "'/'", "':'", 
			"'''", "'>'", "'<'", "'&'", "'$'", "'+'", "'-'", "'?'", "' '", "'.'", 
			"'['", "']'", "'('", "')'", "'@'", "'^'", "'#'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "META", "ROOT", "HOME", "STAR", "DOTS", "CONST", "SLASH", 
			"COLON", "COPY", "ARROW", "VERTEX", "SIGMA", "XI", "PLUS", "MINUS", "QUESTION", 
			"SPACE", "DOT", "LSQ", "RSQ", "LB", "RB", "AT", "RHO", "HASH", "EOL", 
			"BYTES", "BOOL", "STRING", "INT", "FLOAT", "HEX", "NAME", "TEXT", "TAB", 
			"UNTAB"
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
	public String getGrammarFileName() { return "Program.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ProgramParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public ObjectsContext objects() {
			return getRuleContext(ObjectsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ProgramParser.EOF, 0); }
		public LicenseContext license() {
			return getRuleContext(LicenseContext.class,0);
		}
		public MetasContext metas() {
			return getRuleContext(MetasContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(36);
				license();
				}
				break;
			}
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==META) {
				{
				setState(39);
				metas();
				}
			}

			setState(42);
			objects();
			setState(43);
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
	public static class LicenseContext extends ParserRuleContext {
		public List<TerminalNode> COMMENT() { return getTokens(ProgramParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(ProgramParser.COMMENT, i);
		}
		public List<TerminalNode> EOL() { return getTokens(ProgramParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(ProgramParser.EOL, i);
		}
		public LicenseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_license; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).enterLicense(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).exitLicense(this);
		}
	}

	public final LicenseContext license() throws RecognitionException {
		LicenseContext _localctx = new LicenseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_license);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(47); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(45);
					match(COMMENT);
					setState(46);
					match(EOL);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(49); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
	public static class MetasContext extends ParserRuleContext {
		public List<TerminalNode> META() { return getTokens(ProgramParser.META); }
		public TerminalNode META(int i) {
			return getToken(ProgramParser.META, i);
		}
		public List<TerminalNode> EOL() { return getTokens(ProgramParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(ProgramParser.EOL, i);
		}
		public MetasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).enterMetas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).exitMetas(this);
		}
	}

	public final MetasContext metas() throws RecognitionException {
		MetasContext _localctx = new MetasContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_metas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(51);
				match(META);
				setState(52);
				match(EOL);
				}
				}
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==META );
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
		public List<TerminalNode> EOL() { return getTokens(ProgramParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(ProgramParser.EOL, i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(ProgramParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(ProgramParser.COMMENT, i);
		}
		public ObjectsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objects; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).enterObjects(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).exitObjects(this);
		}
	}

	public final ObjectsContext objects() throws RecognitionException {
		ObjectsContext _localctx = new ObjectsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_objects);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(67); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(61);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(57);
						match(COMMENT);
						setState(58);
						match(EOL);
						}
						} 
					}
					setState(63);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(64);
				object();
				setState(65);
				match(EOL);
				}
				}
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 68506640506L) != 0) );
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
		public AbstractionContext abstraction() {
			return getRuleContext(AbstractionContext.class,0);
		}
		public ApplicationContext application() {
			return getRuleContext(ApplicationContext.class,0);
		}
		public List<TailContext> tail() {
			return getRuleContexts(TailContext.class);
		}
		public TailContext tail(int i) {
			return getRuleContext(TailContext.class,i);
		}
		public List<TerminalNode> EOL() { return getTokens(ProgramParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(ProgramParser.EOL, i);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public List<HtailContext> htail() {
			return getRuleContexts(HtailContext.class);
		}
		public HtailContext htail(int i) {
			return getRuleContext(HtailContext.class,i);
		}
		public List<SuffixContext> suffix() {
			return getRuleContexts(SuffixContext.class);
		}
		public SuffixContext suffix(int i) {
			return getRuleContext(SuffixContext.class,i);
		}
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).exitObject(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_object);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(71);
				abstraction();
				}
				break;
			case 2:
				{
				setState(72);
				application(0);
				}
				break;
			}
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(75);
				tail();
				}
				break;
			}
			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(78);
					match(EOL);
					setState(79);
					method();
					setState(81);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						setState(80);
						htail();
						}
						break;
					}
					setState(84);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SPACE) {
						{
						setState(83);
						suffix();
						}
					}

					setState(87);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						setState(86);
						tail();
						}
						break;
					}
					}
					} 
				}
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
	public static class AbstractionContext extends ParserRuleContext {
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public List<TerminalNode> COMMENT() { return getTokens(ProgramParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(ProgramParser.COMMENT, i);
		}
		public List<TerminalNode> EOL() { return getTokens(ProgramParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(ProgramParser.EOL, i);
		}
		public HtailContext htail() {
			return getRuleContext(HtailContext.class,0);
		}
		public SuffixContext suffix() {
			return getRuleContext(SuffixContext.class,0);
		}
		public TerminalNode SPACE() { return getToken(ProgramParser.SPACE, 0); }
		public TerminalNode SLASH() { return getToken(ProgramParser.SLASH, 0); }
		public TerminalNode NAME() { return getToken(ProgramParser.NAME, 0); }
		public TerminalNode QUESTION() { return getToken(ProgramParser.QUESTION, 0); }
		public AbstractionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstraction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).enterAbstraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).exitAbstraction(this);
		}
	}

	public final AbstractionContext abstraction() throws RecognitionException {
		AbstractionContext _localctx = new AbstractionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_abstraction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(94);
				match(COMMENT);
				setState(95);
				match(EOL);
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
			attributes();
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				{
				setState(102);
				suffix();
				setState(106);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(103);
					match(SPACE);
					setState(104);
					match(SLASH);
					setState(105);
					_la = _input.LA(1);
					if ( !(_la==QUESTION || _la==NAME) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				}
				}
				break;
			case 2:
				{
				setState(108);
				htail();
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
	public static class AttributesContext extends ParserRuleContext {
		public TerminalNode LSQ() { return getToken(ProgramParser.LSQ, 0); }
		public TerminalNode RSQ() { return getToken(ProgramParser.RSQ, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<TerminalNode> SPACE() { return getTokens(ProgramParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(ProgramParser.SPACE, i);
		}
		public AttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).enterAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).exitAttributes(this);
		}
	}

	public final AttributesContext attributes() throws RecognitionException {
		AttributesContext _localctx = new AttributesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_attributes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(LSQ);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT || _la==NAME) {
				{
				setState(112);
				attribute();
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACE) {
					{
					{
					setState(113);
					match(SPACE);
					setState(114);
					attribute();
					}
					}
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(122);
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
	public static class AttributeContext extends ParserRuleContext {
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			label();
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
	public static class LabelContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(ProgramParser.AT, 0); }
		public TerminalNode NAME() { return getToken(ProgramParser.NAME, 0); }
		public TerminalNode DOTS() { return getToken(ProgramParser.DOTS, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).exitLabel(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_label);
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(AT);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				match(NAME);
				setState(129);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(128);
					match(DOTS);
					}
					break;
				}
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
	public static class TailContext extends ParserRuleContext {
		public List<TerminalNode> EOL() { return getTokens(ProgramParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(ProgramParser.EOL, i);
		}
		public TerminalNode TAB() { return getToken(ProgramParser.TAB, 0); }
		public TerminalNode UNTAB() { return getToken(ProgramParser.UNTAB, 0); }
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public TailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).enterTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).exitTail(this);
		}
	}

	public final TailContext tail() throws RecognitionException {
		TailContext _localctx = new TailContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(EOL);
			setState(134);
			match(TAB);
			setState(138); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(135);
				object();
				setState(136);
				match(EOL);
				}
				}
				setState(140); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 68506640506L) != 0) );
			setState(142);
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
	public static class SuffixContext extends ParserRuleContext {
		public List<TerminalNode> SPACE() { return getTokens(ProgramParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(ProgramParser.SPACE, i);
		}
		public TerminalNode ARROW() { return getToken(ProgramParser.ARROW, 0); }
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public TerminalNode CONST() { return getToken(ProgramParser.CONST, 0); }
		public SuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).enterSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).exitSuffix(this);
		}
	}

	public final SuffixContext suffix() throws RecognitionException {
		SuffixContext _localctx = new SuffixContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_suffix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(SPACE);
			setState(145);
			match(ARROW);
			setState(146);
			match(SPACE);
			setState(147);
			label();
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(148);
				match(CONST);
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
	public static class MethodContext extends ParserRuleContext {
		public Token mtd;
		public TerminalNode DOT() { return getToken(ProgramParser.DOT, 0); }
		public TerminalNode NAME() { return getToken(ProgramParser.NAME, 0); }
		public TerminalNode RHO() { return getToken(ProgramParser.RHO, 0); }
		public TerminalNode SIGMA() { return getToken(ProgramParser.SIGMA, 0); }
		public TerminalNode AT() { return getToken(ProgramParser.AT, 0); }
		public TerminalNode VERTEX() { return getToken(ProgramParser.VERTEX, 0); }
		public TerminalNode COPY() { return getToken(ProgramParser.COPY, 0); }
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).exitMethod(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(DOT);
			setState(152);
			((MethodContext)_localctx).mtd = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 17230213120L) != 0)) ) {
				((MethodContext)_localctx).mtd = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(153);
				match(COPY);
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
	public static class ScopeContext extends ParserRuleContext {
		public TerminalNode LB() { return getToken(ProgramParser.LB, 0); }
		public ApplicationContext application() {
			return getRuleContext(ApplicationContext.class,0);
		}
		public TerminalNode RB() { return getToken(ProgramParser.RB, 0); }
		public ScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).enterScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).exitScope(this);
		}
	}

	public final ScopeContext scope() throws RecognitionException {
		ScopeContext _localctx = new ScopeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_scope);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(LB);
			setState(157);
			application(0);
			setState(158);
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
	public static class ApplicationContext extends ParserRuleContext {
		public HeadContext head() {
			return getRuleContext(HeadContext.class,0);
		}
		public HtailContext htail() {
			return getRuleContext(HtailContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public ApplicationContext application() {
			return getRuleContext(ApplicationContext.class,0);
		}
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public HasContext has() {
			return getRuleContext(HasContext.class,0);
		}
		public SuffixContext suffix() {
			return getRuleContext(SuffixContext.class,0);
		}
		public ApplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_application; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).enterApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).exitApplication(this);
		}
	}

	public final ApplicationContext application() throws RecognitionException {
		return application(0);
	}

	private ApplicationContext application(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ApplicationContext _localctx = new ApplicationContext(_ctx, _parentState);
		ApplicationContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_application, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMENT:
			case ROOT:
			case HOME:
			case STAR:
			case DOTS:
			case SIGMA:
			case XI:
			case LSQ:
			case AT:
			case RHO:
			case BYTES:
			case BOOL:
			case STRING:
			case INT:
			case FLOAT:
			case HEX:
			case NAME:
			case TEXT:
				{
				setState(161);
				head();
				setState(163);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(162);
					htail();
					}
					break;
				}
				}
				break;
			case LB:
				{
				setState(165);
				scope();
				setState(167);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(166);
					htail();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(188);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(186);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new ApplicationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_application);
						setState(171);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(172);
						method();
						setState(174);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
						case 1:
							{
							setState(173);
							htail();
							}
							break;
						}
						}
						break;
					case 2:
						{
						_localctx = new ApplicationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_application);
						setState(176);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(177);
						has();
						setState(179);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
						case 1:
							{
							setState(178);
							htail();
							}
							break;
						}
						}
						break;
					case 3:
						{
						_localctx = new ApplicationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_application);
						setState(181);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(182);
						suffix();
						setState(184);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
						case 1:
							{
							setState(183);
							htail();
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(190);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
	public static class HtailContext extends ParserRuleContext {
		public List<TerminalNode> SPACE() { return getTokens(ProgramParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(ProgramParser.SPACE, i);
		}
		public List<ApplicationContext> application() {
			return getRuleContexts(ApplicationContext.class);
		}
		public ApplicationContext application(int i) {
			return getRuleContext(ApplicationContext.class,i);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public List<HeadContext> head() {
			return getRuleContexts(HeadContext.class);
		}
		public HeadContext head(int i) {
			return getRuleContext(HeadContext.class,i);
		}
		public List<ScopeContext> scope() {
			return getRuleContexts(ScopeContext.class);
		}
		public ScopeContext scope(int i) {
			return getRuleContext(ScopeContext.class,i);
		}
		public List<HasContext> has() {
			return getRuleContexts(HasContext.class);
		}
		public HasContext has(int i) {
			return getRuleContext(HasContext.class,i);
		}
		public List<SuffixContext> suffix() {
			return getRuleContexts(SuffixContext.class);
		}
		public SuffixContext suffix(int i) {
			return getRuleContext(SuffixContext.class,i);
		}
		public List<AbstractionContext> abstraction() {
			return getRuleContexts(AbstractionContext.class);
		}
		public AbstractionContext abstraction(int i) {
			return getRuleContext(AbstractionContext.class,i);
		}
		public HtailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).enterHtail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).exitHtail(this);
		}
	}

	public final HtailContext htail() throws RecognitionException {
		HtailContext _localctx = new HtailContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_htail);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(209); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(209);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						setState(191);
						match(SPACE);
						setState(192);
						application(0);
						setState(193);
						method();
						}
						break;
					case 2:
						{
						setState(195);
						match(SPACE);
						setState(196);
						head();
						}
						break;
					case 3:
						{
						setState(197);
						match(SPACE);
						setState(198);
						scope();
						}
						break;
					case 4:
						{
						setState(199);
						match(SPACE);
						setState(200);
						application(0);
						setState(201);
						has();
						}
						break;
					case 5:
						{
						setState(203);
						match(SPACE);
						setState(204);
						application(0);
						setState(205);
						suffix();
						}
						break;
					case 6:
						{
						setState(207);
						match(SPACE);
						setState(208);
						abstraction();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(211); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
	public static class HeadContext extends ParserRuleContext {
		public TerminalNode ROOT() { return getToken(ProgramParser.ROOT, 0); }
		public TerminalNode HOME() { return getToken(ProgramParser.HOME, 0); }
		public TerminalNode STAR() { return getToken(ProgramParser.STAR, 0); }
		public TerminalNode NAME() { return getToken(ProgramParser.NAME, 0); }
		public TerminalNode DOT() { return getToken(ProgramParser.DOT, 0); }
		public DataContext data() {
			return getRuleContext(DataContext.class,0);
		}
		public AbstractionContext abstraction() {
			return getRuleContext(AbstractionContext.class,0);
		}
		public TerminalNode DOTS() { return getToken(ProgramParser.DOTS, 0); }
		public TerminalNode AT() { return getToken(ProgramParser.AT, 0); }
		public TerminalNode RHO() { return getToken(ProgramParser.RHO, 0); }
		public TerminalNode XI() { return getToken(ProgramParser.XI, 0); }
		public TerminalNode SIGMA() { return getToken(ProgramParser.SIGMA, 0); }
		public TerminalNode COPY() { return getToken(ProgramParser.COPY, 0); }
		public HeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_head; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).enterHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).exitHead(this);
		}
	}

	public final HeadContext head() throws RecognitionException {
		HeadContext _localctx = new HeadContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_head);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOTS) {
				{
				setState(213);
				match(DOTS);
				}
			}

			setState(231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(216);
				match(ROOT);
				}
				break;
			case 2:
				{
				setState(217);
				match(HOME);
				}
				break;
			case 3:
				{
				setState(218);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 50356224L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(220);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(219);
					match(DOT);
					}
					break;
				}
				}
				break;
			case 4:
				{
				setState(222);
				match(STAR);
				}
				break;
			case 5:
				{
				setState(223);
				match(NAME);
				setState(225);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(224);
					match(COPY);
					}
					break;
				}
				}
				break;
			case 6:
				{
				setState(227);
				match(NAME);
				setState(228);
				match(DOT);
				}
				break;
			case 7:
				{
				setState(229);
				data();
				}
				break;
			case 8:
				{
				setState(230);
				abstraction();
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
	public static class HasContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(ProgramParser.COLON, 0); }
		public TerminalNode NAME() { return getToken(ProgramParser.NAME, 0); }
		public TerminalNode RHO() { return getToken(ProgramParser.RHO, 0); }
		public HasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_has; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).enterHas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).exitHas(this);
		}
	}

	public final HasContext has() throws RecognitionException {
		HasContext _localctx = new HasContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_has);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(COLON);
			setState(234);
			_la = _input.LA(1);
			if ( !(_la==RHO || _la==NAME) ) {
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
		public TerminalNode BYTES() { return getToken(ProgramParser.BYTES, 0); }
		public TerminalNode BOOL() { return getToken(ProgramParser.BOOL, 0); }
		public TerminalNode TEXT() { return getToken(ProgramParser.TEXT, 0); }
		public TerminalNode STRING() { return getToken(ProgramParser.STRING, 0); }
		public TerminalNode INT() { return getToken(ProgramParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(ProgramParser.FLOAT, 0); }
		public TerminalNode HEX() { return getToken(ProgramParser.HEX, 0); }
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).enterData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProgramListener ) ((ProgramListener)listener).exitData(this);
		}
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 51271172096L) != 0)) ) {
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
		case 13:
			return application_sempred((ApplicationContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean application_sempred(ApplicationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001%\u00ef\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0003\u0000"+
		"&\b\u0000\u0001\u0000\u0003\u0000)\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0004\u00010\b\u0001\u000b\u0001\f\u0001"+
		"1\u0001\u0002\u0001\u0002\u0004\u00026\b\u0002\u000b\u0002\f\u00027\u0001"+
		"\u0003\u0001\u0003\u0005\u0003<\b\u0003\n\u0003\f\u0003?\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0004\u0003D\b\u0003\u000b\u0003\f\u0003"+
		"E\u0001\u0004\u0001\u0004\u0003\u0004J\b\u0004\u0001\u0004\u0003\u0004"+
		"M\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004R\b\u0004\u0001"+
		"\u0004\u0003\u0004U\b\u0004\u0001\u0004\u0003\u0004X\b\u0004\u0005\u0004"+
		"Z\b\u0004\n\u0004\f\u0004]\t\u0004\u0001\u0005\u0001\u0005\u0005\u0005"+
		"a\b\u0005\n\u0005\f\u0005d\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005k\b\u0005\u0001\u0005\u0003\u0005"+
		"n\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"t\b\u0006\n\u0006\f\u0006w\t\u0006\u0003\u0006y\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0003\b\u0082\b"+
		"\b\u0003\b\u0084\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u008b"+
		"\b\t\u000b\t\f\t\u008c\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0003\n\u0096\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u009b\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r"+
		"\u0003\r\u00a4\b\r\u0001\r\u0001\r\u0003\r\u00a8\b\r\u0003\r\u00aa\b\r"+
		"\u0001\r\u0001\r\u0001\r\u0003\r\u00af\b\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u00b4\b\r\u0001\r\u0001\r\u0001\r\u0003\r\u00b9\b\r\u0005\r\u00bb\b"+
		"\r\n\r\f\r\u00be\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0004\u000e\u00d2\b\u000e\u000b\u000e\f\u000e\u00d3"+
		"\u0001\u000f\u0003\u000f\u00d7\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u00dd\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u00e2\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u00e8\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0000\u0001\u001a\u0012\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"\u0000"+
		"\u0005\u0002\u0000\u0011\u0011\"\"\u0003\u0000\f\r\u0018\u0019\"\"\u0002"+
		"\u0000\r\u000e\u0018\u0019\u0002\u0000\u0019\u0019\"\"\u0002\u0000\u001c"+
		"!##\u010c\u0000%\u0001\u0000\u0000\u0000\u0002/\u0001\u0000\u0000\u0000"+
		"\u00045\u0001\u0000\u0000\u0000\u0006C\u0001\u0000\u0000\u0000\bI\u0001"+
		"\u0000\u0000\u0000\nb\u0001\u0000\u0000\u0000\fo\u0001\u0000\u0000\u0000"+
		"\u000e|\u0001\u0000\u0000\u0000\u0010\u0083\u0001\u0000\u0000\u0000\u0012"+
		"\u0085\u0001\u0000\u0000\u0000\u0014\u0090\u0001\u0000\u0000\u0000\u0016"+
		"\u0097\u0001\u0000\u0000\u0000\u0018\u009c\u0001\u0000\u0000\u0000\u001a"+
		"\u00a9\u0001\u0000\u0000\u0000\u001c\u00d1\u0001\u0000\u0000\u0000\u001e"+
		"\u00d6\u0001\u0000\u0000\u0000 \u00e9\u0001\u0000\u0000\u0000\"\u00ec"+
		"\u0001\u0000\u0000\u0000$&\u0003\u0002\u0001\u0000%$\u0001\u0000\u0000"+
		"\u0000%&\u0001\u0000\u0000\u0000&(\u0001\u0000\u0000\u0000\')\u0003\u0004"+
		"\u0002\u0000(\'\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)*\u0001"+
		"\u0000\u0000\u0000*+\u0003\u0006\u0003\u0000+,\u0005\u0000\u0000\u0001"+
		",\u0001\u0001\u0000\u0000\u0000-.\u0005\u0001\u0000\u0000.0\u0005\u001b"+
		"\u0000\u0000/-\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u00001/\u0001"+
		"\u0000\u0000\u000012\u0001\u0000\u0000\u00002\u0003\u0001\u0000\u0000"+
		"\u000034\u0005\u0002\u0000\u000046\u0005\u001b\u0000\u000053\u0001\u0000"+
		"\u0000\u000067\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000078\u0001"+
		"\u0000\u0000\u00008\u0005\u0001\u0000\u0000\u00009:\u0005\u0001\u0000"+
		"\u0000:<\u0005\u001b\u0000\u0000;9\u0001\u0000\u0000\u0000<?\u0001\u0000"+
		"\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>@\u0001"+
		"\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000@A\u0003\b\u0004\u0000AB\u0005"+
		"\u001b\u0000\u0000BD\u0001\u0000\u0000\u0000C=\u0001\u0000\u0000\u0000"+
		"DE\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000"+
		"\u0000F\u0007\u0001\u0000\u0000\u0000GJ\u0003\n\u0005\u0000HJ\u0003\u001a"+
		"\r\u0000IG\u0001\u0000\u0000\u0000IH\u0001\u0000\u0000\u0000JL\u0001\u0000"+
		"\u0000\u0000KM\u0003\u0012\t\u0000LK\u0001\u0000\u0000\u0000LM\u0001\u0000"+
		"\u0000\u0000M[\u0001\u0000\u0000\u0000NO\u0005\u001b\u0000\u0000OQ\u0003"+
		"\u0016\u000b\u0000PR\u0003\u001c\u000e\u0000QP\u0001\u0000\u0000\u0000"+
		"QR\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SU\u0003\u0014\n\u0000"+
		"TS\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000"+
		"\u0000VX\u0003\u0012\t\u0000WV\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000"+
		"\u0000XZ\u0001\u0000\u0000\u0000YN\u0001\u0000\u0000\u0000Z]\u0001\u0000"+
		"\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\\t"+
		"\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^_\u0005\u0001\u0000"+
		"\u0000_a\u0005\u001b\u0000\u0000`^\u0001\u0000\u0000\u0000ad\u0001\u0000"+
		"\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000ce\u0001"+
		"\u0000\u0000\u0000db\u0001\u0000\u0000\u0000em\u0003\f\u0006\u0000fj\u0003"+
		"\u0014\n\u0000gh\u0005\u0012\u0000\u0000hi\u0005\b\u0000\u0000ik\u0007"+
		"\u0000\u0000\u0000jg\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000"+
		"kn\u0001\u0000\u0000\u0000ln\u0003\u001c\u000e\u0000mf\u0001\u0000\u0000"+
		"\u0000ml\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000n\u000b\u0001"+
		"\u0000\u0000\u0000ox\u0005\u0014\u0000\u0000pu\u0003\u000e\u0007\u0000"+
		"qr\u0005\u0012\u0000\u0000rt\u0003\u000e\u0007\u0000sq\u0001\u0000\u0000"+
		"\u0000tw\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000"+
		"\u0000\u0000vy\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000xp\u0001"+
		"\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000"+
		"z{\u0005\u0015\u0000\u0000{\r\u0001\u0000\u0000\u0000|}\u0003\u0010\b"+
		"\u0000}\u000f\u0001\u0000\u0000\u0000~\u0084\u0005\u0018\u0000\u0000\u007f"+
		"\u0081\u0005\"\u0000\u0000\u0080\u0082\u0005\u0006\u0000\u0000\u0081\u0080"+
		"\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0084"+
		"\u0001\u0000\u0000\u0000\u0083~\u0001\u0000\u0000\u0000\u0083\u007f\u0001"+
		"\u0000\u0000\u0000\u0084\u0011\u0001\u0000\u0000\u0000\u0085\u0086\u0005"+
		"\u001b\u0000\u0000\u0086\u008a\u0005$\u0000\u0000\u0087\u0088\u0003\b"+
		"\u0004\u0000\u0088\u0089\u0005\u001b\u0000\u0000\u0089\u008b\u0001\u0000"+
		"\u0000\u0000\u008a\u0087\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000"+
		"\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u008f\u0005%\u0000"+
		"\u0000\u008f\u0013\u0001\u0000\u0000\u0000\u0090\u0091\u0005\u0012\u0000"+
		"\u0000\u0091\u0092\u0005\u000b\u0000\u0000\u0092\u0093\u0005\u0012\u0000"+
		"\u0000\u0093\u0095\u0003\u0010\b\u0000\u0094\u0096\u0005\u0007\u0000\u0000"+
		"\u0095\u0094\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000"+
		"\u0096\u0015\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u0013\u0000\u0000"+
		"\u0098\u009a\u0007\u0001\u0000\u0000\u0099\u009b\u0005\n\u0000\u0000\u009a"+
		"\u0099\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b"+
		"\u0017\u0001\u0000\u0000\u0000\u009c\u009d\u0005\u0016\u0000\u0000\u009d"+
		"\u009e\u0003\u001a\r\u0000\u009e\u009f\u0005\u0017\u0000\u0000\u009f\u0019"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a1\u0006\r\uffff\uffff\u0000\u00a1\u00a3"+
		"\u0003\u001e\u000f\u0000\u00a2\u00a4\u0003\u001c\u000e\u0000\u00a3\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00aa"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a7\u0003\u0018\f\u0000\u00a6\u00a8\u0003"+
		"\u001c\u000e\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a9\u00a5\u0001\u0000\u0000\u0000\u00aa\u00bc\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ac\n\u0004\u0000\u0000\u00ac\u00ae\u0003\u0016"+
		"\u000b\u0000\u00ad\u00af\u0003\u001c\u000e\u0000\u00ae\u00ad\u0001\u0000"+
		"\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00bb\u0001\u0000"+
		"\u0000\u0000\u00b0\u00b1\n\u0002\u0000\u0000\u00b1\u00b3\u0003 \u0010"+
		"\u0000\u00b2\u00b4\u0003\u001c\u000e\u0000\u00b3\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u00bb\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b6\n\u0001\u0000\u0000\u00b6\u00b8\u0003\u0014\n\u0000"+
		"\u00b7\u00b9\u0003\u001c\u000e\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00bb\u0001\u0000\u0000\u0000"+
		"\u00ba\u00ab\u0001\u0000\u0000\u0000\u00ba\u00b0\u0001\u0000\u0000\u0000"+
		"\u00ba\u00b5\u0001\u0000\u0000\u0000\u00bb\u00be\u0001\u0000\u0000\u0000"+
		"\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000"+
		"\u00bd\u001b\u0001\u0000\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000"+
		"\u00bf\u00c0\u0005\u0012\u0000\u0000\u00c0\u00c1\u0003\u001a\r\u0000\u00c1"+
		"\u00c2\u0003\u0016\u000b\u0000\u00c2\u00d2\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c4\u0005\u0012\u0000\u0000\u00c4\u00d2\u0003\u001e\u000f\u0000\u00c5"+
		"\u00c6\u0005\u0012\u0000\u0000\u00c6\u00d2\u0003\u0018\f\u0000\u00c7\u00c8"+
		"\u0005\u0012\u0000\u0000\u00c8\u00c9\u0003\u001a\r\u0000\u00c9\u00ca\u0003"+
		" \u0010\u0000\u00ca\u00d2\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005\u0012"+
		"\u0000\u0000\u00cc\u00cd\u0003\u001a\r\u0000\u00cd\u00ce\u0003\u0014\n"+
		"\u0000\u00ce\u00d2\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005\u0012\u0000"+
		"\u0000\u00d0\u00d2\u0003\n\u0005\u0000\u00d1\u00bf\u0001\u0000\u0000\u0000"+
		"\u00d1\u00c3\u0001\u0000\u0000\u0000\u00d1\u00c5\u0001\u0000\u0000\u0000"+
		"\u00d1\u00c7\u0001\u0000\u0000\u0000\u00d1\u00cb\u0001\u0000\u0000\u0000"+
		"\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000"+
		"\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000"+
		"\u00d4\u001d\u0001\u0000\u0000\u0000\u00d5\u00d7\u0005\u0006\u0000\u0000"+
		"\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000"+
		"\u00d7\u00e7\u0001\u0000\u0000\u0000\u00d8\u00e8\u0005\u0003\u0000\u0000"+
		"\u00d9\u00e8\u0005\u0004\u0000\u0000\u00da\u00dc\u0007\u0002\u0000\u0000"+
		"\u00db\u00dd\u0005\u0013\u0000\u0000\u00dc\u00db\u0001\u0000\u0000\u0000"+
		"\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u00e8\u0001\u0000\u0000\u0000"+
		"\u00de\u00e8\u0005\u0005\u0000\u0000\u00df\u00e1\u0005\"\u0000\u0000\u00e0"+
		"\u00e2\u0005\n\u0000\u0000\u00e1\u00e0\u0001\u0000\u0000\u0000\u00e1\u00e2"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e8\u0001\u0000\u0000\u0000\u00e3\u00e4"+
		"\u0005\"\u0000\u0000\u00e4\u00e8\u0005\u0013\u0000\u0000\u00e5\u00e8\u0003"+
		"\"\u0011\u0000\u00e6\u00e8\u0003\n\u0005\u0000\u00e7\u00d8\u0001\u0000"+
		"\u0000\u0000\u00e7\u00d9\u0001\u0000\u0000\u0000\u00e7\u00da\u0001\u0000"+
		"\u0000\u0000\u00e7\u00de\u0001\u0000\u0000\u0000\u00e7\u00df\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e3\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e6\u0001\u0000\u0000\u0000\u00e8\u001f\u0001\u0000"+
		"\u0000\u0000\u00e9\u00ea\u0005\t\u0000\u0000\u00ea\u00eb\u0007\u0003\u0000"+
		"\u0000\u00eb!\u0001\u0000\u0000\u0000\u00ec\u00ed\u0007\u0004\u0000\u0000"+
		"\u00ed#\u0001\u0000\u0000\u0000$%(17=EILQTW[bjmux\u0081\u0083\u008c\u0095"+
		"\u009a\u00a3\u00a7\u00a9\u00ae\u00b3\u00b8\u00ba\u00bc\u00d1\u00d3\u00d6"+
		"\u00dc\u00e1\u00e7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}