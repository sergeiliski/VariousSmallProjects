package com.week2.stacksandqueues;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class DijkstraTwoStack {
	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		String s = StdIn.readString();
		while (!s.equals("end")) {
			if (s.equals("(")) {
			}
			else if (s.equals("+") || s.equals("*")) {
				ops.push(s);
			} else if (s.equals(")")) {
				getComp(ops, vals);
			} else {
				vals.push(Double.parseDouble(s));
			}
			s = StdIn.readString();
		}
		getComp(ops, vals);
		StdOut.println(vals.pop());
	}

	private static void getComp(Stack<String> ops, Stack<Double> vals) {
		String op = ops.pop();
		if (op.equals("+")) {
			vals.push(vals.pop() + vals.pop());
		} else if (op.equals("*")) {
			vals.push(vals.pop() * vals.pop());
		}
	}
}
