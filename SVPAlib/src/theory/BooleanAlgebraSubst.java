/**
 * SVPAlib
 * theory
 * Apr 21, 2015
 * @author Loris D'Antoni
 */
package theory;

/**
 * BooleanAlgebraSubst: A Boolean Alegbra with substitution
 * @param <P> The type of predicates forming the Boolean algebra
 * @param <F> The type of functions S->S in the Boolean Algebra 
 * @param <S> The domain of the Boolean algebra
 */
public abstract class BooleanAlgebraSubst<P,F,S> extends BooleanAlgebra<P, S>{

	/**
	 * Replaces every variable x in the unary function <code>f1</code>  
	 * the application to the function <code>f2</code> (f2(x))
	 * @return f1(f2(x))
	 */
	public abstract F MkSubstFuncFunc(F f1, F f2);
	
	/**
	 * Replaces every variable x in the unary function <code>f</code>  
	 * with the constant <code>c</code>
	 * @return f(c) 
	 */
	public abstract S MkSubstFuncConst(F f, S c);
	
	/**
	 * Replaces every variable x in the predicate <code>p</code>  
	 * with the application to the function <code>f</code> (f(x))
	 * @return p(f(x)) 
	 */
	public abstract P MkSubstFuncPred(F f, P p);

	/**
	 * Make a constant function initialized by the constant <code>s</code>
	 * @return lambda x.s
	 */
	public abstract F MkFuncConst(S s);

	/**
	 * Check whether <code>f1</code> and <code>f2</code> are equivalent relative to the predicate <code>p</code>
	 * @return lambda x.(p(x) and f1(x) != f2(x))
	 */
	public abstract boolean CheckGuardedEquality(P p, F f1, F f2);


	/**
	 * get the restricted output based on <code>p</code> and <code>f</code>
	 * @return \psi(y) = \exists x. \phi(x) \wedge f(x)=y
	 */
	public abstract P getRestrictedOutput(P p, F f);
	
}
