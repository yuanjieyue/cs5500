package yuanjieyue.tests;

import org.junit.Test;

import yuanjieyue.ast.*;

import static org.junit.Assert.assertEquals;

public class ASTTest {
	@Test
	public void test1(){
		yuanjieyue.ast.Variable x = new yuanjieyue.ast.Variable("x");
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Operator plus = new Operator("+");
		Expression exp = new InfixExpression(plus, one, two);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = 1 + 2;");
	}

	@Test
	public void test2() {
		yuanjieyue.ast.Variable x = new yuanjieyue.ast.Variable("y");
		Expression one = new NumberExpression(15);
		Expression two = new NumberExpression(22);
		Operator plus = new Operator("-");
		Expression exp = new InfixExpression(plus, one, two);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var y; y = 15 - 22;");
	}
	@Test
	public void test3() {
		yuanjieyue.ast.Variable x = new yuanjieyue.ast.Variable("SIZE");
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(226);
		Operator plus = new Operator("*");
		Expression exp = new InfixExpression(plus, one, two);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var SIZE; SIZE = 1 * 226;");
	}

	@Test
	public void test4() {
		yuanjieyue.ast.Variable x = new yuanjieyue.ast.Variable("z");
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Operator plus = new Operator("/");
		Expression exp = new InfixExpression(plus, one, two);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var z; z = 1 / 2;");
	}

	@Test
	public void test5() {
		yuanjieyue.ast.Variable x = new yuanjieyue.ast.Variable("x");
		Expression one = new StringExpression("Hello");
		Expression two = new StringExpression("World");
		Operator plus = new Operator("+");
		Expression exp = new InfixExpression(plus, one, two);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = Hello + World;");
	}

	@Test
	public void test6() {
		yuanjieyue.ast.Variable x = new yuanjieyue.ast.Variable("x");
		Expression one = new StringExpression("Hello");
		Expression two = new NumberExpression(2);
		Operator plus = new Operator("+");
		Expression exp = new InfixExpression(plus, one, two);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = Hello + 2;");
	}

	@Test
	public void test7() {
		yuanjieyue.ast.Variable x = new yuanjieyue.ast.Variable("x");
		Expression one = new NumberExpression(1);
		Expression two = new StringExpression("World");
		Operator plus = new Operator("+");
		Expression exp = new InfixExpression(plus, one, two);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = 1 + World;");
	}

	@Test
	public void test8() {
		yuanjieyue.ast.Variable x = new yuanjieyue.ast.Variable("x");
		yuanjieyue.ast.Variable y = new yuanjieyue.ast.Variable("y");
		yuanjieyue.ast.Variable z = new yuanjieyue.ast.Variable("z");
		Expression one = new VariableExpression(y);
		Expression two = new VariableExpression(z);
		Operator plus = new Operator("+");
		Expression exp = new InfixExpression(plus, one, two);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = y + z;");
	}

	@Test
	public void test9() {
		yuanjieyue.ast.Variable x = new yuanjieyue.ast.Variable("x");
		yuanjieyue.ast.Variable y = new yuanjieyue.ast.Variable("y");
		yuanjieyue.ast.Variable z = new yuanjieyue.ast.Variable("z");
		Expression one = new VariableExpression(y);
		Expression two = new VariableExpression(z);
		Operator plus = new Operator("+");
		Expression exp = new PrefixExpression(plus, one, two);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = + y z;");
	}

	@Test
	public void test10() {
		yuanjieyue.ast.Variable y = new yuanjieyue.ast.Variable("y");
		yuanjieyue.ast.Variable z = new yuanjieyue.ast.Variable("z");
		Expression one = new VariableExpression(y);
		Expression two = new VariableExpression(z);
		Operator plus = new Operator("+");
		Expression exp1 = new PrefixExpression(plus, one, two);

		Expression num = new NumberExpression(1);
		Expression str = new StringExpression("Hello");
		Operator minus = new Operator("-");
		Expression exp2 = new InfixExpression(minus, num, str);

		yuanjieyue.ast.Variable m = new yuanjieyue.ast.Variable("x");
		Operator multiply = new Operator("*");

		Expression exp3 = new InfixExpression(multiply, exp1, exp2);

		Statement decl = new Declaration(m);
		Statement assign = new Assignment(m, exp3);
		Statement seq = new Sequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = + y z * 1 - Hello;");
	}

	@Test
	public void test11() {
		yuanjieyue.ast.Variable x = new yuanjieyue.ast.Variable("x");
		yuanjieyue.ast.Variable y = new yuanjieyue.ast.Variable("y");
		yuanjieyue.ast.Variable z = new yuanjieyue.ast.Variable("z");
		Expression one = new VariableExpression(x);
		Expression two = new VariableExpression(y);
		Expression three = new VariableExpression(z);
		Operator plus = new Operator("+");
		Expression exp1 = new PrefixExpression(plus, one, two);
		Expression exp2 = new PrefixExpression(plus, exp1, three);

		Expression num = new NumberExpression(1);
		Expression str = new StringExpression("Hello");
		Operator minus = new Operator("-");
		Expression exp3 = new InfixExpression(minus, num, str);

		yuanjieyue.ast.Variable m = new yuanjieyue.ast.Variable("m");
		Operator multiply = new Operator("*");

		Expression exp4 = new InfixExpression(multiply, exp2, exp3);

		Statement decl = new Declaration(m);
		Statement assign = new Assignment(m, exp4);
		Statement seq = new Sequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var m; m = + + x y z * 1 - Hello;");
	}

	@Test
	public void test12() {
		Operator plus = new Operator("+");
		Operator minus = new Operator("-");
		Operator multiply = new Operator("*");

		yuanjieyue.ast.Variable x = new yuanjieyue.ast.Variable("x");
		Expression hello = new StringExpression("Hello");
		Expression world = new StringExpression("World");
		Expression exp1 = new InfixExpression(plus, hello, world);

		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Expression exp2 = new InfixExpression(minus, one, two);

		yuanjieyue.ast.Variable y = new yuanjieyue.ast.Variable("y");
		yuanjieyue.ast.Variable z = new yuanjieyue.ast.Variable("z");

		Expression exp3 = new PrefixExpression(multiply, exp1, exp2);

		Statement decl1 = new Declaration(x);
		Statement decl2 = new Declaration(y);
		Statement decl3 = new Declaration(z);

		Statement assign1 = new Assignment(y, exp1);
		Statement assign2 = new Assignment(z, exp2);
		Statement assign3 = new Assignment(x, exp3);

		Statement seq1 = new Sequence(decl2, decl3);
		Statement seq2 = new Sequence(decl1, seq1);
		Statement seq3 = new Sequence(assign2, assign3);
		Statement seq4= new Sequence(assign1, seq3);

		Statement sta = new Sequence(seq2, seq4);
		assertEquals(sta.textRepresentation(),
			"var x; var y; var z; y = Hello + World; z = 1 - 2; x = * Hello + World 1 - 2;");
	}
}
