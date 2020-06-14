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
		T__17=18, T__18=19, T__19=20, T__20=21, INT=22, FLOAT=23, DOUBLE=24, LONG=25, 
		STRING=26, PACKAGE=27, IMPORT=28, CLASS=29, INTERFACE=30, FUN=31, OBJECT=32, 
		VAL=33, VAR=34, CONSTRUCTOR=35, THIS=36, SUPER=37, IF=38, ELSE=39, MATCH=40, 
		TRY=41, CATCH=42, FINALLY=43, THROW=44, FOR=45, WHILE=46, RETURN=47, CONTINUE=48, 
		BREAK=49, INT_LITERAL=50, DOUBLE_LITERAL=51, BOOL_LITERAL=52, NULL_LITERAL=53, 
		STRING_LITERAL=54, CLASS_ID=55, ID=56, WS=57, SINGLE_LINE_COMMENT=58, 
		MULTI_LINE_COMMENT=59;
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
			"T__17", "T__18", "T__19", "T__20", "INT", "FLOAT", "DOUBLE", "LONG", 
			"STRING", "PACKAGE", "IMPORT", "CLASS", "INTERFACE", "FUN", "OBJECT", 
			"VAL", "VAR", "CONSTRUCTOR", "THIS", "SUPER", "IF", "ELSE", "MATCH", 
			"TRY", "CATCH", "FINALLY", "THROW", "FOR", "WHILE", "RETURN", "CONTINUE", 
			"BREAK", "INT_LITERAL", "INTEGER", "DOUBLE_LITERAL", "BOOL_LITERAL", 
			"NULL_LITERAL", "STRING_LITERAL", "CLASS_ID", "ID", "LETTER", "ESC", 
			"UNICODE", "HEX", "WS", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "':'", "'='", "';'", "'('", "')'", "','", "'.'", 
			"'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'>'", "'<'", "'>='", "'<='", 
			"'=='", "'!='", "'int'", "'float'", "'double'", "'long'", "'string'", 
			"'package'", "'import'", "'class'", "'interface'", "'fun'", "'object'", 
			"'val'", "'var'", "'constructor'", "'this'", "'super'", "'if'", "'else'", 
			"'match'", "'try'", "'catch'", "'finally'", "'throw'", "'for'", "'while'", 
			"'return'", "'continue'", "'break'", null, null, null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "INT", "FLOAT", 
			"DOUBLE", "LONG", "STRING", "PACKAGE", "IMPORT", "CLASS", "INTERFACE", 
			"FUN", "OBJECT", "VAL", "VAR", "CONSTRUCTOR", "THIS", "SUPER", "IF", 
			"ELSE", "MATCH", "TRY", "CATCH", "FINALLY", "THROW", "FOR", "WHILE", 
			"RETURN", "CONTINUE", "BREAK", "INT_LITERAL", "DOUBLE_LITERAL", "BOOL_LITERAL", 
			"NULL_LITERAL", "STRING_LITERAL", "CLASS_ID", "ID", "WS", "SINGLE_LINE_COMMENT", 
			"MULTI_LINE_COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2=\u01cc\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3"+
		"\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3"+
		"!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3"+
		")\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3-\3"+
		"-\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\63\5\63\u015f\n\63\3\63\3\63\3\64\3\64\3\64\7\64\u0166"+
		"\n\64\f\64\16\64\u0169\13\64\5\64\u016b\n\64\3\65\3\65\3\65\6\65\u0170"+
		"\n\65\r\65\16\65\u0171\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\5"+
		"\66\u017d\n\66\3\67\3\67\3\67\3\67\3\67\38\38\38\78\u0187\n8\f8\168\u018a"+
		"\138\38\38\39\39\39\79\u0191\n9\f9\169\u0194\139\3:\3:\3:\7:\u0199\n:"+
		"\f:\16:\u019c\13:\3;\3;\3<\3<\3<\5<\u01a3\n<\3=\3=\3=\3=\3=\3=\3>\3>\3"+
		"?\6?\u01ae\n?\r?\16?\u01af\3?\3?\3@\3@\3@\3@\7@\u01b8\n@\f@\16@\u01bb"+
		"\13@\3@\3@\3A\3A\3A\3A\7A\u01c3\nA\fA\16A\u01c6\13A\3A\3A\3A\3A\3A\3\u01c4"+
		"\2B\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\2i\65k\66"+
		"m\67o8q9s:u\2w\2y\2{\2};\177<\u0081=\3\2\13\3\2\63;\3\2\62;\4\2$$^^\3"+
		"\2C\\\4\2C\\c|\n\2$$\61\61^^ddhhppttvv\5\2\62;CHch\5\2\13\f\17\17\"\""+
		"\4\2\f\f\17\17\2\u01d5\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2i\3\2\2\2\2k\3\2\2"+
		"\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2}\3\2\2\2\2\177\3\2\2"+
		"\2\2\u0081\3\2\2\2\3\u0083\3\2\2\2\5\u0085\3\2\2\2\7\u0087\3\2\2\2\t\u0089"+
		"\3\2\2\2\13\u008b\3\2\2\2\r\u008d\3\2\2\2\17\u008f\3\2\2\2\21\u0091\3"+
		"\2\2\2\23\u0093\3\2\2\2\25\u0095\3\2\2\2\27\u0097\3\2\2\2\31\u0099\3\2"+
		"\2\2\33\u009b\3\2\2\2\35\u009d\3\2\2\2\37\u009f\3\2\2\2!\u00a1\3\2\2\2"+
		"#\u00a3\3\2\2\2%\u00a5\3\2\2\2\'\u00a8\3\2\2\2)\u00ab\3\2\2\2+\u00ae\3"+
		"\2\2\2-\u00b1\3\2\2\2/\u00b5\3\2\2\2\61\u00bb\3\2\2\2\63\u00c2\3\2\2\2"+
		"\65\u00c7\3\2\2\2\67\u00ce\3\2\2\29\u00d6\3\2\2\2;\u00dd\3\2\2\2=\u00e3"+
		"\3\2\2\2?\u00ed\3\2\2\2A\u00f1\3\2\2\2C\u00f8\3\2\2\2E\u00fc\3\2\2\2G"+
		"\u0100\3\2\2\2I\u010c\3\2\2\2K\u0111\3\2\2\2M\u0117\3\2\2\2O\u011a\3\2"+
		"\2\2Q\u011f\3\2\2\2S\u0125\3\2\2\2U\u0129\3\2\2\2W\u012f\3\2\2\2Y\u0137"+
		"\3\2\2\2[\u013d\3\2\2\2]\u0141\3\2\2\2_\u0147\3\2\2\2a\u014e\3\2\2\2c"+
		"\u0157\3\2\2\2e\u015e\3\2\2\2g\u016a\3\2\2\2i\u016c\3\2\2\2k\u017c\3\2"+
		"\2\2m\u017e\3\2\2\2o\u0183\3\2\2\2q\u018d\3\2\2\2s\u0195\3\2\2\2u\u019d"+
		"\3\2\2\2w\u019f\3\2\2\2y\u01a4\3\2\2\2{\u01aa\3\2\2\2}\u01ad\3\2\2\2\177"+
		"\u01b3\3\2\2\2\u0081\u01be\3\2\2\2\u0083\u0084\7}\2\2\u0084\4\3\2\2\2"+
		"\u0085\u0086\7\177\2\2\u0086\6\3\2\2\2\u0087\u0088\7<\2\2\u0088\b\3\2"+
		"\2\2\u0089\u008a\7?\2\2\u008a\n\3\2\2\2\u008b\u008c\7=\2\2\u008c\f\3\2"+
		"\2\2\u008d\u008e\7*\2\2\u008e\16\3\2\2\2\u008f\u0090\7+\2\2\u0090\20\3"+
		"\2\2\2\u0091\u0092\7.\2\2\u0092\22\3\2\2\2\u0093\u0094\7\60\2\2\u0094"+
		"\24\3\2\2\2\u0095\u0096\7/\2\2\u0096\26\3\2\2\2\u0097\u0098\7#\2\2\u0098"+
		"\30\3\2\2\2\u0099\u009a\7,\2\2\u009a\32\3\2\2\2\u009b\u009c\7\61\2\2\u009c"+
		"\34\3\2\2\2\u009d\u009e\7\'\2\2\u009e\36\3\2\2\2\u009f\u00a0\7-\2\2\u00a0"+
		" \3\2\2\2\u00a1\u00a2\7@\2\2\u00a2\"\3\2\2\2\u00a3\u00a4\7>\2\2\u00a4"+
		"$\3\2\2\2\u00a5\u00a6\7@\2\2\u00a6\u00a7\7?\2\2\u00a7&\3\2\2\2\u00a8\u00a9"+
		"\7>\2\2\u00a9\u00aa\7?\2\2\u00aa(\3\2\2\2\u00ab\u00ac\7?\2\2\u00ac\u00ad"+
		"\7?\2\2\u00ad*\3\2\2\2\u00ae\u00af\7#\2\2\u00af\u00b0\7?\2\2\u00b0,\3"+
		"\2\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b3\7p\2\2\u00b3\u00b4\7v\2\2\u00b4"+
		".\3\2\2\2\u00b5\u00b6\7h\2\2\u00b6\u00b7\7n\2\2\u00b7\u00b8\7q\2\2\u00b8"+
		"\u00b9\7c\2\2\u00b9\u00ba\7v\2\2\u00ba\60\3\2\2\2\u00bb\u00bc\7f\2\2\u00bc"+
		"\u00bd\7q\2\2\u00bd\u00be\7w\2\2\u00be\u00bf\7d\2\2\u00bf\u00c0\7n\2\2"+
		"\u00c0\u00c1\7g\2\2\u00c1\62\3\2\2\2\u00c2\u00c3\7n\2\2\u00c3\u00c4\7"+
		"q\2\2\u00c4\u00c5\7p\2\2\u00c5\u00c6\7i\2\2\u00c6\64\3\2\2\2\u00c7\u00c8"+
		"\7u\2\2\u00c8\u00c9\7v\2\2\u00c9\u00ca\7t\2\2\u00ca\u00cb\7k\2\2\u00cb"+
		"\u00cc\7p\2\2\u00cc\u00cd\7i\2\2\u00cd\66\3\2\2\2\u00ce\u00cf\7r\2\2\u00cf"+
		"\u00d0\7c\2\2\u00d0\u00d1\7e\2\2\u00d1\u00d2\7m\2\2\u00d2\u00d3\7c\2\2"+
		"\u00d3\u00d4\7i\2\2\u00d4\u00d5\7g\2\2\u00d58\3\2\2\2\u00d6\u00d7\7k\2"+
		"\2\u00d7\u00d8\7o\2\2\u00d8\u00d9\7r\2\2\u00d9\u00da\7q\2\2\u00da\u00db"+
		"\7t\2\2\u00db\u00dc\7v\2\2\u00dc:\3\2\2\2\u00dd\u00de\7e\2\2\u00de\u00df"+
		"\7n\2\2\u00df\u00e0\7c\2\2\u00e0\u00e1\7u\2\2\u00e1\u00e2\7u\2\2\u00e2"+
		"<\3\2\2\2\u00e3\u00e4\7k\2\2\u00e4\u00e5\7p\2\2\u00e5\u00e6\7v\2\2\u00e6"+
		"\u00e7\7g\2\2\u00e7\u00e8\7t\2\2\u00e8\u00e9\7h\2\2\u00e9\u00ea\7c\2\2"+
		"\u00ea\u00eb\7e\2\2\u00eb\u00ec\7g\2\2\u00ec>\3\2\2\2\u00ed\u00ee\7h\2"+
		"\2\u00ee\u00ef\7w\2\2\u00ef\u00f0\7p\2\2\u00f0@\3\2\2\2\u00f1\u00f2\7"+
		"q\2\2\u00f2\u00f3\7d\2\2\u00f3\u00f4\7l\2\2\u00f4\u00f5\7g\2\2\u00f5\u00f6"+
		"\7e\2\2\u00f6\u00f7\7v\2\2\u00f7B\3\2\2\2\u00f8\u00f9\7x\2\2\u00f9\u00fa"+
		"\7c\2\2\u00fa\u00fb\7n\2\2\u00fbD\3\2\2\2\u00fc\u00fd\7x\2\2\u00fd\u00fe"+
		"\7c\2\2\u00fe\u00ff\7t\2\2\u00ffF\3\2\2\2\u0100\u0101\7e\2\2\u0101\u0102"+
		"\7q\2\2\u0102\u0103\7p\2\2\u0103\u0104\7u\2\2\u0104\u0105\7v\2\2\u0105"+
		"\u0106\7t\2\2\u0106\u0107\7w\2\2\u0107\u0108\7e\2\2\u0108\u0109\7v\2\2"+
		"\u0109\u010a\7q\2\2\u010a\u010b\7t\2\2\u010bH\3\2\2\2\u010c\u010d\7v\2"+
		"\2\u010d\u010e\7j\2\2\u010e\u010f\7k\2\2\u010f\u0110\7u\2\2\u0110J\3\2"+
		"\2\2\u0111\u0112\7u\2\2\u0112\u0113\7w\2\2\u0113\u0114\7r\2\2\u0114\u0115"+
		"\7g\2\2\u0115\u0116\7t\2\2\u0116L\3\2\2\2\u0117\u0118\7k\2\2\u0118\u0119"+
		"\7h\2\2\u0119N\3\2\2\2\u011a\u011b\7g\2\2\u011b\u011c\7n\2\2\u011c\u011d"+
		"\7u\2\2\u011d\u011e\7g\2\2\u011eP\3\2\2\2\u011f\u0120\7o\2\2\u0120\u0121"+
		"\7c\2\2\u0121\u0122\7v\2\2\u0122\u0123\7e\2\2\u0123\u0124\7j\2\2\u0124"+
		"R\3\2\2\2\u0125\u0126\7v\2\2\u0126\u0127\7t\2\2\u0127\u0128\7{\2\2\u0128"+
		"T\3\2\2\2\u0129\u012a\7e\2\2\u012a\u012b\7c\2\2\u012b\u012c\7v\2\2\u012c"+
		"\u012d\7e\2\2\u012d\u012e\7j\2\2\u012eV\3\2\2\2\u012f\u0130\7h\2\2\u0130"+
		"\u0131\7k\2\2\u0131\u0132\7p\2\2\u0132\u0133\7c\2\2\u0133\u0134\7n\2\2"+
		"\u0134\u0135\7n\2\2\u0135\u0136\7{\2\2\u0136X\3\2\2\2\u0137\u0138\7v\2"+
		"\2\u0138\u0139\7j\2\2\u0139\u013a\7t\2\2\u013a\u013b\7q\2\2\u013b\u013c"+
		"\7y\2\2\u013cZ\3\2\2\2\u013d\u013e\7h\2\2\u013e\u013f\7q\2\2\u013f\u0140"+
		"\7t\2\2\u0140\\\3\2\2\2\u0141\u0142\7y\2\2\u0142\u0143\7j\2\2\u0143\u0144"+
		"\7k\2\2\u0144\u0145\7n\2\2\u0145\u0146\7g\2\2\u0146^\3\2\2\2\u0147\u0148"+
		"\7t\2\2\u0148\u0149\7g\2\2\u0149\u014a\7v\2\2\u014a\u014b\7w\2\2\u014b"+
		"\u014c\7t\2\2\u014c\u014d\7p\2\2\u014d`\3\2\2\2\u014e\u014f\7e\2\2\u014f"+
		"\u0150\7q\2\2\u0150\u0151\7p\2\2\u0151\u0152\7v\2\2\u0152\u0153\7k\2\2"+
		"\u0153\u0154\7p\2\2\u0154\u0155\7w\2\2\u0155\u0156\7g\2\2\u0156b\3\2\2"+
		"\2\u0157\u0158\7d\2\2\u0158\u0159\7t\2\2\u0159\u015a\7g\2\2\u015a\u015b"+
		"\7c\2\2\u015b\u015c\7m\2\2\u015cd\3\2\2\2\u015d\u015f\7/\2\2\u015e\u015d"+
		"\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161\5g\64\2\u0161"+
		"f\3\2\2\2\u0162\u016b\7\62\2\2\u0163\u0167\t\2\2\2\u0164\u0166\t\3\2\2"+
		"\u0165\u0164\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168"+
		"\3\2\2\2\u0168\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u0162\3\2\2\2\u016a"+
		"\u0163\3\2\2\2\u016bh\3\2\2\2\u016c\u016d\5e\63\2\u016d\u016f\7\60\2\2"+
		"\u016e\u0170\t\3\2\2\u016f\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u016f"+
		"\3\2\2\2\u0171\u0172\3\2\2\2\u0172j\3\2\2\2\u0173\u0174\7v\2\2\u0174\u0175"+
		"\7t\2\2\u0175\u0176\7w\2\2\u0176\u017d\7g\2\2\u0177\u0178\7h\2\2\u0178"+
		"\u0179\7c\2\2\u0179\u017a\7n\2\2\u017a\u017b\7u\2\2\u017b\u017d\7g\2\2"+
		"\u017c\u0173\3\2\2\2\u017c\u0177\3\2\2\2\u017dl\3\2\2\2\u017e\u017f\7"+
		"p\2\2\u017f\u0180\7w\2\2\u0180\u0181\7n\2\2\u0181\u0182\7n\2\2\u0182n"+
		"\3\2\2\2\u0183\u0188\7$\2\2\u0184\u0187\5w<\2\u0185\u0187\n\4\2\2\u0186"+
		"\u0184\3\2\2\2\u0186\u0185\3\2\2\2\u0187\u018a\3\2\2\2\u0188\u0186\3\2"+
		"\2\2\u0188\u0189\3\2\2\2\u0189\u018b\3\2\2\2\u018a\u0188\3\2\2\2\u018b"+
		"\u018c\7$\2\2\u018cp\3\2\2\2\u018d\u0192\t\5\2\2\u018e\u0191\5u;\2\u018f"+
		"\u0191\t\3\2\2\u0190\u018e\3\2\2\2\u0190\u018f\3\2\2\2\u0191\u0194\3\2"+
		"\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193r\3\2\2\2\u0194\u0192"+
		"\3\2\2\2\u0195\u019a\5u;\2\u0196\u0199\5u;\2\u0197\u0199\t\3\2\2\u0198"+
		"\u0196\3\2\2\2\u0198\u0197\3\2\2\2\u0199\u019c\3\2\2\2\u019a\u0198\3\2"+
		"\2\2\u019a\u019b\3\2\2\2\u019bt\3\2\2\2\u019c\u019a\3\2\2\2\u019d\u019e"+
		"\t\6\2\2\u019ev\3\2\2\2\u019f\u01a2\7^\2\2\u01a0\u01a3\t\7\2\2\u01a1\u01a3"+
		"\5y=\2\u01a2\u01a0\3\2\2\2\u01a2\u01a1\3\2\2\2\u01a3x\3\2\2\2\u01a4\u01a5"+
		"\7w\2\2\u01a5\u01a6\5{>\2\u01a6\u01a7\5{>\2\u01a7\u01a8\5{>\2\u01a8\u01a9"+
		"\5{>\2\u01a9z\3\2\2\2\u01aa\u01ab\t\b\2\2\u01ab|\3\2\2\2\u01ac\u01ae\t"+
		"\t\2\2\u01ad\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01ad\3\2\2\2\u01af"+
		"\u01b0\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b2\b?\2\2\u01b2~\3\2\2\2\u01b3"+
		"\u01b4\7\61\2\2\u01b4\u01b5\7\61\2\2\u01b5\u01b9\3\2\2\2\u01b6\u01b8\n"+
		"\n\2\2\u01b7\u01b6\3\2\2\2\u01b8\u01bb\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9"+
		"\u01ba\3\2\2\2\u01ba\u01bc\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bc\u01bd\b@"+
		"\2\2\u01bd\u0080\3\2\2\2\u01be\u01bf\7\61\2\2\u01bf\u01c0\7,\2\2\u01c0"+
		"\u01c4\3\2\2\2\u01c1\u01c3\13\2\2\2\u01c2\u01c1\3\2\2\2\u01c3\u01c6\3"+
		"\2\2\2\u01c4\u01c5\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c5\u01c7\3\2\2\2\u01c6"+
		"\u01c4\3\2\2\2\u01c7\u01c8\7,\2\2\u01c8\u01c9\7\61\2\2\u01c9\u01ca\3\2"+
		"\2\2\u01ca\u01cb\bA\2\2\u01cb\u0082\3\2\2\2\22\2\u015e\u0167\u016a\u0171"+
		"\u017c\u0186\u0188\u0190\u0192\u0198\u019a\u01a2\u01af\u01b9\u01c4\3\b"+
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