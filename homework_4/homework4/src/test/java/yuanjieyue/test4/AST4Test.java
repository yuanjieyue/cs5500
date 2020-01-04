package yuanjieyue.test4;

import org.junit.Before;
import org.junit.Test;

import yuanjieyue.ast4.*;

public class AST4Test {

	private NodeFactory statementFactory = new StatementFactory();

	@Test
	public void test1() {
		Node node1 = statementFactory.createNode("Declaration", Variable.getVariable("x"));
		String report1 = statementFactory.report();
		Node node2 = statementFactory.createNode("Declaration", Variable.getVariable("y"));
		String report2 = statementFactory.report();
		Node node3 = statementFactory.createNode("Declaration", Variable.getVariable("z"));
		String report3 = statementFactory.report();
		Node node4 = statementFactory.createNode("Declaration", Variable.getVariable("x"));
		String report4 = statementFactory.report();
		Node node5 = statementFactory.createNode("Declaration", Variable.getVariable("x"));
		String report5 = statementFactory.report();
		Node node6 = statementFactory.createNode("Declaration", Variable.getVariable("y"));
		String report6 = statementFactory.report();
		Node node7 = statementFactory.createNode("Declaration", Variable.getVariable("x"));
		String report7 = statementFactory.report();
	}
}
