// Generated from Lox.g4 by ANTLR 4.8
package net.ziyoung.lox.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LoxLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, INT=11, FLOAT=12, DOUBLE=13, LONG=14, STRING=15, PACKAGE=16, 
		IMPORT=17, CLASS=18, STATIC=19, INTERFACE=20, FUN=21, OBJECT=22, VAL=23, 
		VAR=24, CONSTRUCTOR=25, THIS=26, SUPER=27, IF=28, ELSE=29, MATCH=30, TRY=31, 
		CATCH=32, FINALLY=33, THROW=34, FOR=35, WHILE=36, RETURN=37, CONTINUE=38, 
		BREAK=39, Less=40, LessEqual=41, Greater=42, GreaterEqual=43, Equal=44, 
		Exclamation=45, NotEqual=46, Plus=47, Minus=48, Star=49, Div=50, Mod=51, 
		Assign=52, INT_LITERAL=53, DOUBLE_LITERAL=54, BOOL_LITERAL=55, NULL_LITERAL=56, 
		STRING_LITERAL=57, CLASS_ID=58, ID=59, WS=60, SINGLE_LINE_COMMENT=61, 
		MULTI_LINE_COMMENT=62;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "INT", "FLOAT", "DOUBLE", "LONG", "STRING", "PACKAGE", "IMPORT", 
			"CLASS", "STATIC", "INTERFACE", "FUN", "OBJECT", "VAL", "VAR", "CONSTRUCTOR", 
			"THIS", "SUPER", "IF", "ELSE", "MATCH", "TRY", "CATCH", "FINALLY", "THROW", 
			"FOR", "WHILE", "RETURN", "CONTINUE", "BREAK", "Less", "LessEqual", "Greater", 
			"GreaterEqual", "Equal", "Exclamation", "NotEqual", "Plus", "Minus", 
			"Star", "Div", "Mod", "Assign", "INT_LITERAL", "INTEGER", "DOUBLE_LITERAL", 
			"BOOL_LITERAL", "NULL_LITERAL", "STRING_LITERAL", "CLASS_ID", "ID", "LETTER", 
			"ESC", "UNICODE", "HEX", "WS", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'{'", "'}'", "':'", "'('", "')'", "','", "'.'", "'||'", 
			"'&&'", "'int'", "'float'", "'double'", "'long'", "'string'", "'package'", 
			"'import'", "'class'", "'static'", "'interface'", "'fun'", "'object'", 
			"'val'", "'var'", "'constructor'", "'this'", "'super'", "'if'", "'else'", 
			"'match'", "'try'", "'catch'", "'finally'", "'throw'", "'for'", "'while'", 
			"'return'", "'continue'", "'break'", "'<'", "'<='", "'>'", "'>='", "'=='", 
			"'!'", "'!='", "'+'", "'-'", "'*'", "'/'", "'%'", "'='", null, null, 
			null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "INT", 
			"FLOAT", "DOUBLE", "LONG", "STRING", "PACKAGE", "IMPORT", "CLASS", "STATIC", 
			"INTERFACE", "FUN", "OBJECT", "VAL", "VAR", "CONSTRUCTOR", "THIS", "SUPER", 
			"IF", "ELSE", "MATCH", "TRY", "CATCH", "FINALLY", "THROW", "FOR", "WHILE", 
			"RETURN", "CONTINUE", "BREAK", "Less", "LessEqual", "Greater", "GreaterEqual", 
			"Equal", "Exclamation", "NotEqual", "Plus", "Minus", "Star", "Div", "Mod", 
			"Assign", "INT_LITERAL", "DOUBLE_LITERAL", "BOOL_LITERAL", "NULL_LITERAL", 
			"STRING_LITERAL", "CLASS_ID", "ID", "WS", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT"
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


	public LoxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lox.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2@\u01df\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\3\2\3\2\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3"+
		"!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3%\3%"+
		"\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3(\3(\3(\3(\3(\3(\3)\3)\3*\3*\3*\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\3/\3/"+
		"\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\5"+
		"\66\u0172\n\66\3\66\3\66\3\67\3\67\3\67\7\67\u0179\n\67\f\67\16\67\u017c"+
		"\13\67\5\67\u017e\n\67\38\38\38\68\u0183\n8\r8\168\u0184\39\39\39\39\3"+
		"9\39\39\39\39\59\u0190\n9\3:\3:\3:\3:\3:\3;\3;\3;\7;\u019a\n;\f;\16;\u019d"+
		"\13;\3;\3;\3<\3<\3<\7<\u01a4\n<\f<\16<\u01a7\13<\3=\3=\3=\7=\u01ac\n="+
		"\f=\16=\u01af\13=\3>\3>\3?\3?\3?\5?\u01b6\n?\3@\3@\3@\3@\3@\3@\3A\3A\3"+
		"B\6B\u01c1\nB\rB\16B\u01c2\3B\3B\3C\3C\3C\3C\7C\u01cb\nC\fC\16C\u01ce"+
		"\13C\3C\3C\3D\3D\3D\3D\7D\u01d6\nD\fD\16D\u01d9\13D\3D\3D\3D\3D\3D\3\u01d7"+
		"\2E\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m\2o8q9s:u;w<y={\2}\2\177\2\u0081\2\u0083>\u0085?\u0087@\3\2\13\3\2\63"+
		";\3\2\62;\4\2$$^^\3\2C\\\4\2C\\c|\n\2$$\61\61^^ddhhppttvv\5\2\62;CHch"+
		"\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u01e8\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2"+
		"\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u"+
		"\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087"+
		"\3\2\2\2\3\u0089\3\2\2\2\5\u008b\3\2\2\2\7\u008d\3\2\2\2\t\u008f\3\2\2"+
		"\2\13\u0091\3\2\2\2\r\u0093\3\2\2\2\17\u0095\3\2\2\2\21\u0097\3\2\2\2"+
		"\23\u0099\3\2\2\2\25\u009c\3\2\2\2\27\u009f\3\2\2\2\31\u00a3\3\2\2\2\33"+
		"\u00a9\3\2\2\2\35\u00b0\3\2\2\2\37\u00b5\3\2\2\2!\u00bc\3\2\2\2#\u00c4"+
		"\3\2\2\2%\u00cb\3\2\2\2\'\u00d1\3\2\2\2)\u00d8\3\2\2\2+\u00e2\3\2\2\2"+
		"-\u00e6\3\2\2\2/\u00ed\3\2\2\2\61\u00f1\3\2\2\2\63\u00f5\3\2\2\2\65\u0101"+
		"\3\2\2\2\67\u0106\3\2\2\29\u010c\3\2\2\2;\u010f\3\2\2\2=\u0114\3\2\2\2"+
		"?\u011a\3\2\2\2A\u011e\3\2\2\2C\u0124\3\2\2\2E\u012c\3\2\2\2G\u0132\3"+
		"\2\2\2I\u0136\3\2\2\2K\u013c\3\2\2\2M\u0143\3\2\2\2O\u014c\3\2\2\2Q\u0152"+
		"\3\2\2\2S\u0154\3\2\2\2U\u0157\3\2\2\2W\u0159\3\2\2\2Y\u015c\3\2\2\2["+
		"\u015f\3\2\2\2]\u0161\3\2\2\2_\u0164\3\2\2\2a\u0166\3\2\2\2c\u0168\3\2"+
		"\2\2e\u016a\3\2\2\2g\u016c\3\2\2\2i\u016e\3\2\2\2k\u0171\3\2\2\2m\u017d"+
		"\3\2\2\2o\u017f\3\2\2\2q\u018f\3\2\2\2s\u0191\3\2\2\2u\u0196\3\2\2\2w"+
		"\u01a0\3\2\2\2y\u01a8\3\2\2\2{\u01b0\3\2\2\2}\u01b2\3\2\2\2\177\u01b7"+
		"\3\2\2\2\u0081\u01bd\3\2\2\2\u0083\u01c0\3\2\2\2\u0085\u01c6\3\2\2\2\u0087"+
		"\u01d1\3\2\2\2\u0089\u008a\7=\2\2\u008a\4\3\2\2\2\u008b\u008c\7}\2\2\u008c"+
		"\6\3\2\2\2\u008d\u008e\7\177\2\2\u008e\b\3\2\2\2\u008f\u0090\7<\2\2\u0090"+
		"\n\3\2\2\2\u0091\u0092\7*\2\2\u0092\f\3\2\2\2\u0093\u0094\7+\2\2\u0094"+
		"\16\3\2\2\2\u0095\u0096\7.\2\2\u0096\20\3\2\2\2\u0097\u0098\7\60\2\2\u0098"+
		"\22\3\2\2\2\u0099\u009a\7~\2\2\u009a\u009b\7~\2\2\u009b\24\3\2\2\2\u009c"+
		"\u009d\7(\2\2\u009d\u009e\7(\2\2\u009e\26\3\2\2\2\u009f\u00a0\7k\2\2\u00a0"+
		"\u00a1\7p\2\2\u00a1\u00a2\7v\2\2\u00a2\30\3\2\2\2\u00a3\u00a4\7h\2\2\u00a4"+
		"\u00a5\7n\2\2\u00a5\u00a6\7q\2\2\u00a6\u00a7\7c\2\2\u00a7\u00a8\7v\2\2"+
		"\u00a8\32\3\2\2\2\u00a9\u00aa\7f\2\2\u00aa\u00ab\7q\2\2\u00ab\u00ac\7"+
		"w\2\2\u00ac\u00ad\7d\2\2\u00ad\u00ae\7n\2\2\u00ae\u00af\7g\2\2\u00af\34"+
		"\3\2\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3\7p\2\2\u00b3"+
		"\u00b4\7i\2\2\u00b4\36\3\2\2\2\u00b5\u00b6\7u\2\2\u00b6\u00b7\7v\2\2\u00b7"+
		"\u00b8\7t\2\2\u00b8\u00b9\7k\2\2\u00b9\u00ba\7p\2\2\u00ba\u00bb\7i\2\2"+
		"\u00bb \3\2\2\2\u00bc\u00bd\7r\2\2\u00bd\u00be\7c\2\2\u00be\u00bf\7e\2"+
		"\2\u00bf\u00c0\7m\2\2\u00c0\u00c1\7c\2\2\u00c1\u00c2\7i\2\2\u00c2\u00c3"+
		"\7g\2\2\u00c3\"\3\2\2\2\u00c4\u00c5\7k\2\2\u00c5\u00c6\7o\2\2\u00c6\u00c7"+
		"\7r\2\2\u00c7\u00c8\7q\2\2\u00c8\u00c9\7t\2\2\u00c9\u00ca\7v\2\2\u00ca"+
		"$\3\2\2\2\u00cb\u00cc\7e\2\2\u00cc\u00cd\7n\2\2\u00cd\u00ce\7c\2\2\u00ce"+
		"\u00cf\7u\2\2\u00cf\u00d0\7u\2\2\u00d0&\3\2\2\2\u00d1\u00d2\7u\2\2\u00d2"+
		"\u00d3\7v\2\2\u00d3\u00d4\7c\2\2\u00d4\u00d5\7v\2\2\u00d5\u00d6\7k\2\2"+
		"\u00d6\u00d7\7e\2\2\u00d7(\3\2\2\2\u00d8\u00d9\7k\2\2\u00d9\u00da\7p\2"+
		"\2\u00da\u00db\7v\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7t\2\2\u00dd\u00de"+
		"\7h\2\2\u00de\u00df\7c\2\2\u00df\u00e0\7e\2\2\u00e0\u00e1\7g\2\2\u00e1"+
		"*\3\2\2\2\u00e2\u00e3\7h\2\2\u00e3\u00e4\7w\2\2\u00e4\u00e5\7p\2\2\u00e5"+
		",\3\2\2\2\u00e6\u00e7\7q\2\2\u00e7\u00e8\7d\2\2\u00e8\u00e9\7l\2\2\u00e9"+
		"\u00ea\7g\2\2\u00ea\u00eb\7e\2\2\u00eb\u00ec\7v\2\2\u00ec.\3\2\2\2\u00ed"+
		"\u00ee\7x\2\2\u00ee\u00ef\7c\2\2\u00ef\u00f0\7n\2\2\u00f0\60\3\2\2\2\u00f1"+
		"\u00f2\7x\2\2\u00f2\u00f3\7c\2\2\u00f3\u00f4\7t\2\2\u00f4\62\3\2\2\2\u00f5"+
		"\u00f6\7e\2\2\u00f6\u00f7\7q\2\2\u00f7\u00f8\7p\2\2\u00f8\u00f9\7u\2\2"+
		"\u00f9\u00fa\7v\2\2\u00fa\u00fb\7t\2\2\u00fb\u00fc\7w\2\2\u00fc\u00fd"+
		"\7e\2\2\u00fd\u00fe\7v\2\2\u00fe\u00ff\7q\2\2\u00ff\u0100\7t\2\2\u0100"+
		"\64\3\2\2\2\u0101\u0102\7v\2\2\u0102\u0103\7j\2\2\u0103\u0104\7k\2\2\u0104"+
		"\u0105\7u\2\2\u0105\66\3\2\2\2\u0106\u0107\7u\2\2\u0107\u0108\7w\2\2\u0108"+
		"\u0109\7r\2\2\u0109\u010a\7g\2\2\u010a\u010b\7t\2\2\u010b8\3\2\2\2\u010c"+
		"\u010d\7k\2\2\u010d\u010e\7h\2\2\u010e:\3\2\2\2\u010f\u0110\7g\2\2\u0110"+
		"\u0111\7n\2\2\u0111\u0112\7u\2\2\u0112\u0113\7g\2\2\u0113<\3\2\2\2\u0114"+
		"\u0115\7o\2\2\u0115\u0116\7c\2\2\u0116\u0117\7v\2\2\u0117\u0118\7e\2\2"+
		"\u0118\u0119\7j\2\2\u0119>\3\2\2\2\u011a\u011b\7v\2\2\u011b\u011c\7t\2"+
		"\2\u011c\u011d\7{\2\2\u011d@\3\2\2\2\u011e\u011f\7e\2\2\u011f\u0120\7"+
		"c\2\2\u0120\u0121\7v\2\2\u0121\u0122\7e\2\2\u0122\u0123\7j\2\2\u0123B"+
		"\3\2\2\2\u0124\u0125\7h\2\2\u0125\u0126\7k\2\2\u0126\u0127\7p\2\2\u0127"+
		"\u0128\7c\2\2\u0128\u0129\7n\2\2\u0129\u012a\7n\2\2\u012a\u012b\7{\2\2"+
		"\u012bD\3\2\2\2\u012c\u012d\7v\2\2\u012d\u012e\7j\2\2\u012e\u012f\7t\2"+
		"\2\u012f\u0130\7q\2\2\u0130\u0131\7y\2\2\u0131F\3\2\2\2\u0132\u0133\7"+
		"h\2\2\u0133\u0134\7q\2\2\u0134\u0135\7t\2\2\u0135H\3\2\2\2\u0136\u0137"+
		"\7y\2\2\u0137\u0138\7j\2\2\u0138\u0139\7k\2\2\u0139\u013a\7n\2\2\u013a"+
		"\u013b\7g\2\2\u013bJ\3\2\2\2\u013c\u013d\7t\2\2\u013d\u013e\7g\2\2\u013e"+
		"\u013f\7v\2\2\u013f\u0140\7w\2\2\u0140\u0141\7t\2\2\u0141\u0142\7p\2\2"+
		"\u0142L\3\2\2\2\u0143\u0144\7e\2\2\u0144\u0145\7q\2\2\u0145\u0146\7p\2"+
		"\2\u0146\u0147\7v\2\2\u0147\u0148\7k\2\2\u0148\u0149\7p\2\2\u0149\u014a"+
		"\7w\2\2\u014a\u014b\7g\2\2\u014bN\3\2\2\2\u014c\u014d\7d\2\2\u014d\u014e"+
		"\7t\2\2\u014e\u014f\7g\2\2\u014f\u0150\7c\2\2\u0150\u0151\7m\2\2\u0151"+
		"P\3\2\2\2\u0152\u0153\7>\2\2\u0153R\3\2\2\2\u0154\u0155\7>\2\2\u0155\u0156"+
		"\7?\2\2\u0156T\3\2\2\2\u0157\u0158\7@\2\2\u0158V\3\2\2\2\u0159\u015a\7"+
		"@\2\2\u015a\u015b\7?\2\2\u015bX\3\2\2\2\u015c\u015d\7?\2\2\u015d\u015e"+
		"\7?\2\2\u015eZ\3\2\2\2\u015f\u0160\7#\2\2\u0160\\\3\2\2\2\u0161\u0162"+
		"\7#\2\2\u0162\u0163\7?\2\2\u0163^\3\2\2\2\u0164\u0165\7-\2\2\u0165`\3"+
		"\2\2\2\u0166\u0167\7/\2\2\u0167b\3\2\2\2\u0168\u0169\7,\2\2\u0169d\3\2"+
		"\2\2\u016a\u016b\7\61\2\2\u016bf\3\2\2\2\u016c\u016d\7\'\2\2\u016dh\3"+
		"\2\2\2\u016e\u016f\7?\2\2\u016fj\3\2\2\2\u0170\u0172\7/\2\2\u0171\u0170"+
		"\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0174\5m\67\2\u0174"+
		"l\3\2\2\2\u0175\u017e\7\62\2\2\u0176\u017a\t\2\2\2\u0177\u0179\t\3\2\2"+
		"\u0178\u0177\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b"+
		"\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u0175\3\2\2\2\u017d"+
		"\u0176\3\2\2\2\u017en\3\2\2\2\u017f\u0180\5k\66\2\u0180\u0182\7\60\2\2"+
		"\u0181\u0183\t\3\2\2\u0182\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0182"+
		"\3\2\2\2\u0184\u0185\3\2\2\2\u0185p\3\2\2\2\u0186\u0187\7v\2\2\u0187\u0188"+
		"\7t\2\2\u0188\u0189\7w\2\2\u0189\u0190\7g\2\2\u018a\u018b\7h\2\2\u018b"+
		"\u018c\7c\2\2\u018c\u018d\7n\2\2\u018d\u018e\7u\2\2\u018e\u0190\7g\2\2"+
		"\u018f\u0186\3\2\2\2\u018f\u018a\3\2\2\2\u0190r\3\2\2\2\u0191\u0192\7"+
		"p\2\2\u0192\u0193\7w\2\2\u0193\u0194\7n\2\2\u0194\u0195\7n\2\2\u0195t"+
		"\3\2\2\2\u0196\u019b\7$\2\2\u0197\u019a\5}?\2\u0198\u019a\n\4\2\2\u0199"+
		"\u0197\3\2\2\2\u0199\u0198\3\2\2\2\u019a\u019d\3\2\2\2\u019b\u0199\3\2"+
		"\2\2\u019b\u019c\3\2\2\2\u019c\u019e\3\2\2\2\u019d\u019b\3\2\2\2\u019e"+
		"\u019f\7$\2\2\u019fv\3\2\2\2\u01a0\u01a5\t\5\2\2\u01a1\u01a4\5{>\2\u01a2"+
		"\u01a4\t\3\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a2\3\2\2\2\u01a4\u01a7\3\2"+
		"\2\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6x\3\2\2\2\u01a7\u01a5"+
		"\3\2\2\2\u01a8\u01ad\5{>\2\u01a9\u01ac\5{>\2\u01aa\u01ac\t\3\2\2\u01ab"+
		"\u01a9\3\2\2\2\u01ab\u01aa\3\2\2\2\u01ac\u01af\3\2\2\2\u01ad\u01ab\3\2"+
		"\2\2\u01ad\u01ae\3\2\2\2\u01aez\3\2\2\2\u01af\u01ad\3\2\2\2\u01b0\u01b1"+
		"\t\6\2\2\u01b1|\3\2\2\2\u01b2\u01b5\7^\2\2\u01b3\u01b6\t\7\2\2\u01b4\u01b6"+
		"\5\177@\2\u01b5\u01b3\3\2\2\2\u01b5\u01b4\3\2\2\2\u01b6~\3\2\2\2\u01b7"+
		"\u01b8\7w\2\2\u01b8\u01b9\5\u0081A\2\u01b9\u01ba\5\u0081A\2\u01ba\u01bb"+
		"\5\u0081A\2\u01bb\u01bc\5\u0081A\2\u01bc\u0080\3\2\2\2\u01bd\u01be\t\b"+
		"\2\2\u01be\u0082\3\2\2\2\u01bf\u01c1\t\t\2\2\u01c0\u01bf\3\2\2\2\u01c1"+
		"\u01c2\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c4\3\2"+
		"\2\2\u01c4\u01c5\bB\2\2\u01c5\u0084\3\2\2\2\u01c6\u01c7\7\61\2\2\u01c7"+
		"\u01c8\7\61\2\2\u01c8\u01cc\3\2\2\2\u01c9\u01cb\n\n\2\2\u01ca\u01c9\3"+
		"\2\2\2\u01cb\u01ce\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd"+
		"\u01cf\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01d0\bC\2\2\u01d0\u0086\3\2"+
		"\2\2\u01d1\u01d2\7\61\2\2\u01d2\u01d3\7,\2\2\u01d3\u01d7\3\2\2\2\u01d4"+
		"\u01d6\13\2\2\2\u01d5\u01d4\3\2\2\2\u01d6\u01d9\3\2\2\2\u01d7\u01d8\3"+
		"\2\2\2\u01d7\u01d5\3\2\2\2\u01d8\u01da\3\2\2\2\u01d9\u01d7\3\2\2\2\u01da"+
		"\u01db\7,\2\2\u01db\u01dc\7\61\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\bD"+
		"\2\2\u01de\u0088\3\2\2\2\22\2\u0171\u017a\u017d\u0184\u018f\u0199\u019b"+
		"\u01a3\u01a5\u01ab\u01ad\u01b5\u01c2\u01cc\u01d7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}