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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, INT=24, FLOAT=25, 
		DOUBLE=26, LONG=27, STRING=28, PACKAGE=29, IMPORT=30, CLASS=31, STATIC=32, 
		INTERFACE=33, FUN=34, OBJECT=35, VAL=36, VAR=37, CONSTRUCTOR=38, THIS=39, 
		SUPER=40, IF=41, ELSE=42, MATCH=43, TRY=44, CATCH=45, FINALLY=46, THROW=47, 
		FOR=48, WHILE=49, RETURN=50, CONTINUE=51, BREAK=52, INT_LITERAL=53, DOUBLE_LITERAL=54, 
		BOOL_LITERAL=55, NULL_LITERAL=56, STRING_LITERAL=57, CLASS_ID=58, ID=59, 
		WS=60, SINGLE_LINE_COMMENT=61, MULTI_LINE_COMMENT=62;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "INT", "FLOAT", 
			"DOUBLE", "LONG", "STRING", "PACKAGE", "IMPORT", "CLASS", "STATIC", "INTERFACE", 
			"FUN", "OBJECT", "VAL", "VAR", "CONSTRUCTOR", "THIS", "SUPER", "IF", 
			"ELSE", "MATCH", "TRY", "CATCH", "FINALLY", "THROW", "FOR", "WHILE", 
			"RETURN", "CONTINUE", "BREAK", "INT_LITERAL", "INTEGER", "DOUBLE_LITERAL", 
			"BOOL_LITERAL", "NULL_LITERAL", "STRING_LITERAL", "CLASS_ID", "ID", "LETTER", 
			"ESC", "UNICODE", "HEX", "WS", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'{'", "'}'", "':'", "'='", "'('", "')'", "','", "'.'", 
			"'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'>'", "'<'", "'>='", "'<='", 
			"'=='", "'!='", "'||'", "'&&'", "'int'", "'float'", "'double'", "'long'", 
			"'string'", "'package'", "'import'", "'class'", "'static'", "'interface'", 
			"'fun'", "'object'", "'val'", "'var'", "'constructor'", "'this'", "'super'", 
			"'if'", "'else'", "'match'", "'try'", "'catch'", "'finally'", "'throw'", 
			"'for'", "'while'", "'return'", "'continue'", "'break'", null, null, 
			null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"INT", "FLOAT", "DOUBLE", "LONG", "STRING", "PACKAGE", "IMPORT", "CLASS", 
			"STATIC", "INTERFACE", "FUN", "OBJECT", "VAL", "VAR", "CONSTRUCTOR", 
			"THIS", "SUPER", "IF", "ELSE", "MATCH", "TRY", "CATCH", "FINALLY", "THROW", 
			"FOR", "WHILE", "RETURN", "CONTINUE", "BREAK", "INT_LITERAL", "DOUBLE_LITERAL", 
			"BOOL_LITERAL", "NULL_LITERAL", "STRING_LITERAL", "CLASS_ID", "ID", "WS", 
			"SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT"
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
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3&\3"+
		"&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3"+
		"(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\3"+
		"-\3-\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65"+
		"\3\65\3\65\3\65\3\65\3\65\3\66\5\66\u0172\n\66\3\66\3\66\3\67\3\67\3\67"+
		"\7\67\u0179\n\67\f\67\16\67\u017c\13\67\5\67\u017e\n\67\38\38\38\68\u0183"+
		"\n8\r8\168\u0184\39\39\39\39\39\39\39\39\39\59\u0190\n9\3:\3:\3:\3:\3"+
		":\3;\3;\3;\7;\u019a\n;\f;\16;\u019d\13;\3;\3;\3<\3<\3<\7<\u01a4\n<\f<"+
		"\16<\u01a7\13<\3=\3=\3=\7=\u01ac\n=\f=\16=\u01af\13=\3>\3>\3?\3?\3?\5"+
		"?\u01b6\n?\3@\3@\3@\3@\3@\3@\3A\3A\3B\6B\u01c1\nB\rB\16B\u01c2\3B\3B\3"+
		"C\3C\3C\3C\7C\u01cb\nC\fC\16C\u01ce\13C\3C\3C\3D\3D\3D\3D\7D\u01d6\nD"+
		"\fD\16D\u01d9\13D\3D\3D\3D\3D\3D\3\u01d7\2E\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m\2o8q9s:u;w<y={\2}\2\177\2\u0081"+
		"\2\u0083>\u0085?\u0087@\3\2\13\3\2\63;\3\2\62;\4\2$$^^\3\2C\\\4\2C\\c"+
		"|\n\2$$\61\61^^ddhhppttvv\5\2\62;CHch\5\2\13\f\17\17\"\"\4\2\f\f\17\17"+
		"\2\u01e8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2\u0083"+
		"\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\3\u0089\3\2\2\2\5\u008b\3\2\2"+
		"\2\7\u008d\3\2\2\2\t\u008f\3\2\2\2\13\u0091\3\2\2\2\r\u0093\3\2\2\2\17"+
		"\u0095\3\2\2\2\21\u0097\3\2\2\2\23\u0099\3\2\2\2\25\u009b\3\2\2\2\27\u009d"+
		"\3\2\2\2\31\u009f\3\2\2\2\33\u00a1\3\2\2\2\35\u00a3\3\2\2\2\37\u00a5\3"+
		"\2\2\2!\u00a7\3\2\2\2#\u00a9\3\2\2\2%\u00ab\3\2\2\2\'\u00ae\3\2\2\2)\u00b1"+
		"\3\2\2\2+\u00b4\3\2\2\2-\u00b7\3\2\2\2/\u00ba\3\2\2\2\61\u00bd\3\2\2\2"+
		"\63\u00c1\3\2\2\2\65\u00c7\3\2\2\2\67\u00ce\3\2\2\29\u00d3\3\2\2\2;\u00da"+
		"\3\2\2\2=\u00e2\3\2\2\2?\u00e9\3\2\2\2A\u00ef\3\2\2\2C\u00f6\3\2\2\2E"+
		"\u0100\3\2\2\2G\u0104\3\2\2\2I\u010b\3\2\2\2K\u010f\3\2\2\2M\u0113\3\2"+
		"\2\2O\u011f\3\2\2\2Q\u0124\3\2\2\2S\u012a\3\2\2\2U\u012d\3\2\2\2W\u0132"+
		"\3\2\2\2Y\u0138\3\2\2\2[\u013c\3\2\2\2]\u0142\3\2\2\2_\u014a\3\2\2\2a"+
		"\u0150\3\2\2\2c\u0154\3\2\2\2e\u015a\3\2\2\2g\u0161\3\2\2\2i\u016a\3\2"+
		"\2\2k\u0171\3\2\2\2m\u017d\3\2\2\2o\u017f\3\2\2\2q\u018f\3\2\2\2s\u0191"+
		"\3\2\2\2u\u0196\3\2\2\2w\u01a0\3\2\2\2y\u01a8\3\2\2\2{\u01b0\3\2\2\2}"+
		"\u01b2\3\2\2\2\177\u01b7\3\2\2\2\u0081\u01bd\3\2\2\2\u0083\u01c0\3\2\2"+
		"\2\u0085\u01c6\3\2\2\2\u0087\u01d1\3\2\2\2\u0089\u008a\7=\2\2\u008a\4"+
		"\3\2\2\2\u008b\u008c\7}\2\2\u008c\6\3\2\2\2\u008d\u008e\7\177\2\2\u008e"+
		"\b\3\2\2\2\u008f\u0090\7<\2\2\u0090\n\3\2\2\2\u0091\u0092\7?\2\2\u0092"+
		"\f\3\2\2\2\u0093\u0094\7*\2\2\u0094\16\3\2\2\2\u0095\u0096\7+\2\2\u0096"+
		"\20\3\2\2\2\u0097\u0098\7.\2\2\u0098\22\3\2\2\2\u0099\u009a\7\60\2\2\u009a"+
		"\24\3\2\2\2\u009b\u009c\7/\2\2\u009c\26\3\2\2\2\u009d\u009e\7#\2\2\u009e"+
		"\30\3\2\2\2\u009f\u00a0\7,\2\2\u00a0\32\3\2\2\2\u00a1\u00a2\7\61\2\2\u00a2"+
		"\34\3\2\2\2\u00a3\u00a4\7\'\2\2\u00a4\36\3\2\2\2\u00a5\u00a6\7-\2\2\u00a6"+
		" \3\2\2\2\u00a7\u00a8\7@\2\2\u00a8\"\3\2\2\2\u00a9\u00aa\7>\2\2\u00aa"+
		"$\3\2\2\2\u00ab\u00ac\7@\2\2\u00ac\u00ad\7?\2\2\u00ad&\3\2\2\2\u00ae\u00af"+
		"\7>\2\2\u00af\u00b0\7?\2\2\u00b0(\3\2\2\2\u00b1\u00b2\7?\2\2\u00b2\u00b3"+
		"\7?\2\2\u00b3*\3\2\2\2\u00b4\u00b5\7#\2\2\u00b5\u00b6\7?\2\2\u00b6,\3"+
		"\2\2\2\u00b7\u00b8\7~\2\2\u00b8\u00b9\7~\2\2\u00b9.\3\2\2\2\u00ba\u00bb"+
		"\7(\2\2\u00bb\u00bc\7(\2\2\u00bc\60\3\2\2\2\u00bd\u00be\7k\2\2\u00be\u00bf"+
		"\7p\2\2\u00bf\u00c0\7v\2\2\u00c0\62\3\2\2\2\u00c1\u00c2\7h\2\2\u00c2\u00c3"+
		"\7n\2\2\u00c3\u00c4\7q\2\2\u00c4\u00c5\7c\2\2\u00c5\u00c6\7v\2\2\u00c6"+
		"\64\3\2\2\2\u00c7\u00c8\7f\2\2\u00c8\u00c9\7q\2\2\u00c9\u00ca\7w\2\2\u00ca"+
		"\u00cb\7d\2\2\u00cb\u00cc\7n\2\2\u00cc\u00cd\7g\2\2\u00cd\66\3\2\2\2\u00ce"+
		"\u00cf\7n\2\2\u00cf\u00d0\7q\2\2\u00d0\u00d1\7p\2\2\u00d1\u00d2\7i\2\2"+
		"\u00d28\3\2\2\2\u00d3\u00d4\7u\2\2\u00d4\u00d5\7v\2\2\u00d5\u00d6\7t\2"+
		"\2\u00d6\u00d7\7k\2\2\u00d7\u00d8\7p\2\2\u00d8\u00d9\7i\2\2\u00d9:\3\2"+
		"\2\2\u00da\u00db\7r\2\2\u00db\u00dc\7c\2\2\u00dc\u00dd\7e\2\2\u00dd\u00de"+
		"\7m\2\2\u00de\u00df\7c\2\2\u00df\u00e0\7i\2\2\u00e0\u00e1\7g\2\2\u00e1"+
		"<\3\2\2\2\u00e2\u00e3\7k\2\2\u00e3\u00e4\7o\2\2\u00e4\u00e5\7r\2\2\u00e5"+
		"\u00e6\7q\2\2\u00e6\u00e7\7t\2\2\u00e7\u00e8\7v\2\2\u00e8>\3\2\2\2\u00e9"+
		"\u00ea\7e\2\2\u00ea\u00eb\7n\2\2\u00eb\u00ec\7c\2\2\u00ec\u00ed\7u\2\2"+
		"\u00ed\u00ee\7u\2\2\u00ee@\3\2\2\2\u00ef\u00f0\7u\2\2\u00f0\u00f1\7v\2"+
		"\2\u00f1\u00f2\7c\2\2\u00f2\u00f3\7v\2\2\u00f3\u00f4\7k\2\2\u00f4\u00f5"+
		"\7e\2\2\u00f5B\3\2\2\2\u00f6\u00f7\7k\2\2\u00f7\u00f8\7p\2\2\u00f8\u00f9"+
		"\7v\2\2\u00f9\u00fa\7g\2\2\u00fa\u00fb\7t\2\2\u00fb\u00fc\7h\2\2\u00fc"+
		"\u00fd\7c\2\2\u00fd\u00fe\7e\2\2\u00fe\u00ff\7g\2\2\u00ffD\3\2\2\2\u0100"+
		"\u0101\7h\2\2\u0101\u0102\7w\2\2\u0102\u0103\7p\2\2\u0103F\3\2\2\2\u0104"+
		"\u0105\7q\2\2\u0105\u0106\7d\2\2\u0106\u0107\7l\2\2\u0107\u0108\7g\2\2"+
		"\u0108\u0109\7e\2\2\u0109\u010a\7v\2\2\u010aH\3\2\2\2\u010b\u010c\7x\2"+
		"\2\u010c\u010d\7c\2\2\u010d\u010e\7n\2\2\u010eJ\3\2\2\2\u010f\u0110\7"+
		"x\2\2\u0110\u0111\7c\2\2\u0111\u0112\7t\2\2\u0112L\3\2\2\2\u0113\u0114"+
		"\7e\2\2\u0114\u0115\7q\2\2\u0115\u0116\7p\2\2\u0116\u0117\7u\2\2\u0117"+
		"\u0118\7v\2\2\u0118\u0119\7t\2\2\u0119\u011a\7w\2\2\u011a\u011b\7e\2\2"+
		"\u011b\u011c\7v\2\2\u011c\u011d\7q\2\2\u011d\u011e\7t\2\2\u011eN\3\2\2"+
		"\2\u011f\u0120\7v\2\2\u0120\u0121\7j\2\2\u0121\u0122\7k\2\2\u0122\u0123"+
		"\7u\2\2\u0123P\3\2\2\2\u0124\u0125\7u\2\2\u0125\u0126\7w\2\2\u0126\u0127"+
		"\7r\2\2\u0127\u0128\7g\2\2\u0128\u0129\7t\2\2\u0129R\3\2\2\2\u012a\u012b"+
		"\7k\2\2\u012b\u012c\7h\2\2\u012cT\3\2\2\2\u012d\u012e\7g\2\2\u012e\u012f"+
		"\7n\2\2\u012f\u0130\7u\2\2\u0130\u0131\7g\2\2\u0131V\3\2\2\2\u0132\u0133"+
		"\7o\2\2\u0133\u0134\7c\2\2\u0134\u0135\7v\2\2\u0135\u0136\7e\2\2\u0136"+
		"\u0137\7j\2\2\u0137X\3\2\2\2\u0138\u0139\7v\2\2\u0139\u013a\7t\2\2\u013a"+
		"\u013b\7{\2\2\u013bZ\3\2\2\2\u013c\u013d\7e\2\2\u013d\u013e\7c\2\2\u013e"+
		"\u013f\7v\2\2\u013f\u0140\7e\2\2\u0140\u0141\7j\2\2\u0141\\\3\2\2\2\u0142"+
		"\u0143\7h\2\2\u0143\u0144\7k\2\2\u0144\u0145\7p\2\2\u0145\u0146\7c\2\2"+
		"\u0146\u0147\7n\2\2\u0147\u0148\7n\2\2\u0148\u0149\7{\2\2\u0149^\3\2\2"+
		"\2\u014a\u014b\7v\2\2\u014b\u014c\7j\2\2\u014c\u014d\7t\2\2\u014d\u014e"+
		"\7q\2\2\u014e\u014f\7y\2\2\u014f`\3\2\2\2\u0150\u0151\7h\2\2\u0151\u0152"+
		"\7q\2\2\u0152\u0153\7t\2\2\u0153b\3\2\2\2\u0154\u0155\7y\2\2\u0155\u0156"+
		"\7j\2\2\u0156\u0157\7k\2\2\u0157\u0158\7n\2\2\u0158\u0159\7g\2\2\u0159"+
		"d\3\2\2\2\u015a\u015b\7t\2\2\u015b\u015c\7g\2\2\u015c\u015d\7v\2\2\u015d"+
		"\u015e\7w\2\2\u015e\u015f\7t\2\2\u015f\u0160\7p\2\2\u0160f\3\2\2\2\u0161"+
		"\u0162\7e\2\2\u0162\u0163\7q\2\2\u0163\u0164\7p\2\2\u0164\u0165\7v\2\2"+
		"\u0165\u0166\7k\2\2\u0166\u0167\7p\2\2\u0167\u0168\7w\2\2\u0168\u0169"+
		"\7g\2\2\u0169h\3\2\2\2\u016a\u016b\7d\2\2\u016b\u016c\7t\2\2\u016c\u016d"+
		"\7g\2\2\u016d\u016e\7c\2\2\u016e\u016f\7m\2\2\u016fj\3\2\2\2\u0170\u0172"+
		"\7/\2\2\u0171\u0170\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0173\3\2\2\2\u0173"+
		"\u0174\5m\67\2\u0174l\3\2\2\2\u0175\u017e\7\62\2\2\u0176\u017a\t\2\2\2"+
		"\u0177\u0179\t\3\2\2\u0178\u0177\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178"+
		"\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017a\3\2\2\2\u017d"+
		"\u0175\3\2\2\2\u017d\u0176\3\2\2\2\u017en\3\2\2\2\u017f\u0180\5k\66\2"+
		"\u0180\u0182\7\60\2\2\u0181\u0183\t\3\2\2\u0182\u0181\3\2\2\2\u0183\u0184"+
		"\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185p\3\2\2\2\u0186"+
		"\u0187\7v\2\2\u0187\u0188\7t\2\2\u0188\u0189\7w\2\2\u0189\u0190\7g\2\2"+
		"\u018a\u018b\7h\2\2\u018b\u018c\7c\2\2\u018c\u018d\7n\2\2\u018d\u018e"+
		"\7u\2\2\u018e\u0190\7g\2\2\u018f\u0186\3\2\2\2\u018f\u018a\3\2\2\2\u0190"+
		"r\3\2\2\2\u0191\u0192\7p\2\2\u0192\u0193\7w\2\2\u0193\u0194\7n\2\2\u0194"+
		"\u0195\7n\2\2\u0195t\3\2\2\2\u0196\u019b\7$\2\2\u0197\u019a\5}?\2\u0198"+
		"\u019a\n\4\2\2\u0199\u0197\3\2\2\2\u0199\u0198\3\2\2\2\u019a\u019d\3\2"+
		"\2\2\u019b\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019e\3\2\2\2\u019d"+
		"\u019b\3\2\2\2\u019e\u019f\7$\2\2\u019fv\3\2\2\2\u01a0\u01a5\t\5\2\2\u01a1"+
		"\u01a4\5{>\2\u01a2\u01a4\t\3\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a2\3\2\2"+
		"\2\u01a4\u01a7\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6x"+
		"\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a8\u01ad\5{>\2\u01a9\u01ac\5{>\2\u01aa"+
		"\u01ac\t\3\2\2\u01ab\u01a9\3\2\2\2\u01ab\u01aa\3\2\2\2\u01ac\u01af\3\2"+
		"\2\2\u01ad\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01aez\3\2\2\2\u01af\u01ad"+
		"\3\2\2\2\u01b0\u01b1\t\6\2\2\u01b1|\3\2\2\2\u01b2\u01b5\7^\2\2\u01b3\u01b6"+
		"\t\7\2\2\u01b4\u01b6\5\177@\2\u01b5\u01b3\3\2\2\2\u01b5\u01b4\3\2\2\2"+
		"\u01b6~\3\2\2\2\u01b7\u01b8\7w\2\2\u01b8\u01b9\5\u0081A\2\u01b9\u01ba"+
		"\5\u0081A\2\u01ba\u01bb\5\u0081A\2\u01bb\u01bc\5\u0081A\2\u01bc\u0080"+
		"\3\2\2\2\u01bd\u01be\t\b\2\2\u01be\u0082\3\2\2\2\u01bf\u01c1\t\t\2\2\u01c0"+
		"\u01bf\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c2\u01c3\3\2"+
		"\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\bB\2\2\u01c5\u0084\3\2\2\2\u01c6"+
		"\u01c7\7\61\2\2\u01c7\u01c8\7\61\2\2\u01c8\u01cc\3\2\2\2\u01c9\u01cb\n"+
		"\n\2\2\u01ca\u01c9\3\2\2\2\u01cb\u01ce\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc"+
		"\u01cd\3\2\2\2\u01cd\u01cf\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01d0\bC"+
		"\2\2\u01d0\u0086\3\2\2\2\u01d1\u01d2\7\61\2\2\u01d2\u01d3\7,\2\2\u01d3"+
		"\u01d7\3\2\2\2\u01d4\u01d6\13\2\2\2\u01d5\u01d4\3\2\2\2\u01d6\u01d9\3"+
		"\2\2\2\u01d7\u01d8\3\2\2\2\u01d7\u01d5\3\2\2\2\u01d8\u01da\3\2\2\2\u01d9"+
		"\u01d7\3\2\2\2\u01da\u01db\7,\2\2\u01db\u01dc\7\61\2\2\u01dc\u01dd\3\2"+
		"\2\2\u01dd\u01de\bD\2\2\u01de\u0088\3\2\2\2\22\2\u0171\u017a\u017d\u0184"+
		"\u018f\u0199\u019b\u01a3\u01a5\u01ab\u01ad\u01b5\u01c2\u01cc\u01d7\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}